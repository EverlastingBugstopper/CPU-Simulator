package simulator;

import java.io.*;
import java.util.*;

/**
 *
 * @author avery
 */
public class RTNExecute {

    private final String fileName;
    ArrayList<ArrayList<String>> instructions;
    ArrayList<String> possibleInstructions;

    public RTNExecute() {
        fileName = "RTN.txt";
        readPossibles();
    }

    public RTNExecute(String fN) {
        fileName = fN;
        readPossibles();
    }

    public boolean run(Register instructionRegister) {
        read("fetch");
        execute();

        String opCode = instructionRegister.getValue().substring(0, Configuration.getFunctionBits()); //the first 5 bits in the instruction
        System.out.println(opCode);
        //register will hold the operation needed
        int decodeOpCode = BaseConversion.binaryToInt(opCode).intValue();

        read(possibleInstructions.get(decodeOpCode));

        return execute();
    }

    public boolean execute() {
        try {
            for (int currentLine = 0; currentLine < instructions.size(); currentLine++) {
                for (int currentInstruction = 0; currentInstruction < instructions.get(currentLine).size(); currentInstruction++) {
                    String current = instructions.get(currentLine).get(currentInstruction);
                    String[] arrows = current.split("<-");
                    if (arrows.length < 2) {
                        throw new Exception("This instruction does not contain a <-, or it isn't properly located.");
                    }

                    ArrayList<String> plusOps = null;
                    ArrayList<String> subOps = null;

                    for (String arrow : arrows) {
                        String[] plusOp = arrow.split("\\+");
                        plusOps = new ArrayList<>(Arrays.asList(plusOp));
                    }

                    for (String arrow : arrows) {
                        String[] subOp = arrow.split("\\-");
                        subOps = new ArrayList<>(Arrays.asList(subOp));
                    }

                    if (plusOps != null && plusOps.size() >= 2) {
                        System.out.println(plusOps.get(1) + " is added to " + plusOps.get(0) + "\n");
                    }

                    if (subOps != null && subOps.size() >= 2) {
                        System.out.println(subOps.get(1) + " is subtracted from " + subOps.get(0) + "\n");
                    }

                    System.out.println(arrows[1] + " goes into " + arrows[0] + ".\n");
                }
            }

            ClockCycle.increment(instructions.size());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private void readPossibles() {
        possibleInstructions = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.indexOf(':') != -1) {
                    possibleInstructions.add(line.split(":")[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getPossibles() {
        return possibleInstructions;
    }
    
    public int numOfPossibles() {
        return possibleInstructions.size();
    }

    private ArrayList<ArrayList<String>> read(String chunk) {
        instructions = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            boolean begin = false;
            String line;

            while ((line = reader.readLine()) != null) {
                String[] info = line.split(":");
                if (info[0].equals(chunk)) {
                    begin = true; //hits the chunk we want
                } else if (line.indexOf(':') != -1 && begin) {
                    return instructions;
                }

                if (begin) {
                    if (line.indexOf(':') == -1) {
                        line = line.replaceAll("\\s", "");
                        String[] instructionsArray = line.split(";");
                        ArrayList<String> instructionsList = new ArrayList<>(Arrays.asList(instructionsArray));

                        this.instructions.add(instructionsList);
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return instructions;
    }

    @Override
    public String toString() {
        return instructions.toString();
    }
}
