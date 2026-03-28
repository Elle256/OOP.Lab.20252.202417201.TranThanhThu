import java.util.Scanner;
import java.util.Arrays;
public class Exercise6_5 {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static int partition(int[] arr,int low,int high){
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
      System.out.print("Enter the number of elements in the array:");
        int n = scan.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        quickSort(arr, 0, n - 1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double average = (double) sum / n;
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum of the elements: " + sum);
        System.out.println("Average of the elements: " + average);
    }
}