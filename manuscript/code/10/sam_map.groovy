def myInfo = [ name: 'Jane',
               pet : 'Mittens' ] as ObservableMap

myInfo.addPropertyChangeListener { evt ->
    println "$evt.propertyName was changed: from $evt.oldValue to $evt.newValue"
}

myInfo.pet = 'Fido'
