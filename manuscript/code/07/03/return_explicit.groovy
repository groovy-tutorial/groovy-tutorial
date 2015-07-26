def myClosure = { num1, num2 ->
    if (num1 >= num2) {
        return num1
    } else if (num2 > num1) {
        return num2
    }
}

println myClosure(14, 6)
