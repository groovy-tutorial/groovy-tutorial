## Data Types
Groovy is a dynamically-typed language. Essentially, this means that variables don't need to be declared as being of a specific data type. However, Groovy does not preclude the programmer from explicitly declaring a data type, particularly when it would be pertinent to constrain the values being managed. Furthermore, knowledge of data types is very useful for a number of reasons:

 1. Use of JVM-compatible libraries may require knowledge of the data types required by method calls.
 1. Conversion between different data types (such as decimal numbers to whole numbers) can cause truncation and other (perhaps unexpected) results.

### Available data types
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

### Autoboxing
_Autoboxing_ refers to the automatic conversion of a primitive type to a reference type. _Unboxing_ is the reverse of _Autoboxing_.




