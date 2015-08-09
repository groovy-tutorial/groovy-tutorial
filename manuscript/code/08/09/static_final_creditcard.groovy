@Grab('org.javamoney:moneta:1.0')

import groovy.transform.ToString
import org.javamoney.moneta.Money

@ToString(includeNames = true)
class SilverCreditCard {
    final String cardNumber
    final String cardHolderName
    Money balance

    static final String CURRENCY = 'AUD'
    static final Money CREDIT_LIMIT = Money.of(5_000, CURRENCY)

    SilverCreditCard(String cardNumber, String cardHolderName, Money balance = Money.of(0, CURRENCY)) {
        this.cardNumber = cardNumber
        this.cardHolderName = cardHolderName
        this.balance = balance
    }

    static SilverCreditCard applyForAccount(String applicantName, Money totalAssets, Money totalDebts) {
        if (totalAssets.subtract(totalDebts).subtract(CREDIT_LIMIT).isPositive()) {
            // TODO: Create a new record in the database etc
            return new SilverCreditCard('0000 1111 2222 3333', applicantName)
        } else {
            // TODO: Throw an exception - don't just return null
            return null
        }
    }

    static SilverCreditCard loadAccount(String cardNumber) {
        // TODO: Lookup the number in our database
        new SilverCreditCard(cardNumber, 'Fred Nurk', Money.of(100, CURRENCY))
    }

    Money deposit(Money amt) {
        //TODO: Implement
    }

    Money withdrawl(Money amt) {
        //TODO: Implement
    }
}

SilverCreditCard myCard = SilverCreditCard.applyForAccount('Jim Smith',
        Money.of(20_000, SilverCreditCard.CURRENCY),
        Money.of(10_000, SilverCreditCard.CURRENCY))

println myCard

SilverCreditCard yourCard = SilverCreditCard.loadAccount('1234 5678 9876 5432')
println yourCard
