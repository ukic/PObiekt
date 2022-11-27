package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, AbstractWorldElement> elements = new HashMap<>();
    protected Vector2d lowerLeft = new Vector2d(0,0);
    protected Vector2d upperRight = new Vector2d(0,0);
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);
    public boolean canMoveTo(Vector2d position) {
        if(position == null){throw new IllegalArgumentException("New position cannot be null");}
        return !isOccupied(position);
    }
    public boolean place(Animal animal){
        if(animal == null){
            throw new IllegalArgumentException("An animal cannot be null!");
        }
        if(canMoveTo(animal.getPosition())){
            elements.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position){
        return elements.containsKey(position);
    }
    public Object objectAt(Vector2d position){
        if(elements.containsKey(position)){
            return elements.get(position);
        }
        return null;
    }
    public String toString(){
        return mapVisualizer.draw(lowerLeft, upperRight);
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        AbstractWorldElement el = elements.get(oldPosition);
        elements.remove(oldPosition);
        elements.put(newPosition, el);
    }
}
