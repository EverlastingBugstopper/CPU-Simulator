package simulator;

import java.io.*;
import java.util.*;

/**
 *
 * @author avery
 */
public class Configuration 
{
    private int wordSize;
    private int busSize;
    private int numOfRegisters;
    private String fileName = "config.txt";
    
    public Configuration()
    {
        read(fileName);
    }
    
    public void read(String fN)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            
            String line;
            
            while ((line = reader.readLine()) != null)
            {
                String [] info = line.split(":");
                
                switch (info[0])
                {
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
                    default:
                        System.out.println("\nUnusable data: " + info[0] + info[2] + "\n");
                }
            }
            
            reader.close();
        }
        
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public int getWordSize()
    {
        return wordSize;
    }
    
    public void setWordSize(int wS)
    {
        wordSize = wS;
    }
    
    public int getBusSize()
    {
        return busSize;
    }
    
    public void setBusSize(int bS)
    {
        busSize = bS;
    }
    
    public int getNumOfRegisters()
    {
        return numOfRegisters;
    }
    
    public void setNumOfRegisters(int nOR)
    {
        numOfRegisters = nOR;
    }
    
    public String getFileName()
    {
        return fileName;
    }
    
    public void setFileName(String f)
    {
        fileName = f;
    }
    
    @Override
    public String toString()
    {
        String s = "Number of registers: " + numOfRegisters;
        s += "\nWord Size: " + wordSize;
        s += "\nBus Size: " + busSize;
        return s;
    }
}
