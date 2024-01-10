package test.org.fugerit.java.doc.mod.openpdf.poc;

import org.fugerit.java.doc.mod.openpdf.PdfTypeHandler;
import org.junit.Assert;
import org.junit.Test;

public class TestSpec extends TestDocBase {

	private static final String DEFAULT_DOC = "test";
	
	@Test
	public void testOpenPDF() {
		boolean ok = this.testDocWorker( DEFAULT_DOC ,  PdfTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}

}
