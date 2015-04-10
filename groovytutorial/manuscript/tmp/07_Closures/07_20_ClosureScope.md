---
title:	Closure scope
status:	in-progress
description:	
...

Up to now we've kind of used closures as methods that can be referenced by variables or passed as parameters. 


```groovy
def spyMethod(closure) {
    closure()
}

def code = 'eagle'

def doubleCross = {println "The code is $code"}

spyMethod(doubleCross)
```

# More
First of all I'll create a very basic class

```groovy
class Contact {
    def name
    def phone
    
    /** A closure for calling the contact */
    def final call = { message -> 
        println "Calling ${this.name} on ${this.phone} with the message: \"$message\""
    }
}
```

```groovy
// This is our list of people to call back
def needToCallBack = []
```

```groovy
def andrew = new Contact(name: 'Andrew', phone: '+61 432 321 736')
def sally = new Contact(name: 'Sally', phone: '+61 400 800 900')
```

```groovy
needToCallBack << andrew.call
needToCallBack << sally.call
```

```groovy
// Now somewhere in our code we no longer explicitly track our contacts
andrew = null
sally = null
```

```groovy
// However, we can still call them as we stored the closure in our call back list
needToCallBack.each { it('It\'s Duncan here, sorry I missed your call') }
```

# The Complete Script

```groovy
class Contact {
    def name
    def phone
    
    /** A closure for calling the contact */
    def final call = { message -> 
        println "Calling ${this.name} on ${this.phone} with the message: \"$message\""
    }
}

def needToCallBack = []

def andrew = new Contact(name: 'Andrew', phone: '+61 432 321 736')
def sally = new Contact(name: 'Sally', phone: '+61 400 800 900')

needToCallBack << andrew.call
needToCallBack << sally.call

andrew.phone = '+61 432 321 000'

andrew = null
sally = null

needToCallBack.each { it('It\'s Duncan here, sorry I missed your call') }
```
