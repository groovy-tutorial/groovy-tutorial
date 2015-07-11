# Properties and Fields

I> _What is your substance, whereof are you made?_ ([Sonnet 53](https://en.wikipedia.org/wiki/Sonnet_53))

In this chapter we'll delve more into properties and fields. They're *almost* the same thing and can be known as [member variables](https://en.wikipedia.org/wiki/Member_variable) as they hold data regarding the state of the object instance. In less technical terms, they describe a specific instance (e.g. *Jim*) of a class (*Person*).

## Properties


The class below is composed of three properties and could be used to pass a person's details through a system. You may come across references to this type of structure as "Groovy beans":

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

In the code above I create a new instance of the `Person` class by calling `new Person()` and can then access each property using dot-point notation. This type of class can be really handy when you just need a structure for storing and handing around data - say, for example, you load a record from a database and want to feed it to other classes and their methods for processing. 

T> ## `Person` is a type
T> I could have used `Person astrid = new Person()` 

Groovy provides a built-in approach to passing in property values when creating a new instance. The code below creates a new `Person` but sets the property values using (named arguments)[#chnamedarguments]:

	def astrid = new Person(name: 'Astrid Smithson', email: 'astrid@example.com', mobile: '0418 111 222')

We don't have to set all of the properties, just the ones we need:

	def astrid = new Person(name: 'Astrid Smithson', email: 'astrid@example.com')

T> ## This looks like a method call
T> You're absolutely correct - `new Person()` calls a special type of method called a constructor. We'll cover these in the next chapter: (Constructors)[#chconstructors]. For now, know that Groovy provides this method for you.

### Viewing an object's properties/fields
If you try to use `println` to display the details for `astrid` you'll get something like `Person@46423706`. It's not very useful - just the type of the Object and an identifier. If you want to find out the field values, call the `dump` method that all objects inherit from `Object`:

	println astrid.dump()

### Typed properties

Just as we saw [with variables](#chvariables_datatypes), properties can be defined with a specific data type, rather than with a dynamic type. The code below redefines the `Person` class with typed properties:

{title="A basic person class with three typed properties",lang=groovy}
class Person {
    String name
    String email
    String mobile
}

T> ## Use `def` _or_ a type, not both
T> Whilst `def String name` would work, the `def` is redundant and, by dropping it, you save four keystrokes for something more useful!

People often ask if they should just use `def` or assign an explicit type. My answer is pretty straight-forward: if you know how you'll use it and you'll only use it one way, give it a type. The `name` property is a good example  and I would use `String`. In other situations you may want to be flexible in what you can store so use `def`. 

## Fields

A _field_ is pretty much the same thing as a _property_ - it's a member variable - but there's a key difference: _fields_ are defined with an access modifier and _properties_ are not. An access modifier is used to indicate 

T> [Access modifiers](#chaccessmodifiers) are covered very soon in their own chapter.

In the code below I have rewritten the `Person` class using fields rather than properties:

{title="A basic person class with three fields",lang=groovy}
	class Person {
	    public name
	    private email
	    private mobile
	}

Firstly, you'll see that I haven't used the `def` keyword - I don't need to do this when I provide an access modifier. I could have declared `public def name` but it's not good style.

I> ## Properties become fields
I> Whilst you used `def name` for your property, Groovy actually creates a `private` field for you behind the scenes.

{title="A basic person class with three typed fields",lang=groovy}
	class Person {
	    public String name
	    private String email
	    private String mobile
	}

T> ##Use typed fields for larger programs
T> 

## Default values
Properties and fields are much like variables and can be declared with an initial value:

{title="A basic person class with three typed fields, each with an initial value",lang=groovy}
	class Person {
	    public String name = 'anonymous'
	    private String email = 'anon@example.com'
	    private String mobile = ''
	}

The initial value doesn't have to be a literal, it can be determined from an expression

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


## Constants



`groovy.lang.ReadOnlyPropertyException`


