/**
 */
package at.ac.tuwien.big.momot.examples.modularization.ttc.architecture;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class#getEncapsulates <em>Encapsulates</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ArchitecturePackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Encapsulates</b></em>' reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Feature}.
	 * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Feature#getIsEncapsulatedBy <em>Is Encapsulated By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encapsulates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encapsulates</em>' reference list.
	 * @see at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ArchitecturePackage#getClass_Encapsulates()
	 * @see at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Feature#getIsEncapsulatedBy
	 * @model opposite="isEncapsulatedBy" required="true"
	 * @generated
	 */
	EList<Feature> getEncapsulates();

} // Class
