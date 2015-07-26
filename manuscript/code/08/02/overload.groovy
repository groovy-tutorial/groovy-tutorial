class Math {
    static mean(num1, num2) {
        (num1 + num2) / 2
    }

    static mean(...nums) {
        nums.sum() / nums.size()
    }

}
println Math.mean(10, 20)
println Math.mean(2, 4, 6, 8)