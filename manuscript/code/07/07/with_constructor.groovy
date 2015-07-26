class Person {
    def name
    def email
    def mobile

    def printBusinessCard() {
        println "$name"
        println "e: $email"
        println "m: $mobile"
    }
}

def stacey = new Person().with {
    name = 'Stacey Jane'
    email = 'stacy@example.com'
    mobile = '0401 333 666'
    //This is the same as saying 'return it':
    it
}
stacey.printBusinessCard()
