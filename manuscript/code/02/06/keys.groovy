class Chicken {
    def name

    String toString() {
        return "I am $name".toString()
    }
}

def cluckers = new Chicken(name: 'Cluckers')

def mixedMap = [
        12        : 'Eggs in a carton',
        'chicken' : 'Egg producer',
        (cluckers): 'Head chicken'
]

println mixedMap[12]
println mixedMap.get(12)

println mixedMap.chicken
println mixedMap['chicken']
println mixedMap.get('chicken')

println mixedMap[(cluckers)]
println mixedMap.get(cluckers)

println mixedMap
