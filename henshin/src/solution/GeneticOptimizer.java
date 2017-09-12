package solution;

import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import com.lagodiuk.ga.Fitness;
import com.lagodiuk.ga.GeneticAlgorithm;
import com.lagodiuk.ga.IterartionListener;
import com.lagodiuk.ga.Population;

import architectureCRA.ClassModel;



public class GeneticOptimizer {
	
	// Relative path to the input models.		
	static String INPUT_MODELS = "input_models/";
	
	// Relative path to the output models.		
	static String OUTPUT_MODELS = "output_models/";
	
	private ClassModel bestClassModel;
	
	
	/**
	 * default Constructor
	 */
	public GeneticOptimizer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	void startOptimization(String inputFileName, Settings settings) {
		
		// 1. setup
		CRAIndexCalculator.registerPackage();
		ClassModel loadedInputModel = CRAIndexCalculator.loadModel(INPUT_MODELS+inputFileName);
		
		// required for future children generation during crossover.
		ClassModel rdg = Utility.getClassModelCopy(loadedInputModel);
		
		ClassModelSolution loadedCMS = new ClassModelSolution(loadedInputModel, settings);
		
		// 2. initial population
		Population<ClassModelSolution> population = InitialPopulationProvider.createInitialPopulation(loadedCMS, settings.getPopulationsSize());
//		
		// inversion of CRA by multiplication with "-1" 
        Fitness<ClassModelSolution, Double> fitness = new CRAFitness();

        // 3. genetic algorithm
        GeneticAlgorithm<ClassModelSolution, Double> ga = new GeneticAlgorithm<ClassModelSolution, Double>(population, fitness, rdg);

        addListener(ga);
        
        System.err.println("START evolution");
        
        long startTime = System.currentTimeMillis();
        
        ga.evolve(settings.getMaximumNumberOfEvolutionIterations());
        
        long endTime = System.currentTimeMillis();
		
        //retrieve best solution
        ClassModelSolution best = ga.getBest();
        
        int numberOfIterations = ga.getIteration();
        
        System.err.println("number of iterations: "+numberOfIterations);
        
        // calculate CRA Index of best solution
        CRAIndexCalculator.evaluateModelWithoutCorrectness(best.getClassModel());
        
        bestClassModel = best.getClassModel();
	}





	/**
     * After each iteration Genetic algorithm notifies listener
     */
    private static void addListener(GeneticAlgorithm<ClassModelSolution, Double> ga) {
        // just for pretty print
        System.out.println(String.format("%s\t%s\t%s", "iter", "fit", "chromosome"));

        // Lets add listener, which prints best chromosome after each iteration
        ga.addIterationListener(new IterartionListener<ClassModelSolution, Double>() {



            @Override
            public void update(GeneticAlgorithm<ClassModelSolution, Double> ga) {

            	ClassModelSolution bestCMS = ga.getBest();
                double bestFit = ga.fitness(bestCMS);
                int iteration = ga.getIteration();
                
                Settings settings = bestCMS.getSettings();

                // Listener prints best achieved solution
                System.out.println(String.format("%s\t%s\t%s", iteration, bestFit, bestCMS));

                // If fitness is satisfying - we can stop Genetic algorithm
            	if (bestFit < ((-1)*(settings.getFitnessThreshold()))) {
                    ga.terminate();
            	}      
            }
        });
    }


	public ClassModel getBestClassModel() {
		return bestClassModel;
	}
    
}
