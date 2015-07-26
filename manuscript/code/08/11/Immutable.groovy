@groovy.transform.Immutable
class Person {
    String name
    String email
    String mobile
}

def krusty = new Person(name: 'Krusty')
krusty.email = 'heyhey@example.com'
