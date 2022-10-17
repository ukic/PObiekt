package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("System wystartował");
        String[] strArray = new String[]{"f", "b", "r"};
        Direction[] dirArray = conv(strArray);
        run(dirArray);
        System.out.println("System zakończył działanie");
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
