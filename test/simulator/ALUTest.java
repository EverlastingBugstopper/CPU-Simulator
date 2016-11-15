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
public class ALUTest {

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
    public void setUp() {
        instance = new ALU(true, true, true, true, true, true, true, true);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class ALU.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        int expResult = 11;
        instance.setA(5);
        instance.setB(6);
        int result = instance.execute('+');
        assertEquals(expResult, result);
    }

    /**
     * Test of and method, of class ALU.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAnd() throws Exception {
        System.out.println("and");
        instance.setA(56);  //0000 0000 0011 1000
        instance.setB(28);  //0000 0000 0001 1100      
                            //&&&&-&&&&-&&&&-&&&&
        int expResult = 24; //0000 0000 0001 1000
        int result = instance.execute('&');
        assertEquals(expResult, result);
    }

    /**
     * Test of divide method, of class ALU.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDivide() throws Exception {
        System.out.println("divide");
        instance.setA(123);
        instance.setB(4);
        int expResult = 30; //30.85
        int result = instance.execute('/');
        assertEquals(expResult, result);
    }

    /**
     * Test of lessThan method, of class ALU.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testLessThan() throws Exception {
        System.out.println("lessThan");
        instance.setA(-5);
        instance.setB(8);
        int expResult = 1; //a < b
        int result = instance.execute('<');
        assertEquals(expResult, result);
    }

    /**
     * Test of multiply method, of class ALU.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testMultiply() throws Exception {
        System.out.println("multiply");
        instance.setA(-5);
        instance.setB(7);
        int expResult = -35; //-5 * 7 = -35
        int result = instance.execute('*');
        assertEquals(expResult, result);
    }

    /**
     * Test of or method, of class ALU.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testOr() throws Exception {
        System.out.println("or");
        instance.setA(72);      //0000 0000 0100 1000
        instance.setB(-16);     //1111 1111 1111 0000
                                //||||-||||-||||-||||
        int expResult = -8;     //1111 1111 1111 1000
        int result = instance.execute('|');
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class ALU.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSubtract() throws Exception {
        System.out.println("subtract");
        instance.setA(9);
        instance.setB(-8);
        int expResult = 17; // 9 - (-8) = 9 + 8 = 17
        int result = instance.execute('-');
        assertEquals(expResult, result);
    }

    /**
     * Test of xor method, of class ALU.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testXor() throws Exception {
        System.out.println("xor");
        instance.setA(92);      //0000 0000 0101 1100
        instance.setB(-7);      //1111 1111 1111 1001
                                //^^^^-^^^^-^^^^-^^^^
        int expResult = -91;    //1111 1111 1010 0101
        int result = instance.execute('^');
        assertEquals(expResult, result);
    }

    /**
     * Test of sign flag
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSignFlag() throws Exception {
        System.out.println("signFlag");
        instance.setA(-2);
        instance.setB(1);
        int result = instance.execute('+');
        int expResult = -1;
        assertEquals(1, instance.getSignFlag());
        assertEquals(expResult, result);
    }

    /**
     * Test of zero flag
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testZeroFlag() throws Exception {
        System.out.println("zeroFlag");
        instance.setA(0);
        instance.setB(10);
        int result = instance.execute('*');
        int expResult = 0;
        assertEquals(1, instance.getZeroFlag());
        assertEquals(expResult, result);
    }

    @Test
    public void testOverflowFlag() throws Exception {
        System.out.println("overflowFlag");
        instance.setA(Integer.MAX_VALUE);
        instance.setB(10);
        int result = instance.execute('+');
        int expResult = (instance.getA() + instance.getB());
        assertEquals(1, instance.getOverflowFlag());
        assertEquals(expResult, result);
    }

}
