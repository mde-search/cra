import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;

public interface SystemTypes
{
  public class Set
  { private Vector elements = new Vector();

  public static List select_0(List _l)
  { // Implements: ci.encapsulates->select(mi | mi : UMLMethod)
    List _results_0 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { Feature mi = (Feature) _l.get(_i);
      if ((mi instanceof UMLMethod))
      { _results_0.add(mi); }
    }
    return _results_0;
  }

  public static List select_3(List _l)
  { // Implements: ci.encapsulates->select(f | f : UMLMethod)
    List _results_3 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { Feature f = (Feature) _l.get(_i);
      if ((f instanceof UMLMethod))
      { _results_3.add(f); }
    }
    return _results_3;
  }

  public static List select_4(List _l)
  { // Implements: ci.encapsulates->select(f | f : Attribute)
    List _results_4 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { Feature f = (Feature) _l.get(_i);
      if ((f instanceof Attribute))
      { _results_4.add(f); }
    }
    return _results_4;
  }

  public static List select_10(List _l,Feature a)
  { // Implements: UMLMethod->select(f | f.dataDependency->includes(a))
    List _results_10 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { UMLMethod f = (UMLMethod) _l.get(_i);
      if (f.getdataDependency().contains(a))
      { _results_10.add(f); }
    }
    return _results_10;
  }

  public static List select_11(List _l,Attribute attributex,Attribute self)
  { // Implements: UMLMethod->select(f | self : f.dataDependency)
    List _results_11 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { UMLMethod f = (UMLMethod) _l.get(_i);
      if (f.getdataDependency().contains(self))
      { _results_11.add(f); }
    }
    return _results_11;
  }

  public static List select_13(List _l)
  { // Implements: dataDependency->select(d | d.isEncapsulatedBy.size = 0)
    List _results_13 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { Attribute d = (Attribute) _l.get(_i);
      if (d.getisEncapsulatedBy().size() == 0)
      { _results_13.add(d); }
    }
    return _results_13;
  }

  public static List select_15(List _l)
  { // Implements: m.dataDependency->select(a | a.isEncapsulatedBy.size = 0)
    List _results_15 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { Attribute a = (Attribute) _l.get(_i);
      if (a.getisEncapsulatedBy().size() == 0)
      { _results_15.add(a); }
    }
    return _results_15;
  }

  public static List select_20(List _l,int c)
  { // Implements: traits->select(t | t.value = c & ClassModel.isAttribute(t.item))
    List _results_20 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { GATrait t = (GATrait) _l.get(_i);
      if (t.getvalue() == c && ClassModel.isAttribute(t.getitem()))
      { _results_20.add(t); }
    }
    return _results_20;
  }

  public static List select_21(List _l,int c)
  { // Implements: traits->select(t | t.value = c & ClassModel.isMethod(t.item))
    List _results_21 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { GATrait t = (GATrait) _l.get(_i);
      if (t.getvalue() == c && ClassModel.isMethod(t.getitem()))
      { _results_21.add(t); }
    }
    return _results_21;
  }





  public static boolean forAll_17(List _l,GAIndividual p)
  { 
    for (int _i = 0; _i < _l.size(); _i++)
    { GAIndividual q = (GAIndividual) _l.get(_i);
      if (q.getfitnessval() != p.getfitnessval()) { }
      else { return false; } 
    }
    return true;
  }

  public static boolean forAll_14(List _l,List unencapdas)
  { 
    for (int _i = 0; _i < _l.size(); _i++)
    { UMLMethod m = (UMLMethod) _l.get(_i);
      if ((!(m.getisEncapsulatedBy().size() == 0) || (Set.select_15(m.getdataDependency())).size() <= unencapdas.size())) { }
      else { return false; } 
    }
    return true;
  }

