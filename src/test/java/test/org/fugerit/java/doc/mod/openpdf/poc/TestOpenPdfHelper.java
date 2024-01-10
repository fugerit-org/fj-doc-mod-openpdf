package test.org.fugerit.java.doc.mod.openpdf.poc;

import org.fugerit.java.doc.mod.openpdf.helpers.PhraseParent;
import org.junit.Assert;
import org.junit.Test;

import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;

public class TestOpenPdfHelper {

	@Test
	public void test001() throws Exception {
		PhraseParent parent = new PhraseParent( new Phrase() );
		parent.add( new Paragraph() );
		Assert.assertNotNull( parent );
	}
	
}
