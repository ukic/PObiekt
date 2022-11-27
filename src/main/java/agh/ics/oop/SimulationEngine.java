package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final List<Animal> animals = new ArrayList<>();
    public SimulationEngine(IWorldMap map, MoveDirection[] directions, Vector2d[] initialPositions){
        this.map = map;
        this.directions = directions;
        for(Vector2d i : initialPositions){
            Animal an = new Animal(map, i);
            animals.add(an);
            map.place(an);
        }
        System.out.println(map.toString());
    }
    public void run(){
        int i = 0;
        int n = animals.size();
        for(MoveDirection d: directions) {
            animals.get(i % n).move(d);
            i++;
            System.out.println(map.toString());
        }
    }
}
