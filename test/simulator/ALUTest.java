package simulator;

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
public class ALUTest 
{
    private ALU instance;
    
    public ALUTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        instance = new ALU(true, true, true, true, true, true, true, true);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class ALU.
     * @throws java.lang.Exception
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        int a = 5;
        int b = 6;
        int expResult = 11;
        int result = instance.execute(0, a, b);
        assertEquals(expResult, result);
    }
        
    /**
     * Test of and method, of class ALU.
     * @throws java.lang.Exception
     */
    @Test
    public void testAnd() throws Exception {
        System.out.println("and");
        int a = 56;         //0000 0000 0011 1000
        int b = 28;         //0000 0000 0001 1100
                            //&&&&-&&&&-&&&&-&&&&
        int expResult = 24; //0000 0000 0001 1000
        int result = instance.execute(1, a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of divide method, of class ALU.
     * @throws java.lang.Exception
     */
    @Test
    public void testDivide() throws Exception {
        System.out.println("divide");
        int a = 123;
        int b = 4;
        int expResult = 30; //30.85
        int result = instance.execute(2, a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of lessThan method, of class ALU.
     * @throws java.lang.Exception
     */
    @Test
    public void testLessThan() throws Exception {
        System.out.println("lessThan");
        int a = -5;
        int b = 8;
        int expResult = 1; //a < b
        int result = instance.execute(3, a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of multiply method, of class ALU.
     * @throws java.lang.Exception
     */
    @Test
    public void testMultiply() throws Exception {
        System.out.println("multiply");
        int a = -5;
        int b = 7;
        int expResult = -35; //-5 * 7 = -35
        int result = instance.execute(4, a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of or method, of class ALU.
     * @throws java.lang.Exception
     */
    @Test
    public void testOr() throws Exception {
        System.out.println("or");
        int a = 72;         //0000 0000 0100 1000
        int b = -16;        //1111 1111 1111 0000
                            //||||-||||-||||-||||
        int expResult = -8; //1111 1111 1111 1000
        int result = instance.execute(5, a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class ALU.
     * @throws java.lang.Exception
     */
    @Test
    public void testSubtract() throws Exception {
        System.out.println("subtract");
        int a = 9;
        int b = -8;
        int expResult = 17; // 9 - (-8) = 9 + 8 = 17
        int result = instance.execute(6, a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of xor method, of class ALU.
     * @throws java.lang.Exception
     */
    @Test
    public void testXor() throws Exception {
        System.out.println("xor");
        int a = 92;          //0000 0000 0101 1100
        int b = -7;          //1111 1111 1111 1001
                             //^^^^-^^^^-^^^^-^^^^
        int expResult = -91; //1111 1111 1010 0101
        int result = instance.execute(7, a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of sign flag
     * @throws java.lang.Exception
     */
    @Test
    public void testSignFlag() throws Exception {
        System.out.println("signFlag");
        int a = -2;
        int b = 1;
        int result = instance.execute(0, a, b);
        int expResult = -1;
        assertEquals(1, instance.getSignFlag());
        assertEquals(expResult, result);
    }
    
    /**
     * Test of zero flag
     * @throws java.lang.Exception
     */
    @Test
    public void testZeroFlag() throws Exception {
        System.out.println("zeroFlag");
        int a = 0;
        int b = 10;
        int result = instance.execute(4, a, b);
        int expResult = 0;
        assertEquals(1, instance.getZeroFlag());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOverflowFlag() throws Exception {
        System.out.println("overflowFlag");
        int a = Integer.MAX_VALUE;
        int b = 10;
        int result = instance.execute(0, a, b);
        int expResult = (a + b);
        assertEquals(1, instance.getOverflowFlag());
        assertEquals(expResult, result);
    }
    
}
