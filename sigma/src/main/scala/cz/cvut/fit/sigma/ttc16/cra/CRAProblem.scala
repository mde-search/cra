package cz.cvut.fit.sigma.ttc16.cra

import at.ac.tuwien.big.momot.examples.modularization.ttc.CRAIndexCalculator
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support.Architecture._
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support.ClassModelScalaSupport.ClassModel
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support.ClassScalaSupport.Class
import org.moeaframework.core.Solution
import org.moeaframework.core.variable.EncodingUtils
import org.moeaframework.core.variable.EncodingUtils.newInt
import org.moeaframework.problem.AbstractProblem

object CRAProblem {
  def solutionToClassModel(initModel: ClassModel, solution: Solution): ClassModel = {
    val model = initModel.sCopy
    val rawSolution = EncodingUtils.getInt(solution)
    val classes = (0 to rawSolution.max) map (x => Class(name = s"Class $x"))

    rawSolution.zipWithIndex.foreach {
      case (classIdx, featureIdx) => model.features(featureIdx).isEncapsulatedBy = classes(classIdx)
    }

    model.classes ++= classes filterNot (x => x.getEncapsulates.isEmpty)
    model
  }
}

class CRAProblem(val initModel: ClassModel) extends AbstractProblem(initModel.features.size, 2) {

  override def newSolution(): Solution = {
    val solution = new Solution(numberOfVariables, numberOfObjectives)

    (0 until numberOfVariables) foreach (x => solution.setVariable(x, newInt(0, numberOfVariables - 1)))

    solution
  }

  override def evaluate(solution: Solution): Unit = {
    val model = CRAProblem.solutionToClassModel(initModel, solution)

    // minimize coupling
    solution.setObjective(0, CRAIndexCalculator.calculateCoupling(model))
    // maximize cohesion
    solution.setObjective(1, -CRAIndexCalculator.calculateCohesion(model))
  }
}
