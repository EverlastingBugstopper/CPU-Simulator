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
 * @author The A-Team
 */
public class SimulationTest {
    public RTNExecute executive;
    public Configuration configuration;
    public RegisterContainer registerContainer;
    public Register instructionRegister;
    public Bus bus;
    public MainMemory memory;
    public ProgramCounter programCounter;
    public ALU alu;
    public SimulationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        executive = new RTNExecute();               //this must go first, always
        configuration = new Configuration(executive);      //and this must go second
        registerContainer = new RegisterContainer(Configuration.getWordSize(), Configuration.getNumOfRegisters());
        instructionRegister = registerContainer.getRegister("IR");
        alu = new ALU();
    }
    
    @After
    public void tearDown() {
    }

    // @Test
    // public void hello() {}
    @Test
    public void testRRmov() throws Exception {
        instructionRegister.setValue("01100000000000000000000000001001"); //This should move the value from r0 to r9 as long as the word size is 32
        registerContainer.getRegister(0).setValue(101);
        executive.run(registerContainer, instructionRegister, alu);
        assertEquals(101, registerContainer.getRegister(9).getIntValue());
    }
    
    @Test
    public void testAdd() throws Exception {
        instructionRegister.setValue("00010000000000000000000000001001");
        registerContainer.getRegister(0).setValue(5);
        registerContainer.getRegister(9).setValue(6);
        executive.run(registerContainer, instructionRegister, alu);
        assertEquals(11, registerContainer.getRegister(9).getIntValue());
    }
    
    @Test
    public void testAnd() throws Exception {
        instructionRegister.setValue("01000000000000000000000000001001");
        registerContainer.getRegister(0).setValue(56);
        registerContainer.getRegister(9).setValue(28);
        executive.run(registerContainer, instructionRegister, alu);
        assertEquals(24, registerContainer.getRegister(9).getIntValue());
    }
    
    @Test
    public void testSub() throws Exception {
        instructionRegister.setValue("00110000000000000000000000001001");
        registerContainer.getRegister(0).setValue(9);
        registerContainer.getRegister(9).setValue(8);
        executive.run(registerContainer, instructionRegister, alu);
        assertEquals(1, registerContainer.getRegister(9).getIntValue());
    }
    
    @Test
    public void testXor() throws Exception {
        instructionRegister.setValue("00100000000000000000000000001001");
        registerContainer.getRegister(0).setValue(92);
        registerContainer.getRegister(9).setValue(7);
        executive.run(registerContainer, instructionRegister, alu);
        assertEquals(91, registerContainer.getRegister(9).getIntValue());
    }
}
