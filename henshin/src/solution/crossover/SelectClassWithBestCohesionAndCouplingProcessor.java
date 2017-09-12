package solution.crossover;

import architectureCRA.Class;
import architectureCRA.ClassModel;
import solution.Utility;

public class SelectClassWithBestCohesionAndCouplingProcessor extends CrossoverProcessor {

	@Override
	public Class getMostValuableClass(ClassModel cm) {
		Class mostValuableClass = cm.getClasses().get(0); // default to prevent NULL as return value
		double bestClazzCRA = Double.MIN_VALUE;
		for(Class clazz : cm.getClasses()){
			double cohesion = Utility.calculateCohesion(clazz);
			double coupling = Utility.calculateCoupling(clazz, cm);
			double clazzCRA = cohesion-coupling;
			if(clazzCRA > bestClazzCRA){
				mostValuableClass = clazz;
				bestClazzCRA = clazzCRA;
			}
		}
		return mostValuableClass;
	}
}
