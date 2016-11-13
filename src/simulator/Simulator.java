package simulator;

/**
 *
 * @author avery
 */
public class Simulator {

    public static void main(String[] args) throws Exception {
        Configuration CPUConfig = new Configuration(); //this must go first, always
        RegisterContainer rC = new RegisterContainer(CPUConfig.getWordSize(), CPUConfig.getNumOfRegisters());
        Register iR = rC.getRegister("IR");
        iR.setValue("00001000000000000000000000000000"); //the 1 represents the add function in RTN
        Bus partyBus = new Bus(CPUConfig.getBusSize());
        RTNExecute me = new RTNExecute();
        me.run(iR);

        MainMemory mem = new MainMemory(CPUConfig.getWordSize());
        mem.writeByte("43", "1110");
        mem.writeWord("20", "11110000111100001111000011110000");
    }
}
