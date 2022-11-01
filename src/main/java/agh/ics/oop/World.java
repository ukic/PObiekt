package agh.ics.oop;

public class World {
    public static void main(String[] args){
        Animal animal = new Animal();
        System.out.println(animal.toString());
        OptionsParser parser = new OptionsParser();
        MoveDirection[] md = parser.parse(args);
        for(MoveDirection move : md){
            animal.move(move);
        }
        System.out.println(animal.toString());
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
