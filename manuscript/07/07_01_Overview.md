# Introducing Closures

In the last tutorial we looked at methods and this prepares us as we start to look at closures. If you take a look at the following code you're likely to quickly see what the `printer()` method does:


	def printer(){
	    println 'Hello, world'
	}
	
	def cls = this.&printer
	cls()


So what about `def cls = this.&printer`? Well, `.&` is the Method Reference operator and it returns a reference to the `printer()` method. I use `this` in the script as I need to reference the current instance in which I'm running - remember that Groovy wraps the script in a class.

Once I have the reference I can then call the closure with `cls()`.

Note the following:

1. When I define the closure (`def cls = this.&printer`) I don't put the parentheses after the method name (`printer`)
2. When I call the closure I pass in the parameters

Say I set this up a little differently and create a `Test` class with two `printer` methods - one that takes a parameter and one that doesn't:


	class Test {
	    static printer(){
	        println 'Hello, world'
	    }
	    
	    static printer(name) {
	        println "Hello, $name"
	    }
	}
	
	def cls = Test.&printer
	cls()
	cls('Newman')


You'll see if you run that last example that the call to the closure (`cls`) will result in the associated method being called depending on the parameters I provide.

## Anonymous Functions

In the first examples of this chapter I used the Method Reference operator to point to an existing method that I had defined in a class. Closures can also be defined using anonymous functions. This lets us create a function at the point we define the variable.

In the next example I create an anonymous function using the regular block syntax (`{..}`) and store the function reference in `cls`:

```groovy
def cls = { println 'Hello, world' }
cls()
```

That's pretty nifty! We can define a function when needed and store it in a variable. This variable can then be passed to methods and other closures as a parameter.

## The 'it' parameter

Anonymous functions get a single parameter named `it` by default. That means that you can use `it` as a parameter inside your function and `it` will contain the parameter passed in the call to the closure.

Let's write a version of the `printer` method that takes a parameter:


	def cls = { println "Hello, $it" }
	cls('Jerry')


I> ## More Terminology
I> I'll use the terms "closures" and "anonymous functions" interchangeably. Whilst we know that there's a difference between the two we usually use anonymous functions with closures rather than via the Method Reference operator.
