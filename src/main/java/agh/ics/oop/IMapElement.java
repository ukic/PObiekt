package agh.ics.oop;

public interface IMapElement {
    String toString();
    Vector2d getPosition();
    void setPosition(Vector2d position);
    boolean isAt(Vector2d position);
}
