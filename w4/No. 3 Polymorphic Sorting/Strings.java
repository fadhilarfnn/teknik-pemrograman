import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        String[] StrList;
        int size;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many Strings do you want to short?");
        size = scan.nextInt();
        StrList = new String[size];
        System.out.println("Enter the Strings...");
        for(int i = 0; i < size; i++){
            StrList[i] = scan.next();
        }
        System.out.println();
        Sorting.selectionSort(StrList);
        System.out.println("your Strings in sorted order ascending...");
        for(int i = 0; i<size; i++){
            System.out.print(StrList[i] + " ");
        }
        System.out.println();
        Sorting.insertionSort(StrList);
        System.out.println("your Strings in sorted order descending...");
        for(int i = 0; i<size; i++){
            System.out.print(StrList[i] + " ");
        }
        System.out.println();
    }   
}
