package simulator;

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
    

    public static void main(String[] args) throws Exception {
        executive = new RTNExecute();               //this must go first, always
        configuration = new Configuration(executive);  //and this must go second
        registerContainer = new RegisterContainer(Configuration.getWordSize(), Configuration.getNumOfRegisters());
        instructionRegister = registerContainer.getRegister("IR");
        instructionRegister.setValue("00010000000000000000000000000000"); //the 1 represents the add function in RTN
        bus = new Bus(Configuration.getBusSize());

        executive.run(instructionRegister);

        memory = new MainMemory(Configuration.getWordSize());
        memory.writeByte("43", "1110");
        memory.writeWord("20", "11110000111100001111000011110000");
    }
}
