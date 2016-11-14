package simulator;

/**
 *
 * @author avery
 */
public class ProgramCounter {
    private static int value;
    
    public ProgramCounter() {
        value = 0;
    }
    
    public static void setValue(int val) {
        value = val;
    }
    
    public static int getValue() {
        return value;
    }
    
    public static void increment() {
        value += Configuration.getWordSize();
    }
    
    
    
}
