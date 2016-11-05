package simulator;

/**
 *
 * @author avery
 */
public class Register 
{
   private int size;
   private String name;
   private final int number;
   private int save;
   
   public Register(String nam, int rS, int num)
   {
        name = nam;
        size = rS;
        number = num;
        save = 1;
   }
   
   public int getSize()
   {
       return size;
   }
   
   public void setSize(int s)
   {
       size = s;
   }
   
   public String getName()
   {
       return name;
   }
   
   public void setName(String n)
   {
       name = n;
   }
   
   public int getNumber()
   {
       return number;
   }
   
   //There is no setNumber because there should not be conflicting registers
   
   public String toString()
   {
       String s = "Register " + name + ":";
       s += "\nNumber: " + number;
       s += "\nSize: " + size;
       
       return s;
   }
}
