---
Title:	Data types  
Abstract:	
...

#Data types
Groovy allows you to create and use variables without declaring a data type - often called _dynamic typing_. Java, on the other hand, uses _static typing_ and you need to tell Java the data type you want to use when declaring a variable. Once again, Groovy is flexible and lets you use dynamic or static typing (or both) in your programs.

Groovy does not preclude the programmer from explicitly declaring a data type, particularly when it would be pertinent to constrain the values being managed. Furthermore, knowledge of data types is very useful for a number of reasons:

 1. Use of JVM-compatible libraries may require knowledge of the data types required by method calls.
	 - Important if you want to mine the rich collection of existing Java libraries
 2. Conversion between different data types (such as decimal numbers to whole numbers) can cause truncation and other (perhaps unexpected) results.
	 - Essential knowledge if your program relies on calculations 

## Using a specific type
A variable can be declared as being of a specific data type. When using a type, drop the `def` keyword: 

```groovy
Integer myNum = 1
String myName = "Fred nurk"
```

## Groovy's use of types
The table below illustrates Groovy's selection of a data type based on a value

[Table: Groovy's use of types]
|Value  |Assigned Type|
|:------|:------------|
|`true`|java.lang.Boolean|
|`'a'`|java.lang.String|
|`"This is a String"`|java.lang.String|
|`"Hello ${Larry}"`|org.codehaus.groovy.runtime.GStringImpl|
|`127`|java.lang.Integer|
|`32767`|java.lang.Integer|
|`2147483647`|java.lang.Integer|
|`9223372036854775807`|java.lang.Long|
|`92233720368547758070`|java.math.BigInteger|
|`3.14`|java.math.BigDecimal|
|`3.4028235E+38`|java.math.BigDecimal|
|`1.7976931348623157E+308`|java.math.BigDecimal|

It is important to note that the type is selected at each assignment - a variable that is assigned a string such as `"Hello"` is typed as `java.lang.String` but changes to `java.lang.Integer` when later assigned the value `101`. 

## The `null` Value
Variables that are not assigned a value at declaration are provided a `null` value by default. This is a special reference that indicates the variable is devoid of a value.

Variables can be explicitly assigned `null`:

    def id = null

## Available data types
As Groovy imports the `java.lang` package as well as the `java.math.BigDecimal` and `java.math.BigInteger` classes by default, a range of data types are available for immediate use:

 - `Boolean`: to store a logical value of `true` or `false`
 - `Byte`: an integral type 
 - `Short`: 
 - `Character`:
 - `Integer`: 
 - `Long`: 
 - `Float`:
 - `Double`:
 - `BigDecimal`:
 - `BigInteger`:
 - `String`:
 - `GString`: 
 - `Object`: This is the base class for all other classes. 
 - `Closure`: 

The types listed above are often referred to as _reference types_, indicating that they relate to a class definition. Groovy also provides a set of _primitive types_ that are more closely aligned to the C programming language than an object-oriented language such as Java and Groovy. In most cases, use of a reference type should be preferred and Groovy's dynamic typing uses _reference types_. 

The table below maps the types defined in `java.lang` against their equivalent primitive types:

[Table: the primitive types]
|Type     |Primitive type| Value range                                             |Size (bits) |
|:--------|:-------------|:--------------------------------------------------------|:----------:|
|Boolean  |`boolean`     |`true` or `false`                                        |-           |
|Byte     |`byte`        |-128 to 127, inclusive                                   |8           |
|Short    |`short`       |-32768 to 32767, inclusive                               |16          |
|Character|`char`        |'\u0000' to '\uffff' inclusive                           |16          |
|Integer  |`int`         |-2147483648 to 2147483647, inclusive                     |32          |
|Long     |`long`        |-9223372036854775808 to 9223372036854775807, inclusive   |64          |
|Float    |`float`       |32-bit IEEE 754 floating-point numbers                   |32          |
|Double   |`double`      |64-bit IEEE 754 floating-point numbers                   |64          |

As an object-oriented language Groovy also provides a mechanism for declaring new data types (objects) that extend and encapsulate information to meet a range of requirements. This will be discussed further in [Chapter 4. Classes]()

## Autoboxing
_Autoboxing_ refers to the automatic conversion of a primitive type to a reference type. _Unboxing_ is the reverse of _Autoboxing_.

## Type Conversions

Groovy will convert values assigned to variables into the variable's declared data type. For example, the code below declares a variable of type "String" and then assigns it 3.14 (a number). The assertion that the variable remains of type "String" will succeed, indicating that `3.14` was converted to a String value by Groovy before being assigned to the `myName` variable.

    def String myName = "Fred nurk"
    myName = 3.14
    assert myName.class == java.lang.String

Care must be taken to not rely totally on this automatic conversion. In the example below the assertion will fail as the `myPi` variable is declared as an `Integer` and the assignment drops the fractional component of `3.14`:

    def pi = 3.14
    def Integer myPi = pi
    assert myPi == pi