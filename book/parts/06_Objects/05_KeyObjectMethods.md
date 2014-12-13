---
title:	Introduction
description:	
...

## `is`

## `toString`


## `equals` and `hashCode`

```
class Person {}

Person sam =  new Person()
Person dean = new Person()

assert !sam.equals(dean)
```


```
class Country {
    final String name
    
    Country(name) {
        this.name = name
    }
}

Country australia = new Country(name: 'Australia')
Country au = australia
Country oz = new Country(name: 'Australia')

assert au.equals(australia)
assert au.equals(oz)
```


```
class Country {
    private volatile int hashCode
    final String name
    
    Country(name) {
        this.name = name
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) return false
        if (this.is(o)) return true
        
        if (!this.canEqual(o)) return false
        
        Country c = (Country) o
        if (c.name.equals(this.name)) return true
        
        return false
    }
    
    public boolean canEqual(Object o) {
        return o instanceof Country
    }
    
    @Override
    public int hashCode() {
        //As described in Item 9 of Effective Java
        int result = this.hashCode
        if (result == 0) {
            result = 31 * 17 + this.name.hashCode()
            hashCode = result
        }
        return result
    }
}

Country au = new Country(name: 'Australia')
Country oz = new Country(name: 'Australia')
```