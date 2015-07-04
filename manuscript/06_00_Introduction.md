-# Methods

#Introduction

I> Methods help us break code into logical and reusable segments. 

Methods (sometimes also called functions) are blocks of code that can be run more than once and encapsulate a segment of logic. We define a method by writing the code that will be run when the method is called. _Calling_ a method is the process of your code asking the method to start.

Groovy, like Java, is object-oriented and works around classes. C and Pascal are procedural and work around functions. Whilst the methods described here may look a bit like C-style programming that lets you build libraries of functions, what is really happening is Groovy wraps your code in a `class` definition behind the scenes. You're only likely to create "raw" methods, like the ones below, as a means to break up your scripts. More usually you'll create methods within your classes.

Methods have a number of features:

1. Methods have names
	- this allows you to call your method in a meaningful way
2. Methods can accept parameters
	- these are inputs into your method that can affect how your method operates
3. Methods can return a result value 
	- this can be captured by a variable from the code calling the method
4. Methods have their own scope
	- they can have their own variables and not inadvertently affect the rest of your program

We've already looked at various methods for use with variables such as lists and maps so you've seen methods being called throughout the previous chapters.
