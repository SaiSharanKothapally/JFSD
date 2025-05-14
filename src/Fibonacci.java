import java.util.*;
public class Fibonacci {
 public static int fibonacci(int n){
    if(n<=1){
        return n;
    } else {
        return fibonacci(n-1)+fibonacci(n-2);
    }
 }
 
 public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the no of terms you want in fibonacci sequence");
    int n=sc.nextInt();
    System.out.println("The "+n +"terms of fibonacci sequence are");
    for(int i=0;i<n;i++){
        System.out.print(+fibonacci(i)+"  ");

    }
 }

}
