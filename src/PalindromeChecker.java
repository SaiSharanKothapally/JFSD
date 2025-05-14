import java.util.*;
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter The String you want to Check if it is Palindrome or not");
        String pc = sc.nextLine();
        String reversal=reversal(pc);
        if(pc==reversal){
            System.out.println("the given String is a palindrome");
        } else{
            System.out.println("The String is not a Palindrome");
        }
        
    }

    public static String reversal(String str){
            StringBuilder sb=new StringBuilder(str);
            return  sb.reverse().toString();
        }

}
