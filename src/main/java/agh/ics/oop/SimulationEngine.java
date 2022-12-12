package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable {
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private IObserver observer;
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
    public void setObserver(IObserver observer){
        this.observer = observer;
    }
    public void run(){
        int i = 0;
        int n = animals.size();
        for(MoveDirection d: directions) {
            Vector2d prevPos = animals.get(i % n).getPosition();
            animals.get(i % n).move(d);
            System.out.println(map.toString());
            i++;
            observer.positionChanged();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
