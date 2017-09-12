package solution.runner;

import java.io.File;
import java.util.concurrent.TimeUnit;

import logging.Logger;
import solution.Settings;
import solution.Start;
import solution.Settings.Crossover;
import solution.Settings.InitializationStrategy;

public class InitialisationConfigurationRunner {
	
	
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
		settings.setMaximumNumberOfEvolutionIterations(20);
		settings.setCrossoverStrategy(Settings.Crossover.RANDOM);
		settings.setRuns(10);
		settings.setPopulationsSize(5);
		
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
			
			
			//TODO: welche sinnvollen settingshaben sich aus den vorherigen Messungen ergeben?
			
			for(InitializationStrategy strategy : Settings.InitializationStrategy.values()) {

	        	settings.setInitializationStrategy(strategy);
				
				String runPrefix = "runConfig_"+strategy.toString();

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
 
	private static String createFolderString(String runPrefix, String inputFileName) {
		String inputFileNameWithoutExtension = inputFileName.split("\\.")[0];
		String targetFolder = inputFileNameWithoutExtension + File.separator + runPrefix;
		return targetFolder;
	}
}
