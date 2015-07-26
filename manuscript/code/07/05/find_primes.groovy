def findPrimes(list, closure) {
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
            closure(it)
        }
    }
}

def numList = (1..100)
findPrimes numList, { println "I found a prime: $it" }
