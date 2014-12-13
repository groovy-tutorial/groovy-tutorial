---
title:    Constants
description:   
...
# [%Title]

[%Abstract] 

Constants are just that - they don't change. Use of constants improves code by providing a reference point for comparison. Constants are usually declared with upper-case names (e.g. `MAX_PASSENGERS`). 

The term _constant_ may also be referred to by its synonym _immutable_.  

The `final` modifier is used to declare that a field's value cannot be changed:

    class Bus {
	    static final Integer MAX_PASSENGERS = 125
	    static final SEATS = 40
    }
    println Bus.MAX_PASSENGERS

In the example above the `MAX_PASSENGERS` constant is declared as an `Integer` but `SEATS` isn't explicitly typed, relying on Groovy to determine an appropriate data type. Whilst these things are always debatable constant declarations should be explicitly typed as their value is known and unchanging from the outset.

Access to the constants defined in the `Bus` class is via dot notation, as demonstrated in the `println Bus.MAX_PASSENGERS` statement. Classes and modifiers such as `final` and `static` are discussed in Chapter 4. 

#### Predefined Constants
Key constants are made available by a number of existing Java classes and, where possible, these should be used in preference to local definitions. Examples include:

 - `java.lang.Math.PI`
 - `java.lang.Math.E`
 - `java.lang.Double.NaN`

#### Where to use constants
Constants are extremely useful in ensuring consistency across a program. Key mathematical and scientific constants are often defined to save developers from (potentially) using incorrect values in calculations. Consider the effects of the following typo (where Pi is mistakenly entered as 3.41):
    
    circleArea = 3.41 * (10 * 10)
    
The following use of `java.lang.Math.PI` would have been wiser:

    circleArea = java.lang.Math.PI * (10 * 10)

String constants allow for easy comparison and assignment. Instead of having a large number of repeated strings throughout your code you should centralise the string in a constant. Consider the following code:

    class TestAnswers {
    	//Which animals are cuter?
    	static final ANSWER1 = "bilbies"
    }
    
    String myAnswer = "kittens"
    if (myAnswer == TestAnswers.ANSWER1) {
    	println "Correct!"
    } else {
    	println "Incorrect!"
    }

We could have put "bilbies" directly into the `if` evaluation. Perhaps this is not a great concern with such a trivial piece of code but imagine if this comparison was made at several points through a system - spelling mistakes would cause runtime bugs whereas the use of an incorrectly spelled constant name would be picked up at compile time.

#### Be mindful of constants in scripts 
Constants are best defined within a `class` declaration - as it was in the `Bus` class - rather than within a groovy script. Consider the following in a script file (e.g. `testconstant.groovy`):

    final Integer MAX_WEIGHT = 240
    MAX_WEIGHT = 275
    assert MAX_WEIGHT == 240

The assertion will fail as the assignment of `MAX_WEIGHT = 275` will succeed, rendering `MAX_WEIGHT` a variable and not a constant.

### Enums
Enums (_enumerations_) are used to hold a set of constants:

    enum AustralianStates {
	    TAS, VIC, NSW, QLD, WA, SA
    }
    
    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }
    
    enum Season { WINTER, SPRING, SUMMER, AUTUMN }
    
The name of the enum uses the same format that will be discussed for classes. The constants within the enum are written in upper-case.

Access to a constant within an `enum` is via dot notation ("."):

    AustralianStates.TAS
    Day.FRIDAY
    Season.SPRING

As an `enum` declaration is defining a class they will be discussed further in Chapter 4.
    
