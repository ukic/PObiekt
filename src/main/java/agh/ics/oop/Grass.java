package agh.ics.oop;

public class Grass extends AbstractWorldElement{
    public Grass(Vector2d position){
        super();
        super.setPosition(position);
    }
    @Override
    public String toString(){
        return "*";
    }
}
