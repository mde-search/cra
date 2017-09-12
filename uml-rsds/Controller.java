import java.util.List;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;

import java.lang.*;
import java.lang.reflect.*;
import java.util.StringTokenizer;
import java.io.*;



class ClassModel
  extends NamedElement
  implements SystemTypes
{
  private List classes = new Vector(); // of UMLClass
  private List features = new Vector(); // of Feature

  public ClassModel()
  {

  }



  public String toString()
  { String _res_ = "(ClassModel) ";
    return _res_ + super.toString();
  }

  public static ClassModel parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    ClassModel classmodelx = new ClassModel();
    return classmodelx;
  }


  public void writeCSV(PrintWriter _out)
  { ClassModel classmodelx = this;
    _out.println();
  }


  public void setclasses(List classesxx) { classes = classesxx;
    }
 
  public void addclasses(UMLClass classesxx) { classes.add(classesxx);
    }
 
  public void removeclasses(UMLClass classesxx) { Vector _removedclassesclassesxx = new Vector();
  _removedclassesclassesxx.add(classesxx);
  classes.removeAll(_removedclassesclassesxx);
    }

  public static void setAllclasses(List classmodels,List _val)
  { for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      Controller.inst().setclasses(classmodelx, _val); } }

  public static void addAllclasses(List classmodels,UMLClass _val)
  { for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      Controller.inst().addclasses(classmodelx, _val); } }


  public static void removeAllclasses(List classmodels,UMLClass _val)
  { for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      Controller.inst().removeclasses(classmodelx, _val); } }


  public static void unionAllclasses(List classmodels, List _val)
  { for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      Controller.inst().unionclasses(classmodelx, _val); } }


  public static void subtractAllclasses(List classmodels, List _val)
  { for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      Controller.inst().subtractclasses(classmodelx, _val); } }


  public void setfeatures(List featuresxx) { features = featuresxx;
    }
 
  public void addfeatures(Feature featuresxx) { features.add(featuresxx);
    }
 
  public void removefeatures(Feature featuresxx) { Vector _removedfeaturesfeaturesxx = new Vector();
  _removedfeaturesfeaturesxx.add(featuresxx);
  features.removeAll(_removedfeaturesfeaturesxx);
    }

  public static void setAllfeatures(List classmodels,List _val)
  { for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      Controller.inst().setfeatures(classmodelx, _val); } }

  public static void addAllfeatures(List classmodels,Feature _val)
  { for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      Controller.inst().addfeatures(classmodelx, _val); } }


  public static void removeAllfeatures(List classmodels,Feature _val)
  { for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      Controller.inst().removefeatures(classmodelx, _val); } }


  public static void unionAllfeatures(List classmodels, List _val)
  { for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      Controller.inst().unionfeatures(classmodelx, _val); } }


  public static void subtractAllfeatures(List classmodels, List _val)
  { for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      Controller.inst().subtractfeatures(classmodelx, _val); } }


  public List getclasses() { return (Vector) ((Vector) classes).clone(); }

  public static List getAllclasses(List classmodels)
  { List result = new Vector();
    for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      result = Set.union(result,classmodelx.getclasses()); }
    return result; }

  public static List getAllOrderedclasses(List classmodels)
  { List result = new Vector();
    for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      result = Set.union(result,classmodelx.getclasses()); }
    return result; }

  public List getfeatures() { return (Vector) ((Vector) features).clone(); }

  public static List getAllfeatures(List classmodels)
  { List result = new Vector();
    for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      result = Set.union(result,classmodelx.getfeatures()); }
    return result; }

  public static List getAllOrderedfeatures(List classmodels)
  { List result = new Vector();
    for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx = (ClassModel) classmodels.get(_i);
      result = Set.union(result,classmodelx.getfeatures()); }
    return result; }

    public static int mmi(UMLClass ci,UMLClass cj)
  {   int result = 0;
 
  result = Set.sumint(Set.collect_1(Set.select_0(ci.getencapsulates()),cj));
    return result;
  }


    public static int mai(UMLClass ci,UMLClass cj)
  {   int result = 0;
 
  result = Set.sumint(Set.collect_2(Set.select_0(ci.getencapsulates()),cj));
    return result;
  }


    public static double cohesion(UMLClass ci)
  {   double result = 0;
 
  int nmethods = (Set.select_3(ci.getencapsulates())).size(); 
     int natts = (Set.select_4(ci.getencapsulates())).size(); 
     if (nmethods == 0) 
  {   result = 0;
 
  }  else
      {   if (nmethods > 1 && natts == 0) 
  {   result = ClassModel.mmi(ci,ci) / ( 1.0 * nmethods * ( nmethods - 1 ) );
 
  }  else
      {   if (natts != 0 && nmethods == 1) 
  {   result = ClassModel.mai(ci,ci) / ( 1.0 * natts );
 
  }  else
      if (nmethods > 1 && natts != 0) 
  {   result = ( ClassModel.mai(ci,ci) / ( 1.0 * nmethods * natts ) + ClassModel.mmi(ci,ci) / ( 1.0 * nmethods * ( nmethods - 1 ) ) );
 
  }   
   } 
   }           return result;
  }


    public static double coupling(UMLClass ci,UMLClass cj)
  {   double result = 0;
 
  int nmethodsi = (Set.select_3(ci.getencapsulates())).size(); 
     int nattsj = (Set.select_4(cj.getencapsulates())).size(); 
     int nmethodsj = (Set.select_3(cj.getencapsulates())).size(); 
     if (nmethodsi == 0) 
  {   result = 0;
 
  }  else
      {   if (nmethodsi != 0 && nattsj == 0 && nmethodsj <= 1) 
  {   result = 0;
 
  }  else
      {   if (nmethodsi != 0 && nattsj == 0 && nmethodsj > 1) 
  {   result = ClassModel.mmi(ci,cj) / ( 1.0 * nmethodsi * ( nmethodsj - 1 ) );
 
  }  else
      {   if (nmethodsi != 0 && nattsj != 0 && nmethodsj <= 1) 
  {   result = ClassModel.mai(ci,cj) / ( 1.0 * nmethodsi * nattsj );
 
  }  else
      if (nmethodsi != 0 && nattsj != 0 && nmethodsj > 1) 
  {   result = ( ClassModel.mai(ci,cj) / ( 1.0 * nmethodsi * nattsj ) ) + ( ClassModel.mmi(ci,cj) / ( 1.0 * nmethodsi * ( nmethodsj - 1 ) ) );
 
  }   
   } 
   } 
   }              return result;
  }


    public static double cohesionratio()
  {   double result = 0;
 
  result = Set.sumdouble(Set.collect_5(Controller.inst().umlclasss));
    return result;
  }


    public static double couplingratio()
  {   double result = 0;
 
  result = Set.sumdouble(Set.collect_7(Controller.inst().umlclasss));
    return result;
  }


    public static int dma(String mi,String aj)
  {   int result = 0;
  Object _cached_result = dma_cache.get(mi + ", " + aj);
  if (_cached_result != null)
  { result = ((Integer) _cached_result).intValue(); 
    return result; 
  }
  else 
  {   if (Controller.inst().getUMLMethodByPK(mi).getdataDependency().contains(Controller.inst().getAttributeByPK(aj))) 
  {   result = 1;
 
  }
    dma_cache.put(mi + ", " + aj, new Integer(result));
  }
  return result;
 }


    public static int dmm(String mi,String mj)
  {   int result = 0;
  Object _cached_result = dmm_cache.get(mi + ", " + mj);
  if (_cached_result != null)
  { result = ((Integer) _cached_result).intValue(); 
    return result; 
  }
  else 
  {   if (Controller.inst().getUMLMethodByPK(mi).getfunctionalDependency().contains(Controller.inst().getUMLMethodByPK(mj))) 
  {   result = 1;
 
  }
    dmm_cache.put(mi + ", " + mj, new Integer(result));
  }
  return result;
 }


    public static boolean isAttribute(String n)
  {   boolean result = false;
  Object _cached_result = isAttribute_cache.get(n);
  if (_cached_result != null)
  { result = ((Boolean) _cached_result).booleanValue(); 
    return result; 
  }
  else 
  {   if (Set.collect_8(Controller.inst().attributes).contains(n)) 
  {   result = true;
 
  }
    isAttribute_cache.put(n, new Boolean(result));
  }
  return result;
 }


    public static boolean isMethod(String n)
  {   boolean result = false;
  Object _cached_result = isMethod_cache.get(n);
  if (_cached_result != null)
  { result = ((Boolean) _cached_result).booleanValue(); 
    return result; 
  }
  else 
  {   if (Set.collect_9(Controller.inst().umlmethods).contains(n)) 
  {   result = true;
 
  }
    isMethod_cache.put(n, new Boolean(result));
  }
  return result;
 }


    public void cleanup2()
  { Controller.inst().setclasses(this,Controller.inst().umlclasss);
    Controller.inst().setfeatures(this,Controller.inst().features);
  }

    public void measures1(UMLClass c)
  {   System.out.println("" + ( "CLASS " + c.getname() + " has " + c.getencapsulates().size() + " features, cohesion = " ));

      System.out.println("" + ClassModel.cohesion(c));

  }

    public void measures1outer()
  {  ClassModel classmodelx = this;
    List _range35 = new Vector();
  _range35.addAll(Controller.inst().umlclasss);
  for (int _i34 = 0; _i34 < _range35.size(); _i34++)
  { UMLClass c = (UMLClass) _range35.get(_i34);
       this.measures1(c);
  }
  }


    public void measures2()
  {   System.out.println("" + "Coupling ratio is: ");

      System.out.println("" + ClassModel.couplingratio());

  }

    public void measures3()
  {   System.out.println("" + "Cohesion ratio is: ");

      System.out.println("" + ClassModel.cohesionratio());

  }

    public void measures4()
  {   System.out.println("" + "CRA is: ");

      System.out.println("" + ( ClassModel.cohesionratio() - ClassModel.couplingratio() ));

  }

    public void initialise1(int nclasses)
  { GeneticAlgorithm ga = new GeneticAlgorithm();
    Controller.inst().addGeneticAlgorithm(ga);
    GeneticAlgorithm.setmaxvalue(nclasses);
    GeneticAlgorithm.setmaxpop(300);
  }

    public void initialise1outer()
  {  ClassModel classmodelx = this;
    int nclasses;
  nclasses = Controller.inst().umlclasss.size();
     this.initialise1(nclasses);

  }


  private static java.util.Map dma_cache = new java.util.HashMap();
  private static java.util.Map dmm_cache = new java.util.HashMap();
  private static java.util.Map isAttribute_cache = new java.util.HashMap();
  private static java.util.Map isMethod_cache = new java.util.HashMap();

}


class UMLClass
  extends NamedElement
  implements SystemTypes
{
  private List encapsulates = new Vector(); // of Feature

  public UMLClass()
  {

  }



  public String toString()
  { String _res_ = "(UMLClass) ";
    return _res_ + super.toString();
  }

  public static UMLClass parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    UMLClass umlclassx = new UMLClass();
    return umlclassx;
  }


  public void writeCSV(PrintWriter _out)
  { UMLClass umlclassx = this;
    _out.println();
  }


  public void setencapsulates(List encapsulatesxx) { encapsulates = encapsulatesxx;
    }
 
  public void addencapsulates(Feature encapsulatesxx) { encapsulates.add(encapsulatesxx);
    }
 
  public void removeencapsulates(Feature encapsulatesxx) { Vector _removedencapsulatesencapsulatesxx = new Vector();
  _removedencapsulatesencapsulatesxx.add(encapsulatesxx);
  encapsulates.removeAll(_removedencapsulatesencapsulatesxx);
    }

  public static void setAllencapsulates(List umlclasss,List _val)
  { for (int _i = 0; _i < umlclasss.size(); _i++)
    { UMLClass umlclassx = (UMLClass) umlclasss.get(_i);
      Controller.inst().setencapsulates(umlclassx, _val); } }

  public static void addAllencapsulates(List umlclasss,Feature _val)
  { for (int _i = 0; _i < umlclasss.size(); _i++)
    { UMLClass umlclassx = (UMLClass) umlclasss.get(_i);
      Controller.inst().addencapsulates(umlclassx, _val); } }


  public static void removeAllencapsulates(List umlclasss,Feature _val)
  { for (int _i = 0; _i < umlclasss.size(); _i++)
    { UMLClass umlclassx = (UMLClass) umlclasss.get(_i);
      Controller.inst().removeencapsulates(umlclassx, _val); } }


  public static void unionAllencapsulates(List umlclasss, List _val)
  { for (int _i = 0; _i < umlclasss.size(); _i++)
    { UMLClass umlclassx = (UMLClass) umlclasss.get(_i);
      Controller.inst().unionencapsulates(umlclassx, _val); } }


  public static void subtractAllencapsulates(List umlclasss, List _val)
  { for (int _i = 0; _i < umlclasss.size(); _i++)
    { UMLClass umlclassx = (UMLClass) umlclasss.get(_i);
      Controller.inst().subtractencapsulates(umlclassx, _val); } }


  public List getencapsulates() { return (Vector) ((Vector) encapsulates).clone(); }

  public static List getAllencapsulates(List umlclasss)
  { List result = new Vector();
    for (int _i = 0; _i < umlclasss.size(); _i++)
    { UMLClass umlclassx = (UMLClass) umlclasss.get(_i);
      result = Set.union(result,umlclassx.getencapsulates()); }
    return result; }

  public static List getAllOrderedencapsulates(List umlclasss)
  { List result = new Vector();
    for (int _i = 0; _i < umlclasss.size(); _i++)
    { UMLClass umlclassx = (UMLClass) umlclasss.get(_i);
      result = Set.union(result,umlclassx.getencapsulates()); }
    return result; }

    public void refactor1(Feature m,UMLClass c,List depends)
  { Controller.inst().addencapsulates(c,m);
  }

    public void refactor1outer()
  {  UMLClass umlclassx = this;
      List pre_encapsulates36 = new Vector();
    pre_encapsulates36.addAll(encapsulates);
  List _range38 = new Vector();
  _range38.addAll(pre_encapsulates36);
  for (int _i37 = 0; _i37 < _range38.size(); _i37++)
  { Feature m = (Feature) _range38.get(_i37);
       if ((m instanceof UMLMethod)) {   List _range40 = new Vector();
  _range40.addAll(Controller.inst().umlclasss);
  for (int _i39 = 0; _i39 < _range40.size(); _i39++)
  { UMLClass c = (UMLClass) _range40.get(_i39);
          List pre_encapsulates41 = new Vector();
    pre_encapsulates41.addAll(c.getencapsulates());

    List depends;
    depends = new Vector();
  depends.addAll(Set.union(((UMLMethod) m).getdataDependency(),((UMLMethod) m).getfunctionalDependency()));

     if ((Set.intersection(depends,pre_encapsulates41)).size() > (Set.intersection(depends,pre_encapsulates36)).size()) {    this.refactor1(m,c,depends); }


  } }

  }
  }


    public void refactor2(Feature a,UMLClass c,List dependings)
  { Controller.inst().addencapsulates(c,a);
  }

    public void refactor2outer()
  {  UMLClass umlclassx = this;
      List pre_encapsulates42 = new Vector();
    pre_encapsulates42.addAll(encapsulates);
  List _range44 = new Vector();
  _range44.addAll(pre_encapsulates42);
  for (int _i43 = 0; _i43 < _range44.size(); _i43++)
  { Feature a = (Feature) _range44.get(_i43);
       if ((a instanceof Attribute)) {   List _range46 = new Vector();
  _range46.addAll(Controller.inst().umlclasss);
  for (int _i45 = 0; _i45 < _range46.size(); _i45++)
  { UMLClass c = (UMLClass) _range46.get(_i45);
          List pre_encapsulates47 = new Vector();
    pre_encapsulates47.addAll(c.getencapsulates());

    List dependings;
    dependings = new Vector();
  dependings.addAll(Set.select_10(Controller.inst().umlmethods,a));

     if ((Set.intersection(dependings,pre_encapsulates47)).size() > (Set.intersection(dependings,pre_encapsulates42)).size()) {    this.refactor2(a,c,dependings); }


  } }

  }
  }


    public void cleanup1()
  {   //  if (encapsulates.size() != 0)) { return; } 
  Controller.inst().killUMLClass(this);
  }

    public boolean cleanup1test()
  {  boolean result;
UMLClass umlclassx = this;
     if (umlclassx.getencapsulates().size() == 0) {   return true; }

    return false;

  }


    public static boolean cleanup1search()
  {  boolean result;
  List _range49 = new Vector();
  _range49.addAll(Controller.inst().umlclasss);
  for (int _i48 = 0; _i48 < _range49.size(); _i48++)
  { UMLClass umlclassx = (UMLClass) _range49.get(_i48);
       if (umlclassx.cleanup1test()) {    Controller.inst().cleanup1(umlclassx);
    return true;
 }

  }
    return false;

  }



}


class Attribute
  extends Feature
  implements SystemTypes
{

  public Attribute()
  {

  }



  public String toString()
  { String _res_ = "(Attribute) ";
    return _res_ + super.toString();
  }

  public static Attribute parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    Attribute attributex = new Attribute();
    return attributex;
  }


  public void writeCSV(PrintWriter _out)
  { Attribute attributex = this;
    _out.println();
  }


    public void createclasses2()
  {   if ((Set.select_11(Controller.inst().umlmethods,this, this)).size() == 0) 
  {   if (Controller.inst().getUMLClassByPK("Class0") != null)
    { UMLClass c = Controller.inst().getUMLClassByPK("Class0");
     Controller.inst().addencapsulates(c,this);
  }
    else
    { UMLClass c = new UMLClass();
    Controller.inst().addUMLClass(c);
    Controller.inst().setname(c,"Class0");
    Controller.inst().addencapsulates(c,this); }
}
  }


}


