package agh.ics.oop;

public class Animal {
    private Vector2d currentPosition = new Vector2d(2,2);
    private MapDirection currentDirection = MapDirection.NORTH;
    private IWorldMap map;
    public Animal(){}
    public Animal(IWorldMap map){
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        if (map.canMoveTo(initialPosition)) {
            currentPosition = initialPosition;
        }
    }
    @Override
    public String toString(){
        return currentDirection.toSymbol();
    }
    public Vector2d getPosition(){
        return currentPosition;
    }

    public boolean isAt(Vector2d position){
        if (position != null){
            return currentPosition.equals(position);
        }
        return false;
    }

    public MapDirection getDirection(){
        return currentDirection;
    }
    public void move(MoveDirection direction){
        Vector2d vec = null;
        if (direction != null && currentDirection != null) {
            switch(direction){
                case LEFT -> currentDirection = currentDirection.previous();
                case RIGHT -> currentDirection = currentDirection.next();
                case FORWARD -> vec = currentPosition.add(currentDirection.toUnitVector());
                case BACKWARD -> vec = currentPosition.subtract(currentDirection.toUnitVector());
            }
            if(direction.ordinal() < 2 && map.canMoveTo(vec)) {
                currentPosition = vec;
            }
        }
    }
}
