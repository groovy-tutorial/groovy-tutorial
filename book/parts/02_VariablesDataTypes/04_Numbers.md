---
title:	Numbers
status:	in-progress
description:	Groovy supports the various types of numbers that you'd expect - and makes it easy to use them
...

* Integers (whole numbers)
* Decimals


# Integers
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

# Decimals
Decimal numbers provide a fraction and can be negative or positive:

```groovy
def pi = 3.14159

// Measured in celsius
def absoluteZero = -273.15
```

# Scientific notation 
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

>This section will give you an overview that will cover most types of numbers but if you expect to be handling very large or very small numbers and calculations with such numbers then you really need to do some research to make sure you don't become a victim of truncation (where parts of the number are chopped off) and other issues with precision.