  public static boolean forAll_16(List _l,GAIndividual p)
  { 
    for (int _i = 0; _i < _l.size(); _i++)
    { GAIndividual q = (GAIndividual) _l.get(_i);
      if (q.getfitnessval() != p.getfitnessval()) { }
      else { return false; } 
    }
    return true;
  }


  public static List collect_1(List _l,UMLClass cj)
  { // implements: ci.encapsulates->select( mi | mi : UMLMethod )->collect( m | cj.encapsulates->intersection(m.functionalDependency)->size() )
    List _results_1 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { Feature m = (Feature) _l.get(_i);
      Integer collect_x = new Integer((Set.intersection(cj.getencapsulates(),((UMLMethod) m).getfunctionalDependency())).size());
      if (collect_x != null) { _results_1.add(collect_x); }
    }
    return _results_1;
  }

  public static List collect_2(List _l,UMLClass cj)
  { // implements: ci.encapsulates->select( mi | mi : UMLMethod )->collect( m | cj.encapsulates->intersection(m.dataDependency)->size() )
    List _results_2 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { Feature m = (Feature) _l.get(_i);
      Integer collect_x = new Integer((Set.intersection(cj.getencapsulates(),((UMLMethod) m).getdataDependency())).size());
      if (collect_x != null) { _results_2.add(collect_x); }
    }
    return _results_2;
  }

  public static List collect_5(List _l)
  { // implements: UMLClass->collect( c | ClassModel.cohesion(c) )
    List _results_5 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { UMLClass c = (UMLClass) _l.get(_i);
      Double collect_x = new Double(ClassModel.cohesion(c));
      if (collect_x != null) { _results_5.add(collect_x); }
    }
    return _results_5;
  }

  public static List collect_6(List _l,UMLClass ci)
  { // implements: UMLClass.allInstances->excluding(ci)->collect( cj | ClassModel.coupling(ci,cj) )
    List _results_6 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { UMLClass cj = (UMLClass) _l.get(_i);
      Double collect_x = new Double(ClassModel.coupling(ci,cj));
      if (collect_x != null) { _results_6.add(collect_x); }
    }
    return _results_6;
  }

  public static List collect_7(List _l)
  { // implements: UMLClass->collect( ci | UMLClass.allInstances->excluding(ci)->collect( cj | ClassModel.coupling(ci,cj) )->sum() )
    List _results_7 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { UMLClass ci = (UMLClass) _l.get(_i);
      Double collect_x = new Double(Set.sumdouble(Set.collect_6(Set.subtract(Controller.inst().umlclasss,(new Set()).add(ci).getElements()),ci)));
      if (collect_x != null) { _results_7.add(collect_x); }
    }
    return _results_7;
  }

  public static List collect_8(List _l)
  { // implements: Attribute->collect( attribute_8_xx | name )
    List _results_8 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { Attribute attribute_8_xx = (Attribute) _l.get(_i);
      String collect_x = attribute_8_xx.getname();
      if (collect_x != null) { _results_8.add(collect_x); }
    }
    return _results_8;
  }

  public static List collect_9(List _l)
  { // implements: UMLMethod->collect( umlmethod_9_xx | name )
    List _results_9 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { UMLMethod umlmethod_9_xx = (UMLMethod) _l.get(_i);
      String collect_x = umlmethod_9_xx.getname();
      if (collect_x != null) { _results_9.add(collect_x); }
    }
    return _results_9;
  }

  public static List collect_12(List _l)
  { // implements: functionalDependency->collect( umlmethod_12_xx | dataDependency )
    List _results_12 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { UMLMethod umlmethod_12_xx = (UMLMethod) _l.get(_i);
      List collect_x = umlmethod_12_xx.getdataDependency();
      if (collect_x != null) { _results_12.add(collect_x); }
    }
    return _results_12;
  }

  public static List collect_18(List _l)
  { // implements: q->collect( gaindividual_18_xx | fitnessval )
    List _results_18 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { GAIndividual gaindividual_18_xx = (GAIndividual) _l.get(_i);
      Double collect_x = new Double(gaindividual_18_xx.getfitnessval());
      if (collect_x != null) { _results_18.add(collect_x); }
    }
    return _results_18;
  }

