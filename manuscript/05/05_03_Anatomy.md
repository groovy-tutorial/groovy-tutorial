# Anatomy of an Exception

I> Before we handle the exception let's see what it looks like.

`Throwable` and all of its descendants provide a number of useful methods. Let's start off with a very basic `try-catch` block so that we can then dissect the NullPointerException:

{title="What a catch",lang=Java}
	try {
	    def person = null
	    person.getName()
	} catch (any) {
	    println "Exception received: ${any.class.name}"
	    println()
	    println "getMessage() returns: ${any.getMessage()}"
	    println()
	    println "getCause() returns: ${any.getCause()}"
	    println()
	    println 'getStackTrace() returned:'
	    for (item in any.getStackTrace()) {
	        println "${item.getFileName()}\t${item.getLineNumber()}\t${item.getClassName()}\t${item.getMethodName()}\t${item.isNativeMethod()}"
	    }
	}

`any.class.name`
: Tells us the type of exception that was raised

: We get: `java.lang.NullPointerException`

`getMessage()`
: Returns the message that was set by the thrower of the exception

: We get: `Cannot invoke method getName() on null object`

`getCause()`
: This isn't always set but can be handy to know. Essentially this is set if the exception is "relaying" another exception.

: We get: `null`

`for (item in any.getStackTrace()) {..}`
: The `getStackTrace()` method returns an array of `java.lang.StackTraceElement`. Each `StackTraceElement` can then be further dissected to see what was happening when the exception occurred.

: In my example I output a tab separated row for each `StackTraceElement` - the methods that I call should be reasonably self-explanatory but you can always check the [Java API](http://docs.oracle.com/javase/8/docs/api/java/lang/StackTraceElement.html) for more information.

: To just dump out the stack trace I could have just used `printStackTrace()`
