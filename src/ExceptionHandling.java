import java.util.*;
public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
         
        try {
           System.out.print("Enter your age: ");
            int age = scanner.nextInt();
             System.out.println("You entered: " + age);

        if(age<0) {
           throw new IllegalArgumentException("Age cannot be negative");
        }
      

        if(age>= 21) {
           
            System.out.println("You are eligible to buy liquor.");
        } 
        else {
            System.out.println("You are not eligible to buy liquor.");
        }
    }
    
            catch (InputMismatchException e) {
            System.out.println("Enter a valid age   "+e);
         }
         catch (IllegalArgumentException e) {
            System.out.println("Invalid age entered: " + e.getMessage());

         }
         finally {
            System.out.println("Finally block executed.");
        } 
        


        System.out.print("Enter two numbers to divide: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        divide(a, b);
        System.out.print("Enter an index to access an array: ");
        int index = scanner.nextInt();
        int[] arr = {1, 2, 3, 4, 5};
        accessArray(arr, index);

        System.out.print("Enter a string : ");
        String str = scanner.nextLine();
        try {
            System.out.println("You entered: " + str);
            System.out.println("String length: " + str.length());
           
        } catch (NullPointerException e) {
            System.out.println("The string is null, enter a valid input "+e);
        } 
    }
    public static void divide (int a, int b) {
        try {
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero  :"+e);
        }
    }
    public static void accessArray(int[] arr, int index) {
        try {
            System.out.println("Element at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds: "+e);
        }
    }


}
