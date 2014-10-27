/**
 * Demonstrates basic methods for reading a file
 *
 * File: BasicRead.groovy
 * 
 * Note: Make sure that you start `groovyConsole` from the `src/` directory or the examples won't work!
 */

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path

//Load the `sampledir` path as an absolute path
def path = Paths.get("sampledir/poem/snowyriver.txt").toAbsolutePath()

//We can check if the path exists using `Files.notExists`
if (Files.notExists(path)) {
    println "The file does not exist: $path"
    //We could raise a `java.io.FileNotFoundException` here
    return false
}

//We can check if the path is readable using `Files.isReadable`
if (! Files.isReadable(path)) {
    println "The path is not readable: $path"
    //We could raise a `java.nio.file.AccessDeniedException` here
    return false
}

//We can check if the path is a regular file (i.e. not a directory) `Files.isRegularFile`
if (! Files.isRegularFile(path)) {
    println "The path is not a regular file: $path"
    //We could raise a `java.lang.IllegalArgumentException` here
    return false
}

println 'File contents:'
println path.getText()