class UMLMethod
  extends Feature
  implements SystemTypes
{
  private List dataDependency = new Vector(); // of Attribute
  private List functionalDependency = new Vector(); // of UMLMethod

  public UMLMethod()
  {

  }



  public String toString()
  { String _res_ = "(UMLMethod) ";
    return _res_ + super.toString();
  }

  public static UMLMethod parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    UMLMethod umlmethodx = new UMLMethod();
    return umlmethodx;
  }


  public void writeCSV(PrintWriter _out)
  { UMLMethod umlmethodx = this;
    _out.println();
  }


  public void setdataDependency(List dataDependencyxx) { dataDependency = dataDependencyxx;
    }
 
  public void adddataDependency(Attribute dataDependencyxx) { dataDependency.add(dataDependencyxx);
    }
 
  public void removedataDependency(Attribute dataDependencyxx) { Vector _removeddataDependencydataDependencyxx = new Vector();
  _removeddataDependencydataDependencyxx.add(dataDependencyxx);
  dataDependency.removeAll(_removeddataDependencydataDependencyxx);
    }

  public static void setAlldataDependency(List umlmethods,List _val)
  { for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      Controller.inst().setdataDependency(umlmethodx, _val); } }

  public static void addAlldataDependency(List umlmethods,Attribute _val)
  { for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      Controller.inst().adddataDependency(umlmethodx, _val); } }


  public static void removeAlldataDependency(List umlmethods,Attribute _val)
  { for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      Controller.inst().removedataDependency(umlmethodx, _val); } }


  public static void unionAlldataDependency(List umlmethods, List _val)
  { for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      Controller.inst().uniondataDependency(umlmethodx, _val); } }


  public static void subtractAlldataDependency(List umlmethods, List _val)
  { for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      Controller.inst().subtractdataDependency(umlmethodx, _val); } }


  public void setfunctionalDependency(List functionalDependencyxx) { functionalDependency = functionalDependencyxx;
    }
 
  public void addfunctionalDependency(UMLMethod functionalDependencyxx) { functionalDependency.add(functionalDependencyxx);
    }
 
  public void removefunctionalDependency(UMLMethod functionalDependencyxx) { Vector _removedfunctionalDependencyfunctionalDependencyxx = new Vector();
  _removedfunctionalDependencyfunctionalDependencyxx.add(functionalDependencyxx);
  functionalDependency.removeAll(_removedfunctionalDependencyfunctionalDependencyxx);
    }

  public static void setAllfunctionalDependency(List umlmethods,List _val)
  { for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      Controller.inst().setfunctionalDependency(umlmethodx, _val); } }

  public static void addAllfunctionalDependency(List umlmethods,UMLMethod _val)
  { for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      Controller.inst().addfunctionalDependency(umlmethodx, _val); } }


  public static void removeAllfunctionalDependency(List umlmethods,UMLMethod _val)
  { for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      Controller.inst().removefunctionalDependency(umlmethodx, _val); } }


  public static void unionAllfunctionalDependency(List umlmethods, List _val)
  { for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      Controller.inst().unionfunctionalDependency(umlmethodx, _val); } }


  public static void subtractAllfunctionalDependency(List umlmethods, List _val)
  { for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      Controller.inst().subtractfunctionalDependency(umlmethodx, _val); } }


  public List getdataDependency() { return (Vector) ((Vector) dataDependency).clone(); }

  public static List getAlldataDependency(List umlmethods)
  { List result = new Vector();
    for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      result = Set.union(result,umlmethodx.getdataDependency()); }
    return result; }

  public static List getAllOrdereddataDependency(List umlmethods)
  { List result = new Vector();
    for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      result = Set.union(result,umlmethodx.getdataDependency()); }
    return result; }

  public List getfunctionalDependency() { return (Vector) ((Vector) functionalDependency).clone(); }

  public static List getAllfunctionalDependency(List umlmethods)
  { List result = new Vector();
    for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      result = Set.union(result,umlmethodx.getfunctionalDependency()); }
    return result; }

  public static List getAllOrderedfunctionalDependency(List umlmethods)
  { List result = new Vector();
    for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(_i);
      result = Set.union(result,umlmethodx.getfunctionalDependency()); }
    return result; }

    public List dependsOn(List seen)
  {   List result = new Vector();
 
  List directDeps = Set.subtract(( Set.union(dataDependency,functionalDependency) ),seen); 
     result = Set.union(directDeps,Set.unionAll(Set.collect_12(functionalDependency)));
       return result;
  }


    public void createclasses1()
  {   if (this.getdataDependency().size() == 0 && this.getfunctionalDependency().size() == 0) 
  {   if (Controller.inst().getUMLClassByPK("Class0") != null)
    { UMLClass c = Controller.inst().getUMLClassByPK("Class0");
     Controller.inst().addencapsulates(c,this);
  }
    else
    { UMLClass c = new UMLClass();
    Controller.inst().addUMLClass(c);
    Controller.inst().setname(c,"Class0");
    Controller.inst().addencapsulates(c,this); }
}
  }

    public void createclasses3(UMLClass c)
  { Controller.inst().addencapsulates(c,this);
  }

    public void createclasses3outer()
  {  UMLMethod umlmethodx = this;
     if (umlmethodx.getdataDependency().size() > 0) {   List _range51 = new Vector();
  _range51.addAll(Controller.inst().umlclasss);
  for (int _i50 = 0; _i50 < _range51.size(); _i50++)
  { UMLClass c = (UMLClass) _range51.get(_i50);
          List pre_encapsulates52 = new Vector();
    pre_encapsulates52.addAll(c.getencapsulates());

     if (pre_encapsulates52.containsAll(umlmethodx.getdataDependency())) {    this.createclasses3(c); }

  } }

  }


    public void createclasses4(List unencapdas)
  {     List pre_UMLClass53 = new Vector();
    pre_UMLClass53.addAll(Controller.inst().umlclasss);
  if (Controller.inst().getUMLClassByPK("Class" + ( pre_UMLClass53.size() + 1 )) != null)
    { UMLClass c = Controller.inst().getUMLClassByPK("Class" + ( pre_UMLClass53.size() + 1 ));
     Controller.inst().addencapsulates(c,this);
    Controller.inst().unionencapsulates(c,unencapdas);
  }
    else
    { UMLClass c = new UMLClass();
    Controller.inst().addUMLClass(c);
    Controller.inst().setname(c,"Class" + ( pre_UMLClass53.size() + 1 ));
    Controller.inst().addencapsulates(c,this);
    Controller.inst().unionencapsulates(c,unencapdas); }

  }

    public void createclasses4outer()
  {  UMLMethod umlmethodx = this;
     if (umlmethodx.getisEncapsulatedBy().size() == 0) {   List unencapdas;
    unencapdas = new Vector();
  unencapdas.addAll(Set.select_13(umlmethodx.getdataDependency()));

     if (Set.forAll_14(Controller.inst().umlmethods,unencapdas)) {    this.createclasses4(unencapdas); }

 }

  }


    public void createclasses5(UMLClass c)
  { Controller.inst().addencapsulates(c,this);
  }

    public void createclasses5outer()
  {  UMLMethod umlmethodx = this;
    List _range55 = new Vector();
  _range55.addAll(Controller.inst().umlclasss);
  for (int _i54 = 0; _i54 < _range55.size(); _i54++)
  { UMLClass c = (UMLClass) _range55.get(_i54);
          List pre_encapsulates56 = new Vector();
    pre_encapsulates56.addAll(c.getencapsulates());

     if (pre_encapsulates56.containsAll(umlmethodx.getdataDependency())) {    if (umlmethodx.getfunctionalDependency().size() > 0) {    if (pre_encapsulates56.containsAll(umlmethodx.getfunctionalDependency())) {    this.createclasses5(c); }
 }
 }

  }
  }


    public void createclasses11(List deps)
  {     
  if (Controller.inst().getUMLClassByPK(this.getname() + "Class") != null)
    { UMLClass c = Controller.inst().getUMLClassByPK(this.getname() + "Class");
         List _feature_list60 = new Vector();
    _feature_list60.addAll(deps);
    for (int _ind61 = 0; _ind61 < _feature_list60.size(); _ind61++)
    { Feature d = (Feature) _feature_list60.get(_ind61);
        List pre_isEncapsulatedBy57 = new Vector();
    pre_isEncapsulatedBy57.addAll(d.getisEncapsulatedBy());
    if ((pre_isEncapsulatedBy57.size() == 0)) 
  { Controller.inst().addencapsulates(c,d);}
    }

    Controller.inst().addencapsulates(c,this);
  }
    else
    { UMLClass c = new UMLClass();
    Controller.inst().addUMLClass(c);
    Controller.inst().setname(c,this.getname() + "Class");
        List _feature_list58 = new Vector();
    _feature_list58.addAll(deps);
    for (int _ind59 = 0; _ind59 < _feature_list58.size(); _ind59++)
    { Feature d = (Feature) _feature_list58.get(_ind59);
    List pre_isEncapsulatedBy57 = new Vector();
    pre_isEncapsulatedBy57.addAll(d.getisEncapsulatedBy());
    if ((pre_isEncapsulatedBy57.size() == 0)) 
  { Controller.inst().addencapsulates(c,d);}
    }

    Controller.inst().addencapsulates(c,this); }

  }

    public void createclasses11outer()
  {  UMLMethod umlmethodx = this;
      List pre_isEncapsulatedBy62 = new Vector();
    pre_isEncapsulatedBy62.addAll(isEncapsulatedBy);
   if ((pre_isEncapsulatedBy62.size() == 0)) {   List deps;
    deps = new Vector();
  deps.addAll(umlmethodx.dependsOn((new SystemTypes.Set()).add(this).getElements()));

     this.createclasses11(deps);
 }

  }



}


abstract class Feature
  extends NamedElement
  implements SystemTypes
{
  protected List isEncapsulatedBy = new Vector(); // of UMLClass

  public Feature()
  {

  }



  public String toString()
  { String _res_ = "(Feature) ";
    return _res_ + super.toString();
  }



  public void setisEncapsulatedBy(List isEncapsulatedByxx) { if (isEncapsulatedByxx.size() > 1) { return; } 
    isEncapsulatedBy = isEncapsulatedByxx;
  }
 
  public void addisEncapsulatedBy(UMLClass isEncapsulatedByxx) { if (isEncapsulatedBy.size() > 0) { return; } 
    isEncapsulatedBy.add(isEncapsulatedByxx);
    }
 
  public void removeisEncapsulatedBy(UMLClass isEncapsulatedByxx) { Vector _removedisEncapsulatedByisEncapsulatedByxx = new Vector();
  _removedisEncapsulatedByisEncapsulatedByxx.add(isEncapsulatedByxx);
  isEncapsulatedBy.removeAll(_removedisEncapsulatedByisEncapsulatedByxx);
    }

  public static void setAllisEncapsulatedBy(List features,List _val)
  { for (int _i = 0; _i < features.size(); _i++)
    { Feature featurex = (Feature) features.get(_i);
      Controller.inst().setisEncapsulatedBy(featurex, _val); } }

  public static void addAllisEncapsulatedBy(List features,UMLClass _val)
  { for (int _i = 0; _i < features.size(); _i++)
    { Feature featurex = (Feature) features.get(_i);
      Controller.inst().addisEncapsulatedBy(featurex, _val); } }


  public static void removeAllisEncapsulatedBy(List features,UMLClass _val)
  { for (int _i = 0; _i < features.size(); _i++)
    { Feature featurex = (Feature) features.get(_i);
      Controller.inst().removeisEncapsulatedBy(featurex, _val); } }


  public static void unionAllisEncapsulatedBy(List features, List _val)
  { for (int _i = 0; _i < features.size(); _i++)
    { Feature featurex = (Feature) features.get(_i);
      Controller.inst().unionisEncapsulatedBy(featurex, _val); } }


  public static void subtractAllisEncapsulatedBy(List features, List _val)
  { for (int _i = 0; _i < features.size(); _i++)
    { Feature featurex = (Feature) features.get(_i);
      Controller.inst().subtractisEncapsulatedBy(featurex, _val); } }


  public List getisEncapsulatedBy() { return (Vector) ((Vector) isEncapsulatedBy).clone(); }

  public static List getAllisEncapsulatedBy(List features)
  { List result = new Vector();
    for (int _i = 0; _i < features.size(); _i++)
    { Feature featurex = (Feature) features.get(_i);
      result = Set.union(result,featurex.getisEncapsulatedBy()); }
    return result; }

  public static List getAllOrderedisEncapsulatedBy(List features)
  { List result = new Vector();
    for (int _i = 0; _i < features.size(); _i++)
    { Feature featurex = (Feature) features.get(_i);
      result = Set.union(result,featurex.getisEncapsulatedBy()); }
    return result; }


}


abstract class NamedElement
  implements SystemTypes
{
  protected String name = ""; // internal

  public NamedElement()
  {
    this.name = "";

  }



  public String toString()
  { String _res_ = "(NamedElement) ";
    _res_ = _res_ + name;
    return _res_;
  }



  public void setname(String name_x) { name = name_x;  }


    public static void setAllname(List namedelements,String val)
  { for (int i = 0; i < namedelements.size(); i++)
    { NamedElement namedelementx = (NamedElement) namedelements.get(i);
      Controller.inst().setname(namedelementx,val); } }


    public String getname() { return name; }

    public static List getAllname(List namedelements)
  { List result = new Vector();
    for (int i = 0; i < namedelements.size(); i++)
    { NamedElement namedelementx = (NamedElement) namedelements.get(i);
      if (result.contains(namedelementx.getname())) { }
      else { result.add(namedelementx.getname()); } }
    return result; }

    public static List getAllOrderedname(List namedelements)
  { List result = new Vector();
    for (int i = 0; i < namedelements.size(); i++)
    { NamedElement namedelementx = (NamedElement) namedelements.get(i);
      result.add(namedelementx.getname()); } 
    return result; }


}



class GeneticAlgorithm
  implements SystemTypes
{
  private static double maxfitness = 0; // internal
  private static int maxvalue = 0; // internal
  private static int maxpop = 0; // internal
  private List population = new Vector(); // of GAIndividual
  private List elite = new Vector(); // of GAIndividual
  private List recombined = new Vector(); // of GAIndividual
  private List mutated = new Vector(); // of GAIndividual

  public GeneticAlgorithm()
  {
    this.maxfitness = 0;
    this.maxvalue = 0;
    this.maxpop = 0;

  }



  public String toString()
  { String _res_ = "(GeneticAlgorithm) ";
    _res_ = _res_ + maxfitness + ",";
    _res_ = _res_ + maxvalue + ",";
    _res_ = _res_ + maxpop;
    return _res_;
  }

  public static GeneticAlgorithm parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    GeneticAlgorithm geneticalgorithmx = new GeneticAlgorithm();
    geneticalgorithmx.maxfitness = Double.parseDouble((String) _line1vals.get(0));
    geneticalgorithmx.maxvalue = Integer.parseInt((String) _line1vals.get(1));
    geneticalgorithmx.maxpop = Integer.parseInt((String) _line1vals.get(2));
    return geneticalgorithmx;
  }


  public void writeCSV(PrintWriter _out)
  { GeneticAlgorithm geneticalgorithmx = this;
    _out.print("" + geneticalgorithmx.maxfitness);
    _out.print(" , ");
    _out.print("" + geneticalgorithmx.maxvalue);
    _out.print(" , ");
    _out.print("" + geneticalgorithmx.maxpop);
    _out.println();
  }


  public static void setmaxfitness(double maxfitness_x) { maxfitness = maxfitness_x; }

public void localSetmaxfitness(double maxfitness_x) {   }


    public static void setAllmaxfitness(List geneticalgorithms,double val)
  { for (int i = 0; i < geneticalgorithms.size(); i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(i);
      Controller.inst().setmaxfitness(geneticalgorithmx,val); } }


  public static void setmaxvalue(int maxvalue_x) { maxvalue = maxvalue_x; }

public void localSetmaxvalue(int maxvalue_x) {   }


    public static void setAllmaxvalue(List geneticalgorithms,int val)
  { for (int i = 0; i < geneticalgorithms.size(); i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(i);
      Controller.inst().setmaxvalue(geneticalgorithmx,val); } }


  public static void setmaxpop(int maxpop_x) { maxpop = maxpop_x; }

