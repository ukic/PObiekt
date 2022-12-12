package agh.ics.oop;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OptionsParser {
    private MoveDirection conv(String str){
        switch (str) {
            case "b", "backward" -> {
                return MoveDirection.BACKWARD;
            }
            case "f", "forward" -> {
                return MoveDirection.FORWARD;
            }
            case "l", "left" -> {
                return MoveDirection.LEFT;
            }
            case "r", "right" -> {
                return MoveDirection.RIGHT;
            }
            default -> throw new IllegalArgumentException(str + " is not legal move specification");
        }
    }

    public MoveDirection[] parse(String[] str){
        return Arrays.stream(str).filter(Objects::nonNull).map(this::conv).toArray(MoveDirection[]::new);
    }
}
