class Person {
    def name
    def email
    def mobile

    void setEmail(email) throws IllegalArgumentException {
        def regex = ~/[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+/
        if (email.matches(regex)) {
            this.email = email
            return
        }
        throw new IllegalArgumentException('Incorrect email format')
    }
}

def jess = new Person()

jess.setEmail('jess@example.com')
println jess.dump()

//This will fail
jess.setEmail('jess_at_example.com')
println jess.dump()
