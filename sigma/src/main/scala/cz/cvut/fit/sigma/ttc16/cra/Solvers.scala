package cz.cvut.fit.sigma.ttc16.cra

import at.ac.tuwien.big.momot.examples.modularization.ttc.CRAIndexCalculator
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support.Architecture
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support.Architecture._architecture._
import org.moeaframework.Executor
import org.moeaframework.core.NondominatedPopulation

import scala.collection.JavaConversions._

object Solvers extends Architecture {

  trait Solver {
    val populationSize = System.getProperty("populationSize", "64").toInt
    val maxEvaluations = System.getProperty("maxEvaluation", "10000").toInt

    def initModel: ClassModel

    def apply(): ClassModel =
      run()
        .map(x => CRAProblem.solutionToClassModel(initModel, x))
        .maxBy(CRAIndexCalculator.calculateCRAIndex)

    protected def run(): NondominatedPopulation

    protected def create(): Executor =
      new Executor()
        .withProblemClass(classOf[CRAProblem], initModel)
        .withProperty("populationSize", populationSize)
        .distributeOnAllCores()
        .withMaxEvaluations(maxEvaluations)
  }

  class NSGAIII(val initModel: ClassModel) extends Solver {
    private val mutationRate = 1.0 / initModel.features.size
    private val crossoverRate = .7

    override protected def run() =
      create()
        .withAlgorithm("NSGAIII")
        .withProperty("pm.rate", mutationRate)
        .withProperty("sbx.rate", crossoverRate)
        .run()

    override def toString = s"NSGAIII (" +
      s"populationSize=$populationSize, " +
      s"mutationRate=$mutationRate, " +
      s"crossoverRate=$crossoverRate)"
  }

  class SPEA2(val initModel: ClassModel) extends Solver {
    val archiveSize = System.getProperty("archiveSize", "32").toInt

    override protected def run() =
      create()
        .withAlgorithm("SPEA2")
        .withProperty("archiveSize", archiveSize)
        .run()

    override def toString = s"SPEA2 (" +
      s"populationSize=$populationSize, " +
      s"archiveSize=$archiveSize)"
  }
}
