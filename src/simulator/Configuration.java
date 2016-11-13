package simulator;

import java.io.*;

/**
 *
 * @author avery
 */
public final class Configuration {

    private static int wordSize;
    private static int busSize;
    private static int numOfRegisters;
    private static String fileName;
    private static boolean canAdd;
    private static boolean canAnd;
    private static boolean canDivide;
    private static boolean canLessThan;
    private static boolean canMultiply;
    private static boolean canOr;
    private static boolean canSubtract;
    private static boolean canXor;
    private static int opCodeBits;
    private static int argumentBits;
    private static int functionBits;
    private static RTNExecute executioner;

    public Configuration(RTNExecute exec) throws Exception {
        fileName = "config.txt";
        executioner = exec;
        read(fileName);
    }

    public Configuration(String fN, RTNExecute exec) throws Exception {
        fileName = "fN";
        executioner = exec;
        read(fileName);
    }

    public static void read(String fN) throws Exception {
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
        } catch (Exception ex) {
            System.out.println("Invalid Configuration values.");
        }

        argumentBits = calcNeededBits(numOfRegisters + 1);
        System.out.println("Num of registers: " + (numOfRegisters + 1) + "\nargBits: " + argumentBits);
        functionBits = calcNeededBits(executioner.numOfPossibles());
        System.out.println("Num of Possibles: " + executioner.numOfPossibles() + "\nfunctionBits: " + functionBits);
        int isaLength = ((2 * argumentBits) + functionBits);
        if (isaLength > wordSize) {
            throw new Exception("This amount of registers and functions will not work with this word size.");
        } else if (isaLength < wordSize) {
            argumentBits = (wordSize - functionBits) / 2;
        }

        isaLength = ((2 * argumentBits) + functionBits);

        if (isaLength < wordSize) { //this is needed when the function bit is computed to be odd
            functionBits++;
        }

        if (isaLength != wordSize) {
            throw new Exception("Something went wrong when assembling the ISA, you shouldn't be seeing this error message.");
        }
    }

    public static int getFunctionBits() {
        return functionBits;
    }

    public static int getArgumentBits() {
        return argumentBits;
    }

    public static String ISAtoString() {
        String s = "";

        for (int i = 0; i < functionBits; i++) {
            s += "f";
        }
        s += "|";
        for (int i = 0; i < argumentBits; i++) {
            s += "a";
        }
        s += "|";
        for (int i = 0; i < argumentBits; i++) {
            s += "b";
        }
        return s;
    }

    private static int calcNeededBits(int representatives) {
        int bitValue = 0;
        int greatestValue = 0;
        int bitNumber;

        for (bitNumber = 1; greatestValue < (representatives); bitNumber++) {
            if (bitValue == 0) {
                bitValue++;
            } else {
                bitValue *= 2;
            }
            greatestValue += bitValue;
        }
        return bitNumber - 1;
    }

    public static boolean canAdd() {
        return canAdd;
    }

    public static boolean canAnd() {
        return canAnd;
    }

    public static boolean canDivide() {
        return canDivide;
    }

    public static boolean canLessThan() {
        return canLessThan;
    }

    public static boolean canMultiply() {
        return canMultiply;
    }

    public static boolean canOr() {
        return canOr;
    }

    public static boolean canSubtract() {
        return canSubtract;
    }

    public static boolean canXor() {
        return canXor;
    }

    public static int getBusSize() {
        return busSize;
    }

    public static void setBusSize(int bS) {
        busSize = bS;
    }

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String f) {
        fileName = f;
    }

    public static int getNumOfRegisters() {
        return numOfRegisters;
    }

    public static void setNumOfRegisters(int nOR) {
        numOfRegisters = nOR;
    }

    public static int getWordSize() {
        return wordSize;
    }

    public static void setWordSize(int wS) {
        wordSize = wS;
    }

    public static int getOpCodeBits() {
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
