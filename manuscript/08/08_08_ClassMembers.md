# Class Methods and Variables {#chclassmethods}

In the preceding chapters we looked at _instance_ properties/fields (variables) and _instance_ methods (including constructors) -
 the components of a class that pertain to individual instantiations of the class. This ensures that each instance
 works against its own state and doesn't interfere with other instances. There are many times, however, when we want a class to
 provide a method that isn't bound to an instance or when we want a field/property that is used across instances. This is
 where _class methods_ and _class variables_ are utilised.

Declaring a field/property  or method as static is easy: you just prepend the `static` modifier. Lets look at an example:

{lang=groovy}
<<[A brief example of class methods and variables](code/08/08/static.groovy)

The code above provides a common use of static variables as it reads in configuration from a source and makes that
configuration available to the rest of the system. In this case I have chosen to use [JSON](https://en.wikipedia.org/wiki/JSON)
notation to store the configuration and the file `config.json` appears thus:

{lang=json}
<<[config.json](code/08/08/config.json)

In the `Configuration` class you can see three class variables: `databaseName`, `databasePassword` and `logFile`. These
are accessed via the class, and not an instance, by using the `<class name>.<variable name>` form: `Configuration.databaseName`.
I've also defined the class method `loadConfig` and this is accessed through `Configuration.loadConfig`. You'll see that
I don't have to instantiate `Configuration` by calling `new` nor do I assign `Configuration` to a variable - I just access
 `Configurations`'s class members when I need them.

W> Be mindful here that this is an example and I haven't protected these class variables in any way[^access] so code
W> external to the class could modify them by calls such as `Configuration.databaseName = 'FakeDatabase'`.

[^access]: More on this in [Access Modifiers](#chaccessmodifiers)

I've used the `String` type for the static variables in `Configuration` but, should I want to use dynamic types, I just
use `static <varName>` and don't need `def`:

    static databaseName = ''
    static databasePassword = ''
    static logFile = ''

Whilst the `Configuration` class only defines class methods and variables, classes can have a mix of these elements. The
next example is more complex:

{lang=groovy}
<<[A mix of static and instance elements](code/08/08/static_creditcard.groovy)

_Running this code will cause an error to be displayed but don't panic - it's just saying that I haven't provided a
 configuration for the Java money classes. It's all cool and fine for this example._

In the code above I have described a credit card account - the `SilverCreditCard`. This class uses class
variables to describe the policy for the credit card product (bank speak) and class methods for accessing
individual accounts (after all, you don't want people to just `new CreditCard` do you?):

* Class variables:
    * `currency` is the currency used by all Silver Credit Cards
    * `creditLimit` is the maximum limit allowed for this type of account
* Class methods:
    * `applyForAccount` is for new customers requesting an account - it would return an instance of `SilverCreditCard` being the newly created account
    * `loadAccount` is for existing customers wanting to access their account - it would return an instance of `SilverCreditCard` with information loaded from a database

The instance elements represent a single customer's SilverCreditCard account and aid in tracking their account:

* Instance properties:
    * `cardNumber` is the unique number for the account
    * `cardHolderName` is the name of the card holder
    * `balance` is how much they've spent on their credit card
* Instance methods:
    * `deposit` and `withdrawal` would let the person use their account

T> ## Money talks
T> You'll also note that in that last example that I've thrown in some usage of the
[Java Money library](http://javamoney.github.io/) - something worth looking into.

## Static initializer blocks

Classes don't have a constructor-style approach that you can use to prepare the class variables for use.
However, there is a static form of the instance intializer block:

{lang=groovy}
<<[A static initializer](code/08/08/static_init.groovy)

You'll see that I've just moved the earlier `loadConfig` class method into a static initializer block (`static { }`).
This is probably a good idea as the initializer block is acted on before the class variables are accessed,
allowing me to make sure that the configuration is ready to go rather than relying on other developers to call `loadConfig`.
Additionally, the initializer block will only be called once so the config file is only read once
 - much more efficient than if `loadConfig` is called over and over by other code.

## When to use class methods

A single property is best shared across all instances
: This is often the case with configuration properties

%%The method isn't really specific to an instance
%%: The method

The class is really just a library of methods
: Sometimes you just need a set of utility methods

It's important to note a few things about class methods:

* They can't access `this` as there's no underlying instance
* They can't use instance (member) variables
