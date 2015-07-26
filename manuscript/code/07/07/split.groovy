def players = [
        [name: 'Fred', topScore: 120],
        [name: 'Sally', topScore: 200],
        [name: 'Felix', topScore: 101],
        [name: 'Albert', topScore: 12],
        [name: 'Jane', topScore: 20]
]

def result = players.split {it.topScore > 100}

result[0].each {println "$it.name is in the hall of fame"}

result[1].each {println "$it.name missed out"}