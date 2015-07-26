def spyMethod(closure) {
    closure()
}

def code = 'eagle'

//This is the closure
def doubleCross = { println "The code is $code" }

spyMethod(doubleCross)

code = 'badger'
spyMethod(doubleCross)
