package simulator;

/**
 *
 * @author avery
 */
public class Bus {
    private int size;
    private int value;
    
    public Bus(int busSize, int val)
    {
        size = busSize;
        value = val;
    }
    
    public Bus(int busSize)
    {
        size = busSize;
        value = 0;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public void setSize(int busSize)
    {
        size = busSize;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public void setValue(int val)
    {
        value = val;
    }
    
    public String toString()
    {
        String s = "Size: " + size;
        s += "\nValue: " + value;
        
        return s;
    }
}
