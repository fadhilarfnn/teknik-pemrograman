package JavaProblems;

import java.util.Arrays;

public class ProblemThree {
    public static void main(String[] args) {
        int arr[] = {12, 4, 3, 1, 9, 657};
        int n = 3; // Mencari elemen terbesar ke-3

        int ans = Arrays.stream(arr)
                .boxed()                             // Konversi ke Stream<Integer>
                .sorted((a, b) -> Integer.compare(b, a))     // Urutkan descending
                .skip(n - 1)                        // Lewati 2 elemen pertama
                .findFirst()                             // Ambil elemen yang tersisa
                .orElse(0);                           // Nilai default jika tidak ada

        System.out.println("Elemen terbesar ke-3 adalah: " + ans);
    }
}
