---
Title: "The assert statement"
...

The `assert` statement is perhaps out of order being described here but it will be relied on heavily in code examples.

>_Note: two operators are used in the examples below - `==` is equality operator and `!=` is the inequality operator. Both are discussed later in this chapter._

The `assert` statement evaluates a boolean expression (one that is `true` or `false`). If the result is `false` then the assertion has failed, the program is halted and an error is reported. The following example provides an obviously incorrect statement

    assert 1 == 2

An expression can be appended to the `assert` statement after a semicolon (`:`):

    assert true == false : 'true cannot be false'

The second expression can be anything Groovy can evaluate and the result is used in the error message. The following example will (unhelpfully) place the number "8.0" in the error message:

    assert true == false : Math.sqrt(64)
    
It's not good practice to have a program suddenly just quit when an assertion fails. Your code should aim to "fail gracefully" unless it's really in a position where bailing out is the only option. Groovy (unlike Java) does not provide a mechanism for turning off assertions but the error raised by a failed assertion can be caught within a `try-catch` and handled in a meaningful manner. 

The following example illustrates a class handling a failed assertion by logging the problem - don't be concerned if you don't follow the code as it utilises a number of concepts not yet visited:

    import groovy.util.logging.*

    @Log
    class AssertionTest {
        static void runTest() {
            try {
                assert true == false
            } catch(Error err) {
                log.severe "An assertion failed ${err}"
            } 
        }
    }
    
    AssertionTest.runTest() 

`assert` is also very useful when testing and a range of assertions will be discussed in the chapter on unit testing.
