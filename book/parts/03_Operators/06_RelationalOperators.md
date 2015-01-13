## Relational Operators

[Table: The relational operators]
|Operator|Name     
|:------:|:--------
|\>      |Greater than
|\>=     |Greater than or equal to
|<       |Less than
|<=      |Less than or equal to
|<=>     |Spaceship

Similar to the Equality Operators, the expressions involving Relational Operators return a boolean result (`true` or `false`). All of the following operations resolve to `true`:

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

The spaceship operator comes from the Perl programming language. The Spaceship operator is most often seen where sorting is done. In the example below the `sort` function uses the closure to define the sort algorithm and this is where the spaceship lands:

```groovy
def nums = [42, -99, 6.3, 1, 612, 1, -128, 28, 0]

//Descending
println nums.sort{n1, n2 -> n2<=>n1 }

//Ascending
println nums.sort{n1, n2 -> n1<=>n2 }
```

The following table indicates the result for spaceship expressions (LHS = left-hand side, RHS = right-hand side):

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

# The `compareTo` method
Essentially, the `compareTo` method is used by Groovy to assess the result of relational operations:

```groovy
assert 1.compareTo(2) == -1
```

>There is a reasonable assumption that the two operands can be coerced (cast) into a similar type. This is why `1.compareTo('cat')` just won't work.

Custom classes can determine their own appropriate algorithm for the `Comparable`'s `compareTo` and this will be available when you use the relationship operators.

```groovy
class Num implements Comparable {
    def val
    
    @Override
    int compareTo(obj) {
         if (val < obj.val) {
             return -1
         } else if (val > obj.val) {
             return 1
         } else {
             return 0
         } 
    }
}

def a = new Num(val: 2)
def b = new Num(val: 5)

assert a < b
assert b > a
assert a != b
```

>You'll notice that I've tested `a != b` - this equality operator actually calls the `compareTo`