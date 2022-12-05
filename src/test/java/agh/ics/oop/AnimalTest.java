package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    IWorldMap map = new RectangularMap(5,5);
    @Test
    public void testIsAt() {
        assertTrue(new Animal(map).isAt(new Vector2d(2, 2)));
        assertFalse(new Animal(map).isAt(new Vector2d(-2, -2)));
        assertFalse(new Animal(map).isAt(new Vector2d(-1757439, 1757439)));
        assertFalse(new Animal(map).isAt(new Vector2d(-2, null)));
        assertFalse(new Animal(map).isAt(new Vector2d(null, -2)));
        assertFalse(new Animal(map).isAt(new Vector2d(null, null)));
        assertFalse(new Animal(map).isAt(null));
    }
    @Test
    public void testMove() {
        Animal a = new Animal(map);
        assertEquals(MapDirection.NORTH, a.getDirection());

        a.move(MoveDirection.FORWARD);
        assertEquals(MapDirection.NORTH, a.getDirection());
        assertTrue(a.isAt(new Vector2d(2, 3)));

        a.move(null);
        assertEquals(MapDirection.NORTH, a.getDirection());
        assertTrue(a.isAt(new Vector2d(2, 3)));

        a.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, a.getDirection());
        assertTrue(a.isAt(new Vector2d(2, 3)));

        a.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH, a.getDirection());
        assertTrue(a.isAt(new Vector2d(2, 3)));

        a.move(MoveDirection.BACKWARD);
        assertEquals(MapDirection.NORTH, a.getDirection());
        assertTrue(a.isAt(new Vector2d(2, 2)));

        for(int i=0; i < 5; i++){
            a.move(MoveDirection.BACKWARD);
        }
        assertEquals(MapDirection.NORTH, a.getDirection());
        assertTrue(a.isAt(new Vector2d(2, 0)));

        for(int i=0; i < 5; i++){
            a.move(MoveDirection.FORWARD);
        }
        assertEquals(MapDirection.NORTH, a.getDirection());
        assertTrue(a.isAt(new Vector2d(2, 4)));

        a.move(MoveDirection.RIGHT);
        for(int i=0; i < 5; i++){
            a.move(MoveDirection.BACKWARD);
        }
        assertEquals(MapDirection.EAST, a.getDirection());
        assertTrue(a.isAt(new Vector2d(0, 4)));

        for(int i=0; i < 5; i++){
            a.move(MoveDirection.FORWARD);
        }
        assertEquals(MapDirection.EAST, a.getDirection());
        assertTrue(a.isAt(new Vector2d(4, 4)));
    }
}
