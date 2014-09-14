---
Title:		Your first lines of Groovy
Abstract:	It has become a tradition (maybe an unwritten law) that the first lines of code
			that you write in a new language are to output the line `hello, world`. So let's
			start up the Groovy Console and get going.
...
# [%Title]

[%Abstract] 

## Starting with the console
The Groovy Console provides a handy environment for preparing and testing basic Groovy scripts. In order to 
open the console you need to start a command line (or terminal) session and enter the following command:

````
groovyConsole
````

_Note: Windows users may also find a link to `Groovy Console` in their Start menu._

The Groovy Console should look something like the following screen grab:

![Groovy Console ](img/GroovyConsole.png)

The main parts of the console are:
 1. The top half is the editor area for adding your Groovy scipt
 2. The bottom half is the output area that displays the results of your script
 3. The menu provides the standard tools for opening and saving files (`File`) and cut/copy/paste (`Edit`)
 1. The `Script` menu gives you a number of functions you'll use as you work through this book:
  	1. `Run` will run the script
  	2. `Run Selection` allows you to select (highlight) part of your script and run only that section
  1. The `View` menu lets you reset the output area (`Clear Output`)
  	2. I'd suggest that you select `Auto Clear Output on Run` as this helps reduce confusion 

Once you have the Groovy Console open, enter the following line in the editor area:

````
print "hello, world"
````

Once that's ready, go to the menu and select `Script -> Run` and you should see your output in the bottom half of the window something like the image below:

 ![Groovy Console ](img/GroovyConsoleOutput.png)
 
If you see the output `hello, world` then congratulations - you've taken your first step into a larger world.

## Examining the script 
Our first Groovy script is very simple: it uses the `print` method (function) to output the string `hello world` to the console.

For those that have come from languages such as C++ and Java the script `print "hello, world"` probably appears to be missing items such as imported libraries for output and "container" code such that sets up the context of the code. In fact, if we were to write this code in Java it would look something like:

```java
class Hello {
    public static void main(String[] args) {
        System.out.print("hello, world");
    }
}

Hello.main();
```

When I look at the code above I see why Groovy is so appealing to me:
 1. Groovy lets me focus on solving the problem and not working through so much decoration code.
 	* Groovy doesn't need semi-colons at the end of each statement
 	* Groovy essentially builds the `Hello` class around the script
 2. The Groovy code is much more readable and this *should* help reduce bugs (or at least make finding them easier)
 3. Most Java code is valid Groovy code - you can copy that Java code into the Groovy Console and run it - it will work 
 4. Groovy lets you use the comprehensive standard Java libraries and the extensive third-party libraries written by the Java developer community.

Groovy gives us the brevity and flexibility of a scripting language (such as Python, Ruby and Perl) whilst letting us tap into the galaxy of existing Java libraries.

## Going a little further
Now that we can output something to the screen, let's try and make our example a little more personal. Clear the Groovy Console editor and enter the following:

````
println "hello, ${args[0]}"
````

Before we try to run this, let's look at what's in the code:
 1. `print` has become `println` - this does the same thing as our previous use of `print` but adds a new line at the end of the output. 
 	* This makes the output easier to read when we're running on the command line
 2. Instead of the text `world` we're now using `${args[0]}`:
	* `args` is a built-in variable (an array) that holds any command-line arguments we pass to the script
		* You may have noticed `String[] args` in the Java version of `hello, world` - essentially Groovy is writing that segment of code for you.
		* `args[0]` is the first element in the `args` array - this is the first parameter (command-line argument) passed to the script
	* The `${...}` notation tells Groovy that the contents need to the resolved into a value - in this case Groovy needs to determine the value of `args[0]` before displaying the output

Don't worry if this appears to be a big jump from our `hello, world` - there's a range of concepts being introduced and we'll work through them in this tutorial section. For now, put the code into your Groovy Console and know that, when run, your script will say hello to a specified person.
	
You now need to save your script so go to the `File` menu and select `Save`. When prompted, name the file `hello.groovy` and save it into a directory you can access. 

Unfortunately we can't run this script in the Groovy Console as it doesn't provide an option for passing in a parameter. Follow this process to run the script:
 1. Open a command prompt (terminal) and change to the directory (`cd`) into which you saved `Hello.groovy`.
 2. Type the command `groovy Hello.groovy Newman` and press the `return` key

You should see the following output:

````
hello, Newman
````

Of course you can change "Newman" to be any name so feel free to try out your name, the dog's name etc. However, make sure you add a name - your script needs that parameter or you'll see a disconcerting error.

### Compiling Groovy
You can compile a Groovy script into a `class` file - the same type of file that Java developers compile their code into. The resulting `class` file is in bytecode format that can be read by the Java Virtual Machine (JVM). 

In order to compile `Hello.groovy` we will use the `groovyc` command in the command-prompt as follows:
````
groovyc Hello.groovy
````

When you look at the directory contents you should now see a file named `hello.class`. Don't try to read the contents of the file - it's now in bytecode.

In order to run your new application you enter the following command:
````
groovy --classpath=. Hello Jerry
````
You should see the output `hello, Jerry`.

This uses the `groovy` command to run your compiled script but how?
 1. The `--classpath=.` parameter tells `groovy` to look for `.class` files in the current directory (denoted as `.`)
 2. 'Hello' is a little confusing until we remember that we named our script file `Hello.groovy`
 	1. When `groovyc` compiled our script it generated a class named `Hello` with a `main` method around our single line so that, behind the scenes, the code looked like the Java version discussed earlier
 3. And `Jerry` is the name of the person we're greeting

The call to `groovy` basically says "Run the main method in the Hello class and pass it Jerry as the parameter".

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

## Moving on
At this point we've done a few things:
 1. Opened the Groovy Console, written a very basic script and run it in the Groovy Console
 2. Personalised the script and run it on the command prompt, passing it a parameter
 3. Compiled the Groovy file into a bytecode `.class` file and run it
 
If the stars aligned then you may have also been able to run your `hello.class` file using the direct call to `java` but don't stress if that didn't work.

Let's move onto writing some more useful Groovy.