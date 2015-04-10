---
title:	Conditional Operators
status:	draft
description:	These help you lay out your logic.
...
You'll most often see Conditional-and (`&&`) and Conditional-or (`||`) used in conditional statements such as `if`. We also use them in expressions such as `assert` to determine if a statement is `true` or `false`.

The Conditional Operator (`?:`) is a short-form variant of the `if-else` statement that really helps with code readability. It's also referred to as the "elvis" operator and the "ternary" operator.

[Table: The conditional operators]
|Operator|Name|   
|:------:|:-------- |
|`&&`	|  Conditional-and	|  
|`||`	|  Conditional-or	| 
|`?:`	|  Conditional operator	|  

# What Is Truth?

All of the following statements resolve as `true` and the assertions all pass:

```groovy
assert 1
assert true
assert 'Hello'
```

Obviously `false` is false but so is `0`, `''` (empty string) and `null`. 

The complement operator (`!`) can be used to negate an expression, allowing the following assertions to pass:

```groovy
assert !false
assert !0
assert !''
assert !null
```

# Evaluation

Conditional operators are evaluated left-to-right. The assertion in the following code passes as the result of `true && false` is `false` but is then or'd with `true`, resulting in `true`:

```groovy
assert true && false || true
```

# Conditional-And
Conditional-and uses the boolean AND to determine if a statement is `true` or `false`. In order to be `true`, both the left-hand and right-hand operands must evaluate to true, as described in the truth table below:

[Table: AND Truth Table]
|LHS  |RHS | Result  
| :------:	| :------:	| :------:	|  
|0	| 0	| 0	|  
|1	| 0	| 0	|  
|0	| 1	| 0	|  
|1	| 1	| 1	|

In a conditional-and statement, both expressions are always evaluated. In the example below, `++counter` is evaluated (giving counter now equal to 1) before the conditional is assessed:

```groovy
def counter = 0
def result = true && ++counter

assert result == true
assert counter == 1
```

# Conditional-Or
Conditional-or uses the boolean OR to determine if a statement is `true` or `false`. In order to be `true`, either the left-hand or right-hand operands must evaluate to true, as described in the truth table below:

[Table: OR Truth Table]
|LHS  |RHS | Result  
| :------:	| :------:	| :------:	|  
|0	| 0	| 0	|  
|1	| 0	| 1	|  
|0	| 1	| 1	|  
|1	| 1	| 1	| 

In a conditional-or statement, each expression is evaluated in left-to-right order until either an expression resolves to `true` or no expressions are left (resulting in `false` overall). Once an expression is evaluated to `true` no further evaluation of the conditional is performed. This is important to keep in mind if you have an expression performing an operation that you later rely on as it may never be evaluated. In the example below I demonstrate a similar block of code used in the conditional-and section but I'll use a conditional-or. The final assertion (`assert counter == 1`) will fail as `++counter` is never evaluated:

```groovy
def counter = 0
def result = true || ++counter

assert result == true
assert counter == 1
```

# Conditional Operator

The conditional operator (`?:`) is most commonly used when assigning a value to a variable. A conditional expression is used for the first operand and placed to the left of the question-mark. If this resolves to `true` then the second operand is evaluated, otherwise the third operator is evaluated. This sounds a little confusing so let's look at an example:

```groovy
def salary = 100000

def taxBracket = salary < 75000 ? 'Bracket 1': 'Bracket 2'

assert taxBracket == 'Bracket 2'
```

In the code above the relational expression (`salary < 75000`) is evaluated and, in this case, resolves to `false` and the third operand (`Bracket 2`) is evaluated and assigned to `taxBracket`. As the operand is just a string there's no real evaluation but we can use any expression that will return a result. 

The code below will calculate income tax based on the person's income:

```groovy
def salary = 100000

def tax = salary < 75000 ? salary * 0.1: salary * 0.2

assert tax == 20000
```

>Note that only one of the second _or_ third operands are evaluated. For example, if the conditional resolves to `true` the third operand will not be evaluated.

A major benefit of the conditional operator is readability. Consider the previous code being re-written using an `if` statement and I trust you'll see that `?:` makes for more compact and readable code:

```groovy
def salary = 100000
def tax = 0

if (salary < 75000) { 
    tax = salary * 0.1
} else {
    tax = salary * 0.2
}

assert tax == 20000
```

## Default values

The conditional operator is also really useful for default values - these are used when you want to make sure a variable always has a value. In the code below the `Person` class has been prepared to ensure that any instance that has not been explicitly given a value for the `name` property is assigned `Anonymous` as the name:

```groovy
class Person {
    def name
    
    def Person(name = '') {
        setName(name)
    }
    
    def setName(name) {
        this.name = name ?: 'Anonymous'
    }
}

def jim = new Person()
println jim.name
```

Instead of writing `this.name = name ? name: 'Anonymous'` you'll notice that I didn't provide a second operand. This is another bonus for the ternary operator - if the conditional resolves to `true` and no second operand is provided, the result of the conditional is returned. This is a boring way to say that in `this.name = name ?: 'Anonymous'` if `name` is not false then it is assigned to `this.name`.

>It's usually best to use constants for default values - that way you can easily test a value in other sections of your code.

## Avoiding NPEs
NPEs (Null-Pointer Expressions) are the bane of Java and Groovy programmers. You'll see a lot of code checking for `null` and this reduces readability. This is usually in the form `if (myObj != null) {...}` or using the conditional operator `(myObj != null) ? ... : ...`.

As `null` evaluates to `false` in Groovy, the conditional operator provides a compact means by which to check if an object is `null` before trying to access the object:

```groovy
def myObj = null
def dump =  myObj ? myObj.dump() : ''
```

In the example above I test `myObj` and, if it isn't `null` then `dump` is given the value returned by `myObj.dump()`. Otherwise an empty string (`''`) is returned.

As an alternative, the safe-navigation operator (`?.`) can be used to test for `null` prior to attempting access on the object:

```groovy
def myObj = null
def dump = myObj?.dump()
```

The safe navigation operator is discussed further under Object Operators.

### In Java
In the code below I've provided a small example of checking for `null` in Java. You'll note that we need to be explicit on our conditional (`(t == null)`):

```java
public class NullTest {
    public static void main(String[] args) {
        NullTest t = null;

        String output = (t == null) ? "Null" : "Not null";
        
        System.out.println(output);
    }
}
```

To prove that I'm not just bloating my code to prove a point, here's a slightly more compact version of the example:

```java
public class NullTest {
    public static void main(String[] args) {
        NullTest t = null;
        System.out.println(t==null ? "Null" : "Not null");
    }
}
```

You'll note that I didn't bother with the `output` variable and dropped the parentheses (they're not required). The code is reasonably compact but rewritten in Groovy it gets even tidier:

```groovy
class NullTest {
    static main(args) {
        def t = null
        println(t ? 'Null' : 'Not null')
    }
}
```

You still need to check for `null` in Groovy but the shortened conditional operator and the safe navigation operator really do help cut down on the boiler-plate stuff.
     
