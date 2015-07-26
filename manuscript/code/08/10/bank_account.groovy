class BankAccount {

    private Integer balance = 0

    Integer withdrawal(amount) {
        if (amount > balance) {
            throw new Exception('Insufficient balance')
        }

        balance -= amount
    }

    Integer deposit(amount) {
        balance += amount
    }
}

def acct = new BankAccount()
acct.deposit(100)
acct.withdrawal(150)
