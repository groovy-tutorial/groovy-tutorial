# Other OO Topics

Stay tuned!

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
