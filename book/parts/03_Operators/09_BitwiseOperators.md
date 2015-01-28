---
title:	Bitwise Operators
description:	
...
I have to admit that I haven't seen many instances of bitwise manipulation since my university assignments. That's not to say they're not used or not important - I've just not done a lot of programming on

[Table: The bitwise operators]
|Operator|Name     
|:------:|:--------  
| &	| Bitwise AND	|  
| \|	| Bitwise OR	|  
| ^	| Bitwise XOR[^xor]	|  
| ~	| Bitwise negation (Not)	|  
| >>	| Right shift	|  
| >>>	| Right shift unsigned	|  
| <<	| Left shift	| 

[^xor]: Known as an Exclusive OR

# Truth Tables

Truth tables describe the results of various logical operations. The truth tables below illustrate the NOT, AND, OR and XOR logic.

| Not (`-`) | Result |
|-----|:-----:|
| Not 0 | 0 |
| Not 1 | 1 |

| And (`&`) | Result |
|-----|:-----:|
| 0 AND 0 | 0 |
| 0 AND 1 | 0 |
| 1 AND 0 | 0 |
| 1 AND 1 | 1 |

| Or (`|`) | Result |
|-----|:-----:|
| 0 OR 0 | 0 |
| 0 OR 1 | 1 |
| 1 OR 0 | 1 |
| 1 OR 1 | 1 |

| Xor (`^`) | Result |
|-----|:-----:|
| 0 XOR 0 | 0 |
| 0 XOR 1 | 1 |
| 1 XOR 0 | 1 |
| 1 XOR 1 | 0 |

# Flag example

The unix file permission scheme uses binary flags for read, write and execute permissions on files. You see them when you run `ls -l` as something like `-rwxr-xr-x`. Essentially, this is a set of flags where binary `1` turns on that permission and binary `0` turns it off. The three elements I'll look at here are read (r), write (w) and execute (x):

- READ has the binary value 001 (decimal 1)
- WRITE has the binary value 010 (decimal 2)
- EXECUTE has the binary value 100 (decimal 4)

>I use decimal in my example code but you'll usually see binary manipulated using hexadecimal (`0x1f`) or octal (`037`) notation

Let's look at the example code first and then I'll discuss it:

```groovy
//Create global variables for the permissions
READ = 4      //100
WRITE = 2     //010
EXECUTE = 1   //001

println 'Checking for READ:'
checkFile(READ)

println 'Checking for WRITE:'
checkFile(WRITE)

println 'Checking for READ or EXECUTE:'
checkFile(READ | EXECUTE)

def checkFile (check) {
    def fileList = [:]
    for (i in 0..7) {
        fileList["File $i"] = i
    }
    
    for (file in fileList) {
        if (file.value & check) {
            println "$file.key (${displayFilePermission(file.value)}) meets criteria"
        }
    }
}

def displayFilePermission(val) {
    def retval = ""
    retval <<= (READ & val)? 'r': '-'
    retval <<= (WRITE & val)? 'w': '-'
    retval <<= (EXECUTE & val)? 'x': '-'
    return retval
}
```

>Please note that I'm not really happy with my example (above) but it's the best I could come up with.

First up I set the flags for each of the three elements:

```groovy
READ = 4      //100
WRITE = 2     //010
EXECUTE = 1   //001
```

I then call my `checkFile` method to see which permissions match what I'm seeking. The third call to `checkFile` is the more interesting as I OR two flags: `READ | EXECUTE`. If I OR the READ flag (`100`) with the  EXECUTE flag (`001`) I get `101` (decimal 5):

| Value	| Binary ||| Operator|
|-----------------	| :--:	| :--:	| :--:	| :--:	| 
| READ	| 1	| 0	| 0	| OR	| 
| EXECUTE	| 0	| 0	| 1	| 	|  
| __Result__	| __1__	| __0__	| __1__	| __=__	|  

The `checkFile` method does the checking for me. The first part of the method just creates a set of possible files - enough to cover the various variations of the `rwx` elements:

```groovy
    def fileList = [:]
    for (i in 0..7) {
        fileList["File $i"] = i
    }
```

