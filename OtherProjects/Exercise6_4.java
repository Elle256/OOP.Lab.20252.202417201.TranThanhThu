import java.util.Scanner;
public class Exercise6_4 {
    public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
     int m = 0;
     while (true) {
        System.out.print("Enter the month:");
        String month = scan.nextLine();
        if(month.equalsIgnoreCase("January")||month.equalsIgnoreCase("Jan.")||month.equalsIgnoreCase("Jan")||month.equals("1")){
            m=1;
        } else if(month.equalsIgnoreCase("February")||month.equalsIgnoreCase("Feb.")||month.equalsIgnoreCase("Feb")||month.equals("2")){
            m=2;
        } else if(month.equalsIgnoreCase("March")||month.equalsIgnoreCase("Mar.")||month.equalsIgnoreCase("Mar")||month.equals("3")){
            m=3;
        } else if(month.equalsIgnoreCase("April")||month.equalsIgnoreCase("Apr.")||month.equalsIgnoreCase("Apr")||month.equals("4")){
            m=4;
        } else if(month.equalsIgnoreCase("May")||month.equalsIgnoreCase("May.")||month.equalsIgnoreCase("May")||month.equals("5")){
            m=5;
        } else if(month.equalsIgnoreCase("June")||month.equalsIgnoreCase("Jun.")||month.equalsIgnoreCase("Jun")||month.equals("6")){
            m=6;
        } else if(month.equalsIgnoreCase("July")||month.equalsIgnoreCase("Jul.")||month.equalsIgnoreCase("Jul")||month.equals("7")){
            m=7;
        } else if(month.equalsIgnoreCase("August")||month.equalsIgnoreCase("Aug.")||month.equalsIgnoreCase("Aug")||month.equals("8")){
            m=8;
        } else if(month.equalsIgnoreCase("September")||month.equalsIgnoreCase("Sep.")||month.equalsIgnoreCase("Sep")||month.equals("9")){
            m=9;
        } else if(month.equalsIgnoreCase("October")||month.equalsIgnoreCase("Oct.")||month.equalsIgnoreCase("Oct")||month.equals("10")){
            m=10;
        } else if(month.equalsIgnoreCase("November")||month.equalsIgnoreCase("Nov.")||month.equalsIgnoreCase("Nov")||month.equals("11")){
            m=11;
        } else if(month.equalsIgnoreCase("December")||month.equalsIgnoreCase("Dec.")||month.equalsIgnoreCase("Dec")||month.equals("12")){
            m=12;
        } else {
            System.out.println("Invalid input. Please enter a valid month.");
            continue;
        }
        break;
     }
     int year = 0;
     while(true){
        System.out.print("Enter the year:");
        year = scan.nextInt();
        if(year < 0){
            System.out.println("Invalid input. Please enter a valid year.");
            continue;
        }
        break;
        }
        int days = 0;
        switch (m) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                System.out.println("Number of days: " + days);
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                System.out.println("Number of days: " + days);
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    days = 29;
                } else {
                    days = 28;
                }
                System.out.println("Number of days: " + days);
                break;
            default:
                days = -1; 
        }
     }
}
