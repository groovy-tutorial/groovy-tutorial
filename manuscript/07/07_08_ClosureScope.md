# Closure scope

I> Closures can call into the context from which they were created.

In the first chapter on closures I mentioned that: Closures represent a reference to a function (method) that is accompanied by a referencing environment. Up to now we've mainly used closures as methods that can be referenced by variables or passed as parameters. Methods declared in classes can access the fields in their class and closures can also access items such as variables available in the context from which they were created.

I've tried to demonstrate this concept in the example below. You'll notice that my basic closure refers to a variable `code` that isn't a declared parameter of the closure nor is it a variable declared within the closure. Rather, `code` references a variable available within the scope in which the closure is declared - i.e. `code` can be accessed by the `doubleCross` closure as both are declared in the same block.

{lang=Java}
<<[A small example of context](code/07/08/context.groovy)

## A More Involved Example

My `doubleCross` was quite basic and perhaps makes the usefulness of this concept appear to be ho-hum. In fact, it's extremely useful and opens the door to techniques such as Domain Specific Languages - something for you to research later. For now, I'll take you through a step-by-step example of a more complex use of closure context.

First of all I'll create a very basic class to describe an address book Contact. For each contact I'll record their name and phone number. I'll also define a closure named `call` and this is a simple function that I can use when calling the contact.

	class Contact {
	    def name
	    def phone

	    final call = { message ->
	        println "Calling ${this.name} on ${this.phone} with the message: '$message'"
	    }
	}

I> ## Final?
I> You may notice the `final` I used in the `call` definition. This keyword lets me set `call` to being a constant - it can't be changed after it's been defined

Once I've defined the `Contact` class I'll create a couple of contacts - Andrew and Sally.

	def andrew = new Contact(name: 'Andrew', phone: '+61 432 321 736')
	def sally = new Contact(name: 'Sally', phone: '+61 400 800 900')

I'll then create a list of Contacts I need to call back (perhaps my mobile phone battery died) and add Andrew and Sally. You'll note that I don't add the Contact instances to the call-back list, I actually add the closure for each contact. Think of this as the statement "I'll add to the list the activity of calling the contact".

	def needToCallBack = []
	needToCallBack << andrew.call
	needToCallBack << sally.call

Imagine that a whole lot of other code now "does stuff" and eventually we discard the `andrew` and `sally` variables:

	andrew = null
	sally = null

Now this is where it gets interesting. What if my mobile battery is now recharged and I want to start calling people back? Surely the fact that I blew away my `andrew` and `sally` variables would make this impossible? Well, remember how my `needToCallBack` list contains references to the `call` closures? These closures actually hang on to their original context - the `andrew` and `sally` instances.

All of this means that I can now use the `each` method on `needToCallBack` and I can realise those closures:

	needToCallBack.each { it('It\'s Duncan here, sorry I missed your call') }

This will now cause each of the `call` closures to be called - allowing me to get back in touch with `andrew` and `sally`.

I broke up the code in the discussion so present it all here in full for you copy and try out for yourself:

{lang=Java}
<<[The complete Groovy message service](code/07/08/scope.groovy)
