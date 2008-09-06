package org.roxgt.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.roxgt.RoxgtPackage;
import org.roxgt.diagram.edit.parts.EdgeLabel2EditPart;
import org.roxgt.diagram.edit.parts.EdgeLabelEditPart;
import org.roxgt.diagram.edit.parts.PropertyEditPart;
import org.roxgt.diagram.parsers.CompositeParser;
import org.roxgt.diagram.parsers.MessageFormatParser;
import org.roxgt.diagram.parsers.NativeParser;
import org.roxgt.diagram.part.RoxgtVisualIDRegistry;

/**
 * @generated
 */
public class RoxgtParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser nodeLabel_4001Parser;

	/**
	 * @generated
	 */
	private IParser getNodeLabel_4001Parser() {
		if (nodeLabel_4001Parser == null) {
			nodeLabel_4001Parser = createNodeLabel_4001Parser();
		}
		return nodeLabel_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createNodeLabel_4001Parser() {
		EAttribute[] features = new EAttribute[] { RoxgtPackage.eINSTANCE
				.getGraphElement_Label(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser property_2001Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_2001Parser() {
		if (property_2001Parser == null) {
			property_2001Parser = createProperty_2001Parser();
		}
		return property_2001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createProperty_2001Parser() {
		EAttribute[] features = new EAttribute[] {
				RoxgtPackage.eINSTANCE.getProperty_Name(),
				RoxgtPackage.eINSTANCE.getProperty_Value(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}={1}");
		parser.setEditorPattern("{0}={1}");
		parser.setEditPattern("{0}={1}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser edgeLabel_4002Parser;

	/**
	 * @generated
	 */
	private IParser getEdgeLabel_4002Parser() {
		if (edgeLabel_4002Parser == null) {
			edgeLabel_4002Parser = createEdgeLabel_4002Parser();
		}
		return edgeLabel_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEdgeLabel_4002Parser() {
		EAttribute[] features = new EAttribute[] { RoxgtPackage.eINSTANCE
				.getGraphElement_Label(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case EdgeLabelEditPart.VISUAL_ID:
			return getNodeLabel_4001Parser();
		case PropertyEditPart.VISUAL_ID:
			return getProperty_2001Parser();
		case EdgeLabel2EditPart.VISUAL_ID:
			return getEdgeLabel_4002Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(RoxgtVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(RoxgtVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (RoxgtElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
