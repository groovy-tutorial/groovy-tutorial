---
Title:	Variables  
Abstract:	Variables are one of the most basic of programming constructs and help us to track values in our program.
...

# Variables
Variables are (perhaps unsurprisingly), items that can change. Essentially it is a "box" that can hold a value. Groovy provides a few ways to create a variable but the best one to start with is to use the `def` keyword. In the example below I define (`def`) a new variable named `score` that can be used to hold a value later in my program:

```groovy
def score
```

In the next example I assign `score` a value of 10 and ask Groovy to display the value of `score` using `println`:

```groovy
def score
score = 10
println score
```

Instead of declaring `score` and then assigning it the value `10` I can do this on a single line using `def score = 10`. I do just this in the example below and then change the value of `score` (it is a variable after all) - try this in your Groovy Console and the `println`s will show you the value of `score` after it's been set.

```groovy
def score = 10
println score
score = 11
println score
```

You'll note that the second time I use `score` I don't need the `def` prefix as I've already declared `score` and don't need to redeclare it.

If we're declaring a number of variables we could provide a `def` on each line:

```groovy
def myNumber
def myName
```

Alternatively, the previous example could be represented on a single line in which each variable is separated by a comma (`,`):

```groovy
def myNumber, myName
```

You can assign values to variables defined on a single line:

```groovy
def number1 = 10, number2 = 20
```

A set of variables can be assigned values from a list:

```groovy
def number1, number2
(number1, number2) = [10, 20]

assert number1 == 10
assert number2 == 20
```
    
In the next example a third variable is introduced but the assignment list only provides two elements. This will result in `number1` and `number2` being set but `number3` remaining without a value (`null`):

```groovy
def number1, number2, number3
(number1, number2, number3) = [10, 20]

assert number1 == 10
assert number2 == 20
assert number3 == null
```

## Variable names
Variable names must meet the following criteria:

 - Must start with a letter (upper-case [A-Z] or lower-case [a-z])
   - The underscore (`_`) is also allowed but very strongly discouraged 
 - Must only contain letters, digits (0-9) or an underscore (`_`)
   - The dollar-sign (`$`) is also allowed but very strongly discouraged 
 - Must not match a keyword (reserved word)
 
The use of literate variable names that comply to the criteria is encouraged. For example, a variable named `x` provides little information as to its role whereas `accountNumber` is likely to be clear within the context of a broader system.

# Data Types
Data types define the sort of data a variable can hold. Most programming language feature the following data types:

* Booleans
	* A logical value of `true` or `false`
* Characters and strings
	* A single letter, number or symbol (e.g. `#`)
	* A piece of text (referred to as a string)
* Numbers
	* Integers (whole numbers) both positive and negative
	* Decimals (fractional numbers) both positive and negative
* Dates
* Lists and sets
	* A variable that holds a number of values (list)
	* A variable that holds unique values (set)
* Maps
	* A variable that holds a number of values, each referred to by a key
* Ranges
	* 

Being an object-oriented programming language, Groovy lets you also define your own  types of objects (called classes).

Groovy allows you to create and use variables without declaring a data type - often called _dynamic typing_. Java, on the other hand, uses _static typing_ and you need to tell Java the data type you want to use when declaring a variable. Once again, Groovy is flexible and lets you use dynamic or static typing (or both) in your programs.

{{Variables/Objects.md}}

## Booleans

Boolean variables are perhaps the simplest and can hold a value of either `true` or `false`.

```groovy
def truth = true
def lies = false
```

### Useful Methods

Booleans have a small number of methods that you generally won't find yourself using as they (mostly) have equivalent operators that are more "natural" to read and write.

#### `and(right)`
Performs a logical 'and'

```groovy  
def truth = true
def lies = false
assert truth.and(lies) == false 
```

The conditional And operator (`&&`) is equivalent to the `and` method and the assertion above could also be written as `assert truth && lies == false`

#### `or(right)`
Performs a logical 'or'

```groovy  
def truth = true
def lies = false
assert truth.or(lies) == true 
```

The conditional Or operator (`||`) is equivalent to the `or` method and the assertion above could also be written as `assert truth || lies == true`

## Numbers

Groovy supports the various types of numbers that you'd expect. 

>This section will give you an overview that will cover most types of numbers but if you expect to be handling very large or very small numbers and calculations with such numbers then you really need to do some research to make sure you don't become a victim of truncation (where parts of the number are chopped off) and other issues with precision.

Numbers all have a range of methods but most of these are best used in their operator form. For example, the `plus` method is used add two numbers together but using the plain addition operator (`+`) we learnt in primary school is easier to read:

```groovy
assert 1.plus(1) == 2
assert 1 + 1 == 2
```

### Integers
Integers are whole numbers and can be negative or positive:

```groovy
def age = 27
def coldDay = -8
```

Groovy will also handle very large numbers:

```groovy
// 1 astronomical unit (au)
def distanceEarthToSun = 149597870700
def distanceNeptuneToSun = distanceEarthToSun * 30
```

### Decimals
Decimal numbers provide a fraction and can be negative or positive:

```groovy
def pi = 3.14159

// Measured in celsius
def absoluteZero = -273.15
```

#### Scientific notation 
Base-10 (decimal) scientific notation ($a * 10^b$) can also be used by placing an `e` or `E` before the exponent:

```groovy
def atomicMass = 1.67e-27
```

The next example sets the `au` variable to 1.49597870700 * 10^11 and then checks to make sure I haven't messed up the exponent:

```groovy
def au = 1.49597870700e11
assert au == 149597870700
```

In the previous two examples you can see a signed (positive or negative) integer as the exponent:

* `e-27` is negatively signed
* `e11` can also be written as `e+11` and is positively signed

{{Variables/Strings.md}}  

{{Variables/Lists.md}}  

## Ranges

Ranges define a starting point, an end and the size of the steps in between. Let's look at a well-known type of range:

```groovy
def countdown = 10..0

println countdown.getFrom()
println countdown.getTo()
```

The `countdown` range starts at 10 and goes down to 0. The notation should be easy to decipher: `<start>..<end>`.

Ranges are most often see when we're using loops - we'll get to them in a bit.

{{Variables/Maps.md}}  