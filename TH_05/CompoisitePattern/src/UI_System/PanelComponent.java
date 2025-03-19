package UI_System;

import java.util.ArrayList;
import java.util.List;

public class PanelComponent implements BasicComponent{
    private String label;
    private List<BasicComponent> components;

    public PanelComponent(String label){
        this.label = label;
        this.components = new ArrayList<>();
    }


    public void addComponent(BasicComponent component){
        components.add(component);
    }

    @Override
    public void render() {
        System.out.println("Panel: " + label);
        for(BasicComponent component : components){
            component.render();
        }
    }
}
