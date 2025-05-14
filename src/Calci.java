import java.util.*;

public class Calci{
public static void main(String [] args){

    Scanner sc= new Scanner(System.in);

    System.err.println("New Project Calci");
    double x,y;
    System.out.println("Enter the two numbers");
    x= sc.nextDouble();
    y=sc.nextDouble();
    System.out.println("Enter the operation you want to calculate (+ , * , - ,/)");
    char op= sc.next().charAt(0);
    double val;
    switch (op) {
        case '+':
            val=x+y;
             System.out.println("The Result is "+val);
            
            break;
        case '*':
            val=x*y;
             System.out.println("The Result is "+val);
            
            break;
        case '-':
            val=x-y;
             System.out.println("The Result is "+val);
            
            break;
        case '/':
            if (y!=0) {
                val=x/y;
                System.out.println("The Result is "+val);
            }
            else{
                System.out.println("Error divided by zero");
            }
            
            
            break;
    
        default:
            System.out.println("Enter the correct operator");
            break;
    }




}
}