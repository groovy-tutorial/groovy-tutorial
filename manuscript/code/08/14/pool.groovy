class PrizePool {

    synchronized amount

    static synchronized pools

    synchronized calculateTotalPool() {
        //synchronized code
    }

    def calculateWinnings() {
        //non-synchronized code
        synchronized (this) {
            //synchronized code
        }
        //non-synchronized code
    }

    static synchronized removePool() {
        //synchronized code
    }

    static addPool() {
        //non-synchronized code
        synchronized (PrizePool) {
            //synchronized code
        }
        //non-synchronized code
    }
}
