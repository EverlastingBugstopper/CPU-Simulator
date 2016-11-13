package simulator;

/**
 *
 * @author avery
 */
public class Simulator {

    public static void main(String[] args) throws Exception {
        RTNExecute me = new RTNExecute();               //this must go first, always
        Configuration CPUConfig = new Configuration(me);  //and this must go second
        System.out.println(Configuration.ISAtoString());
        RegisterContainer rC = new RegisterContainer(Configuration.getWordSize(), Configuration.getNumOfRegisters());
        Register iR = rC.getRegister("IR");
        iR.setValue("00010000000000000000000000000000"); //the 1 represents the add function in RTN
        Bus partyBus = new Bus(Configuration.getBusSize());
        
        me.run(iR);

        MainMemory mem = new MainMemory(Configuration.getWordSize());
        mem.writeByte("43", "1110");
        mem.writeWord("20", "11110000111100001111000011110000");
    }
}
