class Person {
    def name
    def email
    def mobile
}

def astrid = [name: 'Astrid Smithson', email: 'astrid@example.com'] as Person
println astrid.dump()

Person gretchen = [name: 'Gretchen Gaul', email: 'gretchen@example.com']
println gretchen.dump()
