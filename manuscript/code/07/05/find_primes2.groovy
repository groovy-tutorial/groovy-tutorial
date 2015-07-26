List findPrimes(List list, Closure closure) {
    def result = []
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
            result << num
            closure(num)
        }
    }
    return result
}

def primes = findPrimes 0..100, { println "I found a prime: $it" }