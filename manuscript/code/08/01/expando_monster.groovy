def monster = new Expando()

monster.with {
    //Let's add some properties
    name = 'Dr Frankensteins Monster'
    owner = 'Dr Frankenstein'
    height = 8

    //Add some closures (methods)
    getOwner = { owner }
    getName = { name }
    getHeight = { height }

    scareVillage = { village ->
        println "Look out $village here comes $name!"
    }
}

monster.scareVillage('Darmstadt')
