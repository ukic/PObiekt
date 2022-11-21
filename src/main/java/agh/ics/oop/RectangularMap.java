package agh.ics.oop;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    private final Integer width;
    private final Integer height;

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
    public boolean canMoveTo(Vector2d position) {
        if(position == null){return false;}
        return isPositionOnMap(position) && super.canMoveTo(position);
    }
    @Override
    public String toString(){
        lowerLeft = new Vector2d(0,0);
        upperRight = new Vector2d(width, height);
        return super.toString();
    }
}
