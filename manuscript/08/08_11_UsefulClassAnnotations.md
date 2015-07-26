# Useful Annotations

I> Note to self: let annotations do my work for me



## ToString



{lang=groovy}
<<[The ToString annotation](code/08/11/ToString.groovy)

Instead of using the full library path with `@groovy.transform.ToString` you can use the `import` keyword:

	import groovy.transform.ToString

	@ToString
	class Person {
		//...
	}


`@ToString(includeNames=true)`
:

`@ToString(includeFields=true)`
:


	@groovy.transform.ToString(includeNames=true, includeFields=true)
	class Person {
	    def name
	    private email
	    private mobile

	    Person(name) {
	        this.name = name
	    }
	}

	def astrid = new Person('Astrid Smithson')

	println astrid

## EqualsAndHashCode

{lang=groovy}
<<[The EqualsAndHashCode annotation](code/08/11/ToString.groovy)

## Canonical

The `Canonical` annotation brings together functionality from a suite of other annotations:

* `ToString`
* `EqualsAndHashCode`
* `TupleConstructor`

{lang=groovy}
<<[The Canonical annotation](code/08/11/Canonical.groovy)

This saves you from needing to stack your annotations:

{lang=groovy}
<<[Canonical combines three annotations](code/08/11/Canonical_equiv.groovy)

## Immutable

The `Immutable` annotation provides the same features as `Canonical` but locks down new instances so that they can't be changed after creation.

{lang=groovy}
<<[You can't touch this - it will cause an exception](code/08/11/Immutable.groovy)
