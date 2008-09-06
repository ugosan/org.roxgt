package org.roxgt.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.roxgt.Edge;
import org.roxgt.Graph;
import org.roxgt.Node;
import org.roxgt.Property;
import org.roxgt.RoxgtPackage;
import org.roxgt.diagram.edit.parts.EdgeEditPart;
import org.roxgt.diagram.edit.parts.EdgeTargetEditPart;
import org.roxgt.diagram.edit.parts.GraphEditPart;
import org.roxgt.diagram.edit.parts.NodePropertyCompartmentEditPart;
import org.roxgt.diagram.edit.parts.PropertyEditPart;
import org.roxgt.diagram.providers.RoxgtElementTypes;

/**
 * @generated
 */
public class RoxgtDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (RoxgtVisualIDRegistry.getVisualID(view)) {
		case NodePropertyCompartmentEditPart.VISUAL_ID:
			return getNodePropertyCompartment_5001SemanticChildren(view);
		case GraphEditPart.VISUAL_ID:
			return getGraph_79SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getNodePropertyCompartment_5001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Node modelElement = (Node) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getProperties().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = RoxgtVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PropertyEditPart.VISUAL_ID) {
				result.add(new RoxgtNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGraph_79SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Graph modelElement = (Graph) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNodes().iterator(); it.hasNext();) {
			Node childElement = (Node) it.next();
			int visualID = RoxgtVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EdgeEditPart.VISUAL_ID) {
				result.add(new RoxgtNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (RoxgtVisualIDRegistry.getVisualID(view)) {
		case GraphEditPart.VISUAL_ID:
			return getGraph_79ContainedLinks(view);
		case EdgeEditPart.VISUAL_ID:
			return getNode_1001ContainedLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_2001ContainedLinks(view);
		case EdgeTargetEditPart.VISUAL_ID:
			return getEdge_3001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (RoxgtVisualIDRegistry.getVisualID(view)) {
		case EdgeEditPart.VISUAL_ID:
			return getNode_1001IncomingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_2001IncomingLinks(view);
		case EdgeTargetEditPart.VISUAL_ID:
			return getEdge_3001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (RoxgtVisualIDRegistry.getVisualID(view)) {
		case EdgeEditPart.VISUAL_ID:
			return getNode_1001OutgoingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_2001OutgoingLinks(view);
		case EdgeTargetEditPart.VISUAL_ID:
			return getEdge_3001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGraph_79ContainedLinks(View view) {
		Graph modelElement = (Graph) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Edge_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getNode_1001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEdge_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getNode_1001IncomingLinks(View view) {
		Node modelElement = (Node) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Edge_3001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEdge_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getNode_1001OutgoingLinks(View view) {
		Node modelElement = (Node) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Edge_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEdge_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Edge_3001(
			Graph container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getEdges().iterator(); links.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof Edge) {
				continue;
			}
			Edge link = (Edge) linkObject;
			if (EdgeTargetEditPart.VISUAL_ID != RoxgtVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTarget();
			Node src = link.getSource();
			result.add(new RoxgtLinkDescriptor(src, dst, link,
					RoxgtElementTypes.Edge_3001, EdgeTargetEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Edge_3001(
			Node target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != RoxgtPackage.eINSTANCE
					.getEdge_Target()
					|| false == setting.getEObject() instanceof Edge) {
				continue;
			}
			Edge link = (Edge) setting.getEObject();
			if (EdgeTargetEditPart.VISUAL_ID != RoxgtVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node src = link.getSource();
			result.add(new RoxgtLinkDescriptor(src, target, link,
					RoxgtElementTypes.Edge_3001, EdgeTargetEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Edge_3001(
			Node source) {
		Graph container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Graph) {
				container = (Graph) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getEdges().iterator(); links.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof Edge) {
				continue;
			}
			Edge link = (Edge) linkObject;
			if (EdgeTargetEditPart.VISUAL_ID != RoxgtVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTarget();
			Node src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new RoxgtLinkDescriptor(src, dst, link,
					RoxgtElementTypes.Edge_3001, EdgeTargetEditPart.VISUAL_ID));
		}
		return result;
	}

}
