class Person {
    private UUID id
    private String name = 'Anonymous'

    ;{
        this.id = UUID.randomUUID()
    }
}

Person fred = new Person(name: 'Fred')
println fred.dump()
