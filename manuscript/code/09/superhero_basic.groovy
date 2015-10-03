class Person {
    String name

    String toString() {
        "Name: $name"
    }
}

class SuperHero extends Person {
    String superHeroName

    String toString() {
        "Name: $superHeroName (alias: $name)"
    }
}

SuperHero groovyMan = new SuperHero(name: 'Gary Grails', superHeroName: 'Groovy Man!')

println groovyMan
