package org.fugerit.java.doc.mod.openpdf.helpers;

import java.awt.Color;

import org.fugerit.java.doc.base.model.DocPara;
import org.fugerit.java.doc.base.xml.DocModelUtils;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;

public class OpenPdfFontHelper {

	private static int handleFontStyle( int style, int fontStyle ) {
		if ( fontStyle == DocPara.STYLE_BOLD ) {
			style = Font.BOLD;
		} else if ( fontStyle == DocPara.STYLE_UNDERLINE ) {
			style = Font.UNDERLINE;
		} else if ( fontStyle == DocPara.STYLE_ITALIC ) {
			style = Font.ITALIC;
		} else if ( fontStyle == DocPara.STYLE_BOLDITALIC ) {
			style = Font.BOLDITALIC;
		}
		return style;
	}
	
	protected static Font createFont( String fontName, String fontPath, int fontSize, int fontStyle, OpenPdfHelper docHelper, String color ) throws Exception {
		Font font = null;
		int size = fontSize;
		int style = Font.NORMAL;
		BaseFont bf = null;
		int bfV = -1;
		if ( size == -1 ) {
			size = Integer.parseInt( docHelper.getDefFontSize() );
		}
		style = handleFontStyle(style, fontStyle);
		if ( fontName == null ) {
			fontName = docHelper.getDefFontName();
		}
		if ( "helvetica".equalsIgnoreCase( fontName ) ) {
			bfV = Font.HELVETICA;
		} else if ( "courier".equalsIgnoreCase( fontName ) ) {
			bfV = Font.COURIER;
		} else if ( "times-roman".equalsIgnoreCase( fontName ) ) {
			bfV = Font.TIMES_ROMAN;
		} else if ( "symbol".equalsIgnoreCase( fontName ) ) {
			bfV = Font.SYMBOL;
		} else {
			bf = OpenPpfDocHandler.findFont( fontName );
			if ( bf == null) {
				bf = BaseFont.createFont( fontPath, BaseFont.CP1252, true );
				OpenPpfDocHandler.registerFont( fontName, bf );
			}
		}
		Color c = Color.BLACK;
		if ( color != null ) {
			c = DocModelUtils.parseHtmlColor( color );
		}
		if ( bfV == -1 ) {
			font = new Font( bf, size, style, c );	
		} else {
			font = new Font( bfV, size, style, c );
		}
		return font;
	}
	
}