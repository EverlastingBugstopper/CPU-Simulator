package simulator;

import java.io.*;

/**
 *
 * @author avery
 */
public final class Configuration {

    private int wordSize;
    private int busSize;
    private int numOfRegisters;
    private String fileName;
    private boolean canAdd;
    private boolean canAnd;
    private boolean canDivide;
    private boolean canLessThan;
    private boolean canMultiply;
    private boolean canOr;
    private boolean canSubtract;
    private boolean canXor;
    private int opCodeBits;
    private int registerBits;

    public Configuration() {
        fileName = "config.txt";
        read(fileName);
    }

    public Configuration(String fN) {
        fileName = "fN";
        read(fileName);
    }

    public void read(String fN) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] info = line.split(":");

                switch (info[0]) {
                    case "word":
                    case "words":
                    case "wordSize":
                        wordSize = Integer.parseInt(info[1]);
                        break;
                    case "bus":
                    case "busSize":
                        busSize = Integer.parseInt(info[1]);
                        break;
                    case "registers":
                    case "numOfRegisters":
                        numOfRegisters = Integer.parseInt(info[1]);
                        break;
                    case "add":
                        if (info[1].substring(0, 1).toLowerCase().equals("t")) {
                            canAdd = true;
                            break;
                        }
                        canAdd = false;
                        break;
                    case "and":
                        if (info[1].substring(0, 1).toLowerCase().equals("t")) {
                            canAnd = true;
                            break;
                        }
                        canAnd = false;
                        break;
                    case "divide":
                        if (info[1].substring(0, 1).toLowerCase().equals("t")) {
                            canDivide = true;
                            break;
                        }
                        canDivide = false;
                        break;
                    case "lessThan":
                    case "lessthan":
                    case "less":
                        if (info[1].substring(0, 1).toLowerCase().equals("t")) {
                            canLessThan = true;
                            break;
                        }
                        canLessThan = false;
                        break;
                    case "multiply":
                        if (info[1].substring(0, 1).toLowerCase().equals("t")) {
                            canMultiply = true;
                            break;
                        }
                        canLessThan = false;
                        break;
                    case "or":
                        if (info[1].substring(0, 1).toLowerCase().equals("t")) {
                            canOr = true;
                            break;
                        }
                        canOr = false;
                        break;
                    case "subtract":
                        if (info[1].substring(0, 1).toLowerCase().equals("t")) {
                            canSubtract = true;
                            break;
                        }
                        canSubtract = false;
                        break;
                    case "xor":
                        if (info[1].substring(0, 1).toLowerCase().equals("t")) {
                            canXor = true;
                            break;
                        }
                        canXor = false;
                        break;
                    default:
                        System.out.println("\nUnusable data: " + info[0] + info[2] + "\n");
                        break;
                }
            }

        } catch (IOException e) {
            System.out.println("The specified file could not be opened.");
        }

        int bitValue = 0;
        int greatestValue = 0;
        int bitNumber;

        //numOfRegisters + 1 to account for the instruction register
        for (bitNumber = 1; greatestValue < (numOfRegisters + 1); bitNumber++) {
            System.out.println("BEFORE: \nbitNumber: " + bitNumber + "\ngreatestValue: " + greatestValue
                    + "\nnumOfRegisters: " + numOfRegisters);
            if (bitValue == 0) {
                bitValue++;
            } else {
                bitValue *= 2;
            }
            greatestValue += bitValue;
            System.out.println("AFTER: \nbitNumber: " + bitNumber + "\ngreatestValue: " + greatestValue
                    + "\nnumOfRegisters: " + numOfRegisters);
        }
        registerBits = bitNumber - 1; //-1 because the for loop increments one more than it should

        System.out.println("AFTERAFTER: \nbitNumber: " + bitNumber + "\ngreatestValue: " + greatestValue
                + "\nnumOfRegisters: " + numOfRegisters);

    }

    public boolean canAdd() {
        return canAdd;
    }

    public boolean canAnd() {
        return canAnd;
    }

    public boolean canDivide() {
        return canDivide;
    }

    public boolean canLessThan() {
        return canLessThan;
    }

    public boolean canMultiply() {
        return canMultiply;
    }

    public boolean canOr() {
        return canOr;
    }

    public boolean canSubtract() {
        return canSubtract;
    }

    public boolean canXor() {
        return canXor;
    }

    public int getBusSize() {
        return busSize;
    }

    public void setBusSize(int bS) {
        busSize = bS;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String f) {
        fileName = f;
    }

    public int getNumOfRegisters() {
        return numOfRegisters;
    }

    public void setNumOfRegisters(int nOR) {
        numOfRegisters = nOR;
    }

    public int getWordSize() {
        return wordSize;
    }

    public void setWordSize(int wS) {
        wordSize = wS;
    }

    public int getOpCodeBits() {
        return opCodeBits;
    }

    @Override
    public String toString() {
        String s = "Number of registers: " + numOfRegisters;
        s += "\nWord Size: " + wordSize;
        s += "\nBus Size: " + busSize;
        return s;
    }
}
