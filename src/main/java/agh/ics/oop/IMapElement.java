package agh.ics.oop;

public interface IMapElement {
    public String toString();
    public Vector2d getPosition();
    public void setPosition(Vector2d position);
    public boolean isAt(Vector2d position);
}
