package solution;

import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.interpreter.util.InterpreterUtil;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import architectureCRA.Class;
import architectureCRA.ClassModel;
import architectureCRA.Feature;

public class Mutator {
	
	// Relative path to the transformations.
	static String TRANSFORMATIONS = "transformations/";
	
	private static Engine engine;// = new EngineImpl();
	
	private static Module module;
	
	private static HenshinResourceSet henshinResourceSet;

	private static Unit moveSelectedFeatureUnit;
	private static Unit joinSelectedClassesUnit;
	private static Unit moveOnceReferencedAttrToItsMethodUnit;
	private static Unit randomSplitClassUnit;
	private static Unit moveFeatureUnit;
	
	
	
	
	public static List<Unit> mutate(ClassModelSolution classModelSolution){
		
		ClassModel classModel = classModelSolution.getClassModel();
		
		//Test
		Settings settings = classModelSolution.getSettings();
		
		// Create a Henshin resource set:
		if(henshinResourceSet == null){			
			henshinResourceSet = new HenshinResourceSet();
		}

		// ensure module is loaded!
		getModule();
		
		// ensure units are loaded!
		initializeAllUnits();
		
		EGraph graph = new EGraphImpl(classModel);

		// Create an engine and a rule application:
		if(engine == null){			
			engine = new EngineImpl();
		}

		// selection of applied mutations
		List<Unit> selectedMutations = new LinkedList<Unit>();
		if(settings.isMutateMoveSelectedFeature())
			selectedMutations.add(moveSelectedFeatureUnit);
		if(settings.isMutateJoinSelectedClasses())
			selectedMutations.add(joinSelectedClassesUnit);
		if(settings.isMutateMoveOnceReferencedAttrToItsMethod())
			selectedMutations.add(moveOnceReferencedAttrToItsMethodUnit); // has a tremendous influence
		if(settings.isMutateRandomSplitClass())
			selectedMutations.add(randomSplitClassUnit);	
		
		if(selectedMutations.contains(joinSelectedClassesUnit)){
			int numberOfClasses = classModel.getClasses().size();
			int randomNumberOfClasses = 0 + (int)(Math.random() * (((numberOfClasses-1) - 0) + 1));
//			int numberOfJoinse = (int) Math.sqrt(randomNumberOfClasses);
			for(int i = 0; i<randomNumberOfClasses; i++){
				RuleApplication app = new RuleApplicationImpl(engine);
				app.setEGraph(graph);
				app.setUnit(joinSelectedClassesUnit);
				EList<Class> classes = classModel.getClasses();
				int random1 = 0 + (int)(Math.random() * (((classes.size()-1) - 0) + 1));
				int random2 = 0 + (int)(Math.random() * (((classes.size()-1) - 0) + 1));
				if(random1 == random2){ // try once to prevent the selection of the same class twice.
					if(random2 > 0){
						random2--;
					}
					else if(random2 < (classes.size()-1)){
						random2++;
					}
				}
				Class deletedClass = classes.get(random1);
				app.setParameterValue("deletedClass", deletedClass);
				Class remainingClass = classes.get(random2);
				app.setParameterValue("remainingClass", remainingClass);
				
				boolean execute = app.execute(null);
			}
		}
		

		if(selectedMutations.contains(randomSplitClassUnit)){
			
			// select class to split random
			EList<Class> classes = classModel.getClasses();
			int selectClass = 0 + (int)(Math.random() * (((classes.size()-1) - 0) + 1));
			Class classToSplit = classes.get(selectClass);
			EList<Feature> featuresOfClassToSplit = classToSplit.getEncapsulates();
			List<String> featureNamesOfClassToSplit = Utility.extractFeatureNames(featuresOfClassToSplit);
			
			// select how much new classes shall be created (between 2 and numberOfFeaturesInClassToSplit)
			// since a large number of features shouldnt result in a large number of Classes upper bound should be the sqrt of the number of features
			int numberOfResultingClasses = 2 + (int)(Math.random() * ((int)Math.sqrt(featuresOfClassToSplit.size())));
			
			//create the new classes (slope + collect them in a list)
			List<Class> createdClasses = new LinkedList<Class>();
			for(int i = 0; i<numberOfResultingClasses; i++){
				Class createdClass = Utility.createClass(classModel, Utility.getRandomString());
				createdClasses.add(createdClass);
			}
			
			//randomly distribute the features on the new classes
			for(String featureName : featureNamesOfClassToSplit){
				Unit joinSelectedClassesUnit = moveFeatureUnit;
				RuleApplication app = new RuleApplicationImpl(engine);
				app.setEGraph(graph);
				app.setUnit(joinSelectedClassesUnit);
				app.setParameterValue("movedFeatureName", featureName);
				int selectCreatedClass = 0 + (int)(Math.random() * (((createdClasses.size()-1) - 0) + 1));
				Class selectedCreatedClass = createdClasses.get(selectCreatedClass);
				app.setParameterValue("targetClass", selectedCreatedClass);
				boolean execute = app.execute(null);
			}
			
		}
		if(selectedMutations.contains(moveSelectedFeatureUnit)){
			int numberOfFeatures = classModel.getFeatures().size();
			int numberOfMovedSelectedFeatures = 0 + (int)(Math.random() * numberOfFeatures);
			for(int i = 0;i<numberOfMovedSelectedFeatures;i++){
				RuleApplication app = new RuleApplicationImpl(engine);
				app.setEGraph(graph);
				app.setUnit(moveSelectedFeatureUnit);
				EList<Feature> features = classModel.getFeatures();
				EList<Class> classes = classModel.getClasses();
				// select random feature
				int random1 = 0 + (int)(Math.random() * (((features.size()-1) - 0) + 1));
				Feature movedFeature = features.get(random1);
				//select random Class that is not the one of the feature
				int random2 = 0 + (int)(Math.random() * (((classes.size()-1) - 0) + 1));
				Class targetClass = classes.get(random2);
				Class formerClass = movedFeature.getIsEncapsulatedBy();
				if(formerClass == targetClass){
					if(random2 > 0){
						random2--;
						targetClass = classes.get(random2);
					}
					else if(random2 < (classes.size()-1)){
						random2++;
						targetClass = classes.get(random2);
					}
					// else: only one class remaining!
				}
				app.setParameterValue("movedFeature", movedFeature);
				app.setParameterValue("targetClass", targetClass);
			}
		}
		
		
		if(selectedMutations.contains(moveSelectedFeatureUnit)){
				double random = Math.random();
				if(random<0.1){ //10%
					RuleApplication app = new RuleApplicationImpl(engine);
					app.setEGraph(graph);
					app.setUnit(moveSelectedFeatureUnit);
					app.execute(null);
				}
				random = Math.random();
		}
		
		if(selectedMutations.contains(moveOnceReferencedAttrToItsMethodUnit)){
			List<Match> findAllMatches = InterpreterUtil.findAllMatches(engine, (Rule) moveOnceReferencedAttrToItsMethodUnit, graph, null);
			for(Match match : findAllMatches){
				RuleApplication app = new RuleApplicationImpl(engine);
				app.setEGraph(graph);
				app.setUnit(moveOnceReferencedAttrToItsMethodUnit);
				app.setPartialMatch(match);
				app.execute(null);
			}
		}
		
		if(settings.doPostProcess_moveAttributeToReferencingMethod()){
			graph = PostProcessor.postProcess_moveAttributeToReferencingMethod(classModel);
		}

		CRAIndexCalculator.printGeneralInfo((ClassModel) classModel); //TODO: before cast apply 'instanceof' check!
		CRAIndexCalculator.printOptimalityInfo((ClassModel) classModel); //TODO: before cast apply 'instanceof' check!

		return selectedMutations;
	}


