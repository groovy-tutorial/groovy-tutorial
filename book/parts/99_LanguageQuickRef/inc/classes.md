# Classes
>Note: Groovy doesn't enforce access modifiers such as `private` and `protected` - these are used in an advisory capacity.

The simplest class declaration:

<pre>
class <i>ClassName</i> {
}
</pre>

The more involved version:

<pre>
<i>[package_name]</i>

<i>def</i> <i>[class modifiers]</i> <i>[access modifiers]</i> class <i>ClassName</i> 
  <i>[extends SuperClass]</i>
  <i>[implements Interface(s)]</i>{
	<i>[Field declarations]
	[{Instance initializers}]
	[static {Static initializers}]
	[Constructor declarations]
	[Instance method declarations]
	[Static method declarations]</i>
}
</pre>

- Classes are `public` by default
- The sections listed inside the class body (e.g. _Field declarations_) can appear in any order.

`def`
:Not required

access modifiers (optional, 0..1):
:- `public`
- `protected`

Class modifiers (optional, 0..1):
:- `abstract` (optional)
	- Instances of this class cannot be created. 
- `final` (optional)
	- Subclasses cannot be created for this class

`extends` (optional, 0..1)
:Specifies the superclass

`implements` (optional, 0..n)
:Specifies the interface(s) implemented by this class 
:Multiple interfaces can be declared, separated by a comma (`,`)

## Package Name



## Fields

<pre>
[def | static | access modifier] fieldName <i>[= operation]</i>
</pre>

Accessing fields
:Fields can be accessed using dot-point notation (e.g. `myObj.name`)

### Properties
Instance fields defined using the `def` statement and static fields declared without an access are referred to as _properties_ and default getter and setter methods are automatically provided by Groovy. 

|Field example | Generated setter | Generated getter |  
| ------	| ------	| ------	|  
|`def name` 	| `getName()`	| `setName(name)`	|  
|`def carModel`	| `getCarModel()`	| `setCarModel(carModel)`	| 
|`static name` 	| `getName()`	| `setName(name)`	|  

A getter and/or setter can be explicitly provided.

Accessing properties
:Property access using dot-point notation actually causes the getter or setter to be called, depending on the operation.

### Instance Fields

Instance fields can be accessed via the `this.` keyword.

### Static Fields




## Instance Initializers
The instance initializer block is contained within curly braces (`{...}`) and is called _once_ when a new class instance is created (using the `new` statement): 

<pre>
{
  // Instance intialising block
}
</pre>

Zero or more instance initializer blocks can be provided and are evaluated in order of appearance.

The instance initializer block is evaluated before any pertinent constructor is evaluated.

## Static Initializers
The static initializer block is contained within curly braces prefixed with the `static` keyword (`static {...}`) and is called _once_ when a  class is initialised: 

<pre>
static {
  // Static intialising block
}
</pre>

Zero or more static initializer blocks can be provided and are evaluated in order of appearance.

In general terms, a class is initialised (and the static initializer(s) evaluated) when one of the following occurs:

- A new instance of the class is requested
- A static field or method is accessed

## Methods
<pre>
<i>[method modifiers]</i> <i>[def | static | access_modifier]</i> <i>[return_type]</i> methodName(<i>[params]</i>) 
  <i>[throws exception_types]</i>{
  // method block
}
</pre>

A method is declared using the `def` or `static` keywords or an access modifier.

`def` (optional)
:Equivalent to the `public` access modifier

`static` (optional)
:Indicates the the method is a static method
:Will be `public` by default but an access modifier may be provided.

access modifiers (0..1)
:- `public`
- `private`
- `protected`
:_Don't provide an access modifier is `def` is used_

Method modifiers
:- `abstract` (optional)
	- Introduces the method signature but provides no implementation
	- Can only be declared in `abstract` classes 
	- Can't be used in association with `final` or `synchronized`
- `final` (optional)
	- Subclasses cannot be created for this class
- `synchronized`
	- 

Return type
:

`throws`
:

Returning values
:The `return` statement causes the evaluation of the method to cease and control is passed back to the invoker.

:A method will return a result by either:

:- An explicit `return` is provided with an associated expression
	- e.g. `return 21`
	- `return`  with no expression will cause `null` to be returned
- If no `return` statement is provided, the result of the method's final expression is returned.
	
### Instance Method Declarations
Instance methods can access instance fields and methods, and are able to use the `this` keyword.

### Static Method Declarations
Static methods use the `static` method modifier, cannot access instance fields and methods, and aren't able to use `this`.

<pre>
static <i>[method modifiers]</i> <i>[return_type]</i> methodName(<i>[params]</i>) {
  // method block
}
</pre>






