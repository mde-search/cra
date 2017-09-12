package at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support

import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ClassModel;
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Feature;

import fr.unice.i3s.sigma.emf.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait ClassModelScalaSupport extends EMFScalaSupport {
  type ClassModel = at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ClassModel
  
  protected implicit val _classmodelProxyBuilder = new EMFProxyBuilder[ClassModel](Architecture._architectureBuilder)
  
  object ClassModel {
    def apply(name: String = null, classes: EList[at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class] = null, features: EList[Feature] = null): ClassModel = {
      val _instance = Architecture._architectureBuilder.create[ClassModel]
      
      if (name != null) _instance.setName(name)
      if (classes != null) _instance.getClasses.addAll(classes)
      if (features != null) _instance.getFeatures.addAll(features)
      
      _instance
    }
  }}
object ClassModelScalaSupport extends ClassModelScalaSupport
