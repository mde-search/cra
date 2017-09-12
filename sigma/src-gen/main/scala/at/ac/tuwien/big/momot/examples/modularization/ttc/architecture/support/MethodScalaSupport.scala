package at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support

import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Attribute;
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Method;

import fr.unice.i3s.sigma.emf.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait MethodScalaSupport extends EMFScalaSupport {
  type Method = at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Method
  
  protected implicit val _methodProxyBuilder = new EMFProxyBuilder[Method](Architecture._architectureBuilder)
  
  object Method {
    def apply(name: String = null, isEncapsulatedBy: at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class = null, dataDependency: EList[Attribute] = null, functionalDependency: EList[Method] = null): Method = {
      val _instance = Architecture._architectureBuilder.create[Method]
      
      if (name != null) _instance.setName(name)
      if (isEncapsulatedBy != null) _instance.setIsEncapsulatedBy(isEncapsulatedBy)
      if (dataDependency != null) _instance.getDataDependency.addAll(dataDependency)
      if (functionalDependency != null) _instance.getFunctionalDependency.addAll(functionalDependency)
      
      _instance
    }
  }}
object MethodScalaSupport extends MethodScalaSupport