  public static List collect_19(List _l)
  { // implements: traits->collect( t | t.item + " = " + t.value + " " )
    List _results_19 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { GATrait t = (GATrait) _l.get(_i);
      String collect_x = t.getitem() + " = " + t.getvalue() + " ";
      if (collect_x != null) { _results_19.add(collect_x); }
    }
    return _results_19;
  }

  public static List collect_22(List _l,GATrait m)
  { // implements: atts(cj)->collect( a | ClassModel.dma(m.item,a.item) )
    List _results_22 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { GATrait a = (GATrait) _l.get(_i);
      Integer collect_x = new Integer(ClassModel.dma(m.getitem(),a.getitem()));
      if (collect_x != null) { _results_22.add(collect_x); }
    }
    return _results_22;
  }

  public static List collect_23(List _l,GAIndividual gaindividualx,int cj)
  { // implements: mets(ci)->collect( m | atts(cj)->collect( a | ClassModel.dma(m.item,a.item) )->sum() )
    List _results_23 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { GATrait m = (GATrait) _l.get(_i);
      Integer collect_x = new Integer(Set.sumint(Set.collect_22(gaindividualx.atts(cj),m)));
      if (collect_x != null) { _results_23.add(collect_x); }
    }
    return _results_23;
  }

  public static List collect_24(List _l,GATrait m)
  { // implements: mets(cj)->collect( a | ClassModel.dmm(m.item,a.item) )
    List _results_24 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { GATrait a = (GATrait) _l.get(_i);
      Integer collect_x = new Integer(ClassModel.dmm(m.getitem(),a.getitem()));
      if (collect_x != null) { _results_24.add(collect_x); }
    }
    return _results_24;
  }

  public static List collect_25(List _l,GAIndividual gaindividualx,int cj)
  { // implements: mets(ci)->collect( m | mets(cj)->collect( a | ClassModel.dmm(m.item,a.item) )->sum() )
    List _results_25 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { GATrait m = (GATrait) _l.get(_i);
      Integer collect_x = new Integer(Set.sumint(Set.collect_24(gaindividualx.mets(cj),m)));
      if (collect_x != null) { _results_25.add(collect_x); }
    }
    return _results_25;
  }

  public static List collect_26(List _l,GAIndividual gaindividualx)
  { // implements: traits.value->asSet()->collect( c | cohesion(c) )
    List _results_26 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { int c = ((Integer) _l.get(_i)).intValue();
      Double collect_x = new Double(gaindividualx.cohesion(c));
      if (collect_x != null) { _results_26.add(collect_x); }
    }
    return _results_26;
  }

  public static List collect_27(List _l,GAIndividual gaindividualx,int ci)
  { // implements: traits.value->asSet()->excluding(ci)->collect( cj | coupling(ci,cj) )
    List _results_27 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { int cj = ((Integer) _l.get(_i)).intValue();
      Double collect_x = new Double(gaindividualx.coupling(ci,cj));
      if (collect_x != null) { _results_27.add(collect_x); }
    }
    return _results_27;
  }

  public static List collect_28(List _l,GAIndividual gaindividualx)
  { // implements: traits.value->asSet()->collect( ci | traits.value->asSet()->excluding(ci)->collect( cj | coupling(ci,cj) )->sum() )
    List _results_28 = new Vector();
    for (int _i = 0; _i < _l.size(); _i++)
    { int ci = ((Integer) _l.get(_i)).intValue();
      Double collect_x = new Double(Set.sumdouble(Set.collect_27(Set.subtract(Set.asSet(GATrait.getAllOrderedvalue(gaindividualx.gettraits())),(new Set()).add(new Integer(ci)).getElements()),gaindividualx,ci)));
      if (collect_x != null) { _results_28.add(collect_x); }
    }
    return _results_28;
  }


