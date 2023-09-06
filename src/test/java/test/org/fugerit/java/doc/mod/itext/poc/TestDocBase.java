package test.org.fugerit.java.doc.mod.itext.poc;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.fugerit.java.core.lang.helpers.ClassHelper;
import org.fugerit.java.doc.base.config.DocInput;
import org.fugerit.java.doc.base.config.DocOutput;
import org.fugerit.java.doc.base.config.DocTypeHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestDocBase {

	protected boolean testDocWorker( String testCase, DocTypeHandler handler ) {
		boolean ok = false;
		String inputXml = "xml/"+testCase+".xml" ;
		File outputFile = new File( "target", testCase+"."+handler.getType() );
		log.info( "inputXml:{}, outputFile:{}", inputXml, outputFile );
		try ( InputStreamReader reader = new InputStreamReader( ClassHelper.loadFromDefaultClassLoader( inputXml ) );
				OutputStream os = new FileOutputStream( outputFile ) ) {
			handler.handle( DocInput.newInput( handler.getType() , reader ) , DocOutput.newOutput(os) );
			ok = true;
		} catch (Exception e) {
			String message = "Error : "+e.getMessage();
			log.error( message , e );
			fail( message );
		}
		return ok;
	}
	
}
