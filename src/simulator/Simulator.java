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
            System.out.println(mem.toString());
    }
}
