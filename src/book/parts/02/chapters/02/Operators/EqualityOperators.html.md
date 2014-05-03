## Equality Operators

Operator|Name     
:------:|:--------
==      |Equal to 
!=      |Not equal to

The equality operators return a boolean result from a comparison. All of the following comparisons evaluate as being `true`

    assert -99 == -99
    assert 'koala' == 'koala'
    assert 'cat' != 'dog'
    assert 6 != 7
    
    def domesticAnimal = 'dog'
    def wildAnimal = 'lion'
    assert domesticAnimal != wildAnimal
    
    def str1 = 'Hello'
    def str2 = 'Hello'
    assert str1 == str2
    
In the following example, the equality operator (`!=`) is evaluated before the assignment operator (`=`), resulting in the value of `truth` being the boolean value `true`:

    def truth = 'cats' != 'dogs'
    assert truth == true