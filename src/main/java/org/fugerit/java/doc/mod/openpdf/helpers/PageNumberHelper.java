package org.fugerit.java.doc.mod.openpdf.helpers;

import org.fugerit.java.doc.base.model.DocContainer;
import org.fugerit.java.doc.base.model.DocElement;
import org.fugerit.java.doc.base.model.DocPara;
import org.fugerit.java.doc.base.model.DocPhrase;

public class PageNumberHelper {
	
	private PageNumberHelper() {}

	public static final String CURRENT_PAGE = "${currentPage}";
	
	public static final String PAGE_COUNT = "${pageCount}";
	
	public static boolean isPageNumberContent( String text ) {
		return text.contains( CURRENT_PAGE ) || text.contains( PAGE_COUNT );
	}
	
	public static DocElement findPageNumberElement( DocContainer c ) {
		DocElement res = null;
		for ( DocElement current : c.getElementList() ) {
			if ( current instanceof DocPara ) {
				DocPara element = (DocPara)current;
				if ( isPageNumberContent( element.getText() ) ) {
					res = element;
				}
			} else if ( current instanceof DocPhrase ) {
				DocPhrase element = (DocPhrase)current;
				if ( isPageNumberContent( element.getText() ) ) {
					res = element;
				}
			}
		} 
		return res;
	}
	
}
