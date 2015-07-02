# Creating a Class

I> Who doesn't want a classy application?

The basics of Objects was covered in Chapter 10 as part of the section on Variables and Data Types. 

* A class is defined using the `class` keyword: `class MyClass{}`
* Class names use camel case format in which the first letter in each word appears in upper case.
	* Don't use underscores as proxy spaces (e.g. `My_Class`)
* A new _instance_ of a class is created using the `new` keyword: `def fido = new Dog()`

In this chapter we'll delve more into the main class elements: properties, fields and methods.

## Access Modifiers
Classes are used to embody an abstraction of some real or virtual entity. You can probably guess what a `BankAccount` or a `EmailMessage` class embodies. In some cases we might be happy for other code to change a value held in a class instance or to run a method. However, in the case of a `BankAccount` class we are likely to need some sort of _information hiding_ that moderates what other code is allowed to do:

* The `balance` field shouldn't be directly accessible. Rather, two methods `deposit` and `withdrawal` have to be used.
* The `withdrawal` method should not allow you take take out more money than the current balance.

In Groovy we can implement the business logic just described through the use of _Access Modifiers_.

Access modifiers are keywords (`public`, `private`, `protected`) that determine if another class can use an element of a class (such as a property, field or method).

* `public` elements can be accessed by all other classes and code
* `private` elements are only accessible from within the class itself
* `protected` elements 

For our `BankAccount` class we can make the `deposit` field `private`

{title="A basic BankAccount with information hiding", lang=groovy}
	class BankAccount {
	
	    private balance = 0
	    
	    public withdrawal(amount) {
	        if (amount > balance) {
	            throw new Exception('Insufficient balance')
	        }
	        
	        balance -= amount
	    }
	    
	    public deposit(amount) {
	        balance += amount
	    }
	}
	
	def acct = new BankAccount()
	acct.deposit(100)
	acct.withdrawal(150)

In the example above I set the `balance` field to `private` and then provide two `public` methods to allow for other code to perform a `deposit` or a `withdrawal`. The latter method even throws an exception if you try to take out too much.

Now here's "the rub". Groovy doesn't actually enforce the access modifier. That means that, given my `BankAccount` class I could still write `acct.balance = 1_000_000` and access the field directly. A Python programmer might shrug at this and state that it's a matter of respecting the original programmer's intention. A Java programmer might be shocked that Groovy doesn't throw an exception or an error. I'm usually pretty happy with the Python approach but if it was really a concern I could add the following method to my `BankAccount` class:

	private setBalance(amount){}

Groovy generates setters and getters for fields (such as `balance`) and properties. In the case of the `balance` field, the setter method named `setBalance` is actually called when I do something like `acct.balance = 1_000_000`. Knowing this, I overrode the setter Groovy would have created with my own version that does nothing and I also used the `private` modifier. This does two things:

1. The `private` modifier reinforces that other developers should try to directly change the value of `balance`
2. If the other developers just don't listen then I ignore their attempt to change the `balance`.

Whilst my empty `setBalance` method helps prove a point, having to do that too often will reduce readability and annoy me with having to write lots of vacant code to protect my code from others who don't listen. Essentially I take the approach that developers are (usually) sensible people that understand what they're being asked not to fiddle with. If they fiddle then they can expect a weird outcome. So feel free to write a method with the signature `private doSomethingEvil()`, add some code that deletes all files and see who doesn't pay attention :) 

 W> ## Access modifiers are not security
W> Groovy and Java both support a technique called _reflection_ that allows programmers to programmatically examine other code (such as class definitions) and even change their behaviour. This means that even your Java code can be changed by another developer if they're using your code in their application. There are methods for preventing this[^securitymanager] but it's beyond the scope of this book.

[^securitymanager]: If you want to really get into this topic, start with <http://docs.oracle.com/javase/tutorial/essential/environment/security.html>

### Applying Access Modifiers
The following access methods are available:

* Classes: 
	* `public`
	* `protected`
* Fields
	* `public`
	* `private`
	* `protected`
* Methods
	* `public`
	* `private`
	* `protected`

