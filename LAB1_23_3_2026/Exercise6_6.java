import java.util.Scanner;
public class Exercise6_6 {
    public static void input(Scanner scan, int[][] matrix,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=scan.nextInt();
            }
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n,m;
        System.out.println("Enter the number of rows: ");
        n = scan.nextInt();

        System.out.println("Enter the number of columns: ");
        m = scan.nextInt();

        int [][] arr = new int[n][m] ;
        int [][] arr1 = new int[n][m];
        int [][] arr2 = new int[n][m];
       
        System.out.println("Input matrix 1: ");
        input(scan, arr,n,m);

        System.out.println("Input matrix 2: ");
        input(scan, arr1, n,m); 

        System.out.println("------The result matrix is------------");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr2[i][j]=arr[i][j]+arr1[i][j];
            }
        }

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr2[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }

    }
}
