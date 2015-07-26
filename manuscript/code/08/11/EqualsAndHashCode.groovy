@groovy.transform.EqualsAndHashCode
class Person {
    def name
    def email
    def mobile
}

def agentSmith = new Person(name: 'Agent Smith')
def agentSmith2 = new Person(name: 'Agent Smith')

assert agentSmith == agentSmith2
