---
Title:		Deploying scripts  
Abstract:	  
...
# [%Title]

[%Abstract] 

### Running in Java
_Note: This section gets complicated so have a try and see how you go. If you can't get it to work just move on and come back to it another time._

At this point you could email a friend with the `Hello.groovy` file and they could run it using the `groovy` command. This would also let them read the file and "hack" it if they wanted. Alternatively you could email `hello.class` and they could use the `groovy` command but wouldn't be able to read it.[^If they were skilled then they could decompile to class file so this approach isn't as secure as you might assume]. In both cases your friend would need to have Groovy installed on their own machine.

That last point is an important reason why Groovy and the other JVM-based languages are so useful. Our compiled `class` file can actually also be run using the standard Java application installed on so many PCs, laptops, servers etc. Using the `java` command, our friend could run our application but we need to send them two things:

 1. Our `hello.class` file
 2. A copy of a file containing the Groovy core and support modules.

The second item is packaged as a `jar` (or *J*ava *AR*chive) and contains the set of essential compiled Groovy classes. We need this as Groovy, in compiling our script, relies on using its own library. Fortunately, you got a copy of this file when you installed Groovy. It's likely to be named something like `groovy-all-2.3.6.jar` and is stored in the `embeddable` directory of you Groovy installation. On most systems you can find it by running the following command in the command prompt:

On Linux and OS X:

````
ls $GROOVY_HOME/embeddable
````

On Windows:

````
dir %GROOVY_HOME%/embeddable
````

If you're having no luck using the command prompt, try the search feature in your file browser or open the archive you downloaded to install Groovy. As a last-ditched effort try <http://search.maven.org/remotecontent?filepath=org/codehaus/groovy/groovy-all/2.3.6/groovy-all-2.3.6.jar> - just change the version number to match what you've installed.

Once you've found the groovy-all jar file, *copy* it to the same directory in which you've saved `hello.class` and then run:

````
java -classpath groovy-all-2.3.6.jar:. Hello Kramer
````

This does much the same as our call to `groovy --classpath=. Hello Jerry` but the call to the `java` application requires us to tell Java where to find the groovy-all archive. Essentially, the `groovy` application sets this up for us and then calls `java`.

If our friend has Java installed (they'd only need the JRE, not the JDK) then we could email them both `groovy-all-2.3.6.jar` and `hello.class` and tell them how to run our program. Well maybe this is OK for our fellow coders but it isn't something to email your nan.
