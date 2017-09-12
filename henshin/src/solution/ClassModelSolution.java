package solution;

import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.model.Unit;

import com.lagodiuk.ga.Chromosome;

import architectureCRA.ClassModel;
import solution.crossover.ICrossover;

/**
 * Container for the actual model instance.
 * - providing required methods:
 * 	- mutate
 * 	- crossover (NOT implemented yet!)
 * 	- clone
 */
public class ClassModelSolution implements Chromosome<ClassModelSolution>, Cloneable {

	final Random random = new Random();

	private ClassModel classModel;
	
	List<String> historyOfAppliedTransformations;

	private List<Unit> lastMutations;

	private Settings settings;

	/**
	 * Default constructor (copies the provided ClassModel to contain the copy in the future!)
	 * @param classModel a class model of which a copy is created that serves in the future as contained class model
	 */
	public ClassModelSolution(ClassModel classModel, Settings settings) {
		this.settings = settings;
		EcoreUtil.Copier copier = new EcoreUtil.Copier() {
			// private static final long serialVersionUID = 1L;
		};
		EObject copy = copier.copy(classModel);
		 copier.copyReferences(); //essential!!!
		ClassModel newClassModel = (ClassModel) copy; // TODO: add typeCheck by 'instanceof'
		this.classModel = newClassModel;
	}
	
	//maybe replace by that
//	public ClassModelSolution(ClassModelSolution classModelSolution) {
//		this.settings = classModelSolution.getSettings();
//		EcoreUtil.Copier copier = new EcoreUtil.Copier() {
//			// private static final long serialVersionUID = 1L;
//		};
//		EObject copy = copier.copy(classModelSolution.getClassModel());
//		 copier.copyReferences(); //essential!!!
//		ClassModel newClassModel = (ClassModel) copy; // TODO: add typeCheck by 'instanceof'
//		this.classModel = newClassModel;
//	}

	/**
	 * Returns clone of current ClassModelSolution, which is mutated a bit by
	 * the Mutator, which should apply a single mutation transformation
	 */
	@Override
	public ClassModelSolution mutate() {
		ClassModelSolution mutatedClassModelSolution = new ClassModelSolution(getClassModel(), settings);
		this.lastMutations = Mutator.mutate(mutatedClassModelSolution);
		return mutatedClassModelSolution;
	}

	/**
	 * Returns list of siblings <br/>
	 * Siblings are actually new chromosomes, <br/>
	 * created using any of crossover strategy
	 */
	@Override
	public List<ClassModelSolution> crossover(ClassModel rdg, ClassModelSolution other) {
		ClassModelSolution thisClone = new ClassModelSolution(this.getClassModel(), settings); // this.clone(); //TODO: to be
												// adapted!
		ClassModelSolution otherClone = new ClassModelSolution(this.getClassModel(), settings); // other.clone();//TODO: to be
												// adapted!

		ICrossover crossoverProcessor = settings.getCrossoverStrategy();
		
		List<ClassModelSolution> crossoverSolutions = crossoverProcessor.createCrossover(rdg, thisClone, otherClone);

		return crossoverSolutions;
	}

	@Override
	protected ClassModelSolution clone() {
		// Constructor of 'ClassModelSolution' clones the passed ClassModel.
		ClassModelSolution clone = new ClassModelSolution(this.getClassModel(), settings);
		return clone;
	}

	public ClassModel getClassModel() {
		return classModel;
	}

	@Override
	public String toString() {
		// relies on EGraphImpl.toString();
		return new EGraphImpl(getClassModel()).toString();  
	}
	
	public List<String> getHistory(){
		return historyOfAppliedTransformations;
	}

	public List<Unit> getLastMutations() {
		return lastMutations;
	}

	public Settings getSettings() {
		return settings;
	}
}
