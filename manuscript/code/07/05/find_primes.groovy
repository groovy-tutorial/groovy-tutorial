def findPrimes(list, closure) {
    for (num in list) {
        def isPrime = true
        if (num != 2) {
            for (divisor in (2..num/2)) {
                if (num % divisor == 0) {
                    isPrime = false
                    break
                }
            }
        }
        if (isPrime) {
            closure(num)
        }
    }
}

def numList = (1..100)
findPrimes numList, { println "I found a prime: $it" }