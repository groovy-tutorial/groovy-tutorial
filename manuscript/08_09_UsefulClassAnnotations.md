# Useful Annotations

I> Note to self: let annotations do my work for me



## ToString


	@groovy.transform.ToString
	class Person {
	    def name
	    def email
	    def mobile
	    
	    Person(name) {
	        this.name = name
	    }
	}
	
	def astrid = new Person('Astrid Smithson')
	
	println astrid

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


	@groovy.transform.EqualsAndHashCode
	class Person {
	    def name
	    def email
	    def mobile
	}
	
	def agentSmith = new Person(name: 'Agent Smith')
	def agentSmith2 = new Person(name: 'Agent Smith')
	
	assert agentSmith == agentSmith2



## Canonical

The `Canonical` annotation brings together functionality from a suite of other annotations:

* `ToString`
* `EqualsAndHashCode`
* `TupleConstructor`


	@groovy.transform.Canonical
	class Person {
	    def name
	    def email
	    def mobile
	}


This saves you from needing to stack your annotations:

	@groovy.transform.ToString
	@groovy.transform.EqualsAndHashCode
	@groovy.transform.TupleConstructor
	class Person {
	    def name
	    def email
	    def mobile
	}

## Immutable

The `Immutable` annotation provides the same features as `Canonical` but locks down new instances so that they can't be changed after creation.

	@groovy.transform.Immutable
	class Person {
	    String name
	    String email
	    String mobile
	}
	
	def krusty = new Person(name: 'Krusty')
	krusty.email = 'heyhey@example.com'