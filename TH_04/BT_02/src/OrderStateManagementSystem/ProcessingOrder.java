package OrderStateManagementSystem;

public class ProcessingOrder implements OrderState{
    @Override
    public String printStatus() {
        return ProcessingOrder.class.getSimpleName();
    }

    @Override
    public OrderState preState() {
        return new NewOrder();
    }

    @Override
    public OrderState nextState() {
        return new DeliveredOrder();
    }

    @Override
    public String printDescription() {
        return "Order is being processed";
    }
}
