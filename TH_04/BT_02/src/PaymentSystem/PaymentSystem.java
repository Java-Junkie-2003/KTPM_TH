package PaymentSystem;

import java.math.BigDecimal;

public class PaymentSystem {
    public static void main(String[] args) {
        PaymentStrategy creditCardPayment = new CreditCardPayment();
        creditCardPayment = new ProcessingFeeDecorator(creditCardPayment, new BigDecimal("10.00"));
        creditCardPayment = new DiscountDecorator(creditCardPayment, new BigDecimal("5.00"));
        BigDecimal amount = new BigDecimal("100.00");
        System.out.println("Initial amount: " + amount);
        creditCardPayment.pay(amount);
    }
}
