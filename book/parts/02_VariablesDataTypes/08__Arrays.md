---
Title:      Arrays
...
To declare an array of Strings

```groovy
String[] names = new String[4]
```

A basic use of arrays:

```groovy
def myArray = new String[4]
myArray[0] = 'Jim'
myArray[1] = 'Sarah'
myArray[2] = 'David'
myArray[3] = 'Amy'

for (Object person: myArray) {
    println person
}
```

Access to array elements is via their index (e.g. `myArray[2]`).

Any attempt to add an extra item (e.g. `myArray[4] = 'Duncan'`) will cause an `java.lang.ArrayIndexOutOfBoundsException`.

Arrays can be of any type and the `Object` class provides a flexible type when your array needs to hold a mixture of values (e.g. numbers, strings, various types):

```groovy
Object[] bag = new Object[4]
```

# Manipulating arrays

```groovy
println myArray.length
```

```groovy
println myArray.size()
```

Sort an array
```groovy
myArray.sort()
println myArray
```

TODO: myArray.binarySearch

Use closures
```groovy
myArray.each() {
    println "Name: $it"
}
```

# Copying arrays
```java
public static void arraycopy(Object src,
                             int srcPos,
                             Object dest,
                             int destPos,
                             int length)
```

The following code copies the whole array:
```groovy
System.arraycopy(myArray, 0, newArray, 0, newArray.length)
println newArray
```




#Array methods
`java.util.Arrays` has a number of 

## Multidimensional arrays