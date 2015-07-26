# Getters and Setters
Getters and setters are methods:

- Getters are used to read the value of a member variable
    - Their name begins with `get` followed by the title cased version of the property name
    - `getName`, `getEmail`, `getMobile`
    - Getter methods don't have any parameters
- Setters are used to set the value of a member variable. 
    - Their name begins with `set` followed by the title cased version of the property name
    - `setName`, `setEmail`, `setMobile`

Q> ## Accessors and Mutators?
Q> Getters are _accessor_ methods as they are used to access an object's member variable.
Q> Setters are _mutator_ methods as they can change a member variable.

In Java code you often see a lot of anaemic setters and getters - basically they getters just `return name` and the setters just `this.name = name`. In a class with a lot of member variables this results in a lot of boilerplate code that really gets in the way of readability. Groovy, however, creates these anaemic setters/getters for **properties only** behind the scenes so you don't have to. In the next code example I use my basic `Person` class with three properties:

{title='Where did getEmail come from?',lang=groovy}
    
    class Person {
        def name
        def email
        def mobile
    }
    
    def jess = new Person()
    jess.setEmail('jess_at_example.com')
    println jess.getEmail()

I never wrote the `getEmail` and `setEmail` methods - Groovy just worked out that my `email` property would need associated getters and setters. 

This means that most Groovy classes only need to provide getters/setters for properties if they need specific functionality or want to turn off the default behaviour. In the code below I define the setter for the `email` field as I want to make sure the caller is passing me a valid email address:

{title='A custom setter',lang=groovy}
    
    class Person {
        def name
        def email
        def mobile
        
        void setEmail(email) throws IllegalArgumentException {
            def regex = ~/[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+/
            if (email.matches(regex)) {
                this.email = email
                return
            }
            throw new IllegalArgumentException('Incorrect email format')
        }
    }
    
    def jess = new Person()
    
    jess.setEmail('jess@example.com')
    println jess.dump()
    
    //This will fail
    jess.setEmail('jess_at_example.com')
    println jess.dump()

What if I don't want a setter or getter? You can define your own setter or getter, mark it with the `private` access modifier and document it. I also like to throw exceptions to really prove my point:

{title='Change my ID will you?',lang=groovy}
    
    class Person {
        def id
        def name
        def email
        def mobile
        
        /**
         * Will NOT set the ID - do not call
         * @throws Exception Always throws an exception
         */
        private void setId(id) throws Exception {
            throw new Exception('Method not available')
        }
    }

In the code above you'll see that any call to `setId` will cause an exception to be thrown - whether it call the setter directly (`p.setId 1234`) or indirectly (`p.id = 1234`). 

Setters and getters **aren't generated for fields**. You need to create your own setters and getters for fields (if you want them). If you do provide a setter for a field (such as `name` in the code below), an attempt to directly set the field's value (e.g. `p.name = 'Bill'`) is deferred to the setter:

{title='',lang=groovy}

    class Person {
        public String name     
        
        void setName(name) {
            println 'Setting name...'
            this.name = name
        }
    }

    Person p = new Person()
    p.name = 'Bill'
