package org.roxgt.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.roxgt.RoxgtPackage;
import org.roxgt.diagram.edit.parts.PropertyEditPart;
import org.roxgt.diagram.part.RoxgtDiagramUpdater;
import org.roxgt.diagram.part.RoxgtNodeDescriptor;
import org.roxgt.diagram.part.RoxgtVisualIDRegistry;

/**
 * @generated
 */
public class NodePropertyCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = RoxgtDiagramUpdater
				.getNodePropertyCompartment_5001SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
			result.add(((RoxgtNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = RoxgtVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case PropertyEditPart.VISUAL_ID:
			return !semanticChildren.contains(view.getElement())
					|| visualID != RoxgtVisualIDRegistry.getNodeVisualID(
							(View) getHost().getModel(), view.getElement());
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(RoxgtPackage.eINSTANCE
					.getGraphElement_Properties());
		}
		return myFeaturesToSynchronize;
	}

}
