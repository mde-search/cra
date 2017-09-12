package uk.ac.kcl.mdeoptimise.ttc16.implementation

import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject

class MinimiseClasslessFeatures extends AbstractModelQueryFitnessFunction {

	override computeFitness(EObject model) {
		-1.0 * (model.getFeature("features") as EList<EObject>).filter [ feature |
			feature.getFeature("isEncapsulatedBy") == null
		].size
	}
	
	override getName() {
		return "Mimise classless features"
	}
}
