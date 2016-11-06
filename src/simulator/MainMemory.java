package simulator;

import java.util.*;
import java.math.BigInteger;

/**
 *
 * @author avery
 */
public class MainMemory 
{
    private final int wordSize;
    private final int memorySize;
    private HashMap<String, String> memory;
    private final int numOfHexDigits;
    
    public MainMemory(int wS) throws Exception
    {
        wordSize = wS;
        memorySize = 2048;
        numOfHexDigits = 8;
        initialize();
    }
    
    private void initialize() throws Exception
    {
        memory = new HashMap<>();
        
        for (int address = 0; address < (memorySize / 8); address++)
        {
            String index = BaseConversion.intToHex(new BigInteger((Integer.toString(address * 8))), numOfHexDigits);
            String value = BaseConversion.intToBinary(new BigInteger("0"), wordSize);
            memory.put(index, value);
        }
    }
    
    public boolean write(String address, String value)
    {
        try 
        {
            memory.put(BaseConversion.formatHex(address, numOfHexDigits), 
                       BaseConversion.formatBinary(value, wordSize));
        }
        
        catch (Exception ex)
        {
            return false; //returns false if doesn't run successfully
        }
        
        return true; //returns if successfully runs
    }
    
    public String read(String address) throws Exception
    {
        return memory.get(BaseConversion.formatHex(address, numOfHexDigits));
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        String s = "";
        for (int address = 0; address < (memorySize / 8); address++)
        {
            String currentAddress = "";
            try {
                currentAddress = BaseConversion.intToHex(new BigInteger((Integer.toString(address * 8))), numOfHexDigits);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            String currentValue = memory.get(currentAddress);
            s += currentAddress + " -> " + currentValue + "\n";
        }
        
        return s;
    }
}
