class Country {
    def name, capital
}

class City {
    def name, location
}

class Location {
    def lattitude, longitude, hemisphere
    
    
}

def au = new Country(name: 'Australia', 
            capital: new City(
                name: 'Canberra',
                location: new Location (
                    lattitude: 22,
                    longitude: 22,
                    hemisphere: 'south'
                )
            )
        )

def nz = new Country(name: 'New Zealand', 
            capital: new City(
                name: 'Wellington',
                location: new Location (
                    lattitude: 22,
                    longitude: 22,
                    hemisphere: 'south'
                )
            )
        )
        
def struct = [
    countries: [au, nz]    
]

def json = new groovy.json.JsonBuilder(struct)
println json.toPrettyString()