I'd simplified things earlier when I said that _properties_ are sometimes also referred to as _fields_. The Groovy documentation discriminates between a _field_ and a _property_ and the difference really boils down to:

>*Fields* have an access modifier and *Properties* do not



## Properties and Fields




### Properties


{title="A basic person class with three properties",lang=groovy}
	class Person {
	    def name
	    def email
	    def mobile
	}


	def astrid = new Person()
	astrid.name = 'Astrid Smithson'
	astrid.email = 'astrid@example.com'
	astrid.mobile = '0418 111 222'

This type of class can be really handy when you just need a structure for storing and handing around data. Say for example you load a record from a database and want to feed it to other classes and their methods for processing. 





	def astrid = new Person(name: 'Astrid Smithson', email: 'astrid@example.com', mobile: '0418 111 222')

I 

	def astrid = new Person(name: 'Astrid Smithson', email: 'astrid@example.com')

If you try to use `println` to display the details for `astrid` you'll get something like `Person@46423706`. It's not very useful - just the type of the Object and an identifier. If you want to find out the field values, call the `dump` method that all objects inherit from `Object`:

	println astrid.dump()

{title="A basic person class with three typed properties",lang=groovy}
class Person {
    String name
    String email
    String mobile
}

### Fields


### Default values

Properties and fields are much like 

## Getters and Setters

	class Person {
	    def name
	    def email
	    def mobile
	}
	
	def jess = new Person()
	
	jess.setEmail('jess_at_example.com')
	
	println jess.dump()



	class Person {
	    def name
	    def email
	    def mobile
	    
	    def setEmail(email) throws IllegalArgumentException {
	        def regex = ~/[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+/
	        if (email.matches(regex)) {
	            this.email = email
	            return
	        }
	        throw new IllegalArgumentException('Incorrect email format')
	    }
	}
	
	def jess = new Person()
	
	jess.setEmail('jess@example.com')
	println jess.dump()
	
	//This will fail
	jess.setEmail('jess_at_example.com')
	println jess.dump()

## Methods

## Let Go of That Instance!

Sometimes your variable (e.g. a class instance) can end up holding a large amount of data. For example, you might have placed the text of the complete works of Shakespeare into a property. The JVM performs a process called _Garbage Collection_ so as to clean up data that you are no longer using. By assigning a variable to `null` we flag that the data previously held by the variable is no longer needed:

	myInstance = null

For small Groovy scripts this may never be an issue but, for long running applications, data hanging around and not being used can start to soak up a serious amount of resources, especially memory. Once you've finished with a variable it's worth assigning its value to `null` to let the JVM know you don't need it anymore. 

You don't always need to explicitly set variables to `null` - this would make your code far less readable. The JVM knows that once a variable is no longer in scope, it's no longer accessible and, thus, is no longer needed. This means that if you have a variable declared inside a method, that its value is no longer needed once the method has completed. The same goes for variables declared within scopes such as loops.

There is an important caveat however, if multiple variables refer to the same data then the JVM can only release resources once all references have "unlatched". Let's examine this in the code below:

{title="Example of multiple references to the same data", lang=groovy}
	class SampleText {
	    def text
	}
	
	def shakespeare = new SampleText(text: 'It was the best of times....')
	def marlow = shakespeare
	shakespeare = null
	println marlow.text

I've defined a variable (`shakespeare`) to hold a new instance of the `SampleText` class and then said that another variable (`marlow`) points to that instance of `SampleText`. My call to `marlow.text` will still work despite my setting `shakespeare` to `null`. In this case we say that "`marlow` still holds a reference to the `SampleText` instance". This means that the JVM can't release the resources held by the instance until all references are set to `null`. I need to set `marlow` to `null` to completely release the resources. 

T> ## Keeping track of references
T> Building up unused references to data is how a program will use up all of your system's memory and slowing everything to a crawl over time. When you have variables or collections of variables (such as lists) that you keep and add to over a long period of time you need to make sure you clean up what you don't need.

There's a lot more to garbage collection than I want to cover here but if you spend a few moments searching "Java Garbage Collection" you'll be able to delve deep into the topic.