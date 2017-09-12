package solution.crossover;

import java.util.LinkedList;
import java.util.List;

import architectureCRA.ClassModel;
import solution.ClassModelSolution;
import solution.Settings;

public class NoCrossoverProcessor implements ICrossover {

	@Override
	public List<ClassModelSolution> createCrossover(ClassModel rdg, ClassModelSolution thisClone,
			ClassModelSolution otherClone) {
		
		List<ClassModelSolution> result = new LinkedList<ClassModelSolution>();
		result.add(thisClone);
		return result;
	}

}
