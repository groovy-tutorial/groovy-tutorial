# Try-Catch-Finally

I> The `try-catch-finally` statement is used for catching and handling exceptions and errors.

The `try-catch-finally` statement can have three forms:

1. `try-catch`
2. `try-catch-finally`
3. `try-finally`

Groovy doesn't support the `try-with-resources` syntax available in Java. Groovy's closure infrastructure often takes care of closing resources for you (you may not even need a `finally` block).

## Scope
Before getting into the specific syntax it's important to point out that the `try` statement presents a block with its own scope. This means that variables declared within the `try` block can't been seen outside the block. In the example below the `assert` fails not because `score` doesn't equal 12 but because the `score` variable is out-of-scope:

	try {
	    def score = 12
	} catch (any) {

	}

	assert score == 12

In fact, the `score` variable won't be visible to the `catch` block or a `finally block`. If you do need to access `score` outside of the `try` block then you should declare it before the `try`:

	def score
	try {
	    score = 12
	} catch (any) {

	}

	assert score == 12

## try-catch
The basic format of `try-catch`  is as follows:

{title="`try-catch`",lang=Java}
	try {
		//statements...
	} catch (<Exception type> <var>) {
		//statements...
	}


If an exception occurs within the `try` block:

- The catch variable (`var`) is set to the exception instance
- If `Exception type` is provided (this is optional) then the `catch` block will only be activated if the exception is of that type.

In the following example I generate an exception on purpose by dividing 10 by 0. The `catch` block is set up to catch any exception raised:


	try {
	    10 / 0
	} catch (any) {
	    println any.message
	    any.printStackTrace()
	}


As we saw in an earlier chapter, exceptions in Groovy are objects - they have fields and methods, allowing me to display the `message` within the exception as well as display the stack trace.

I> I like using `any` as the catch variable when I'm prepared to catch anything - it just reads nicely. However, you're also likely to see `e`, `exc` or a shortened version of the exception name (e.g. `npe` for a `NullPointerException`).

An Exception type can be provided for a `catch` block. In the example below I only catch an `ArithmeticException` - any other type of exception is raised up to the caller:


	try {
	    10 / 0
	} catch (ArithmeticException e) {
	    println 'I just caught an ArithmeticException'
	}


A `try-catch` statement can consist of multiple `catch` blocks, each targeting specific exceptions. In this next example I explicitly catch `ArithmeticException` and have a default `catch` to pick up any other exception raised:


	try {
	    10 / 0
	} catch (ArithmeticException e) {
	    println 'I just caught an ArithmeticException'
	} catch (any) {
	    println 'What just happened?'
	}


In this next example I explicitly catch `IllegalStateException` and `ArithmeticException` and have a default `catch` to pick up any other exception raised:


	try {
	    10 / 0
	} catch (IllegalStateException e) {
	    println 'I just caught an IllegalStateException'
	} catch (ArithmeticException e) {
	    println 'I just caught an ArithmeticException'
	} catch (any) {
	    println 'What just happened?'
	}


I> In that last example, `IllegalStateException` will never be raised but I've used it here to indicate syntax. Later in this chapter we'll make this example more meaningful

If we wanted to handle a number of exception types (sometimes called a multicatch) in the same manner, the `|` operator can be used within the same `catch` to provide a separator for the exception types:


	try {
	    10 / 0
	} catch (IllegalStateException | ArithmeticException e) {
	    println 'I just caught an exception I want to handle'
	} catch (any) {
	    println 'What just happened?'
	}


The last `catch` block (`catch (any)`) is a very useful one to reflect on when considering how you deal with exceptions. By providing a `catch` block you are flagging an intent to actually do __something useful__ with an exception. If you don't actually intend to add any value to the situation then I'd suggest not catching the exception. That way it will pass up the chain to the calling code (which may chose to actually handle the exception). The buck stops at the top-level code (e.g. the script) and, without explicit handling, the exception will be displayed and the program halted.

My preference is to use `try-finally` if I just want to tidy up resources (such as files) if an exception occurs - that way the exception will pass up to the caller but I don't get in the way. In most cases I use the explicit form of `catch` and indicate which Exception type I am prepared to handle.

## try-catch-finally
The `try-catch` statement can have an optional `finally` block. This is run regardless of if an exception is raised. The `finally` block doesn't receive any incoming parameter and can appear no more than once per `try`:

{title="`try-catch-finally`",lang=Java}
	try {
		//statements...
	} catch (<Exception type> <var>) {
		//statements...
	} finally {
		//statements
	}


In the code below, the `println` in the finally block will run regardless of whether an exception was raised or the `try` block completed successfully:


	try {
	    10 / 0
	} catch (any) {
	    println any.message
	} finally {
	    println 'I think we survived'
	}


But why use `finally`? Exceptions are used in a large number of places, including:

- Failure to read/write a file
- Failure to access a database
- Trying to access `null`

The `finally` block comes in handy when you need to tidy up resources before either completing the `try` block or losing control to an exception. You'll most commonly see `finally` used to close files, disconnect from databases or return the system to a state in which it can continue.

## try-finally
The third form of the `try` statement doesn't provide a `catch` block:

{title="`try-finally`",lang=Java}
	try {
		//statements...
	} finally {
		//statements
	}


Essentially we're indicating that any exceptions will just be raised up to the caller but we need to tidy up some resources before losing control:


	try {
	    10 / 0
	} finally {
	    println 'Finally block has been evaluated'
	}



W> ## Don't `println` in production
W> My examples have largely performed a `println` and this alone is not acceptable in production code. What a more serious piece of code should do is attempt to recover from the problem, most likely log the issue, and raise the exception to the caller if there's no possibility of repair.
