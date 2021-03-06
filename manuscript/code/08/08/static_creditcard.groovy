@Grab('org.javamoney:moneta:1.0')

import groovy.transform.ToString
import org.javamoney.moneta.Money

@ToString(includeNames = true)
class SilverCreditCard {
    String cardNumber
    String cardHolderName
    Money balance = Money.of(0, currency)

    static String currency = 'AUD'
    static Money creditLimit = Money.of(5_000, currency)

    static SilverCreditCard applyForAccount(String applicantName, Money totalAssets, Money totalDebts) {
        if (totalAssets.subtract(totalDebts).subtract(creditLimit).isPositive()) {
            // TODO: Create a new record in the database etc
            return new SilverCreditCard(cardNumber: '0000 1111 2222 3333', cardHolderName: applicantName)
        } else {
            // TODO: Throw an exception - don't just return null
            return null
        }
    }

    static SilverCreditCard loadAccount(String cardNumber) {
        // TODO: Lookup the number in our database
        new SilverCreditCard(cardNumber: cardNumber, cardHolderName: 'Fred Nurk', balance: Money.of(100, currency))
    }

    Money deposit(Money amt) {
        //TODO: Implement
    }

    Money withdrawl(Money amt) {
        //TODO: Implement
    }
}

SilverCreditCard yourCard = SilverCreditCard.loadAccount('1234 5678 9876 5432')
println yourCard

SilverCreditCard myCard = SilverCreditCard.applyForAccount('Jim Smith',
        Money.of(20_000, SilverCreditCard.currency),
        Money.of(10_000, SilverCreditCard.currency))

println myCard
