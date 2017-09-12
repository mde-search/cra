package solution;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import com.lagodiuk.ga.Population;

import architectureCRA.ClassModel;

public class InitialPopulationProvider {

	// Relative path to the transformations.
	static String TRANSFORMATIONS = "transformations/";

	static Population<ClassModelSolution> createInitialPopulation(ClassModelSolution cms, int populationSize) {

		// use each initialization transformation once to achieve the first ClassModels
		Population<ClassModelSolution> eachSelectedInitiliasationOncePopulation = new Population<ClassModelSolution>();
		Settings settings = cms.getSettings();
		
		// Create a resource set with a base directory:
		HenshinResourceSet henshinResourceSet = new HenshinResourceSet();

		// Load the module:
		Module moduleContainingInitialisationTransformations = henshinResourceSet
				.getModule(TRANSFORMATIONS + "initialTransformation.henshin", false);

		
		
		String CRAsOfInitialSolution = "";
		
		if (settings.getInitializationStrategy() == Settings.InitializationStrategy.ONE_CLASS_PER_FEATURE ||
				settings.getInitializationStrategy() == Settings.InitializationStrategy.MIXED) {
			Unit unit = moduleContainingInitialisationTransformations.getUnit("createClassPerFeature");
			CRAsOfInitialSolution = createAndAddStartingIndividual(cms, eachSelectedInitiliasationOncePopulation,
					CRAsOfInitialSolution, unit);
		}
		if (settings.getInitializationStrategy() == Settings.InitializationStrategy.GODCLASS||
				settings.getInitializationStrategy() == Settings.InitializationStrategy.MIXED) {
			Unit unit = moduleContainingInitialisationTransformations.getUnit("allFeaturesInOneClass");
			CRAsOfInitialSolution = createAndAddStartingIndividual(cms, eachSelectedInitiliasationOncePopulation,
					CRAsOfInitialSolution, unit);
			
		}
			
		
		// 2. Fill up start population until the maximum size is met
		Population<ClassModelSolution> initialPopulation = new Population<ClassModelSolution>();
		for(int i = 0; i<populationSize; i++){
			int sizeOfInitialisationPopulation = eachSelectedInitiliasationOncePopulation.getSize();
			int selectTheNextOfTheInitialisationPopulation = i%sizeOfInitialisationPopulation;
			ClassModelSolution chromosomeByIndex = eachSelectedInitiliasationOncePopulation.getChromosomeByIndex(selectTheNextOfTheInitialisationPopulation);
			System.err.println(eachSelectedInitiliasationOncePopulation.getChromosomeByIndex(selectTheNextOfTheInitialisationPopulation).getClassModel().getClasses().size());
			ClassModelSolution chr = new ClassModelSolution(chromosomeByIndex.getClassModel(), cms.getSettings());
			chr.mutate();
			initialPopulation.addChromosome(chr);
			double calculateCRAIndex = CRAIndexCalculator.calculateCRAIndex(chr.getClassModel());
			CRAIndexCalculator.evaluateModelWithoutCorrectness(chr.getClassModel());
			CRAsOfInitialSolution += (new Double(calculateCRAIndex).toString());
			CRAsOfInitialSolution += " - ";
		}
		System.out.println("CRAs of initial population: " + CRAsOfInitialSolution);
		
		return initialPopulation;
	}

	private static String createAndAddStartingIndividual(ClassModelSolution cms,
			Population<ClassModelSolution> eachSelectedInitiliasationOncePopulation, String CRAsOfInitialSolution,
			Unit unit) {
		ClassModelSolution copyOfCMS = new ClassModelSolution(cms.getClassModel(), cms.getSettings());
		ClassModelSolution newCMS = setUpAnInitialSolution(unit, copyOfCMS);
		eachSelectedInitiliasationOncePopulation.addChromosome(newCMS);
		double calculateCRAIndex = CRAIndexCalculator.calculateCRAIndex(newCMS.getClassModel());
		CRAIndexCalculator.evaluateModelWithoutCorrectness(newCMS.getClassModel());
		CRAsOfInitialSolution += (new Double(calculateCRAIndex).toString());
		CRAsOfInitialSolution += " - ";
		return CRAsOfInitialSolution;
	}
	
	
	private static ClassModelSolution setUpAnInitialSolution(Unit transformationForInitialSolution,
			ClassModelSolution cms) {
		ClassModel classModel = cms.getClassModel();
		// Load the example model into an EGraph:
		EGraph graph = new EGraphImpl(classModel);
		
		// Create an engine and a rule application:
		Engine engine = new EngineImpl();
		UnitApplication app = new UnitApplicationImpl(engine);
		app.setEGraph(graph);
		
		app.setUnit(transformationForInitialSolution);
		
		if (!app.execute(null)) {
			throw new RuntimeException("Error applying 'createClassPerFeature'");
		}

		ClassModelSolution initialClassModelSolution = new ClassModelSolution(classModel, cms.getSettings());
		return initialClassModelSolution;
	}

}
