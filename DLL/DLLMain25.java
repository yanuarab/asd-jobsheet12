package DLL;

import java.util.Scanner;

public class DLLMain25 {
    static Mahasiswa25 inputMahasiswa(Scanner scan) {
        System.out.print("Masukkan NIM: ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Kelas: ");
        String kelas = scan.nextLine();
        System.out.print("Masukkan IPK: ");
        double ipk = scan.nextDouble();
        scan.nextLine(); // Membersihkan newline
        return new Mahasiswa25(nim, nama, kelas, ipk);
    }

    public static void main(String[] args) {
        DoubleLinkedList25 list = new DoubleLinkedList25();
        Scanner scan = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Double Linked List Mahasiswa");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus di awal");
            System.out.println("4. Hapus di akhir");
            System.out.println("5. Hapus data berdasarkan index");
            System.out.println("6. Hapus data setelah NIM");
            System.out.println("7. Tampilkan data");
            System.out.println("8. Sisipkan data");
            System.out.println("9. Cari Mahasiswa berdasarkan NIM");
            System.out.println("10. Tampilkan data pertama");
            System.out.println("11. Tampilkan data terakhir");
            System.out.println("12. Tampilkan data pada indeks tertentu");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1:
                    Mahasiswa25 mhsAwal = inputMahasiswa(scan);
                    list.addFirst(mhsAwal);
                    System.out.println("Data berhasil ditambahkan.");
                    break;
                case 2:
                    Mahasiswa25 mhsAkhir = inputMahasiswa(scan);
                    list.addLast(mhsAkhir);
                    System.out.println("Data berhasil ditambahkan.");
                    break;
                case 3:
                    list.removeFirst();
                    break;
                case 4:
                    list.removeLast();
                    break;
                case 5:
                    System.out.print("Masukkan Index: ");
                    int index = scan.nextInt();
                    list.remove(index);
                    break;
                case 6:
                    System.out.print("Masukkan NIM: ");
                    String keyNim = scan.nextLine();
                    list.removeAfter(keyNim);
                    break;
                case 7:
                    list.print();
                    break;
                case 8:
                    System.out.println("Sisipkan data setelah NIM : ");
                    String key = scan.nextLine();
                    Mahasiswa25 newMhs = inputMahasiswa(scan);
                    list.insertAfter(key, newMhs);
                    break;
                case 9:
                    System.out.println("Masukkan NIM yang dicari: ");
                    String nim = scan.nextLine();
                    Node25 found = list.search(nim);
                    if (found != null) {
                        System.out.println("Data ditemukan: ");
                        found.data.tampil();
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;
                case 10:
                    list.getFirst();
                    break;
                case 11:
                    list.getLast();
                    break;
                case 12:
                    System.out.print("Masukkan indeks: ");
                    int idx = scan.nextInt();
                    scan.nextLine();
                    list.getIndex(idx);
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        } while (pilihan != 0);
        scan.close();
    }
}
