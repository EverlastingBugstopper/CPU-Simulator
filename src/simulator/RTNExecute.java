package simulator;

import java.io.*;
import java.util.*;

/**
 *
 * @author avery
 */
public class RTNExecute {

    private final String fileName;
    private ArrayList<ArrayList<String>> instructions;
    private ArrayList<String> possibleInstructions;
    private RegisterContainer registerContainer;
    private Register instructionRegister;
    private ALU alu;
    private int arg1;
    private int arg2;
    private int operation;

    public RTNExecute() {
        fileName = "RTN.txt";
        readPossibles();
    }

    public RTNExecute(String fN) {
        fileName = fN;
        readPossibles();
    }

    public boolean run(RegisterContainer rC, Register iR, ALU al) {
        registerContainer = rC;
        instructionRegister = iR;
        alu = al;
        read("fetch");
        execute();
        String irWord = instructionRegister.getValue();
        int funcStop = Configuration.getFunctionBits();
        int arg1Stop = funcStop + Configuration.getArg1Bits();
        int arg2Stop = arg1Stop + Configuration.getArg2Bits();
        String op = irWord.substring(0, funcStop); //the first n bits in the instruction
        String rg1 = irWord.substring(funcStop, arg1Stop);
        String rg2 = irWord.substring(arg1Stop, arg2Stop);
        //register will hold the operation needed
        operation = BaseConversion.binaryToInt(op).intValue();
        arg1 = BaseConversion.binaryToInt(rg1).intValue();
        arg2 = BaseConversion.binaryToInt(rg2).intValue();

        read(possibleInstructions.get(operation));

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

                    Register rSource = null;
                    Register rDest = null;
                    System.out.println(arrows[1] + " goes into " + arrows[0] + ".\n");
                    
                    if (arrows[1].charAt(0) == 'R') {
                        if (arrows[1].charAt(1) == 's') {
                            rSource = registerContainer.getRegister(arg1);
                        } else if (arrows[1].charAt(1) == 'd') {
                            rSource = registerContainer.getRegister(arg2);
                        }
                    }
                    if (arrows[0].charAt(0) == 'R') {
                        System.out.println("0" + arrows[0]);
                        if (arrows[0].charAt(1) == 's') {
                            rDest = registerContainer.getRegister(arg1);
                        } else if (arrows[0].charAt(1) == 'd') {
                            rDest = registerContainer.getRegister(arg2);
                        }
                    }
                    
                    if (arrows[0].charAt(0) == 'A') {
                        if (rSource != null) {
                            alu.setA(rSource.getIntValue());
                        } else if (rDest != null) {
                            alu.setA(rDest.getIntValue());
                        }
                    }
                    
                    if (arrows[0].charAt(0) == 'B') {
                        if (rSource != null) {
                            alu.setB(rSource.getIntValue());
                        } else if (rDest != null) {
                            alu.setB(rDest.getIntValue());
                        }
                    }
                    try {
                        if (arrows[1].charAt(0) == 'A' && arrows[1].charAt(2) == 'B') {
                            alu.execute(arrows[1].charAt(1));
                        }
                    } catch (Exception e) {} //nothing is actually wrong here... probably
                    
                    if (arrows[1].charAt(0) == 'C' && rDest != null) {
                        rDest.setValue(alu.getC());
                    }
                    
                    if (rSource != null && rDest != null) {
                        rDest.setValue(rSource.getValue());
                    }

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

    private ArrayList<ArrayList<String>> read(String opName) {
        instructions = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            boolean begin = false;
            String line;

            while ((line = reader.readLine()) != null) {
                String[] info = line.split(":");
                if (info[0].equals(opName)) {
                    begin = true; //hits the opName we want
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
