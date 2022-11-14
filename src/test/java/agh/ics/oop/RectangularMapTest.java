package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    private final RectangularMap map = new RectangularMap(2,2);
    @Test
    public void testPlace(){
        assertTrue(map.place(new Animal(map, new Vector2d(null, null))));
        assertFalse(map.place(new Animal(map, new Vector2d(-1, -1))));
        assertFalse(map.place(new Animal(map, new Vector2d(1, null))));
        assertFalse(map.place(new Animal(map, new Vector2d(null, 1))));
        assertFalse(map.place(new Animal(map)));
        assertTrue(map.place(new Animal(map, new Vector2d(1,1))));
        assertFalse(map.place(new Animal(map, new Vector2d(1, 1))));

    }
    @Test
    public void testIsOccupied(){
        assertFalse(map.isOccupied(new Vector2d(null, null)));
        assertFalse(map.isOccupied(new Vector2d(1, null)));
        assertFalse(map.isOccupied(new Vector2d(null, 1)));
        assertFalse(map.isOccupied(new Vector2d(1, 1)));

        map.place(new Animal(map, new Vector2d(1, 1)));
        assertTrue(map.isOccupied(new Vector2d(1, 1)));

        map.place(new Animal(map, new Vector2d(-1, -1)));
        assertFalse(map.isOccupied(new Vector2d(-1, -1)));
    }
    @Test
    public void testCanMoveTo(){
        map.place(new Animal(map, new Vector2d(1, 1)));
        assertFalse(map.canMoveTo(new Vector2d(-1, -1)));
        assertFalse(map.canMoveTo(new Vector2d(1, 1)));
        assertFalse(map.canMoveTo(new Vector2d(null, 1)));
        assertFalse(map.canMoveTo(new Vector2d(1, null)));
        assertFalse(map.canMoveTo(new Vector2d(null, null)));
        assertTrue(map.canMoveTo(new Vector2d(0, 1)));
    }
    @Test
    public void testObjectAt(){
        Animal an = new Animal(map, new Vector2d(1, 1));
        map.place(an);
        assertEquals(an, map.objectAt(new Vector2d(1, 1)));
        assertNull(map.objectAt(new Vector2d(0, 1)));
        assertNull(map.objectAt(new Vector2d(-1, -1)));
        assertNull(map.objectAt(new Vector2d(null,null)));
    }
}
