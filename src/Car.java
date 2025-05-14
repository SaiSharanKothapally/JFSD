import java.util.*;

public class Car {

     String brand, model;
    int speed, year;

    public Car(String brand,String model,int year){
        this.brand=brand;
        this.model=model;
        this.year=year;
        this.speed=0;

    }

    public void start(){
        System.err.println("The "+brand +" " +model +" has started ");
        speed=speed+10;
    }

    public void acceleration(){
        speed+=10;
         System.err.println("The "+brand +" " +model +" has increased the speed to "+speed+"MPH");
    }

    public void brake(){
        speed-=10;
        System.err.println("The "+brand +" "+model +" has apllied the brakes and the speed is "+speed+"MPH");
    }

    public void displayInfo(){
        System.out.println("The car brand and model are "+brand+" , "+model +" and the making year of car is "+year);
    }


    public static void main(String[] args) {

        Car c1=new Car("Honda", "Civic", 2014);
        c1.displayInfo();
        c1.start();
        c1.acceleration();
        c1.brake();
   
   
     }

}
