class Person {
    private String name
    final setName(name) {}
}

class SuperHero extends Person {
    final String getName() {
        'Unknown'
    }
}

class BizarroSuperHero extends SuperHero {

    //This will NOT be allowed:
    String getName() {
        name
    }
}

