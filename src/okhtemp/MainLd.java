package okhtemp;

import java.util.Arrays;
import java.util.Scanner;
import okhtemp.RandomFunctions;
import okhtemp.HillClimbing;

public class MainLd {

    static final String directory = "E:/Frequently Used/Edukasi/Kuliah/Semester 7/Optimasi Kombinatorik dan Heuristik/Toronto/";

    public static void execute(String dir_stu, String dir_crs, int timeslot) {

        CourseSet courseSet = new CourseSet(dir_crs);
        int jumlah_timeslot = timeslot;
        
        ConflictMatrix conflictMatrix = new ConflictMatrix(dir_stu, courseSet.getSize());
        int[][] matrixInitial = conflictMatrix.getMatrix();
        int[][] matrixLargestDegree = conflictMatrix.getLargestDegree();
        int[][] largestDegree = conflictMatrix.getDegree();
        int jumlahSiswa = conflictMatrix.getJumlahStudent();
              
        SchedulerFunctions scheduler = new SchedulerFunctions(courseSet.getSize());
        scheduler.timesloting(matrixLargestDegree, 100);
        scheduler.printSchedule(conflictMatrix.getDegree());
        
        int[][] solution = RandomFunctions.getSaturationSchedule(courseSet.getSize(), largestDegree, matrixInitial);

        scheduler.exportSchedule(dir_stu.substring(dir_stu.length() - 12, dir_stu.length() - 4));
        System.out.println("Penalty : " + RandomFunctions.getPenalty(matrixInitial, solution, jumlahSiswa));

        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i][0] + " " + solution[i][1]);
        }
        int[] timeslotTempLd = new int[solution.length];
        for (int i = 0; i < solution.length; i++) {
            timeslotTempLd[i] = solution[i][1];
        }
        System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd).max().getAsInt() + "\n");
    }

    public static void executeOptimizer(String dir_stu, String dir_crs, int timeslot, String filename) {
        CourseSet courseSet = new CourseSet(dir_crs);
        ConflictMatrix conflictMatrix = new ConflictMatrix(dir_stu, courseSet.getSize());

        int[][] graph = conflictMatrix.getRandomMatrix();
        int jumlah_timeslot = timeslot;

        SchedulerFunctions scheduler = new SchedulerFunctions(courseSet.getSize());
        scheduler.timesloting(graph, jumlah_timeslot);

        scheduler.printSchedule(conflictMatrix.getRandomIndex(graph.length));
        scheduler.exportSchedule(filename);
    }

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

        int timeslot = 0;

        System.out.println("=== OPTIMIZE INITIAL SOLUTION === \n");
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
                long startTime = System.nanoTime();
                execute(dir_carf92_stu, dir_carf92_crs, timeslot);
                long endTime = System.nanoTime();
                long totalTime = endTime - startTime;
                System.out.println("Total waktu : " + (double) totalTime / 1000000000 + " detik");
                break;
                
            case 2:
                long startTime2 = System.nanoTime();
                execute(dir_cars91_stu, dir_cars91_crs, timeslot);
                long endTime2 = System.nanoTime();
                long totalTime2 = endTime2 - startTime2;
                System.out.println("Total waktu : " + (double) totalTime2 / 1000000000 + " detik");
                break;
                
            case 3:
                long startTime3 = System.nanoTime();
                execute(dir_earf83_stu, dir_earf83_crs, timeslot);
                long endTime3 = System.nanoTime();
                long totalTime3 = endTime3 - startTime3;
                System.out.println("Total waktu : " + (double) totalTime3 / 1000000000 + " detik");
                break;
                
            case 4:
                long startTime4 = System.nanoTime();
                execute(dir_hecs92_stu, dir_hecs92_crs, timeslot);
                long endTime4 = System.nanoTime();
                long totalTime4 = endTime4 - startTime4;
                System.out.println("Total waktu : " + (double) totalTime4 / 1000000000 + " detik");
                break;
                
            case 5:
                long startTime5 = System.nanoTime();
                execute(dir_kfus93_stu, dir_kfus93_crs, timeslot);
                long endTime5 = System.nanoTime();
                long totalTime5 = endTime5 - startTime5;
                System.out.println("Total waktu : " + (double) totalTime5 / 1000000000 + " detik");
                break;
                
            case 6:
                long startTime6 = System.nanoTime();
                execute(dir_lsef91_stu, dir_lsef91_crs, timeslot);
                long endTime6 = System.nanoTime();
                long totalTime6 = endTime6 - startTime6;
                System.out.println("Total waktu : " + (double) totalTime6 / 1000000000 + " detik");
                break;
                
            case 7:
                long startTime7 = System.nanoTime();
                execute(dir_purs93_stu, dir_purs93_crs, timeslot);
                long endTime7 = System.nanoTime();
                long totalTime7 = endTime7 - startTime7;
                System.out.println("Total waktu : " + (double) totalTime7 / 1000000000 + " detik");
                break;
                
            case 8:		
                long startTime8 = System.nanoTime();
                execute(dir_ryes93_stu, dir_ryes93_crs, timeslot);
                long endTime8 = System.nanoTime();
                long totalTime8 = endTime8 - startTime8;
                System.out.println("Total waktu : " + (double) totalTime8 / 1000000000 + " detik");
                break;
            case 9:
                long startTime9 = System.nanoTime();
                execute(dir_staf83_stu, dir_staf83_crs, timeslot);
                long endTime9 = System.nanoTime();
                long totalTime9 = endTime9 - startTime9;
                System.out.println("Total waktu : " + (double) totalTime9 / 1000000000 + " detik");
                break;
            case 10:
                long startTime10 = System.nanoTime();
                execute(dir_tres92_stu, dir_tres92_crs, timeslot);
                long endTime10 = System.nanoTime();
                long totalTime10 = endTime10 - startTime10;
                System.out.println("Total waktu : " + (double) totalTime10 / 1000000000 + " detik");
                break;
            case 11:
                long startTime11 = System.nanoTime();
                execute(dir_utas92_stu, dir_utas92_crs, timeslot);
                long endTime11 = System.nanoTime();
                long totalTime11 = endTime11 - startTime11;
                System.out.println("Total waktu : " + (double) totalTime11 / 1000000000 + " detik");
                break;
            case 12:
                long startTime12 = System.nanoTime();
                execute(dir_utes92_stu, dir_utes92_crs, timeslot);
                long endTime12 = System.nanoTime();
                long totalTime12 = endTime12 - startTime12;
                System.out.println("Total waktu : " + (double) totalTime12 / 1000000000 + " detik");
                break;
            case 13:
                long startTime13 = System.nanoTime();
                execute(dir_yorf83_stu, dir_yorf83_crs, 100);
                long endTime13 = System.nanoTime();
                long totalTime13 = endTime13 - startTime13;
                System.out.println("Total waktu : " + (double) totalTime13 / 1000000000 + " detik");
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