>Creating `fileList` each time the method is called is inefficient - that's why copying tutorial code into your production system is a bad idea :)

It's the second half of `checkFile` that does the important stuff:

```groovy
    for (file in fileList) {
        if (file.value & check) {
            println "$file.key (${displayFilePermission(file.value)}) meets criteria"
        }
    }
```

The `if (file.value & check)` performs an AND on the check requested (e.g. `READ`) and the file's permissions. If the AND returns a result greater than `0` then the file's permission match the `check`. For example, a file with execute permission (`--x`) meets the `READ | EXECUTE` criteria:

|Item| Value	| Binary ||| Operator|
|:----:|-----------------	| :--:	| :--:	| :--:	| :--:	| 
|`check`| READ \| EXECUTE	| 1	| 0	| 1	| AND	| 
|`file`| `--x`	| 0	| 0	| 1	| 	|  
| | __Result__	| __0__	| __0__	| __1__	| __=__	| 

A file with read and write permission (`rw-`) also matches:

|Item| Value	| Binary ||| Operator|
|:----:|-----------------	| :--:	| :--:	| :--:	| :--:	| 
|`check`| READ \| EXECUTE	| 1	| 0	| 1	| AND	| 
|`file`| `rw-`	| 1	| 1	| 0	| 	|  
| | __Result__	| __1__	| __0__	| __0__	| __=__	| 

However, a file with only the write permission (`-w-`) will not successfully match:

|Item| Value	| Binary ||| Operator|
|:----:|-----------------	| :--:	| :--:	| :--:	| :--:	| 
|`check`| READ \| EXECUTE	| 1	| 0	| 1	| AND	| 
|`file`| `-w-`	| 0	| 1	| 0	| 	|  
| | __Result__	| __0__	| __0__	| __0__	| __=__	| 

Lastly, the `displayFilePermission` method just helps me display the permissions in the `rwx` format.

Some other quick points follow:

I can negate (`~`) a value to indicate that I want the inverse of a value, rather than ORing the other options individually:
:
```groovy
println 'Checking for WRITE or EXECUTE:'
checkFile(~READ)
```

I can XOR (`^`) to aggregate the permissions but ignore intersections (where both variables contain the same flag): 
:
```groovy
def file1 = READ | EXECUTE
def file2 = WRITE | EXECUTE
println 'File 1: ' << displayFilePermission(file1)
println 'File 2: ' << displayFilePermission(file2)
println 'Result: ' << displayFilePermission(file1 ^ file2)
```

# Shift Example

Shifting just moves the bits in a binary to the left (`<<`) or to the right (`>>`), depending on the left-hand operand. If we take the following list as a starting point we can see how progressive shifts left change a value:

- 0001 (binary) = 1 (decimal)
- 0010 (binary) = 2 (decimal)
- 0100 (binary) = 4 (decimal)
- 1000 (binary) = 8 (decimal)

With this is mind the following code demonstrates the left- and right-shift operators:

```groovy
assert 2 << 1 == 4	//Left-shift once
assert 2 << 2 == 8	//Left-shift twice
assert 2 >> 1 == 1	//Right-shift once
```

The code below displays a table in which each row represents a value that's be left-shifted by one position more than the prior row:

```groovy
def value = 0x0000FF    //Binary: 0000 0000 0000 0000 1111 1111

println '| Shift   | Hex      | Decimal  | Octal    | Binary                   |'
println '|---------|----------|----------|----------|--------------------------|'
(0..16).each {
    def shifted = value << it
    def hexDisplay = '0x' << Integer.toHexString(shifted).padLeft(6, '0')
    def binDisplay = Integer.toBinaryString(shifted).padLeft(24, '0')
    def decDisplay = "$shifted".padLeft(8, ' ')
    def octDisplay = Integer.toOctalString(shifted).padLeft(8, ' ')
    def shiftDisplay = "$it".padLeft(7, ' ')
    println "| $shiftDisplay | $hexDisplay | $decDisplay | $octDisplay | $binDisplay |"
}
println '|---------|----------|----------|----------|--------------------------|'
```

>Whilst it may not be an overly useful example you can also see the methods for displaying numbers using different number systems (hexadecimal, octal, decimal and binary)