public void localSetmaxpop(int maxpop_x) {   }


    public static void setAllmaxpop(List geneticalgorithms,int val)
  { for (int i = 0; i < geneticalgorithms.size(); i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(i);
      Controller.inst().setmaxpop(geneticalgorithmx,val); } }


  public void setpopulation(List populationxx) { population = populationxx;
    }
 
  public void addpopulation(GAIndividual populationxx) { population.add(populationxx);
    }
 
  public void removepopulation(GAIndividual populationxx) { Vector _removedpopulationpopulationxx = new Vector();
  _removedpopulationpopulationxx.add(populationxx);
  population.removeAll(_removedpopulationpopulationxx);
    }

  public static void setAllpopulation(List geneticalgorithms,List _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().setpopulation(geneticalgorithmx, _val); } }

  public static void addAllpopulation(List geneticalgorithms,GAIndividual _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().addpopulation(geneticalgorithmx, _val); } }


  public static void removeAllpopulation(List geneticalgorithms,GAIndividual _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().removepopulation(geneticalgorithmx, _val); } }


  public static void unionAllpopulation(List geneticalgorithms, List _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().unionpopulation(geneticalgorithmx, _val); } }


  public static void subtractAllpopulation(List geneticalgorithms, List _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().subtractpopulation(geneticalgorithmx, _val); } }


  public void setelite(List elitexx) { elite = elitexx;
    }
 
  public void addelite(GAIndividual elitexx) { elite.add(elitexx);
    }
 
  public void removeelite(GAIndividual elitexx) { Vector _removedeliteelitexx = new Vector();
  _removedeliteelitexx.add(elitexx);
  elite.removeAll(_removedeliteelitexx);
    }

  public static void setAllelite(List geneticalgorithms,List _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().setelite(geneticalgorithmx, _val); } }

  public static void addAllelite(List geneticalgorithms,GAIndividual _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().addelite(geneticalgorithmx, _val); } }


  public static void removeAllelite(List geneticalgorithms,GAIndividual _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().removeelite(geneticalgorithmx, _val); } }


  public static void unionAllelite(List geneticalgorithms, List _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().unionelite(geneticalgorithmx, _val); } }


  public static void subtractAllelite(List geneticalgorithms, List _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().subtractelite(geneticalgorithmx, _val); } }


  public void setrecombined(List recombinedxx) { recombined = recombinedxx;
    }
 
  public void addrecombined(GAIndividual recombinedxx) { recombined.add(recombinedxx);
    }
 
  public void removerecombined(GAIndividual recombinedxx) { Vector _removedrecombinedrecombinedxx = new Vector();
  _removedrecombinedrecombinedxx.add(recombinedxx);
  recombined.removeAll(_removedrecombinedrecombinedxx);
    }

  public static void setAllrecombined(List geneticalgorithms,List _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().setrecombined(geneticalgorithmx, _val); } }

  public static void addAllrecombined(List geneticalgorithms,GAIndividual _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().addrecombined(geneticalgorithmx, _val); } }


  public static void removeAllrecombined(List geneticalgorithms,GAIndividual _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().removerecombined(geneticalgorithmx, _val); } }


  public static void unionAllrecombined(List geneticalgorithms, List _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().unionrecombined(geneticalgorithmx, _val); } }


  public static void subtractAllrecombined(List geneticalgorithms, List _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().subtractrecombined(geneticalgorithmx, _val); } }


  public void setmutated(List mutatedxx) { mutated = mutatedxx;
    }
 
  public void addmutated(GAIndividual mutatedxx) { mutated.add(mutatedxx);
    }
 
  public void removemutated(GAIndividual mutatedxx) { Vector _removedmutatedmutatedxx = new Vector();
  _removedmutatedmutatedxx.add(mutatedxx);
  mutated.removeAll(_removedmutatedmutatedxx);
    }

  public static void setAllmutated(List geneticalgorithms,List _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().setmutated(geneticalgorithmx, _val); } }

  public static void addAllmutated(List geneticalgorithms,GAIndividual _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().addmutated(geneticalgorithmx, _val); } }


  public static void removeAllmutated(List geneticalgorithms,GAIndividual _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().removemutated(geneticalgorithmx, _val); } }


  public static void unionAllmutated(List geneticalgorithms, List _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().unionmutated(geneticalgorithmx, _val); } }


  public static void subtractAllmutated(List geneticalgorithms, List _val)
  { for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      Controller.inst().subtractmutated(geneticalgorithmx, _val); } }


    public static double getmaxfitness() { return maxfitness; }

    public static List getAllmaxfitness(List geneticalgorithms)
  { List result = new Vector();
   if (geneticalgorithms.size() > 0)
   { result.add(new Double(GeneticAlgorithm.maxfitness)); }
    return result; }

    public static List getAllOrderedmaxfitness(List geneticalgorithms)
  { List result = new Vector();
    for (int i = 0; i < geneticalgorithms.size(); i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(i);
      result.add(new Double(geneticalgorithmx.getmaxfitness())); } 
    return result; }

    public static int getmaxvalue() { return maxvalue; }

    public static List getAllmaxvalue(List geneticalgorithms)
  { List result = new Vector();
   if (geneticalgorithms.size() > 0)
   { result.add(new Integer(GeneticAlgorithm.maxvalue)); }
    return result; }

    public static List getAllOrderedmaxvalue(List geneticalgorithms)
  { List result = new Vector();
    for (int i = 0; i < geneticalgorithms.size(); i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(i);
      result.add(new Integer(geneticalgorithmx.getmaxvalue())); } 
    return result; }

    public static int getmaxpop() { return maxpop; }

    public static List getAllmaxpop(List geneticalgorithms)
  { List result = new Vector();
   if (geneticalgorithms.size() > 0)
   { result.add(new Integer(GeneticAlgorithm.maxpop)); }
    return result; }

    public static List getAllOrderedmaxpop(List geneticalgorithms)
  { List result = new Vector();
    for (int i = 0; i < geneticalgorithms.size(); i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(i);
      result.add(new Integer(geneticalgorithmx.getmaxpop())); } 
    return result; }

  public List getpopulation() { return (Vector) ((Vector) population).clone(); }

  public static List getAllpopulation(List geneticalgorithms)
  { List result = new Vector();
    for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      result = Set.union(result,geneticalgorithmx.getpopulation()); }
    return result; }

  public static List getAllOrderedpopulation(List geneticalgorithms)
  { List result = new Vector();
    for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      result = Set.union(result,geneticalgorithmx.getpopulation()); }
    return result; }

  public List getelite() { return (Vector) ((Vector) elite).clone(); }

  public static List getAllelite(List geneticalgorithms)
  { List result = new Vector();
    for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      result = Set.union(result,geneticalgorithmx.getelite()); }
    return result; }

  public static List getAllOrderedelite(List geneticalgorithms)
  { List result = new Vector();
    for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      result = Set.union(result,geneticalgorithmx.getelite()); }
    return result; }

  public List getrecombined() { return (Vector) ((Vector) recombined).clone(); }

  public static List getAllrecombined(List geneticalgorithms)
  { List result = new Vector();
    for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      result = Set.union(result,geneticalgorithmx.getrecombined()); }
    return result; }

  public static List getAllOrderedrecombined(List geneticalgorithms)
  { List result = new Vector();
    for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      result = Set.union(result,geneticalgorithmx.getrecombined()); }
    return result; }

  public List getmutated() { return (Vector) ((Vector) mutated).clone(); }

  public static List getAllmutated(List geneticalgorithms)
  { List result = new Vector();
    for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      result = Set.union(result,geneticalgorithmx.getmutated()); }
    return result; }

  public static List getAllOrderedmutated(List geneticalgorithms)
  { List result = new Vector();
    for (int _i = 0; _i < geneticalgorithms.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(_i);
      result = Set.union(result,geneticalgorithmx.getmutated()); }
    return result; }

    public static int incrementValue(int v)
  {   int result = 0;
 
  if (v + 1 == maxvalue) 
  {   result = 1;
 
  }  else
      if (v + 1 != maxvalue) 
  {   result = ( v + 1 ) % maxvalue;
 
  }       return result;
  }


    public static boolean isUnfit(GAIndividual v)
  {   boolean result = false;
 
  double maxfit = GeneticAlgorithm.getmaxfitness(); 
     if (v.getfitnessval() < maxfit - 0.5 * Math.abs(maxfit) - 0.5) 
  {   result = true;
 
  }       return result;
  }


    public static boolean isElite(GAIndividual v)
  {   boolean result = false;
 
  double maxfit = GeneticAlgorithm.getmaxfitness(); 
     if (v.getfitnessval() >= maxfit - 0.2 * Math.abs(maxfit) - 0.2) 
  {   result = true;
 
  }       return result;
  }


    public static boolean isCombinable(GAIndividual p,GAIndividual q)
  {   boolean result = false;
 
  double maxfit = GeneticAlgorithm.getmaxfitness(); 
     if (p.getfitnessval() >= maxfit - 0.25 * Math.abs(maxfit) - 0.25 && q.getfitnessval() >= maxfit - 0.25 * Math.abs(maxfit) - 0.25) 
  {   result = true;
 
  }       return result;
  }


    public static boolean isMutatable(GAIndividual v)
  {   boolean result = false;
 
  double maxfit = GeneticAlgorithm.getmaxfitness(); 
     if (v.getfitnessval() >= maxfit - 0.5 * Math.abs(maxfit) - 0.5) 
  {   result = true;
 
  }       return result;
  }


    public void cull(List p,int n)
  { Controller.inst().setpopulation(this,Set.asSet(Set.subrange(p,n - GeneticAlgorithm.maxpop,n)));
    Controller.inst().killAllGAIndividual(Set.subrange(p,1,n - ( GeneticAlgorithm.maxpop + 1 )));
  }

    public void evolve1(GAIndividual p)
  { Controller.inst().killGAIndividual(p);
  }

    public void evolve1outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
      List pre_population63 = new Vector();
    pre_population63.addAll(population);
  List _range65 = new Vector();
  _range65.addAll(pre_population63);
  for (int _i64 = 0; _i64 < _range65.size(); _i64++)
  { GAIndividual p = (GAIndividual) _range65.get(_i64);
       if (GeneticAlgorithm.isUnfit(p)) {    this.evolve1(p); }

  }
  }


    public void evolve2(GAIndividual p)
  { Controller.inst().addelite(this,p);
  }

    public void evolve2outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
    List _range67 = new Vector();
  _range67.addAll(geneticalgorithmx.getpopulation());
  for (int _i66 = 0; _i66 < _range67.size(); _i66++)
  { GAIndividual p = (GAIndividual) _range67.get(_i66);
       if (GeneticAlgorithm.isElite(p)) {    this.evolve2(p); }

  }
  }


    public void evolve3(GAIndividual p,GAIndividual q)
  { Controller.inst().addrecombined(this,p.combine(q));
  }

    public void evolve3outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
    List _range69 = new Vector();
  _range69.addAll(geneticalgorithmx.getelite());
  for (int _i68 = 0; _i68 < _range69.size(); _i68++)
  { GAIndividual p = (GAIndividual) _range69.get(_i68);
      List _range71 = new Vector();
  _range71.addAll(geneticalgorithmx.getpopulation());
  for (int _i70 = 0; _i70 < _range71.size(); _i70++)
  { GAIndividual q = (GAIndividual) _range71.get(_i70);
       if (q.getfitnessval() < p.getfitnessval()) {    if (GeneticAlgorithm.isCombinable(p,q)) {    this.evolve3(p,q); }
 }

  }
  }
  }


    public void evolve4(GAIndividual p,GAIndividual q)
  { Controller.inst().addmutated(this,q);
  }

    public void evolve4outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
    List _range73 = new Vector();
  _range73.addAll(geneticalgorithmx.getpopulation());
  for (int _i72 = 0; _i72 < _range73.size(); _i72++)
  { GAIndividual p = (GAIndividual) _range73.get(_i72);
       if (GeneticAlgorithm.isMutatable(p)) {   GAIndividual q = p.mutate();
     if (q.fitness() > p.getfitnessval() - 0.5 * Math.abs(p.getfitnessval()) - 0.5) {    this.evolve4(p,q); }

 }

  }
  }


    public void nextgeneration1()
  {     List pre_elite74 = new Vector();
    pre_elite74.addAll(elite);
Controller.inst().setpopulation(this,pre_elite74);
  }

    public void nextgeneration2(GAIndividual p)
  { Controller.inst().setfitnessval(p,p.fitness());
  }

    public void nextgeneration2outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
      List pre_elite75 = new Vector();
    pre_elite75.addAll(elite);
  List _range77 = new Vector();
  _range77.addAll(pre_elite75);
  for (int _i76 = 0; _i76 < _range77.size(); _i76++)
  { GAIndividual p = (GAIndividual) _range77.get(_i76);
       this.nextgeneration2(p);
  }
  }


    public void nextgeneration3(GAIndividual p)
  { Controller.inst().setfitnessval(p,p.fitness());
  }

    public void nextgeneration3outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
      List pre_recombined78 = new Vector();
    pre_recombined78.addAll(recombined);
  List _range80 = new Vector();
  _range80.addAll(pre_recombined78);
  for (int _i79 = 0; _i79 < _range80.size(); _i79++)
  { GAIndividual p = (GAIndividual) _range80.get(_i79);
       this.nextgeneration3(p);
  }
  }


    public void nextgeneration4(GAIndividual p)
  { Controller.inst().setfitnessval(p,p.fitness());
  }

    public void nextgeneration4outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
      List pre_mutated81 = new Vector();
    pre_mutated81.addAll(mutated);
  List _range83 = new Vector();
  _range83.addAll(pre_mutated81);
  for (int _i82 = 0; _i82 < _range83.size(); _i82++)
  { GAIndividual p = (GAIndividual) _range83.get(_i82);
       this.nextgeneration4(p);
  }
  }


    public void nextgeneration5(GAIndividual p)
  { Controller.inst().addpopulation(this,p);
  }

    public void nextgeneration5outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
      List pre_population84 = new Vector();
    pre_population84.addAll(population);
    List pre_recombined85 = new Vector();
    pre_recombined85.addAll(recombined);
  List _range87 = new Vector();
  _range87.addAll(pre_recombined85);
  for (int _i86 = 0; _i86 < _range87.size(); _i86++)
  { GAIndividual p = (GAIndividual) _range87.get(_i86);
       if (Set.forAll_16(pre_population84,p)) {    this.nextgeneration5(p); }

  }
  }


    public void nextgeneration6(GAIndividual p)
  { Controller.inst().addpopulation(this,p);
  }

    public void nextgeneration6outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
      List pre_population88 = new Vector();
    pre_population88.addAll(population);
    List pre_mutated89 = new Vector();
    pre_mutated89.addAll(mutated);
  List _range91 = new Vector();
  _range91.addAll(pre_mutated89);
  for (int _i90 = 0; _i90 < _range91.size(); _i90++)
  { GAIndividual p = (GAIndividual) _range91.get(_i90);
       if (Set.forAll_17(pre_population88,p)) {    this.nextgeneration6(p); }

  }
  }


    public void nextgeneration7()
  { Controller.inst().setelite(this,(new SystemTypes.Set()).getElements());
    Controller.inst().setrecombined(this,(new SystemTypes.Set()).getElements());
    Controller.inst().setmutated(this,(new SystemTypes.Set()).getElements());
  }

    public void nextgeneration8(List q)
  { this.cull(Set.sortedBy(q, Set.collect_18(q)),q.size());
  }

    public void nextgeneration8outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
      List pre_population92 = new Vector();
    pre_population92.addAll(population);
  List q;
    q = new Vector();
  q.addAll(pre_population92);

     if (q.size() > GeneticAlgorithm.maxpop + 100) {    this.nextgeneration8(q); }


  }


    public void nextgeneration9()
  {   if (this.getpopulation().size() > 0) 
  { GeneticAlgorithm.setmaxfitness(((Double) Set.max(Set.collect_18(this.getpopulation()))).doubleValue());}
  }

    public void nextgeneration10()
  {   System.out.println("" + ( "Population size = " + this.getpopulation().size() ));

      System.out.println("" + ( "Max fitness = " + GeneticAlgorithm.getmaxfitness() ));

  }

    public void initialise2(int j)
  { GAIndividual g = new GAIndividual();
    Controller.inst().addGAIndividual(g);
        List _feature_list93 = new Vector();
    _feature_list93.addAll(Controller.inst().features);
    for (int _ind94 = 0; _ind94 < _feature_list93.size(); _ind94++)
    { Feature f = (Feature) _feature_list93.get(_ind94);
      GATrait t = new GATrait();
    Controller.inst().addGATrait(t);
    Controller.inst().setitem(t,f.getname());
    Controller.inst().setvalue(t,((int) Math.floor(( Math.random() * GeneticAlgorithm.getmaxvalue() ))) + 1);
    Controller.inst().addtraits(g,t);
    }

    Controller.inst().addpopulation(this,g);
  }

    public void initialise2outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
    List _range96 = new Vector();
  _range96.addAll(Set.integerSubrange(1,300));
  for (int _i95 = 0; _i95 < _range96.size(); _i95++)
  { int j = ((Integer) _range96.get(_i95)).intValue();
       this.initialise2(j);
  }
  }


    public void initialise3(int i)
  { GAIndividual g = new GAIndividual();
    Controller.inst().addGAIndividual(g);
        List _feature_list97 = new Vector();
    _feature_list97.addAll(Controller.inst().features);
    for (int _ind98 = 0; _ind98 < _feature_list97.size(); _ind98++)
    { Feature f = (Feature) _feature_list97.get(_ind98);
      GATrait t = new GATrait();
    Controller.inst().addGATrait(t);
    Controller.inst().setitem(t,f.getname());
    Controller.inst().setvalue(t,( Controller.inst().umlclasss.indexOf(((UMLClass) Set.any(f.getisEncapsulatedBy()))) + 1 ));
    Controller.inst().addtraits(g,t);
    }

    Controller.inst().addpopulation(this,g);
  }

    public void initialise3outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
    List _range100 = new Vector();
  _range100.addAll(Set.integerSubrange(1,100));
  for (int _i99 = 0; _i99 < _range100.size(); _i99++)
  { int i = ((Integer) _range100.get(_i99)).intValue();
       this.initialise3(i);
  }
  }


    public void initialise4(GAIndividual p)
  { Controller.inst().setfitnessval(p,p.fitness());
  }

    public void initialise4outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
    List _range102 = new Vector();
  _range102.addAll(geneticalgorithmx.getpopulation());
  for (int _i101 = 0; _i101 < _range102.size(); _i101++)
  { GAIndividual p = (GAIndividual) _range102.get(_i101);
       this.initialise4(p);
  }
  }


    public void initialise5()
  {   if (this.getpopulation().size() > 0) 
  { GeneticAlgorithm.setmaxfitness(((Double) Set.max(Set.collect_18(this.getpopulation()))).doubleValue());
      System.out.println("" + ( "Population size = " + this.getpopulation().size() ));

      System.out.println("" + ( "Maxfitness = " + GeneticAlgorithm.maxfitness ));
}
  }

    public void postprocess1(GAIndividual g)
  {     List _gatrait_list103 = new Vector();
    _gatrait_list103.addAll(g.gettraits());
    for (int _ind104 = 0; _ind104 < _gatrait_list103.size(); _ind104++)
    { GATrait t = (GATrait) _gatrait_list103.get(_ind104);
      Controller.inst().addisEncapsulatedBy(Controller.inst().getFeatureByPK(t.getitem()),((UMLClass) Controller.inst().umlclasss.get(t.getvalue() - 1)));
    }

  }

    public void postprocess1outer()
  {  GeneticAlgorithm geneticalgorithmx = this;
     if (geneticalgorithmx.getpopulation().size() > 0) {   GAIndividual g = ((GAIndividual) Set.any(Set.maximalElements(geneticalgorithmx.getpopulation(), Set.collect_18(geneticalgorithmx.getpopulation()))));
     this.postprocess1(g);
 }

  }


    public void ga2(int iter)
  {     List _int_list105 = new Vector();
    _int_list105.addAll(Set.integerSubrange(1,iter));
    for (int _ind106 = 0; _ind106 < _int_list105.size(); _ind106++)
    { int i = ((Integer) _int_list105.get(_ind106)).intValue();
      Controller.inst().evolve();
    Controller.inst().nextgeneration();
    }

  }

    public void ga2outer(int iter)
  {  GeneticAlgorithm geneticalgorithmx = this;
     if (true) {    this.ga2(iter); }

  }



}


class GAIndividual
  implements SystemTypes
{
  private double fitnessval = 0; // internal
  private List traits = new Vector(); // of GATrait

  public GAIndividual()
  {
    this.fitnessval = 0;

  }



  public static GAIndividual parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    GAIndividual gaindividualx = new GAIndividual();
    gaindividualx.fitnessval = Double.parseDouble((String) _line1vals.get(0));
    return gaindividualx;
  }


  public void writeCSV(PrintWriter _out)
  { GAIndividual gaindividualx = this;
    _out.print("" + gaindividualx.fitnessval);
    _out.println();
  }


  public void setfitnessval(double fitnessval_x) { fitnessval = fitnessval_x;  }


    public static void setAllfitnessval(List gaindividuals,double val)
  { for (int i = 0; i < gaindividuals.size(); i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividuals.get(i);
      Controller.inst().setfitnessval(gaindividualx,val); } }


  public void settraits(List traitsxx) { traits = traitsxx;
    }
 
  public void settraits(int ind_x,GATrait traitsxx) { traits.set(ind_x,traitsxx); }

 public void addtraits(GATrait traitsxx) { traits.add(traitsxx);
    }
 
  public void removetraits(GATrait traitsxx) { Vector _removedtraitstraitsxx = new Vector();
  _removedtraitstraitsxx.add(traitsxx);
  traits.removeAll(_removedtraitstraitsxx);
    }

  public static void setAlltraits(List gaindividuals,List _val)
  { for (int _i = 0; _i < gaindividuals.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividuals.get(_i);
      Controller.inst().settraits(gaindividualx, _val); } }

  public static void setAlltraits(List gaindividuals,int _ind,GATrait _val)
  { for (int _i = 0; _i < gaindividuals.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividuals.get(_i);
      Controller.inst().settraits(gaindividualx,_ind,_val); } }

  public static void addAlltraits(List gaindividuals,GATrait _val)
  { for (int _i = 0; _i < gaindividuals.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividuals.get(_i);
      Controller.inst().addtraits(gaindividualx, _val); } }


  public static void removeAlltraits(List gaindividuals,GATrait _val)
  { for (int _i = 0; _i < gaindividuals.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividuals.get(_i);
      Controller.inst().removetraits(gaindividualx, _val); } }


  public static void unionAlltraits(List gaindividuals, List _val)
  { for (int _i = 0; _i < gaindividuals.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividuals.get(_i);
      Controller.inst().uniontraits(gaindividualx, _val); } }


  public static void subtractAlltraits(List gaindividuals, List _val)
  { for (int _i = 0; _i < gaindividuals.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividuals.get(_i);
      Controller.inst().subtracttraits(gaindividualx, _val); } }


    public double getfitnessval() { return fitnessval; }

    public static List getAllfitnessval(List gaindividuals)
  { List result = new Vector();
    for (int i = 0; i < gaindividuals.size(); i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividuals.get(i);
      if (result.contains(new Double(gaindividualx.getfitnessval()))) { }
      else { result.add(new Double(gaindividualx.getfitnessval())); } }
    return result; }

    public static List getAllOrderedfitnessval(List gaindividuals)
  { List result = new Vector();
    for (int i = 0; i < gaindividuals.size(); i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividuals.get(i);
      result.add(new Double(gaindividualx.getfitnessval())); } 
    return result; }

  public List gettraits() { return (Vector) ((Vector) traits).clone(); }

  public static List getAlltraits(List gaindividuals)
  { List result = new Vector();
    for (int _i = 0; _i < gaindividuals.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividuals.get(_i);
      result = Set.union(result,gaindividualx.gettraits()); }
    return result; }

  public static List getAllOrderedtraits(List gaindividuals)
  { List result = new Vector();
    for (int _i = 0; _i < gaindividuals.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividuals.get(_i);
      result.addAll(gaindividualx.gettraits()); }
    return result; }

    public GAIndividual combine(GAIndividual g)
  {   GAIndividual result = null;
 
  int n = traits.size(); 
     int m = g.gettraits().size(); 
     int p = ((int) Math.floor(( Math.random() * n ))) + 1; 
     GAIndividual h = new GAIndividual();
    Controller.inst().addGAIndividual(h);
    h.settraits(Set.concatenate(Set.subrange(traits,1,p),Set.subrange(g.gettraits(),p + 1,m)));
    result = h;
               return result;
  }


    public GAIndividual mutate()
  {   GAIndividual result = null;
 
  int n = traits.size(); 
     int p = ((int) Math.floor(( Math.random() * n ))) + 1; 
     int val = ((GATrait) traits.get(p - 1)).getvalue(); 
     String itm = ((GATrait) traits.get(p - 1)).getitem(); 
     GAIndividual h = new GAIndividual();
    Controller.inst().addGAIndividual(h);
    Controller.inst().uniontraits(h,traits);
    GATrait newt = new GATrait();
    Controller.inst().addGATrait(newt);
    newt.setitem(itm);
    newt.setvalue(GeneticAlgorithm.incrementValue(val));
    h.settraits(p - 1,newt);
    result = h;
                  return result;
  }


    public String toString()
  {   String result = "";
 
  result = Set.sumString(Set.collect_19(traits));
    return result;
  }


    public List atts(int c)
  {   List result = new Vector();
 
  result = Set.select_20(traits,c);
    return result;
  }


    public List mets(int c)
  {   List result = new Vector();
 
  result = Set.select_21(traits,c);
    return result;
  }


    public int mai(int ci,int cj)
  {   int result = 0;
 
  result = Set.sumint(Set.collect_23(this.mets(ci),this,cj));
    return result;
  }


    public int mmi(int ci,int cj)
  {   int result = 0;
 
  result = Set.sumint(Set.collect_25(this.mets(ci),this,cj));
    return result;
  }


    public double cohesion(int ci)
  {   double result = 0;
 
  int nmethods = (this.mets(ci)).size(); 
     int natts = (this.atts(ci)).size(); 
     if (nmethods == 0) 
  {   result = 0;
 
  }  else
      {   if (nmethods > 1 && natts == 0) 
  {   result = this.mmi(ci,ci) / ( 1.0 * nmethods * ( nmethods - 1 ) );
 
  }  else
      {   if (natts != 0 && nmethods == 1) 
  {   result = this.mai(ci,ci) / ( 1.0 * natts );
 
  }  else
      if (nmethods > 1 && natts != 0) 
  {   result = this.mai(ci,ci) / ( 1.0 * nmethods * natts ) + ( this.mmi(ci,ci) / ( 1.0 * nmethods * ( nmethods - 1 ) ) );
 
  }   
   } 
   }           return result;
  }


    public double cohesionrat()
  {   double result = 0;
 
  result = Set.sumdouble(Set.collect_26(Set.asSet(GATrait.getAllOrderedvalue(traits)),this));
    return result;
  }


    public double coupling(int ci,int cj)
  {   double result = 0;
 
  int nmethodsi = (this.mets(ci)).size(); 
     int nmethodsj = (this.mets(cj)).size(); 
     int natts = (this.atts(cj)).size(); 
     if (nmethodsi == 0) 
  {   result = 0;
 
  }  else
      {   if (nmethodsi != 0 && natts == 0 && nmethodsj <= 1) 
  {   result = 0;
 
  }  else
      {   if (nmethodsi != 0 && natts == 0 && nmethodsj > 1) 
  {   result = this.mmi(ci,cj) / ( 1.0 * nmethodsi * ( nmethodsj - 1 ) );
 
  }  else
      {   if (nmethodsi != 0 && natts != 0 && nmethodsj <= 1) 
  {   result = this.mai(ci,cj) / ( 1.0 * nmethodsi * natts );
 
  }  else
      if (nmethodsi != 0 && natts != 0 && nmethodsj > 1) 
  {   result = this.mai(ci,cj) / ( 1.0 * nmethodsi * natts ) + this.mmi(ci,cj) / ( 1.0 * nmethodsi * ( nmethodsj - 1 ) );
 
  }   
   } 
   } 
   }              return result;
  }


    public double couplingrat()
  {   double result = 0;
 
  result = Set.sumdouble(Set.collect_28(Set.asSet(GATrait.getAllOrderedvalue(traits)),this));
    return result;
  }


    public double fitness()
  {   double result = 0;
 
  result = this.cohesionrat() - this.couplingrat();
    return result;
  }



}


