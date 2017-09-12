package testing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import architectureCRA.Class;
import architectureCRA.ClassModel;
import junit.framework.Assert;
import solution.CRAIndexCalculator;
import solution.Utility;

public class UtilityTest {

	@Test
	public void createClassTest() {
		
		CRAIndexCalculator.registerPackage();
	
		ClassModel loadedCM = CRAIndexCalculator.loadModel("test_models/join_input_1.xmi");
		
		String nameOfNewClass = "newClass";
		
		Utility.createClass(loadedCM, nameOfNewClass);
				
		Assert.assertEquals(1, loadedCM.getClasses().size());		
	}

	@Test
	public void assignFeaturesToClassTest() {
		
		CRAIndexCalculator.registerPackage();
	
		ClassModel loadedCM = CRAIndexCalculator.loadModel("test_models/join_input_3.xmi");
		
		List<String> featureNames = Arrays.asList(new String[]{"M1","A3"});
		
		Class classForFeatureEncapsulation = loadedCM.getClasses().get(0);
		
		boolean featuresAssignedToClass = Utility.assignFeaturesToClass(loadedCM, classForFeatureEncapsulation, featureNames);
		
		Assert.assertTrue(featuresAssignedToClass);
				
		Assert.assertEquals(2, classForFeatureEncapsulation.getEncapsulates().size());
		
		//TODO: check by assertion, that feature M1 and A3 are encapsulated.		
	}


	@Test
	public void deleteFeaturesTest() {
		
		CRAIndexCalculator.registerPackage();
	
		ClassModel loadedCM = CRAIndexCalculator.loadModel("test_models/join_input_4.xmi");
		
		List<String> featureNames = Arrays.asList(new String[]{"M1","M3","A2","A3","A4"});
		
		Assert.assertEquals(9, loadedCM.getFeatures().size());
		
		Utility.deleteFeatures(loadedCM, featureNames);
	
		Assert.assertEquals(4, loadedCM.getFeatures().size());
	}

}
