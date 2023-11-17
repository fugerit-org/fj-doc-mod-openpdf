package org.fugerit.java.doc.mod.openpdf.events;

import org.fugerit.java.core.function.SafeFunction;
import org.fugerit.java.doc.base.model.DocBase;
import org.fugerit.java.doc.base.model.DocElement;
import org.fugerit.java.doc.base.model.DocPara;
import org.fugerit.java.doc.base.model.DocPhrase;
import org.fugerit.java.doc.mod.openpdf.helpers.PageNumberHelper;

import com.lowagie.text.Document;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

import lombok.Getter;

/**
 * <p>
 * Event Helper for ${currentPage} and ${pageCount} properties
 * </p>
 * 
 * <p>
 * Adapted from :
 * https://github.com/LibrePDF/OpenPDF/blob/master/pdf-toolbox/src/test/java/com/lowagie/examples/directcontent/pageevents/PageNumbersWatermark.java
 * </p>
 * 
 */
public class PageNumbersEventHandler extends PdfPageEventHelper {

	public PageNumbersEventHandler(DocBase docBase) {
		super();
		this.pageNumberHeader = PageNumberHelper.findPageNumberElement(docBase.getDocHeader());
		this.pageNumberFooter = PageNumberHelper.findPageNumberElement(docBase.getDocFooter());
	}

	/** A template that will hold the total number of pages. */
	private PdfTemplate tpl;

	/** The font that will be used. */
	private BaseFont helv;

	private DocElement pageNumberHeader;

	private DocElement pageNumberFooter;

	@Override
	public void onOpenDocument(PdfWriter writer, Document document) {
		if (this.pageNumberFooter != null || this.pageNumberHeader != null) {
			SafeFunction.apply(() -> {
				// initialization of the template
				tpl = writer.getDirectContent().createTemplate(100, 100);
				tpl.setBoundingBox(new Rectangle(-20, -20, 100, 100));
				// initialization of the font
				helv = BaseFont.createFont("Helvetica", BaseFont.WINANSI, false);
			});
		}
	}

	private void headerFooterHelper(PdfWriter writer, Document document, DocElement element, boolean header) {
		if (element!= null) {
			ElementData data = new ElementData( element );
			PdfContentByte cb = writer.getDirectContent();
			cb.saveState();
			String text = data.parseText( writer.getPageNumber() );
			float textSize = helv.getWidthPoint(text, 12);
			float textBase = document.bottom() - 20;
			if ( header ) {
				textBase = document.top() - 20;
			}
			float align = document.left();
			float templateAlign = align + textSize;
			if ( data.getAlign() == DocPara.ALIGN_RIGHT ) {
				templateAlign = document.right();
				align = templateAlign - textSize;
			} else if ( data.getAlign() == DocPara.ALIGN_CENTER ) {
				align = (document.right()-document.left()-textSize)/2;
				templateAlign = align+textSize;
			}
			cb.beginText();
			cb.setFontAndSize(helv, 12);
			cb.setTextMatrix(align, textBase);
			cb.showText(text);
			cb.endText();
			cb.addTemplate(tpl, templateAlign, textBase);
			cb.restoreState();
			cb.sanityCheck();
		}
	}
	
	@Override
	public void onStartPage(PdfWriter writer, Document document) {
		this.headerFooterHelper(writer, document, this.pageNumberHeader, true);
	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		this.headerFooterHelper(writer, document, this.pageNumberFooter, false);
	}

	@Override
	public void onCloseDocument(PdfWriter writer, Document document) {
		if (this.pageNumberFooter != null || this.pageNumberHeader != null) {
			tpl.beginText();
			tpl.setFontAndSize(helv, 12);
			tpl.setTextMatrix(0, 0);
			tpl.showText(Integer.toString(writer.getPageNumber() - 1));
			tpl.endText();
			tpl.sanityCheck();
		}
	}

}

class ElementData {
	
	@Getter private int align;
	
	@Getter private String text;
	
	public ElementData( DocElement element ) {
		if ( element instanceof DocPhrase ) {
			DocPhrase e = (DocPhrase)element;
			this.align = DocPara.ALIGN_CENTER;
			this.text = e.getText();
		} else if ( element instanceof DocPara ) {
			DocPara e = (DocPara)element;
			this.align = e.getAlign();
			this.text = e.getText();
		}
	}
	
	public String parseText( int pageNumber ) {
		return this.getText().replace( PageNumberHelper.CURRENT_PAGE , String.valueOf(pageNumber) ).replace( PageNumberHelper.PAGE_COUNT , "" );
	}
	
}