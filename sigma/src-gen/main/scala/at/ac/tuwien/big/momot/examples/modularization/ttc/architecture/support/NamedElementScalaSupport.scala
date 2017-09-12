package at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support

import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.NamedElement;

import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

trait NamedElementScalaSupport extends EMFScalaSupport {
  type NamedElement = at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.NamedElement
  
  object NamedElement {
  }}
object NamedElementScalaSupport extends NamedElementScalaSupport
