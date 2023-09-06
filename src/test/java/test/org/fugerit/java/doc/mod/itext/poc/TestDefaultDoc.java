package test.org.fugerit.java.doc.mod.itext.poc;

import org.fugerit.java.doc.mod.openpdf.HtmlTypeHandler;
import org.fugerit.java.doc.mod.openpdf.PdfTypeHandler;
import org.fugerit.java.doc.mod.openpdf.RtfTypeHandler;
import org.junit.Test;

public class TestDefaultDoc extends TestDocBase {

	@Test
	public void testOpenPDF() {
		this.testDocWorker( "default_doc" ,  PdfTypeHandler.HANDLER );
	}

	@Test
	public void testOpenHTML() {
		this.testDocWorker( "default_doc" ,  HtmlTypeHandler.HANDLER );
	}
	
	@Test
	public void testOpenRTF() {
		this.testDocWorker( "default_doc" ,  RtfTypeHandler.HANDLER );
	}
	
}
