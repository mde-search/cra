/**
 */
package at.ac.tuwien.big.momot.examples.modularization.ttc.architecture;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ClassModel#getClasses <em>Classes</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ClassModel#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ArchitecturePackage#getClassModel()
 * @model
 * @generated
 */
public interface ClassModel extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ArchitecturePackage#getClassModel_Classes()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Class> getClasses();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see at.ac.tuwien.big.momot.examples.modularization.ttc.architecture.ArchitecturePackage#getClassModel_Features()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Feature> getFeatures();

} // ClassModel
