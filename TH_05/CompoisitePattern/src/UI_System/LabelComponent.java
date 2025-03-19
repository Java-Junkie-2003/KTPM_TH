package UI_System;

public class LabelComponent implements BasicComponent{
    private String text;

    public LabelComponent(String text){
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println("Label: " + text);
    }
}
