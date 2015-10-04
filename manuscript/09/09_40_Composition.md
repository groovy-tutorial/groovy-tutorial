# Composition



This can start to get even more abstract if we consider that a superhero has their hero identity (_Groovy Man!_) and their secret identity (_Gary Grails_). The approach to modelling this could be pondered in a number of ways:

* A super hero is just an advanced person so they inherit the person's properties and methods and extend them with additional abilities. This would mean that we use subclassing.
* The super hero abilities are just that - encapsulated abilities - and we could enhance a class with one or more traits.
* At their core, _Gary Grails_ and _Groovy Man!_ are two different people within a single physical body and should be described as an entity composed of two people.

This is all very deep and meaningful stuff and, whilst my example isn't overly serious, is what makes the design of software both extremely interesting and somewhat frustrating. My approach would normally be to write some prototype classes and traits and see how well they hold together as you delve into the concepts. Many times you'll find there's no perfect answer, just a less fragile one.
