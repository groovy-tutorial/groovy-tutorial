---
title:      Methods
description:   
...

# Calling an Object's Method

The dot-point notation notation is used to specify a method call on an object instance. The following example helps explain this:

```groovy
class Athlete {
    def run() {
        println 'I am running'
    }
}

def alex = new Athlete()
alex.run()
```

The statement `alex.run()` calls the `run` method on the `Athlete` instance represented in the `alex` variable.

# Calling a method using a variable

It's possible to call an object's method by resolving its name using string interpolation. The following example helps explain this:

```groovy
class Athlete {
    def run() {
        println 'I am running'
    }
    
    def cycle() {
        println 'I am cycling'
    }
    
    def swim() {
        println 'I am swimming'
    }
}

def alex = new Athlete()

def triathlon = ['run', 'swim', 'cycle']

for (event in triathlon) {
    alex."$event"()
}
```

The call `alex."$event"()` looks a bit odd but remember that Groovy resolves `"$event"` to the value held by the `event` variable.

If we called `alex.event()` we'd get an exception as Groovy would look for a method called `event` in the `Athlete` class.


It's worth checking that the method you're calling actually exists and the call to `alex.class.getMethod(event)` will throw a `NoSuchMethodException` if the method isn't available:

```groovy
for (event in ['ski', 'swim', 'cycle']) {
    try {
        alex.class.getMethod(event)
        alex."$event"()
    } catch (NoSuchMethodException ex) {
        println "Sorry, but I can't $event"
    }
}
```

## DANGER
Be careful with just accepting anything for interpolation - you want to make sure that someone can't start interrogating your object. Try out the following code example and see what can go wrong:

```groovy
class User {
    def password = '1234'
    
    def getPassword() {
        return null
    }
}

def jane = new User()

def method = 'dump'
jane."$method"()
```

>Of course `println jane.@password` would also display the password *but* using the string interpolation approach means that user input (perhaps via a web form) could reveal the password rather than the field operator which would need another coder.

# The `main` method
Groovy classes can declare a method named `main`

```
class Countdown {
    int start = 10
    int end = 0
    
    void run() {
        start.downto(end){
            println it
        }
    }
    
    static void main(String[] args) {
        def count = new Countdown()
        count.run()
    }
}
```