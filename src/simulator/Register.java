package simulator;

import java.math.BigInteger;

/**
 *
 * @author avery
 */
public class Register {

    private int size;
    private String name;
    private final int number;
    private int save;
    private String value;

    public Register(String nam, int rS, int num, String val) throws Exception {
        name = nam;
        size = rS;
        number = num;
        save = 1;
        value = BaseConversion.formatBinary(val, size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int s) {
        size = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public int getNumber() {
        return number;
    }

    public void setValue(String val) throws Exception {
        value = BaseConversion.formatBinary(val, size);
    }

    public void setValue(int val) throws Exception {
        value = BaseConversion.intToBinary(new BigInteger(Integer.toString(val)), size);
    }

    public String getValue() {
        return value;
    }

    //There is no setNumber because there should not be conflicting registers
    @Override
    public String toString() {
        String s = "Register " + name + ":";
        s += "\nNumber: " + number;
        s += "\nSize: " + size;

        return s;
    }
}
