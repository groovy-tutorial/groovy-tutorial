---
title:	Fields
description:	
...
# [%Title]

_[%Abstract]_ 

A class's fields are used to describe an object. Some fields describe properties of the object (e.g. name, age, height), some describe the state of the object (e.g. active, alive, employed), and some may be used 


The example below describes a class with two fields - `name` and `age`:

```
class Person {
    String name
    int age
} 
```

As you can see, the `name` field is a `String` and `age` is an `int`. 

Knowing which fields a class needs is a function of the following questions:

How much information do we need about the object for it to be useful in the system?
:    Describing a comprehensive `Person` class is likely to be impossible - how does one describe something as complex? Essentially, we don't - we take the attributes of a `Person` that we need in order for `Person` objects to be useful within the context of the system. For example, a banking system doesn't need to know a person's hobbies and phobias so developers of banking systems tend not to include them in their `Person` classes.

Which fields are really derived from other fields?
:    The `Person` class has an `age` field but this wasn't a good idea. It would have been more useful to have a `dateOfBirth` field as it would allow the class to provide methods to determine information such as age, star sign and generation. Additionally, we'd need extra code to somehow keep updating the `age` field - otherwise our `Person` might be trapped forever at the age of 8 ala Bart Simpson. Methods will be discussed later but it's useful to know that fields which can be calculated/derived from other fields are best presented as methods.

## Naming fields


## Managing field values
Having fields in a class is useful - being able to set them to meaningful values means that objects can then represent their real/virtual counterpart. 




### Field Modifiers


### Constructors


### Setters and Getters