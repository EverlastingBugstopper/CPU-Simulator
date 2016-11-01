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

    public RTNExecute() {
        fileName = "RTN.txt";
    }

    public RTNExecute(String fN) {
        fileName = fN;
    }

    public boolean run(String chunk) {
        read(chunk);
        return execute();
    }

    public boolean execute() {
        try {
            for (int currentLine = 0; currentLine < instructions.size(); currentLine++) {
                for (int currentInstruction = 0; currentInstruction < instructions.get(currentLine).size(); currentInstruction++) {
                    String current = instructions.get(currentLine).get(currentInstruction);
                    String[] arrows = current.split("<-");
                    System.out.println(arrows[0] + " " + arrows[1]);
                }
            }

            ClockCycle.increment(instructions.size());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
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
