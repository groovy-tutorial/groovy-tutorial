# Export Plugin
module.exports = (BasePlugin) ->
    # Define Plugin
    class BookPlugin extends BasePlugin
        # Plugin name
        name: 'docpad-plugin-book'
        
        config:
            Book:
                outline: "book.cson"
        
        extendTemplateData: ({templateData}) ->
            	docpad = @docpad
                config = @config
                templateData.getBookParts = () ->
                    book = new Book
                    "Hello"
