---
title:	The Throwable Family
status:	draft
description:	Exceptions and Errors are just objects that can bring your program to a rapid halt.
...

Groovy takes on Java's approach to raising, handling and reporting errors and exceptions:

- **Errors** are serious problems that usually cause an application to halt ("crash"). In most cases you won't handle these - they'll happen and the program will fall over.
- **Exceptions** are less serious and applications, with good exception handling set up, may be able to keep going. 

At the heart of this model is the `java.lang.Throwable`[^throw] class. Exceptions and Errors are are two sides to the `Throwable` family tree:

- `java.lang.Exception` is the superclass (parent) of all exceptions
- `java.lang.Error` is the superclass (parent) of all errors

When writing Groovy applications you're likely to interact with exceptions in the following ways:

- Catching exceptions (using `try-catch`) thrown by various classes, be they written by you, part of the Java/Groovy libraries or from a third-party. 
- Throwing your own exceptions using (`throw`) to signal that something's gone wrong in your code.
- Being surprised and frustrated when exceptions "just happen"

Your goal should be to use defensive coding and testing that seeks to handle what you think is necessary but be prepared for issues to arise and use facilities such as logging to help you determine the root-cause.





[^throw]: Check out the [JavaDoc for Throwable](http://docs.oracle.com/javase/8/docs/api/index.html)



