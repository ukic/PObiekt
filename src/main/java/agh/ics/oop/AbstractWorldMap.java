package agh.ics.oop;

import javax.swing.event.MenuKeyListener;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<AbstractWorldElement> elements = new ArrayList<>();
    protected Vector2d lowerLeft = new Vector2d(0,0);
    protected Vector2d upperRight = new Vector2d(0,0);
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);
    public boolean canMoveTo(Vector2d position) {
        if (position == null){
            return false;
        }
        return !isOccupied(position);
    }
    public boolean place(Animal animal){
        if(animal == null){
            return false;
        }
        if(elements.contains(animal)){
            return false;
        }
        if(animal.getPosition() != null && canMoveTo(animal.getPosition())){
            elements.add(animal);
            return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position){
        if(position == null){
            return false;
        }
        for(AbstractWorldElement a: elements){
            if(a.isAt(position)){
                return true;
            }
        }
        return false;
    }
    public Object objectAt(Vector2d position){
        if(position == null || position.x == null || position.y == null){
            return null;
        }
        for(AbstractWorldElement a: elements){
            if(a.isAt(position)){
                return a;
            }
        }
        return null;
    }
    public String toString(){
        return mapVisualizer.draw(lowerLeft, upperRight);
    }
}
