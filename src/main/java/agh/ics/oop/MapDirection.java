package agh.ics.oop;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;
    @Override
    public String toString(){
        switch(this){
            case EAST -> {
                return "Wschód";
            }
            case WEST -> {
                return "Zachód";
            }
            case NORTH -> {
                return "Północ";
            }
            case SOUTH -> {
                return "Południe";
            }
            default -> {
                return "Invalid direction";
            }
        }
    }
    public MapDirection next(){
        switch(this){
            case EAST -> {
                return SOUTH;
            }
            case WEST -> {
                return NORTH;
            }
            case NORTH -> {
                return EAST;
            }
            default -> {
                return WEST;
            }
        }
    }
    public MapDirection previous(){
        switch(this){
            case EAST -> {
                return NORTH;
            }
            case WEST -> {
                return SOUTH;
            }
            case NORTH -> {
                return WEST;
            }
            default -> {
                return EAST;
            }
        }
    }
    public Vector2d toUnitVector(){
        switch(this){
            case EAST -> {
                return new Vector2d(1, 0);
            }
            case WEST -> {
                return new Vector2d(-1, 0);
            }
            case NORTH -> {
                return new Vector2d(0, 1);
            }
            case SOUTH -> {
                return new Vector2d(0, -1);
            }
            default -> {
                return null;
            }
        }
    }
}
