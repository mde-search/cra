package momot_results;

import java.util.Arrays;
import java.util.List;

import architectureCRA.ClassModel;
import solution.CRAIndexCalculator;

public class MOMotResultCalculator {
	
	// Relative path to the output models.		
	static String OUTPUT_MODELS = "MOMoT_output_models/";

	static String partialOutputFileNameBeginning = "TTC_InputRDG_";
	static String outputFileNameFileEnding = ".xmi";
			
	
	public static void main(String[] args){
		
		// 1. loop ( A to E )
		List<String> supplierNames = Arrays.asList("A_cd4", "B_cd7", "C_cd12", "D_cd20", "E_cd47");
		for(String partialResultName : supplierNames){
			String outputModel = partialOutputFileNameBeginning+partialResultName+outputFileNameFileEnding;
			System.out.println("output model: "+outputModel);
			// 2. load model
			CRAIndexCalculator.registerPackage();
			ClassModel loadedInputModel = CRAIndexCalculator.loadModel(OUTPUT_MODELS+outputModel);
			// calculate CRA
			CRAIndexCalculator.evaluateModel(loadedInputModel);
//			CRAIndexCalculator.printOptimalityInfo(loadedInputModel);
		}
		
	}

}
