def vampire = [ : ]
vampire.name = 'Dracula'

vampire.scareVillage = { village ->
    println "Look out $village here comes $vampire.name!"
}

vampire.scareVillage('London')
