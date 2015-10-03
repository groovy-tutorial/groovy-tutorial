# The `assert` statement

I> The "assert" statement is handy for checking if we have the correct result or if there was a problem in our code.

The `assert` statement is perhaps out of order being described here but it will be relied on in many code examples.

T> ## Equality and inequality
T> Two operators are used in the examples below: `==` (two equals signs) is the equality operator and `!=` is the inequality operator. Both are discussed later.

The `assert` statement evaluates a boolean expression (one that is `true` or `false`). If the result is `false` then the assertion has failed, the program is halted and an error is reported. The following example provides an obviously incorrect statement:

{title="Basic assert",lang=Java}
	assert 1 == 2


An expression can be appended to the `assert` statement after a colon (`:`):

{title="Assert with expression",lang=Java}
	assert true == false : 'true cannot be false'


The second expression can be anything Groovy can evaluate and the result is used in the error message. The following example will (unhelpfully) place the number "8.0" in the error message:

{title="Assert with expression",lang=Java}
	assert true == false : Math.sqrt(64)

## Handling failed assertions
For the purposes of our tutorial scripts, using asserts is a handy way to demonstrate a result for a problem. However, it's not good practice to have a program suddenly just quit when an assertion fails. When you start writing large programs, your code should aim to "fail gracefully" unless it's really in a position where bailing out is the only option.

Groovy (unlike Java) does not provide a mechanism for turning off assertions so be careful about where you use the `assert` statement in larger systems. Remember that a failed `assert` raises an `Error` (which signals a critical problem) rather than an `Exception` (from which a program is more likely to recover). Arguably, in running (production) systems, assertions are best suited to dark places in code that should never be reached - they flag when the extremely unlikely condition has happened.

The error raised by a failed assertion can be caught within a `try-catch` and handled but this isn't how errors are usually treated (we normally just let them happen). The following example illustrates a class handling a failed assertion by logging the problem - don't be concerned if you don't follow the code as it utilises a number of concepts not yet visited:

{lang=Java}
<<[Handling failed assertions](code/01/07/handling.groovy)

The section on [Exceptions](#chexceptions) will explain this syntax in more depth.

T> ##Annotations
T> You may have noticed `@Log` in that last code snippet. This is called an [annotation](https://docs.oracle.com/javase/tutorial/java/annotations/) and is marked using an "at" (`@`) sign followed by a class name. These are used to markup code and have a number of purposes including error detection and generating functionality.

Although it's Java-focussed, check out the [Programming with Assertions guide](http://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html) for more information.
