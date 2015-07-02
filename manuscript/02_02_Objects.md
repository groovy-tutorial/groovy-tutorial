# Objects

I> Groovy is an object-oriented programming language and it's essential to understand what this means if you're to really get to grips with coding in Groovy. 

But what is an object? Well, an object is an encapsulation of properties and methods:

* __Properties__ are variables that hold data about the object
	* For example, a person object may have properties such as:
		* `name`
		* `email`
	* Properties are sometimes referred to as _fields_.
* __Methods__ are a means for accessing and manipulating the object's properties
	* For example a person object may have methods such as:
		* `getName()`
		* `setName(name)`
	* Methods can take parameters and/or return values. For example:
		* `getName()` would return the person's name
		* `setName(name)` takes 1 parameter (`name`) and sets the person's name to that value
	* Methods are sometimes called _functions_

We use the `class` structure to define this assembly of properties and methods.

I> ## This is just an overview
I> We'll cover a lot more on Objects in a later tutorial as they're so central to Groovy. For now, this overview should help you get an understanding of how objects are used.

## Declaring and using a class

Let's look at a Groovy script that declares a new class:

{title="Declaring a new class",lang=groovy}
	class Person {
	    def name
	    def email
	    
	    def getName() {
	        return this.name
	    }
	    
	    def setName(name) {
	        this.name = name
	    }
	    
	    def getEmail() {
	        return this.email
	    }
	    
	    def setEmail(email) {
	        this.email = email
	    }
	}
	
	// Create a new variable to hold an instance of the Person class
	def david = new Person(name: 'David', email: 'david@example.com')
	
	// Change David's email address:
	david.setEmail('dave@example.com')
	
	// Print out David's information
	println david.getName()
	println david.getEmail()


A class is defined using the `class` keyword and it's best practice to using an uppercase letter for the first character: `class Person {`


T> ## Curly brackets
T> You'll note the `{` in the code. This is called a curly bracket (or brace) and is used to denote a block of code. Each `{` has a partner `}` and are called the opening and closing brackets respectively. The opening bracket after `class Person` tells Groovy that all of the code up to the closing bracket relates to our definition of the Person class. 

We declare the two properties in much the same way as we do for any variable:

{title="Properties",lang=groovy}
	def name
	def email


A number of methods are declared to let us set and retrieve (get) the values of the  object's properties:

{title="Methods",lang=groovy}
	def getName() {
	    return this.name
	}
	
	def setName(name) {
	    this.name = name
	}
	
	def getEmail() {
	    return this.email
	}
	
	def setEmail(email) {
	    this.email = email
	}

T> ## More curly brackets
T> Again you'll note the opening and closing brackets for each method, telling Groovy where the method definition opens and closes. As these are _nested_ within the brackets for the `class` we know the methods belong to the `class`

After we've declared the `Person` class we can now create instances of the class and assign values to the properties:

{title="Creating an instance",lang=groovy}
	def david = new Person(name: 'David', email: 'david@example.com')


We use `def david` as we would for other variables and then use `new Person` to indicated that `david` will hold an instance of the `Person` class. Lastly we call a special method called a _constructor_ that Groovy provides us for our objects: `(name: 'David', email: 'david@example.com')`. This sets up `david` with starting values for the properties.

I> ## Constructors
I> Constructors are basically methods but use the class name for the method name. They're also only called when you create a new instance.

