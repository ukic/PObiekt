package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        assertThrows(IllegalArgumentException.class, () -> new Vector2d(null, null).toString());
        assertThrows(IllegalArgumentException.class, () -> new Vector2d(1, null).toString());
        assertThrows(IllegalArgumentException.class, () -> new Vector2d(null, 7).toString());
        assertEquals("(4,8)", new Vector2d(4, 8).toString());
    }

    @Test
    void testPrecedes() {
        Vector2d v = new Vector2d(4, 8);
        assertFalse(v.precedes(new Vector2d(-5, -346)));
        assertTrue(v.precedes(new Vector2d(65, 36)));
    }

    @Test
    void testFollows() {
        Vector2d v = new Vector2d(0, 5);
        Vector2d v21 = new Vector2d(-46, -456);
        Vector2d v22 = new Vector2d(58, 47);

        assertTrue(v.follows(v21));
        assertFalse(v.follows(v22));
    }

    @Test
    void testAdd() {
        assertEquals(new Vector2d(1, 1), new Vector2d(-4, -5).add(new Vector2d(5, 6)));
    }

    @Test
    void testSubtract() {
        assertEquals(new Vector2d(-4, -5), new Vector2d(1, 1).subtract(new Vector2d(5, 6)));
    }

    @Test
    void testUpperRight() {
        Vector2d v = new Vector2d(5, 6);

        assertEquals(v, v.upperRight(v));
        assertEquals(new Vector2d(5, 8), new Vector2d(-4, 8).upperRight(v));
    }

    @Test
    void testLowerLeft() {
        Vector2d v = new Vector2d(5, 6);

        assertEquals(v, v.lowerLeft(v));
        assertEquals(new Vector2d(-4, 6), new Vector2d(-4, 8).lowerLeft(v));
    }

    @Test
    void testOpposite() {
        assertEquals(new Vector2d(-4, 8), new Vector2d(4, -8).opposite());
    }

    @Test
    void testEquals() {
        Vector2d v = new Vector2d(-4, 8);

        assertTrue(v.equals(v));
        assertFalse(v.equals(new Vector2d(0, 0)));
    }
}