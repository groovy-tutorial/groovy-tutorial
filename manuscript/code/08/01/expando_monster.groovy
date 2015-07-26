def monster = new Expando()

//Let's add some properties
monster.name = 'Dr Frankensteins Monster'
monster.owner = 'Dr Frankenstein'
monster.height = 8

//Add some closures (methods)
monster.getOwner = {owner}
monster.getName = {name}
monster.getHeight = {height}

monster.scareVillage = { village ->
    println "Look out $village here comes $name!"
}

monster.scareVillage('Darmstadt')
