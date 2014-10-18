/**
 * 
 */
package name.dickinson.duncan.book.util

import java.nio.file.Files
import java.nio.file.Paths

import name.dickinson.duncan.book.Book

import org.yaml.snakeyaml.Yaml

/**
 * @author Duncan Dickinson
 *
 */
class Loader {

	static loadBook(String bookConfig = 'src/main/resources/book.yaml') 
		throws FileNotFoundException, IllegalStateException {
		// Pre: The requested file must exist
		def path = Paths.get(bookConfig).toAbsolutePath()
		if (Files.notExists(path)) {
			throw new FileNotFoundException("File: ${path}")
		}

		Yaml yaml = new Yaml()

		def input = new FileInputStream(bookConfig)
		def book = yaml.loadAs(input, Book.class)
		input.close()

		// Post: Never return null
		if (book == null) {
			throw new IllegalStateException('The YAML file was not read')
		}

		// Return
		return book
	}

	static main(args) {
		def book = loadBook()
		println book.toString()
	}
}
