package OrderStateManagementSystem;

public class NewOrder implements OrderState{
    @Override
    public String printStatus() {
        return NewOrder.class.getSimpleName();
    }

    @Override
    public OrderState preState() {
        return null;
    }

    @Override
    public OrderState nextState() {
        return new ProcessingOrder();
    }

    @Override
    public String printDescription() {
        return "Checking the order";
    }
}
