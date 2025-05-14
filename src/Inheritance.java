import java.util.*;

    
 class person {
    String name;
    int age;
    public person(String name , int age) {
        this.name = name;
        this.age = age;
    }
    public void printMethod() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
 class student extends person {
    String uni;
    public student(String name , int age, String uni) {
        super(name, age);
        this.uni = uni;
    }
    
    public void printMethod() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("University: " + uni);
    }
    
    
}

 class employee extends person {
    String office;
    public employee(String name , int age, String office) {
        super(name, age);
        this.office = office;
    }
    
    public void printMethod() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("office: " + office);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        student s = new student("Sharan", 20, "MIT");
        employee e = new employee("Mohan", 30, "Google");
        
        s.printMethod();
        e.printMethod();
    }
}