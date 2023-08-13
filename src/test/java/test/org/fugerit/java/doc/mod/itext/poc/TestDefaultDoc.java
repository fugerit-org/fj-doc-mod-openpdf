package test.org.fugerit.java.doc.mod.itext.poc;

import org.fugerit.java.doc.mod.openpdf.PdfTypeHandler;
import org.junit.Test;

public class TestDefaultDoc extends TestDocBase {

	@Test
	public void testOpenPDF() {
		this.testDocWorker( "default_doc" ,  PdfTypeHandler.HANDLER );
	}
	
}
