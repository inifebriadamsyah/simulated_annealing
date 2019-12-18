package okhtemp;

import okhtemp.SimulatedAnnealing;
import java.util.Scanner;
import static okhtemp.MainHc.directory;
import static okhtemp.MainLd.directory;

public class MainSa{

    static final String directory = "E:/Frequently Used/Edukasi/Kuliah/Semester 7/Optimasi Kombinatorik dan Heuristik/Toronto/";

    public static void main(String[] args) {
        String dir_carf92_stu = directory + "car-f-92.stu";
        String dir_carf92_crs = directory + "car-f-92.crs";

        String dir_cars91_stu = directory + "car-s-91.stu";
        String dir_cars91_crs = directory + "car-s-91.crs";

        String dir_earf83_stu = directory + "ear-f-83.stu";
        String dir_earf83_crs = directory + "ear-f-83.crs";

        String dir_hecs92_stu = directory + "hec-s-92.stu";
        String dir_hecs92_crs = directory + "hec-s-92.crs";

        String dir_kfus93_stu = directory + "kfu-s-93.stu";
        String dir_kfus93_crs = directory + "kfu-s-93.crs";

        String dir_lsef91_stu = directory + "lse-f-91.stu";
        String dir_lsef91_crs = directory + "lse-f-91.crs";

        String dir_purs93_stu = directory + "pur-s-93.stu";
        String dir_purs93_crs = directory + "pur-s-93.crs";

        String dir_ryes93_stu = directory + "rye-s-93.stu";
        String dir_ryes93_crs = directory + "rye-s-93.crs";

        String dir_staf83_stu = directory + "sta-f-83.stu";
        String dir_staf83_crs = directory + "sta-f-83.crs";

        String dir_tres92_stu = directory + "tre-s-92.stu";
        String dir_tres92_crs = directory + "tre-s-92.crs";

        String dir_utas92_stu = directory + "uta-s-92.stu";
        String dir_utas92_crs = directory + "uta-s-92.crs";

        String dir_utes92_stu = directory + "ute-s-92.stu";
        String dir_utes92_crs = directory + "ute-s-92.crs";

        String dir_yorf83_stu = directory + "yor-f-83.stu";
        String dir_yorf83_crs = directory + "yor-f-83.crs";

        Scanner in = new Scanner(System.in);

        int iterasi = 0;

        System.out.println("=== OPTIMIZING WITH SIMULATED ANNEALING === \n");
        System.out.println("1. Car-f-92");
        System.out.println("2. Car-s-91");
        System.out.println("3. Ear-f-83");
        System.out.println("4. Hec-s-92");
        System.out.println("5. Kfu-s-93");
        System.out.println("6. Lse-f-91");
        System.out.println("7. Pur-s-93");
        System.out.println("8. Rye-s-93");
        System.out.println("9. Sta-f-83");
        System.out.println("10. Tre-s-92");
        System.out.println("11. Uta-s-92");
        System.out.println("12. Ute-s-92");
        System.out.println("13. yor-f-83");
        System.out.println("100. EXIT");

        System.out.print("\nPilih File : ");
        int input = in.nextInt();
        
        switch (input) {
            case 1:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime = System.nanoTime();
                SimulatedAnnealing.run(dir_carf92_stu, dir_carf92_crs, 1000, iterasi);
                long endTime = System.nanoTime();
                long totalTime = endTime - startTime;
                System.out.println("Total waktu : " + (double) totalTime / 1000000000 + " detik");
                break;
            case 2:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime2 = System.nanoTime();
                SimulatedAnnealing.run(dir_cars91_stu, dir_cars91_crs, 100, iterasi);
                long endTime2 = System.nanoTime();
                long totalTime2 = endTime2 - startTime2;
                System.out.println("Total waktu : " + (double) totalTime2 / 1000000000 + " detik");
                break;
            case 3:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime3 = System.nanoTime();
                SimulatedAnnealing.run(dir_earf83_stu, dir_earf83_crs, 100, iterasi);
                long endTime3 = System.nanoTime();
                long totalTime3 = endTime3 - startTime3;
                System.out.println("Total waktu : " + (double) totalTime3 / 1000000000 + " detik");
                break;
            case 4:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime4 = System.nanoTime();
                SimulatedAnnealing.run(dir_hecs92_stu, dir_hecs92_crs, 100, iterasi);
                long endTime4 = System.nanoTime();
                long totalTime4 = endTime4 - startTime4;
                System.out.println("Total waktu : " + (double) totalTime4 / 1000000000 + " detik");
                break;
            case 5:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime5 = System.nanoTime();
                SimulatedAnnealing.run(dir_kfus93_stu, dir_kfus93_crs, 100, iterasi);
                long endTime5 = System.nanoTime();
                long totalTime5 = endTime5 - startTime5;
                System.out.println("Total waktu : " + (double) totalTime5 / 1000000000 + " detik");
                break;
            case 6:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime6 = System.nanoTime();
                SimulatedAnnealing.run(dir_lsef91_stu, dir_lsef91_crs, 100, iterasi);
                long endTime6 = System.nanoTime();
                long totalTime6 = endTime6 - startTime6;
                System.out.println("Total waktu : " + (double) totalTime6 / 1000000000 + " detik");
                break;
            case 7:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime7 = System.nanoTime();
                SimulatedAnnealing.run(dir_purs93_stu, dir_purs93_crs, 100, iterasi);
                long endTime7 = System.nanoTime();
                long totalTime7 = endTime7 - startTime7;
                System.out.println("Total waktu : " + (double) totalTime7 / 1000000000 + " detik");
                break;
            case 8:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime8 = System.nanoTime();
                SimulatedAnnealing.run(dir_ryes93_stu, dir_ryes93_crs, 100, iterasi);
                long endTime8 = System.nanoTime();
                long totalTime8 = endTime8 - startTime8;
                System.out.println("Total waktu : " + (double) totalTime8 / 1000000000 + " detik");
                break;
            case 9:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime9 = System.nanoTime();
                SimulatedAnnealing.run(dir_staf83_stu, dir_staf83_crs, 100, iterasi);
                long endTime9 = System.nanoTime();
                long totalTime9 = endTime9 - startTime9;
                System.out.println("Total waktu : " + (double) totalTime9 / 1000000000 + " detik");
                break;
            case 10:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime10 = System.nanoTime();
                SimulatedAnnealing.run(dir_tres92_stu, dir_tres92_crs, 100, iterasi);
                long endTime10 = System.nanoTime();
                long totalTime10 = endTime10 - startTime10;
                System.out.println("Total waktu : " + (double) totalTime10 / 1000000000 + " detik");
                break;
            case 11:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime11 = System.nanoTime();
                SimulatedAnnealing.run(dir_utas92_stu, dir_utas92_crs, 100, iterasi);
                long endTime11 = System.nanoTime();
                long totalTime11 = endTime11 - startTime11;
                System.out.println("Total waktu : " + (double) totalTime11 / 1000000000 + " detik");
                break;
            case 12:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime12 = System.nanoTime();
                SimulatedAnnealing.run(dir_utes92_stu, dir_utes92_crs, 100, iterasi);
                long endTime12 = System.nanoTime();
                long totalTime12 = endTime12 - startTime12;
                System.out.println("Total waktu : " + (double) totalTime12 / 1000000000 + " detik");
                break;
            case 13:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime13 = System.nanoTime();
                SimulatedAnnealing.run(dir_yorf83_stu, dir_yorf83_crs, 100, iterasi);
                long endTime13 = System.nanoTime();
                long totalTime13 = endTime13 - startTime13;
                System.out.println("Total waktu : " + (double) totalTime13 / 1000000000 + " detik");
                break;
            case 100:
                System.out.println("Bye...");
                System.exit(0);
            default:
                System.exit(0);
        }
        in.close();
    }
}
