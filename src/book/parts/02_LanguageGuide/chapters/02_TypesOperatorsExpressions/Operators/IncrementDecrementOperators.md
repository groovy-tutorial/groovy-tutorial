## Increment and Decrement Operators

Operator|Name     
:------:|:--------
++      |Increment
--      |Decrement

The increment and decrement operators come in two flavours: prefix and postfix.

    def counter = 1
    counter++
    assert counter == 2


    def counter = 1
    def next = ++counter
    assert next == 2
    assert counter == 2
