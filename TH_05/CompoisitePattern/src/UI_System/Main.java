package UI_System;

public class Main {
    public static void main(String[] args) {
        BasicComponent label = new LabelComponent("Hello World");
        label.render();

        BasicComponent button = new ButtonComponent("Click me");
        button.render();

        System.out.println("==================Panel===================");
        PanelComponent panel = new PanelComponent("UI Panel");
        panel.addComponent(label);
        panel.addComponent(button);
        panel.render();

    }
}
