def max = { num1, num2 ->
    if (num1 >= num2) {
        num1
    } else if (num2 > num1) {
        num2
    }
}

println max(14, 6)