package PaymentSystem;

import java.math.BigDecimal;

public class PaypalPayment implements PaymentStrategy{
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Paying " + amount + " using Paypal");
    }
}
