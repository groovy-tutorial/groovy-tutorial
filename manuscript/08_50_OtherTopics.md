# Other OO Topics

## The `synchronized` Modifier

The `synchronized` modifier is used to indicate that part of the code (e.g. a method) can only be accessed by one caller at a time. This approach is used in concurrent environments in which multiple [threads](https://en.wikipedia.org/wiki/Thread_%28computing%29) are operating and there's potential that code running on different threads are interacting on the same instance of an object. This topic is beyond the scope of this book. A good starting place for understanding this topic is the [Concurrency](http://docs.oracle.com/javase/tutorial/essential/concurrency/index.html) section of The Java Tutorials.

## Static Type Checking and Compilation

	class Person {
	    String id
	    Integer getId() {id}
	}
	
	def pete = new Person(id: 12.3)
	println pete.id

When you try to run the code above you'll get a Groovy runtime exception (`org.codehaus.groovy.runtime.typehandling.GroovyCastException`). 
	
	@groovy.transform.TypeChecked
	class Person {
	    String id
	    Integer getId() {id}
	}
	
	def pete = new Person(id: 12.3)
	println pete.id

## Generics



Note how Groovy just lets us pass in the String:

	public class Box<T> {
	    private T value
	    public void set(T value) { this.value = value }
	    public T get() { value }
	}
	
	Box<Integer> iBox = new Box<>()
	iBox.set('rabbit')
	
	println iBox.get()

Java won't compile code equivalent to that above.

## Inner Classes
Java developers 