	private static void initializeAllUnits() {
		if(anyUnitIsUninitialized()){			
			moveSelectedFeatureUnit = getModule().getUnit("moveSelectedFeature");
			joinSelectedClassesUnit = getModule().getUnit("joinSelectedClasses");
			moveOnceReferencedAttrToItsMethodUnit = getModule().getUnit("moveOnceReferencedAttrToItsMethod");
			randomSplitClassUnit = getModule().getUnit("randomSplitClass");
			moveFeatureUnit = getModule().getUnit("moveFeature");
		}
	}


	public static Module getModule() {
		// Load the module:
		if(module == null){
			module = henshinResourceSet.getModule(TRANSFORMATIONS+"mutations.henshin", false);
		}
		return module;
	}


	public static Unit getMoveOnceReferencedAttrToItsMethodUnit() {	
		// prevent to return null;
		initializeAllUnits();
		return moveOnceReferencedAttrToItsMethodUnit;
	}


	private static boolean anyUnitIsUninitialized() {
		if(
			moveSelectedFeatureUnit == null 
			|| joinSelectedClassesUnit == null
			|| moveOnceReferencedAttrToItsMethodUnit == null
			|| randomSplitClassUnit == null
			|| moveFeatureUnit == null)
				return true;
		return false;
	}
}
