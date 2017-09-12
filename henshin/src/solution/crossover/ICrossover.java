package solution.crossover;

import java.util.List;

import architectureCRA.ClassModel;
import solution.ClassModelSolution;
import solution.Settings;

public interface ICrossover {

	List<ClassModelSolution> createCrossover(ClassModel rdg, ClassModelSolution thisClone, ClassModelSolution otherClone);

}
