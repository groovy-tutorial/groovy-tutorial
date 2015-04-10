---
title:	Expando
status:	in-progress
description:	The Expando class lets you create objects on the fly. 
...
In the example below the `monster` variable is dynamically assigned a set of fields and methods (through the use of closures).

```
def monster = new Expando()

//Let's add some properties
monster.name = 'Dr Frankensteins Monster'
monster.owner = 'Dr Frankenstein'
monster.height = 8

//Add some closures (methods)
monster.getOwner = {owner}
monster.getName = {name}
monster.getHeight = {height}

monster.scareVillage = { village ->
    println "Look out $village here comes $name!"
}

monster.scareVillage('Darmstadt')
```

The `monster` Expando looks to be acting similar to a Map but it gives us more functionality.
Whilst the properties can be assigned to an Expando instance in the same way as a map, 
the addition of a closure illustrates the difference. In the example below the use of
a map to define the `vampire` variable demonstrates that the `scareVillage` can't rely 
on an instance field (`name`):

```
def vampire = [:]
vampire.name = 'Dracula'

vampire.scareVillage = { village ->
    println "Look out $village here comes $vampire.name!"
}

vampire.scareVillage('London')
```

By using the `Expando` class instead of a `Map`, the instance fields can be accessed.

## Using Expando

TODO

```groovy
//This is a basic CSV (Comma-separated file)  described as a string
def table = '''\
name,email,phone
Fred,fred@email.com,555-678345
Alex,alex@email.com,555-987123
Simon,simon@example.com,555-567321
'''

//Read the CSV in and break it up by linebreaks
def csv = table.tokenize()

//Extract the first row - it contains the headers (field names)
header = csv[0].tokenize(',')
csv.remove(0)

def contactList = []
for (row in csv) {
    //Separate the row into fields
    def fields = row.tokenize(',')
    
    Expando contact = new Expando()
    contact.keys = header
    
    //Now setup the contact class with field names based on the header
    fields.eachWithIndex() { key, value ->
       contact.setProperty header[value], key
    }
    
    contact.buildLine = { values, token = ',' ->
        StringBuffer line = new StringBuffer("")
        for (item in values) {
            line.append("$item$token")
        }
        
        line.deleteCharAt(line.length()-1)
        line.append('\n')
    }
    
    contact.toCSV = { token = ',', boolean displayHeader = false ->
        StringBuffer line = new StringBuffer("")
        if (displayHeader) line.append(buildLine(keys, token))
        
        def values = []
        for (field in keys) {
            values << getProperty(field)
        }
        line.append(buildLine(values, token))
    }
    
    //
    contact.getVCard = {
        """BEGIN:VCARD
        VERSION:4.0
        N:$name
        EMAIL:$email
        TEL;TYPE=work,voice;VALUE=uri:tel:$phone
        END:VCARD"""
    }
    contactList << contact
}

//for (contact in contactList) {
//    println contact.getVCard()
//}

for (contact in contactList) {
    print contact.toCSV('\t', true)
}
```