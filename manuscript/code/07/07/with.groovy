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

def john = new Person()

john.with {
    name = 'John Smith'
    email = 'john@example.com'
    mobile = '0401 999 888'
    printBusinessCard()
}
