/**
 * Demonstrates basic methods for reading and writing a file
 *
 * File: BasicReadWrite.groovy
 * 
 * Note: Make sure that you start `groovyConsole` from the `src/` directory or the examples won't work!
 */

import java.nio.file.Files
import java.nio.file.Path

//`Files.createTempFile` is useful for this tutorial as it won't start putting files throught the tutorial examples
def file = Files.createTempFile(null, null)

println "Created $file"

//We'll add the following text to our file:
def text = '''When they reached the mountain's summit, even Clancy took a pull,
It well might make the boldest hold their breath,
The wild hop scrub grew thickly, and the hidden ground was full
Of wombat holes, and any slip was death.
But the man from Snowy River let the pony have his head,
And he swung his stockwhip round and gave a cheer,
And he raced him down the mountain like a torrent down its bed,
While the others stood and watched in very fear.
'''

//Use the `write` method to write the text to the file
file.write(text)

//Dsiplay the file contents using `getText`
println 'File content:'
println file.getText()

// Finally, use `Files.delete` to delete the file - feel free to comment this line out
// if you'd like to take a look at the file after the script has run
Files.delete(file)