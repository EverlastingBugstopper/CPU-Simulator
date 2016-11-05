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
    private int zeroFlag;
    private int signFlag;
    private int overflowFlag;

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
        zeroFlag = 0;
        signFlag = 0;
        overflowFlag = 0;
    }
    
    private int add(int a, int b) throws Exception
    {
        int result;
        
        if (canAdd)
        {
            try
            {
                result = Math.addExact(a, b);
            }
            
            catch (ArithmeticException e)
            {
                result = a + b;
                overflowFlag = 1;
            }
        }
        
        else
        {
            throw new Exception("This ALU cannot perform an add operation.");
        }
        
        return result;
    }
    
    private int and(int a, int b) throws Exception
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
    
    private int divide(int a, int b) throws Exception
    {
        if (canDivide)
        {
            if (b != 0)
            {
                return (a / b);
            }
            
            else
            {
                throw new Exception("You cannot divide by 0.");
            }
        }
        
        else
        {
            throw new Exception("This ALU cannot perform a division operation.");
        }
    }
    
    public int execute(int operation, int a, int b) throws Exception
    {
        int result;
        switch(operation)
        {
            case 0:
                result = add(a, b);
                break;
            case 1:
                result = and(a, b);
                break;
            case 2:
                result = divide(a, b);
                break;
            case 3:
                result = lessThan(a, b);
                break;
            case 4:
                result = multiply(a, b);
                break;
            case 5:
                result = or(a, b);
                break;
            case 6:
                result = subtract(a, b);
                break;
            case 7:
                result = xor(a, b);
                break;
            default:
                throw new Exception("The operation provided does not exist.");
        }
        
        if (result == 0)
        {
            zeroFlag = 1;
        }
        
        if (result < 0)
        {
            signFlag = 1;
        }
        
        return result;
    }
    
    public int getOverflowFlag()
    {
        return overflowFlag;
    }
    
    public int getSignFlag()
    {
        return signFlag;
    }
    
    public int getZeroFlag()
    {
        return zeroFlag;
    }
    
    private int lessThan(int a, int b) throws Exception
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
            throw new Exception("This ALU cannot perform a less than operation.");
        }
    }
    
    private int multiply(int a, int b) throws Exception
    {
        int result;
        
        if (canMultiply)
        {
            try
            {
                result = Math.multiplyExact(a, b);
            }
            
            catch (ArithmeticException e)
            {
                result = a * b;
                overflowFlag = 1;
            }
        }
        
        else 
        {
            throw new Exception("This ALU cannot perform a multiplication operation.");
        }
        
        return result;
    }
    
    private int or(int a, int b) throws Exception
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
    
    public void resetFlags()
    {
        zeroFlag = 0;
        signFlag = 0;
        overflowFlag = 0;
    }
    
    private int subtract(int a, int b) throws Exception
    {
        int result;
        
        if (canSubtract)
        {
            try
            {
                result = Math.subtractExact(a, b);
            }
            
            catch (ArithmeticException e)
            {
                result = a - b;
                overflowFlag = 1;
            }
        }
        
        else
        {
            throw new Exception("This ALU cannot perform a subtraction operation.");
        }
        
        return result;
    }
    
    private int xor(int a, int b) throws Exception
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
