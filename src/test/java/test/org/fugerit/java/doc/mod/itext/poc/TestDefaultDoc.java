package test.org.fugerit.java.doc.mod.itext.poc;

import org.fugerit.java.core.cfg.ConfigRuntimeException;
import org.fugerit.java.doc.mod.openpdf.HtmlTypeHandler;
import org.fugerit.java.doc.mod.openpdf.PdfTypeHandler;
import org.fugerit.java.doc.mod.openpdf.RtfTypeHandler;
import org.fugerit.java.doc.mod.openpdf.helpers.OpenPpfDocHandler;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lowagie.text.pdf.BaseFont;

public class TestDefaultDoc extends TestDocBase {

	private static final String CUSTOM_FONT = "TitilliumWeb";
	
	@BeforeClass
	public static void init() {
		try {
			OpenPpfDocHandler.registerFont( CUSTOM_FONT , "src/test/resources/font/TitilliumWeb-Regular.ttf");
		} catch (Exception e) {
			throw new ConfigRuntimeException( e );
		}
	}
	
	private static final String DEFAULT_DOC = "default_doc";
	
	private static final String DEFAULT_DOC_ALT = "default_doc_alt";
	
	private static final String DEFAULT_DOC_ALT1 = "default_doc_alt1";

	private static final String DEFAULT_DOC_ALT2 = "default_doc_alt2";
	
	@Test
	public void testOpenFailPDF() {
		Assert.assertThrows( AssertionError.class , () -> this.testDocWorker( "default_doc_fail1" ,  PdfTypeHandler.HANDLER ) );
	}
	
	@Test
	public void testCustomFont() {
		BaseFont font = OpenPpfDocHandler.findFont( CUSTOM_FONT );
		Assert.assertNotNull(font);
	}
	
	@Test
	public void testOpenPDF() {
		boolean ok = this.testDocWorker( DEFAULT_DOC ,  PdfTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}

	@Test
	public void testOpenHTML() {
		boolean ok = this.testDocWorker( DEFAULT_DOC ,  HtmlTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}
	
	@Test
	public void testOpenRTF() {
		boolean ok = this.testDocWorker( DEFAULT_DOC ,  RtfTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}
	
	@Test
	public void testOpenAltPDF() {
		boolean ok = this.testDocWorker( DEFAULT_DOC_ALT ,  PdfTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}

	@Test
	public void testOpenAltHTML() {
		boolean ok = this.testDocWorker( DEFAULT_DOC_ALT ,  HtmlTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}
	
	@Test
	public void testOpenAltRTF() {
		boolean ok = this.testDocWorker( DEFAULT_DOC_ALT ,  RtfTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}
	
	
	@Test
	public void testOpenAlt1PDF() {
		boolean ok = this.testDocWorker( DEFAULT_DOC_ALT1 ,  PdfTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}

	@Test
	public void testOpenAlt1HTML() {
		boolean ok = this.testDocWorker( DEFAULT_DOC_ALT1 ,  HtmlTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}
	
	@Test
	public void testOpenAlt1RTF() {
		boolean ok = this.testDocWorker( DEFAULT_DOC_ALT1 ,  RtfTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}
	
	@Test
	public void testOpenAlt2PDF() {
		boolean ok = this.testDocWorker( DEFAULT_DOC_ALT2 ,  PdfTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}

	@Test
	public void testOpenAlt2HTML() {
		boolean ok = this.testDocWorker( DEFAULT_DOC_ALT2 ,  HtmlTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}
	
	@Test
	public void testOpenAlt2RTF() {
		boolean ok = this.testDocWorker( DEFAULT_DOC_ALT2 ,  RtfTypeHandler.HANDLER );
		Assert.assertTrue(ok);
	}
	
}
