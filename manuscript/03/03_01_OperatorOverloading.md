# Operator Overloading {#choperatoroverloading}

Groovy supports something called "operator overloading" and it's possible for classes to determine how they want operators to behave. Throughout this tutorial I'll provide some examples of overloading but before we go too far, let's take a look at what "operator overloading" actually means.

The C++ language provides a mechanism for programmers to customise how operators such as `+` (plus) and `-` (minus) work. This functionality isn't provided in Java but is available to Groovy programmers. Essentially, a class can include certain methods that replace (overload) the default implementation - as such methods are tied to specific operators.

Consider the `+` operator, as seen in many great additions. You can use the operator in a statement such as `10 + 2` but you can also use the `plus` method instead: `10.plus(2)`. I'd argue (strongly) that using the `plus` method in your code will be far less readable. However, you should be able to see that using the `+` operator actually results in the `plus` method being called.

This means that you can use operator overloading for evil - say, by creating a numerical class that ignores all mathematical sense. Aside from developer practical jokes you'll probably only use operator overloading every now and then. Where it does become extremely useful is in the core Groovy classes and the Groovy extensions to the JDK.

In the coming chapters you'll see a range of operator usage that isn't available to the Java developer but made available through Groovy's extensions to the JDK and through the GAPI.

To highlight all of this, operator overloading can be used in classes via the methods associated in the following table:

{title="Methods for overloading operators"}
|Method|Operator|
|:------|:------:|
| plus	| `+`	|
| minus	| `-`	|
| div	| `/`	|
| mod	| `%`	|
| multiply	| `*`	|
| power	| `**`	|
| equals	| `==`	|
| compareTo	| `<=>`, `>`, `<`	|
| rightShift	| `>>`	|
| leftShift	| `<<`	|
| next	| `++`	|
| previous	| `--`	|

I>This list doesn't include all possible operators, just the main ones

Throughout the tutorials on operators I'll provide information as to how certain functionality is obtained through operator overloading. Feel free to glaze past these sections - they're mainly there to explain why/how stuff is happening.
