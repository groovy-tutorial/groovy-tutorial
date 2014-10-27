def struct = [
    australia: [
        name: 'Australia',
        capital: [
            name: 'Canberra',
            location:[
                lat: 22,
                'long': 22
            ]
        ]
    ]
]

println 'JSON Format:'
def json = new groovy.json.JsonBuilder()
json.countries struct
println json.toPrettyString()