package simulator;

/**
 *
 * @author avery
 */
public class BaseConversion 
{
    public static String intToBinary(int intValue)
    {
        return Integer.toBinaryString(intValue);
    }
    
    public static int binaryToInt(String binaryValue)
    {
        return Integer.parseInt(binaryValue, 2);
    }
    
    public static String intToHex(int intValue)
    {
        return Integer.toHexString(intValue);
    }
    
    public static int hexToInt(String hexValue)
    {
        return Integer.parseInt(hexValue, 8);
    }
    
    public static String hexToBinary(String hexValue)
    {
        int intVal = hexToInt(hexValue);
        return intToBinary(intVal);
    }
    
    public static String binaryToHex(String binaryValue)
    {
        int intVal = binaryToInt(binaryValue);
        return intToHex(intVal);
    }
}
