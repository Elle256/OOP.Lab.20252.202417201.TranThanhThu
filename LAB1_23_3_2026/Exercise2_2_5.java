import java.util.Scanner;
public class Exercise2_2_5 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        double a,b;
         while (true) {
            System.out.print("Enter number a: ");
            if (scan.hasNextDouble()) {
                a = scan.nextDouble();
                break;
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scan.next(); 
            }
        }
        while (true) {
            System.out.print("Enter number b: ");
            if (scan.hasNextDouble()) {
                b = scan.nextDouble();
                break;
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scan.next();
            }
        }
        double sum = a+b;
         System.out.println("The sum of "+a+" and "+b+" is: "+ sum);
        double diff = a-b;
        System.out.println("The difference of "+a+" and "+b+" is: "+ diff);
        double mul = a*b;
         System.out.println("The product of "+a+" and "+b+" is: "+ mul);
        if (b==0){
            System.out.println("Cannot divided by 0");
        }
        else{
            double quotient = a/b;
            System.out.println("The quotient of "+a+" and "+b+" is: "+quotient);
        }

    }
}