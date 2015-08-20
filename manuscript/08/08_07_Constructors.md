# Constructors {#chconstructors}

I> Can we build it?

A constructor is a special type of method that is called when instantiating a new instance of a class. We create a new instance every time we use the `new` keyword:

{lang=groovy}
<<[A basic bean-type class](code/08/07/basic.groovy)

In the code above I define the `Person` class with three properties and then create a new instance in the `astrid` variable. The `new` keyword indicates to Groovy that a new `Person` instance is to be created. The `Person()` aspect is actually a call to the constructor for the class. However, I haven't actually provided a constructor for the `Person` class so what am I calling? Groovy classes all trace back to the `Object` class - where a class does not explicitly state that it inherits from (subclasses) another class it is automatically seen as a subclass of `Object`.

Groovy sees `Person()` and knows that the `Person` class doesn't provide a no-parameter (aka no-argument or no-args) constructor but `Object` does so that is called and it doesn't really do anything interesting. This whole arrangement means that your classes automatically have a no-argument constructor.

As always, Groovy adds a little extra on top and we've seen that we can use the map notation to assign values to member variables (properties/fields) when we create a new instance:

    def astrid = new Person([name: 'Astrid Smithson', email: 'astrid@example.com'])

You can see that `new Person` is being passed a map consisting of keys that relate to properties in the class. This means you can prepare the map elsewhere in your code and then pass it into the constructor:

    def details = [name: 'Astrid Smithson', email: 'astrid@example.com']
    def astrid = new Person(details)

Groovy gives us that little bit of syntactic sugar and lets us drop the square brackets (`[]`) in the call:

	def astrid = new Person(name: 'Astrid Smithson', email: 'astrid@example.com')

This looks like a built-in constructor that accepts a map (or map-like) syntax in which each of the keys match a name of a member variable. This is really useful for bean-type classes that we're using to keep data fields together. However, this isn't a true constructor as Groovy doesn't generate a `Person` constructor that takes a map as its parameter. Instead, the no-args constructor is called followed by the setters for each key in the map. This isn't usually a problem until you're [using `final` properties and fields](#chfinal).

W> Note that `def astrid = new Person name: 'Astrid Smithson', email: 'astrid@example.com'` won't work - you need the parentheses.

## Writing your own constructor(s)
Whilst the no-args constructor and map parameter approach can be useful, you'll probably need to define your own constructors at some point. This may be due to a few reasons, such as:

1. You need information when you create a new instance that is more than just the member variables - perhaps you need to calculate something
2. You don't want the caller to be able to populate a member variable - perhaps you'll load that from a database or perform a calculation to determine its value

If you need to do something specific in order to sensibly create a new instance of your class you'll need to define one or more constructors. So, let's look at an example:

{lang=groovy}
<<[A basic constructor for `Person`](code/08/07/basic_constructor.groovy)

In order to define a constructor we declare a method that:

