package simulator;

import java.math.BigInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author avery
 */
public class BaseConversionTest {
    
    public BaseConversionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of intToBinary method, of class BaseConversion.
     */
    @Test
    public void testIntToBinary() {
        System.out.println("intToBinary");
        BigInteger intValue = new BigInteger("107");
        String expResult = "1101011";
        String result = BaseConversion.intToBinary(intValue);
        assertEquals(expResult, result);
        System.out.println("The expected result was " + expResult + " and " + result + " was given.\n");
    }

    /**
     * Test of binaryToInt method, of class BaseConversion.
     */
    @Test
    public void testBinaryToInt() {
        System.out.println("binaryToInt");
        String binaryValue = "010111010";
        BigInteger expResult = new BigInteger("186");
        BigInteger result = BaseConversion.binaryToInt(binaryValue);
        assertEquals(expResult, result);
        System.out.println("The expected result was " + expResult + " and " + result + " was given.\n");
    }

    /**
     * Test of intToHex method, of class BaseConversion.
     */
    @Test
    public void testIntToHex() {
        System.out.println("intToHex");
        BigInteger intValue = new BigInteger("167");
        String expResult = "a7";
        String result = BaseConversion.intToHex(intValue);
        assertEquals(expResult, result);
        System.out.println("The expected result was " + expResult + " and " + result + " was given.\n");
    }

    /**
     * Test of hexToInt method, of class BaseConversion.
     */
    @Test
    public void testHexToInt() {
        System.out.println("hexToInt");
        String hexValue = "60DF";
        BigInteger expResult = new BigInteger("24799");
        BigInteger result = BaseConversion.hexToInt(hexValue);
        assertEquals(expResult, result);
        System.out.println("The expected result was " + expResult + " and " + result + " was given.\n");
    }

    /**
     * Test of hexToBinary method, of class BaseConversion.
     */
    @Test
    public void testHexToBinary() {
        System.out.println("hexToBinary");
        String hexValue = "23AB";
        String expResult = "10001110101011";
        String result = BaseConversion.hexToBinary(hexValue);
        assertEquals(expResult, result);
        System.out.println("The expected result was " + expResult + " and " + result + " was given.\n");
    }

    /**
     * Test of binaryToHex method, of class BaseConversion.
     */
    @Test
    public void testBinaryToHex() {
        System.out.println("binaryToHex");
        String binaryValue = "00100111110101111101";
        String expResult = "27d7d";
        String result = BaseConversion.binaryToHex(binaryValue);
        assertEquals(expResult, result);
        System.out.println("The expected result was " + expResult + " and " + result + " was given.\n");
    }
    
}
