
import java.util.*;

abstract class AbsClass {
    abstract void display();
    void show() {
        System.out.println(" method implemented in abstract class.");
    }
}
class A extends AbsClass {
    void display() {
        System.out.println("Class A  implementation of abstract method.");
    }
}
interface InterfaceClass {
    void show();
}
class I implements InterfaceClass {
    public void show() {
        System.out.println("Interface method implementation in child class.");
    }
}

class I1 implements InterfaceClass {
    public void show() {
        System.out.println("Interface method implementation in child2 class.");
    }
}
public class InterfaceAndAbstract {
  
    public static void main(String[] args) {
        A x = new A();
        x.display();
        x.show();

        I impl = new I();
        impl.show();
        I1 impl1 = new I1();
        impl1.show();
       
}
}
