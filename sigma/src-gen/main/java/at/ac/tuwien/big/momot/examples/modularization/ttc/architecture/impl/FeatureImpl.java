/**
 */
package at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.impl;

import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ArchitecturePackage;
import at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Feature;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.impl.FeatureImpl#getIsEncapsulatedBy <em>Is Encapsulated By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FeatureImpl extends NamedElementImpl implements Feature
{
	/**
	 * The cached value of the '{@link #getIsEncapsulatedBy() <em>Is Encapsulated By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsEncapsulatedBy()
	 * @generated
	 * @ordered
	 */
	protected at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class isEncapsulatedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ArchitecturePackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class getIsEncapsulatedBy()
	{
		if (isEncapsulatedBy != null && isEncapsulatedBy.eIsProxy())
		{
			InternalEObject oldIsEncapsulatedBy = (InternalEObject)isEncapsulatedBy;
			isEncapsulatedBy = (at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class)eResolveProxy(oldIsEncapsulatedBy);
			if (isEncapsulatedBy != oldIsEncapsulatedBy)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY, oldIsEncapsulatedBy, isEncapsulatedBy));
			}
		}
		return isEncapsulatedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class basicGetIsEncapsulatedBy()
	{
		return isEncapsulatedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIsEncapsulatedBy(at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class newIsEncapsulatedBy, NotificationChain msgs)
	{
		at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class oldIsEncapsulatedBy = isEncapsulatedBy;
		isEncapsulatedBy = newIsEncapsulatedBy;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY, oldIsEncapsulatedBy, newIsEncapsulatedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsEncapsulatedBy(at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class newIsEncapsulatedBy)
	{
		if (newIsEncapsulatedBy != isEncapsulatedBy)
		{
			NotificationChain msgs = null;
			if (isEncapsulatedBy != null)
				msgs = ((InternalEObject)isEncapsulatedBy).eInverseRemove(this, ArchitecturePackage.CLASS__ENCAPSULATES, at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class.class, msgs);
			if (newIsEncapsulatedBy != null)
				msgs = ((InternalEObject)newIsEncapsulatedBy).eInverseAdd(this, ArchitecturePackage.CLASS__ENCAPSULATES, at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class.class, msgs);
			msgs = basicSetIsEncapsulatedBy(newIsEncapsulatedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY, newIsEncapsulatedBy, newIsEncapsulatedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
				if (isEncapsulatedBy != null)
					msgs = ((InternalEObject)isEncapsulatedBy).eInverseRemove(this, ArchitecturePackage.CLASS__ENCAPSULATES, at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class.class, msgs);
				return basicSetIsEncapsulatedBy((at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
				return basicSetIsEncapsulatedBy(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
				if (resolve) return getIsEncapsulatedBy();
				return basicGetIsEncapsulatedBy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
				setIsEncapsulatedBy((at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
				setIsEncapsulatedBy((at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
				return isEncapsulatedBy != null;
		}
		return super.eIsSet(featureID);
	}

} //FeatureImpl