class GATrait
  implements SystemTypes
{
  private String item = ""; // internal
  private int value = 0; // internal

  public GATrait()
  {
    this.item = "";
    this.value = 0;

  }



  public String toString()
  { String _res_ = "(GATrait) ";
    _res_ = _res_ + item + ",";
    _res_ = _res_ + value;
    return _res_;
  }

  public static GATrait parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    GATrait gatraitx = new GATrait();
    gatraitx.item = (String) _line1vals.get(0);
    gatraitx.value = Integer.parseInt((String) _line1vals.get(1));
    return gatraitx;
  }


  public void writeCSV(PrintWriter _out)
  { GATrait gatraitx = this;
    _out.print("" + gatraitx.item);
    _out.print(" , ");
    _out.print("" + gatraitx.value);
    _out.println();
  }


  public void setitem(String item_x) { item = item_x;  }


    public static void setAllitem(List gatraits,String val)
  { for (int i = 0; i < gatraits.size(); i++)
    { GATrait gatraitx = (GATrait) gatraits.get(i);
      Controller.inst().setitem(gatraitx,val); } }


  public void setvalue(int value_x) { value = value_x;  }


    public static void setAllvalue(List gatraits,int val)
  { for (int i = 0; i < gatraits.size(); i++)
    { GATrait gatraitx = (GATrait) gatraits.get(i);
      Controller.inst().setvalue(gatraitx,val); } }


    public String getitem() { return item; }

    public static List getAllitem(List gatraits)
  { List result = new Vector();
    for (int i = 0; i < gatraits.size(); i++)
    { GATrait gatraitx = (GATrait) gatraits.get(i);
      if (result.contains(gatraitx.getitem())) { }
      else { result.add(gatraitx.getitem()); } }
    return result; }

    public static List getAllOrdereditem(List gatraits)
  { List result = new Vector();
    for (int i = 0; i < gatraits.size(); i++)
    { GATrait gatraitx = (GATrait) gatraits.get(i);
      result.add(gatraitx.getitem()); } 
    return result; }

    public int getvalue() { return value; }

    public static List getAllvalue(List gatraits)
  { List result = new Vector();
    for (int i = 0; i < gatraits.size(); i++)
    { GATrait gatraitx = (GATrait) gatraits.get(i);
      if (result.contains(new Integer(gatraitx.getvalue()))) { }
      else { result.add(new Integer(gatraitx.getvalue())); } }
    return result; }

    public static List getAllOrderedvalue(List gatraits)
  { List result = new Vector();
    for (int i = 0; i < gatraits.size(); i++)
    { GATrait gatraitx = (GATrait) gatraits.get(i);
      result.add(new Integer(gatraitx.getvalue())); } 
    return result; }


}


class CreateClasses
  implements SystemTypes
{

  public CreateClasses()
  {

  }



  public String toString()
  { String _res_ = "(CreateClasses) ";
    return _res_;
  }

  public static CreateClasses parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    CreateClasses createclassesx = new CreateClasses();
    return createclassesx;
  }


  public void writeCSV(PrintWriter _out)
  { CreateClasses createclassesx = this;
    _out.println();
  }


  


}


class Refactor
  implements SystemTypes
{

  public Refactor()
  {

  }



  public String toString()
  { String _res_ = "(Refactor) ";
    return _res_;
  }

  public static Refactor parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    Refactor refactorx = new Refactor();
    return refactorx;
  }


  public void writeCSV(PrintWriter _out)
  { Refactor refactorx = this;
    _out.println();
  }


  


}


class Cleanup
  implements SystemTypes
{

  public Cleanup()
  {

  }



  public String toString()
  { String _res_ = "(Cleanup) ";
    return _res_;
  }

  public static Cleanup parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    Cleanup cleanupx = new Cleanup();
    return cleanupx;
  }


  public void writeCSV(PrintWriter _out)
  { Cleanup cleanupx = this;
    _out.println();
  }


  


}


class Measures
  implements SystemTypes
{

  public Measures()
  {

  }



  public String toString()
  { String _res_ = "(Measures) ";
    return _res_;
  }

  public static Measures parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    Measures measuresx = new Measures();
    return measuresx;
  }


  public void writeCSV(PrintWriter _out)
  { Measures measuresx = this;
    _out.println();
  }


  


}


class Preprocess
  implements SystemTypes
{

  public Preprocess()
  {

  }



  public String toString()
  { String _res_ = "(Preprocess) ";
    return _res_;
  }

  public static Preprocess parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    Preprocess preprocessx = new Preprocess();
    return preprocessx;
  }


  public void writeCSV(PrintWriter _out)
  { Preprocess preprocessx = this;
    _out.println();
  }


  


}


class Evolve
  implements SystemTypes
{

  public Evolve()
  {

  }



  public String toString()
  { String _res_ = "(Evolve) ";
    return _res_;
  }

  public static Evolve parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    Evolve evolvex = new Evolve();
    return evolvex;
  }


  public void writeCSV(PrintWriter _out)
  { Evolve evolvex = this;
    _out.println();
  }


  


}


class Nextgeneration
  implements SystemTypes
{

  public Nextgeneration()
  {

  }



  public String toString()
  { String _res_ = "(Nextgeneration) ";
    return _res_;
  }

  public static Nextgeneration parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    Nextgeneration nextgenerationx = new Nextgeneration();
    return nextgenerationx;
  }


  public void writeCSV(PrintWriter _out)
  { Nextgeneration nextgenerationx = this;
    _out.println();
  }


  


}


class Initialise
  implements SystemTypes
{

  public Initialise()
  {

  }



  public String toString()
  { String _res_ = "(Initialise) ";
    return _res_;
  }

  public static Initialise parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    Initialise initialisex = new Initialise();
    return initialisex;
  }


  public void writeCSV(PrintWriter _out)
  { Initialise initialisex = this;
    _out.println();
  }


  


}


class Postprocess
  implements SystemTypes
{

  public Postprocess()
  {

  }



  public String toString()
  { String _res_ = "(Postprocess) ";
    return _res_;
  }

  public static Postprocess parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    Postprocess postprocessx = new Postprocess();
    return postprocessx;
  }


  public void writeCSV(PrintWriter _out)
  { Postprocess postprocessx = this;
    _out.println();
  }


  


}


class Ga
  implements SystemTypes
{

  public Ga()
  {

  }



  public String toString()
  { String _res_ = "(Ga) ";
    return _res_;
  }

  public static Ga parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    Ga gax = new Ga();
    return gax;
  }


  public void writeCSV(PrintWriter _out)
  { Ga gax = this;
    _out.println();
  }


  


}


class CreateClasses1
  implements SystemTypes
{

  public CreateClasses1()
  {

  }



  public String toString()
  { String _res_ = "(CreateClasses1) ";
    return _res_;
  }

  public static CreateClasses1 parseCSV(String _line)
  { if (_line == null) { return null; }
    Vector _line1vals = new Vector();
    StringTokenizer _st1 =
      new StringTokenizer(_line, ",");
    while (_st1.hasMoreTokens())
    { String _str = _st1.nextToken();
      if (_str != null) 
      { _line1vals.add(_str.trim()); }
    }
    CreateClasses1 createclasses1x = new CreateClasses1();
    return createclasses1x;
  }


  public void writeCSV(PrintWriter _out)
  { CreateClasses1 createclasses1x = this;
    _out.println();
  }


  


}



public class Controller implements SystemTypes, ControllerInterface
{
  Vector classmodels = new Vector();
  Vector umlclasss = new Vector();
  Vector attributes = new Vector();
  Vector umlmethods = new Vector();
  Vector features = new Vector();
  Vector namedelements = new Vector();
  Map namedelementnameindex = new HashMap(); // String --> NamedElement

  Vector geneticalgorithms = new Vector();
  Vector gaindividuals = new Vector();
  Vector gatraits = new Vector();
  Vector createclassess = new Vector();
  Vector refactors = new Vector();
  Vector cleanups = new Vector();
  Vector measuress = new Vector();
  Vector preprocesss = new Vector();
  Vector evolves = new Vector();
  Vector nextgenerations = new Vector();
  Vector initialises = new Vector();
  Vector postprocesss = new Vector();
  Vector gas = new Vector();
  Vector createclasses1s = new Vector();
  private static Controller uniqueInstance; 


  private Controller() { } 


  public static Controller inst() 
    { if (uniqueInstance == null) 
    { uniqueInstance = new Controller(); }
    return uniqueInstance; } 


  public static void loadModel(String file)
  {
    try
    { BufferedReader br = null;
      File f = new File(file);
      try 
      { br = new BufferedReader(new FileReader(f)); }
      catch (Exception ex) 
      { System.err.println("No file: " + file); return; }
      Class cont = Class.forName("Controller");
      java.util.Map objectmap = new java.util.HashMap();
      while (true)
      { String line1;
        try { line1 = br.readLine(); }
        catch (Exception e)
        { return; }
        if (line1 == null)
        { return; }
        line1 = line1.trim();

        if (line1.length() == 0) { continue; }
        String left;
        String op;
        String right;
        if (line1.charAt(line1.length() - 1) == '"')
        { int eqind = line1.indexOf("="); 
          if (eqind == -1) { continue; }
          else 
          { left = line1.substring(0,eqind-1).trim();
            op = "="; 
            right = line1.substring(eqind+1,line1.length()).trim();
          }
        }
        else
        { StringTokenizer st1 = new StringTokenizer(line1);
          Vector vals1 = new Vector();
          while (st1.hasMoreTokens())
          { String val1 = st1.nextToken();
            vals1.add(val1);
          }
          if (vals1.size() < 3)
          { continue; }
          left = (String) vals1.get(0);
          op = (String) vals1.get(1);
          right = (String) vals1.get(2);
        }
        if (":".equals(op))
        { int i2 = right.indexOf(".");
          if (i2 == -1)
          { Class cl;
            try { cl = Class.forName("" + right); }
            catch (Exception _x) { System.err.println("No entity: " + right); continue; }
            Object xinst = cl.newInstance();
            objectmap.put(left,xinst);
            Class[] cargs = new Class[] { cl };
            Method addC = null;
            try { addC = cont.getMethod("add" + right,cargs); }
            catch (Exception _xx) { System.err.println("No entity: " + right); continue; }
            if (addC == null) { continue; }
            Object[] args = new Object[] { xinst };
            addC.invoke(Controller.inst(),args);
          }
          else
          { String obj = right.substring(0,i2);
            String role = right.substring(i2+1,right.length());
            Object objinst = objectmap.get(obj); 
            if (objinst == null) 
            { continue; }
            Object val = objectmap.get(left);
            if (val == null) 
            { continue; }
            Class objC = objinst.getClass();
            Class typeclass = val.getClass(); 
            Object[] args = new Object[] { val }; 
            Class[] settypes = new Class[] { typeclass };
            Method addrole = Controller.findMethod(objC,"add" + role);
            if (addrole != null) 
            { addrole.invoke(objinst, args); }
            else { System.err.println("Error: cannot add to " + role); }
          }
        }
        else if ("=".equals(op))
        { int i1 = left.indexOf(".");
          if (i1 == -1) 
          { continue; }
          String obj = left.substring(0,i1);
          String att = left.substring(i1+1,left.length());
          Object objinst = objectmap.get(obj); 
          if (objinst == null) 
          { continue; }
          Class objC = objinst.getClass();
          Class typeclass; 
          Object val; 
          if (right.charAt(0) == '"' &&
              right.charAt(right.length() - 1) == '"')
          { typeclass = String.class;
            val = right.substring(1,right.length() - 1);
          } 
          else if ("true".equals(right) || "false".equals(right))
          { typeclass = boolean.class;
            if ("true".equals(right))
            { val = new Boolean(true); }
            else
            { val = new Boolean(false); }
          }
          else 
          { val = objectmap.get(right);
            if (val != null)
            { typeclass = val.getClass(); }
            else 
            { int i;
              long l; 
              double d;
              try 
              { i = Integer.parseInt(right);
                typeclass = int.class;
                val = new Integer(i); 
              }
              catch (Exception ee)
              { try 
                { l = Long.parseLong(right);
                  typeclass = long.class;
                  val = new Long(l); 
                }
                catch (Exception eee)
                { try
                  { d = Double.parseDouble(right);
                    typeclass = double.class;
                    val = new Double(d);
                  }
                  catch (Exception ff)
                  { continue; }
                }
              }
            }
          }
          Object[] args = new Object[] { val }; 
          Class[] settypes = new Class[] { typeclass };
          Method setatt = Controller.findMethod(objC,"set" + att);
          if (setatt != null) 
          { setatt.invoke(objinst, args); }
          else { System.err.println("No attribute: " + objC.getName() + "::" + att); }
        }
      }
    } catch (Exception e) { }
  }

  public static Method findMethod(Class c, String name)
  { Method[] mets = c.getMethods(); 
    for (int i = 0; i < mets.length; i++)
    { Method m = mets[i];
      if (m.getName().equals(name))
      { return m; }
    } 
    return null;
  }


