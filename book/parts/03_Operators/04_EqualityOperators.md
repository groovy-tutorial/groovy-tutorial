## Equality Operators
[Table: The equality operators]
|Operator|Name     
|:------:|:--------
|==      |Equal to 
|!=      |Not equal to

The equality operators return a boolean (`true` or `false`) result from a comparison. All of the following comparisons evaluate as being `true`

```groovy
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
```

### What Is Equality?

Equality can be a little tricky. Think about the statement "Hey cool, we have the same car!". This could mean that we have the same make and model but different instances of a car *or* it could mean that we share a car. 

For those coming from a Java background, `==` is used to determine if the two variables reference the same instance and the `equals` method is used to determine if two variables are equivalent. Groovy conflates `==` and `equals` to perform the same comparison.

The `is` method performs the Groovy equivalent of Java's `==` and returns `true` if two variables refer to the same instance of an object

```groovy
def obj1 = new Object()
def obj2 = new Object()
def obj3 = obj1

assert obj1.is(obj3)
assert ! obj1.is(obj2)

assert obj1 != obj2
assert obj1 == obj3

assert ! obj1.equals(obj2)
assert obj1.equals(obj3)
```

### Precedence
In the following example, the equality operator (`!=`) is evaluated before the assignment operator (`=`), resulting in the value of `truth` being the boolean value `true`:

```groovy
def truth = 'cats' != 'dogs'
assert truth == true
```

### Custom Equality

