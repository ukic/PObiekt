package agh.ics.oop;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
public class MapBoundary implements IPositionChangeObserver{
    private final SortedSet<Vector2d> xAxis = new TreeSet<Vector2d>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d v1, Vector2d v2) {
            if (v1.getX().equals(v2.getX())) {
                return (v1.getY()).compareTo(v2.getY());
            }
            return v1.getX().compareTo(v2.getX());
        }
    });
    private final SortedSet<Vector2d> yAxis = new TreeSet<Vector2d>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d v1, Vector2d v2) {
            if (v1.getY().equals(v2.getY())){
                return (v1.getX()).compareTo(v2.getX());
            }
            return v1.getY().compareTo(v2.getY());
        }
    });
    public MapBoundary(Set<Vector2d> vSet){
        for(Vector2d v:vSet){
            addElement(v);
        }
    }
    public MapBoundary(){}
    public void addElement(Vector2d newElement){
        xAxis.add(newElement);
        yAxis.add(newElement);
    }
    public void removeElement(Vector2d element){
        xAxis.remove(element);
        yAxis.remove(element);
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        removeElement(oldPosition);
        addElement(newPosition);
    }
    public Vector2d getLowerLeft(){
        return new Vector2d(xAxis.first().getX(), yAxis.first().getY());
    }
    public Vector2d getUpperRight(){
        return new Vector2d(xAxis.last().getX(), yAxis.last().getY());
    }
}
