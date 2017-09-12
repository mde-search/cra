//package solution;
//
//import java.io.File;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//import logging.Logger;
//
//public class RunAllConfigs {
//	
//	
//	public static void main(String[] args) {
//		try {
//			run();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public static void run() throws InterruptedException{
//		Settings settings = new Settings();
//		
//		String inputFileName = "TTC_InputRDG_A.xmi";
//		
//		settings.setMaximumNumberOfEvolutionIterations(5);
//		settings.setCrossoverStrategy(Settings.Crossover.RANDOM);
//		settings.setRuns(10);
//		
////		settings.setInitialiseWithOneClassForFeaturesAndOneForAttributes(true);
////		settings.setInitialiseWithAllFeaturesInOneClass(true);
//		
//		//end early
////		settings.setFitnessThreshold(3.5);
//		
////		settings.setPopulationsSize(3);
//////		settings.setPostProcessMoveOnceReferencedAttrToItsMethod(true);
//////		settings.setMutateRandomSplitClass(false);
////		for(int i = 0;i<settings.getRuns(); i++){
////			Start.run(inputFileName, settings, "popSize3");			
////		}
//		
//
//		settings.setPopulationsSize(5);
////		settings.setPostProcessMoveOnceReferencedAttrToItsMethod(true);
////		settings.setMutateRandomSplitClass(true);
//
//		String runPrefix = "popSize5_noOpt";
//		String targetFolder = createFolderString(runPrefix, inputFileName);
//		
//		for(int i = 0;i<settings.getRuns(); i++){
//			Start.run(inputFileName, settings, targetFolder);
//		}
//		
//		Logger.exportStoredRuntimeToCSV(targetFolder);
//		Logger.resetTimeMeasurement();
//		TimeUnit.SECONDS.sleep(5);
//		
//		
//		settings.setPopulationsSize(5);
//		settings.setPostProcessMoveOnceReferencedAttrToItsMethod(true);
////		settings.setMutateRandomSplitClass(true);
//		
//
//		runPrefix = "popSize5_withOpt";
//		targetFolder = createFolderString(runPrefix, inputFileName);
//		
//		for(int i = 0;i<settings.getRuns(); i++){
//			Start.run(inputFileName, settings, targetFolder);
//		}
//		
//		Logger.exportStoredRuntimeToCSV(targetFolder);
//		Logger.resetTimeMeasurement();
//		TimeUnit.SECONDS.sleep(5);
//		
//		
//		
//		inputFileName = "TTC_InputRDG_C.xmi";
//		
//		
//		settings.setPopulationsSize(5);
////		settings.setPostProcessMoveOnceReferencedAttrToItsMethod(true);
////		settings.setMutateRandomSplitClass(true);
//		
//		runPrefix = "popSize5_noOpt";
//		targetFolder = createFolderString(runPrefix, inputFileName);
//		
//		for(int i = 0;i<settings.getRuns(); i++){
//			Start.run(inputFileName, settings, targetFolder);
//		}
//
//		Logger.exportStoredRuntimeToCSV(targetFolder);
//		Logger.resetTimeMeasurement();
//		TimeUnit.SECONDS.sleep(5);
//		
//		
//		
//		settings.setPopulationsSize(5);
//		settings.setPostProcessMoveOnceReferencedAttrToItsMethod(true);
////		settings.setMutateRandomSplitClass(true);
//		
//		runPrefix = "popSize5_withOpt";
//		targetFolder = createFolderString(runPrefix, inputFileName);
//		
//		for(int i = 0;i<settings.getRuns(); i++){
//			Start.run(inputFileName, settings, targetFolder);
//		}
//
//		Logger.exportStoredRuntimeToCSV(targetFolder);
//		Logger.resetTimeMeasurement();
//		TimeUnit.SECONDS.sleep(5);
//		
//
//	}
//
//	private static String createFolderString(String runPrefix, String inputFileName) {
//		String inputFileNameWithoutExtension = inputFileName.split("\\.")[0];
//		String targetFolder = inputFileNameWithoutExtension + File.separator + runPrefix;
//		return targetFolder;
//	}
//}
