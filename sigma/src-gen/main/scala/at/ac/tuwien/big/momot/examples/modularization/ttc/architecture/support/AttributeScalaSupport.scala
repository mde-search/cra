package at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support

import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Attribute;

import fr.unice.i3s.sigma.emf.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

trait AttributeScalaSupport extends EMFScalaSupport {
  type Attribute = at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Attribute
  
  protected implicit val _attributeProxyBuilder = new EMFProxyBuilder[Attribute](Architecture._architectureBuilder)
  
  object Attribute {
    def apply(name: String = null, isEncapsulatedBy: at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class = null): Attribute = {
      val _instance = Architecture._architectureBuilder.create[Attribute]
      
      if (name != null) _instance.setName(name)
      if (isEncapsulatedBy != null) _instance.setIsEncapsulatedBy(isEncapsulatedBy)
      
      _instance
    }
  }}
object AttributeScalaSupport extends AttributeScalaSupport
