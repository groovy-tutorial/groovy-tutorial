# Packages

I> Groovy lets you take advantage of the core Java packages (the JDK) so let's take a quick look at how this works.

Except for very small programs, most Groovy and Java-based programs are made up of packages of code:

- The `package` keyword is used to designate that a class is part of a package and we'll cover this more fully in the tutorial on object-oriented Groovy.
- The `import` keyword is used to import classes from other packages into a program. 

Consider the sample code below:

{title="Using imports", lang=groovy}
	package test
	
	import java.time.Year
	
	println Year.now()

I've indicated that this code:

- Is part of a `package` named `test`
- Needs to use the `Year` class defined in the `java.time` package

This notion of packaging allows for thousands of developers to create classes and packages without clashing. If another developer creates a `Year` class but put it into a package with a name other than `java.time` then all will be well. Oh, and you'd never start your own package name with `java.` - that really won't work out well for you[^pkg].

Before you write any new code you should always check out these resources in the order I've given below:

1. The [Groovy API (GAPI)](http://docs.groovy-lang.org/docs/groovy-2.4.0/html/gapi/)
2. The [Groovy extensions to the JDK (GDK)](http://docs.groovy-lang.org/docs/groovy-2.4.0/html/groovy-jdk/)
2. The [standard Java classes (JDK)](http://docs.oracle.com/javase/8/docs/api/index.html)

Using the order I've provided above lets you look at the libraries providing the Groovy approach first (the GAPI and GDK) then looking at the Java standard library (JDK).

For the rest of this chapter I'll focus on `import` as that will help us in the early set of tutorials.

[^pkg]: There's actually a [package naming convention](http://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html) that is very easy to follow.

## Using `import`

You can `import` other classes in a variety of manners - let's take a look.

### Basic Imports
The basic form of imports are the most commonly seen and you should get accustomed to them pretty quickly.

`import java.time.Year`
:	This will import the `Year` class from the `java.time` package

`import java.time.*`
:	This is a star (wildcard) import
:	This will import all classes in the `java.time` package

### Static imports

Static imports can help your code look a little cleaner as they give you an easy way to refer to useful constants and functions (methods) declared in other code packages.
 
`import static java.lang.Math.PI`
:	This is a _static_ import
:	This lets you import static items from another class 
:	In this example I've imported the `PI` constant from the `java.lang.Math` class and can now use it as if it was just part of my code: `println PI`

`import static java.lang.Math.PI as pi`
:	This is a _static_ import with _aliasing_
:	This is the same as the previous `import` but I can use the `as` keyword to rename the item being imported - I've decided to use `PI` but refer to it using the lowercase form (`pi`)

`import static java.util.UUID.randomUUID as generateId`
:	This is also a _static_ import with _aliasing_ but I've imported the `randomUUID` static method and given in the alias `generateId`
: 	I can now call `println generateId()` in my program

`import static java.lang.Math.*`
:	This is a _static star_ import and will import all static elements described in `Math` and let me refer to them directly in my program.

I've thrown the term `static` around a lot here - don't worry too much about this for now as we'll really only need basic imports for now. The notion of `static` will be covered when we get to object-oriented Groovy.

## Built in Libraries

The following libraries are imported into Groovy by default - you don't need to do anything to start using them:

- `java.io.*`
- `java.lang.*`
- `java.math.BigDecimal`
- `java.math.BigInteger`
- `java.net.*`
- `java.util.*`
- `groovy.lang.*`
- `groovy.util.*`

Groovy is able to make use of classes within these packages without explicitly `import`ing them. You can still declare them with `import` and you'll notice various development environments (IDEs) will do this regardless of Groovy's default - either way it'll be groovy.

## Useful third-party libraries
There is an extensive body of existing Java libraries available to the Groovy developer and it's best to do some investigating before you write your own code - re-using well-supported libraries is a real time saver - here's a couple to take a look at:

1. [Apache Commons](http://commons.apache.org/)
1. [Google Guava](https://code.google.com/p/guava-libraries/)

In the olden days (in Java-time) you'd often have to download the third-party library you wanted, download any other libraries it depended on, store them in the correct place (called a Classpath) and then you could start using it. Time went by and systems such as [Apache Maven](http://maven.apache.org) came along to make it easier to grab a copy of your dependencies. This then lead to [The (Maven) Central Repository](http://search.maven.org) and made it even easier to grab the libraries you needed. 

T> ## Other repositories
T> There are other repositories you can use too - you'll likely come across these as you write more code and seek out new dependencies.

## Grape
Whilst you can use Maven or (even better) [Gradle](http://gradle.org) to grab these dependencies, Groovy includes a dependency manager called [Grape](http://groovy-lang.org/grape.html) that you can start using straight away.

Say I wanted to grab a copy of my favourite web page and had worked out that [Apache's HTTP Components](https://hc.apache.org/index.html) would really help me. I can search the Maven Central Repository and [find what I need](http://search.maven.org/#artifactdetails%7Corg.apache.httpcomponents%7Chttpclient%7C4.3.6%7Cjar). In fact, that web page even tells me how to use the library with Grape:

{title="Grape example",lang=groovy}
	@Grapes( 
	@Grab(group='org.apache.httpcomponents', module='httpcomponents-client', version='4.4') 
	)

I> Searching the repository can be a little frustrating at first but you'll get the hang of it over time.

Grape uses annotations - essentially the "at" (`@`) sign followed by a name - to do its thing. In the example above:

- `@Grapes` starts of the grape listing
	- You need this if you're grabbing several libraries in the same segment (node) of your code - we can actually ignore this in smaller examples.
- Each grape is declared using `@Grab` and providing the following:
	- The `group` that holds the module
	- The name of the `module`
	- The required version of the `module`

In the code below I use the Apache HTTP Components library to report on the HTTP status line from my request to "http://www.example.org". I've trimmed off the `@Grapes` as I just need to `Grab` one module:

{title="Using Grape",lang=groovy}
	@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.3.6')  
	import org.apache.http.impl.client.HttpClients
	import org.apache.http.client.methods.HttpGet
	
	def httpclient = HttpClients.createDefault()
	def httpGet = new HttpGet('http://www.example.org')
	def response = httpclient.execute(httpGet)
	
	println response.getStatusLine()


T> ## Where to grab
T> I like to put my `@Grabs` on the line above the `import` that include the dependency - it helps other see where my libraries are coming from.

You can use a short-form version of `@Grab` using the format `<group>:<module>:<version>` - this would let us use the following:

{title="Short-form grape",lang=groovy}
	@Grab('org.apache.httpcomponents:httpclient:4.3.6')

Once you start building more complex programs you will probably turn to Gradle but Grape works just fine for these tutorials.