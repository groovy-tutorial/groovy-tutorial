## Variables

Variables provide the basic "containers" into which values are stored for processing. As mentioned in [Data Types](), Groovy provides _dynamic typing_, freeing the programmer from having to explicitly declare a data type for a variable. This results in a variable's value being flexible enough to hold a changing value throughout the variable's lifespan.

The programmer may chose to use _explicit types_ for some or all variables. This is likely to be a decision based on desired constraints and readability.

### Variable names
Variable names must meet the following criteria:

 - Must start with a letter (upper-case [A-Z] or lower-case [a-z])
   - The underscore (`_`) is also allowed but very strongly discouraged 
 - Must only contain letters, digits (0-9) or an underscore (`_`)
   - The dollar-sign (`$`) is also allowed but very strongly discouraged 
 - Must not match a keyword (reserved word)
 
The use of literate variable names that comply to the criteria is encouraged. For example, a variable named `x` provides little information as to its role whereas `accountNumber` is likely to be clear within the context of a broader system.

### Variable Declaration and Assignment

The `def` keyword is used to declare a variable:

    def myNumber
    def myName

The previous example could be represented on a single line in which each variable is separated by a comma (`,`):

    def myNumber, myName

Variables can be assigned a value at declaration:

    def myNumber = 1
    def myName = "Fred Nurk"

A variable can be declared as being of a specific data type: 
 
    def Integer myNum = 1
    def String myName = "Fred nurk"

### Dynamic Typing
If a specific data type is not declared Groovy will handle the variable's data type. The table below illustrates Groovy's selection of a data type based on a value

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

### The `null` Value
Variables that are not assigned a value at declaration are provided a `null` value. This is a special reference that indicates the variable is devoid of a value.

Variables can be explicitly assigned `null`:

    def id = null