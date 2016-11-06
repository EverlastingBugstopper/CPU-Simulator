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
            String location = "0x";
            String index = BaseConversion.intToHex(new BigInteger((Integer.toString(address * 8))), numOfHexDigits);
            
            memory.put((location + index), BaseConversion.intToBinary(new BigInteger("0"), wordSize));
        }
    }
    
    public void write(String address, String value) throws Exception
    {
        memory.put(BaseConversion.formatHex(address, numOfHexDigits), 
                   BaseConversion.formatBinary(value, wordSize));
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
            String location = "0x";
            String index = "";
            try
            {
                index = BaseConversion.intToHex(new BigInteger((Integer.toString(address * 8))), numOfHexDigits);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            for (int i = 0; i < (numOfHexDigits - index.length()); i++)
            {
                location += "0"; //pad memory location with zeroes
            }
            String currentAddress = location + index;
            s += currentAddress + " -> " + memory.get(currentAddress) + "\n";
        }
        
        return s;
    }
}
