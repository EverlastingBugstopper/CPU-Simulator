package simulator;

/**
 *
 * @author avery
 */
public class Simulator {
    public static void main(String[] args) throws Exception {
            Configuration CPUConfig = new Configuration();
            RegisterContainer rC = new RegisterContainer(CPUConfig.getWordSize(), CPUConfig.getNumOfRegisters());
            Bus partyBus = new Bus(CPUConfig.getBusSize());
            RTNExecute me = new RTNExecute();
            me.run("fetch");
            me.run("add");
            MainMemory mem = new MainMemory(CPUConfig.getWordSize());
            mem.writeByte("43", "1110");
            mem.writeWord("20", "11110000111100001111000011110000");
            System.out.println(mem.toString());
            System.out.println(mem.readWord("20"));
    }
}
