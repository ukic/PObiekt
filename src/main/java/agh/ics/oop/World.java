package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args){
        try {
            /*MoveDirection[] directions = new OptionsParser().parse(args);
            //IWorldMap map = new RectangularMap(10, 5);
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(0, 0), new Vector2d(3,4)};
            IEngine engine = new SimulationEngine(map, directions, positions);
            engine.run();*/
            Application.launch(App.class, args);
        }
        catch(IllegalArgumentException ex){
            System.out.println("Illegal argument");
        }
        catch(NullPointerException ex) {
            System.out.println("Null cannot be an argument");
        }
    }
    public static Direction[] conv(String[] moves) {
        Direction[] d = new Direction[moves.length];
        for(int i = 0; i < moves.length; i++){
            Direction m = switch(moves[i]){
                case "f" -> Direction.f;
                case "b" -> Direction.b;
                case "r" -> Direction.r;
                case "l" -> Direction.l;
                default -> Direction.u;
            };
            d[i] = m;
        }
        return d;
    }
    public static void run(Direction[] args){
        for(Direction argument: args){
            String message = switch (argument) {
                case f -> "Zwierzak idzie do przodu";
                case b -> "Zwierzak idzie do tyłu";
                case r -> "Zwierzak idzie w prawo";
                case l -> "Zwierzak idzie w lewo";
                case u -> "";
            };
            System.out.println(message);
        }
    }
}
