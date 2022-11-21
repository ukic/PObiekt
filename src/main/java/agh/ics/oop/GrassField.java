package agh.ics.oop;

import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private final int max;
    private int lowX;
    private int lowY;
    private int upX;
    private int upY;
    public GrassField(int n){
        max = (int) Math.sqrt(10*n);
        for(int i=0; i < n; i++){
            elements.add(new Grass(genNewPlace()));
        }
    }
    private void setMapCoordinates(Vector2d vec){
        if(vec.x < lowX){
            lowX = vec.x;
        }
        else if(vec.x > upX){
            upX = vec.x;
        }
        if(vec.y < lowY){
            lowY = vec.y;
        }
        else if(vec.y > upY){
            upY = vec.y;
        }
    }
    private Vector2d genNewPlace(){
        Random random = new Random();
        Vector2d vec = new Vector2d(random.nextInt(max), random.nextInt(max));
        while(isOccupied(vec)){
            vec = new Vector2d(random.nextInt(max), random.nextInt(max));
        }
        setMapCoordinates(vec);
        return vec;
    }
    public boolean canMoveTo(Vector2d position){
        if(position == null){
            return false;
        }
        if(isOccupied(position)){
            Object el = objectAt(position);
            if(el instanceof Grass){
                ((Grass) el).setPosition(genNewPlace());
            }
            else{
                return false;
            }
        }
        setMapCoordinates(position);
        return true;
    }

    @Override
    public String toString(){
        lowerLeft = new Vector2d(lowX, lowY);
        upperRight = new Vector2d(upX, upY);
        return super.toString();
    }
}
