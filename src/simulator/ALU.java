package simulator;
/**
 *
 * @author avery
 */
public class ALU 
{
    private final boolean canAdd;
    private final boolean canAnd;
    private final boolean canDivide;
    private final boolean canLessThan;
    private final boolean canMultiply;
    private final boolean canOr;
    private final boolean canSubtract;
    private final boolean canXor;

    public ALU(boolean add, boolean and, boolean divide,
               boolean less, boolean multiply, boolean or, 
               boolean subtract, boolean xor)
    {
        canAdd      = add;
        canAnd      = and;
        canDivide   = divide;
        canLessThan = less;
        canMultiply = multiply;
        canOr       = or;
        canSubtract = subtract;
        canXor      = xor;
    }
    
    public int add(int a, int b) throws Exception
    {
        if (canAdd)
        {
            return (a + b);
        }
        
        else
        {
            throw new Exception("This ALU cannot perform an add operation.");
        }
    }
    
    public int and(int a, int b) throws Exception
    {
        if (canAnd)
        {
            return (a & b);
        }
        
        else
        {
            throw new Exception("This ALU cannot perform an and operation.");
        }
    }
    
    public int divide(int a, int b) throws Exception
    {
        if (canDivide)
        {
            return (a / b);
        }
        
        else
        {
            throw new Exception("This ALU cannot perform a division operation.");
        }
    }
    
    public int lessThan(int a, int b) throws Exception
    {
        if (canLessThan)
        {
            if (a < b)
            {
                return 1;
            }
            
            else
            {
                return 0;
            }
        }
        
        else
        {
            throw new Exception("This ALU canno perform a less than operation.");
        }
    }
    
    public int multiply(int a, int b) throws Exception
    {
        if (canMultiply)
        {
            return (a * b);
        }
        
        else 
        {
            throw new Exception("This ALU cannot perform a multiplication operation.");
        }
    }
    
    public int or(int a, int b) throws Exception
    {
        if (canOr)
        {
            return (a | b);
        }
        
        else
        {
            throw new Exception("This ALU cannot perform an or operation.");
        }
    }
    
    public int subtract(int a, int b) throws Exception
    {
        if (canSubtract)
        {
            return (a - b);
        }
        
        else
        {
            throw new Exception("This ALU cannot perform a subtraction operation.");
        }
    }
    
    public int xor(int a, int b) throws Exception
    {
        if (canXor)
        {
            return (a ^ b);
        }
        
        else
        {
            throw new Exception("This ALU cannot perform an xor operation.");
        }
    }
}
