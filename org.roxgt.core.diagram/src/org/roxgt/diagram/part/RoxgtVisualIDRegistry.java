package org.roxgt.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.roxgt.Graph;
import org.roxgt.RoxgtPackage;
import org.roxgt.diagram.edit.parts.EdgeEditPart;
import org.roxgt.diagram.edit.parts.EdgeLabel2EditPart;
import org.roxgt.diagram.edit.parts.EdgeLabelEditPart;
import org.roxgt.diagram.edit.parts.EdgeTargetEditPart;
import org.roxgt.diagram.edit.parts.GraphEditPart;
import org.roxgt.diagram.edit.parts.NodePropertyCompartmentEditPart;
import org.roxgt.diagram.edit.parts.Property2EditPart;
import org.roxgt.diagram.edit.parts.PropertyEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class RoxgtVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = RoxgtDiagramEditorPlugin
			.getInstance().getBundle().getSymbolicName()
			+ "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (GraphEditPart.MODEL_ID.equals(view.getType())) {
				return GraphEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.roxgt.diagram.part.RoxgtVisualIDRegistry.getVisualID(view
				.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				RoxgtDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (RoxgtPackage.eINSTANCE.getGraph().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Graph) domainElement)) {
			return GraphEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.roxgt.diagram.part.RoxgtVisualIDRegistry
				.getModelID(containerView);
		if (!GraphEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (GraphEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.roxgt.diagram.part.RoxgtVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = GraphEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case NodePropertyCompartmentEditPart.VISUAL_ID:
			if (RoxgtPackage.eINSTANCE.getProperty().isSuperTypeOf(
					domainElement.eClass())) {
				return PropertyEditPart.VISUAL_ID;
			}
			break;
		case GraphEditPart.VISUAL_ID:
			if (RoxgtPackage.eINSTANCE.getNode().isSuperTypeOf(
					domainElement.eClass())) {
				return EdgeEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.roxgt.diagram.part.RoxgtVisualIDRegistry
				.getModelID(containerView);
		if (!GraphEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (GraphEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.roxgt.diagram.part.RoxgtVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = GraphEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case EdgeEditPart.VISUAL_ID:
			if (EdgeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NodePropertyCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NodePropertyCompartmentEditPart.VISUAL_ID:
			if (PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GraphEditPart.VISUAL_ID:
			if (EdgeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EdgeTargetEditPart.VISUAL_ID:
			if (EdgeLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (RoxgtPackage.eINSTANCE.getEdge().isSuperTypeOf(
				domainElement.eClass())) {
			return EdgeTargetEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Graph element) {
		return true;
	}

}
