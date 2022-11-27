package agh.ics.oop;

public class Grass extends AbstractWorldElement{
    public Grass(Vector2d position){
        super();
        if(position == null){
            throw new IllegalArgumentException("Invalid argument for Object Grass");
        }
        super.setPosition(position);
    }
    @Override
    public String toString(){
        return "*";
    }
}
