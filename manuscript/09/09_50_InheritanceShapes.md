# The Shapes demo - Inheritance

The class hierachy for the Shapes demo is provided below:

![The Shapes Demo class diagram](images/ClassDiagram.png)

Inheritance is used in a number of places:

* The `Square` class is a subtype of `Rectangle` as squares are a special type of rectangle in which all four sides have the same length.
    * `Square` doesn't need to do much over the already provided `Rectangle` class
* The `Triangle` class is extended by two subtypes: `TriangleRightAngled` and `TriangleIsosceles`
    * `TriangleEquilateral` is a subtype of `TriangleIsosceles`

The three `Triangle` subtypes encapsulate specific refinements such as the definition of the sides and refinement of the `calculateArea` calculation. By making `calculateArea` a `static` method, each subtype makes the calculation easily available to other code as well as tying the `calculateArea` instance method to the static method.

The `Square`, `TriangleRightAngled` and `TriangleEquilateral` classes are both declared as `final` because I decided they couldn't be refined any further. This is an important aspect to designing/developing classes: only allow for inheritance if you will support it. By marking these classes as `final` I've indicated that the implementations can't/shouldn't be further enhanced. Naturally, another developer could `extend Triangle` with their own implementation as it isn't marked as `final` because I believe `Triangle` to be a sound generic basis for describing triangles.

Q> ## Was `TriangleSubtype` a good name/approach for a `trait`?
Q> I wanted subclasses of `Triangle` to provide a specific `getTriangleType()` implementation and considered two other options:
Q>
Q> * I could have created a `TriangleSubclass` that extended `Triangle` and was, in turn, extended by specific subclasses. However, this just felt like an odd "shim" in the class hierarchy so I decided against it.
Q> * A `TriangleSubtype` `interface` might have been a better idea but I felt that the actual implementation of the `getTriangleType` wouldn't need to be adapted by a subclass.
Q>
Q> I'm not really happy with `TriangleSubtype` but it helped me demonstrate `@SelfType` and the use of a `trait` to provide a default implementation similar to the functionality available in Java interfaces.

I> The Shapes demo doesn't declare any abstract classes.
