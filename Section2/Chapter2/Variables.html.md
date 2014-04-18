## Variables

Variables provide the basic "containers" into which values are stored for processing.

Groovy is a dynamically-typed language. This means that variables don't need to be declared as being of a specific data type.

### Variable Declaration and Assignment

The `def` keyword is used to declare a variable:

    def myNumber
    def myName

The previous example could be represented on a single line in which each variable is separated by a comma (`,`):

    def myNumber, myName

Variables can be assigned a value at declaration:

    def myNumber = 1
    def myName = "Fred Nurk"
    
Variables that are not assigned a value at declaration are provided a `null` value. This is a special reference that indicates the variable is devoid of a value.

A variable can be declared as being of a specific data type: 
 
    def Integer myNum = 1
    def String myName = "Fred nurk"

Groovy will convert values assigned to variables into the variable's declared data type. For example, the code below declares a variable of type "String" and then assigns it 3.14 (a number). The assertion that the variable remains of type "String" will succeed, indicating that `3.14` was converted to a String value by Groovy before being assigned to the `myName` variable.

    def String myName = "Fred nurk"
    myName = 3.14
    assert myName.class == java.lang.String

Care must be taken to not rely totally on this automatic conversion. In the example below the assertion will fail as the `myPi` variable is declared as an `Integer` and the assignment drops the fractional component of `3.14`:

    def pi = 3.14
    def Integer myPi = pi
    assert myPi == pi

Further discussion regarding type conversion please refer to [Type Conversions](TypeConversions).