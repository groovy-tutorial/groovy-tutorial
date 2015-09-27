# Blocks

I> These blocks are not as fun as the wooden version but just as important in building programs.

%%This chapter is really just a note about syntax - feel free to move to the next chapter after a quick glance here.

Groovy uses curly brackets `{..}` to enclose blocks of code. These are primarily used to group a set of statements within elements such as control flow, class, method and closure declarations. Blocks also let you "partition off" parts of code so that items such as variables aren't visible to other parts of your code - referred to as "scope".

Groovy doesn't allow the use of anonymous code block such as the one below:

{title="A sample block",lang=Java}
	{
	    def count = 0
	    assert count == 0
	}


You need to label the block provided above if you want to use it in Groovy code:

{title="A labelled block",lang=Java}
	Block1:{
	    def count = 0
	    assert count == 0
	}


This limitation is primarily due to the closure syntax - labelling the block ensures it isn't confused with a closure.

Blocks appearing within blocks are called "nested blocks":

{title="A nested block",lang=Java}
	Block1:{
	    def count = 0
	    assert count == 0
	    NestedBlock: {
	        assert count == 0
	    }
	}


If the above code was a Groovy script the block structures really would be redundant "noise" - you're not likely to see usage such as `Block1:{..}` very often. You're more likely to see blocks used with control flow statements (such as `if`):


	if (true) {
	    //some code
	}


... in class declarations:


	class Person {

	}


... in method declarations:


	def doStuff() {

	}


... in closure declarations


	{name ->
	    println "Hello, $name"
	}


## Variable Scope

Variable Scope refers to the visibility of a variable from other blocks. A variable declared at the top level is visible to blocks nested within it. The reverse, however, is not true. This lets us declare variables within a block that is specific to that block (and any nested blocks) but doesn't interfere with the rest of the program.

In the example below, the code within `Block1` can "see" the `count` variable so both asserts work:

{title="A sample block",lang=Java}
	def count = 0

	Block1: {
	    assert count == 0
	}

	assert count == 0


The second `assert` will fail as `count` is not in scope in the main body of the script:


	Block1: {
	    def count = 0
	    assert count == 0
	}

	assert count == 0


In the next example, `count` is visible to the nested bock (`Block2`):


	Block1:{
	    def count = 0

	    Block2:{
	        assert count == 0
	    }
	}


What all of this means is that you need to keep an eye on where the variable can be "seen". In the example below, the `volume` variable is visible (within scope) of the `if` block but the `dbLevel` variable is local to the `if` block.


	def volume = 11

	if (volume > 10) {
	    def dbLevel = 'extreme'
	    println "A volume of $volume is $dbLevel"
	    //more code
	}


I repeatedly make a mistake in which I declare a variable within a `try` block but I need to use the variable later on. The code below is an example of my mistake - `println myObj` will never work as `myObj` is not visible at that level.


	try {
	    def myObj = new Object()
	} catch (any) {
	    //Do something to handle the exception
	}

	println myObj


I've put the `def myObj = new Object()` into the `try` block as the instantiation may cause an exception. What I needed to do was separate the variable definition (`def`) from the creation of a new instance (instantiation):


	def myObj

	try {
	    myObj = new Object()
	} catch (any) {
	    //Do something to handle the exception
	}

	println myObj
