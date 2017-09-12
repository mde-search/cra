package solution.runner;

import java.io.File;
import java.util.concurrent.TimeUnit;

import logging.Logger;
import solution.Settings;
import solution.Start;
import solution.Settings.Crossover;

public class CrossoverConfigurationSpaceRunner {
	
	
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
			
			for(int crossoverConfig = 3; crossoverConfig<4; crossoverConfig++){
//				setBooleanConfiguration(settings, crossoverConfig);
				setCrossoverConfiguration(settings, crossoverConfig);
				
				String runPrefix = "runConfig_"+crossoverConfig;

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

	private static void setCrossoverConfiguration(Settings settings, int crossoverConfig) {
		switch(crossoverConfig) {
        case 0: //RANDOM
			settings.setCrossoverStrategy(Settings.Crossover.RANDOM);
        		break;
		case 1: //CLASS_WITH_BEST_COHESION
			settings.setCrossoverStrategy(Settings.Crossover.CLASS_WITH_BEST_COHESION);
        		break;
		case 2: //CLASS_WITH_BEST_COUPLING_AND_COHESION
			settings.setCrossoverStrategy(Settings.Crossover.CLASS_WITH_BEST_COUPLING_AND_COHESION);
        		break;
		case 3: //CLASS_WITH_BEST_COUPLING_AND_COHESION
			settings.setCrossoverStrategy(Settings.Crossover.NONE);
        		break;
		}
	}
}
