import java.util.*;
public class PrimeNumbers {
    public static void main(String[] args) {
        
   int n=100;
   int count;
   System.out.println("The prime numbers between 1 to 100 are:");

   for(int i=1;i<=n;i++){
         count=0;
    for(int j=1;j<=i;j++){
        if(i%j==0){
            count++;
        }
        
    }
    if(count<3){
        System.out.println(i);
    }
   }
}
}