## Relational Operators

[Table: The relational operators]
|Operator|Name     
|:------:|:--------
|\>      |Greater than
|\>=     |Greater than or equal to
|<       |Less than
|<=      |Less than or equal to
|<=>     |Spaceship

Similar to the Equality Operators, the expressions involving Relational Operators return a boolean result (`true` or `false`). All of the following assertions are `true`:

```groovy
assert 5 > 2
assert 4 >= 3
assert 4 >= 4
assert 8 < 9
assert 6 <= 7
assert 7 <= 7
```

Ordinarily, the operands used in a relational comparison can be compared in a meaningful manner. If they are different data types then the operands need to be able to find a common type for comparison (such as both being numbers) - the following code will cause and exception because Groovy can't be expected compare a string with a number in this way:

```groovy
if ('easy' < 123) println "It's easier than 123"
```

### Spaceship
[Table: The spaceship operator]
|Operator|  
|:------:|
|<=>      |  

The spaceship operator comes from the Perl programming language. 

|Expression|Result
|:--|:--:
|LHS less than RHS|-1
|LHS = RHS|0
|LHS greater than RHS|1

The following assertions all resolve as true:

```groovy
assert 2 <=> 2 == 0
assert 1 <=> 2 == -1
assert 2 <=> 1 == 1
```