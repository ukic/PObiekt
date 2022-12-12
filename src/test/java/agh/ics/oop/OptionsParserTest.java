package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    public void testParse(){
        assertThrows(NullPointerException.class, () -> new OptionsParser().parse(null));
        //assertThrows(IllegalArgumentException.class, () -> new OptionsParser().parse(new String[]{"null"}));
        MoveDirection[] d = new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT};
        //assertArrayEquals(d, new OptionsParser().parse(new String[]{"right", "forward", "backward", "left"}));
        //assertArrayEquals(d, new OptionsParser().parse(new String[]{"r", "f", "b", "l"}));
    }
}
