/**
 * Demonstrates basic methods for reading directories
 *
 * File: Directories.groovy
 * 
 * Note: Make sure that you start `groovyConsole` from the `src/` directory or the examples won't work!
 */

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path

//Load the `sampledir` path as an absolute path
def path = Paths.get("sampledir").toAbsolutePath()

//We can check if the path exists using `Files.exists`
if (! Files.exists(path)) {
    println "The path does not exist: $path"
    //We could raise a `java.io.FileNotFoundException` here
    return false
}

//We can check if the path is a directory using `Files.isDirectory`
if (! Files.isDirectory(path)) {
    println "The path is not a directory: $path"
    //We could raise a `java.lang.IllegalArgumentException` here
    return false
}

//The `toString()` method will display the full path
println "Path: ${path.toString()}"

//The `getParent()` method returns the parent directory and `getFileName` returns the directory name without the rest of the path
println "Parent directory: ${path.getParent().getFileName()}"

//The Groovy JDK extension includes a [traverse method](http://beta.groovy-lang.org/docs/latest/html/groovy-jdk/java/nio/file/Path.html#traverse(java.util.Map,%20groovy.lang.Closure) for `java.nio.file.Path`
//The `traverse` method takes a closure as an argument and calls this closure for each descendent under the path
println 'Directory listing:'
path.traverse {println "  - ${path.relativize(it)}"}