package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{
    private final Integer width;
    private final Integer height;

    public RectangularMap(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }
    private boolean isPositionOnMap(Vector2d position){
        return position.x > -1 && position.x <= width && position.y > -1 && position.y <= height ;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && isPositionOnMap(position);
    }
    @Override
    public String toString(){
        lowerLeft = new Vector2d(0,0);
        upperRight = new Vector2d(width, height);
        return super.toString();
    }
}
