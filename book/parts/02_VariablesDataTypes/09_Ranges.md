---
title: Ranges
...
Ranges define a starting point, an end and the size of the steps in between. Let's look at a well-known type of range:

```groovy
def countdown = 10..0

println countdown.getFrom()
println countdown.getTo()
```

The `countdown` range starts at 10 and goes down to 0. The notation should be easy to decipher: `<start>..<end>`.

Ranges are most often see when we're using loops - we'll get to them in a bit.
