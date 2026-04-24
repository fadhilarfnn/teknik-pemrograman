import java.util.Scanner;

class Deret implements Runnable{
    private int IDThread;
    private long Awal;
    private long Akhir;
    long Pasial;

    public Deret(int IDThread, long Awal, long Akhir){
        this.IDThread = IDThread;
        this.Awal = Awal;
        this.Akhir = Akhir;
        this.Pasial = 0;
    }

    @Override
    public void run(){
        for (long i = Awal; i <= Akhir; i++ ){
            Pasial += i;
        }
        System.out.println("Hasil Parsial Thread " + IDThread + " = " + Pasial);
    }
}

public class DeretPalarel {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan jumlah thread\t: ");
        int JumlahThread = input.nextInt();
        System.out.print("Masukan angka akhir\t: ");
        long AngkaAkhir = input.nextLong();
        input.close();

        long Interval = AngkaAkhir / JumlahThread;
        long Sisa = AngkaAkhir % JumlahThread;

        Deret[] Deret = new Deret[JumlahThread];
        Thread[] Thread  = new Thread[JumlahThread];

        long Awal = 1;
        for(int i = 0; i < JumlahThread; i++){
            long Akhir = Awal + Interval -1;
            if(i < Sisa){
                Akhir += 1;
            }

            Deret[i] = new Deret(i+1, Awal, Akhir);
            Thread[i] = new Thread(Deret[i]);

            System.out.println("Thread " + (i+1) + ": Menjumlahkan " + Awal + "-" + Akhir);

            Awal = Akhir + 1;
        }

        for(Thread t : Thread){
            t.start();  
        }

        
        for(Thread t : Thread){
            try{t.join();}catch (Exception e) {}
        }

        long Total = 0;
        for(int i = 0; i < JumlahThread; i++){
            Total += Deret[i].Pasial;
        }
        System.out.println("TOtal = " + Total);
    }
}