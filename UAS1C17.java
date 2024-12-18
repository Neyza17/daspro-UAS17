//Neyza Ratu A
//244107060119
//SIB 1C
//17

import java.util.Scanner;

public class UAS1C17 {
    public static void main(String[] args) {
        Scanner scanner17 = new Scanner(System.in);
        int jumlahTim17 = (19 % 3) + 4;
        String[] namaTim17 = new String[jumlahTim17];
        int[][] skor17 = new int[jumlahTim17][2];
        int[] totalSkor17 = new int[jumlahTim17];
        boolean dataInputted17 = false;

        int menu17;
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            menu17 = scanner17.nextInt();
            scanner17.nextLine();

            switch (menu17) {
                case 1:
                    for (int i17 = 0; i17 < jumlahTim17; i17++) {
                        System.out.print("Masukkan nama tim ke-" + (i17 + 1) + ": ");
                        namaTim17[i17] = scanner17.nextLine();

                        for (int j17 = 0; j17 < 2; j17++) {
                            boolean validInput17 = false;
                            while (!validInput17) {
                                System.out.print("Masukkan skor " + namaTim17[i17] + " untuk Level " + (j17 + 1) + ": ");
                                int skorInput17 = scanner17.nextInt();
                                scanner17.nextLine();
                                if (skorInput17 >= 0) {
                                    if (j17 == 0 && skorInput17 < 35) {
                                        skor17[i17][j17] = 0;
                                    } else {
                                        skor17[i17][j17] = skorInput17;
                                    }
                                    validInput17 = true;
                                } else {
                                    System.out.println("Input tidak valid. Skor harus positif atau nol.");
                                }
                            }
                        }

                        totalSkor17[i17] = skor17[i17][0] + skor17[i17][1];
                        if (totalSkor17[i17] % 2 == 0) {
                            totalSkor17[i17] -= 15;
                        }
                        if (skor17[i17][0] > 50 && skor17[i17][1] > 50) {
                            totalSkor17[i17] += 17;
                        }
                    }
                    dataInputted17 = true;
                    break;

                case 2:
                    if (!dataInputted17) {
                        System.out.println("Data belum diinput. Pilih menu 1 untuk menginput data.");
                        break;
                    }
                    System.out.println("\nTabel Skor Turnamen");
                    System.out.printf("%-15s%-10s%-10s%-10s\n", "Nama Tim", "Level 1", "Level 2", "Total Skor");
                    for (int i17 = 0; i17 < jumlahTim17; i17++) {
                        System.out.printf("%-15s%-10d%-10d%-10d\n", namaTim17[i17], skor17[i17][0], skor17[i17][1], totalSkor17[i17]);
                    }
                    break;

                case 3:
                    if (!dataInputted17) {
                        System.out.println("Data belum diinput. Pilih menu 1 untuk menginput data.");
                        break;
                    }

                    String timTerbaik17 = "";
                    int skorTerbaik17 = -1;
                    boolean seri17 = false;

                    for (int i17 = 0; i17 < jumlahTim17; i17++) {
                        if (totalSkor17[i17] > skorTerbaik17) {
                            timTerbaik17 = namaTim17[i17];
                            skorTerbaik17 = totalSkor17[i17];
                            seri17 = false;
                        } else if (totalSkor17[i17] == skorTerbaik17) {
                            seri17 = true;
                        }
                    }

                    if (seri17) {
                        System.out.println("Turnamen berakhir seri. Tim terbaik adalah Neyza Ratu Anastasya.");
                    } else {
                        System.out.println("Selamat kepada Tim " + timTerbaik17 + " yang telah memenangkan kompetisi!");
                    }
                    break;

                case 4:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu 1-4.");
            }
        } while (menu17 != 4);

        scanner17.close();
    }
}