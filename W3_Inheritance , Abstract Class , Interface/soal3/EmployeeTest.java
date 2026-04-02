public class EmployeeTest {
    public static void main(String[] args) {
        // Mendeklarasikan dan mengalokasikan array untuk 3 objek Employee 
        Employee[] staff = new Employee[3];

        // Inisialisasi data karyawan
        staff[0] = new Employee("Antonio Rossi", 5000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);
        
        // Menaikkan gaji setiap staf sebesar 5% 
        for (int i = 0; i < 3; i++) {
            staff[i].raiseSalary(5);
        }

        // Mencetak data dari setiap staf 
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }      

        System.out.println("hasil compare gaji staff 1 dan 2: ");
        switch(staff[1].compare(staff[2])){
            case -1 :
                System.out.println("gaji staff 1 lebih kecil dari gaji staff 2");
                break;
            case 0 :
                 System.out.println("gaji staff 1 sama dengan gaji staff 2");
                break;
            case 1 :
                 System.out.println("gaji staff 1 lebih besar dari gaji staff 2");
                break;
        }
    }
}
