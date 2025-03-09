package OrderStateManagementSystem;

public interface OrderState {
    String printStatus();
    OrderState preState();
    OrderState nextState();
    String printDescription();
}
