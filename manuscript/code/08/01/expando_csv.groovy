//This is a basic CSV (Comma-separated file)  described as a string
def table = '''\
	name,email,phone
	Fred,fred@email.com,555-678345
	Alex,alex@email.com,555-987123
	Simon,simon@example.com,555-567321
	'''

//We define the separator as the comma character
def separator = ','

//Read the CSV in and break it up by linebreaks
def csv = table.tokenize()

//Extract the first row - it contains the headers (field names)
header = csv[0].tokenize(separator)
csv.remove(0)

def contactList = [ ]

for (row in csv) {

    Expando contact = new Expando()

    //Now setup the contact class with field names based on the header
    row.tokenize(separator).eachWithIndex { key, value ->
        contact.setProperty header[value], key
    }

    contact.getVCard = {
        """BEGIN:VCARD
            VERSION:4.0
            N:$name
            EMAIL:$email
            TEL;TYPE=work,voice;VALUE=uri:tel:$phone
            END:VCARD"""
    }
    contactList << contact
}

contactList.each {
    println it.vcard
}
