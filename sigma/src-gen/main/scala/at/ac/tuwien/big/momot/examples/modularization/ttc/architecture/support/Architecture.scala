package at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.support

import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ArchitecturePackage;
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Attribute;
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ClassModel;
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Feature;
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Method;
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.NamedElement;

import fr.unice.i3s.sigma.emf.support.EMFBuilder;
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;
import fr.unice.i3s.sigma.emf.support.SigmaEcorePackage;

import org.eclipse.emf.common.util.EList;

import scala.Option;


trait Architecture
  extends EMFScalaSupport {
    
    implicit class ClassModel2Sigma(that: ClassModel) {
      def classes: EList[at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class] = that.getClasses
      def features: EList[Feature] = that.getFeatures
    }
    implicit class Class2Sigma(that: at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class) {
      def encapsulates: EList[Feature] = that.getEncapsulates
    }
    
    implicit class Method2Sigma(that: Method) {
      def dataDependency: EList[Attribute] = that.getDataDependency
      def functionalDependency: EList[Method] = that.getFunctionalDependency
    }
    implicit class Feature2Sigma(that: Feature) {
      def isEncapsulatedBy: Option[at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class] = Option(that.getIsEncapsulatedBy)
      def isEncapsulatedBy_=(value: at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class): Unit = that.setIsEncapsulatedBy(value)
      def isEncapsulatedBy_=(value: ⇒ Option[at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class]): Unit =
        that.setIsEncapsulatedBy(Architecture._architectureBuilder.ref(value))
    }
    implicit class NamedElement2Sigma(that: NamedElement) {
      def name: String = that.getName
      def name_=(value: String): Unit = that.setName(value)
    }
    
    object _architecture extends SigmaEcorePackage[ArchitecturePackage] with
      ClassModelScalaSupport with
      ClassScalaSupport with
      AttributeScalaSupport with
      MethodScalaSupport with
      FeatureScalaSupport with
      NamedElementScalaSupport {
      
      val ePackage = ArchitecturePackage.eINSTANCE
    }}
object Architecture extends Architecture {
  private[this] val ePackage = ArchitecturePackage.eINSTANCE
  
  protected[support] val _architectureBuilder = new EMFBuilder(ePackage)
}