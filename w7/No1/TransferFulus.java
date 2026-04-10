class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Berikan komentar apa yang dilakukan pada blok ini? 
                //lock acc1 biar ga bisa diambil thread lain
                System.out.println("Thread t1 sedang mengunci objek acc1, thread lain tunggu giliran");
                try { Thread.sleep(100); } catch (Exception e) {} // Simulasi dengan memberikan jeda. Mengapa diperlukan Exception?
                // pakai exception karena Thread.sleep melempar InterruptedException

                synchronized (acc2) { // Berikan komentar apa yang dilakukan pada blok ini?
                    //lock acc1 biar ga bisa diambil thread lain
                    System.out.println("Thread t1 sedang mengunci objek acc2 juga, thread lain tunggu giliran");
                    acc2.balance += acc1.balance;
                }
            }
        });

        // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            synchronized (acc1) { // Berikan komentar apa yang dilakukan pada blok ini?
                //lock acc1 biar ga bisa diambil thread lain
                System.out.println("Thread t2 sedang mengunci objek acc1, thread lain tunggu giliran");
                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc2) { // Berikan komentar apa yang dilakukan pada blok ini?
                    //lock acc2 biar ga bisa diambil thread lain
                    System.out.println("Thread t2 sedang mengunci objek acc2 juga, thread lain tunggu giliran");
                    acc1.balance += acc2.balance;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
		System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}
