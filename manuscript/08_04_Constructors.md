# Constructors


	class Person {
	    def name
	    def email
	    def mobile
	    
	    Person(name) {
	        this.name = name
	    }
	}
	
	def astrid = new Person('Astrid Smithson')
	
	println astrid.dump()

Now that you've supplied a constructor you'll lose the built-in named argument constructor. Be warned that this isn't always obvious! If we create a new instance using named arguments, our `dump` will show us that `astrid`'s name becomes a list:

	def astrid = new Person(name: 'Astrid Smithson', email: 'astrid@example.com', mobile: '0418 111 222')

	println astrid.dump()

What just happened? Remember that Groovy provides a helpful option for providing named arguments in methods. As a constructor is just a specific type of method, Groovy sees the parameters as a map and stores it in the `name` field.

## Working With Getters and Setters

If you've 

