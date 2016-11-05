package simulator;
import java.math.BigInteger;
/**
 *
 * @author avery
 */
public class BaseConversion 
{
    public static String intToBinary(BigInteger intValue)
    {
        return intValue.toString(2);
    }
    
    public static BigInteger binaryToInt(String binaryValue)
    {
        return new BigInteger(binaryValue, 2);
    }
    
    public static String intToHex(BigInteger intValue)
    {
        return intValue.toString(16);
    }
    
    public static BigInteger hexToInt(String hexValue)
    {
        return new BigInteger(hexValue, 16);
    }
    
    public static String hexToBinary(String hexValue)
    {
        BigInteger intVal = hexToInt(hexValue);
        return intToBinary(intVal);
    }
    
    public static String binaryToHex(String binaryValue)
    {
        BigInteger intVal = binaryToInt(binaryValue);
        return intToHex(intVal);
    }
}
