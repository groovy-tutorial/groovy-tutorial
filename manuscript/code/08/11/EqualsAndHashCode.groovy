@groovy.transform.EqualsAndHashCode(includes='id')
class Person {
    def id
    def name
}

def agentSmith = new Person(id: 414, name: 'Agent Smith')
def agentSmith2 = new Person(id: 414, name: 'Agent X')

assert agentSmith == agentSmith2
