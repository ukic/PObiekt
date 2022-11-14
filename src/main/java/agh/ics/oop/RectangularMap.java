package agh.ics.oop;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    public Integer width;
    public Integer height;
    public final List<Animal> animals = new ArrayList<>();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    public RectangularMap(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }
    private boolean isPositionOnMap(Vector2d position){
        if (position.x != null && position.y != null){
            return position.x > -1 && position.x <= width && position.y > -1 && position.y <= height ;
        }
        return false;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal an : animals){
            if (an.isAt(position)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return isPositionOnMap(position) && !isOccupied(position);
    }
    @Override
    public boolean place(Animal animal) {
        if(animals.contains(animal)){
            return true;
        }
        if(canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }
    @Override
    public Object objectAt(Vector2d position) {
        for(Animal an : animals){
            if (an.isAt(position)){
                return an;
            }
        }
        return null;
    }
    @Override
    public String toString(){
        return mapVisualizer.draw(new Vector2d(0,0), new Vector2d(width, height));
    }
}
