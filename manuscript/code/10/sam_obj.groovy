interface Command {
    public void handle(String eventTitle)
}

class Invoker {
    private final commands = [ ]

    void addReceiver(Command command) {
        this.commands << command
    }

    private void event(String title) {
        commands.each { cmd ->
            cmd.handle(title)
        }
    }

    void onClickEvent() {
        event('Clicked')
    }

    void onDoubleClickEvent() {
        event('Double Clicked')
    }
}

def window = new Invoker()

window.addReceiver(new Command() {
    public void handle(String eventTitle) {
        println "I just received a '$eventTitle' event"
    }
})

window.onClickEvent()
window.onDoubleClickEvent()
