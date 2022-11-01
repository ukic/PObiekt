package agh.ics.oop;

public class Vector2d {
    public Integer x;
    public Integer y;
    public Vector2d(Integer x, Integer y){
        if (x != null && y != null){
            this.x = x;
            this.y = y;
        }
        else{
            System.out.println("Invalid x and/or y!");
        }
    }

    @Override public String toString(){
        if(this.x != null && this.y != null){
            return "("+ this.x +","+ this.y +")";
        }
        return "Error";
    }
    public boolean precedes(Vector2d other){
        if(this.x != null && this.y != null && other.x != null && other.y != null){
            return other.x >= this.x && other.y >= this.y;
        }
        System.out.println("Invalid x and/or y!");
        return false;
    }
    public boolean follows(Vector2d other){
        if(this.x != null && this.y != null && other.x != null && other.y != null){
            return other.x <= this.x && other.y <= this.y;
        }
        System.out.println("Invalid x and/or y!");
        return false;
    }
    public Vector2d add (Vector2d other){
        if(other != null && this.x != null && this.y != null && other.x != null && other.y != null){
            return new Vector2d(other.x+this.x, other.y+this.y);
        }
        System.out.println("Invalid x and/or y!");
        return null;
    }
    public Vector2d subtract (Vector2d other){
        if(this.x != null && this.y != null && other.x != null && other.y != null){
            return new Vector2d(this.x - other.x, this.y-other.y);
        }
        System.out.println("Invalid x and/or y!");
        return null;
    }
    public Vector2d upperRight(Vector2d other){
        if(this.x != null && this.y != null && other.x != null && other.y != null){
            return new Vector2d(Math.max(other.x, this.x), Math.max(other.y,this.y));
        }
        System.out.println("Invalid x and/or y!");
        return null;
    }
    public Vector2d lowerLeft(Vector2d other){
        if(this.x != null && this.y != null && other.x != null && other.y != null){
            return new Vector2d(Math.min(other.x, this.x), Math.min(other.y,this.y));
        }
        System.out.println("Invalid x and/or y!");
        return null;
    }
    public Vector2d opposite(){
        if(this.x != null && this.y != null){
            return new Vector2d(-x, -y);
        }
        System.out.println("Invalid x and/or y!");
        return null;
    }
    @Override
    public boolean equals(Object other){
        if (other.getClass().equals(Vector2d.class)){
            Vector2d other_vec = (Vector2d) other;
            if(other_vec.x != null && this.x != null && this.y != null && other_vec.y != null){
                return other_vec.x.equals(this.x) && other_vec.y.equals(this.y);
            }
        }
        return false;
    }
}
