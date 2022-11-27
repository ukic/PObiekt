package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldElement implements IMapElement {
    private Vector2d position;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();
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
    public void removeObserver(IPositionChangeObserver observer){
        if(observer != null){
            observers.remove(observer);
        }
    }
    public void addObserver(IPositionChangeObserver observer){
        if(observer != null && !observers.contains(observer)){
            observers.add(observer);
        }
    }
    public void positionChanged(Vector2d newPosition){
        for(IPositionChangeObserver o: observers){
            o.positionChanged(position, newPosition);
        }
        setPosition(newPosition);
    }
}
