/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class MainMemoryTest {
    private MainMemory mem;
    
    public MainMemoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        mem = new MainMemory(32);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of writeByte method, of class MainMemory.
     */
    @Test
    public void testWriteByte() {
        System.out.println("writeByte");
        String address = "0x00";
        String value = "10001";
        boolean expResult = true;
        boolean result = mem.writeByte(address, value);
        assertEquals(expResult, result);
        address = "0xFFFFFFFFFF";
        value = "0110";
        expResult = false;
        result = mem.writeByte(address, value);
        assertEquals(expResult, result);
    }

    /**
     * Test of writeWord method, of class MainMemory.
     */
    @Test
    public void testWriteWord() {
        System.out.println("writeWord");
        String address = "0x00";
        String value = "0110";
        boolean expResult = true;
        boolean result = mem.writeWord(address, value);
        assertEquals(expResult, result);
        address = "0xFFFFFFFFF";
        value = "0110";
        expResult = false;
        result = mem.writeWord(address, value);
        assertEquals(expResult, result);
    }

    /**
     * Test of readByte method, of class MainMemory.
     */
    @Test
    public void testReadByte() throws Exception {
        System.out.println("readByte");
        String address = "0xfff";
        String value = "01100111";
        mem.writeByte(address, value);
        String result = mem.readByte(address);
        assertEquals(value, result); 
    }

    /**
     * Test of readWord method, of class MainMemory.
     */
    @Test
    public void testReadWord() throws Exception {
        System.out.println("readWord");
        String address = "0xff";
        String value = "0110";
        mem.writeWord(address, value);
        String result = mem.readWord(address);
        assertEquals("00000000000000000000000000000110", result);        
    }    
}
