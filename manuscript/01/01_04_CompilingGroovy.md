# Compiling Groovy
You can compile a Groovy script into a `class` file - the same type of file that Java developers compile their code into. The resulting `class` file is in bytecode format that can be read by the Java Virtual Machine (JVM). Once compiled to bytecode, Groovy code can work on the same JVM that runs existing Java systems - this is extremely handy if you work in a Java-centric organisation but want to use Groovy.

In order to compile `Hello.groovy` we will use the `groovyc` command in the command-prompt as follows:

	groovyc hello.groovy

When you look at the directory contents you should now see a file named `Hello.class`. Don't try to read the contents of the file - it's now in bytecode.

In order to run your new application you enter the following command:

	groovy --classpath=. Hello Jerry

You should see the output `hello, Jerry`.

This uses the `groovy` command to run your compiled script but how?

 1. The `--classpath=.` parameter tells `groovy` to look for `.class` files in the current directory (denoted as `.`)
 2. 'Hello' is a little confusing until we remember that we named our script file `Hello.groovy`
     - When `groovyc` compiled our script it generated a class named `Hello` with a `main` method around our single line so that, behind the scenes, the code turned into something like the Java version discussed earlier
 3. And `Jerry` is the name of the person we're greeting

The call to `groovy` basically says "Run the main method in the Hello class and pass it Jerry as the parameter".
