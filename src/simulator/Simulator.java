package simulator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author avery
 */
public class Simulator {
    public static void main(String[] args) {
            Configuration CPUConfig = new Configuration();
            RegisterContainer rC = new RegisterContainer(CPUConfig.getWordSize(), CPUConfig.getNumOfRegisters());
            Bus partyBus = new Bus(CPUConfig.getBusSize());
    }
}
