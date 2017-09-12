package solution.runner;

import java.io.File;
import java.util.concurrent.TimeUnit;

import logging.Logger;
import solution.Settings;
import solution.Start;
import solution.Settings.Crossover;

public class MutationConfigurationSpaceRunner {
	
	
	public static void main(String[] args) {
		try {
			run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void run() throws InterruptedException{
		Settings settings = new Settings();
		settings.setMaximumNumberOfEvolutionIterations(10);
		settings.setCrossoverStrategy(Settings.Crossover.RANDOM);
		settings.setRuns(10);
		settings.setPopulationsSize(5);
		settings.setInitializationStrategy(Settings.InitializationStrategy.ONE_CLASS_PER_FEATURE);

		settings.setPostProcess_moveAttributeToReferencingMethod(true);
		
		String[] inputFileNames = {"TTC_InputRDG_A.xmi", 
				"TTC_InputRDG_B.xmi", 
				"TTC_InputRDG_C.xmi", 
				"TTC_InputRDG_D.xmi", 
				"TTC_InputRDG_E.xmi"};
		
		// WARMUP!!
		Start.run(inputFileNames[0], settings, "warmup", "warmup");
		Logger.resetTimeMeasurement();
		
		for(int i= 0 ; i<inputFileNames.length; i++){
			
			String inputFileName = inputFileNames[i];
						
			for(int booleanConfig = 1; booleanConfig<17; booleanConfig++){
				setBooleanConfiguration(settings, booleanConfig);
				
				String runPrefix = "runConfig_"+booleanConfig;

				String targetFolder =  inputFileName.split("\\.")[0]; // remove extension
				String subFolder = runPrefix;
				
				for(int run = 0;run<settings.getRuns(); run++){

					Start.run(inputFileName, settings, targetFolder, subFolder);
					//required to prevent blocking file system on result writing
					TimeUnit.MILLISECONDS.sleep(1000);
				}
				
				Logger.exportStoredRuntimeToCSV(targetFolder + File.separator + subFolder);
				Logger.resetTimeMeasurement();
				//required to prevent blocking file system on result writing
				TimeUnit.MILLISECONDS.sleep(1000);
			}
			
		}
	}

	private static void setBooleanConfiguration(Settings settings, int booleanConfig) {
		switch(booleanConfig) {
	        case 1:  //JSC - MORA - MSF - RS 
	    		settings.setMutateJoinSelectedClasses(true);
	    		settings.setMutateMoveAttributeToReferencingMethod(true);
	    		settings.setMutateMoveSelectedFeature(true);
	    		settings.setMutateRandomSplitClass(true);
	        		break;
			case 2:  //JSC - MORA - MSF 
	    		settings.setMutateJoinSelectedClasses(true);
	    		settings.setMutateMoveAttributeToReferencingMethod(true);
	    		settings.setMutateMoveSelectedFeature(true);
	    		settings.setMutateRandomSplitClass(false);
	        		break;
			case 3:  //JSC - MORA - RS
	    		settings.setMutateJoinSelectedClasses(true);
	    		settings.setMutateMoveAttributeToReferencingMethod(true);
	    		settings.setMutateMoveSelectedFeature(false);
	    		settings.setMutateRandomSplitClass(true);
	        		break;
			case 4:  //JSC - MSF - RS
	    		settings.setMutateJoinSelectedClasses(true);
	    		settings.setMutateMoveAttributeToReferencingMethod(false);
	    		settings.setMutateMoveSelectedFeature(true);
	    		settings.setMutateRandomSplitClass(true);
	        		break;
			case 5:  //MORA - MSF - RS
	    		settings.setMutateJoinSelectedClasses(false);
	    		settings.setMutateMoveAttributeToReferencingMethod(true);
	    		settings.setMutateMoveSelectedFeature(true);
	    		settings.setMutateRandomSplitClass(true);
	        		break;
			case 6:  //JSC - MORA
	    		settings.setMutateJoinSelectedClasses(true);
	    		settings.setMutateMoveAttributeToReferencingMethod(true);
	    		settings.setMutateMoveSelectedFeature(false);
	    		settings.setMutateRandomSplitClass(false);
	        		break;
			case 7:  //JSC - RS
	    		settings.setMutateJoinSelectedClasses(true);
	    		settings.setMutateMoveAttributeToReferencingMethod(false);
	    		settings.setMutateMoveSelectedFeature(false);
	    		settings.setMutateRandomSplitClass(true);
	        		break;
			case 8:  //MSF - RS
	    		settings.setMutateJoinSelectedClasses(false);
	    		settings.setMutateMoveAttributeToReferencingMethod(false);
	    		settings.setMutateMoveSelectedFeature(true);
	    		settings.setMutateRandomSplitClass(true);
	        		break;
			case 9:  //MORA - MSF
	    		settings.setMutateJoinSelectedClasses(false);
	    		settings.setMutateMoveAttributeToReferencingMethod(true);
	    		settings.setMutateMoveSelectedFeature(true);
	    		settings.setMutateRandomSplitClass(false);
	        		break;
			case 10:  //JSC - MSF
	    		settings.setMutateJoinSelectedClasses(true);
	    		settings.setMutateMoveAttributeToReferencingMethod(false);
	    		settings.setMutateMoveSelectedFeature(true);
	    		settings.setMutateRandomSplitClass(false);
	        		break;
			case 11:  //MORA - RS
	    		settings.setMutateJoinSelectedClasses(false);
	    		settings.setMutateMoveAttributeToReferencingMethod(true);
	    		settings.setMutateMoveSelectedFeature(false);
	    		settings.setMutateRandomSplitClass(true);
	        		break;
			case 12:  //JSC
	    		settings.setMutateJoinSelectedClasses(true);
	    		settings.setMutateMoveAttributeToReferencingMethod(false);
	    		settings.setMutateMoveSelectedFeature(false);
	    		settings.setMutateRandomSplitClass(false);
	        		break;
			case 13:  //MORA
	    		settings.setMutateJoinSelectedClasses(false);
	    		settings.setMutateMoveAttributeToReferencingMethod(true);
	    		settings.setMutateMoveSelectedFeature(false);
	    		settings.setMutateRandomSplitClass(false);
	        		break;
			case 14:  //MSF
	    		settings.setMutateJoinSelectedClasses(false);
	    		settings.setMutateMoveAttributeToReferencingMethod(false);
	    		settings.setMutateMoveSelectedFeature(true);
	    		settings.setMutateRandomSplitClass(false);
	        		break;
			case 15:  //RS
	    		settings.setMutateJoinSelectedClasses(false);
	    		settings.setMutateMoveAttributeToReferencingMethod(false);
	    		settings.setMutateMoveSelectedFeature(false);
	    		settings.setMutateRandomSplitClass(true);
	        		break;
			case 16:  //
	    		settings.setMutateJoinSelectedClasses(false);
	    		settings.setMutateMoveAttributeToReferencingMethod(false);
	    		settings.setMutateMoveSelectedFeature(false);
	    		settings.setMutateRandomSplitClass(false);
	        		break;
		}
	}

	private static String createFolderString(String runPrefix, String inputFileName) {
		String inputFileNameWithoutExtension = inputFileName.split("\\.")[0];
		String targetFolder = inputFileNameWithoutExtension + File.separator + runPrefix;
		return targetFolder;
	}
}
