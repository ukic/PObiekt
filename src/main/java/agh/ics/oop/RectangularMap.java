package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{
    private final Integer width;
    private final Integer height;

    public RectangularMap(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        mapBoundary = new MapBoundary();
    }
    private boolean isPositionOnMap(Vector2d position){
        return position.getX() > -1 && position.getX()<= width && position.getY() > -1 && position.getY() <= height ;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && isPositionOnMap(position);
    }
}
