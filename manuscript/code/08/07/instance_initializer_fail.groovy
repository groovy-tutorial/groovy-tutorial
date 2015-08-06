class Person {
    private Integer id
    private String name = 'Anonymous'

    {
        this.id = UUID.randomUUID()
    }
}

Person fred = new Person(name: 'Fred')
