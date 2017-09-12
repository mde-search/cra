/**
 */
package at.ac.tuwien.big.momot.examples.modularization.ttc.architecture;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Feature#getIsEncapsulatedBy <em>Is Encapsulated By</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ArchitecturePackage#getFeature()
 * @model abstract="true"
 * @generated
 */
public interface Feature extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Is Encapsulated By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class#getEncapsulates <em>Encapsulates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Encapsulated By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Encapsulated By</em>' reference.
	 * @see #setIsEncapsulatedBy(at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class)
	 * @see at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ArchitecturePackage#getFeature_IsEncapsulatedBy()
	 * @see at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class#getEncapsulates
	 * @model opposite="encapsulates"
	 * @generated
	 */
	at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class getIsEncapsulatedBy();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Feature#getIsEncapsulatedBy <em>Is Encapsulated By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Encapsulated By</em>' reference.
	 * @see #getIsEncapsulatedBy()
	 * @generated
	 */
	void setIsEncapsulatedBy(at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class value);

} // Feature
