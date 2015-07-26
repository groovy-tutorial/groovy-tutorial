List findPrimes(List list, Closure closure) {
    def result = [ ]
    list.each {
        def isPrime = true
        if (it != 2) {
            for (divisor in (2..it / 2)) {
                if (it % divisor == 0) {
                    isPrime = false
                    break
                }
            }
        }
        if (isPrime) {
            result << it
            closure(it)
        }
    }
    result
}

def primes = findPrimes 0..100, { println "I found a prime: $it" }

println primes
