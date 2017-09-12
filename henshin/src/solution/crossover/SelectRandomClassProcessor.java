package solution.crossover;

import org.eclipse.emf.common.util.EList;

import architectureCRA.Class;
import architectureCRA.ClassModel;

public class SelectRandomClassProcessor extends CrossoverProcessor {

	// here this is  not really the most valuable class but just a random one. 
	@Override
	public Class getMostValuableClass(ClassModel cm) {
		
		EList<Class> classes = cm.getClasses();

		if(classes.isEmpty()){
			System.err.println("NO CLASSES IN CM!!!");
		}
		// select random class
		int random = 0 + (int)    Math.round( (Math.random() * (((classes.size()-1) - 0))) );
		return classes.get(random);
	}
}
