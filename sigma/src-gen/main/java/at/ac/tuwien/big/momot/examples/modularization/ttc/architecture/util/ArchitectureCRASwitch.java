/**
 */
package at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.util;

import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ArchitectureCRAPackage;
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Attribute;
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ClassModel;
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Feature;
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Method;
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.NamedElement;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ArchitectureCRAPackage
 * @generated
 */
public class ArchitectureCRASwitch
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ArchitectureCRAPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureCRASwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = ArchitectureCRAPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject)
	{
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject)
	{
		if (theEClass.eContainer() == modelPackage)
		{
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else
		{
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case ArchitectureCRAPackage.CLASS_MODEL:
			{
				ClassModel classModel = (ClassModel)theEObject;
				Object result = caseClassModel(classModel);
				if (result == null) result = caseNamedElement(classModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitectureCRAPackage.CLASS:
			{
				at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class class_ = (at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class)theEObject;
				Object result = caseClass(class_);
				if (result == null) result = caseNamedElement(class_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitectureCRAPackage.ATTRIBUTE:
			{
				Attribute attribute = (Attribute)theEObject;
				Object result = caseAttribute(attribute);
				if (result == null) result = caseFeature(attribute);
				if (result == null) result = caseNamedElement(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitectureCRAPackage.METHOD:
			{
				Method method = (Method)theEObject;
				Object result = caseMethod(method);
				if (result == null) result = caseFeature(method);
				if (result == null) result = caseNamedElement(method);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitectureCRAPackage.FEATURE:
			{
				Feature feature = (Feature)theEObject;
				Object result = caseFeature(feature);
				if (result == null) result = caseNamedElement(feature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ArchitectureCRAPackage.NAMED_ELEMENT:
			{
				NamedElement namedElement = (NamedElement)theEObject;
				Object result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClassModel(ClassModel object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClass(at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAttribute(Attribute object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMethod(Method object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFeature(Feature object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNamedElement(NamedElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object)
	{
		return null;
	}

} //ArchitectureCRASwitch
