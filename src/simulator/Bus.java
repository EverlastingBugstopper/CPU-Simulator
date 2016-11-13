package simulator;

/**
 *
 * @author avery
 */
public class Bus {

    private int size;
    private int value;
    private boolean full;

    public Bus(int busSize, int val) {
        size = busSize;
        value = val;
        full = true;
    }

    public Bus(int busSize) {
        size = busSize;
        value = 0;
        full = false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int busSize) {
        size = busSize;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int val) {
        value = val;
        full = true;
    }

    public void reset() {
        value = 0;
        full = false;
    }

    public boolean isFull() {
        return full;
    }

    public String toString() {
        String s = "Size: " + size;
        s += "\nValue: " + value;
        s += "\nFull: " + full;

        return s;
    }
}