    public static boolean equals(List a, List b)
    { return a.containsAll(b) && b.containsAll(a); }


    public Set add(Object x)
    { if (x != null) { elements.add(x); }
      return this; }

    public Set add(int x)
    { elements.add(new Integer(x));
      return this; }

    public Set add(long x)
    { elements.add(new Long(x));
      return this; }

    public Set add(double x)
    { elements.add(new Double(x));
      return this; }

    public Set add(boolean x)
    { elements.add(new Boolean(x));
      return this; }

    public List getElements() { return elements; }


  public static Comparable max(List l)
  { Comparable res = null; 
    if (l.size() == 0) { return res; }
    res = (Comparable) l.get(0); 
    for (int i = 1; i < l.size(); i++)
    { Comparable e = (Comparable) l.get(i);
      if (res.compareTo(e) < 0) { res = e; } }
    return res; }


  public static Comparable min(List l)
  { Comparable res = null; 
    if (l.size() == 0) { return res; }
    res = (Comparable) l.get(0); 
    for (int i = 1; i < l.size(); i++)
    { Comparable e = (Comparable) l.get(i);
      if (res.compareTo(e) > 0) { res = e; } }
    return res; }


  public static List union(List a, List b)
  { List res = new Vector(); 
    for (int i = 0; i < a.size(); i++)
    { if (a.get(i) == null || res.contains(a.get(i))) { } else { res.add(a.get(i)); } }
    for (int j = 0; j < b.size(); j++)
    { if (b.get(j) == null || res.contains(b.get(j))) { } else { res.add(b.get(j)); } }
    return res; }


  public static List subtract(List a, List b)
  { List res = new Vector(); 
    res.addAll(a);
    res.removeAll(b);
    return res; }

  public static String subtract(String a, String b)
  { String res = ""; 
    for (int i = 0; i < a.length(); i++)
    { if (b.indexOf(a.charAt(i)) < 0) { res = res + a.charAt(i); } }
    return res; }



  public static List intersection(List a, List b)
  { List res = new Vector(); 
    res.addAll(a);
    res.retainAll(b);
    return res; }



  public static List symmetricDifference(List a, List b)
  { List res = new Vector();
    for (int i = 0; i < a.size(); i++)
    { Object _a = a.get(i);
      if (b.contains(_a) || res.contains(_a)) { }
      else { res.add(_a); }
    }
    for (int j = 0; j < b.size(); j++)
    { Object _b = b.get(j);
      if (a.contains(_b) || res.contains(_b)) { }
      else { res.add(_b); }
    }
    return res;
  }



  public static boolean isUnique(List evals)
  { List vals = new Vector(); 
    for (int i = 0; i < evals.size(); i++)
    { Object ob = evals.get(i); 
      if (vals.contains(ob)) { return false; }
      vals.add(ob);
    }
    return true;
  }


  public static int sumint(List a)
  { int sum = 0; 
    for (int i = 0; i < a.size(); i++)
    { Integer x = (Integer) a.get(i); 
      if (x != null) { sum += x.intValue(); }
    } 
    return sum; }

  public static double sumdouble(List a)
  { double sum = 0.0; 
    for (int i = 0; i < a.size(); i++)
    { Double x = (Double) a.get(i); 
      if (x != null) { sum += x.doubleValue(); }
    } 
    return sum; }

  public static long sumlong(List a)
  { long sum = 0; 
    for (int i = 0; i < a.size(); i++)
    { Long x = (Long) a.get(i); 
      if (x != null) { sum += x.longValue(); }
    } 
    return sum; }

  public static String sumString(List a)
  { String sum = ""; 
    for (int i = 0; i < a.size(); i++)
    { Object x = a.get(i); 
      sum = sum + x; }
    return sum;  }



  public static int prdint(List a)
  { int res = 1; 
    for (int i = 0; i < a.size(); i++)
    { Integer x = (Integer) a.get(i); 
      if (x != null) { res *= x.intValue(); }
    } 
    return res; }

