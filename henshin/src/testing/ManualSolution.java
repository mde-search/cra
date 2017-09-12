package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import architectureCRA.ClassModel;
import solution.CRAIndexCalculator;

public class ManualSolution {

	@Test
	public void manualSolution1() {
		CRAIndexCalculator.registerPackage();

		ClassModel loadedCM = CRAIndexCalculator.loadModel("manual_solutions/TTC_manual_solution_A_1.xmi");
		CRAIndexCalculator.printOptimalityInfo(loadedCM);
	}
	
	@Test
	public void manualSolution2() {
		CRAIndexCalculator.registerPackage();

		ClassModel loadedCM = CRAIndexCalculator.loadModel("manual_solutions/TTC_manual_solution_A_2.xmi");
		CRAIndexCalculator.printOptimalityInfo(loadedCM);
	}
	
	@Test
	public void manualSolution3() {
		CRAIndexCalculator.registerPackage();

		ClassModel loadedCM = CRAIndexCalculator.loadModel("manual_solutions/TTC_manual_solution_A_3.xmi");
		CRAIndexCalculator.printOptimalityInfo(loadedCM);
	}
	
	@Test
	public void momotSolution1() {
		CRAIndexCalculator.registerPackage();

		ClassModel loadedCM = CRAIndexCalculator.loadModel("MOMoT_output_models/TTC_InputRDG_A_cd4.xmi");
		CRAIndexCalculator.printOptimalityInfo(loadedCM);
	}
}
