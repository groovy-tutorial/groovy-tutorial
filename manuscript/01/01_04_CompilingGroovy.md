# Compiling Groovy
You can compile a Groovy script into a `class` file - the same type of file that Java developers compile their code into. The resulting `class` file is in bytecode format that can be read by the Java Virtual Machine (JVM). Once compiled to bytecode, Groovy code can work on the same JVM that runs existing Java systems - this is extremely handy if you work in a Java-centric organisation but want to use Groovy.

In order to compile `Hello.groovy` we will use the `groovyc` command in the command-prompt as follows:

	groovyc Hello.groovy

When you look at the directory contents you should now see a file named `Hello.class`. Don't try to read the contents of the file - it's now in bytecode.

We'll explore this further in the [Organising your code](#chorganising) chapter.
