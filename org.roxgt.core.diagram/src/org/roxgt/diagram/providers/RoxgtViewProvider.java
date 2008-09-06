package org.roxgt.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.roxgt.diagram.edit.parts.EdgeEditPart;
import org.roxgt.diagram.edit.parts.EdgeLabel2EditPart;
import org.roxgt.diagram.edit.parts.EdgeLabelEditPart;
import org.roxgt.diagram.edit.parts.EdgeTargetEditPart;
import org.roxgt.diagram.edit.parts.GraphEditPart;
import org.roxgt.diagram.edit.parts.NodePropertyCompartmentEditPart;
import org.roxgt.diagram.edit.parts.Property2EditPart;
import org.roxgt.diagram.edit.parts.PropertyEditPart;
import org.roxgt.diagram.part.RoxgtVisualIDRegistry;
import org.roxgt.diagram.view.factories.EdgeLabel2ViewFactory;
import org.roxgt.diagram.view.factories.EdgeLabelViewFactory;
import org.roxgt.diagram.view.factories.EdgeTargetViewFactory;
import org.roxgt.diagram.view.factories.EdgeViewFactory;
import org.roxgt.diagram.view.factories.GraphViewFactory;
import org.roxgt.diagram.view.factories.NodePropertyCompartmentViewFactory;
import org.roxgt.diagram.view.factories.Property2ViewFactory;
import org.roxgt.diagram.view.factories.PropertyViewFactory;

/**
 * @generated
 */
public class RoxgtViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (GraphEditPart.MODEL_ID.equals(diagramKind)
				&& RoxgtVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return GraphViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = RoxgtVisualIDRegistry.getNodeVisualID(containerView,
					domainElement);
		} else {
			visualID = RoxgtVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!RoxgtElementTypes.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != RoxgtVisualIDRegistry.getNodeVisualID(
								containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!GraphEditPart.MODEL_ID.equals(RoxgtVisualIDRegistry
						.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case EdgeEditPart.VISUAL_ID:
				case PropertyEditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != RoxgtVisualIDRegistry
									.getNodeVisualID(containerView,
											domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case EdgeLabelEditPart.VISUAL_ID:
				case NodePropertyCompartmentEditPart.VISUAL_ID:
					if (EdgeEditPart.VISUAL_ID != RoxgtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EdgeLabel2EditPart.VISUAL_ID:
					if (EdgeTargetEditPart.VISUAL_ID != RoxgtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null
				|| !RoxgtVisualIDRegistry
						.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case EdgeEditPart.VISUAL_ID:
			return EdgeViewFactory.class;
		case EdgeLabelEditPart.VISUAL_ID:
			return EdgeLabelViewFactory.class;
		case PropertyEditPart.VISUAL_ID:
			return PropertyViewFactory.class;
		case NodePropertyCompartmentEditPart.VISUAL_ID:
			return NodePropertyCompartmentViewFactory.class;
		case EdgeLabel2EditPart.VISUAL_ID:
			return EdgeLabel2ViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!RoxgtElementTypes.isKnownElementType(elementType)
				|| (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = RoxgtVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != RoxgtVisualIDRegistry
						.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case EdgeTargetEditPart.VISUAL_ID:
			return EdgeTargetViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}
}
