package at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support

import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Feature;

import fr.unice.i3s.sigma.emf.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait ClassScalaSupport extends EMFScalaSupport {
  type Class = at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class
  
  protected implicit val _classProxyBuilder = new EMFProxyBuilder[Class](Architecture._architectureBuilder)
  
  object Class {
    def apply(name: String = null, encapsulates: EList[Feature] = null): Class = {
      val _instance = Architecture._architectureBuilder.create[Class]
      
      if (name != null) _instance.setName(name)
      if (encapsulates != null) _instance.getEncapsulates.addAll(encapsulates)
      
      _instance
    }
  }}
object ClassScalaSupport extends ClassScalaSupport
