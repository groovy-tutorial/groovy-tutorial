# Creating a Class

I> Who doesn't want a classy application?

The basics of Objects was covered [as part of the section on Variables and Data Types](#chobjects). Let's refresh:

* A class is defined using the `class` keyword: `class MyClass{}`
* Class names use camel case format in which the first letter in each word appears in upper case.
	* Don't use underscores as proxy spaces (e.g. `My_Class`)
* A new _instance_ of a class is created using the `new` keyword: `def fido = new Dog()`

In this chapter we'll delve more into the main class elements: properties, fields and methods.

## Properties and Fields


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

