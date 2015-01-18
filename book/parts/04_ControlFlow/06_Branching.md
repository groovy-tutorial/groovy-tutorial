---
title:	Branching statements
description:	
---


# `break`
The `break` reserved word is used to exit out of a loop  - even if there are more iterations possible.

```groovy
def planets = [
    'Mercury',
    'Venus',
    'Earth',
    'Mars'
]

for (planet in planets) {
    println planet
    if (planet == 'Earth') {
        break
    }
}
```

# `continue`
The `continue` reserved word will cause the next iteration of the loop - ignoring anything within the rest of the current iteration.

```groovy
def planets = [
    'Mercury',
    'Venus',
    'Earth',
    'Mars'
]

for (planet in planets) {
    if (planet == 'Earth') {
        continue
    }
    println planet
}
```

# `return`

