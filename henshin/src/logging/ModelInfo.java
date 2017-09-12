package logging;

import architectureCRA.ClassModel;
import solution.CRAIndexCalculator;

public class ModelInfo {
	private ClassModel classModel;
	private int classCount;
	private double cohesion;
	private double coupling;
	private double fitness;
	
	ModelInfo(ClassModel model) {
		this.classModel = model;
		this.classCount = model.getClasses().size();
		this.cohesion = CRAIndexCalculator.calculateCohesion(model);
		this.coupling = CRAIndexCalculator.calculateCoupling(model);
		this.fitness = cohesion-coupling;
	}
	
	public ClassModel getClassModel() {
		return classModel;
	}
	
	public int getClassCount() {
		return classCount;
	}
	public double getCohesion() {
		return cohesion;
	}
	public double getCoupling() {
		return coupling;
	}
	public double getFitness() {
		return fitness;
	}
}
