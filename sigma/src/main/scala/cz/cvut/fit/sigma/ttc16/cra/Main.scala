package cz.cvut.fit.sigma.ttc16.cra

import java.io.File

import at.ac.tuwien.big.momot.examples.modularization.ttc.CRAIndexCalculator
import at.ac.tuwien.big.momot.examples.modularization.ttc.CRAIndexCalculator.{calculateCRAIndex, printCorrectnessInfo, printGeneralInfo, printOptimalityInfo}
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support.Architecture
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support.Architecture._architecture._
import fr.unice.i3s.sigma.emf.util.EMFUtils

object Main extends App with Architecture {

  if (args.length != 2) {
    println(s"Missing required parameters: <path/to/input.xmi> <path/to/output.xmi>")
    sys.exit(1)
  }

  EMFUtils.IO.registerDefaultFactories()
  CRAIndexCalculator.registerPackage()

  val algorithm = System.getProperty("algorithm", "NSGAIII")
  val numRuns = System.getProperty("numRuns", "10").toInt
  val input = new File(args(0))
  val output = new File(args(1))
  val initModel = EMFUtils.IO.loadFromFile[ClassModel](input)
  val solver = algorithm match {
    case "NSGAIII" => new Solvers.NSGAIII(initModel)
    case "SPEA2" => new Solvers.SPEA2(initModel)
    case x => throw new IllegalArgumentException("Unsupported algorithm " + x)
  }

  println(s"Solving ${input.getCanonicalPath} using $solver (running $numRuns)")

  val solution = profile[ClassModel]((time, _) => s"Solved all in $time ms\n", optimize(numRuns, initModel))

  printGeneralInfo(solution)
  printCorrectnessInfo(solution)
  printOptimalityInfo(solution)

  EMFUtils.IO.saveToFile(output, Some(solution))

  println(s"Output written to ${output.getCanonicalPath}")

  private def optimize(numRuns: Int, initModel: ClassModel): ClassModel = {
    (1 to numRuns)
      .map (x => profile[ClassModel](
                    (time, res) => s"Solved $x/$numRuns in $time ms (CRA: ${calculateCRAIndex(res)})", solver()))
      .maxBy(calculateCRAIndex)
  }

  private def profile[A](message: (Long, A) => String, thunk: => A): A = {
    val time = System.currentTimeMillis()
    val result = thunk

    println(message(System.currentTimeMillis() - time, result))

    result
  }
}
