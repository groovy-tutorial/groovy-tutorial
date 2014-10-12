---
Title:    Built-in features  
Abstract:   
...
# [%Title]

[%Abstract] 

The following libraries are imported into Groovy by default:

- `java.io.*`
- `java.lang.*`
- `java.math.BigDecimal`
- `java.math.BigInteger`
- `java.net.*`
- `java.util.*`
- `groovy.lang.*`
- `groovy.util.*`

Since Groovy 2.3, those running on Java 7 (or later) also have automatic access to `java.nio.*`

Scripts are able to make use of classes within these packages without explicitly importing them.