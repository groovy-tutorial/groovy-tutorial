---
title: Equality Operators  
...
## Equality Operators

|Operator|Name     
|:------:|:--------
|==      |Equal to 
|!=      |Not equal to

The equality operators return a boolean result from a comparison. All of the following comparisons evaluate as being `true`

````groovy
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
````

In the following example, the equality operator (`!=`) is evaluated before the assignment operator (`=`), resulting in the value of `truth` being the boolean value `true`:

    def truth = 'cats' != 'dogs'
    assert truth == true
    
````groovy
class Dog{
    def name
}

def woofy = new Dog(name:'Woofy')

def charlie = new Dog(name:'Charlie')

assert woofy != charlie
assert ! woofy.is(charlie)

def bouncer = woofy
assert woofy.is(bouncer)
````


````groovy
import groovy.transform.EqualsAndHashCode 

@EqualsAndHashCode
class Dog{
    def name
}

def woofy = new Dog(name:'Woofy')

def newdog = new Dog(name:'Woofy')

assert woofy == newdog
assert ! woofy.is(newdog)
````