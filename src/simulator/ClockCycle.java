/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

/**
 *
 * @author avery
 */
public class ClockCycle {

    private static int value;

    private static ClockCycle self = new ClockCycle();

    public ClockCycle() {
        value = 0;
    }

    public ClockCycle(int v) {
        value = v;
    }

    public static ClockCycle increment() {
        value += 1;
        return self;
    }

    public static ClockCycle increment(int v) {
        value += v;
        return self;
    }

    public static ClockCycle get() {
        return self;
    }

    public static ClockCycle set(int v) {
        value = v;
        return self;
    }

    public static int getValue() {
        return value;
    }

    public static String toStaticString() {
        return Integer.toString(self.getValue());
    }
}
