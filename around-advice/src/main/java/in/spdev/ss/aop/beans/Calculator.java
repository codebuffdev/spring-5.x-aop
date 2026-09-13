package in.spdev.ss.aop.beans;

public class Calculator {
    public int add(int x, int y) {
        System.out.println("In Calculator.add(" + x + "," + y + ")");
        return x + y;
    }
}
