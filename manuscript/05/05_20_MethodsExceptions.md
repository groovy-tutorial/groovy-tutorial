# Methods and Exceptions

I> Another small chapter on technique

The code in this chapter is rather skewed as we'd rarely throw an exception and catch it within the same `try-catch` block. Rather, we're most likely to throw an exception from a method back to the caller and we use `try` blocks to catch exceptions from methods we're calling.

Throwing an exception from a method results in no `return` value being returned to the caller - the caller needs to handle the exception. It's important to note that, where the `try` and/or `catch` block contain a `return` statement, the `finally` block will be evaluated __before__ the `return` is actually processed. In the next two examples below, the `println` in the `finally` block will always display.

{title="Using `return` in `catch`",lang=groovy}
	def testMethod() {
	    try {
	        10 / 0
	    } catch (any) {
	        return
	    } finally {
	        println 'Finally block has been evaluated'
	    }
	}

{title="Using `return` in `try`",lang=groovy}
	def testMethod() {
	    try {
	        return 100
	    } catch (any) {
	        println 'Exception'
	    } finally {
	        println 'Finally block has been evaluated'
	    }
	}

	testMethod()

We're about to get to the [section on Methods](#chmethods).
