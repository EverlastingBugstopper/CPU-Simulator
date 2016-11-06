package simulator;
import java.math.BigInteger;
/**
 *
 * @author avery
 */
public class BaseConversion 
{
    public static String intToBinary(BigInteger intValue, int size) throws Exception
    {
        return formatBinary(intValue.toString(2), size);
    }
    
    public static BigInteger binaryToInt(String binaryValue)
    {
        return new BigInteger(binaryValue, 2);
    }
    
    public static String intToHex(BigInteger intValue, int size) throws Exception
    {
        return formatHex(intValue.toString(16), size);
    }
    
    public static BigInteger hexToInt(String hexValue)
    {
        hexValue = stripHex(hexValue);
        return new BigInteger(hexValue, 16);
    }
    
    public static String hexToBinary(String hexValue, int size) throws Exception
    {
        hexValue = stripHex(hexValue);
        BigInteger intVal = hexToInt(hexValue);
        return intToBinary(intVal, size);
    }
    
    public static String binaryToHex(String binaryValue, int size) throws Exception
    {
        BigInteger intVal = binaryToInt(binaryValue);
        return intToHex(intVal, size);
    }
    
    private static String stripHex(String hexValue)
    {
        if (hexValue.length() >= 2)
        {
            if ((hexValue.charAt(0) == '0') && ((hexValue.charAt(1) == 'x') || hexValue.charAt(1) == 'X'))
            {
                hexValue = hexValue.substring(2);
            }
        }
        
        return hexValue;
    }
    
    public static String formatHex(String hexValue, int size) throws Exception
    {
        hexValue = stripHex(hexValue);
        String value = "";
        while (value.length() + hexValue.length() < size)
        {
            value += "0";
        }
        
        if ((value + hexValue).length() > size)
        {
            throw new Exception("The value given cannot be properly represented in this amount of hex digits.");
        }
        
        return "0x" + value + hexValue;
    }
    
    public static String formatBinary(String binaryValue, int size) throws Exception
    {
        String value = "";
        
        while (value.length() + binaryValue.length() < size)
        {
            value += "0";
        }
        
        if ((value + binaryValue).length() > size)
        {
            throw new Exception("The value given cannot be properly represented in this amount of bits.");
        }
        
        return value + binaryValue;
    }
}
