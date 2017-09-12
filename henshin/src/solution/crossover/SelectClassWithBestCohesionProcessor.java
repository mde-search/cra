package solution.crossover;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import architectureCRA.Class;
import architectureCRA.ClassModel;
import architectureCRA.Feature;
import solution.ClassModelSolution;
import solution.Settings;
import solution.Utility;

public class SelectClassWithBestCohesionProcessor extends CrossoverProcessor implements ICrossover {
	
	
	public Class getMostValuableClass(ClassModel cm) {
		Class mostValuableClass = cm.getClasses().get(0); // default to prevent NULL as return value
		double bestCohesion = Double.MIN_VALUE;
		for(Class clazz : cm.getClasses()){
			double cohesion = Utility.calculateCohesion(clazz);
			if(cohesion > bestCohesion){
				mostValuableClass = clazz;
				bestCohesion = cohesion;
			}
		}
		return mostValuableClass;
	}

}
