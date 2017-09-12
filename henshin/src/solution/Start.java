package solution;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import architectureCRA.ClassModel;
import logging.Logger;

public class Start {
	
	static String OUTPUT_FOLDER = "output_models"+File.separator;
		
	public static void run(String inputFileName, Settings settings, String targetFolder, String targetSubFolder) {

		Date start = new Date();
		
		Logger.startTimeMeasurement();
		
		// 2. start genetic optimization
		GeneticOptimizer geneticOptimizer = new GeneticOptimizer();
		geneticOptimizer.startOptimization(inputFileName, settings);
		
		Logger.endTimeMeasurement();
		
		//no more supported!!
//		Logger.printUnitApplicationCount();
		Logger.printStoredModelInfo();
		
		DateFormat dateFormat = new SimpleDateFormat("yy_MM_dd-HHmmss");
		String inputFileNameWithoutExtension = inputFileName.split("\\.")[0];
		writeLogToFileSystem(targetFolder, targetSubFolder, start, dateFormat, inputFileNameWithoutExtension);
		writeBestModelToFileSystem(geneticOptimizer.getBestClassModel(), targetFolder, targetSubFolder, start, dateFormat, inputFileNameWithoutExtension);
		

		Logger.reset();
	}


	private static void writeLogToFileSystem(String targetFolder, String targetSubFolder, Date start,
			DateFormat dateFormat, String inputFileNameWithoutExtension) {
		File folder = new File(targetFolder);
		folder.mkdir();
		File subfolder = new File(targetFolder + File.separator + targetSubFolder);
		subfolder.mkdir();
		Logger.exportStoredModelInfoToCSV(subfolder.getPath() + File.separator + dateFormat.format(start) + "-" + inputFileNameWithoutExtension + "-metrics.csv");
	}

	private static void writeBestModelToFileSystem(ClassModel bestClassModel, String targetFolder,
			String targetSubFolder, Date start, DateFormat dateFormat, String inputFileNameWithoutExtension) {
		File folder = new File(OUTPUT_FOLDER + targetFolder);
		folder.mkdir();
		File subfolder = new File(OUTPUT_FOLDER + targetFolder + File.separator + targetSubFolder);
		subfolder.mkdir();
		String cra = CRAIndexCalculator.calculateCRAIndex(bestClassModel)+"0000";
		cra = cra.substring(0,cra.indexOf('.')+2);
		String path = subfolder.getPath() + File.separator + dateFormat.format(start) + "-" + inputFileNameWithoutExtension + "-cra_"+cra+".xmi";
		Utility.getHenshinResourceSet().saveEObject(bestClassModel, path);
	}

	
	public static void run(String inputFileName, Settings settings) {
		run(inputFileName, settings, "", "");
	}

}
