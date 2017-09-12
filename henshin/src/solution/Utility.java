package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import architectureCRA.Attribute;
import architectureCRA.Class;
import architectureCRA.ClassModel;
import architectureCRA.Feature;
import architectureCRA.Method;

public class Utility {
	
	// Relative path to the transformations.
	static String TRANSFORMATIONS = "transformations/";
	
	private static Engine engine;
	private static Module module;
	private static Unit nameFixUnit;
	private static Unit deleteFeatureUnit;
	private static Unit createClassUnit;
	private static Unit assignFeaturesToClassUnit;
	private static Unit deleteClassUnit;
	private static Unit deleteEmptyClassesUnit;

	private static HenshinResourceSet henshinResourceSet;
	
	public static Engine getEngine() {
		if (engine == null)
			engine = new EngineImpl();
		return engine;
	}
	
	public static Module getModule() {
		if (module == null) {
			module = getHenshinResourceSet().getModule(TRANSFORMATIONS+"utility.henshin", false);	
		}
		return module;
	}

	public static HenshinResourceSet getHenshinResourceSet() {
		if (henshinResourceSet==null)
			henshinResourceSet = new HenshinResourceSet();
		return henshinResourceSet;
	}
	
	private static Unit getNameFixUnit() {
		if (nameFixUnit == null) {	
			nameFixUnit = getModule().getUnit("nameFix");
		}
		return nameFixUnit;
	}
	
	private static Unit getDeleteFeatureUnit() {
		if (deleteFeatureUnit == null) {
			deleteFeatureUnit = getModule().getUnit("deleteFeature");
		}
		return deleteFeatureUnit;
	}

	private static Unit getCreateClassUnit() {
		if (createClassUnit == null) { 
			createClassUnit = getModule().getUnit("createClass");
		}
		return createClassUnit;
	}

	private static Unit getAssignFeaturesToClassUnit() {
		if (assignFeaturesToClassUnit == null) {
			assignFeaturesToClassUnit = getModule().getUnit("assignFeature");
		}
		return assignFeaturesToClassUnit;
	}

	private static Unit getDeleteClassUnit() {
		if (deleteClassUnit == null) {
			deleteClassUnit = getModule().getUnit("deleteClass");
		}
		return deleteClassUnit;
	}
	
	private static Unit getDeleteEmptyClassesUnit() {
		if (deleteEmptyClassesUnit == null) {
			deleteEmptyClassesUnit = getModule().getUnit("deleteEmptyClasses");
		}
		return deleteEmptyClassesUnit;
	}

	public static double calculateCohesion(Class clazz) {
		// code stems of CRAIndexCalculator ...(...)
		double cohesionRatioOfClass = 0.0;
		if(getMethodsOfClass(clazz).size()==0){
			cohesionRatioOfClass +=0.0;
		} else if (getMethodsOfClass(clazz).size()==1){ //Here, the second part of the addition is still 0
			if (getAttributesOfClass(clazz).size()==0){ //and now, also the first part is 0
				cohesionRatioOfClass += 0.0;
			} else { //now, the first part is not 0
				cohesionRatioOfClass += mai(clazz,clazz)/(double)(getMethodsOfClass(clazz).size()*getAttributesOfClass(clazz).size());
			}
		} else { //Here, we have more than one method in the clazz
			if (getAttributesOfClass(clazz).size()==0){ //Now, the first part of the addition will be 0
				cohesionRatioOfClass += mmi(clazz,clazz)/(double)(getMethodsOfClass(clazz).size()*(getMethodsOfClass(clazz).size()-1));
			} else { //Here, we have more than 0 attributes and more than 1 method, so we use the whole formula
				cohesionRatioOfClass += mai(clazz,clazz)/(double)(getMethodsOfClass(clazz).size()*getAttributesOfClass(clazz).size()) +
						mmi(clazz,clazz)/(double)(getMethodsOfClass(clazz).size()*(getMethodsOfClass(clazz).size()-1));
			}
		}
		return cohesionRatioOfClass;
	}
	

	// code stems of CRAIndexCalculator
	public static double calculateCoupling(Class classSource, ClassModel model) {
		double couplingRatio = 0;
		for(Class classTarget : model.getClasses()) {
			if (classSource != classTarget){
				if (getMethodsOfClass(classSource).size()==0){
					couplingRatio += 0.0;
				} else { //From here, |M(clsi)|>0
					if (getMethodsOfClass(classTarget).size()<=1){ //The second part of the addition is 0
						if (getAttributesOfClass(classTarget).size()==0){ //Now, also the first part of the addition is 0
							couplingRatio += 0.0;
						} else { //Now, the first part of the addition is not 0
							couplingRatio += mai(classSource,classTarget)/(double)(getMethodsOfClass(classSource).size()*getAttributesOfClass(classTarget).size());
						}
					} else{ //Now, the second part of the addition is not 0
						if (getAttributesOfClass(classTarget).size()==0){
							couplingRatio += mmi(classSource,classTarget)/(double)(getMethodsOfClass(classSource).size()*(getMethodsOfClass(classTarget).size()-1));
						} else { //Now, non of the parts is 0
							couplingRatio += (mai(classSource,classTarget)/(double)(getMethodsOfClass(classSource).size()*getAttributesOfClass(classTarget).size()))+
								 	(mmi(classSource,classTarget)/(double)(getMethodsOfClass(classSource).size()*(getMethodsOfClass(classTarget).size()-1)));
						}
					}
				}
			}
		}
		return couplingRatio;
	}

	// code stems of CRAIndexCalculator
	static List<Attribute> getAttributesOfClass(Class clazz){
		List<Attribute> attributes = new ArrayList<Attribute>();		
		for (Feature feature : clazz.getEncapsulates()) {
			if(feature instanceof Attribute)
				attributes.add((Attribute) feature);
		}					
		return attributes;
	}

