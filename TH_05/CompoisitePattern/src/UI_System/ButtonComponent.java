package UI_System;

public class ButtonComponent implements BasicComponent{

    private String label;
    public ButtonComponent(String label){
        this.label = label;
    }

    @Override
    public void render() {
        System.out.println("Button: " + label);
    }
}
