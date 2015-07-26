class Person {
    def name
    def email
    def mobile
}

def astrid = new Person()
astrid.name = 'Astrid Smithson'
astrid.email = 'astrid@example.com'
astrid.mobile = '0418 111 222'

println astrid.dump()
