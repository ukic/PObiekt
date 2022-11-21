package agh.ics.oop;

public class Animal extends AbstractWorldElement{
    private MapDirection currentDirection = MapDirection.NORTH;
    private IWorldMap map;
    public Animal(){}
    public Animal(IWorldMap map){
        super();
        this.map = map;
        setPosition(new Vector2d(2,2));
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        if(initialPosition != null){
            this.map = map;
            if (map.canMoveTo(initialPosition)) {
                setPosition(initialPosition);
            }
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
        try {
            Vector2d vec = null;
            switch (direction) {
                case LEFT -> currentDirection = currentDirection.previous();
                case RIGHT -> currentDirection = currentDirection.next();
                case FORWARD -> vec = getPosition().add(currentDirection.toUnitVector());
                case BACKWARD -> vec = getPosition().subtract(currentDirection.toUnitVector());
            }
            if (direction.ordinal() < 2 && map.canMoveTo(vec)) {
                setPosition(vec);
            }
        }
        catch (NullPointerException n){
            throw new NullPointerException("Argument is null");
        }

    }
}