  public static void loadCSVModel()
  { boolean __eof = false;
    String __s = "";
    Controller __cont = Controller.inst();
    BufferedReader __br = null;
    try
    { File _classmodel = new File("ClassModel.csv");
      __br = new BufferedReader(new FileReader(_classmodel));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { ClassModel classmodelx = ClassModel.parseCSV(__s.trim());
          if (classmodelx != null)
          { __cont.addClassModel(classmodelx); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _umlclass = new File("UMLClass.csv");
      __br = new BufferedReader(new FileReader(_umlclass));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { UMLClass umlclassx = UMLClass.parseCSV(__s.trim());
          if (umlclassx != null)
          { __cont.addUMLClass(umlclassx); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _attribute = new File("Attribute.csv");
      __br = new BufferedReader(new FileReader(_attribute));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { Attribute attributex = Attribute.parseCSV(__s.trim());
          if (attributex != null)
          { __cont.addAttribute(attributex); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _umlmethod = new File("UMLMethod.csv");
      __br = new BufferedReader(new FileReader(_umlmethod));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { UMLMethod umlmethodx = UMLMethod.parseCSV(__s.trim());
          if (umlmethodx != null)
          { __cont.addUMLMethod(umlmethodx); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _geneticalgorithm = new File("GeneticAlgorithm.csv");
      __br = new BufferedReader(new FileReader(_geneticalgorithm));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { GeneticAlgorithm geneticalgorithmx = GeneticAlgorithm.parseCSV(__s.trim());
          if (geneticalgorithmx != null)
          { __cont.addGeneticAlgorithm(geneticalgorithmx); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _gaindividual = new File("GAIndividual.csv");
      __br = new BufferedReader(new FileReader(_gaindividual));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { GAIndividual gaindividualx = GAIndividual.parseCSV(__s.trim());
          if (gaindividualx != null)
          { __cont.addGAIndividual(gaindividualx); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _gatrait = new File("GATrait.csv");
      __br = new BufferedReader(new FileReader(_gatrait));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { GATrait gatraitx = GATrait.parseCSV(__s.trim());
          if (gatraitx != null)
          { __cont.addGATrait(gatraitx); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _createclasses = new File("CreateClasses.csv");
      __br = new BufferedReader(new FileReader(_createclasses));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { CreateClasses createclassesx = CreateClasses.parseCSV(__s.trim());
          if (createclassesx != null)
          { __cont.addCreateClasses(createclassesx); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _refactor = new File("Refactor.csv");
      __br = new BufferedReader(new FileReader(_refactor));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { Refactor refactorx = Refactor.parseCSV(__s.trim());
          if (refactorx != null)
          { __cont.addRefactor(refactorx); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _cleanup = new File("Cleanup.csv");
      __br = new BufferedReader(new FileReader(_cleanup));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { Cleanup cleanupx = Cleanup.parseCSV(__s.trim());
          if (cleanupx != null)
          { __cont.addCleanup(cleanupx); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _measures = new File("Measures.csv");
      __br = new BufferedReader(new FileReader(_measures));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { Measures measuresx = Measures.parseCSV(__s.trim());
          if (measuresx != null)
          { __cont.addMeasures(measuresx); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _preprocess = new File("Preprocess.csv");
      __br = new BufferedReader(new FileReader(_preprocess));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { Preprocess preprocessx = Preprocess.parseCSV(__s.trim());
          if (preprocessx != null)
          { __cont.addPreprocess(preprocessx); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _evolve = new File("Evolve.csv");
      __br = new BufferedReader(new FileReader(_evolve));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { Evolve evolvex = Evolve.parseCSV(__s.trim());
          if (evolvex != null)
          { __cont.addEvolve(evolvex); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _nextgeneration = new File("Nextgeneration.csv");
      __br = new BufferedReader(new FileReader(_nextgeneration));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { Nextgeneration nextgenerationx = Nextgeneration.parseCSV(__s.trim());
          if (nextgenerationx != null)
          { __cont.addNextgeneration(nextgenerationx); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _initialise = new File("Initialise.csv");
      __br = new BufferedReader(new FileReader(_initialise));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { Initialise initialisex = Initialise.parseCSV(__s.trim());
          if (initialisex != null)
          { __cont.addInitialise(initialisex); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _postprocess = new File("Postprocess.csv");
      __br = new BufferedReader(new FileReader(_postprocess));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { Postprocess postprocessx = Postprocess.parseCSV(__s.trim());
          if (postprocessx != null)
          { __cont.addPostprocess(postprocessx); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _ga = new File("Ga.csv");
      __br = new BufferedReader(new FileReader(_ga));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { Ga gax = Ga.parseCSV(__s.trim());
          if (gax != null)
          { __cont.addGa(gax); }
        }
      }
    }
    catch(Exception __e) { }
    try
    { File _createclasses1 = new File("CreateClasses1.csv");
      __br = new BufferedReader(new FileReader(_createclasses1));
      __eof = false;
      while (!__eof)
      { try { __s = __br.readLine(); }
        catch (IOException __e)
        { System.out.println("Reading failed.");
          return;
        }
        if (__s == null)
        { __eof = true; }
        else
        { CreateClasses1 createclasses1x = CreateClasses1.parseCSV(__s.trim());
          if (createclasses1x != null)
          { __cont.addCreateClasses1(createclasses1x); }
        }
      }
    }
    catch(Exception __e) { }
  }


  public void checkCompleteness()
  {   for (int _i = 0; _i < namedelements.size(); _i++)
  { NamedElement namedelement_x = (NamedElement) namedelements.get(_i);
    NamedElement namedelement_obj = (NamedElement) namedelementnameindex.get(namedelement_x.getname());
    if (namedelement_obj == namedelement_x) { }
    else if (namedelement_obj == null)
    { namedelementnameindex.put(namedelement_x.getname(),namedelement_x); }
    else
    { System.out.println("Error: multiple objects with name = " + namedelement_x.getname()); }
  }
  for (int _i = 0; _i < umlclasss.size(); _i++)
  { UMLClass isEncapsulatedBy_umlclassx1 = (UMLClass) umlclasss.get(_i);
    for (int _j = 0; _j < features.size(); _j++)
    { Feature encapsulates_featurex2 = (Feature) features.get(_j);
      if (isEncapsulatedBy_umlclassx1.getencapsulates().contains(encapsulates_featurex2))
      { if (encapsulates_featurex2.getisEncapsulatedBy().contains(isEncapsulatedBy_umlclassx1)) { }
        else { encapsulates_featurex2.addisEncapsulatedBy(isEncapsulatedBy_umlclassx1); }
      }
      else if (encapsulates_featurex2.getisEncapsulatedBy().contains(isEncapsulatedBy_umlclassx1))
      { isEncapsulatedBy_umlclassx1.addencapsulates(encapsulates_featurex2); } 
    }
  }
  }


  public void saveModel(String file)
  { File outfile = new File(file); 
    PrintWriter out; 
    try { out = new PrintWriter(new BufferedWriter(new FileWriter(outfile))); }
    catch (Exception e) { return; } 
  for (int _i = 0; _i < classmodels.size(); _i++)
  { ClassModel classmodelx_ = (ClassModel) classmodels.get(_i);
    out.println("classmodelx_" + _i + " : ClassModel");
    out.println("classmodelx_" + _i + ".name = \"" + classmodelx_.getname() + "\"");
  }

  for (int _i = 0; _i < umlclasss.size(); _i++)
  { UMLClass umlclassx_ = (UMLClass) umlclasss.get(_i);
    out.println("umlclassx_" + _i + " : UMLClass");
    out.println("umlclassx_" + _i + ".name = \"" + umlclassx_.getname() + "\"");
  }

  for (int _i = 0; _i < attributes.size(); _i++)
  { Attribute attributex_ = (Attribute) attributes.get(_i);
    out.println("attributex_" + _i + " : Attribute");
    out.println("attributex_" + _i + ".name = \"" + attributex_.getname() + "\"");
  }

  for (int _i = 0; _i < umlmethods.size(); _i++)
  { UMLMethod umlmethodx_ = (UMLMethod) umlmethods.get(_i);
    out.println("umlmethodx_" + _i + " : UMLMethod");
    out.println("umlmethodx_" + _i + ".name = \"" + umlmethodx_.getname() + "\"");
  }

  for (int _i = 0; _i < createclassess.size(); _i++)
  { CreateClasses createclassesx_ = (CreateClasses) createclassess.get(_i);
    out.println("createclassesx_" + _i + " : CreateClasses");
  }

  for (int _i = 0; _i < refactors.size(); _i++)
  { Refactor refactorx_ = (Refactor) refactors.get(_i);
    out.println("refactorx_" + _i + " : Refactor");
  }

  for (int _i = 0; _i < cleanups.size(); _i++)
  { Cleanup cleanupx_ = (Cleanup) cleanups.get(_i);
    out.println("cleanupx_" + _i + " : Cleanup");
  }

  for (int _i = 0; _i < measuress.size(); _i++)
  { Measures measuresx_ = (Measures) measuress.get(_i);
    out.println("measuresx_" + _i + " : Measures");
  }

  for (int _i = 0; _i < preprocesss.size(); _i++)
  { Preprocess preprocessx_ = (Preprocess) preprocesss.get(_i);
    out.println("preprocessx_" + _i + " : Preprocess");
  }

  for (int _i = 0; _i < evolves.size(); _i++)
  { Evolve evolvex_ = (Evolve) evolves.get(_i);
    out.println("evolvex_" + _i + " : Evolve");
  }

  for (int _i = 0; _i < nextgenerations.size(); _i++)
  { Nextgeneration nextgenerationx_ = (Nextgeneration) nextgenerations.get(_i);
    out.println("nextgenerationx_" + _i + " : Nextgeneration");
  }

  for (int _i = 0; _i < initialises.size(); _i++)
  { Initialise initialisex_ = (Initialise) initialises.get(_i);
    out.println("initialisex_" + _i + " : Initialise");
  }

  for (int _i = 0; _i < postprocesss.size(); _i++)
  { Postprocess postprocessx_ = (Postprocess) postprocesss.get(_i);
    out.println("postprocessx_" + _i + " : Postprocess");
  }

  for (int _i = 0; _i < gas.size(); _i++)
  { Ga gax_ = (Ga) gas.get(_i);
    out.println("gax_" + _i + " : Ga");
  }

  for (int _i = 0; _i < createclasses1s.size(); _i++)
  { CreateClasses1 createclasses1x_ = (CreateClasses1) createclasses1s.get(_i);
    out.println("createclasses1x_" + _i + " : CreateClasses1");
  }

  for (int _i = 0; _i < classmodels.size(); _i++)
  { ClassModel classmodelx_ = (ClassModel) classmodels.get(_i);
    List classmodel_classes_UMLClass = classmodelx_.getclasses();
    for (int _j = 0; _j < classmodel_classes_UMLClass.size(); _j++)
    { out.println("umlclassx_" + umlclasss.indexOf(classmodel_classes_UMLClass.get(_j)) + " : classmodelx_" + _i + ".classes");
    }
    List classmodel_features_Feature = classmodelx_.getfeatures();
    for (int _k = 0; _k < classmodel_features_Feature.size(); _k++)
    { if (classmodel_features_Feature.get(_k) instanceof Attribute)
      { out.println("attributex_" + attributes.indexOf(classmodel_features_Feature.get(_k)) + " : classmodelx_" + _i + ".features"); }
 if (classmodel_features_Feature.get(_k) instanceof UMLMethod)
      { out.println("umlmethodx_" + umlmethods.indexOf(classmodel_features_Feature.get(_k)) + " : classmodelx_" + _i + ".features"); }
  }
  }
  for (int _i = 0; _i < umlclasss.size(); _i++)
  { UMLClass umlclassx_ = (UMLClass) umlclasss.get(_i);
    List umlclass_encapsulates_Feature = umlclassx_.getencapsulates();
    for (int _k = 0; _k < umlclass_encapsulates_Feature.size(); _k++)
    { if (umlclass_encapsulates_Feature.get(_k) instanceof Attribute)
      { out.println("attributex_" + attributes.indexOf(umlclass_encapsulates_Feature.get(_k)) + " : umlclassx_" + _i + ".encapsulates"); }
 if (umlclass_encapsulates_Feature.get(_k) instanceof UMLMethod)
      { out.println("umlmethodx_" + umlmethods.indexOf(umlclass_encapsulates_Feature.get(_k)) + " : umlclassx_" + _i + ".encapsulates"); }
  }
  }
  for (int _i = 0; _i < attributes.size(); _i++)
  { Attribute attributex_ = (Attribute) attributes.get(_i);
    List attribute_isEncapsulatedBy_UMLClass = attributex_.getisEncapsulatedBy();
    for (int _j = 0; _j < attribute_isEncapsulatedBy_UMLClass.size(); _j++)
    { out.println("umlclassx_" + umlclasss.indexOf(attribute_isEncapsulatedBy_UMLClass.get(_j)) + " : attributex_" + _i + ".isEncapsulatedBy");
    }
  }
  for (int _i = 0; _i < umlmethods.size(); _i++)
  { UMLMethod umlmethodx_ = (UMLMethod) umlmethods.get(_i);
    List umlmethod_dataDependency_Attribute = umlmethodx_.getdataDependency();
    for (int _j = 0; _j < umlmethod_dataDependency_Attribute.size(); _j++)
    { out.println("attributex_" + attributes.indexOf(umlmethod_dataDependency_Attribute.get(_j)) + " : umlmethodx_" + _i + ".dataDependency");
    }
    List umlmethod_functionalDependency_UMLMethod = umlmethodx_.getfunctionalDependency();
    for (int _j = 0; _j < umlmethod_functionalDependency_UMLMethod.size(); _j++)
    { out.println("umlmethodx_" + umlmethods.indexOf(umlmethod_functionalDependency_UMLMethod.get(_j)) + " : umlmethodx_" + _i + ".functionalDependency");
    }
    List umlmethod_isEncapsulatedBy_UMLClass = umlmethodx_.getisEncapsulatedBy();
    for (int _j = 0; _j < umlmethod_isEncapsulatedBy_UMLClass.size(); _j++)
    { out.println("umlclassx_" + umlclasss.indexOf(umlmethod_isEncapsulatedBy_UMLClass.get(_j)) + " : umlmethodx_" + _i + ".isEncapsulatedBy");
    }
  }
    out.close(); 
  }


  public void saveXSI(String file)
  { File outfile = new File(file); 
    PrintWriter out; 
    try { out = new PrintWriter(new BufferedWriter(new FileWriter(outfile))); }
    catch (Exception e) { return; } 
    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.println("<My:model xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\">");
    for (int _i = 0; _i < classmodels.size(); _i++)
    { ClassModel classmodelx_ = (ClassModel) classmodels.get(_i);
       out.print("<classmodels xsi:type=\"My:ClassModel\"");
    out.print(" name=\"" + classmodelx_.getname() + "\" ");
    out.print(" classes = \"");
    List classmodel_classes = classmodelx_.getclasses();
    for (int _j = 0; _j < classmodel_classes.size(); _j++)
    { out.print(" //@umlclasss." + umlclasss.indexOf(classmodel_classes.get(_j)));
    }
    out.print("\"");
    out.print(" features = \"");
    List classmodel_features = classmodelx_.getfeatures();
    for (int _k = 0; _k < classmodel_features.size(); _k++)
    {      if (classmodel_features.get(_k) instanceof Attribute)
      { out.print(" //@attributes." + attributes.indexOf(classmodel_features.get(_k)));
    }
 else      if (classmodel_features.get(_k) instanceof UMLMethod)
      { out.print(" //@umlmethods." + umlmethods.indexOf(classmodel_features.get(_k)));
    }
  }
    out.print("\"");
    out.println(" />");
  }

    for (int _i = 0; _i < umlclasss.size(); _i++)
    { UMLClass umlclassx_ = (UMLClass) umlclasss.get(_i);
       out.print("<umlclasss xsi:type=\"My:UMLClass\"");
    out.print(" name=\"" + umlclassx_.getname() + "\" ");
    out.print(" encapsulates = \"");
    List umlclass_encapsulates = umlclassx_.getencapsulates();
    for (int _k = 0; _k < umlclass_encapsulates.size(); _k++)
    {      if (umlclass_encapsulates.get(_k) instanceof Attribute)
      { out.print(" //@attributes." + attributes.indexOf(umlclass_encapsulates.get(_k)));
    }
 else      if (umlclass_encapsulates.get(_k) instanceof UMLMethod)
      { out.print(" //@umlmethods." + umlmethods.indexOf(umlclass_encapsulates.get(_k)));
    }
  }
    out.print("\"");
    out.println(" />");
  }

    for (int _i = 0; _i < attributes.size(); _i++)
    { Attribute attributex_ = (Attribute) attributes.get(_i);
       out.print("<attributes xsi:type=\"My:Attribute\"");
    out.print(" name=\"" + attributex_.getname() + "\" ");
    out.print(" isEncapsulatedBy = \"");
    List attribute_isEncapsulatedBy = attributex_.getisEncapsulatedBy();
    for (int _j = 0; _j < attribute_isEncapsulatedBy.size(); _j++)
    { out.print(" //@umlclasss." + umlclasss.indexOf(attribute_isEncapsulatedBy.get(_j)));
    }
    out.print("\"");
    out.println(" />");
  }

    for (int _i = 0; _i < umlmethods.size(); _i++)
    { UMLMethod umlmethodx_ = (UMLMethod) umlmethods.get(_i);
       out.print("<umlmethods xsi:type=\"My:UMLMethod\"");
    out.print(" name=\"" + umlmethodx_.getname() + "\" ");
    out.print(" dataDependency = \"");
    List umlmethod_dataDependency = umlmethodx_.getdataDependency();
    for (int _j = 0; _j < umlmethod_dataDependency.size(); _j++)
    { out.print(" //@attributes." + attributes.indexOf(umlmethod_dataDependency.get(_j)));
    }
    out.print("\"");
    out.print(" functionalDependency = \"");
    List umlmethod_functionalDependency = umlmethodx_.getfunctionalDependency();
    for (int _j = 0; _j < umlmethod_functionalDependency.size(); _j++)
    { out.print(" //@umlmethods." + umlmethods.indexOf(umlmethod_functionalDependency.get(_j)));
    }
    out.print("\"");
    out.print(" isEncapsulatedBy = \"");
    List umlmethod_isEncapsulatedBy = umlmethodx_.getisEncapsulatedBy();
    for (int _j = 0; _j < umlmethod_isEncapsulatedBy.size(); _j++)
    { out.print(" //@umlclasss." + umlclasss.indexOf(umlmethod_isEncapsulatedBy.get(_j)));
    }
    out.print("\"");
    out.println(" />");
  }

    for (int _i = 0; _i < createclassess.size(); _i++)
    { CreateClasses createclassesx_ = (CreateClasses) createclassess.get(_i);
       out.print("<createclassess xsi:type=\"My:CreateClasses\"");
    out.println(" />");
  }

    for (int _i = 0; _i < refactors.size(); _i++)
    { Refactor refactorx_ = (Refactor) refactors.get(_i);
       out.print("<refactors xsi:type=\"My:Refactor\"");
    out.println(" />");
  }

    for (int _i = 0; _i < cleanups.size(); _i++)
    { Cleanup cleanupx_ = (Cleanup) cleanups.get(_i);
       out.print("<cleanups xsi:type=\"My:Cleanup\"");
    out.println(" />");
  }

    for (int _i = 0; _i < measuress.size(); _i++)
    { Measures measuresx_ = (Measures) measuress.get(_i);
       out.print("<measuress xsi:type=\"My:Measures\"");
    out.println(" />");
  }

    for (int _i = 0; _i < preprocesss.size(); _i++)
    { Preprocess preprocessx_ = (Preprocess) preprocesss.get(_i);
       out.print("<preprocesss xsi:type=\"My:Preprocess\"");
    out.println(" />");
  }

    for (int _i = 0; _i < evolves.size(); _i++)
    { Evolve evolvex_ = (Evolve) evolves.get(_i);
       out.print("<evolves xsi:type=\"My:Evolve\"");
    out.println(" />");
  }

    for (int _i = 0; _i < nextgenerations.size(); _i++)
    { Nextgeneration nextgenerationx_ = (Nextgeneration) nextgenerations.get(_i);
       out.print("<nextgenerations xsi:type=\"My:Nextgeneration\"");
    out.println(" />");
  }

    for (int _i = 0; _i < initialises.size(); _i++)
    { Initialise initialisex_ = (Initialise) initialises.get(_i);
       out.print("<initialises xsi:type=\"My:Initialise\"");
    out.println(" />");
  }

    for (int _i = 0; _i < postprocesss.size(); _i++)
    { Postprocess postprocessx_ = (Postprocess) postprocesss.get(_i);
       out.print("<postprocesss xsi:type=\"My:Postprocess\"");
    out.println(" />");
  }

    for (int _i = 0; _i < gas.size(); _i++)
    { Ga gax_ = (Ga) gas.get(_i);
       out.print("<gas xsi:type=\"My:Ga\"");
    out.println(" />");
  }

    for (int _i = 0; _i < createclasses1s.size(); _i++)
    { CreateClasses1 createclasses1x_ = (CreateClasses1) createclasses1s.get(_i);
       out.print("<createclasses1s xsi:type=\"My:CreateClasses1\"");
    out.println(" />");
  }

    out.println("</My:model>");
    out.close(); 
  }


  public void saveCSVModel()
  { try {
      File _classmodel = new File("ClassModel.csv");
      PrintWriter _out_classmodel = new PrintWriter(new BufferedWriter(new FileWriter(_classmodel)));
      for (int __i = 0; __i < classmodels.size(); __i++)
      { ClassModel classmodelx = (ClassModel) classmodels.get(__i);
        classmodelx.writeCSV(_out_classmodel);
      }
      _out_classmodel.close();
      File _umlclass = new File("UMLClass.csv");
      PrintWriter _out_umlclass = new PrintWriter(new BufferedWriter(new FileWriter(_umlclass)));
      for (int __i = 0; __i < umlclasss.size(); __i++)
      { UMLClass umlclassx = (UMLClass) umlclasss.get(__i);
        umlclassx.writeCSV(_out_umlclass);
      }
      _out_umlclass.close();
      File _attribute = new File("Attribute.csv");
      PrintWriter _out_attribute = new PrintWriter(new BufferedWriter(new FileWriter(_attribute)));
      for (int __i = 0; __i < attributes.size(); __i++)
      { Attribute attributex = (Attribute) attributes.get(__i);
        attributex.writeCSV(_out_attribute);
      }
      _out_attribute.close();
      File _umlmethod = new File("UMLMethod.csv");
      PrintWriter _out_umlmethod = new PrintWriter(new BufferedWriter(new FileWriter(_umlmethod)));
      for (int __i = 0; __i < umlmethods.size(); __i++)
      { UMLMethod umlmethodx = (UMLMethod) umlmethods.get(__i);
        umlmethodx.writeCSV(_out_umlmethod);
      }
      _out_umlmethod.close();
      File _geneticalgorithm = new File("GeneticAlgorithm.csv");
      PrintWriter _out_geneticalgorithm = new PrintWriter(new BufferedWriter(new FileWriter(_geneticalgorithm)));
      for (int __i = 0; __i < geneticalgorithms.size(); __i++)
      { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(__i);
        geneticalgorithmx.writeCSV(_out_geneticalgorithm);
      }
      _out_geneticalgorithm.close();
      File _gaindividual = new File("GAIndividual.csv");
      PrintWriter _out_gaindividual = new PrintWriter(new BufferedWriter(new FileWriter(_gaindividual)));
      for (int __i = 0; __i < gaindividuals.size(); __i++)
      { GAIndividual gaindividualx = (GAIndividual) gaindividuals.get(__i);
        gaindividualx.writeCSV(_out_gaindividual);
      }
      _out_gaindividual.close();
      File _gatrait = new File("GATrait.csv");
      PrintWriter _out_gatrait = new PrintWriter(new BufferedWriter(new FileWriter(_gatrait)));
      for (int __i = 0; __i < gatraits.size(); __i++)
      { GATrait gatraitx = (GATrait) gatraits.get(__i);
        gatraitx.writeCSV(_out_gatrait);
      }
      _out_gatrait.close();
      File _createclasses = new File("CreateClasses.csv");
      PrintWriter _out_createclasses = new PrintWriter(new BufferedWriter(new FileWriter(_createclasses)));
      for (int __i = 0; __i < createclassess.size(); __i++)
      { CreateClasses createclassesx = (CreateClasses) createclassess.get(__i);
        createclassesx.writeCSV(_out_createclasses);
      }
      _out_createclasses.close();
      File _refactor = new File("Refactor.csv");
      PrintWriter _out_refactor = new PrintWriter(new BufferedWriter(new FileWriter(_refactor)));
      for (int __i = 0; __i < refactors.size(); __i++)
      { Refactor refactorx = (Refactor) refactors.get(__i);
        refactorx.writeCSV(_out_refactor);
      }
      _out_refactor.close();
      File _cleanup = new File("Cleanup.csv");
      PrintWriter _out_cleanup = new PrintWriter(new BufferedWriter(new FileWriter(_cleanup)));
      for (int __i = 0; __i < cleanups.size(); __i++)
      { Cleanup cleanupx = (Cleanup) cleanups.get(__i);
        cleanupx.writeCSV(_out_cleanup);
      }
      _out_cleanup.close();
      File _measures = new File("Measures.csv");
      PrintWriter _out_measures = new PrintWriter(new BufferedWriter(new FileWriter(_measures)));
      for (int __i = 0; __i < measuress.size(); __i++)
      { Measures measuresx = (Measures) measuress.get(__i);
        measuresx.writeCSV(_out_measures);
      }
      _out_measures.close();
      File _preprocess = new File("Preprocess.csv");
      PrintWriter _out_preprocess = new PrintWriter(new BufferedWriter(new FileWriter(_preprocess)));
      for (int __i = 0; __i < preprocesss.size(); __i++)
      { Preprocess preprocessx = (Preprocess) preprocesss.get(__i);
        preprocessx.writeCSV(_out_preprocess);
      }
      _out_preprocess.close();
      File _evolve = new File("Evolve.csv");
      PrintWriter _out_evolve = new PrintWriter(new BufferedWriter(new FileWriter(_evolve)));
      for (int __i = 0; __i < evolves.size(); __i++)
      { Evolve evolvex = (Evolve) evolves.get(__i);
        evolvex.writeCSV(_out_evolve);
      }
      _out_evolve.close();
      File _nextgeneration = new File("Nextgeneration.csv");
      PrintWriter _out_nextgeneration = new PrintWriter(new BufferedWriter(new FileWriter(_nextgeneration)));
      for (int __i = 0; __i < nextgenerations.size(); __i++)
      { Nextgeneration nextgenerationx = (Nextgeneration) nextgenerations.get(__i);
        nextgenerationx.writeCSV(_out_nextgeneration);
      }
      _out_nextgeneration.close();
      File _initialise = new File("Initialise.csv");
      PrintWriter _out_initialise = new PrintWriter(new BufferedWriter(new FileWriter(_initialise)));
      for (int __i = 0; __i < initialises.size(); __i++)
      { Initialise initialisex = (Initialise) initialises.get(__i);
        initialisex.writeCSV(_out_initialise);
      }
      _out_initialise.close();
      File _postprocess = new File("Postprocess.csv");
      PrintWriter _out_postprocess = new PrintWriter(new BufferedWriter(new FileWriter(_postprocess)));
      for (int __i = 0; __i < postprocesss.size(); __i++)
      { Postprocess postprocessx = (Postprocess) postprocesss.get(__i);
        postprocessx.writeCSV(_out_postprocess);
      }
      _out_postprocess.close();
      File _ga = new File("Ga.csv");
      PrintWriter _out_ga = new PrintWriter(new BufferedWriter(new FileWriter(_ga)));
      for (int __i = 0; __i < gas.size(); __i++)
      { Ga gax = (Ga) gas.get(__i);
        gax.writeCSV(_out_ga);
      }
      _out_ga.close();
      File _createclasses1 = new File("CreateClasses1.csv");
      PrintWriter _out_createclasses1 = new PrintWriter(new BufferedWriter(new FileWriter(_createclasses1)));
      for (int __i = 0; __i < createclasses1s.size(); __i++)
      { CreateClasses1 createclasses1x = (CreateClasses1) createclasses1s.get(__i);
        createclasses1x.writeCSV(_out_createclasses1);
      }
      _out_createclasses1.close();
    }
    catch(Exception __e) { }
  }



  public void addClassModel(ClassModel oo) { classmodels.add(oo); addNamedElement(oo); }

  public ClassModel getClassModelByPK(String namex)
  { if (!(namedelementnameindex.get(namex) instanceof ClassModel)) { return null; }
  return (ClassModel) namedelementnameindex.get(namex); }

  public List getClassModelByPK(List namex)
  { Vector res = new Vector(); 
    for (int _i = 0; _i < namex.size(); _i++)
    { ClassModel classmodelx = getClassModelByPK((String) namex.get(_i));
      if (classmodelx != null) { res.add(classmodelx); }
    }
    return res; 
  }

  public void addUMLClass(UMLClass oo) { umlclasss.add(oo); addNamedElement(oo); }

  public UMLClass getUMLClassByPK(String namex)
  { if (!(namedelementnameindex.get(namex) instanceof UMLClass)) { return null; }
  return (UMLClass) namedelementnameindex.get(namex); }

  public List getUMLClassByPK(List namex)
  { Vector res = new Vector(); 
    for (int _i = 0; _i < namex.size(); _i++)
    { UMLClass umlclassx = getUMLClassByPK((String) namex.get(_i));
      if (umlclassx != null) { res.add(umlclassx); }
    }
    return res; 
  }

  public void addAttribute(Attribute oo) { attributes.add(oo); addFeature(oo); }

  public Attribute getAttributeByPK(String namex)
  { if (!(namedelementnameindex.get(namex) instanceof Attribute)) { return null; }
  return (Attribute) namedelementnameindex.get(namex); }

  public List getAttributeByPK(List namex)
  { Vector res = new Vector(); 
    for (int _i = 0; _i < namex.size(); _i++)
    { Attribute attributex = getAttributeByPK((String) namex.get(_i));
      if (attributex != null) { res.add(attributex); }
    }
    return res; 
  }

  public void addUMLMethod(UMLMethod oo) { umlmethods.add(oo); addFeature(oo); }

  public UMLMethod getUMLMethodByPK(String namex)
  { if (!(namedelementnameindex.get(namex) instanceof UMLMethod)) { return null; }
  return (UMLMethod) namedelementnameindex.get(namex); }

  public List getUMLMethodByPK(List namex)
  { Vector res = new Vector(); 
    for (int _i = 0; _i < namex.size(); _i++)
    { UMLMethod umlmethodx = getUMLMethodByPK((String) namex.get(_i));
      if (umlmethodx != null) { res.add(umlmethodx); }
    }
    return res; 
  }

  public void addFeature(Feature oo) { features.add(oo); addNamedElement(oo); }

  public Feature getFeatureByPK(String namex)
  { if (!(namedelementnameindex.get(namex) instanceof Feature)) { return null; }
  return (Feature) namedelementnameindex.get(namex); }

  public List getFeatureByPK(List namex)
  { Vector res = new Vector(); 
    for (int _i = 0; _i < namex.size(); _i++)
    { Feature featurex = getFeatureByPK((String) namex.get(_i));
      if (featurex != null) { res.add(featurex); }
    }
    return res; 
  }

  public void addNamedElement(NamedElement oo) { namedelements.add(oo); }

  public NamedElement getNamedElementByPK(String namex)
  {  return (NamedElement) namedelementnameindex.get(namex); }

  public List getNamedElementByPK(List namex)
  { Vector res = new Vector(); 
    for (int _i = 0; _i < namex.size(); _i++)
    { NamedElement namedelementx = getNamedElementByPK((String) namex.get(_i));
      if (namedelementx != null) { res.add(namedelementx); }
    }
    return res; 
  }

  public void addGeneticAlgorithm(GeneticAlgorithm oo) { geneticalgorithms.add(oo); }

  public void addGAIndividual(GAIndividual oo) { gaindividuals.add(oo); }

  public void addGATrait(GATrait oo) { gatraits.add(oo); }

  public void addCreateClasses(CreateClasses oo) { createclassess.add(oo); }

  public void addRefactor(Refactor oo) { refactors.add(oo); }

  public void addCleanup(Cleanup oo) { cleanups.add(oo); }

  public void addMeasures(Measures oo) { measuress.add(oo); }

  public void addPreprocess(Preprocess oo) { preprocesss.add(oo); }

  public void addEvolve(Evolve oo) { evolves.add(oo); }

  public void addNextgeneration(Nextgeneration oo) { nextgenerations.add(oo); }

  public void addInitialise(Initialise oo) { initialises.add(oo); }

  public void addPostprocess(Postprocess oo) { postprocesss.add(oo); }

  public void addGa(Ga oo) { gas.add(oo); }

  public void addCreateClasses1(CreateClasses1 oo) { createclasses1s.add(oo); }



  public ClassModel createClassModel()
  { ClassModel classmodelx = new ClassModel();
    addClassModel(classmodelx);
    return classmodelx;
  }

  public UMLClass createUMLClass()
  { UMLClass umlclassx = new UMLClass();
    addUMLClass(umlclassx);
    return umlclassx;
  }

  public Attribute createAttribute()
  { Attribute attributex = new Attribute();
    addAttribute(attributex);
    return attributex;
  }

  public UMLMethod createUMLMethod()
  { UMLMethod umlmethodx = new UMLMethod();
    addUMLMethod(umlmethodx);
    return umlmethodx;
  }

  public GeneticAlgorithm createGeneticAlgorithm()
  { GeneticAlgorithm geneticalgorithmx = new GeneticAlgorithm();
    addGeneticAlgorithm(geneticalgorithmx);
    return geneticalgorithmx;
  }

  public GAIndividual createGAIndividual()
  { GAIndividual gaindividualx = new GAIndividual();
    addGAIndividual(gaindividualx);
    return gaindividualx;
  }

  public GATrait createGATrait()
  { GATrait gatraitx = new GATrait();
    addGATrait(gatraitx);
    return gatraitx;
  }

  public CreateClasses createCreateClasses()
  { CreateClasses createclassesx = new CreateClasses();
    addCreateClasses(createclassesx);
    return createclassesx;
  }

  public Refactor createRefactor()
  { Refactor refactorx = new Refactor();
    addRefactor(refactorx);
    return refactorx;
  }

  public Cleanup createCleanup()
  { Cleanup cleanupx = new Cleanup();
    addCleanup(cleanupx);
    return cleanupx;
  }

  public Measures createMeasures()
  { Measures measuresx = new Measures();
    addMeasures(measuresx);
    return measuresx;
  }

  public Preprocess createPreprocess()
  { Preprocess preprocessx = new Preprocess();
    addPreprocess(preprocessx);
    return preprocessx;
  }

  public Evolve createEvolve()
  { Evolve evolvex = new Evolve();
    addEvolve(evolvex);
    return evolvex;
  }

  public Nextgeneration createNextgeneration()
  { Nextgeneration nextgenerationx = new Nextgeneration();
    addNextgeneration(nextgenerationx);
    return nextgenerationx;
  }

  public Initialise createInitialise()
  { Initialise initialisex = new Initialise();
    addInitialise(initialisex);
    return initialisex;
  }

  public Postprocess createPostprocess()
  { Postprocess postprocessx = new Postprocess();
    addPostprocess(postprocessx);
    return postprocessx;
  }

  public Ga createGa()
  { Ga gax = new Ga();
    addGa(gax);
    return gax;
  }

  public CreateClasses1 createCreateClasses1()
  { CreateClasses1 createclasses1x = new CreateClasses1();
    addCreateClasses1(createclasses1x);
    return createclasses1x;
  }


  public void setclasses(ClassModel classmodelx, List classesxx) 
  {     classmodelx.setclasses(classesxx);
      }


  public void addclasses(ClassModel classmodelx, UMLClass classesxx) 
  { if (classmodelx.getclasses().contains(classesxx)) { return; }
      classmodelx.addclasses(classesxx);
   }


  public void removeclasses(ClassModel classmodelx, UMLClass classesxx) 
  { classmodelx.removeclasses(classesxx);
    }


 public void unionclasses(ClassModel classmodelx,List classesx)
  { for (int _i = 0; _i < classesx.size(); _i++)
    { UMLClass umlclassxclasses = (UMLClass) classesx.get(_i);
      addclasses(classmodelx,umlclassxclasses);
     } } 


 public void subtractclasses(ClassModel classmodelx,List classesx)
  { for (int _i = 0; _i < classesx.size(); _i++)
    { UMLClass umlclassxclasses = (UMLClass) classesx.get(_i);
      removeclasses(classmodelx,umlclassxclasses);
     } } 


  public void setfeatures(ClassModel classmodelx, List featuresxx) 
  {     classmodelx.setfeatures(featuresxx);
      }


  public void addfeatures(ClassModel classmodelx, Feature featuresxx) 
  { if (classmodelx.getfeatures().contains(featuresxx)) { return; }
      classmodelx.addfeatures(featuresxx);
   }


  public void removefeatures(ClassModel classmodelx, Feature featuresxx) 
  { classmodelx.removefeatures(featuresxx);
    }


 public void unionfeatures(ClassModel classmodelx,List featuresx)
  { for (int _i = 0; _i < featuresx.size(); _i++)
    { Feature featurexfeatures = (Feature) featuresx.get(_i);
      addfeatures(classmodelx,featurexfeatures);
     } } 


 public void subtractfeatures(ClassModel classmodelx,List featuresx)
  { for (int _i = 0; _i < featuresx.size(); _i++)
    { Feature featurexfeatures = (Feature) featuresx.get(_i);
      removefeatures(classmodelx,featurexfeatures);
     } } 


  public void setencapsulates(UMLClass umlclassx, List encapsulatesxx) 
  {   List _oldencapsulatesxx = umlclassx.getencapsulates();
    for (int _j = 0; _j < _oldencapsulatesxx.size(); _j++)
    { Feature _yy = (Feature) _oldencapsulatesxx.get(_j);
      if (encapsulatesxx.contains(_yy)) { }
      else { _yy.removeisEncapsulatedBy(umlclassx); }
    }
  for (int _i = 0; _i < encapsulatesxx.size(); _i++)
  { Feature _xx = (Feature) encapsulatesxx.get(_i);
    if (_oldencapsulatesxx.contains(_xx)) { }
    else { UMLClass.removeAllencapsulates(_xx.getisEncapsulatedBy(),_xx); }
    Vector _xxNewValue = new Vector();
    _xxNewValue.add(umlclassx);
    _xx.setisEncapsulatedBy(_xxNewValue);
  }
    umlclassx.setencapsulates(encapsulatesxx);
      }


  public void addencapsulates(UMLClass umlclassx, Feature encapsulatesxx) 
  { if (umlclassx.getencapsulates().contains(encapsulatesxx)) { return; }
    UMLClass.removeAllencapsulates(encapsulatesxx.getisEncapsulatedBy(),encapsulatesxx);
  encapsulatesxx.addisEncapsulatedBy(umlclassx);
    umlclassx.addencapsulates(encapsulatesxx);
   }


  public void removeencapsulates(UMLClass umlclassx, Feature encapsulatesxx) 
  { umlclassx.removeencapsulates(encapsulatesxx);
      encapsulatesxx.removeisEncapsulatedBy(umlclassx);
  }


 public void unionencapsulates(UMLClass umlclassx,List encapsulatesx)
  { for (int _i = 0; _i < encapsulatesx.size(); _i++)
    { Feature featurexencapsulates = (Feature) encapsulatesx.get(_i);
      addencapsulates(umlclassx,featurexencapsulates);
     } } 


 public void subtractencapsulates(UMLClass umlclassx,List encapsulatesx)
  { for (int _i = 0; _i < encapsulatesx.size(); _i++)
    { Feature featurexencapsulates = (Feature) encapsulatesx.get(_i);
      removeencapsulates(umlclassx,featurexencapsulates);
     } } 


  public void setdataDependency(UMLMethod umlmethodx, List dataDependencyxx) 
  {     umlmethodx.setdataDependency(dataDependencyxx);
      }


  public void adddataDependency(UMLMethod umlmethodx, Attribute dataDependencyxx) 
  { if (umlmethodx.getdataDependency().contains(dataDependencyxx)) { return; }
      umlmethodx.adddataDependency(dataDependencyxx);
   }


  public void removedataDependency(UMLMethod umlmethodx, Attribute dataDependencyxx) 
  { umlmethodx.removedataDependency(dataDependencyxx);
    }


 public void uniondataDependency(UMLMethod umlmethodx,List dataDependencyx)
  { for (int _i = 0; _i < dataDependencyx.size(); _i++)
    { Attribute attributexdataDependency = (Attribute) dataDependencyx.get(_i);
      adddataDependency(umlmethodx,attributexdataDependency);
     } } 


 public void subtractdataDependency(UMLMethod umlmethodx,List dataDependencyx)
  { for (int _i = 0; _i < dataDependencyx.size(); _i++)
    { Attribute attributexdataDependency = (Attribute) dataDependencyx.get(_i);
      removedataDependency(umlmethodx,attributexdataDependency);
     } } 


  public void setfunctionalDependency(UMLMethod umlmethodx, List functionalDependencyxx) 
  {     umlmethodx.setfunctionalDependency(functionalDependencyxx);
      }


  public void addfunctionalDependency(UMLMethod umlmethodx, UMLMethod functionalDependencyxx) 
  { if (umlmethodx.getfunctionalDependency().contains(functionalDependencyxx)) { return; }
      umlmethodx.addfunctionalDependency(functionalDependencyxx);
   }


  public void removefunctionalDependency(UMLMethod umlmethodx, UMLMethod functionalDependencyxx) 
  { umlmethodx.removefunctionalDependency(functionalDependencyxx);
    }


 public void unionfunctionalDependency(UMLMethod umlmethodx,List functionalDependencyx)
  { for (int _i = 0; _i < functionalDependencyx.size(); _i++)
    { UMLMethod umlmethodxfunctionalDependency = (UMLMethod) functionalDependencyx.get(_i);
      addfunctionalDependency(umlmethodx,umlmethodxfunctionalDependency);
     } } 


 public void subtractfunctionalDependency(UMLMethod umlmethodx,List functionalDependencyx)
  { for (int _i = 0; _i < functionalDependencyx.size(); _i++)
    { UMLMethod umlmethodxfunctionalDependency = (UMLMethod) functionalDependencyx.get(_i);
      removefunctionalDependency(umlmethodx,umlmethodxfunctionalDependency);
     } } 


  public void setisEncapsulatedBy(Feature featurex, List isEncapsulatedByxx) 
  {   if (isEncapsulatedByxx.size() > 1) { return; }
  List _oldisEncapsulatedByxx = featurex.getisEncapsulatedBy();
    for (int _j = 0; _j < _oldisEncapsulatedByxx.size(); _j++)
    { UMLClass _yy = (UMLClass) _oldisEncapsulatedByxx.get(_j);
      if (isEncapsulatedByxx.contains(_yy)) { }
      else { _yy.removeencapsulates(featurex); }
    }
  for (int _i = 0; _i < isEncapsulatedByxx.size(); _i++)
  { UMLClass _xx = (UMLClass) isEncapsulatedByxx.get(_i);
    if (_oldisEncapsulatedByxx.contains(_xx)) { }
    else { _xx.addencapsulates(featurex); }
  }
    featurex.setisEncapsulatedBy(isEncapsulatedByxx);
      }


  public void addisEncapsulatedBy(Feature featurex, UMLClass isEncapsulatedByxx) 
  { if (featurex.getisEncapsulatedBy().contains(isEncapsulatedByxx)) { return; }
      if (featurex.getisEncapsulatedBy().size() > 0)
    { UMLClass umlclass_xx = (UMLClass) featurex.getisEncapsulatedBy().get(0);
      featurex.removeisEncapsulatedBy(umlclass_xx);
      umlclass_xx.removeencapsulates(featurex);
    }
    isEncapsulatedByxx.addencapsulates(featurex);
    featurex.addisEncapsulatedBy(isEncapsulatedByxx);
   }


  public void removeisEncapsulatedBy(Feature featurex, UMLClass isEncapsulatedByxx) 
  { featurex.removeisEncapsulatedBy(isEncapsulatedByxx);
      isEncapsulatedByxx.removeencapsulates(featurex);
  }


 public void unionisEncapsulatedBy(Feature featurex,List isEncapsulatedByx)
  { for (int _i = 0; _i < isEncapsulatedByx.size(); _i++)
    { UMLClass umlclassxisEncapsulatedBy = (UMLClass) isEncapsulatedByx.get(_i);
      addisEncapsulatedBy(featurex,umlclassxisEncapsulatedBy);
     } } 


 public void subtractisEncapsulatedBy(Feature featurex,List isEncapsulatedByx)
  { for (int _i = 0; _i < isEncapsulatedByx.size(); _i++)
    { UMLClass umlclassxisEncapsulatedBy = (UMLClass) isEncapsulatedByx.get(_i);
      removeisEncapsulatedBy(featurex,umlclassxisEncapsulatedBy);
     } } 


public void setname(NamedElement namedelementx, String name_x) 
  { if (namedelementnameindex.get(name_x) != null) { return; }
  namedelementnameindex.remove(namedelementx.getname());
  namedelementx.setname(name_x);
  namedelementnameindex.put(name_x,namedelementx);
    }


public void setmaxfitness(double maxfitness_x) 
  { GeneticAlgorithm.setmaxfitness(maxfitness_x);
  for (int i = 0; i < geneticalgorithms.size(); i++)
  { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(i);
    setmaxfitness(geneticalgorithmx,maxfitness_x); } }

  public void setmaxfitness(GeneticAlgorithm geneticalgorithmx, double maxfitness_x) 
  { geneticalgorithmx.localSetmaxfitness(maxfitness_x);
    }


public void setmaxvalue(int maxvalue_x) 
  { GeneticAlgorithm.setmaxvalue(maxvalue_x);
  for (int i = 0; i < geneticalgorithms.size(); i++)
  { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(i);
    setmaxvalue(geneticalgorithmx,maxvalue_x); } }

  public void setmaxvalue(GeneticAlgorithm geneticalgorithmx, int maxvalue_x) 
  { geneticalgorithmx.localSetmaxvalue(maxvalue_x);
    }


public void setmaxpop(int maxpop_x) 
  { GeneticAlgorithm.setmaxpop(maxpop_x);
  for (int i = 0; i < geneticalgorithms.size(); i++)
  { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithms.get(i);
    setmaxpop(geneticalgorithmx,maxpop_x); } }

  public void setmaxpop(GeneticAlgorithm geneticalgorithmx, int maxpop_x) 
  { geneticalgorithmx.localSetmaxpop(maxpop_x);
    }


  public void setpopulation(GeneticAlgorithm geneticalgorithmx, List populationxx) 
  {   List _oldpopulationxx = geneticalgorithmx.getpopulation();
  for (int _i = 0; _i < populationxx.size(); _i++)
  { GAIndividual _xx = (GAIndividual) populationxx.get(_i);
    if (_oldpopulationxx.contains(_xx)) { }
    else { GeneticAlgorithm.removeAllpopulation(geneticalgorithms, _xx); }
  }
    geneticalgorithmx.setpopulation(populationxx);
      }


  public void addpopulation(GeneticAlgorithm geneticalgorithmx, GAIndividual populationxx) 
  { if (geneticalgorithmx.getpopulation().contains(populationxx)) { return; }
    GeneticAlgorithm.removeAllpopulation(geneticalgorithms,populationxx);
    geneticalgorithmx.addpopulation(populationxx);
   }


  public void removepopulation(GeneticAlgorithm geneticalgorithmx, GAIndividual populationxx) 
  { geneticalgorithmx.removepopulation(populationxx);
    }


 public void unionpopulation(GeneticAlgorithm geneticalgorithmx,List populationx)
  { for (int _i = 0; _i < populationx.size(); _i++)
    { GAIndividual gaindividualxpopulation = (GAIndividual) populationx.get(_i);
      addpopulation(geneticalgorithmx,gaindividualxpopulation);
     } } 


 public void subtractpopulation(GeneticAlgorithm geneticalgorithmx,List populationx)
  { for (int _i = 0; _i < populationx.size(); _i++)
    { GAIndividual gaindividualxpopulation = (GAIndividual) populationx.get(_i);
      removepopulation(geneticalgorithmx,gaindividualxpopulation);
     } } 


  public void setelite(GeneticAlgorithm geneticalgorithmx, List elitexx) 
  {     geneticalgorithmx.setelite(elitexx);
      }


  public void addelite(GeneticAlgorithm geneticalgorithmx, GAIndividual elitexx) 
  { if (geneticalgorithmx.getelite().contains(elitexx)) { return; }
      geneticalgorithmx.addelite(elitexx);
   }


  public void removeelite(GeneticAlgorithm geneticalgorithmx, GAIndividual elitexx) 
  { geneticalgorithmx.removeelite(elitexx);
    }


 public void unionelite(GeneticAlgorithm geneticalgorithmx,List elitex)
  { for (int _i = 0; _i < elitex.size(); _i++)
    { GAIndividual gaindividualxelite = (GAIndividual) elitex.get(_i);
      addelite(geneticalgorithmx,gaindividualxelite);
     } } 


 public void subtractelite(GeneticAlgorithm geneticalgorithmx,List elitex)
  { for (int _i = 0; _i < elitex.size(); _i++)
    { GAIndividual gaindividualxelite = (GAIndividual) elitex.get(_i);
      removeelite(geneticalgorithmx,gaindividualxelite);
     } } 


  public void setrecombined(GeneticAlgorithm geneticalgorithmx, List recombinedxx) 
  {     geneticalgorithmx.setrecombined(recombinedxx);
      }


  public void addrecombined(GeneticAlgorithm geneticalgorithmx, GAIndividual recombinedxx) 
  { if (geneticalgorithmx.getrecombined().contains(recombinedxx)) { return; }
      geneticalgorithmx.addrecombined(recombinedxx);
   }


  public void removerecombined(GeneticAlgorithm geneticalgorithmx, GAIndividual recombinedxx) 
  { geneticalgorithmx.removerecombined(recombinedxx);
    }


 public void unionrecombined(GeneticAlgorithm geneticalgorithmx,List recombinedx)
  { for (int _i = 0; _i < recombinedx.size(); _i++)
    { GAIndividual gaindividualxrecombined = (GAIndividual) recombinedx.get(_i);
      addrecombined(geneticalgorithmx,gaindividualxrecombined);
     } } 


 public void subtractrecombined(GeneticAlgorithm geneticalgorithmx,List recombinedx)
  { for (int _i = 0; _i < recombinedx.size(); _i++)
    { GAIndividual gaindividualxrecombined = (GAIndividual) recombinedx.get(_i);
      removerecombined(geneticalgorithmx,gaindividualxrecombined);
     } } 


  public void setmutated(GeneticAlgorithm geneticalgorithmx, List mutatedxx) 
  {     geneticalgorithmx.setmutated(mutatedxx);
      }


  public void addmutated(GeneticAlgorithm geneticalgorithmx, GAIndividual mutatedxx) 
  { if (geneticalgorithmx.getmutated().contains(mutatedxx)) { return; }
      geneticalgorithmx.addmutated(mutatedxx);
   }


  public void removemutated(GeneticAlgorithm geneticalgorithmx, GAIndividual mutatedxx) 
  { geneticalgorithmx.removemutated(mutatedxx);
    }


 public void unionmutated(GeneticAlgorithm geneticalgorithmx,List mutatedx)
  { for (int _i = 0; _i < mutatedx.size(); _i++)
    { GAIndividual gaindividualxmutated = (GAIndividual) mutatedx.get(_i);
      addmutated(geneticalgorithmx,gaindividualxmutated);
     } } 


 public void subtractmutated(GeneticAlgorithm geneticalgorithmx,List mutatedx)
  { for (int _i = 0; _i < mutatedx.size(); _i++)
    { GAIndividual gaindividualxmutated = (GAIndividual) mutatedx.get(_i);
      removemutated(geneticalgorithmx,gaindividualxmutated);
     } } 


public void setfitnessval(GAIndividual gaindividualx, double fitnessval_x) 
  { gaindividualx.setfitnessval(fitnessval_x);
    }


  public void settraits(GAIndividual gaindividualx, List traitsxx) 
  {     gaindividualx.settraits(traitsxx);
      }


  public void settraits(GAIndividual gaindividualx, int _ind, GATrait gatraitx) 
  { gaindividualx.settraits(_ind,gatraitx); }
  
  public void addtraits(GAIndividual gaindividualx, GATrait traitsxx) 
  {     gaindividualx.addtraits(traitsxx);
   }


  public void removetraits(GAIndividual gaindividualx, GATrait traitsxx) 
  { gaindividualx.removetraits(traitsxx);
    }


 public void uniontraits(GAIndividual gaindividualx,List traitsx)
  { for (int _i = 0; _i < traitsx.size(); _i++)
    { GATrait gatraitxtraits = (GATrait) traitsx.get(_i);
      addtraits(gaindividualx,gatraitxtraits);
     } } 


 public void subtracttraits(GAIndividual gaindividualx,List traitsx)
  { for (int _i = 0; _i < traitsx.size(); _i++)
    { GATrait gatraitxtraits = (GATrait) traitsx.get(_i);
      removetraits(gaindividualx,gatraitxtraits);
     } } 


public void setitem(GATrait gatraitx, String item_x) 
  { gatraitx.setitem(item_x);
    }


public void setvalue(GATrait gatraitx, int value_x) 
  { gatraitx.setvalue(value_x);
    }



  public void cleanup2(ClassModel classmodelx)
  {   classmodelx.cleanup2();
   }

  public void measures1(ClassModel classmodelx,UMLClass c)
  {   classmodelx.measures1(c);
   }

  public void measures1outer(ClassModel classmodelx)
  {   classmodelx.measures1outer();
   }

  public void measures2(ClassModel classmodelx)
  {   classmodelx.measures2();
   }

  public void measures3(ClassModel classmodelx)
  {   classmodelx.measures3();
   }

  public void measures4(ClassModel classmodelx)
  {   classmodelx.measures4();
   }

  public void initialise1(ClassModel classmodelx,int nclasses)
  {   classmodelx.initialise1(nclasses);
   }

  public void initialise1outer(ClassModel classmodelx)
  {   classmodelx.initialise1outer();
   }

  public void refactor1(UMLClass umlclassx,Feature m,UMLClass c,List depends)
  {   umlclassx.refactor1(m, c, depends);
   }

  public void refactor1outer(UMLClass umlclassx)
  {   umlclassx.refactor1outer();
   }

  public void refactor2(UMLClass umlclassx,Feature a,UMLClass c,List dependings)
  {   umlclassx.refactor2(a, c, dependings);
   }

  public void refactor2outer(UMLClass umlclassx)
  {   umlclassx.refactor2outer();
   }

  public void cleanup1(UMLClass umlclassx)
  {   //  if (!(umlclassx.getencapsulates().size() == 0)) { return; } 
    umlclassx.cleanup1();
   }

  public  List AllUMLClasscleanup1test(List umlclassxs)
  { 
    List result = new Vector();
    for (int _i = 0; _i < umlclassxs.size(); _i++)
    { UMLClass umlclassx = (UMLClass) umlclassxs.get(_i);
      result.add(new Boolean(umlclassx.cleanup1test()));
    }
    return result; 
  }

 public static boolean cleanup1search()
 { return UMLClass.cleanup1search(); }

  public void createclasses2(Attribute attributex)
  {   attributex.createclasses2();
   }

  public  List AllUMLMethoddependsOn(List umlmethodxs,List seen)
  { 
    List result = new Vector();
    for (int _i = 0; _i < umlmethodxs.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) umlmethodxs.get(_i);
      result.addAll(umlmethodx.dependsOn(seen));
    }
    return result; 
  }

  public void createclasses1(UMLMethod umlmethodx)
  {   umlmethodx.createclasses1();
   }

  public void createclasses3(UMLMethod umlmethodx,UMLClass c)
  {   umlmethodx.createclasses3(c);
   }

  public void createclasses3outer(UMLMethod umlmethodx)
  {   umlmethodx.createclasses3outer();
   }

  public void createclasses4(UMLMethod umlmethodx,List unencapdas)
  {   umlmethodx.createclasses4(unencapdas);
   }

  public void createclasses4outer(UMLMethod umlmethodx)
  {   umlmethodx.createclasses4outer();
   }

  public void createclasses5(UMLMethod umlmethodx,UMLClass c)
  {   umlmethodx.createclasses5(c);
   }

  public void createclasses5outer(UMLMethod umlmethodx)
  {   umlmethodx.createclasses5outer();
   }

  public void createclasses11(UMLMethod umlmethodx,List deps)
  {   umlmethodx.createclasses11(deps);
   }

  public void createclasses11outer(UMLMethod umlmethodx)
  {   umlmethodx.createclasses11outer();
   }

  public void cull(GeneticAlgorithm geneticalgorithmx,List p,int n)
  {   geneticalgorithmx.cull(p, n);
   }

  public  List AllGeneticAlgorithmcull(List geneticalgorithmxs,List p,int n)
  { 
    List result = new Vector();
    for (int i = 0; i < geneticalgorithmxs.size(); i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) geneticalgorithmxs.get(i);
      cull(geneticalgorithmx,p, n);
    }
    return result; 
  }

  public void evolve1(GeneticAlgorithm geneticalgorithmx,GAIndividual p)
  {   geneticalgorithmx.evolve1(p);
   }

  public void evolve1outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.evolve1outer();
   }

  public void evolve2(GeneticAlgorithm geneticalgorithmx,GAIndividual p)
  {   geneticalgorithmx.evolve2(p);
   }

  public void evolve2outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.evolve2outer();
   }

  public void evolve3(GeneticAlgorithm geneticalgorithmx,GAIndividual p,GAIndividual q)
  {   geneticalgorithmx.evolve3(p, q);
   }

  public void evolve3outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.evolve3outer();
   }

  public void evolve4(GeneticAlgorithm geneticalgorithmx,GAIndividual p,GAIndividual q)
  {   geneticalgorithmx.evolve4(p, q);
   }

  public void evolve4outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.evolve4outer();
   }

  public void nextgeneration1(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.nextgeneration1();
   }

  public void nextgeneration2(GeneticAlgorithm geneticalgorithmx,GAIndividual p)
  {   geneticalgorithmx.nextgeneration2(p);
   }

  public void nextgeneration2outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.nextgeneration2outer();
   }

  public void nextgeneration3(GeneticAlgorithm geneticalgorithmx,GAIndividual p)
  {   geneticalgorithmx.nextgeneration3(p);
   }

  public void nextgeneration3outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.nextgeneration3outer();
   }

  public void nextgeneration4(GeneticAlgorithm geneticalgorithmx,GAIndividual p)
  {   geneticalgorithmx.nextgeneration4(p);
   }

  public void nextgeneration4outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.nextgeneration4outer();
   }

  public void nextgeneration5(GeneticAlgorithm geneticalgorithmx,GAIndividual p)
  {   geneticalgorithmx.nextgeneration5(p);
   }

  public void nextgeneration5outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.nextgeneration5outer();
   }

  public void nextgeneration6(GeneticAlgorithm geneticalgorithmx,GAIndividual p)
  {   geneticalgorithmx.nextgeneration6(p);
   }

  public void nextgeneration6outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.nextgeneration6outer();
   }

  public void nextgeneration7(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.nextgeneration7();
   }

  public void nextgeneration8(GeneticAlgorithm geneticalgorithmx,List q)
  {   geneticalgorithmx.nextgeneration8(q);
   }

  public void nextgeneration8outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.nextgeneration8outer();
   }

  public void nextgeneration9(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.nextgeneration9();
   }

  public void nextgeneration10(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.nextgeneration10();
   }

  public void initialise2(GeneticAlgorithm geneticalgorithmx,int j)
  {   geneticalgorithmx.initialise2(j);
   }

  public void initialise2outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.initialise2outer();
   }

  public void initialise3(GeneticAlgorithm geneticalgorithmx,int i)
  {   geneticalgorithmx.initialise3(i);
   }

  public void initialise3outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.initialise3outer();
   }

  public void initialise4(GeneticAlgorithm geneticalgorithmx,GAIndividual p)
  {   geneticalgorithmx.initialise4(p);
   }

  public void initialise4outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.initialise4outer();
   }

  public void initialise5(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.initialise5();
   }

  public void postprocess1(GeneticAlgorithm geneticalgorithmx,GAIndividual g)
  {   geneticalgorithmx.postprocess1(g);
   }

  public void postprocess1outer(GeneticAlgorithm geneticalgorithmx)
  {   geneticalgorithmx.postprocess1outer();
   }

  public void ga2(GeneticAlgorithm geneticalgorithmx,int iter)
  {   geneticalgorithmx.ga2(iter);
   }

  public void ga2outer(GeneticAlgorithm geneticalgorithmx,int iter)
  {   geneticalgorithmx.ga2outer(iter);
   }

  public  List AllGAIndividualcombine(List gaindividualxs,GAIndividual g)
  { 
    List result = new Vector();
    for (int _i = 0; _i < gaindividualxs.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividualxs.get(_i);
      result.add(gaindividualx.combine(g));
    }
    return result; 
  }

  public  List AllGAIndividualmutate(List gaindividualxs)
  { 
    List result = new Vector();
    for (int _i = 0; _i < gaindividualxs.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividualxs.get(_i);
      result.add(gaindividualx.mutate());
    }
    return result; 
  }

  public  List AllGAIndividualtoString(List gaindividualxs)
  { 
    List result = new Vector();
    for (int _i = 0; _i < gaindividualxs.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividualxs.get(_i);
      result.add(gaindividualx.toString());
    }
    return result; 
  }

  public  List AllGAIndividualatts(List gaindividualxs,int c)
  { 
    List result = new Vector();
    for (int _i = 0; _i < gaindividualxs.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividualxs.get(_i);
      result.addAll(gaindividualx.atts(c));
    }
    return result; 
  }

  public  List AllGAIndividualmets(List gaindividualxs,int c)
  { 
    List result = new Vector();
    for (int _i = 0; _i < gaindividualxs.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividualxs.get(_i);
      result.addAll(gaindividualx.mets(c));
    }
    return result; 
  }

  public  List AllGAIndividualmai(List gaindividualxs,int ci,int cj)
  { 
    List result = new Vector();
    for (int _i = 0; _i < gaindividualxs.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividualxs.get(_i);
      result.add(new Integer(gaindividualx.mai(ci, cj)));
    }
    return result; 
  }

  public  List AllGAIndividualmmi(List gaindividualxs,int ci,int cj)
  { 
    List result = new Vector();
    for (int _i = 0; _i < gaindividualxs.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividualxs.get(_i);
      result.add(new Integer(gaindividualx.mmi(ci, cj)));
    }
    return result; 
  }

  public  List AllGAIndividualcohesion(List gaindividualxs,int ci)
  { 
    List result = new Vector();
    for (int _i = 0; _i < gaindividualxs.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividualxs.get(_i);
      result.add(new Double(gaindividualx.cohesion(ci)));
    }
    return result; 
  }

  public  List AllGAIndividualcohesionrat(List gaindividualxs)
  { 
    List result = new Vector();
    for (int _i = 0; _i < gaindividualxs.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividualxs.get(_i);
      result.add(new Double(gaindividualx.cohesionrat()));
    }
    return result; 
  }

  public  List AllGAIndividualcoupling(List gaindividualxs,int ci,int cj)
  { 
    List result = new Vector();
    for (int _i = 0; _i < gaindividualxs.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividualxs.get(_i);
      result.add(new Double(gaindividualx.coupling(ci, cj)));
    }
    return result; 
  }

  public  List AllGAIndividualcouplingrat(List gaindividualxs)
  { 
    List result = new Vector();
    for (int _i = 0; _i < gaindividualxs.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividualxs.get(_i);
      result.add(new Double(gaindividualx.couplingrat()));
    }
    return result; 
  }

  public  List AllGAIndividualfitness(List gaindividualxs)
  { 
    List result = new Vector();
    for (int _i = 0; _i < gaindividualxs.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) gaindividualxs.get(_i);
      result.add(new Double(gaindividualx.fitness()));
    }
    return result; 
  }



  public void killAllClassModel(List classmodelxx)
  { for (int _i = 0; _i < classmodelxx.size(); _i++)
    { killClassModel((ClassModel) classmodelxx.get(_i)); }
  }

  public void killClassModel(ClassModel classmodelxx)
  { if (classmodelxx == null) { return; }
   classmodels.remove(classmodelxx);
  killNamedElement(classmodelxx);
  }



  public void killAllUMLClass(List umlclassxx)
  { for (int _i = 0; _i < umlclassxx.size(); _i++)
    { killUMLClass((UMLClass) umlclassxx.get(_i)); }
  }

  public void killUMLClass(UMLClass umlclassxx)
  { if (umlclassxx == null) { return; }
   umlclasss.remove(umlclassxx);
    Vector _1qrangeclassesClassModel = new Vector();
    _1qrangeclassesClassModel.addAll(classmodels);
    for (int _i = 0; _i < _1qrangeclassesClassModel.size(); _i++)
    { ClassModel classmodelx = (ClassModel) _1qrangeclassesClassModel.get(_i);
      if (classmodelx != null && classmodelx.getclasses().contains(umlclassxx))
      { removeclasses(classmodelx,umlclassxx); }
    }
    Vector _2qrangeisEncapsulatedByFeature = new Vector();
    _2qrangeisEncapsulatedByFeature.addAll(umlclassxx.getencapsulates());
    for (int _i = 0; _i < _2qrangeisEncapsulatedByFeature.size(); _i++)
    { Feature featurex = (Feature) _2qrangeisEncapsulatedByFeature.get(_i);
      if (featurex != null && featurex.getisEncapsulatedBy().contains(umlclassxx))
      { removeisEncapsulatedBy(featurex,umlclassxx); }
    }

    umlclassxx.setencapsulates(new Vector());
  killNamedElement(umlclassxx);
  }



  public void killAllAttribute(List attributexx)
  { for (int _i = 0; _i < attributexx.size(); _i++)
    { killAttribute((Attribute) attributexx.get(_i)); }
  }

  public void killAttribute(Attribute attributexx)
  { if (attributexx == null) { return; }
   attributes.remove(attributexx);
    Vector _1qrangedataDependencyUMLMethod = new Vector();
    _1qrangedataDependencyUMLMethod.addAll(umlmethods);
    for (int _i = 0; _i < _1qrangedataDependencyUMLMethod.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) _1qrangedataDependencyUMLMethod.get(_i);
      if (umlmethodx != null && umlmethodx.getdataDependency().contains(attributexx))
      { removedataDependency(umlmethodx,attributexx); }
    }
  killFeature(attributexx);
  }



  public void killAllUMLMethod(List umlmethodxx)
  { for (int _i = 0; _i < umlmethodxx.size(); _i++)
    { killUMLMethod((UMLMethod) umlmethodxx.get(_i)); }
  }

  public void killUMLMethod(UMLMethod umlmethodxx)
  { if (umlmethodxx == null) { return; }
   umlmethods.remove(umlmethodxx);
    Vector _1qrangefunctionalDependencyUMLMethod = new Vector();
    _1qrangefunctionalDependencyUMLMethod.addAll(umlmethods);
    for (int _i = 0; _i < _1qrangefunctionalDependencyUMLMethod.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) _1qrangefunctionalDependencyUMLMethod.get(_i);
      if (umlmethodx != null && umlmethodx.getfunctionalDependency().contains(umlmethodxx))
      { removefunctionalDependency(umlmethodx,umlmethodxx); }
    }
  killFeature(umlmethodxx);
  }



  public void killAllFeature(List featurexx)
  { for (int _i = 0; _i < featurexx.size(); _i++)
    { killFeature((Feature) featurexx.get(_i)); }
  }

  public void killFeature(Feature featurexx)
  { if (featurexx == null) { return; }
   features.remove(featurexx);
    Vector _1qrangefeaturesClassModel = new Vector();
    _1qrangefeaturesClassModel.addAll(classmodels);
    for (int _i = 0; _i < _1qrangefeaturesClassModel.size(); _i++)
    { ClassModel classmodelx = (ClassModel) _1qrangefeaturesClassModel.get(_i);
      if (classmodelx != null && classmodelx.getfeatures().contains(featurexx))
      { removefeatures(classmodelx,featurexx); }
    }
    Vector _1qrangeencapsulatesUMLClass = new Vector();
    _1qrangeencapsulatesUMLClass.addAll(featurexx.getisEncapsulatedBy());
    for (int _i = 0; _i < _1qrangeencapsulatesUMLClass.size(); _i++)
    { UMLClass umlclassx = (UMLClass) _1qrangeencapsulatesUMLClass.get(_i);
      if (umlclassx != null && umlclassx.getencapsulates().contains(featurexx))
      { removeencapsulates(umlclassx,featurexx); }
    }
  killNamedElement(featurexx);
  }

  public void killAbstractFeature(Feature featurexx)
  {
    if (featurexx instanceof Attribute)
    { killAttribute((Attribute) featurexx); }
    if (featurexx instanceof UMLMethod)
    { killUMLMethod((UMLMethod) featurexx); }
  }

  public void killAbstractFeature(List _l)
  { for (int _i = 0; _i < _l.size(); _i++)
    { Feature _e = (Feature) _l.get(_i);
      killAbstractFeature(_e);
    }
  }



  public void killAllNamedElement(List namedelementxx)
  { for (int _i = 0; _i < namedelementxx.size(); _i++)
    { killNamedElement((NamedElement) namedelementxx.get(_i)); }
  }

  public void killNamedElement(NamedElement namedelementxx)
  { if (namedelementxx == null) { return; }
   namedelements.remove(namedelementxx);
    namedelementnameindex.remove(namedelementxx.getname());
  }

  public void killAbstractNamedElement(NamedElement namedelementxx)
  {
    if (namedelementxx instanceof ClassModel)
    { killClassModel((ClassModel) namedelementxx); }
    if (namedelementxx instanceof UMLClass)
    { killUMLClass((UMLClass) namedelementxx); }
    if (namedelementxx instanceof Attribute)
    { killAttribute((Attribute) namedelementxx); }
    if (namedelementxx instanceof UMLMethod)
    { killUMLMethod((UMLMethod) namedelementxx); }
  }

  public void killAbstractNamedElement(List _l)
  { for (int _i = 0; _i < _l.size(); _i++)
    { NamedElement _e = (NamedElement) _l.get(_i);
      killAbstractNamedElement(_e);
    }
  }



  public void killAllGeneticAlgorithm(List geneticalgorithmxx)
  { for (int _i = 0; _i < geneticalgorithmxx.size(); _i++)
    { killGeneticAlgorithm((GeneticAlgorithm) geneticalgorithmxx.get(_i)); }
  }

  public void killGeneticAlgorithm(GeneticAlgorithm geneticalgorithmxx)
  { if (geneticalgorithmxx == null) { return; }
   geneticalgorithms.remove(geneticalgorithmxx);
  }



  public void killAllGAIndividual(List gaindividualxx)
  { for (int _i = 0; _i < gaindividualxx.size(); _i++)
    { killGAIndividual((GAIndividual) gaindividualxx.get(_i)); }
  }

  public void killGAIndividual(GAIndividual gaindividualxx)
  { if (gaindividualxx == null) { return; }
   gaindividuals.remove(gaindividualxx);
    Vector _1qrangepopulationGeneticAlgorithm = new Vector();
    _1qrangepopulationGeneticAlgorithm.addAll(geneticalgorithms);
    for (int _i = 0; _i < _1qrangepopulationGeneticAlgorithm.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) _1qrangepopulationGeneticAlgorithm.get(_i);
      if (geneticalgorithmx != null && geneticalgorithmx.getpopulation().contains(gaindividualxx))
      { removepopulation(geneticalgorithmx,gaindividualxx); }
    }
    Vector _1qrangeeliteGeneticAlgorithm = new Vector();
    _1qrangeeliteGeneticAlgorithm.addAll(geneticalgorithms);
    for (int _i = 0; _i < _1qrangeeliteGeneticAlgorithm.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) _1qrangeeliteGeneticAlgorithm.get(_i);
      if (geneticalgorithmx != null && geneticalgorithmx.getelite().contains(gaindividualxx))
      { removeelite(geneticalgorithmx,gaindividualxx); }
    }
    Vector _1qrangerecombinedGeneticAlgorithm = new Vector();
    _1qrangerecombinedGeneticAlgorithm.addAll(geneticalgorithms);
    for (int _i = 0; _i < _1qrangerecombinedGeneticAlgorithm.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) _1qrangerecombinedGeneticAlgorithm.get(_i);
      if (geneticalgorithmx != null && geneticalgorithmx.getrecombined().contains(gaindividualxx))
      { removerecombined(geneticalgorithmx,gaindividualxx); }
    }
    Vector _1qrangemutatedGeneticAlgorithm = new Vector();
    _1qrangemutatedGeneticAlgorithm.addAll(geneticalgorithms);
    for (int _i = 0; _i < _1qrangemutatedGeneticAlgorithm.size(); _i++)
    { GeneticAlgorithm geneticalgorithmx = (GeneticAlgorithm) _1qrangemutatedGeneticAlgorithm.get(_i);
      if (geneticalgorithmx != null && geneticalgorithmx.getmutated().contains(gaindividualxx))
      { removemutated(geneticalgorithmx,gaindividualxx); }
    }
  }



  public void killAllGATrait(List gatraitxx)
  { for (int _i = 0; _i < gatraitxx.size(); _i++)
    { killGATrait((GATrait) gatraitxx.get(_i)); }
  }

  public void killGATrait(GATrait gatraitxx)
  { if (gatraitxx == null) { return; }
   gatraits.remove(gatraitxx);
    Vector _1qrangetraitsGAIndividual = new Vector();
    _1qrangetraitsGAIndividual.addAll(gaindividuals);
    for (int _i = 0; _i < _1qrangetraitsGAIndividual.size(); _i++)
    { GAIndividual gaindividualx = (GAIndividual) _1qrangetraitsGAIndividual.get(_i);
      if (gaindividualx != null && gaindividualx.gettraits().contains(gatraitxx))
      { removetraits(gaindividualx,gatraitxx); }
    }
  }



  public void killAllCreateClasses(List createclassesxx)
  { for (int _i = 0; _i < createclassesxx.size(); _i++)
    { killCreateClasses((CreateClasses) createclassesxx.get(_i)); }
  }

  public void killCreateClasses(CreateClasses createclassesxx)
  { if (createclassesxx == null) { return; }
   createclassess.remove(createclassesxx);
  }



  public void killAllRefactor(List refactorxx)
  { for (int _i = 0; _i < refactorxx.size(); _i++)
    { killRefactor((Refactor) refactorxx.get(_i)); }
  }

  public void killRefactor(Refactor refactorxx)
  { if (refactorxx == null) { return; }
   refactors.remove(refactorxx);
  }



  public void killAllCleanup(List cleanupxx)
  { for (int _i = 0; _i < cleanupxx.size(); _i++)
    { killCleanup((Cleanup) cleanupxx.get(_i)); }
  }

  public void killCleanup(Cleanup cleanupxx)
  { if (cleanupxx == null) { return; }
   cleanups.remove(cleanupxx);
  }



  public void killAllMeasures(List measuresxx)
  { for (int _i = 0; _i < measuresxx.size(); _i++)
    { killMeasures((Measures) measuresxx.get(_i)); }
  }

  public void killMeasures(Measures measuresxx)
  { if (measuresxx == null) { return; }
   measuress.remove(measuresxx);
  }



  public void killAllPreprocess(List preprocessxx)
  { for (int _i = 0; _i < preprocessxx.size(); _i++)
    { killPreprocess((Preprocess) preprocessxx.get(_i)); }
  }

  public void killPreprocess(Preprocess preprocessxx)
  { if (preprocessxx == null) { return; }
   preprocesss.remove(preprocessxx);
  }



  public void killAllEvolve(List evolvexx)
  { for (int _i = 0; _i < evolvexx.size(); _i++)
    { killEvolve((Evolve) evolvexx.get(_i)); }
  }

  public void killEvolve(Evolve evolvexx)
  { if (evolvexx == null) { return; }
   evolves.remove(evolvexx);
  }



  public void killAllNextgeneration(List nextgenerationxx)
  { for (int _i = 0; _i < nextgenerationxx.size(); _i++)
    { killNextgeneration((Nextgeneration) nextgenerationxx.get(_i)); }
  }

  public void killNextgeneration(Nextgeneration nextgenerationxx)
  { if (nextgenerationxx == null) { return; }
   nextgenerations.remove(nextgenerationxx);
  }



  public void killAllInitialise(List initialisexx)
  { for (int _i = 0; _i < initialisexx.size(); _i++)
    { killInitialise((Initialise) initialisexx.get(_i)); }
  }

  public void killInitialise(Initialise initialisexx)
  { if (initialisexx == null) { return; }
   initialises.remove(initialisexx);
  }



  public void killAllPostprocess(List postprocessxx)
  { for (int _i = 0; _i < postprocessxx.size(); _i++)
    { killPostprocess((Postprocess) postprocessxx.get(_i)); }
  }

  public void killPostprocess(Postprocess postprocessxx)
  { if (postprocessxx == null) { return; }
   postprocesss.remove(postprocessxx);
  }



  public void killAllGa(List gaxx)
  { for (int _i = 0; _i < gaxx.size(); _i++)
    { killGa((Ga) gaxx.get(_i)); }
  }

  public void killGa(Ga gaxx)
  { if (gaxx == null) { return; }
   gas.remove(gaxx);
  }



  public void killAllCreateClasses1(List createclasses1xx)
  { for (int _i = 0; _i < createclasses1xx.size(); _i++)
    { killCreateClasses1((CreateClasses1) createclasses1xx.get(_i)); }
  }

  public void killCreateClasses1(CreateClasses1 createclasses1xx)
  { if (createclasses1xx == null) { return; }
   createclasses1s.remove(createclasses1xx);
  }




  
    public void createClasses() 
  { 

    List _range108 = new Vector();
  _range108.addAll(Controller.inst().umlmethods);
  for (int _i107 = 0; _i107 < _range108.size(); _i107++)
  { UMLMethod loopvar_0 = (UMLMethod) _range108.get(_i107);
       Controller.inst().createclasses1(loopvar_0);
  }
    List _range110 = new Vector();
  _range110.addAll(Controller.inst().attributes);
  for (int _i109 = 0; _i109 < _range110.size(); _i109++)
  { Attribute loopvar_1 = (Attribute) _range110.get(_i109);
       Controller.inst().createclasses2(loopvar_1);
  }
    List _range112 = new Vector();
  _range112.addAll(Controller.inst().umlmethods);
  for (int _i111 = 0; _i111 < _range112.size(); _i111++)
  { UMLMethod loopvar_2 = (UMLMethod) _range112.get(_i111);
       Controller.inst().createclasses3outer(loopvar_2);
  }
    List _range114 = new Vector();
  _range114.addAll(Controller.inst().umlmethods);
  for (int _i113 = 0; _i113 < _range114.size(); _i113++)
  { UMLMethod loopvar_3 = (UMLMethod) _range114.get(_i113);
       Controller.inst().createclasses4outer(loopvar_3);
  }
    List _range116 = new Vector();
  _range116.addAll(Controller.inst().umlmethods);
  for (int _i115 = 0; _i115 < _range116.size(); _i115++)
  { UMLMethod loopvar_4 = (UMLMethod) _range116.get(_i115);
       Controller.inst().createclasses5outer(loopvar_4);
  }

  }



    public void refactor() 
  { 

    List _range118 = new Vector();
  _range118.addAll(Controller.inst().umlclasss);
  for (int _i117 = 0; _i117 < _range118.size(); _i117++)
  { UMLClass loopvar_5 = (UMLClass) _range118.get(_i117);
       Controller.inst().refactor1outer(loopvar_5);
  }
    List _range120 = new Vector();
  _range120.addAll(Controller.inst().umlclasss);
  for (int _i119 = 0; _i119 < _range120.size(); _i119++)
  { UMLClass loopvar_6 = (UMLClass) _range120.get(_i119);
       Controller.inst().refactor2outer(loopvar_6);
  }

  }



    public void cleanup() 
  { 

    boolean cleanup1_running;
  cleanup1_running = true;
    while (cleanup1_running) 
  { cleanup1_running = UMLClass.cleanup1search(); }

    List _range122 = new Vector();
  _range122.addAll(Controller.inst().classmodels);
  for (int _i121 = 0; _i121 < _range122.size(); _i121++)
  { ClassModel loopvar_7 = (ClassModel) _range122.get(_i121);
       Controller.inst().cleanup2(loopvar_7);
  }

  }



    public void measures() 
  { 

    List _range124 = new Vector();
  _range124.addAll(Controller.inst().classmodels);
  for (int _i123 = 0; _i123 < _range124.size(); _i123++)
  { ClassModel loopvar_8 = (ClassModel) _range124.get(_i123);
       Controller.inst().measures1outer(loopvar_8);
  }
    List _range126 = new Vector();
  _range126.addAll(Controller.inst().classmodels);
  for (int _i125 = 0; _i125 < _range126.size(); _i125++)
  { ClassModel loopvar_9 = (ClassModel) _range126.get(_i125);
       Controller.inst().measures2(loopvar_9);
  }
    List _range128 = new Vector();
  _range128.addAll(Controller.inst().classmodels);
  for (int _i127 = 0; _i127 < _range128.size(); _i127++)
  { ClassModel loopvar_10 = (ClassModel) _range128.get(_i127);
       Controller.inst().measures3(loopvar_10);
  }
    List _range130 = new Vector();
  _range130.addAll(Controller.inst().classmodels);
  for (int _i129 = 0; _i129 < _range130.size(); _i129++)
  { ClassModel loopvar_11 = (ClassModel) _range130.get(_i129);
       Controller.inst().measures4(loopvar_11);
  }

  }



    public void preprocess() 
  { 

    List _range132 = new Vector();
  _range132.addAll(Controller.inst().umlmethods);
  for (int _i131 = 0; _i131 < _range132.size(); _i131++)
  { UMLMethod loopvar_0 = (UMLMethod) _range132.get(_i131);
       Controller.inst().createclasses1(loopvar_0);
  }
    List _range134 = new Vector();
  _range134.addAll(Controller.inst().attributes);
  for (int _i133 = 0; _i133 < _range134.size(); _i133++)
  { Attribute loopvar_1 = (Attribute) _range134.get(_i133);
       Controller.inst().createclasses2(loopvar_1);
  }
    List _range136 = new Vector();
  _range136.addAll(Controller.inst().umlmethods);
  for (int _i135 = 0; _i135 < _range136.size(); _i135++)
  { UMLMethod loopvar_2 = (UMLMethod) _range136.get(_i135);
       Controller.inst().createclasses3outer(loopvar_2);
  }
    List _range138 = new Vector();
  _range138.addAll(Controller.inst().umlmethods);
  for (int _i137 = 0; _i137 < _range138.size(); _i137++)
  { UMLMethod loopvar_3 = (UMLMethod) _range138.get(_i137);
       Controller.inst().createclasses4outer(loopvar_3);
  }
    List _range140 = new Vector();
  _range140.addAll(Controller.inst().umlmethods);
  for (int _i139 = 0; _i139 < _range140.size(); _i139++)
  { UMLMethod loopvar_4 = (UMLMethod) _range140.get(_i139);
       Controller.inst().createclasses5outer(loopvar_4);
  }
  List _range142 = new Vector();
  _range142.addAll(Controller.inst().umlclasss);
  for (int _i141 = 0; _i141 < _range142.size(); _i141++)
  { UMLClass loopvar_5 = (UMLClass) _range142.get(_i141);
       Controller.inst().refactor1outer(loopvar_5);
  }
    List _range144 = new Vector();
  _range144.addAll(Controller.inst().umlclasss);
  for (int _i143 = 0; _i143 < _range144.size(); _i143++)
  { UMLClass loopvar_6 = (UMLClass) _range144.get(_i143);
       Controller.inst().refactor2outer(loopvar_6);
  }
  boolean cleanup1_running;
  cleanup1_running = true;
    while (cleanup1_running) 
  { cleanup1_running = UMLClass.cleanup1search(); }

    List _range146 = new Vector();
  _range146.addAll(Controller.inst().classmodels);
  for (int _i145 = 0; _i145 < _range146.size(); _i145++)
  { ClassModel loopvar_7 = (ClassModel) _range146.get(_i145);
       Controller.inst().cleanup2(loopvar_7);
  }
  List _range148 = new Vector();
  _range148.addAll(Controller.inst().classmodels);
  for (int _i147 = 0; _i147 < _range148.size(); _i147++)
  { ClassModel loopvar_8 = (ClassModel) _range148.get(_i147);
       Controller.inst().measures1outer(loopvar_8);
  }
    List _range150 = new Vector();
  _range150.addAll(Controller.inst().classmodels);
  for (int _i149 = 0; _i149 < _range150.size(); _i149++)
  { ClassModel loopvar_9 = (ClassModel) _range150.get(_i149);
       Controller.inst().measures2(loopvar_9);
  }
    List _range152 = new Vector();
  _range152.addAll(Controller.inst().classmodels);
  for (int _i151 = 0; _i151 < _range152.size(); _i151++)
  { ClassModel loopvar_10 = (ClassModel) _range152.get(_i151);
       Controller.inst().measures3(loopvar_10);
  }
    List _range154 = new Vector();
  _range154.addAll(Controller.inst().classmodels);
  for (int _i153 = 0; _i153 < _range154.size(); _i153++)
  { ClassModel loopvar_11 = (ClassModel) _range154.get(_i153);
       Controller.inst().measures4(loopvar_11);
  }

  }



    public void evolve() 
  { 

    List _range156 = new Vector();
  _range156.addAll(Controller.inst().geneticalgorithms);
  for (int _i155 = 0; _i155 < _range156.size(); _i155++)
  { GeneticAlgorithm loopvar_12 = (GeneticAlgorithm) _range156.get(_i155);
       Controller.inst().evolve1outer(loopvar_12);
  }
    List _range158 = new Vector();
  _range158.addAll(Controller.inst().geneticalgorithms);
  for (int _i157 = 0; _i157 < _range158.size(); _i157++)
  { GeneticAlgorithm loopvar_13 = (GeneticAlgorithm) _range158.get(_i157);
       Controller.inst().evolve2outer(loopvar_13);
  }
    List _range160 = new Vector();
  _range160.addAll(Controller.inst().geneticalgorithms);
  for (int _i159 = 0; _i159 < _range160.size(); _i159++)
  { GeneticAlgorithm loopvar_14 = (GeneticAlgorithm) _range160.get(_i159);
       Controller.inst().evolve3outer(loopvar_14);
  }
    List _range162 = new Vector();
  _range162.addAll(Controller.inst().geneticalgorithms);
  for (int _i161 = 0; _i161 < _range162.size(); _i161++)
  { GeneticAlgorithm loopvar_15 = (GeneticAlgorithm) _range162.get(_i161);
       Controller.inst().evolve4outer(loopvar_15);
  }

  }



    public void nextgeneration() 
  { 

    List _range164 = new Vector();
  _range164.addAll(Controller.inst().geneticalgorithms);
  for (int _i163 = 0; _i163 < _range164.size(); _i163++)
  { GeneticAlgorithm loopvar_16 = (GeneticAlgorithm) _range164.get(_i163);
       Controller.inst().nextgeneration1(loopvar_16);
  }
    List _range166 = new Vector();
  _range166.addAll(Controller.inst().geneticalgorithms);
  for (int _i165 = 0; _i165 < _range166.size(); _i165++)
  { GeneticAlgorithm loopvar_17 = (GeneticAlgorithm) _range166.get(_i165);
       Controller.inst().nextgeneration2outer(loopvar_17);
  }
    List _range168 = new Vector();
  _range168.addAll(Controller.inst().geneticalgorithms);
  for (int _i167 = 0; _i167 < _range168.size(); _i167++)
  { GeneticAlgorithm loopvar_18 = (GeneticAlgorithm) _range168.get(_i167);
       Controller.inst().nextgeneration3outer(loopvar_18);
  }
    List _range170 = new Vector();
  _range170.addAll(Controller.inst().geneticalgorithms);
  for (int _i169 = 0; _i169 < _range170.size(); _i169++)
  { GeneticAlgorithm loopvar_19 = (GeneticAlgorithm) _range170.get(_i169);
       Controller.inst().nextgeneration4outer(loopvar_19);
  }
    List _range172 = new Vector();
  _range172.addAll(Controller.inst().geneticalgorithms);
  for (int _i171 = 0; _i171 < _range172.size(); _i171++)
  { GeneticAlgorithm loopvar_20 = (GeneticAlgorithm) _range172.get(_i171);
       Controller.inst().nextgeneration5outer(loopvar_20);
  }
    List _range174 = new Vector();
  _range174.addAll(Controller.inst().geneticalgorithms);
  for (int _i173 = 0; _i173 < _range174.size(); _i173++)
  { GeneticAlgorithm loopvar_21 = (GeneticAlgorithm) _range174.get(_i173);
       Controller.inst().nextgeneration6outer(loopvar_21);
  }
    List _range176 = new Vector();
  _range176.addAll(Controller.inst().geneticalgorithms);
  for (int _i175 = 0; _i175 < _range176.size(); _i175++)
  { GeneticAlgorithm loopvar_22 = (GeneticAlgorithm) _range176.get(_i175);
       Controller.inst().nextgeneration7(loopvar_22);
  }
    List _range178 = new Vector();
  _range178.addAll(Controller.inst().geneticalgorithms);
  for (int _i177 = 0; _i177 < _range178.size(); _i177++)
  { GeneticAlgorithm loopvar_23 = (GeneticAlgorithm) _range178.get(_i177);
       Controller.inst().nextgeneration8outer(loopvar_23);
  }
    List _range180 = new Vector();
  _range180.addAll(Controller.inst().geneticalgorithms);
  for (int _i179 = 0; _i179 < _range180.size(); _i179++)
  { GeneticAlgorithm loopvar_24 = (GeneticAlgorithm) _range180.get(_i179);
       Controller.inst().nextgeneration9(loopvar_24);
  }
    List _range182 = new Vector();
  _range182.addAll(Controller.inst().geneticalgorithms);
  for (int _i181 = 0; _i181 < _range182.size(); _i181++)
  { GeneticAlgorithm loopvar_25 = (GeneticAlgorithm) _range182.get(_i181);
       Controller.inst().nextgeneration10(loopvar_25);
  }

  }



    public void initialise() 
  { 

    List _range184 = new Vector();
  _range184.addAll(Controller.inst().classmodels);
  for (int _i183 = 0; _i183 < _range184.size(); _i183++)
  { ClassModel loopvar_26 = (ClassModel) _range184.get(_i183);
       Controller.inst().initialise1outer(loopvar_26);
  }
    List _range186 = new Vector();
  _range186.addAll(Controller.inst().geneticalgorithms);
  for (int _i185 = 0; _i185 < _range186.size(); _i185++)
  { GeneticAlgorithm loopvar_27 = (GeneticAlgorithm) _range186.get(_i185);
       Controller.inst().initialise2outer(loopvar_27);
  }
    List _range188 = new Vector();
  _range188.addAll(Controller.inst().geneticalgorithms);
  for (int _i187 = 0; _i187 < _range188.size(); _i187++)
  { GeneticAlgorithm loopvar_28 = (GeneticAlgorithm) _range188.get(_i187);
       Controller.inst().initialise3outer(loopvar_28);
  }
    List _range190 = new Vector();
  _range190.addAll(Controller.inst().geneticalgorithms);
  for (int _i189 = 0; _i189 < _range190.size(); _i189++)
  { GeneticAlgorithm loopvar_29 = (GeneticAlgorithm) _range190.get(_i189);
       Controller.inst().initialise4outer(loopvar_29);
  }
    List _range192 = new Vector();
  _range192.addAll(Controller.inst().geneticalgorithms);
  for (int _i191 = 0; _i191 < _range192.size(); _i191++)
  { GeneticAlgorithm loopvar_30 = (GeneticAlgorithm) _range192.get(_i191);
       Controller.inst().initialise5(loopvar_30);
  }

  }



    public void postprocess() 
  { 

    List _range194 = new Vector();
  _range194.addAll(Controller.inst().geneticalgorithms);
  for (int _i193 = 0; _i193 < _range194.size(); _i193++)
  { GeneticAlgorithm loopvar_31 = (GeneticAlgorithm) _range194.get(_i193);
       Controller.inst().postprocess1outer(loopvar_31);
  }

  }



    public void ga(int iter) 
  { 

     Controller.inst().initialise();
    List _range196 = new Vector();
  _range196.addAll(Controller.inst().geneticalgorithms);
  for (int _i195 = 0; _i195 < _range196.size(); _i195++)
  { GeneticAlgorithm loopvar_32 = (GeneticAlgorithm) _range196.get(_i195);
       Controller.inst().ga2outer(loopvar_32,iter);
  }

  }



    public void createClasses1() 
  { 

    List _range198 = new Vector();
  _range198.addAll(Controller.inst().umlmethods);
  for (int _i197 = 0; _i197 < _range198.size(); _i197++)
  { UMLMethod loopvar_33 = (UMLMethod) _range198.get(_i197);
       Controller.inst().createclasses11outer(loopvar_33);
  }

  }


 
}



