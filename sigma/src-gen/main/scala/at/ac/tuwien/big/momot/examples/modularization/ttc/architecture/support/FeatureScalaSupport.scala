package at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support

import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Feature;

import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

trait FeatureScalaSupport extends EMFScalaSupport {
  type Feature = at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Feature
  
  object Feature {
  }}
object FeatureScalaSupport extends FeatureScalaSupport
