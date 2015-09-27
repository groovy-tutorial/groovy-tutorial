# Running a script
Now that we can output something to the screen, let's try and make our example a little more personal. Clear the Groovy Console editor and enter the following:

{title="Using command-line arguments",lang=Java}
    println "hello, ${args[0]}"

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

	hello, Newman

Of course you can change "Newman" to be any name so feel free to try out your name, the dog's name etc. However, make sure you add a name - your script needs that parameter or you'll see a disconcerting error.
