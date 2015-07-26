def scores = [2, 4, 6, 8, 10]
def total = 0
def average = 0

for (i in scores) {
    total += i
}

average = total / scores.size

println "The average of the scores ($scores) is $average"

scores.each {
    print "The value $it is "

    if (it > average) {
        println 'above average'
    } else if (it < average) {
        println 'below average'
    } else {
        println 'average'
    }
}