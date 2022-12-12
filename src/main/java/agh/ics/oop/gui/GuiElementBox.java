package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.Grass;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox extends Node {
    private final ImageView iv = new ImageView();
    private Text text;
    private final IMapElement element;
    private String getImagePath(){
        if(element instanceof Grass){
            return "grass.png";
        }
        else{
            Animal animal = (Animal) element;
            switch(animal.toString()){
                case "N" -> {
                    return "up.png";
                }
                case "E" -> {
                    return "right.png";
                }
                case "S" -> {
                    return "down.png";
                }
                case "W" -> {
                    return "left.png";
                }
            }
        }
        return null;
    }

    private String getLabel(){
        if(element instanceof Grass){
            return "Trawa";
        }
        else{
            return "Z" + ((Animal) element).getPosition().toString();
        }
    }

    public GuiElementBox(IMapElement element){
        this.element = element;
    }
    private void setImage(){
        Image image;
        try{
            image = new Image(new FileInputStream("src/main/resources/" + getImagePath()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        iv.setImage(image);
        iv.setFitWidth(20);
        iv.setFitHeight(20);
    }
    public void setText(){
        text = new Text(getLabel());
    }

    public VBox getGUIElement(){
        setText();
        setImage();

        VBox vb = new VBox();
        vb.getChildren().add(iv);
        vb.getChildren().add(text);
        vb.setAlignment(Pos.CENTER);
        return vb;
    }
}
