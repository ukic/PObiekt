package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GrassFieldTest {
    private final GrassField map = new GrassField(10);
    @Test
    public void testPlace(){
        assertFalse(map.place(new Animal(map, null)));
        assertTrue(map.place(new Animal(map)));
        assertTrue(map.place(new Animal(map, new Vector2d(-1,-1))));
        assertFalse(map.place(new Animal(map, new Vector2d(-1, -1))));

    }
    @Test
    public void testIsOccupied(){
        assertFalse(map.isOccupied(null));
        assertFalse(map.isOccupied(new Vector2d(null, 1)));
        map.place(new Animal(map, new Vector2d(1000, 1000)));
        assertTrue(map.isOccupied(new Vector2d(1000, 1000)));
        assertFalse(map.isOccupied(new Vector2d(-1, -1)));
    }
    @Test
    public void testCanMoveTo(){
        map.place(new Animal(map, new Vector2d(1, 1)));
        assertTrue(map.canMoveTo(new Vector2d(-1000, 1000)));
        assertFalse(map.canMoveTo(new Vector2d(1, 1)));
        assertFalse(map.canMoveTo(null));
        assertFalse(map.isOccupied(new Vector2d(1, null)));
        assertTrue(map.canMoveTo(new Vector2d(0, 1)));
    }
    @Test
    public void testObjectAt(){
        Animal an = new Animal(map, new Vector2d(1, 1));
        map.place(an);
        assertEquals(an, map.objectAt(new Vector2d(1, 1)));
        assertNull(map.objectAt(new Vector2d(0, 1)));
        assertNull(map.objectAt(new Vector2d(-1, -1)));
        assertNull(map.objectAt(null));
        assertNull(map.objectAt(new Vector2d(null, null)));
    }
}
