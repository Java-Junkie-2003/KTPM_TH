package PaymentSystem;

import java.math.BigDecimal;

public abstract class PaymentDecorator implements PaymentStrategy{
    protected PaymentStrategy paymentStrategy;
    public PaymentDecorator(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public void pay(BigDecimal amount) {
        this.paymentStrategy.pay(amount);
    }
}