	// code stems of CRAIndexCalculator
	static List<Method> getMethodsOfClass(Class clazz) {
		List<Method> methods = new ArrayList<Method>();		
		for (Feature feature : clazz.getEncapsulates()) {
			if (feature instanceof Method)
				methods.add((Method) feature);
		}					
		return methods;
	}

	// code stems of CRAIndexCalculator
	static int mai(Class classSource, Class classTarget){
		int mai = 0;
		for (Method method : getMethodsOfClass(classSource)) {
			for (Attribute attribute : getAttributesOfClass(classTarget)) {
				if (method.getDataDependency().contains(attribute))
					mai++;
			}
		}		
		return mai;
	}

	// code stems of CRAIndexCalculator
	static int mmi(Class classSource, Class classTarget){
		int mmi = 0;
		for (Method methodSource : getMethodsOfClass(classSource)){
			for (Method methodTarget : getMethodsOfClass(classTarget)){
				if (methodSource.getFunctionalDependency().contains(methodTarget))
					mmi++;
			}
		}		
		return mmi;
	}

	public static boolean deleteFeatures(ClassModel cm, List<String> featureNames) {
		boolean success = true;
		for(String featureName : featureNames){
			EGraph egraph = new EGraphImpl(cm);
			
			UnitApplication app = new UnitApplicationImpl(getEngine());
			app.setEGraph(egraph);
			app.setUnit(getDeleteFeatureUnit());
			app.setParameterValue("featureName", featureName);
			
			if(!app.execute(null))
				success = false;
		}
		return success;
	}

	public static ClassModel getClassModelCopy(ClassModel cm) {
		//copy of ClassModel
		EcoreUtil.Copier copier = new EcoreUtil.Copier() {
			// private static final long serialVersionUID = 1L;
		};
		EObject copy = copier.copy(cm);
		 copier.copyReferences(); //essential!!!
		ClassModel initialClassModel = (ClassModel) copy; // TODO: add typeCheck by 'instanceof'
		return initialClassModel;
	}

	// TODO: extract to utility
		public static Class createClass(ClassModel classModel, String name) {
	
			
			EGraph egraph = new EGraphImpl(classModel);
			
			UnitApplication app = new UnitApplicationImpl(getEngine());
			app.setEGraph(egraph);
			app.setUnit(getCreateClassUnit());
//			app.setParameterValue("className", name);
			
			if (app.execute(null)) {
				//TODO: how to deal with that?
	//			System.out.println("'createClass' applied");
	//			app.getAssignment();
			}
			
			Class result = null;
			Object createdClass = app.getResultParameterValue("newClass");
			if(createdClass instanceof Class){
				result = (Class) createdClass;
			}
			return result;
		}


		public static boolean assignFeaturesToClass(ClassModel classModel, Class classForFeatureEncapsulation, List<String> featureNames) {
			List<Feature> featuresToAssign = extractFeatures(featureNames, classModel.getFeatures());
		
			boolean allAssignmentsSuccessful = true;
			EGraph egraph = new EGraphImpl(classModel);
			for(Feature feature : featuresToAssign){
				UnitApplication app = new UnitApplicationImpl(getEngine());
				app.setEGraph(egraph);
				app.setUnit(getAssignFeaturesToClassUnit());
				app.setParameterValue("feature", feature);
				app.setParameterValue("class", classForFeatureEncapsulation);
				
				boolean assignementSuccessful = app.execute(null);
				
				allAssignmentsSuccessful = allAssignmentsSuccessful && assignementSuccessful;
			}
			
			return allAssignmentsSuccessful;
		}


		private static List<Feature> extractFeatures(List<String> featureNames, List<Feature> features) {
		
			List<Feature> extractedFeatures = new LinkedList<Feature>(); 
			for(Feature feature : features){
				if(featureNames.contains(feature.getName()))
					extractedFeatures.add(feature);
			}
			return extractedFeatures;
		}

		public static List<String> extractFeatureNames(EList<Feature> encapsulatedFeaturesOfMostValuableClass) {
			List<String> extractedFeatureNames = new LinkedList<String>();
			for(Feature feature : encapsulatedFeaturesOfMostValuableClass){
				extractedFeatureNames.add(feature.getName());
			}
			return extractedFeatureNames;
		}

		public static boolean deleteClass(ClassModel cm, Class clazz) {
			EGraph egraph = new EGraphImpl(cm);
			
			UnitApplication app = new UnitApplicationImpl(getEngine());
			app.setEGraph(egraph);
			app.setUnit(getDeleteClassUnit());
			app.setParameterValue("clazz", clazz);
			
			boolean transformationRuleApplied = app.execute(null);
		
			return transformationRuleApplied;
		}


		public static String getRandomString(){
			return Long.toHexString(Double.doubleToLongBits(Math.random()));
		}


		public static boolean doNameFix(ClassModel classModel) {
			EGraph egraph = new EGraphImpl(classModel);

			UnitApplication app = new UnitApplicationImpl(getEngine());
			app.setEGraph(egraph);
			app.setUnit(getNameFixUnit());
			
			boolean transformationRuleApplied = app.execute(null);
		
			return transformationRuleApplied;
		}

		public static boolean deleteEmptyClasses(ClassModel classModel) {
			EGraph egraph = new EGraphImpl(classModel);

			UnitApplication app = new UnitApplicationImpl(getEngine());
			app.setEGraph(egraph);
			app.setUnit(getDeleteEmptyClassesUnit());
			
			boolean transformationRuleApplied = app.execute(null);
		
			return transformationRuleApplied;
		}
}
