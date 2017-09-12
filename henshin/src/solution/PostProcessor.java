package solution;

import java.util.List;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.interpreter.util.InterpreterUtil;
import org.eclipse.emf.henshin.model.Rule;
import architectureCRA.ClassModel;

public class PostProcessor {
	
	
	private static Rule moveOnceReferencedAttrToItsMethodUnit;
	
	private static Rule getMoveAttributeToReferencingMethodUnitUnit() {
		if (moveOnceReferencedAttrToItsMethodUnit == null) {	
			moveOnceReferencedAttrToItsMethodUnit = (Rule) Mutator.getMoveOnceReferencedAttrToItsMethodUnit();
		}
		return moveOnceReferencedAttrToItsMethodUnit;
	}

	public static EGraph postProcess_moveAttributeToReferencingMethod(ClassModel classModel) {

		Engine engine = Utility.getEngine();
		RuleApplication app = new RuleApplicationImpl(engine);
		EGraphImpl graph = new EGraphImpl(classModel);
		app.setEGraph(graph);
		app.setRule(getMoveAttributeToReferencingMethodUnitUnit());
		ClassModel intermediateClassModel;
		intermediateClassModel = Utility.getClassModelCopy((ClassModel) graph.getRoots().get(0));
		double cRAIndexBeforePostProcess = CRAIndexCalculator.calculateCRAIndex(classModel);
		List<Match> findAllMatches = InterpreterUtil.findAllMatches(engine, getMoveAttributeToReferencingMethodUnitUnit(), graph, null);
		for(Match match : findAllMatches){
			app.setPartialMatch(match);
			app.execute(null);
		}
		double cRAIndexAfterPostProcess = CRAIndexCalculator.calculateCRAIndex(classModel);
//		System.err.println("PostProcess lonelyMethod - before: "+cRAIndexBeforePostProcess+" after: "+cRAIndexAfterPostProcess);
		
		if(cRAIndexBeforePostProcess > cRAIndexAfterPostProcess){
			graph = new EGraphImpl(intermediateClassModel);
		}
		return graph;
	}

}
