package org.roxgt.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.roxgt.RoxgtPackage;
import org.roxgt.diagram.edit.commands.PropertyCreateCommand;
import org.roxgt.diagram.providers.RoxgtElementTypes;

/**
 * @generated
 */
public class NodePropertyCompartmentItemSemanticEditPolicy extends
		RoxgtBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (RoxgtElementTypes.Property_2001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(RoxgtPackage.eINSTANCE
						.getGraphElement_Properties());
			}
			return getGEFWrapper(new PropertyCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
