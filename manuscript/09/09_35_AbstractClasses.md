# Abstract classes


{lang=Java}
    abstract class Thing {}

    def myObj = new Thing()

{lang=Java}
    abstract class Thing {

        abstract String name

        abstract String describe()

        @Override
        String toString() {
            'This is a thingy'
        }

    }

    class Blob extends Thing {

        String describe() {
            'I am an amorphous blob'
        }

    }

    def myObj = new Blob()
    assert myObj.describe() == 'I am an amorphous blob'


Some things to keep in mind:

* Abstract classes can implement interfaces and traits
    * The abstract class may not provide an implementation of some or all of the interface methods - any missing implementations must be provided by the class extending the subclass.
* You can provide static methods and variables (class members) in an abstract class
* An abstract class can extend (subclass) an abstract class
    * The subclass doesn't need to implement any/all of the abstract methods of the superclass - the responsibility is passed down to a non-abstract subclass
     * This option is rarely useful and interfaces are likely to be a better approach

Before committing to an abstract class it'd be well worth your time determining if a combination of an interface and a "base" class; or an interface and a trait; or just an interface wouldn't be more flexible.
