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
    private final int byteSize;
    private final BigInteger gobble;
    
    public MainMemory(int wS) throws Exception
    {
        wordSize = wS;
        memorySize = 2048;
        numOfHexDigits = 8;
        byteSize = 8;
        gobble = new BigInteger(Integer.toString(byteSize));
        initialize();
    }
    
    private void initialize() throws Exception
    {
        memory = new HashMap<>();
        
        for (int address = 0; address < (memorySize / byteSize); address++)
        {
            String index = BaseConversion.intToHex(new BigInteger((Integer.toString(address * byteSize))), numOfHexDigits);
            String value = BaseConversion.intToBinary(new BigInteger("0"), byteSize);
            memory.put(index, value);
        }
    }
    
    public boolean writeByte(String address, String value)
    {
        try 
        {
            memory.put(gobbleItUp(address), BaseConversion.formatBinary(value, byteSize));
        }
        
        catch (Exception ex)
        {
            return false; //returns false if doesn't run successfully
        }
        
        return true; //returns if successfully runs
    }
    
    public boolean writeWord(String address, String value)
    {
        try {
            int initial = BaseConversion.hexToInt(gobbleItUp(address)).intValue();
            for (int i = initial; i < (wordSize + initial); i += byteSize)
            {
                String currentByte = BaseConversion.intToHex(new BigInteger(Integer.toString(i)), numOfHexDigits);
                String currentValue = value.substring(i - initial, i + byteSize - initial);
                writeByte(currentByte, currentValue);
            }
        }
        
        catch (Exception e)
        {
            return false;
        }
        
        return true;
    }
    
    public String readByte(String address) throws Exception
    {
        return memory.get(gobbleItUp(address));
    }
    
    public String readWord(String address) throws Exception
    {
        String word = "";
        
        try {
            int initial = BaseConversion.hexToInt(gobbleItUp(address)).intValue();
            for (int i = initial; i < (wordSize + initial); i += byteSize)
            {
                String currentByte = BaseConversion.intToHex(new BigInteger(Integer.toString(i)), numOfHexDigits);
                word += readByte(currentByte);
            }
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return word;
    }
    
    /**
     * 
     * @param address
     * @return Returns an address that actually can be reached within the hash table
     * @throws Exception 
     */
    private String gobbleItUp(String address) throws Exception
    {
        return BaseConversion.intToHex(BaseConversion.hexToInt(address).divide(gobble).multiply(gobble), numOfHexDigits);
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
