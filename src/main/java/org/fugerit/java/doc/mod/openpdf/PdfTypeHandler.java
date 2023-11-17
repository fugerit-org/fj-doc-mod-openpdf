package org.fugerit.java.doc.mod.openpdf;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.fugerit.java.doc.base.config.DocInput;
import org.fugerit.java.doc.base.config.DocOutput;
import org.fugerit.java.doc.base.config.DocTypeHandler;
import org.fugerit.java.doc.base.config.DocTypeHandlerDefault;
import org.fugerit.java.doc.base.model.DocBase;
import org.fugerit.java.doc.mod.openpdf.events.PageNumbersEventHandler;
import org.fugerit.java.doc.mod.openpdf.helpers.OpenPpfDocHandler;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;

public class PdfTypeHandler extends DocTypeHandlerDefault {

	private static final long serialVersionUID = 5459938865782356227L;
	
	public static final DocTypeHandler HANDLER = new PdfTypeHandler();
	
	/*
	 * OpenPDF examples : https://github.com/LibrePDF/OpenPDF/tree/master/pdf-toolbox/src/test/java/com/lowagie/examples
	 */
	
	public PdfTypeHandler() {
		super( OpenPpfDocHandler.DOC_OUTPUT_PDF, OpenPpfDocHandler.MODULE );
	}

	@Override
	public void handle(DocInput docInput, DocOutput docOutput) throws Exception {
		DocBase docBase = docInput.getDoc();
		OutputStream outputStream = docOutput.getOs();
		String[] margins = docBase.getInfo().getProperty( "margins", "20;20;20;20" ).split( ";" );
		Document document = new Document( PageSize.A4, Integer.parseInt( margins[0] ),
				Integer.parseInt( margins[1] ),
				Integer.parseInt( margins[2] ), 
				Integer.parseInt( margins[3] ) );
		// allocate buffer
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// create pdf writer
		PdfWriter pdfWriter = PdfWriter.getInstance( document, baos );
		// create doc handler
		OpenPpfDocHandler handler = new OpenPpfDocHandler( document, pdfWriter );
		//pdfWriter.setPageEvent( new PageNumbersEventHandler( docBase ) );
		handler.handleDoc( docBase );
		baos.writeTo( outputStream );
		baos.close();
		outputStream.close();	
	}

}
