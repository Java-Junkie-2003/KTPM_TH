package OrderStateManagementSystem;

public class DeliveredOrder implements OrderState{
    @Override
    public String printStatus() {
        return DeliveredOrder.class.getSimpleName();
    }

    @Override
    public OrderState preState() {
        return new ProcessingOrder();
    }

    @Override
    public OrderState nextState() {
        return new CancelOrder();
    }

    @Override
    public String printDescription() {
        return "Order has been delivered";
    }
}
