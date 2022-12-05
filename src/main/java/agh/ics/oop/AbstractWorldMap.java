package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    public Map<Vector2d, AbstractWorldElement> elements = new HashMap<>();
    protected MapBoundary mapBoundary;
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
            mapBoundary.addElement(animal.getPosition());
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
    public Vector2d getLowerLeft(){
        return mapBoundary.getLowerLeft();
    }
    public Vector2d getUpperRight(){
        return mapBoundary.getUpperRight();
    }
    public String toString(){
        return mapVisualizer.draw(mapBoundary.getLowerLeft(), mapBoundary.getUpperRight());
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        AbstractWorldElement el = elements.get(oldPosition);
        elements.remove(oldPosition);
        elements.put(newPosition, el);
        mapBoundary.positionChanged(oldPosition, newPosition);
    }
}
