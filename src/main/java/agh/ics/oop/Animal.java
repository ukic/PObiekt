package agh.ics.oop;

public class Animal extends AbstractWorldElement{
    private MapDirection currentDirection = MapDirection.NORTH;
    private final IWorldMap map;
    public Animal(IWorldMap map){
        super();
        if (map==null){
            throw new IllegalArgumentException("Invalid argument for Object Animal");
        }
        this.map = map;
        setPosition(new Vector2d(2,2));
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        super();
        if(map == null || initialPosition == null){
            throw new IllegalArgumentException("Invalid argument for Object Animal");
        }
        else{
            this.map = map;
            setPosition(initialPosition);
        }
    }
    @Override
    public String toString(){
        return currentDirection.toSymbol();
    }
    public MapDirection getDirection(){
        return currentDirection;
    }
    public void move(MoveDirection direction) {
        Vector2d vec = null;
        switch (direction) {
            case LEFT -> currentDirection = currentDirection.previous();
            case RIGHT -> currentDirection = currentDirection.next();
            case FORWARD -> vec = getPosition().add(currentDirection.toUnitVector());
            case BACKWARD -> vec = getPosition().subtract(currentDirection.toUnitVector());
        }
        if (direction.ordinal() < 2 && map.canMoveTo(vec)) {
            positionChanged(vec);
        }
    }
}
