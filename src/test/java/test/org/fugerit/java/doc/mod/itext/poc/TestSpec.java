package test.org.fugerit.java.doc.mod.itext.poc;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.fugerit.java.doc.mod.openpdf.PdfTypeHandler;
import org.fugerit.java.doc.mod.openpdf.helpers.OpenPpfDocHandler;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSpec extends TestDocBase {

	private static final String CUSTOM_FONT = "Calibri";
	
	@BeforeClass
	public static void init() {
		try {
			OpenPpfDocHandler.registerFont( CUSTOM_FONT , "src/test/resources/font/TitilliumWeb-Regular.ttf");
		} catch (Exception e) {
			throw new ConfigRuntimeException( e );
		}
	}
	
	private static final String DEFAULT_DOC = "test";
	
	@Test
	public void testOpenPDF() {
		boolean ok = this.testDocWorker( DEFAULT_DOC ,  PdfTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}

}
