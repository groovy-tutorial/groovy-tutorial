/**
 * 
 */
package name.dickinson.duncan.book

/**
 * @author Duncan Dickinson
 *
 */
@groovy.transform.Immutable
class BookInfo {
	String title
	String edition
	Date pubdate
	Copyright copyright
	LegalNotice legalnotice
	Person[] authorgroup
	String[] keywordset
	
}
