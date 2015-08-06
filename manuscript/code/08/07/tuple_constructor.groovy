@groovy.transform.TupleConstructor
class Person {
    def name = 'Anonymous'
    def email
    def mobile
}

def unknown = new Person()
def astrid = new Person('Astrid Smithson')
def john = new Person('John Hancock', 'john@example.com')
def kelly = new Person('Kelly Grant', 'kelly@example.com', '044 555 555')
def dave = new Person(name: 'Dave Smith', email: 'dave@example.com')
