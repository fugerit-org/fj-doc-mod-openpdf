package org.fugerit.java.doc.mod.openpdf;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.fugerit.java.core.cfg.ConfigException;
import org.fugerit.java.doc.base.config.DocInput;
import org.fugerit.java.doc.base.config.DocOutput;
import org.fugerit.java.doc.base.config.DocTypeHandler;
import org.fugerit.java.doc.base.config.DocTypeHandlerDefault;
import org.fugerit.java.doc.base.model.DocBase;
import org.fugerit.java.doc.mod.openpdf.helpers.OpenPDFConfigHelper;
import org.fugerit.java.doc.mod.openpdf.helpers.OpenPpfDocHandler;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.rtf.RtfWriter2;
import org.w3c.dom.Element;

public class RtfTypeHandler extends DocTypeHandlerDefault {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7532380038613171305L;
	
	public static final DocTypeHandler HANDLER = new RtfTypeHandler();
	
	public RtfTypeHandler() {
		super( OpenPpfDocHandler.DOC_OUTPUT_RTF, OpenPpfDocHandler.MODULE );
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
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		RtfWriter2 rtfWriter2 = RtfWriter2.getInstance( document, baos );
		OpenPpfDocHandler handler = new OpenPpfDocHandler( document, rtfWriter2 );
		handler.handleDoc( docBase );
		baos.writeTo( outputStream );
		baos.close();
		outputStream.close();	
	}

	protected void handleConfigTag(Element config) throws ConfigException {
		super.handleConfigTag(config);
		OpenPDFConfigHelper.handleConfig( config, this.getType() );
	}

}