  public static double prddouble(List a)
  { double res = 1; 
    for (int i = 0; i < a.size(); i++)
    { Double x = (Double) a.get(i); 
      if (x != null) { res *= x.doubleValue(); }
    } 
    return res; }

  public static long prdlong(List a)
  { long res = 1; 
    for (int i = 0; i < a.size(); i++)
    { Long x = (Long) a.get(i); 
      if (x != null) { res *= x.longValue(); }
    }
    return res;  }



  public static List concatenate(List a, List b)
  { List res = new Vector(); 
    res.addAll(a); 
    res.addAll(b); 
    return res; }


  public static List closureUMLMethodfunctionalDependency(List _r)
  { Vector _path = new Vector();
    for (int _i = 0; _i < _r.size(); _i++)
    { UMLMethod umlmethodx = (UMLMethod) _r.get(_i);
      closureUMLMethodfunctionalDependency(umlmethodx, _path);
    }
    return _path;
  }

  private static void closureUMLMethodfunctionalDependency(UMLMethod umlmethodx, List _path)
  { if (_path.contains(umlmethodx)) { return; }
    _path.add(umlmethodx);
    List functionalDependencyx = umlmethodx.getfunctionalDependency();
    for (int _i = 0; _i < functionalDependencyx.size(); _i++)
    { if (functionalDependencyx.get(_i) instanceof UMLMethod)
      { UMLMethod umlmethodxx = (UMLMethod) functionalDependencyx.get(_i);
        closureUMLMethodfunctionalDependency(umlmethodxx, _path);
      }
      else { _path.add(functionalDependencyx.get(_i)); }
    }
  }


  public static List asSet(List a)
  { List res = new Vector(); 
    for (int i = 0; i < a.size(); i++)
    { Object obj = a.get(i);
      if (res.contains(obj)) { } 
      else { res.add(obj); }
    } 
    return res; 
  }


  public static List reverse(List a)
  { List res = new Vector(); 
    for (int i = a.size() - 1; i >= 0; i--)
    { res.add(a.get(i)); } 
    return res; }

  public static String reverse(String a)
  { String res = ""; 
    for (int i = a.length() - 1; i >= 0; i--)
    { res = res + a.charAt(i); } 
    return res; }



  public static List front(List a)
  { List res = new Vector(); 
    for (int i = 0; i < a.size() - 1; i++)
    { res.add(a.get(i)); } 
    return res; }


  public static List tail(List a)
  { List res = new Vector(); 
    for (int i = 1; i < a.size(); i++)
    { res.add(a.get(i)); } 
    return res; }


    public static Object first(List v)
    { if (v.size() == 0) { return null; }
      return v.get(0);
    }


    public static Object last(List v)
    { if (v.size() == 0) { return null; }
      return v.get(v.size() - 1);
    }



  public static List sort(final List a)
  { int i = a.size()-1;
    return mergeSort(a,0,i);
  }

  static List mergeSort(final List a, int ind1, int ind2)
  { List res = new Vector();
    if (ind1 > ind2)
    { return res; }
    if (ind1 == ind2)
    { res.add(a.get(ind1));
      return res;
    }
    int mid = (ind1 + ind2)/2;
    List a1;
    List a2;
    if (mid == ind1)
    { a1 = new Vector();
      a1.add(a.get(ind1));
      a2 = mergeSort(a,mid+1,ind2);
    }
    else
    { a1 = mergeSort(a,ind1,mid-1);
      a2 = mergeSort(a,mid,ind2);
    }
    int i = 0;
    int j = 0;
    while (i < a1.size() && j < a2.size())
    { Comparable e1 = (Comparable) a1.get(i); 
      Comparable e2 = (Comparable) a2.get(j);
      if (e1.compareTo(e2) < 0) // e1 < e2
      { res.add(e1);
        i++; // get next e1
      } 
      else 
      { res.add(e2);
        j++; 
      } 
    } 
    if (i == a1.size())
    { for (int k = j; k < a2.size(); k++)
      { res.add(a2.get(k)); } 
    } 
    else 
    { for (int k = i; k < a1.size(); k++) 
      { res.add(a1.get(k)); } 
    } 
    return res;
  }


