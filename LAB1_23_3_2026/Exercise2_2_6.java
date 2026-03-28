import java.util.Scanner;

public class Exercise2_2_6 {

    public static void Linear(Scanner scan){
        System.out.print("Enter a: ");
        double a = scan.nextDouble();

        System.out.print("Enter b: ");
        double b = scan.nextDouble();

        System.out.println("------------------------");

        if (a == 0){
            if (b == 0){
                System.out.println("Infinite solutions");
            } else {
                System.out.println("No solution");
            }
        } else {
            double x = -b / a;
            System.out.println("The solution x is: " + x);
        }
    }

    public static void System(Scanner scan){
        System.out.println("Enter a11, a12, b1:");
        double a11 = scan.nextDouble();
        double a12 = scan.nextDouble();
        double b1 = scan.nextDouble();

        System.out.println("Enter a21, a22, b2:");
        double a21 = scan.nextDouble();
        double a22 = scan.nextDouble();
        double b2 = scan.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0){
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0)
                System.out.println("Infinite solutions");
            else
                System.out.println("No solution");
        }
    }

    public static void Quadratic(Scanner scan){
        System.out.print("Enter a, b, c: ");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        if (a == 0){
            if (b == 0){
                if (c == 0)
                    System.out.println("Infinite solutions");
                else
                    System.out.println("No solution");
            } else {
                System.out.println("x = " + (-c / b));
            }
            return;
        }

        double delta = b*b - 4*a*c;

        if (delta > 0){
            double x1 = (-b + Math.sqrt(delta)) / (2*a);
            double x2 = (-b - Math.sqrt(delta)) / (2*a);
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0){
            System.out.println("Double root: x = " + (-b / (2*a)));
        } else {
            System.out.println("No real solution");
        }
    }

    public static void menu(){
        System.out.println("----------MENU--------");
        System.out.println("1. Linear Equation");
        System.out.println("2. Linear System");
        System.out.println("3. Quadratic Equation");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int choice;

        do {
            menu();
            choice = scan.nextInt();  

            switch(choice){
                case 1:
                    Linear(scan);
                    break;
                case 2:
                    System(scan);
                    break;
                case 3:
                    Quadratic(scan);
                    break;
                case 0:
                    System.out.println("Exit program");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while(choice != 0);
    }
}