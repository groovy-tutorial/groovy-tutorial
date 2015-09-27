# Object Operators {#chobjectoperators}

I> These operators help you check classes and instances.

It could be argued that all operators are object operators as nearly every variable or value in Groovy is an object. However, these operators are all about working with and checking on the object's structure.

{title="Object operators"}
|Operator(s)     |Type
|:------------------:|:--------------------|
| `?.`	| Safe Navigation Operator|
| `as`	| Casting Operator	|
| `is`	| Identity Operator	|
| `instanceof` `in`	| Type Comparisons	|
| `.@`	| Field Operator	|
| `.&`	| Method Reference	|


## Safe Navigation Operator

The Safe Navigation operator (`?.`) checks to make sure that a variable isn't `null` before calling the requested method. Consider the following code:

{title="Hitting a null",lang=Java}
	class Person{
	    def name
	}

	def fred = new Person(name: 'Fred')

	//various statements
	fred = null
	//various statements

	println fred.name


As `fred` somehow became `null` at some point in the code, that call to `fred.name` causes a nasty `java.lang.NullPointerException` (aka the NPE). This happens a lot as variables (in this case `fred`) can end up being `null` for a number of reasons, including:

- The variable never gets set in the first place - perhaps the initialisation failed but we didn't catch it properly
- A method returns `null` instead of an object instance
- We get passed a parameter that has `null` value.

In order to stop the NPE you'll normally see developers using an `if` statement to check that the variable isn't `null` before trying to call a method:

{title="Checking for null",lang=Java}
	class Person{
	    def name
	}

	def fred = new Person(name: 'Fred')

	//various statements
	fred = null
	//various statements

	if (fred) {
	    println fred.name
	}


T>In the code above, `if (fred)` equates to true if `fred` isn't null - it's a handy bit of Groovy syntax we'll cover when we get to the [tutorial on the `if` statement](#chif).

Groovy's Safe Navigation operator saves some time and code. In the code below, Groovy checks that the `fred` variable isn't `null`  before trying to access the `name` property - giving us a compact piece of code: `fred?.name`.

{title="Safe navigation",lang=Java}
	class Person{
	    def name
	}

	def fred = new Person(name: 'Fred')

	//various statements
	fred = null
	//various statements

	println fred?.name


You'll see that "null" is displayed - this is because `fred` is `null`. Groovy doesn't even try to access the `name` property.

## Casting Operator

The Casting operator (`as`) changes the data type of a value or variable to the specified class. This is sometimes called "casting", "type conversion" or "coercing". You'll have seen this in action when we created a Set:


	def nums = [1, 6, 3, 9, 3] as Set


I> For those that like to know the secret sauce, this actually casts `num` to be a `java.util.LinkedHashSet`. I know this because `nums.class.name` knows this.

The `as` tells Groovy that you want to convert the item to be of the specified data type (class) - in the example above I use `Set`. The code below demonstrates a few more conversions:


	assert 3.14 as Integer == 3
	assert 101 as String == '101'
	assert true as String == 'true'
	assert '987' as Integer == 987


You'll note that the cast can be lossy - `3.14 as Integer` caused the value to be truncated to `3`. Not all values can be cast to all types and code such as `'hello, world' as Integer` causes an exception.

## Identity Operator

The Identity operator (`is`) determines if two variables are referencing the same object instance. This "operator" is really a method that you call by using `obj1.is(obj2)` to check if `obj1` and `obj2` reference the same instance.

As we saw in the chapters on Equality Operators and Relational Operators, Groovy uses the `==` operator to determine if two objects are equivalent based on their state. Using `==` for this purpose is really useful and improves code readability *but* it means that the traditional Java use of `==` to determine if two objects reference the same instance needs a replacement in Groovy. The `is` method is that replacement.

In the code below I describe a `Person` class and use a very helpful annotation (`@groovy.\-transform.\-EqualsAndHashCode`) so that Groovy sets up the approach to determining if two instances of `Person` are the same - such that `==` returns `true`. I've decided that all people will have a unique identifier and, provided two instances have the same identifier, they're the same person. This means that all three variations (`fred`, `freddie`, `frederick`) of the person with the ID `345` are equal (`==`) to each other. However, by using `is` I can see that, whilst `fred` and `freddie` point to the same instance of Person, `frederick` points to a different instance.

