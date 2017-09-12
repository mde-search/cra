package solution;

import solution.crossover.ICrossover;
import solution.crossover.NoCrossoverProcessor;
import solution.crossover.SelectClassWithBestCohesionAndCouplingProcessor;
import solution.crossover.SelectClassWithBestCohesionProcessor;
import solution.crossover.SelectRandomClassProcessor;

public class Settings {
	
	/**
	 * holds information on: 
	 * - OK population size 
	 * - OK	maximumNumberOfEvolutionIterations 
	 * - OK targetValue (double or null for NOT!) 
	 * - OK involved mutations 
	 * - OK used CrossoverStrategy 
	 * - initialPopulation creation 
	 * - OK OPTIMISATION/ post processing
	 * -
	 * 
	 */
	
	public enum Crossover {
		RANDOM, CLASS_WITH_BEST_COHESION, CLASS_WITH_BEST_COUPLING_AND_COHESION, NONE
	}
	
	public enum InitializationStrategy {
		ONE_CLASS_PER_FEATURE, GODCLASS, MIXED
	}
	
	private InitializationStrategy initializationStrategy = InitializationStrategy.MIXED; // default
	
	public InitializationStrategy getInitializationStrategy() {
		return initializationStrategy;
	}

	public void setInitializationStrategy(InitializationStrategy initializationStrategy) {
		this.initializationStrategy = initializationStrategy;
	}

	private int runs = 1; // default

	private int maximumNumberOfEvolutionIterations = 10; // default

	private int populationsSize = 5; // default
	
	private double fitnessThreshold = Double.MAX_VALUE;// 1.0; //1e-5;
	
	// mutations
	private boolean mutateMoveSelectedFeature = true; //default
	private boolean mutateJoinSelectedClasses = true; //default
	private boolean mutateMoveAttributeToReferencingMethod = true; //default
	private boolean mutateRandomSplitClass = true; //default
	
	// crossover
	private ICrossover crossoverStrategy;
	
	// optimisations!
	private boolean postProcess_moveAttributeToReferencingMethod = false; // default

	/**
	 * default constructor
	 */
	public Settings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setRuns(int runs) {
		this.runs = runs;		
	}

	public int getRuns() {
		return runs;
	}

	public ICrossover getCrossoverStrategy() {
		if(crossoverStrategy == null)
			crossoverStrategy = new SelectRandomClassProcessor();
		return crossoverStrategy;
	}

	public void setCrossoverStrategy(Crossover crossoverStrategy) {
		switch (crossoverStrategy) {
		case RANDOM:
			this.crossoverStrategy = new SelectRandomClassProcessor();
		case CLASS_WITH_BEST_COHESION:
			this.crossoverStrategy = new SelectClassWithBestCohesionProcessor();
		case CLASS_WITH_BEST_COUPLING_AND_COHESION:
			this.crossoverStrategy = new SelectClassWithBestCohesionAndCouplingProcessor();
		case NONE:
			this.crossoverStrategy = new NoCrossoverProcessor();
		default:
			this.crossoverStrategy = new SelectRandomClassProcessor();
		}
	}

	public int getPopulationsSize() {
		return populationsSize;
	}

	public void setPopulationsSize(int populationsSize) {
		this.populationsSize = populationsSize;
	}

	public int getMaximumNumberOfEvolutionIterations() {
		return maximumNumberOfEvolutionIterations;
	}

	public void setMaximumNumberOfEvolutionIterations(int maximumNumberOfEvolutionIterations) {
		this.maximumNumberOfEvolutionIterations = maximumNumberOfEvolutionIterations;
	}

	public boolean isMutateMoveSelectedFeature() {
		return mutateMoveSelectedFeature;
	}

	public void setMutateMoveSelectedFeature(boolean mutateMoveSelectedFeature) {
		this.mutateMoveSelectedFeature = mutateMoveSelectedFeature;
	}

	public boolean isMutateJoinSelectedClasses() {
		return mutateJoinSelectedClasses;
	}

	public void setMutateJoinSelectedClasses(boolean mutateJoinSelectedClasses) {
		this.mutateJoinSelectedClasses = mutateJoinSelectedClasses;
	}

	public boolean isMutateMoveOnceReferencedAttrToItsMethod() {
		return mutateMoveAttributeToReferencingMethod;
	}

	public void setMutateMoveAttributeToReferencingMethod(boolean mutateMoveAttributeToReferencingMethod) {
		this.mutateMoveAttributeToReferencingMethod = mutateMoveAttributeToReferencingMethod;
	}

	public boolean isMutateRandomSplitClass() {
		return mutateRandomSplitClass;
	}

	public void setMutateRandomSplitClass(boolean mutateRandomSplitClass) {
		this.mutateRandomSplitClass = mutateRandomSplitClass;
	}

	public void setCrossoverStrategy(ICrossover crossoverStrategy) {
		this.crossoverStrategy = crossoverStrategy;
	}

	public boolean doPostProcess_moveAttributeToReferencingMethod() {
		return postProcess_moveAttributeToReferencingMethod;
	}

	public void setPostProcess_moveAttributeToReferencingMethod(boolean postProcess_moveAttributeToReferencingMethod) {
		this.postProcess_moveAttributeToReferencingMethod = postProcess_moveAttributeToReferencingMethod;
	}

	public double getFitnessThreshold() {
		return fitnessThreshold;
	}

	public void setFitnessThreshold(double fitnessThreshold) {
		this.fitnessThreshold = fitnessThreshold;
	}
}