1. Can have an access modifier ([discussed in a later chapter](#chaccessmodifiers))
2. Has no return value declared - none, not even `void`
2. Has the same name as the class in which it is defined - yes, it is case-sensitive
3. Can take 0 or more arguments

Now that you've supplied a constructor you'll lose the built-in "map constructor". Be warned that this isn't always obvious! If we create a new instance using named arguments, our `dump` will show us that `astrid`'s name becomes a list:

	def astrid = new Person(name: 'Astrid Smithson', email: 'astrid@example.com', mobile: '0418 111 222')
	println astrid.dump()

This will display: `<Person@45ceff52 name=[name:Astrid Smithson, email:astrid@example.com] email=null mobile=null>`. You should be able to see that the name property is just plain wrong.

By adding the `Person(name)` constructor we've effectively changed `Person` so that it has two constructors: the no-argument constructor and one that accepts the `Person`'s name. If the coder using our `Person` class wanted to add an email or mobile number they'd have to do that after instantiating the instance.

We can define as many constructors as we feel necessary - they all carry the same name as their class but have different parameter lists (à la overloading). In the code below I provide two constructor definitions:

{lang=groovy}
<<[A class with two constructor definitions](code/08/07/overloaded_constructor.groovy)

T> I can still call `new Person()` as the no-argument constructor is still there.

You can probably work out what most of the code above does - one constructor allows for just a `name` argument and the other allows for both a `name` and an `email`. But what is `this(name)` doing? First, remember that `this` is used to refer to the current instance. What I wanted to do from `Person(name, email)` was call `Person(name)` so as to set the name - perhaps I was going to put some more complex logic in around setting the name. In order to call the `Person(name)` constructor from another constructor I need to to refer to `this` so `this(name)` is a call to another constructor within the class. This is commonly referred to as "constructor chaining".

There is a specific rule we have to follow when constructor chaining - calls to other constructors must occur before any other statements.  That means the following constructor code won't compile:

	Person(name, email) {
        this.email = email
        this(name)
    }

T> Before you start writing lots of constructors to allow callers to pass in different numbers of parameters - called [telescoping constructors](https://en.wikipedia.org/wiki/Builder_pattern) - hang tight and we'll get to the `TupleConstructor` annotation shortly.

Before moving on, there's still that no-args constructor that we get even when we don't ask for it. Sometimes we actually want to force
other developers to use a constructor with arguments. For example the `Person(Integer id)` might use the `id` parameter to load the
Person's details from a file/database. In this case the no-args constructor could leave us with some sort of zombie person instance
with no information. One approach to avoiding this is to [prepend the `private` modifier](#chaccessmodifiers) to indicate
that other coders shouldn't use it:

    private Person() {}

If you want to be really forceful, just throw an exception if someone tries their luck:

    private Person() {
        throw new IllegalArgumentException('Do not use the no-arg constructor')
    }

### Lists

Good old Groovy never stops giving us different ways to do things and, in the code below, we can cast a list of values into
a `Person`:

<<[That list constructs!](code/08/07/constructor_list.groovy)

For `astrid` I cast the three item list explicitly using `as Person` because I didn't supply a type when decalaring the
variable (`def astrid`). Groovy takes my 3 items, sees that there is a three-argument constructor, and passes it through.
In the case of `gretchen` I don't need the explicit cast as I declared a type with the variable (`Person gretchen`). The
list has 2 items so the two-argument constructor is called.

T> I could have been groovier and declared one constructor, with `mobile` given a default value, and got the same result:
T>
T> {lang="groovy"}
T> ~~~~~~~~~~~~~~~
T>  Person(name, email, mobile = '') {
T>      this.name = name
T>      this.email = email
T>      this.mobile = mobile
T>  }
T> ~~~~~~~~~~~~~~~

There's two really interesting things to keep in mind with this:

1. The constructor is being called (unlike with the "map constructor")
2. This will work with all the various Groovy and Java classes

On that last point, let's look at two quick examples to prove I'm not fooling you:

    //Prepare a calendar using YYYY, MM, DD
    def calendar = [2015, 01, 31] as GregorianCalendar

    //Setup a URL
    java.net.URL url = ['http', 'www.example.com', 80, '/index.html']


## TupleConstructor annotation
The [`@groovy.transform.TupleConstructor`](http://docs.groovy-lang.org/latest/html/gapi/groovy/transform/TupleConstructor.html) is an annotation that we can add to our classes and have a variety of constructors automatically generated for us:

{lang=groovy}
<<[The `TupleConstructor` annotation](code/08/07/tuple_constructor.groovy)

The `TupleConstructor` annotation gives us the map-based constructor as well as a set of constructors matching the member variables - effectively generating the following constructors:

- `Person(name)`
- `Person(name, email)`
- `Person(name, email, mobile)`

You can see where the "telescoping" notion comes from - each constructor adds a parameter over the last.

You can configure the annotation to include and exclude specific fields so, when you're wanting to give it a spin in your own code, check out [`@groovy.transform.TupleConstructor`](http://docs.groovy-lang.org/latest/html/gapi/groovy/transform/TupleConstructor.html).

## Instance initializer blocks

A stand-alone instance initializer block can be used to provide a base setup for a new instance. This is useful if you need a block of code in order to set default/original values for one or more member variables.

Instance initializer blocks appear inside the class itself, surrounded by curly braces `{}`:

{lang=groovy}
<<[A basic class with an initializer block](code/08/07/instance_initializer.groovy)

The code above offers nothing over setting the property defaults directly (`UUID id = UUID.randomUUID()`) - it's just a simple example. You can use an initializer block or constructors, or both. The initializer block will be called before any constructor(s).

T> Whilst you can actually provide several initializer blocks, you probably just need to use one - it makes your code a lot easier to follow.

There is a small trap to be wary of when using an instance initializer block - the syntax Groovy uses for passing closures as parameters will cause a failure around initializer blocks in some conditions. The following code is an example of this and won't run:

{lang=groovy}
<<[An initializer block that gets mistaken as a closure](code/08/07/instance_initializer_fail.groovy)

In order to get around this, prefix the initializer block with a semicolon (`;`)[^initprefix]. This stamps a definite statement delimiter against the initializer block:

{lang=groovy}
<<[A prefixed initializer block](code/08/07/instance_initializer_win.groovy)

I'd suggest always using the prefix - it isn't messy and makes sure that Groovy knows it's looking at an initializer block.

[^initprefix]: Thanks to Jochen "blackdrag" Theodorou for [his guidance on this](http://mail-archives.apache.org/mod_mbox/incubator-groovy-users/201507.mbox/%3c55A0B6F1.8050007@gmx.org%3e)

## When and How Things Happen
It can be frustrating when you've written a nice looking class but things don't happen in the manner you intended.
This can be due to the stuff going on behind the scenes that isn't always immediately obvious.
Let's take a look at a `Person` object that uses an initializer block and a constructor as well as provide a field setter and a helper method:

{lang=groovy}
<<[Investigate the order of things](code/08/07/ordering.groovy)

Running the code above will yield the following output:

    Initialised default name to Anonymous
    Constructor called with name: Fred
    After instantiation, name is: Fred
    setName called. Name is now: Freda
    changeName called. Name is now: Frederique

From that output we can piece together a basic set of rules that helps us see how things happen:

1. The initialiser block is called before the constructor
2. Setting a field within object methods (e.g. with `this.name = name`) performs a direct change of the field
3. Setting a field externally (e.g. with `fred.name = 'Freda'`) causes the setter (`setName`) to be called

## Constructors and instance methods
In the last code example I set the `name` field directly in the constructor. When looking at the code you may wonder if it isn't better to have the constructor call the setter (`setName`) so that I can place any logic around setting the field in a single method. Be careful with this as a more complicated setter may call on other instance fields that have not yet been initialised. Normally, the constructor code is self-contained and would only call other constructors or static methods (we'll look at these shortly).

However, the `changeName ` method may have been best to use `setName` rather than changing the field directly. This would allow me to centralise any associated logic.

If you do need to provide some checks or other logic before allowing a field to be set then it might be worth placing this logic in another (private) method that doesn't change any instance fields directly. To achieve this, the method's parameters would cover all of the required items for validation (e.g. `private String checkName(name, validNameList)`) and return the name (if valid) or throw an exception if the check fails. The code might look something like:

{lang=groovy}
	private String checkName(name, validNameList) throws IllegalArgumentException {
        if (name in validNameList) {
            return name
        } else {
            throw new IllegalArgumentException('The name is not in the list of valid names')
        }
    }
