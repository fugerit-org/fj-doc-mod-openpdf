package org.fugerit.java.doc.mod.openpdf.helpers;

import lombok.extern.slf4j.Slf4j;
import org.fugerit.java.core.cfg.ConfigException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Slf4j
public class OpenPDFConfigHelper {

    public static void handleConfig( Element config, String type ) throws ConfigException {
        log.info( "configure for type: {}", type );
        NodeList fontList = config.getElementsByTagName( "font" );
        for ( int k=0; k<fontList.getLength(); k++ ) {
            Element currentFontTag = (Element) fontList.item( k );
            String name = currentFontTag.getAttribute( "name" );
            String path = currentFontTag.getAttribute( "path" );
            log.info( "current font {} - {}", name, path );
            ConfigException.apply( () -> OpenPpfDocHandler.registerFont( name , path ) );
        }
    }

}