  public static List sortedBy(final List a, List f)
  { int i = a.size()-1;
    java.util.Map f_map = new java.util.HashMap();
    for (int j = 0; j < a.size(); j++)
    { f_map.put(a.get(j), f.get(j)); }
    return mergeSort(a,f_map,0,i);
  }

  static List mergeSort(final List a, java.util.Map f, int ind1, int ind2)
  { List res = new Vector();
    if (ind1 > ind2)
    { return res; }
    if (ind1 == ind2)
    { res.add(a.get(ind1));
      return res;
    }
    if (ind2 == ind1 + 1)
    { Comparable e1 = (Comparable) f.get(a.get(ind1)); 
      Comparable e2 = (Comparable) f.get(a.get(ind2));
      if (e1.compareTo(e2) < 0) // e1 < e2
      { res.add(a.get(ind1)); res.add(a.get(ind2)); return res; }
      else 
      { res.add(a.get(ind2)); res.add(a.get(ind1)); return res; }
    }
    int mid = (ind1 + ind2)/2;
    List a1;
    List a2;
    if (mid == ind1)
    { a1 = new Vector();
      a1.add(a.get(ind1));
      a2 = mergeSort(a,f,mid+1,ind2);
    }
    else
    { a1 = mergeSort(a,f,ind1,mid-1);
      a2 = mergeSort(a,f,mid,ind2);
    }
    int i = 0;
    int j = 0;
    while (i < a1.size() && j < a2.size())
    { Comparable e1 = (Comparable) f.get(a1.get(i)); 
      Comparable e2 = (Comparable) f.get(a2.get(j));
      if (e1.compareTo(e2) < 0) // e1 < e2
      { res.add(a1.get(i));
        i++; // get next e1
      } 
      else 
      { res.add(a2.get(j));
        j++; 
      } 
    } 
    if (i == a1.size())
    { for (int k = j; k < a2.size(); k++)
      { res.add(a2.get(k)); } 
    } 
    else 
    { for (int k = i; k < a1.size(); k++) 
      { res.add(a1.get(k)); } 
    } 
    return res;
  }


  public static List integerSubrange(int i, int j)
  { List tmp = new Vector(); 
    for (int k = i; k <= j; k++)
    { tmp.add(new Integer(k)); } 
    return tmp;
  }

  public static String subrange(String s, int i, int j)
  { return s.substring(i-1,j); }

  public static List subrange(List l, int i, int j)
  { List tmp = new Vector(); 
    for (int k = i-1; k < j; k++)
    { tmp.add(l.get(k)); } 
    return tmp; 
  }



  public static List prepend(List l, Object ob)
  { List res = new Vector();
    res.add(ob);
    res.addAll(l);
    return res;
  }


  public static List append(List l, Object ob)
  { List res = new Vector();
    res.addAll(l);
    res.add(ob);
    return res;
  }


  public static int count(List l, Object obj)
  { int res = 0; 
    for (int _i = 0; _i < l.size(); _i++)
    { if (obj == l.get(_i)) { res++; } 
      else if (obj != null && obj.equals(l.get(_i))) { res++; } 
    }
    return res; 
  }

  public static int count(String s, String x)
  { int res = 0; 
    if ("".equals(s)) { return res; }
    int ind = s.indexOf(x); 
    if (ind == -1) { return res; }
    String ss = s.substring(ind+1,s.length());
    res++; 
    while (ind >= 0)
    { ind = ss.indexOf(x); 
      if (ind == -1 || ss.equals("")) { return res; }
      res++; 
      ss = ss.substring(ind+1,ss.length());
    } 
    return res;
  }