At some point David changes his email address so we call the `setEmail` method:

	david.setEmail('dave@example.com')`. 

You can see that the method call uses dot-point notation of `<variable name>.<method name>` - the dot (`.`) separates the variable name (`david`) from the method (`setEmail`).

Lastly, we use the two `get` methods to display `david`'s information: 

{title="Calling methods",lang=groovy}
	println david.getName()
	println david.getEmail()


The example `Person` class has demonstrated a number of Groovy's object-oriented programming syntax:

1. Creating a new class with properties and methods
2. Creating a new instance of the class and calling its constructor
3. Changing (setting) and retrieving (getting) the instance's properties

You can create lots of `Person` instances and each will exist in their own context. This means that `david` and `sarah` don't get mixed up:

{title="Creating instances",lang=groovy}
	def david = new Person(name: 'David', email: 'david@example.com')
	def sarah = new Person(name: 'Sarah', email: 'sarah@example.com')


## Useful Methods

In the Groovy/Java family tree, `java.lang.Object` is the grand-daddy of all classes. Using a system called "inheritance", each new class inherits attributes such as methods and properties from their forebears. Even the `Person` class I described above inherits from `java.lang.Object` and the Groovy developers been enhanced that class further! This means that all classes have built-in features that we can access. Let's look at a few of them.

### `class`

The `class` property is used to access the Class that defines the object. This can be really useful when we want to check what sort of object we're dealing with.

{title="The class property",lang=groovy}
	class Person {
	    def name
	    def email
	}
	
	def david = new Person(name: 'David', email: 'david@example.com')
	
	println david.class.name


### `dump()`

This will return a String that describes the object instance's internals. Try out the following code to see what gets dumped:

{title="The dump method",lang=groovy}
	class Person {
	    def name
	    def email
	}
	
	def david = new Person(name: 'David', email: 'david@example.com')
	
	println david.dump()


### `with()`

This method works with closures (we'll cover them later) to give us an easy format for accessing a object's properties in methods. In the example below I wrap some code using `with` and don't have to use `david.name` and `david.email` to access those properties:

{title="The with method",lang=groovy}
	david.with {
	    println name
	    println email 
	}


## Existing classes

The great strength/benefit/bonus of object-oriented programming is the vast array of existing libraries of objects that you can reuse in your code. In Groovy and Java the listing of these available objects are referred to as the Application Programming Interface (API). 

If we were going to create a variable to hold a string (a piece of text) we would do something like:

{title="Creating a new String",lang=groovy}
	def quote = 'Well may we say "God save the Queen", because nothing will save the Governor-General!'


We could also use the following code to do exactly the same thing as the code above:

{title="Also creating a new String",lang=groovy}
	def quote = new String('Well may we say "God save the Queen", because nothing will save the Governor-General!')


This looks similar to the way we created an instance of the `Person` class - we create a new instance of `String` and pass the text into the constructor.

T> ## Usage
T> I prefer the first version as it's a lot easier to read but the example provided here lets you see that under Groovy's hood there's some helpful stuff going on to make your life easier.

Now that we have our `quote` string we actually also get a number of methods that help us handle our variable:

{title="Handy String methods",lang=groovy}
	//Display the quote in upper case letters
	println quote.toUpperCase()
	
	//Display the quote backwards
	println quote.reverse()
	
	//Display the number of characters in the quote
	println quote.size()


The example above demonstrates how we can call methods on an object instance and you'll see this used in the rest of the tutorials. Be sure to try out the code above to see what it does!

## Classes and literal values
Literal values are best thought of the value you would write down:

* Boolean:
	* true
	* false
* Numbers:
	* 42
	* 3.14
* Strings (text):
	* 'hi there'

>We use single- or double-quotes for string literals otherwise Groovy thinks the text is actually code and tries to interpret it.

We can call methods directly on literal values as Groovy will create an appropriate object instance for us:

{title="Calling a method from a literal",lang=groovy}
	assert 1.plus(1) == 2


This definitely looks a bit odd but think of it this way:

1. Groovy sees the literal value `1` followed by a method call
2. Groovy creates a number object instance for `1`
3. Groovy then calls the `plus` method against the new number instance

I> `1.plus(1)` also looks odd because we're used to seeing `1 + 1`. Both formats are supported but the latter is easier to read.

This can start to be very useful when you look at lists and ranges - something we'll get to soon. 

Lastly, as the literal is put into an object we can access methods and properties for the object. In the example below I can see what data type Groovy is actually using when I use 3.14:

{title="Accessing properties from a literal",lang=groovy}
	println 3.14.class.name







