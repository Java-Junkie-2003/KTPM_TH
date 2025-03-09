package PaymentSystem;

import java.math.BigDecimal;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Paying " + amount + " using Credit Card");
    }
}
