package okhtemp;

import java.util.Arrays;
import java.util.Scanner;
import okhtemp.Heuristics;
import static okhtemp.MainLd.DIREKTORI;

public class MainHc {

    static final String DIREKTORI = "E:/Frequently Used/Edukasi/Kuliah/Semester 7/Optimasi Kombinatorik dan Heuristik/Toronto/";

    public static void main(String[] args) {
        // Direktori file
        String dir_carf92_stu = DIREKTORI + "car-f-92.stu";
        String dir_carf92_crs = DIREKTORI + "car-f-92.crs";

        String dir_cars91_stu = DIREKTORI + "car-s-91.stu";
        String dir_cars91_crs = DIREKTORI + "car-s-91.crs";

        String dir_earf83_stu = DIREKTORI + "ear-f-83.stu";
        String dir_earf83_crs = DIREKTORI + "ear-f-83.crs";

        String dir_hecs92_stu = DIREKTORI + "hec-s-92.stu";
        String dir_hecs92_crs = DIREKTORI + "hec-s-92.crs";

        String dir_kfus93_stu = DIREKTORI + "kfu-s-93.stu";
        String dir_kfus93_crs = DIREKTORI + "kfu-s-93.crs";

        String dir_lsef91_stu = DIREKTORI + "lse-f-91.stu";
        String dir_lsef91_crs = DIREKTORI + "lse-f-91.crs";

        String dir_purs93_stu = DIREKTORI + "pur-s-93.stu";
        String dir_purs93_crs = DIREKTORI + "pur-s-93.crs";

        String dir_ryes93_stu = DIREKTORI + "rye-s-93.stu";
        String dir_ryes93_crs = DIREKTORI + "rye-s-93.crs";

        String dir_staf83_stu = DIREKTORI + "sta-f-83.stu";
        String dir_staf83_crs = DIREKTORI + "sta-f-83.crs";

        String dir_tres92_stu = DIREKTORI + "tre-s-92.stu";
        String dir_tres92_crs = DIREKTORI + "tre-s-92.crs";

        String dir_utas92_stu = DIREKTORI + "uta-s-92.stu";
        String dir_utas92_crs = DIREKTORI + "uta-s-92.crs";

        String dir_utes92_stu = DIREKTORI + "ute-s-92.stu";
        String dir_utes92_crs = DIREKTORI + "ute-s-92.crs";

        String dir_yorf83_stu = DIREKTORI + "yor-f-83.stu";
        String dir_yorf83_crs = DIREKTORI + "yor-f-83.crs";

        Scanner in = new Scanner(System.in);

        int iterasi = 0;

        System.out.println("=== OPTIMIZING WITH HILL CLIMBING === \n");
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
                Heuristics.hillClimbing(dir_carf92_stu, dir_carf92_crs, 100, iterasi);
                long endTime = System.nanoTime();
                long totalTime = endTime - startTime;
                System.out.println("Total waktu : " + (double) totalTime / 1000000000 + " detik");
                int[][] hasil_timeslot1 = Heuristics.getJadwal();
                for (int i = 0; i < hasil_timeslot1.length; i++) {
                    System.out.println(hasil_timeslot1[i][0] + " " + hasil_timeslot1[i][1]);
                }
                int[] timeslotTempLd01 = new int[hasil_timeslot1.length];
                for (int i = 0; i < hasil_timeslot1.length; i++) {
                    timeslotTempLd01[i] = hasil_timeslot1[i][1];
                }
                System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd01).max().getAsInt() + "\n");
                
                
                break;
                
            case 2:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime2 = System.nanoTime();
                Heuristics.hillClimbing(dir_cars91_stu, dir_cars91_crs, 100, 1000);
                long endTime2 = System.nanoTime();
                long totalTime2 = endTime2 - startTime2;
                System.out.println("Total waktu : " + (double) totalTime2 / 1000000000 + " detik");
                
                int[][] hasil_timeslot2 = Heuristics.getJadwal();
                for (int i = 0; i < hasil_timeslot2.length; i++) {
                    System.out.println(hasil_timeslot2[i][0] + " " + hasil_timeslot2[i][1]);
                }
                
                int[] timeslotTempLd02 = new int[hasil_timeslot2.length];
                for (int i = 0; i < hasil_timeslot2.length; i++) {
                    timeslotTempLd02[i] = hasil_timeslot2[i][1];
                }
                System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd02).max().getAsInt() + "\n");
                break;
                
            case 3:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime3 = System.nanoTime();
                Heuristics.hillClimbing(dir_earf83_stu, dir_earf83_crs, 100, 1000);
                long endTime3 = System.nanoTime();
                long totalTime3 = endTime3 - startTime3;
                System.out.println("Total waktu : " + (double) totalTime3 / 1000000000 + " detik");
                
                int[][] hasil_timeslot3 = Heuristics.getJadwal();
                for (int i = 0; i < hasil_timeslot3.length; i++) {
                    System.out.println(hasil_timeslot3[i][0] + " " + hasil_timeslot3[i][1]);
                }
                
                int[] timeslotTempLd03 = new int[hasil_timeslot3.length];
                for (int i = 0; i < hasil_timeslot3.length; i++) {
                    timeslotTempLd03[i] = hasil_timeslot3[i][1];
                }
                System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd03).max().getAsInt() + "\n");
                break;
                
            case 4:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime4 = System.nanoTime();
                Heuristics.hillClimbing(dir_hecs92_stu, dir_hecs92_crs, 100, 1000);
                long endTime4 = System.nanoTime();
                long totalTime4 = endTime4 - startTime4;
                System.out.println("Total waktu : " + (double) totalTime4 / 1000000000 + " detik");
                
                int[][] hasil_timeslot4 = Heuristics.getJadwal();
                for (int i = 0; i < hasil_timeslot4.length; i++) {
                    System.out.println(hasil_timeslot4[i][0] + " " + hasil_timeslot4[i][1]);
                }
                
                int[] timeslotTempLd04 = new int[hasil_timeslot4.length];
                for (int i = 0; i < hasil_timeslot4.length; i++) {
                    timeslotTempLd04[i] = hasil_timeslot4[i][1];
                }
                System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd04).max().getAsInt() + "\n");
                break;
                
            case 5:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime5 = System.nanoTime();
                Heuristics.hillClimbing(dir_kfus93_stu, dir_kfus93_crs, 100, 1000);
                long endTime5 = System.nanoTime();
                long totalTime5 = endTime5 - startTime5;
                System.out.println("Total waktu : " + (double) totalTime5 / 1000000000 + " detik");
                
                int[][] hasil_timeslot5 = Heuristics.getJadwal();
                for (int i = 0; i < hasil_timeslot5.length; i++) {
                    System.out.println(hasil_timeslot5[i][0] + " " + hasil_timeslot5[i][1]);
                }
                
                int[] timeslotTempLd05 = new int[hasil_timeslot5.length];
                for (int i = 0; i < hasil_timeslot5.length; i++) {
                    timeslotTempLd05[i] = hasil_timeslot5[i][1];
                }
                System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd05).max().getAsInt() + "\n");
                break;
                
            case 6:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime6 = System.nanoTime();
                Heuristics.hillClimbing(dir_lsef91_stu, dir_lsef91_crs, 100, 1000);
                long endTime6 = System.nanoTime();
                long totalTime6 = endTime6 - startTime6;
                System.out.println("Total waktu : " + (double) totalTime6 / 1000000000 + " detik");
               
                int[][] hasil_timeslot6 = Heuristics.getJadwal();
                for (int i = 0; i < hasil_timeslot6.length; i++) {
                    System.out.println(hasil_timeslot6[i][0] + " " + hasil_timeslot6[i][1]);
                }
                
                int[] timeslotTempLd06 = new int[hasil_timeslot6.length];
                for (int i = 0; i < hasil_timeslot6.length; i++) {
                    timeslotTempLd06[i] = hasil_timeslot6[i][1];
                }
                System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd06).max().getAsInt() + "\n");
                break;
            case 7:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime7 = System.nanoTime();
                Heuristics.hillClimbing(dir_purs93_stu, dir_purs93_crs, 100, 1000000);
                long endTime7 = System.nanoTime();
                long totalTime7 = endTime7 - startTime7;
                System.out.println("Total waktu : " + (double) totalTime7 / 1000000000 + " detik");
                
                int[][] hasil_timeslot7 = Heuristics.getJadwal();
                for (int i = 0; i < hasil_timeslot7.length; i++) {
                    System.out.println(hasil_timeslot7[i][0] + " " + hasil_timeslot7[i][1]);
                }
                
                int[] timeslotTempLd07 = new int[hasil_timeslot7.length];
                for (int i = 0; i < hasil_timeslot7.length; i++) {
                    timeslotTempLd07[i] = hasil_timeslot7[i][1];
                }
                System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd07).max().getAsInt() + "\n");
                break;
                
            case 8:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime8 = System.nanoTime();
                Heuristics.hillClimbing(dir_ryes93_stu, dir_ryes93_crs, 100, 1000000);
                long endTime8 = System.nanoTime();
                long totalTime8 = endTime8 - startTime8;
                System.out.println("Total waktu : " + (double) totalTime8 / 1000000000 + " detik");
                
                int[][] hasil_timeslot8 = Heuristics.getJadwal();
                for (int i = 0; i < hasil_timeslot8.length; i++) {
                    System.out.println(hasil_timeslot8[i][0] + " " + hasil_timeslot8[i][1]);
                }
                
                int[] timeslotTempLd08 = new int[hasil_timeslot8.length];
                for (int i = 0; i < hasil_timeslot8.length; i++) {
                    timeslotTempLd08[i] = hasil_timeslot8[i][1];
                }
                System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd08).max().getAsInt() + "\n");
                break;
                
            case 9:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime9 = System.nanoTime();
                Heuristics.hillClimbing(dir_staf83_stu, dir_staf83_crs, 100, 1000000);
                long endTime9 = System.nanoTime();
                long totalTime9 = endTime9 - startTime9;
                System.out.println("Total waktu : " + (double) totalTime9 / 1000000000 + " detik");
                
                int[][] hasil_timeslot9 = Heuristics.getJadwal();
                for (int i = 0; i < hasil_timeslot9.length; i++) {
                    System.out.println(hasil_timeslot9[i][0] + " " + hasil_timeslot9[i][1]);
                }
                
                int[] timeslotTempLd09 = new int[hasil_timeslot9.length];
                for (int i = 0; i < hasil_timeslot9.length; i++) {
                    timeslotTempLd09[i] = hasil_timeslot9[i][1];
                }
                System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd09).max().getAsInt() + "\n");
                
                break;
                
            case 10:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime10 = System.nanoTime();
                Heuristics.hillClimbing(dir_tres92_stu, dir_tres92_crs, 100, 1000000);
                long endTime10 = System.nanoTime();
                long totalTime10 = endTime10 - startTime10;
                System.out.println("Total waktu : " + (double) totalTime10 / 1000000000 + " detik");
                
                int[][] hasil_timeslot10 = Heuristics.getJadwal();
                for (int i = 0; i < hasil_timeslot10.length; i++) {
                    System.out.println(hasil_timeslot10[i][0] + " " + hasil_timeslot10[i][1]);
                }
                
                int[] timeslotTempLd10 = new int[hasil_timeslot10.length];
                for (int i = 0; i < hasil_timeslot10.length; i++) {
                    timeslotTempLd10[i] = hasil_timeslot10[i][1];
                }
                System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd10).max().getAsInt() + "\n");
                
                break;
            case 11:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime11 = System.nanoTime();
                Heuristics.hillClimbing(dir_utas92_stu, dir_utas92_crs, 100, 1000000);
                long endTime11 = System.nanoTime();
                long totalTime11 = endTime11 - startTime11;
                System.out.println("Total waktu : " + (double) totalTime11 / 1000000000 + " detik");
                
                int[][] hasil_timeslot11 = Heuristics.getJadwal();
                for (int i = 0; i < hasil_timeslot11.length; i++) {
                    System.out.println(hasil_timeslot11[i][0] + " " + hasil_timeslot11[i][1]);
                }
                
                int[] timeslotTempLd11 = new int[hasil_timeslot11.length];
                for (int i = 0; i < hasil_timeslot11.length; i++) {
                    timeslotTempLd11[i] = hasil_timeslot11[i][1];
                }
                System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd11).max().getAsInt() + "\n");
                
                break;
            case 12:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime12 = System.nanoTime();
                Heuristics.hillClimbing(dir_utes92_stu, dir_utes92_crs, 100, iterasi);
                long endTime12 = System.nanoTime();
                long totalTime12 = endTime12 - startTime12;
                System.out.println("Total waktu : " + (double) totalTime12 / 1000000000 + " detik");
                
                int[][] hasil_timeslot12 = Heuristics.getJadwal();
                for (int i = 0; i < hasil_timeslot12.length; i++) {
                    System.out.println(hasil_timeslot12[i][0] + " " + hasil_timeslot12[i][1]);
                }
                
                int[] timeslotTempLd12 = new int[hasil_timeslot12.length];
                for (int i = 0; i < hasil_timeslot12.length; i++) {
                    timeslotTempLd12[i] = hasil_timeslot12[i][1];
                }
                System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd12).max().getAsInt() + "\n");
                
                break;
            case 13:
                System.out.print("Jumlah Iterasi : ");
                iterasi = in.nextInt();
                long startTime13 = System.nanoTime();
                Heuristics.hillClimbing(dir_yorf83_stu, dir_yorf83_crs, 100, iterasi);
                long endTime13 = System.nanoTime();
                long totalTime13 = endTime13 - startTime13;
                System.out.println("Total waktu : " + (double) totalTime13 / 1000000000 + " detik");
                
                int[][] hasil_timeslot13 = Heuristics.getJadwal();
                for (int i = 0; i < hasil_timeslot13.length; i++) {
                    System.out.println(hasil_timeslot13[i][0] + " " + hasil_timeslot13[i][1]);
                }
                
                int[] timeslotTempLd13 = new int[hasil_timeslot13.length];
                for (int i = 0; i < hasil_timeslot13.length; i++) {
                    timeslotTempLd13[i] = hasil_timeslot13[i][1];
                }
                System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd13).max().getAsInt() + "\n");
                
                break;
            case 100:
                System.out.println("Exiting....");
                System.exit(0);
            default:
                System.exit(0);
        }
        in.close();
    }
}
