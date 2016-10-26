package simulator;

import java.util.*;

/**
 *
 * @author avery
 */
public class RegisterContainer 
{
    private ArrayList<Register> allRegisters;
    
    public RegisterContainer(int wordSize ,int numOfRegisters)
    {
        allRegisters = new ArrayList<Register>(numOfRegisters);
        
        for (int i = 0; i < numOfRegisters; i++)
        {
            allRegisters.add(new Register(("r" + Integer.toString(i)), wordSize, i));
        }
    }
    
    public int size()
    {
        return allRegisters.size();
    }
    
    public String toString()
    {
        String s = "All registers:\n";
        
        for (int i = 0; i < allRegisters.size(); i++)
        {
            s += allRegisters.get(i).toString() + "\n";
        }
        
        return s;
    }
    
}
