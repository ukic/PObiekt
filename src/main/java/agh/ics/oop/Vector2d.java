package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    private final Integer x;
    private final Integer y;
    public Vector2d(Integer x, Integer y){
        if (x != null && y != null){
            this.x = x;
            this.y = y;
        }
        else{
            throw new IllegalArgumentException("Invalid argument for Object Vector2d");
        }
    }
    public Integer getX(){
        return x;
    }
    public Integer getY(){
        return y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
    @Override public String toString(){
        return "("+ this.x +","+ this.y +")";
    }
    public boolean precedes(Vector2d other){
        return other.x >= this.x && other.y >= this.y;
    }
    public boolean follows(Vector2d other){
        return other.x <= this.x && other.y <= this.y;
    }
    public Vector2d add (Vector2d other){
        return new Vector2d(other.x+this.x, other.y+this.y);
    }
    public Vector2d subtract (Vector2d other){
        return new Vector2d(this.x - other.x, this.y-other.y);
    }
    public Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(other.x, this.x), Math.max(other.y,this.y));
    }
    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(other.x, this.x), Math.min(other.y,this.y));
    }
    public Vector2d opposite(){
        return new Vector2d(-x, -y);
    }
    @Override
    public boolean equals(Object other){
        if (other instanceof Vector2d other_vec){
            return other_vec.x.equals(this.x) && other_vec.y.equals(this.y);
        }
        return false;
    }
}
