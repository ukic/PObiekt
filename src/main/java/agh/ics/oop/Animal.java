package agh.ics.oop;

public class Animal {
    private Vector2d currentPosition = new Vector2d(2,2);
    private MapDirection currentDirection = MapDirection.NORTH;
    @Override
    public String toString(){
        return "The animal's is looking in the " + currentDirection.toString() + " direction and is on position "
                + currentPosition.toString();
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
        if (direction != null && currentDirection != null) {
            Vector2d vec;
            if (direction.equals(MoveDirection.RIGHT)) {
                currentDirection = currentDirection.next();
            } else if (direction.equals(MoveDirection.LEFT)) {
                currentDirection = currentDirection.previous();
            } else if (direction.equals(MoveDirection.FORWARD)) {
                vec = currentPosition.add(currentDirection.toUnitVector());
                if (vec != null && vec.follows(new Vector2d(0, 0)) && vec.precedes(new Vector2d(4, 4))) {
                    currentPosition = vec;
                }
            } else if (direction.equals(MoveDirection.BACKWARD)) {
                vec = currentPosition.add(currentDirection.toUnitVector().opposite());
                if (vec != null && vec.follows(new Vector2d(0, 0)) && vec.precedes(new Vector2d(4, 4))) {
                    currentPosition = vec;
                }
            }
        }
    }
}
