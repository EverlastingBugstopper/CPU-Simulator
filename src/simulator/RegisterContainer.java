package simulator;

import java.util.*;

/**
 *
 * @author avery
 */
public class RegisterContainer {

    private final ArrayList<Register> allRegisters;

    public RegisterContainer(int wordSize, int numOfRegisters) throws Exception {
        allRegisters = new ArrayList<>(numOfRegisters);

        for (int i = 0; i < numOfRegisters; i++) {
            allRegisters.add(new Register(("r" + Integer.toString(i)), wordSize, i, "0"));
        }

        allRegisters.add(new Register("IR", wordSize, numOfRegisters, "0"));
    }

    public Register getRegister(String name) {
        Register currentRegister;
        for (int i = 0; i < allRegisters.size(); i++) {
            currentRegister = allRegisters.get(i);
            if (currentRegister.getName().equals(name)) {
                return currentRegister;
            }
        }

        System.out.println("The register you're looking for was not found.");
        return null;
    }

    public int size() {
        return allRegisters.size();
    }

    @Override
    public String toString() {
        String s = "All registers:\n";

        for (int i = 0; i < allRegisters.size(); i++) {
            s += allRegisters.get(i).toString() + "\n";
        }

        return s;
    }

}
