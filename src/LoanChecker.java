import java.util.*;
public class LoanChecker {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to TechQuest Bank");
        System.out.println("Please Enter your Age");

         int age=sc.nextInt();
        System.out.println("Please Enter your Income");
         double income=sc.nextDouble();
         System.out.println("Please Enter your Credit Score");
         int credit=sc.nextInt();

         if (age<21) {
             System.out.println("Sorry We cannot process your Loan as your age is less than 21");
             return;
            
         } else if (income<50000){
            System.out.println("Sorry We cannot process your Loan as your income is less than 50,000");
            
         } else if(credit<700){
            System.out.println("Sorry We cannot process your Loan as your Credit Score is less than 700");
         } else{
            System.out.println("Congratulation you are eligible for the Loan , One of our agent will contact you");
         }
        
    }

}
