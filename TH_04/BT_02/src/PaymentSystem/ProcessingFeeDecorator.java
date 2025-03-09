package PaymentSystem;

import java.math.BigDecimal;

public class ProcessingFeeDecorator extends PaymentDecorator{

    private BigDecimal fee;

    public ProcessingFeeDecorator(PaymentStrategy paymentStrategy, BigDecimal fee) {
        super(paymentStrategy);
        this.fee = fee;
    }

    @Override
    public void pay(BigDecimal amount) {
        BigDecimal newAmount = amount.add(fee);
        System.out.println("Adding processing fee to the amount: " + fee);
        super.pay(newAmount);
    }
}
