import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;

public interface ControllerInterface
{
  public void addClassModel(ClassModel oo);
    public void killClassModel(ClassModel classmodelxx);
 public void setclasses(ClassModel classmodelx,List classesxx);
   public void addclasses(ClassModel classmodelx,UMLClass classesxx);
   public void removeclasses(ClassModel classmodelx,UMLClass classesxx);
   public void setfeatures(ClassModel classmodelx,List featuresxx);
   public void addfeatures(ClassModel classmodelx,Feature featuresxx);
   public void removefeatures(ClassModel classmodelx,Feature featuresxx);
    public void addUMLClass(UMLClass oo);
    public void killUMLClass(UMLClass umlclassxx);
 public void setencapsulates(UMLClass umlclassx,List encapsulatesxx);
   public void addencapsulates(UMLClass umlclassx,Feature encapsulatesxx);
   public void removeencapsulates(UMLClass umlclassx,Feature encapsulatesxx);
    public void addAttribute(Attribute oo);
    public void killAttribute(Attribute attributexx);
  public void addUMLMethod(UMLMethod oo);
    public void killUMLMethod(UMLMethod umlmethodxx);
 public void setdataDependency(UMLMethod umlmethodx,List dataDependencyxx);
   public void adddataDependency(UMLMethod umlmethodx,Attribute dataDependencyxx);
   public void removedataDependency(UMLMethod umlmethodx,Attribute dataDependencyxx);
   public void setfunctionalDependency(UMLMethod umlmethodx,List functionalDependencyxx);
   public void addfunctionalDependency(UMLMethod umlmethodx,UMLMethod functionalDependencyxx);
   public void removefunctionalDependency(UMLMethod umlmethodx,UMLMethod functionalDependencyxx);
    public void addFeature(Feature oo);
    public void killFeature(Feature featurexx);
  public void killAbstractFeature(Feature featurexx);

  public void killAbstractFeature(List featurexx);

 public void setisEncapsulatedBy(Feature featurex,List isEncapsulatedByxx);
   public void addisEncapsulatedBy(Feature featurex,UMLClass isEncapsulatedByxx);
   public void removeisEncapsulatedBy(Feature featurex,UMLClass isEncapsulatedByxx);
    public void addNamedElement(NamedElement oo);
    public void killNamedElement(NamedElement namedelementxx);
  public void killAbstractNamedElement(NamedElement namedelementxx);

  public void killAbstractNamedElement(List namedelementxx);

  public void addGeneticAlgorithm(GeneticAlgorithm oo);
    public void killGeneticAlgorithm(GeneticAlgorithm geneticalgorithmxx);
 public void setpopulation(GeneticAlgorithm geneticalgorithmx,List populationxx);
   public void addpopulation(GeneticAlgorithm geneticalgorithmx,GAIndividual populationxx);
   public void removepopulation(GeneticAlgorithm geneticalgorithmx,GAIndividual populationxx);
   public void setelite(GeneticAlgorithm geneticalgorithmx,List elitexx);
   public void addelite(GeneticAlgorithm geneticalgorithmx,GAIndividual elitexx);
   public void removeelite(GeneticAlgorithm geneticalgorithmx,GAIndividual elitexx);
   public void setrecombined(GeneticAlgorithm geneticalgorithmx,List recombinedxx);
   public void addrecombined(GeneticAlgorithm geneticalgorithmx,GAIndividual recombinedxx);
   public void removerecombined(GeneticAlgorithm geneticalgorithmx,GAIndividual recombinedxx);
   public void setmutated(GeneticAlgorithm geneticalgorithmx,List mutatedxx);
   public void addmutated(GeneticAlgorithm geneticalgorithmx,GAIndividual mutatedxx);
   public void removemutated(GeneticAlgorithm geneticalgorithmx,GAIndividual mutatedxx);
    public void addGAIndividual(GAIndividual oo);
    public void killGAIndividual(GAIndividual gaindividualxx);
 public void settraits(GAIndividual gaindividualx,List traitsxx);
   public void addtraits(GAIndividual gaindividualx,GATrait traitsxx);
   public void removetraits(GAIndividual gaindividualx,GATrait traitsxx);
    public void addGATrait(GATrait oo);
    public void killGATrait(GATrait gatraitxx);
  public void addCreateClasses(CreateClasses oo);
    public void killCreateClasses(CreateClasses createclassesxx);
  public void addRefactor(Refactor oo);
    public void killRefactor(Refactor refactorxx);
  public void addCleanup(Cleanup oo);
    public void killCleanup(Cleanup cleanupxx);
  public void addMeasures(Measures oo);
    public void killMeasures(Measures measuresxx);
  public void addPreprocess(Preprocess oo);
    public void killPreprocess(Preprocess preprocessxx);
  public void addEvolve(Evolve oo);
    public void killEvolve(Evolve evolvexx);
  public void addNextgeneration(Nextgeneration oo);
    public void killNextgeneration(Nextgeneration nextgenerationxx);
  public void addInitialise(Initialise oo);
    public void killInitialise(Initialise initialisexx);
  public void addPostprocess(Postprocess oo);
    public void killPostprocess(Postprocess postprocessxx);
  public void addGa(Ga oo);
    public void killGa(Ga gaxx);
  public void addCreateClasses1(CreateClasses1 oo);
    public void killCreateClasses1(CreateClasses1 createclasses1xx);
}

