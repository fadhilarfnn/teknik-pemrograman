// *************************************************************
// WeeklySales.java
//
// Sorts the sales staff in descending order by sales.
// ************************************************************
import java.util.Scanner;
public class WeeklySales
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("How many sales do you want to sort?");
        int size = scan.nextInt();
        Salesperson[] salesStaff = new Salesperson[size];

        System.out.println("Entaer the first name, lastname, and sales...");        
        for(int i = 0; i<size; i++){
            System.out.println("sales ke-" + (i+1));
            String firts = scan.next();
            String last = scan.next();
            int sales = scan.nextInt();
            salesStaff[i] = new Salesperson(firts, last, sales);
            System.out.println();
        }
        Sorting.insertionSort(salesStaff);
        System.out.println ("\nRanking of Sales for the Week\n");
        for (Salesperson s : salesStaff)
        System.out.println (s);
    }
} 