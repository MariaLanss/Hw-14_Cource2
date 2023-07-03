package pro.sky.hw14_cource2;

public class IntegerArrayListElementNotFoundException extends RuntimeException{
    public IntegerArrayListElementNotFoundException(String element) {
        super("Element " + element + " not found");
    }
}