package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {
    Label label = new Label("Zwierzak");
    Scene scene = new Scene(label, 400, 400);
    private AbstractWorldMap map;
    @Override
    public void init(){
        map = new GrassField(10);
        map.place(new Animal(map, new Vector2d(0, 0)));
        map.place(new Animal(map, new Vector2d(3,4)));
    }
    private void fillGrid(GridPane grid, String text, Integer x, Integer y){
        label = new Label(text);
        grid.add(label, x, y, 1, 1);
        GridPane.setHalignment(label, HPos.CENTER);
        GridPane.setValignment(label, VPos.CENTER);
    }
    private void createScene(){
        Vector2d l = map.getLowerLeft();
        Vector2d r = map.getUpperRight();

        // Creating grid
        GridPane grid = new GridPane();
        fillGrid(grid, "y/x", 0, 0);
        grid.getColumnConstraints().add(new ColumnConstraints(20));
        grid.getRowConstraints().add(new RowConstraints(20));

        // Setting x-axis
        Integer x = l.getX();
        int i = 1;
        while(x <= r.getX()){
            fillGrid(grid, x.toString(), i, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(20));
            i++;
            x++;
        }
        // Setting y-axis
        Integer y = r.getY();
        i = 1;
        while(y >= l.getY()){
            fillGrid(grid, y.toString(), 0, i);
            grid.getRowConstraints().add(new RowConstraints(20));
            i++;
            y--;
        }

        // Putting elements on grid
        grid.setGridLinesVisible(true);
        for(Vector2d e: map.elements.keySet()){
            fillGrid(grid, map.elements.get(e).toString(),e.getX() - l.getX() + 1, r.getY() - e.getY() + 1);
        }

        grid.setAlignment(Pos.CENTER);
        scene = new Scene(grid, 500, 500);
    }
    public void start(Stage primaryStage){
        primaryStage.setTitle("Zwierzak");
        createScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

