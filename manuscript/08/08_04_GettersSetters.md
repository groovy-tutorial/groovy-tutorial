# Getters and Setters

Getters and setters are methods:

- Getters are used to read the value of a member variable
    - Their name begins with `get` followed by the title-case version of the property name
    - `getName`, `getEmail`, `getMobile`
    - Getter methods don't have any parameters
- Setters are used to set the value of a member variable.
    - Their name begins with `set` followed by the title cased version of the property name
    - `setName`, `setEmail`, `setMobile`

Q> ## Accessors and Mutators?
Q> Getters are _accessor_ methods as they are used to access an object's member variable.
Q> Setters are _mutator_ methods as they can change a member variable.

In Java code you often see a lot of anaemic setters and getters - basically the getters just `return name` and the setters just `this.name = name`. In a class with a lot of member variables this results in a lot of boilerplate code that really gets in the way of readability. Groovy, however, creates these anaemic setters/getters for **properties** behind the scenes so you don't have to. In the next code example I use my basic `Person` class with three properties:

{lang=Java}
<<[Where did getEmail come from?](code/08/04/builtin_accessors.groovy)

I never wrote the `getEmail` and `setEmail` methods - Groovy just worked out that my `email` property would need associated getters and setters.

This means that most Groovy classes only need to provide getters/setters for properties if they need specific functionality or want to turn off the default behaviour. In the code below I define the setter for the `email` field as I want to make sure the caller is passing me a valid email address:

{lang=Java}
<<[A custom setter](code/08/04/custom_setter.groovy)

What if I don't want a setter or getter? You can define your own setter or getter, mark each with the `private` access modifier and document it. I also like to throw exceptions to really prove my point:

{lang=Java}
<<[Change my ID will you?](code/08/04/no_accessor.groovy)


In the code above you'll see that any call to `setId` will cause an exception to be thrown - whether it calls the setter directly (`p.setId 1234`) or indirectly (`p.id = 1234`).

## Fields
Setters and getters **aren't generated for fields**. You need to create your own setters and getters for fields (if you want them). In the code below
we can't use `p.setName('Bill')` as the setter is not created for us - instead, we access the field directly with `p.name = 'Bill'`:

{lang=Java}
<<[A basic field](code/08/04/fields.groovy)

If you do provide a setter for a field (such as `setName` in the code below), an attempt to directly set the field's value (e.g. `p.name = 'Bill'`) is deferred to the setter:

{lang=Java}
<<[A setter](code/08/04/fields2.groovy)

The call to `p.setName` also works but using `p.name` is a little cleaner in terms of aesthetics/style.

I> A Java developer may be a little concerned that I can directly edit a field with the `private` access modifier. This is something
I> you need to be aware of and I'll cover it more in [Access modifiers](#chaccessmodifiers).

## Pseudo properties

The Groovy model for setters and getters means that you can access Java and Groovy getter/setter methods as if they were
properties. For example, instead of calling `myUrl.getText()` on an instance of `java.net.URL`, I can just use `myUrl.text`:

    def myUrl = new URL('http://www.example.com')
    print myUrl.text

The `URL` class may have an underlying member variable called `text` but that's not really our concern. What it does guide us to is
the fact that, provided we use the `get` and `set` prefix on methods we can then access them as if they were properties. Consider
a `Person` class that stores the person's date of birth (DOB). When we know their DOB we can calculate their age:

{lang=Java}
<<[Age is a pseudo property](code/08/04/pseudo_property.groovy)

In the code above I define the `getAge` getter to perform the calculation to determine the person's age. This is better than
having an `age` property/field as this can be calculated from the DOB. The other advantage is in long-running systems - if we
stored the `age` then it becomes out of date as the system runs for days/weeks/months.

It's important to note that we can't call `jim.age = 100` in the code above as we don't provide a setter. Naturally, we could provide a setter
but it doesn't make a lot of sense in terms of the Person's `age`.

I> Pseudo properties may also be referred to as calculated, derived or virtual fields/properties
