class Person {
    String name

    Person(String name) {
        this.name = name
    }
}

class SuperHero extends Person {
    String superHeroName

    SuperHero(String name, String superHeroName) {
        super(name)
        this.superHeroName = superHeroName
    }
}

SuperHero groovyMan = new SuperHero('Gary Grails', 'Groovy Man!')

assert groovyMan.name == 'Gary Grails'
assert groovyMan.superHeroName == 'Groovy Man!'
