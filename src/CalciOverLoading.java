import java.util.*;

public class CalciOverLoading {

    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
    public double add(int a, double b) {
        return a + b;
    }
    public double add(double a, int b) {
        return a + b;
    }
    public int add(int a, int b,int c) {
        return a + b+c;
    }

    public static void main(String[] args) {
        CalciOverLoading c1=new CalciOverLoading();
         System.out.println(c1.add(5,9));
         System.out.println(c1.add(9,9,8));
         System.out.println(c1.add(5.5,9));
         System.out.println(c1.add(5,9.9));
    }

}
