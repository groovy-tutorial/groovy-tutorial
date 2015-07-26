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

    private setBalance(amount) {

    }
}

def acct = new BankAccount(balance: 200)
assert acct.balance == 0

def acct2 = new BankAccount()
acct.balance = 100
assert acct2.balance == 0
