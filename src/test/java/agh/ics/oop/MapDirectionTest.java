package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    public void testNext(){
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next(), "Failed for direction North");
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next(), "Failed for direction West");
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next(), "Failed for direction East");
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next(), "Failed for direction South");
    }

    @Test
    public void testPrev(){
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous(), "Failed for direction North");
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous(), "Failed for direction West");
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous(), "Failed for direction East");
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous(), "Failed for direction South");
    }
}