interface Event {
    void startEvent()
}

trait Running implements Event {
    @Override
    void startEvent() {
        println 'Start the running event'
    }
}

trait Swimming implements Event {
    @Override
    void startEvent() {
        println 'Start the swimming event'
    }
}

trait Riding implements Event {
    @Override
    void startEvent() {
        println 'Start the riding event'
    }
}

class Pentath
