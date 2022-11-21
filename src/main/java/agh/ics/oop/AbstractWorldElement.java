package agh.ics.oop;

abstract class AbstractWorldElement implements IMapElement {
    private Vector2d position;
    public Vector2d getPosition(){
        return position;
    }
    public void setPosition(Vector2d position){
        this.position=position;
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public abstract String toString();
}
