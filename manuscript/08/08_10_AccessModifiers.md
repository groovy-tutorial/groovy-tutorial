# Access Modifiers {#chaccessmodifiers}
Classes are used to embody an abstraction of some real or virtual entity. You can probably guess what a `BankAccount` or a `EmailMessage` class embodies. In some cases we might be happy for other code to change a value held in a class instance or to run a method. However, in the case of a `BankAccount` class we are likely to need some sort of _information hiding_ that moderates what other code is allowed to do:

* The `balance` field shouldn't be directly accessible. Rather, two methods `deposit` and `withdrawal` have to be used.
* The `withdrawal` method should not allow you take take out more money than the current balance.

In Groovy we can implement the business logic just described through the use of _Access Modifiers_.

Access modifiers are keywords (`public`, `private`, `protected`) that determine if another class can use an element of a class (such as a property, field or method).

* `public` elements can be accessed by all other classes and code
* `private` elements are only accessible from within the class itself
* `protected` elements 

For our `BankAccount` class we can make the `deposit` field `private`:

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

Now here's "the rub". Groovy doesn't actually enforce the access modifier. That means that, given my `BankAccount` class I could still write `acct.balance = 1_000_000` and access the field directly. A Python programmer might shrug at this and state that it's a matter of respecting the original programmer's intention. A Java programmer might be shocked that Groovy doesn't throw an exception or an error. 

Q> ## What does the Groovy community think about this?
Q> One great thing about open source, community-oriented software projects (like Groovy) is that you can look into the discussions going on around topics such as language constructs. I think that the [Jira ticket](https://issues.apache.org/jira/browse/GROOVY-3010) (and its subtasks) relating to the visibility of private fields is a great insight into how people discuss their ideas and seek or decline changes.

I'm usually pretty happy with the Python approach but if it was really a concern I could add the following method to my `BankAccount` class:

	private setBalance(amount){}

Groovy generates setters and getters for fields (such as `balance`) and properties. In the case of the `balance` field, the setter method named `setBalance` is actually called when I do something like `acct.balance = 1_000_000`. Knowing this, I overrode the setter Groovy would have created with my own version that does nothing and I also used the `private` modifier. This does two things:

1. The `private` modifier reinforces that other developers should try to directly change the value of `balance`
2. If the other developers just don't listen then I ignore their attempt to change the `balance`.

Whilst my empty `setBalance` method helps prove a point, having to do that too often will reduce readability and annoy me with having to write lots of vacant code to protect my code from others who don't listen. Essentially I take the approach that developers are (usually) sensible people that understand what they're being asked not to fiddle with. If they fiddle then they can expect a weird outcome. So feel free to write a method with the signature `private doSomethingEvil()`, add some code that deletes all files and see who doesn't pay attention :) 

 W> ## Access modifiers are not security
W> Groovy and Java both support a technique called _reflection_ that allows programmers to programmatically examine other code (such as class definitions) and even change their behaviour. This means that even your Java code can be changed by another developer if they're using your code in their application. There are methods for preventing this[^securitymanager] but it's beyond the scope of this book.

[^securitymanager]: If you want to really get into this topic, start with <http://docs.oracle.com/javase/tutorial/essential/environment/security.html>

## Applying Access Modifiers
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

> *Fields* have an access modifier and *Properties* do not

