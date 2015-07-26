class SampleText {
    def text
}

def shakespeare = new SampleText(text: 'It was the best of times....')
def marlow = shakespeare
shakespeare = null
println marlow.text
