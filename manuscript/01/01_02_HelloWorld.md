# Your first lines of Groovy

I> It has become a tradition (maybe an unwritten law) that the first lines of code that you write in a new language are to output the line `hello, world`. So let's start up the Groovy Console and get going.

The Groovy Console provides a handy environment for preparing and testing basic Groovy scripts. In order to open the console you need to start a command line (or terminal) session and enter the following command:

{title="Start the console",lang=bash}
	groovyConsole &

I> On Windows...
I> Windows users may also find a link to `Groovy Console` in their Start menu.

The Groovy Console should look something like the following screen grab:

![Screen shot of the Groovy Console application window](images/GroovyConsole.png)

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

{title="Let's get groovy",lang=groovy}
	print 'hello, world'

T> Groovy web console
T> Don't forget that you can also try out the [Groovy web console](http://groovyconsole.appspot.com) - it'll run this code just fine.

Once that's ready, go to the menu and select `Script -> Run` and you should see your output in the bottom half of the window something like the image below:

![Screen shot of the Groovy Console application window with the hello, world script](images/GroovyConsoleOutput.png)

If you see the output `hello, world` then congratulations - you've taken your first step into a larger world.

## Examining the script
Our first Groovy script is very simple: it uses the `print` method (function) to output the string `hello world` to the console.

T> Groovy has a flexible syntax and can accept either `print 'hello, world'` or `print('hello, world')`

For those that have come from languages such as C++ and Java the script `print "hello, world"` probably appears to be missing items such as imported libraries for output and "container" or "boilerplate" code that sets up the context of the code. In fact, if we were to write this code in Java it would look something like:

{lang=java}
<<[Hello,world - Java style](code/01/02/java/Hello.java)

T> ## Running java
T> To run the code above we'd need to run the following from the command line:
T> `> javac Hello.java`
T> `> java -cp . Hello`

When I look at the code above I see why Groovy is so appealing to me:

 1. Groovy lets me focus on solving the problem and not working through so much decoration code.
     * Groovy doesn't need semi-colons at the end of each statement
     * Groovy essentially builds the `Hello` class around the script
 2. The Groovy code is much more readable and this *should* help reduce bugs (or at least make finding them easier)
 3. Most Java code is valid Groovy code - you can copy that Java code into the Groovy Console and run it - it will work
 4. Groovy lets you use the comprehensive standard Java libraries and the extensive third-party libraries written by the Java developer community.
	 1. But also extends these standard libraries with some great timesavers.

Groovy gives us the brevity and flexibility of a scripting language (such as Python, Ruby and Perl) whilst letting us tap into the galaxy of existing Java libraries.


