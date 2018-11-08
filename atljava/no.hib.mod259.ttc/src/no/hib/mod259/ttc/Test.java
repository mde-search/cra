package no.hib.mod259.ttc;

import java.io.IOException;
import java.util.Collections;
import java.util.Random;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

//import at.ac.tuwien.big.momot.examples.modularization.cra.eval.CRAIndexCalculator;
import architectureCRA.*;

public class Test {

	private static final int ITERATIONS = 500;

	final static String IN_METAMODEL = "src/architectureCRA.ecore";
	final static String TRANSFORMATION_DIR = "src/transformations/";

	static final String INPUT_DIR = "src/InputModels/";
	static final String INPUT_MODEL = "b.xmi";

	static final String OUTPUT_DIR = "src/OutputModels/";
	static final String OUTPUT_MODEL = "resultB.xmi";

	static final String TEMP_DIR = "src/TempDir/";
	static final String TEMP_MODEL = "temp.xmi";
	static final String BEST_MODEL = "best.xmi";

	public static void transform(Metamodel metaModel, Model inModel, Model outModel, String transformationDir,
			String transformationModule) {
		
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		env.setJitDisabled(true);

		env.registerMetaModel("architectureCRA", metaModel);
		env.registerInputModel("IN", inModel);
		env.registerOutputModel("OUT", outModel);

		ModuleResolver mr = new DefaultModuleResolver(transformationDir, new ResourceSetImpl());
		TimingData td = new TimingData();
		env.loadModule(mr, transformationModule);
		td.finishLoading();
		env.run(td);
		td.finish();
	}

	public static double evaluate(Model model) {
		return CRAIndexCalculator.calculateCRAIndex((ClassModel) model.getResource().getContents().get(0));
	}

	public static double acceptanceProbability(double currentCRI, double newCRI, double temperature) {
		if (newCRI > currentCRI) {
			return 1.0;
		}
		return Math.exp((newCRI - currentCRI) / temperature);
	}

	public static double calculateCoolingFactor(double tMin, double tMax, int rounds) {
		return Math.pow(tMin / tMax, 1.0 / rounds);
	}

	public static void main(String[] args) {
		CRAIndexCalculator.registerPackage();
		Random r = new Random(1);
		String input = INPUT_DIR + INPUT_MODEL;
		
		//CRAIndexCalculator.evaluateModel(CRAIndexCalculator.loadModel("src/MomotOutputs/theirB.xmi"));
		//CRAIndexCalculator.evaluateModel(CRAIndexCalculator.loadModel("src/OutputModels/resultB.xmi"));

		ResourceSet rs = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("emftvm", new EMFTVMResourceFactoryImpl());

		Metamodel metaModel = EmftvmFactory.eINSTANCE.createMetamodel();
		metaModel.setResource(rs.getResource(URI.createURI("http://momot.big.tuwien.ac.at/architectureCRA/1.0"), true));

		Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(rs.getResource(URI.createURI(input, true), true));

		Model tempModel = EmftvmFactory.eINSTANCE.createModel();
		tempModel.setResource(rs.createResource(URI.createURI(TEMP_DIR+TEMP_MODEL)));

		Model bestModel = EmftvmFactory.eINSTANCE.createModel();
		bestModel.setResource(rs.createResource(URI.createURI(TEMP_DIR+BEST_MODEL)));

		Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(rs.createResource(URI.createURI(OUTPUT_DIR+OUTPUT_MODEL)));

		long before = java.lang.System.nanoTime();

		// Create a class for each feature
		transform(metaModel, inModel, tempModel, TRANSFORMATION_DIR, "Model2Classes");
		// Generate a random solution
		transform(metaModel, tempModel, bestModel, TRANSFORMATION_DIR, "AssignFeatures");
		
		double temperature = 3;
		double endTemperature = 0.01;
		double k = calculateCoolingFactor(endTemperature, temperature, ITERATIONS);
		// Evaluate the generated solution
		double craBest = evaluate(bestModel);

		while (temperature > 0.01) {
			 tempModel = EmftvmFactory.eINSTANCE.createModel();
			 tempModel.setResource(rs.createResource(URI.createURI(TEMP_DIR+TEMP_MODEL)));
			
			// Generate a new solution from the old solution
			transform(metaModel, bestModel, tempModel, TRANSFORMATION_DIR, "ReassignFeatures");
			// Evaluate the new solution
			double craNew = evaluate(tempModel);
			// Compare
			if (acceptanceProbability(craBest, craNew, temperature) > r.nextDouble()) {
				bestModel = tempModel;
				craBest = craNew;
			}
			// Decrease temperature
			temperature *= k;
		}

		// Delete empty classes from the best solution and transfer it to the outModel
		transform(metaModel, bestModel, outModel, TRANSFORMATION_DIR, "DeleteEmptyClasses");

		// Save the best solution
		try {
			outModel.getResource().save(Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}

		long after = java.lang.System.nanoTime();
		System.out.println("The classdiagram has a CRI of: " + evaluate(bestModel));
		System.out.println("It took: " + (after - before) / 1000000 + "ms to generate the classdiagram.");

	}

}
