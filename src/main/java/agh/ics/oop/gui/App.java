package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application{
    Label label = new Label("Animal");
    IObserver observer;
    Vector2d l, r;
    GridPane grid = new GridPane();
    Scene scene = new Scene(label, 400, 400);
    private AbstractWorldMap map;
    Thread engineThread;
    public void init(){
        observer = new SimulationObserver(this);
    }
    private void addElementToGrid(GridPane grid, Node gui, Integer x, Integer y){
        grid.add(gui, x, y, 1, 1);
    }
    private void fillGridAxes(GridPane grid, String text, Integer x, Integer y){
        label = new Label(text);
        grid.add(label, x, y, 1, 1);
        GridPane.setHalignment(label, HPos.CENTER);
        GridPane.setValignment(label, VPos.CENTER);
    }
    private void createGridAxes(){
        l = map.getLowerLeft();
        r = map.getUpperRight();

        fillGridAxes(grid, "y/x", 0, 0);
        grid.getColumnConstraints().add(new ColumnConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));

        // Setting x-axis
        Integer x = l.getX();
        int i = 1;
        while(x <= r.getX()){
            fillGridAxes(grid, x.toString(), i, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(50));
            i++;
            x++;
        }

        // Setting y-axis
        Integer y = r.getY();
        i = 1;
        while(y >= l.getY()){
            fillGridAxes(grid, y.toString(), 0, i);
            grid.getRowConstraints().add(new RowConstraints(50));
            i++;
            y--;
        }
    }
    private void putWorldElements(){
        for(Vector2d e: map.elements.keySet()) {
            Node gui = new GuiElementBox(map.elements.get(e)).getGUIElement();
            addElementToGrid(grid, gui,e.getX() - l.getX() + 1, r.getY() - e.getY() + 1);
        }
    }
    private void fillGrid() {
        createGridAxes();
        putWorldElements();

        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
    }
    private void createPrimaryScene(){
        BorderPane border = new BorderPane();

        Slider slider = new Slider(1, 100, 10);
        Label sliderNumber = new Label("Number of grass fields on map: 10");

        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(1);
        slider.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    slider.setValue(newValue.intValue());
                    sliderNumber.setText("Number of grass fields on map: " + slider.getValue());
                });

        VBox vBox = new VBox(slider, sliderNumber);
        vBox.setSpacing(10);

        TextField textField = new TextField("Enter animal moves");

        Button button = new Button("Start");
        button.setOnAction(event -> {
            map = new GrassField(slider.valueProperty().intValue());
            SimulationEngine engine = new SimulationEngine(map, new OptionsParser().parse(textField.getText().split(" ")),
                    new Vector2d[]{new Vector2d(0, 0), new Vector2d(3, 4)});
            fillGrid();
            engine.setObserver(observer);
            engineThread = new Thread(engine);
            engineThread.start();
        });

        HBox hBox = new HBox(button, vBox, textField);
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);
        border.setTop(hBox);
        border.setCenter(grid);
        scene = new Scene(border, 1000, 1000);
    }
    public void updateGrid() {
        grid.setGridLinesVisible(false);
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.getChildren().clear();

        fillGrid();
    }

    public void start(Stage primaryStage){
        createPrimaryScene();
        primaryStage.setTitle("Animal moves");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

