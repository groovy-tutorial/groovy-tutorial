/**
 * 
 */
package name.dickinson.duncan.book

/**
 * @author Duncan Dickinson
 *
 */
@groovy.transform.Immutable
class Book {
	BookInfo bookinfo
	Colophon colophon
	Dedication dedication
	Section[] preface
	Part[] parts	
}
