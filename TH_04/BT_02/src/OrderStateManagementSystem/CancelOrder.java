package OrderStateManagementSystem;

public class CancelOrder implements OrderState{
    @Override
    public String printStatus() {
        return CancelOrder.class.getSimpleName();
    }

    @Override
    public OrderState preState() {
        return new ProcessingOrder();
    }

    @Override
    public OrderState nextState() {
        return null;
    }

    @Override
    public String printDescription() {
        return "Order is cancelled";
    }
}
