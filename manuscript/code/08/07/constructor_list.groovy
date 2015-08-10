class Person {
    String name
    String email
    String mobile

    Person(name, email) {
        this.name = name
        this.email = email
    }

    Person(name, email, mobile) {
        this(name, email)
        this.mobile = mobile
    }
}

def astrid = ['Astrid Smithson', 'astrid@example.com', '12345'] as Person
println astrid.dump()

Person gretchen = ['Gretchen Gaul', 'gretchen@example.com']
println gretchen.dump()
