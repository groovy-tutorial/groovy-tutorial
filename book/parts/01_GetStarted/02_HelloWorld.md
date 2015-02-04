---
title:	Your first lines of Groovy
status:	in-progress
description:	It has become a tradition (maybe an unwritten law) that the first lines of code that you write in a new language are to output the line `hello, world`. So let's start up the Groovy Console and get going.
...
The Groovy Console provides a handy environment for preparing and testing basic Groovy scripts. In order to open the console you need to start a command line (or terminal) session and enter the following command:

```bash
groovyConsole &
```

_Note: Windows users may also find a link to `Groovy Console` in their Start menu._

The Groovy Console should look something like the following screen grab:

![Screen shot of the Groovy Console application window][GroovyConsole]

[GroovyConsole]: resources/images/GroovyConsole.png "Screen shot of the Groovy Console application window" height=400px

The main parts of the console are:

 1. The top half is the editor area for adding your Groovy script
 1. The bottom half is the output area that displays the results of your script
 1. The menu provides the standard tools for opening and saving files (`File`) and cut/copy/paste (`Edit`)
 1. The `Script` menu gives you a number of functions you'll use as you work through this book:
      1. `Run` will run the script
      2. `Run Selection` allows you to select (highlight) part of your script and run only that section
  1. The `View` menu lets you reset the output area (`Clear Output`)
      2. I'd suggest that you select `Auto Clear Output on Run` as this helps reduce confusion 

Once you have the Groovy Console open, enter the following line in the editor area:

````groovy
print 'hello, world'
````

>Don't forget that you can also try out the [Groovy web console](http://groovyconsole.appspot.com) - it'll run this code just fine.

Once that's ready, go to the menu and select `Script -> Run` and you should see your output in the bottom half of the window something like the image below:

![Screen shot of the Groovy Console application window with the hello, world script][GroovyConsoleHW] 

[GroovyConsoleHW]: resources/images/GroovyConsoleOutput.png "Screen shot of the Groovy Console application window with the `hello, world` script" height=400px
 
If you see the output `hello, world` then congratulations - you've taken your first step into a larger world.

# Examining the script 
Our first Groovy script is very simple: it uses the `print` method (function) to output the string `hello world` to the console.

For those that have come from languages such as C++ and Java the script `print "hello, world"` probably appears to be missing items such as imported libraries for output and "container" or "boilerplate" code that sets up the context of the code. In fact, if we were to write this code in Java it would look something like:

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
	 1. But also extends these standard libraries with some great timesavers.

Groovy gives us the brevity and flexibility of a scripting language (such as Python, Ruby and Perl) whilst letting us tap into the galaxy of existing Java libraries.

# Going a little further
Now that we can output something to the screen, let's try and make our example a little more personal. Clear the Groovy Console editor and enter the following:

```groovy
println "hello, ${args[0]}"
```

Before we try to run this, let's look at what's in the code:

 1. `print` has become `println` - this does the same thing as our previous use of `print` but adds a new line at the end of the output. 
     * This makes the output easier to read when we're running on the command line
 2. Instead of the text `world` we're now using `${args[0]}`:
    * `args` is a variable (an array[^array]) that holds any command-line arguments we pass to the script
        * You may have noticed `String[] args` in the Java version of `hello, world` - essentially Groovy is writing that segment of code for you.
        * `args[0]` is the first element in the `args` array - this is the first parameter (command-line argument) passed to the script
    * The `${...}` notation tells Groovy that the contents need to the resolved into a value - in this case Groovy needs to determine the value of `args[0]` before displaying the output

[^array]: More about arrays in a little bit

Don't worry if this appears to be a big jump from our `hello, world` - there's a range of concepts being introduced and we'll work through them in this tutorial section. For now, put the code into your Groovy Console and know that, when run, your script will say hello to a specified person.
    
You now need to save your script so go to the `File` menu and select `Save`. When prompted, name the file `Hello.groovy` and save it into a directory you can access. 

Unfortunately we can't run this script in the Groovy Console as it doesn't provide an option for passing in a command-line parameter. Follow this process to run the script:

 1. Open a command prompt (terminal) and change to the directory (`cd`) into which you saved `Hello.groovy`.
 2. Type the command `groovy Hello.groovy Newman` and press the `return` key

You should see the following output:

````
hello, Newman
````

Of course you can change "Newman" to be any name so feel free to try out your name, the dog's name etc. However, make sure you add a name - your script needs that parameter or you'll see a disconcerting error.

# Compiling Groovy
You can compile a Groovy script into a `class` file - the same type of file that Java developers compile their code into. The resulting `class` file is in bytecode format that can be read by the Java Virtual Machine (JVM). Once compiled to bytecode, Groovy code can work on the same JVM that runs existing Java systems - this is extremely handy if you work in a Java-centric organisation but want to use Groovy.

In order to compile `Hello.groovy` we will use the `groovyc` command in the command-prompt as follows:

````
groovyc hello.groovy
````

When you look at the directory contents you should now see a file named `Hello.class`. Don't try to read the contents of the file - it's now in bytecode.

In order to run your new application you enter the following command:

````
groovy --classpath=. Hello Jerry
````

You should see the output `hello, Jerry`.

This uses the `groovy` command to run your compiled script but how?

 1. The `--classpath=.` parameter tells `groovy` to look for `.class` files in the current directory (denoted as `.`)
 2. 'Hello' is a little confusing until we remember that we named our script file `Hello.groovy`
     - When `groovyc` compiled our script it generated a class named `Hello` with a `main` method around our single line so that, behind the scenes, the code turned into something like the Java version discussed earlier
 3. And `Jerry` is the name of the person we're greeting

The call to `groovy` basically says "Run the main method in the Hello class and pass it Jerry as the parameter".

# Moving on
At this point we've done a few things:

 1. Opened the Groovy Console, written a very basic script and run it in the Groovy Console
 2. Personalised the script and run it on the command prompt, passing it a parameter
 3. Compiled the Groovy file into a bytecode `.class` file and run it

Let's move onto writing some more useful Groovy.
