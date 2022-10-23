package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        Vector2d v1 = new Vector2d(null, null);
        Vector2d v2 = new Vector2d(1, null);
        Vector2d v3 = new Vector2d(null, 7);
        Vector2d v4 = new Vector2d(4, 8);

        assertEquals("Error", v1.toString());
        assertEquals("Error", v2.toString());
        assertEquals("Error", v3.toString());
        assertEquals("(4,8)", v4.toString());
    }

    @Test
    void testPrecedes() {
        Vector2d v11 = new Vector2d(null, null);
        Vector2d v12 = new Vector2d(6, null);
        Vector2d v13 = new Vector2d(null, 7);
        Vector2d v14 = new Vector2d(4, 8);

        Vector2d v21 = new Vector2d(null, null);
        Vector2d v22 = new Vector2d(3, null);
        Vector2d v23 = new Vector2d(null, 6);
        Vector2d v24 = new Vector2d(-5, -346);
        Vector2d v25 = new Vector2d(65, 36);

        Vector2d[] vecs1 = {v11, v12, v13};
        Vector2d[] vecs2 = {v21, v22, v23, v24, v25};

        for(Vector2d vec1 : vecs1){
            for (Vector2d vec2 : vecs2) {
                assertFalse(vec1.precedes(vec2));
            }
        }

        assertFalse(v14.precedes(v21));
        assertFalse(v14.precedes(v22));
        assertFalse(v14.precedes(v23));
        assertFalse(v14.precedes(v24));
        assertTrue(v14.precedes(v25));

    }

    @Test
    void testFollows() {
        Vector2d v11 = new Vector2d(null, null);
        Vector2d v12 = new Vector2d(4, null);
        Vector2d v13 = new Vector2d(null, 8);
        Vector2d v14 = new Vector2d(0, 5);

        Vector2d v21 = new Vector2d(null, null);
        Vector2d v22 = new Vector2d(3, null);
        Vector2d v23 = new Vector2d(null, 6);
        Vector2d v24 = new Vector2d(-46, -456);
        Vector2d v25 = new Vector2d(58, 47);

        Vector2d[] vecs1 = {v11, v12, v13};
        Vector2d[] vecs2 = {v21, v22, v23, v24, v25};

        for(Vector2d vec1 : vecs1){
            for (Vector2d vec2 : vecs2) {
                assertFalse(vec1.follows(vec2));
            }
        }

        assertFalse(v14.follows(v21));
        assertFalse(v14.follows(v22));
        assertFalse(v14.follows(v23));
        assertTrue(v14.follows(v24));
        assertFalse(v14.follows(v25));
    }

    @Test
    void testAdd() {
        Vector2d v1 = new Vector2d(null, null);
        Vector2d v2 = new Vector2d(3, null);
        Vector2d v3 = new Vector2d(null, 6);
        Vector2d v4 = new Vector2d(-4, -5);
        Vector2d v5 = new Vector2d(5, 6);

        Vector2d v6 = new Vector2d(1, 1);

        Vector2d[] vecs = {v1, v2, v3, v4};
        for(Vector2d vec1 : vecs){
            for (Vector2d vec2 : vecs) {
                if (vec1.equals(vec2) && vec1.equals(v4)) {
                    break;
                }
                assertNull(vec1.add(vec2));
            }
        }
        assertEquals(v6, v4.add(v5));

    }

    @Test
    void testSubtract() {
        Vector2d v1 = new Vector2d(null, null);
        Vector2d v2 = new Vector2d(3, null);
        Vector2d v3 = new Vector2d(null, 6);
        Vector2d v4 = new Vector2d(-4, -5);
        Vector2d v5 = new Vector2d(5, 6);

        Vector2d v6 = new Vector2d(1, 1);

        Vector2d[] vecs = {v1, v2, v3, v4};

        for(Vector2d vec1 : vecs){
            for (Vector2d vec2 : vecs) {
                if (vec1.equals(vec2) && vec1.equals(v4)) {
                    break;
                }
                assertNull(vec1.subtract(vec2));
            }
        }

        assertEquals(v4, v6.subtract(v5));
    }

    @Test
    void testUpperRight() {
        Vector2d v1 = new Vector2d(null, null);
        Vector2d v2 = new Vector2d(3, null);
        Vector2d v3 = new Vector2d(null, 6);
        Vector2d v4 = new Vector2d(-4, 8);
        Vector2d v5 = new Vector2d(5, 6);
        Vector2d v6 = new Vector2d(5, 8);

        Vector2d[] vecs = {v1, v2, v3, v4};

        for(Vector2d vec1 : vecs){
            for (Vector2d vec2 : vecs) {
                if (vec1.equals(vec2) && vec1.equals(v4)) {
                    break;
                }
                assertNull(vec1.upperRight(vec2));
            }
        }
        assertEquals(v5, v5.upperRight(v5));
        assertEquals(v6, v4.upperRight(v5));
    }

    @Test
    void testLowerLeft() {
        Vector2d v1 = new Vector2d(null, null);
        Vector2d v2 = new Vector2d(3, null);
        Vector2d v3 = new Vector2d(null, 6);
        Vector2d v4 = new Vector2d(-4, 8);
        Vector2d v5 = new Vector2d(5, 6);
        Vector2d v6 = new Vector2d(-4, 6);

        Vector2d[] vecs = {v1, v2, v3, v4};

        for(Vector2d vec1 : vecs){
            for (Vector2d vec2 : vecs) {
                if (vec1.equals(vec2) && vec1.equals(v4)) {
                    break;
                }
                assertNull(vec1.lowerLeft(vec2));
            }
        }
        assertEquals(v5, v5.lowerLeft(v5));
        assertEquals(v6, v4.lowerLeft(v5));
    }

    @Test
    void testOpposite() {
        Vector2d v1 = new Vector2d(null, null);
        Vector2d v2 = new Vector2d(3, null);
        Vector2d v3 = new Vector2d(null, 6);
        Vector2d v4 = new Vector2d(-4, 8);
        Vector2d v5 = new Vector2d(4, -8);

        Vector2d[] vecs = {v1, v2, v3};

        for(Vector2d vec1 : vecs){
            assertNull(vec1.opposite());
        }
        assertEquals(v5, v4.opposite());
    }

    @Test
    void testEquals() {
        Vector2d v1 = new Vector2d(null, null);
        Vector2d v11 = new Vector2d(null, null);
        Vector2d v2 = new Vector2d(3, null);
        Vector2d v22 = new Vector2d(3, null);
        Vector2d v3 = new Vector2d(null, 6);
        Vector2d v33 = new Vector2d(null, 6);
        Vector2d v4 = new Vector2d(-4, 8);
        Vector2d v44 = new Vector2d(-4, 8);

        Vector2d[] vecs = {v1, v2, v3, v4};

        for(Vector2d vec1 : vecs){
            for (Vector2d vec2 : vecs) {
                if (vec1.equals(vec2)) {
                    continue;
                }
                assertFalse(vec1.equals(vec2));
            }
        }

        assertFalse(v1.equals(v11));
        assertFalse(v2.equals(v22));
        assertFalse(v3.equals(v33));
        assertTrue(v4.equals(v44));
    }
}