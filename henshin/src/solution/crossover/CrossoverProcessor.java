package solution.crossover;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import architectureCRA.Class;
import architectureCRA.ClassModel;
import architectureCRA.Feature;
import solution.ClassModelSolution;
import solution.PostProcessor;
import solution.Settings;
import solution.Utility;

public abstract class CrossoverProcessor implements ICrossover {
	
	// Relative path to the transformations.
	static String TRANSFORMATIONS = "transformations/";
	

	ClassModel child;
	
	@Override
	public List<ClassModelSolution> createCrossover(ClassModel rdg, ClassModelSolution cms1, ClassModelSolution cms2) {
		this.child = rdg;
		
		ClassModel cm1Copy = Utility.getClassModelCopy(cms1.getClassModel());
		ClassModel cm2Copy = Utility.getClassModelCopy(cms2.getClassModel());
		ClassModelSolution crossoverSolution = getCrossover(cm1Copy, cm2Copy, cms1.getSettings());
		
		Settings settings = cms1.getSettings();
		//TODO: NPE check in case of settings = NULL
		if(settings.doPostProcess_moveAttributeToReferencingMethod()){
			PostProcessor.postProcess_moveAttributeToReferencingMethod(crossoverSolution.getClassModel());
		}

		List<ClassModelSolution> results = new LinkedList<ClassModelSolution>();
		results.add(crossoverSolution);
		
		return results;
	}
	
	
	private ClassModelSolution getCrossover(ClassModel cm1, ClassModel cm2, Settings settings) {
	
	
		
		while(featuresWithoutClassRemaining(child) && (cm1.getFeatures().size() > 0 || cm2.getFeatures().size() > 0 )){
			
			// TODO: extract to "transferMostValuableClass(...)"
			// choose alternating a class of one of the source ClassModels and adopt the feature allocation in the resulting crossover ClassModel
			Class mostValuableClass = getMostValuableClass(cm1);
			EList<Feature> encapsulatedFeaturesOfMostValuableClass = mostValuableClass.getEncapsulates();
			// create Class in the result ClassModel and allocate the before identified Features
			Class createdClass = Utility.createClass(child, mostValuableClass.getName());
			List<String> featureNames = Utility.extractFeatureNames(encapsulatedFeaturesOfMostValuableClass);
			boolean allFeaturesAssigned = Utility.assignFeaturesToClass(child, createdClass, featureNames);
			// delete Class in the source ClassModel1
			boolean primordialClassdeleted = Utility.deleteClass(cm1, mostValuableClass);
			// delete Features in both source ClassModels
			boolean featuresInCm1Deleted = Utility.deleteFeatures(cm1, featureNames);
			boolean featuresInCm2Deleted = Utility.deleteFeatures(cm2, featureNames);
			//check afterwards the number of remaining Features in cm1 and cm2 to be identical. 
			
		}
			
			//TODO: abschließend prüfen, ob in 'resultModel' features on encapsulation in einer Class sind.
		ClassModelSolution resultCMS = new ClassModelSolution(child, settings);
		return resultCMS;
	}

	protected abstract Class getMostValuableClass(ClassModel cm1);

	private boolean featuresWithoutClassRemaining(ClassModel resultModel) {
		for(Feature feature : resultModel.getFeatures()){
			if(feature.getIsEncapsulatedBy() == null)
				return true;
		}
		return false;
	}


}
