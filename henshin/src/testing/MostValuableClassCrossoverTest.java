package testing;

import java.util.List;

import org.junit.Test;

import architectureCRA.Class;
import architectureCRA.ClassModel;
import junit.framework.Assert;
import solution.CRAIndexCalculator;
import solution.ClassModelSolution;
import solution.Settings;
import solution.Utility;
import solution.crossover.SelectClassWithBestCohesionProcessor;

public class MostValuableClassCrossoverTest {

	@Test
	public void getMostValuableClassTest() {
		
		CRAIndexCalculator.registerPackage();
	
		ClassModel loadedCM = CRAIndexCalculator.loadModel("test_models/join_input_4.xmi");
	
		SelectClassWithBestCohesionProcessor mostValuableClassProcessor  = new SelectClassWithBestCohesionProcessor();
		
		Class mostValuableClass = mostValuableClassProcessor.getMostValuableClass(loadedCM);
		
		// "M1M3A1A2A3" is the class with the better cohesion (1.5) value.
		Class class1 = loadedCM.getClasses().get(0);
		if(class1.getName().equals("M1M3A1A2A3")){
			Assert.assertTrue(mostValuableClass == class1);			
		}
		Class class2 = loadedCM.getClasses().get(1);
		if(class2.getName().equals("M1M3A1A2A3")){
			Assert.assertTrue(mostValuableClass == class1);			
		}
		
		// TODO: use sub method calculateCohesion(Class clazz) to calculate the value of both classes. "M1M3A1A2A3": 1.5 ; "M2M4A4A5": 0.75
		
	}

	@Test
	public void getCrossoverTest() {
		
		Settings settings = new Settings();
		
		CRAIndexCalculator.registerPackage();
	
		ClassModel loadedCM1 = CRAIndexCalculator.loadModel("test_models/join_input_4.xmi");
		ClassModelSolution loadedCMS1 = new ClassModelSolution(loadedCM1, settings);
	
		ClassModel loadedCM2 = CRAIndexCalculator.loadModel("test_models/join_input_5.xmi");
		ClassModelSolution loadedCMS2 = new ClassModelSolution(loadedCM2, settings);
	
		SelectClassWithBestCohesionProcessor mostValuableClassProcessor  = new SelectClassWithBestCohesionProcessor();
		
		ClassModel rdg = Utility.getClassModelCopy(loadedCM1);
		List<ClassModelSolution> createdCrossover = mostValuableClassProcessor.createCrossover(rdg,loadedCMS1, loadedCMS2);
		
		Assert.assertEquals(1, createdCrossover.size());
		
		ClassModelSolution classModelSolution1 = createdCrossover.get(0);
		Assert.assertEquals(9, classModelSolution1.getClassModel().getFeatures().size());
		
		CRAIndexCalculator.evaluateModel(classModelSolution1.getClassModel());
	}
}