  public static List characters(String str)
  { char[] _chars = str.toCharArray();
    Vector _res = new Vector();
    for (int i = 0; i < _chars.length; i++)
    { _res.add("" + _chars[i]); }
    return _res;
  }



    public static Object any(List v)
    { if (v.size() == 0) { return null; }
      return v.get(0);
    }


    public static List subcollections(List v)
    { Vector res = new Vector();
      if (v.size() == 0)
      { res.add(new Vector());
        return res;
      }
      if (v.size() == 1)
      { res.add(new Vector());
        res.add(v);
        return res;
      }
      Vector s = new Vector();
      Object x = v.get(0);
      s.addAll(v);
      s.remove(0);
      List scs = subcollections(s);
      res.addAll(scs);
      for (int i = 0; i < scs.size(); i++)
      { Vector sc = (Vector) scs.get(i);
        Vector scc = new Vector();
        scc.add(x);
        scc.addAll(sc);
        res.add(scc);
      }
      return res;
    }


  public static Vector maximalElements(List s, List v)
  { Vector res = new Vector();
    if (s.size() == 0) { return res; }
    Comparable largest = (Comparable) v.get(0);
    res.add(s.get(0));
    
    for (int i = 1; i < s.size(); i++)
    { Comparable next = (Comparable) v.get(i);
      if (largest.compareTo(next) < 0)
      { largest = next;
        res.clear();
        res.add(s.get(i));
      }
      else if (largest.compareTo(next) == 0)
      { res.add(s.get(i)); }
    }
    return res;
  }

  public static Vector minimalElements(List s, List v)
  { Vector res = new Vector();
    if (s.size() == 0) { return res; }
    Comparable smallest = (Comparable) v.get(0);
    res.add(s.get(0));
    
    for (int i = 1; i < s.size(); i++)
    { Comparable next = (Comparable) v.get(i);
      if (next.compareTo(smallest) < 0)
      { smallest = next;
        res.clear();
        res.add(s.get(i));
      }
      else if (smallest.compareTo(next) == 0)
      { res.add(s.get(i)); }
    }
    return res;
  }


  public static List intersectAll(List se)
  { List res = new Vector(); 
    if (se.size() == 0) { return res; }
    res.addAll((List) se.get(0));
    for (int i = 1; i < se.size(); i++)
    { res.retainAll((List) se.get(i)); }
    return res;
  }



  public static List unionAll(List se)
  { List res = new Vector(); 
    for (int i = 0; i < se.size(); i++)
    { List b = (List) se.get(i); 
      for (int j = 0; j < b.size(); j++)
      { if (res.contains(b.get(j))) { } else { res.add(b.get(j)); } }
    }
    return res;
  }



    public static List concatenateAll(List a)
    { List res = new Vector();
      for (int i = 0; i < a.size(); i++)
      { List r = (List) a.get(i);
        res.addAll(r); 
      }
      return res;
    }



  public static List insertAt(List l, int ind, Object ob)
  { List res = new Vector();
    for (int i = 0; i < ind-1 && i < l.size(); i++)
    { res.add(l.get(i)); }
    if (ind <= l.size() + 1) { res.add(ob); }
    for (int i = ind-1; i < l.size(); i++)
    { res.add(l.get(i)); }
    return res;
  }
  public static String insertAt(String l, int ind, Object ob)
  { String res = "";
    for (int i = 0; i < ind-1 && i < l.length(); i++)
    { res = res + l.charAt(i); }
    if (ind <= l.length() + 1) { res = res + ob; }
    for (int i = ind-1; i < l.length(); i++)
    { res = res + l.charAt(i); }
    return res;
  }


 public static boolean isInteger(String str)
  { try { Integer.parseInt(str); return true; }
    catch (Exception _e) { return false; }
  }


 public static boolean isReal(String str)
  { try { double d = Double.parseDouble(str); 
          if (Double.isNaN(d)) { return false; }
          return true; }
    catch (Exception _e) { return false; }
  }

  }
}
