def determineAverage(list) {
    return list.sum() / list.size()
}

def scores = [2, 7, 4, 3]
def result = determineAverage(scores)
println result
