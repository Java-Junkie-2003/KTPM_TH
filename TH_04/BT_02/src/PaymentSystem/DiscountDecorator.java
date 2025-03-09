package PaymentSystem;

import java.math.BigDecimal;

public class DiscountDecorator extends PaymentDecorator {

    private BigDecimal discount;

    public DiscountDecorator(PaymentStrategy paymentStrategy, BigDecimal discount) {
        super(paymentStrategy);
        this.discount = discount;
    }

    @Override
    public void pay(BigDecimal amount) {
        BigDecimal newAmount = amount.subtract(discount);
        System.out.println("Paying " + newAmount + " after discount of " + discount);
        super.pay(newAmount);
    }
}
