package solution;

import com.lagodiuk.ga.Fitness;

public class CRAFitness implements Fitness<ClassModelSolution, Double> {

	/**
	 * Assume that chromosome1 is better than chromosome2 <br/>
	 * fit1 = calculate(chromosome1) <br/>
	 * fit2 = calculate(chromosome2) <br/>
	 * So the following condition must be true <br/>
	 * fit1.compareTo(fit2) <= 0 <br/>
	 */
	@Override
	public Double calculate(ClassModelSolution chromosome) {
		double calculatedCRAIndex = CRAIndexCalculator.calculateCRAIndex(chromosome.getClassModel());	
		return (calculatedCRAIndex*(-1));
	}

}
