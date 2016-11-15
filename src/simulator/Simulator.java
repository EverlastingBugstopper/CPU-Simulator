package simulator;

import java.math.BigInteger;

/**
 *
 * @author avery
 */
public class Simulator {
    public static RTNExecute executive;
    public static Configuration configuration;
    public static RegisterContainer registerContainer;
    public static Register instructionRegister;
    public static Bus bus;
    public static MainMemory memory;
    public static ProgramCounter programCounter;
    public static ALU alu;
    

    public static void main(String[] args) throws Exception {
        executive = new RTNExecute();               //this must go first, always
        configuration = new Configuration(executive);    //this must go second
        System.out.println(Configuration.ISAtoString());
        registerContainer = new RegisterContainer(Configuration.getWordSize(), Configuration.getNumOfRegisters());
        alu = new ALU();
        instructionRegister = registerContainer.getRegister("IR");
        instructionRegister.setValue("01100000000000000000000000001001"); //the 1 represents the add function in RTN
        executive.run(registerContainer, instructionRegister, alu);
        instructionRegister.setValue("00010000000000000000000000001001");
        executive.run(registerContainer, instructionRegister, alu);
        bus = new Bus(Configuration.getBusSize());

        memory = new MainMemory(Configuration.getWordSize());
        memory.writeByte("43", "1110");
        memory.writeWord("20", "11110000111100001111000011110000");
        System.out.println(memory.toString());
    }
}
