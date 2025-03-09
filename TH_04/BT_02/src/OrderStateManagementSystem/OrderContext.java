package OrderStateManagementSystem;
 class OrderContext {
    private OrderState orderState;

    public OrderContext(){
        this.orderState = new NewOrder();
    }

    public void setOrderState(OrderState orderState){
        this.orderState = orderState;
    }

    public void previous(){
        OrderState preState = this.orderState.preState();
        if(preState != null){
            this.orderState = preState;
        }
    }

    public void next(){
        OrderState nextState = this.orderState.nextState();
        if(nextState != null){
            this.orderState = nextState;
        }
    }
    public String getOrderState(){
        return this.orderState.printStatus();
    }
    public String getOrderDescription(){
        return this.orderState.printDescription();
    }
}
class Client{
    public static void main(String[] args) {
        OrderContext orderContext = new OrderContext();
        System.out.println("Order State: "+orderContext.getOrderState());
        System.out.println("Order Description: "+orderContext.getOrderDescription());
        orderContext.next();
        System.out.println("Order State: "+orderContext.getOrderState());
        System.out.println("Order Description: "+orderContext.getOrderDescription());
        orderContext.next();
        System.out.println("Order State: "+orderContext.getOrderState());
        System.out.println("Order Description: "+orderContext.getOrderDescription());
        orderContext.next();
        System.out.println("Order State: "+orderContext.getOrderState());
        System.out.println("Order Description: "+orderContext.getOrderDescription());
    }
}