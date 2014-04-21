### Type Comparison Operator

The `instanceof` operator . The left-hand operand is 

The assertions in the following code all resolve as `true`

    Integer age = 27
    assert age instanceof Integer
    
    class Location {}
    class Country extends Location{}
    Country australia = new Country()
    assert australia instanceof Country
    assert australia instanceof Location