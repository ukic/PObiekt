package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    public void testNext(){
        MapDirection md = MapDirection.NORTH;
        assertEquals(MapDirection.EAST, md.next(), "Failed for direction North");
        md = MapDirection.WEST;
        assertEquals(MapDirection.NORTH, md.next(), "Failed for direction West");
        md = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH, md.next(), "Failed for direction East");
        md = MapDirection.SOUTH;
        assertEquals(MapDirection.WEST, md.next(), "Failed for direction South");
    }

    @Test
    public void testPrev(){
        MapDirection md = MapDirection.NORTH;
        assertEquals(MapDirection.WEST, md.previous(), "Failed for direction North");
        md = MapDirection.WEST;
        assertEquals(MapDirection.SOUTH, md.previous(), "Failed for direction West");
        md = MapDirection.EAST;
        assertEquals(MapDirection.NORTH, md.previous(), "Failed for direction East");
        md = MapDirection.SOUTH;
        assertEquals(MapDirection.EAST, md.previous(), "Failed for direction South");
    }
}