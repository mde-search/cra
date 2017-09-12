package logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.acl.LastOwnerException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.eclipse.emf.henshin.model.Unit;

import architectureCRA.ClassModel;

public class Logger {
	
	private static List<Unit> appliedUnits = new ArrayList<Unit>();
	private static List<ModelInfo> storedModelInfo = new ArrayList<ModelInfo>();
	private static List<Long> runtime = new ArrayList<Long>();
	
	private static long lastStartTime;
	
	private static DateFormat dateFormat = new SimpleDateFormat("yy_MM_dd-HHmmss");
	
	public static List<Unit> getAppliedUnits() {
		return appliedUnits;
	}

	/**
	 * Adds the given Unit to the list of applied Units
	 * @param appliedUnit
	 */
	public static void storeUnitApplication(Unit appliedUnit) {
		appliedUnits.add(appliedUnit);
	}
	
	public static List<ModelInfo> getStoredModelInfo() {
		return storedModelInfo;
	}
	
	public static void storeModelInfo(ClassModel model) {
		storedModelInfo.add(new ModelInfo(model));
	}
	
	public static HashMap<String, Integer> getUnitApplicationCount() {
		HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
		
		for(Unit unit : appliedUnits) {
			if(resultMap.containsKey(unit.getName())) {
				Integer oldValue = resultMap.get(unit.getName());
				resultMap.put(unit.getName(), oldValue + 1);
			} else {
				resultMap.put(unit.getName(), 1);
			}
		}
		
		return resultMap;
	}
	
//	public static void printUnitApplicationCount() {
//		HashMap<String, Integer> count = getUnitApplicationCount();
//		
//		System.out.println("------------------------------------------");
//		System.out.println("Unit Application Count:");
//		System.out.println("------------------------------------------");
//		
//		for(String unit : count.keySet()) {
//			System.out.println(unit + ": " + count.get(unit));
//		}
//		
//		System.out.println("------------------------------------------\n");
//	}

	public static void printStoredModelInfo() {
		System.out.println("------------------------------------------------");
		System.out.println("Stored model information:");
		System.out.println("------------------------------------------------");
		
		System.out.println("Classes\t|Cohesion\t|Coupling\t|Fitness");
		System.out.println("------------------------------------------------");
		DecimalFormat df = new DecimalFormat("0.00");
		
		for(ModelInfo modelInfo : storedModelInfo) {
			System.out.print(modelInfo.getClassCount() + "\t|");
			System.out.print(df.format(modelInfo.getCohesion()) + "\t\t|");
			System.out.print(df.format(modelInfo.getCoupling()) + "\t\t|");
			System.out.print(df.format(modelInfo.getFitness()) + "\t");
			System.out.print("\n");
		}
	}
	
	public static void exportUnitApplicationCountToCVS(String filename) {
		if(appliedUnits.isEmpty()) {
			return;
		}
		
		try {
			FileWriter fw = new FileWriter(filename);

			fw.append("unitname,count");
			
			HashMap<String, Integer> count = getUnitApplicationCount();
			for(String unitName : count.keySet()) {
				fw.append("\n");
				fw.append(unitName);
				fw.append(",");
				fw.append(count.get(unitName).toString());
			}
			
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void exportStoredModelInfoToCSV(String filename) {
		if(storedModelInfo.isEmpty()) {
			return;
		}
		
		try {
			FileWriter fw = new FileWriter(filename);
			
			fw.append("classes,cohesion,coupling,fitness");
			
			for(ModelInfo info : storedModelInfo) {
				fw.append("\n");
				fw.append(modelInfoToString(info));
			}
			
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void exportStoredRuntimeToCSV(String targetFolder){
		if(runtime.isEmpty()) {
			return;
		}
		
		try {
			
			Date start = new Date();
			String filename = targetFolder + File.separator + dateFormat.format(start) + "-results.csv";
			
			
			FileWriter fw = new FileWriter(filename);
			
			fw.append("measured runtime in miliseconds");
			
			for(Long singleRuntime : runtime) {
				fw.append("\n");
				fw.append(String.valueOf(singleRuntime));
			}
			
			
			DescriptiveStatistics stats = new DescriptiveStatistics();

			// Add the data from the array
			for(Long singleRuntime : runtime) {
				stats.addValue(singleRuntime);
			}

			// Compute some statistics
			double mean = stats.getMean();
			fw.append("\n"); fw.append("mean");
			fw.append("\n"); fw.append(printAsString(mean));
			double std = stats.getStandardDeviation();
			fw.append("\n"); fw.append("std");
			fw.append("\n"); fw.append(printAsString(std));
			double median = stats.getPercentile(50);
			fw.append("\n"); fw.append("median");
			fw.append("\n"); fw.append(printAsString(median));
			
			
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String printAsString(double d) {
		String result = String.valueOf(d) + "000";
		result =  result.substring(0, result.indexOf('.')+2);
		return result;
	}
	 
	private static String modelInfoToString(ModelInfo info) {
		StringBuilder modelInfoStringBuilder = new StringBuilder();
		
		modelInfoStringBuilder.append(info.getClassCount());
		modelInfoStringBuilder.append(",");
		modelInfoStringBuilder.append(info.getCohesion());
		modelInfoStringBuilder.append(",");
		modelInfoStringBuilder.append(info.getCoupling());
		modelInfoStringBuilder.append(",");
		modelInfoStringBuilder.append(info.getFitness());
		return modelInfoStringBuilder.toString();
	}

	public static void reset() {
		appliedUnits = new ArrayList<Unit>();
		storedModelInfo = new ArrayList<ModelInfo>();
	}

	public static void startTimeMeasurement() {
		lastStartTime = System.currentTimeMillis();
	}

	public static void endTimeMeasurement() {
		long resultingDurationOfRun = System.currentTimeMillis() - lastStartTime;
		runtime.add(resultingDurationOfRun);
	}

	public static void resetTimeMeasurement() {
		runtime = new ArrayList<Long>();
	}
}
