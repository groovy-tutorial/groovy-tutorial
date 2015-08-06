class Person {
    def id
    def name
}

def agentSmith1 = new Person(id: 411, name: 'Agent Smith')
def agentSmith2 = agentSmith1
def agentSmith3 = new Person(id: 411, name: 'Agent Smith')

assert agentSmith1 == agentSmith2
assert agentSmith2 == agentSmith3
