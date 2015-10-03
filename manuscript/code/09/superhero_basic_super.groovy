class Person {
    String name

    String toString() {
        "Name: $name"
    }
}

class SuperHero extends Person {
    String superHeroName

    @Override
    String toString() {
        "Name: $superHeroName\nAlias:\n  ${super.toString()}"
    }
}

SuperHero groovyMan = new SuperHero(name: 'Gary Grails', superHeroName: 'Groovy Man!')

println groovyMan