{title="Can I see some identification?",lang=Java}
	@groovy.transform.EqualsAndHashCode(includes="id")
	class Person{
	    def id
	    def name
	}

	def fred = new Person(id: 345, name: 'Fred')
	def freddie = fred
	def frederick = new Person(id: 345, name: 'Frederick')

	//Check that they're all the same person
	assert fred == freddie
	assert fred == frederick
	assert freddie == frederick

	//Check which variable points to the same instance
	assert fred.is(freddie)
	assert ! fred.is(frederick)


## Type Comparison

The Type Comparison operators (`instanceof` and `in`) is used to determine if a variable is an instance of the specified class.

In this next example I check to make sure that `fred` is a `Person`:

{title="Type comparison",lang=Java}
	class Person{
	    def name
	}

	def fred = new Person(name: 'Fred')

	assert fred instanceof Person
	assert fred in Person


Checking the variable's type can be useful in dynamically typed languages such as Groovy as it lets us check before we call a property or method that may not be there:


	class Person{
	    def name
	}

	def fred = new Person(name: 'Fred')

	if (fred instanceof Person) {
	    println fred?.name
	}


In my `Person` example I'm not really using the full benefits of object-oriented programming that we can leverage in Groovy - primarily because we're yet to get up to that. However, trust me when I say that class hierarchies and interfaces give us a handy way to build up a family tree of classes and that we can use `instanceof` or `in` to check if the object instance has a legacy that helps us achieve an outcome. For example, the `Integer` and `Float` classes are a subclass (child) of the `Number` class.

I> ## Meanwhile, under the sea
I>It's a bit like the [Linnaean taxonomy](http://en.wikipedia.org/wiki/Linnaean_taxonomy): `assert octopus instanceof Mollusc` and `slug instanceof Mollusc`. Check out the [Encyclopedia of Life](http://eol.org/pages/2195/overview) to learn more about molluscs - those little guys are really cool.

In the example below I set up an `add` method that adds two numbers (handy!). Before I try to add those two numbers I use `in` to make sure they're actually Numbers. If they aren't, I throw an exception at you.


	def add(num1, num2) {
	    if (num1 in Number && num2 in Number) {
	        return num1 + num2
	    }
	    throw new IllegalArgumentException('Parameters must be Numbers')
	}

	assert add(1, 6) == 7
	assert add(3.14, 9.2) == 12.34

	add('Rabbit', 'Flower')


T>Granted, I could have declared `def add(Number num1, Number num2)` but that wouldn't be very dynamic of me.

## Field Operator and Method Reference

I> I won't discuss these two operators to any depth at this point.

The Field operator (`.@`) provides direct access to an object's property (field) rather than using a getter/setter. _Use with a lot of caution or, even better, don't use it at all._

The Method Reference operator (`.&`) returns a reference to an object method. This can be handy when you'd like to use the method as a closure. This is a very useful feature so use it at will!

In the example below I describe the `Person` class. When I then create an instance called `example` you'll notice that:

- `example.name = 'Fred'` causes `setName()` to be called
- `println example.name` causes `getName()` to be called
- `example.@name = 'Jane'` and `println example.@name` both access the `name` property directly.
- `def intro = example.&introduceSelf` sets `intro` as a pointer (closure) to the `introduceSelf` method.
	- Which is then called using `intro()`

{title="Field operators and method references",lang=Java}
	class Person {
	    def name

	    def setName(name) {
	        println 'You called setName()'
	        this.name = name
	    }

	    def getName() {
	        println 'You called getName()'
	        return this.name
	    }

	    def introduceSelf() {
	        println "Hi, my name is ${this.name}"
	    }
	}

	def example = new Person()

	//example.name actually calls the getter or setter
	example.name = 'Fred'
	println example.name

	//example.@name directly access the field
	example.@name = 'Jane'
	println example.@name

	//intro holds the reference to the introduceSelf method
	def intro = example.&introduceSelf

	//This next line calls introduceSelf()
	intro()



