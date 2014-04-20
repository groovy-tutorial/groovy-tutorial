## Relational Operators

Operator|Name     
:------:|:--------
\>      |Greater than
\>=     |Greater than or equal to
<       |Less than
<=      |Less than or equal to
<=>     |Spaceship

Similar to the Equality Operators, the expressions involving Relational Operators return a boolean result (`true` or `false`). All of the following assertions are `true`:

    assert 5 > 2
    assert 4 >= 3
    assert 4 >= 4
    assert 8 < 9
    assert 6 <= 7
    assert 7 <= 7

Ordinarily, the operands used in a relational comparison are of a primitive type or able to be cast to a primitive type. Furthermore, the operands need to be able to find a common type for comparison (such as both being numbers) - the following code will cause and exception:

    if ('easy' < 123) println "It's easier than 123"

However, as Groovy allows for operator overloading (discussed in Chapter 4), objects can determine the . Consider the following:

    if ('hello' > 'goodbye') println "It's nicer to say hello"
    
Can we infer that Groovy is undertaking some sort of natural language processing? Hardly - Groovy provides this as a short-form version of the String's [`compareTo`](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#compareTo%28java.lang.String%29) method:

 * If the two Strings are **the same** then `==`, `>=` and `<=` comparisons will return `true`
 * If the two Strings are **different** then a `!=` comparison will return `true`
 * [TODO]

### Spaceship
The spaceship operator

    assert 2 <=> 2 == 0
    assert 1 <=> 2 == -1
    assert 2 <=> 1 == 1