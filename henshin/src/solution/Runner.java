package solution;

import java.io.File;
import java.util.concurrent.TimeUnit;

import logging.Logger;
import solution.Settings.Crossover;

public class Runner {
	
	private static final int NUMBER_OF_RUNS = 10;
	private static final int NUMBER_OF_MAXIMUM_ITERATIONS = 20;
	private static final int POPULATION_SIZE = 5;
	
	private static final Settings.InitializationStrategy INITIALIZATION_STRATEGY = Settings.InitializationStrategy.ONE_CLASS_PER_FEATURE;
	
	private static final boolean MUTATE_JOIN_SELECTED_CLASSES = true;
	private static final boolean MUTATE_MOVE_ATTRIBUTE_TO_REFERENCING_METHOD = true;
	private static final boolean MUTATE_MOVE_SELECTED_FEATURE = true;
	private static final boolean MUTATE_RANDOM_SPLIT_CLASS = true;
	
	private static final Crossover CROSSOVER_STRATEGY = Settings.Crossover.RANDOM;

	private static final boolean POST_PROCESSING = true;
	
	private static final String[] inputFileNames = {
			"TTC_InputRDG_A.xmi", 
			"TTC_InputRDG_B.xmi", 
			"TTC_InputRDG_C.xmi", 
			"TTC_InputRDG_D.xmi", 
			"TTC_InputRDG_E.xmi"};

	
	
	public static void main(String[] args) {
		try {
			run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void run() throws InterruptedException {

		Settings settings = new Settings();
		settings.setRuns(NUMBER_OF_RUNS);
		settings.setMaximumNumberOfEvolutionIterations(NUMBER_OF_MAXIMUM_ITERATIONS);
		settings.setPopulationsSize(POPULATION_SIZE);
		settings.setInitializationStrategy(INITIALIZATION_STRATEGY);
		settings.setMutateJoinSelectedClasses(MUTATE_JOIN_SELECTED_CLASSES);
		settings.setMutateMoveAttributeToReferencingMethod(MUTATE_MOVE_ATTRIBUTE_TO_REFERENCING_METHOD);
		settings.setMutateMoveSelectedFeature(MUTATE_MOVE_SELECTED_FEATURE);
		settings.setMutateRandomSplitClass(MUTATE_RANDOM_SPLIT_CLASS);
		settings.setCrossoverStrategy(CROSSOVER_STRATEGY);
		settings.setPostProcess_moveAttributeToReferencingMethod(POST_PROCESSING);
		
		
		settings.setCrossoverStrategy(CROSSOVER_STRATEGY);
		
		// WARMUP!!
		Start.run(inputFileNames[0], settings, "warmup", "warmup");
		Logger.resetTimeMeasurement();
		
		for(String inputFileName : inputFileNames){	
			String runPrefix = "RUNNER";
			String targetFolder =  inputFileName.split("\\.")[0]; // removes extension
			String subFolder = runPrefix;
	
			for (int i = 0; i < settings.getRuns(); i++) {
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
