package okhtemp;

import java.util.Scanner;
import okhtemp.Utils;
import okhtemp.HillClimbing;

public class MainLd {

    static final String DIREKTORI = "E:/Frequently Used/Edukasi/Kuliah/Semester 7/Optimasi Kombinatorik dan Heuristik/Toronto/";

    public static void execute(String dir_stu, String dir_crs, int timeslot) {

        CourseSet courseSet = new CourseSet(dir_crs);
        ConflictMatrix conflictMatrix = new ConflictMatrix(dir_stu, courseSet.getSize());
        int[][] copyGraph = Utils.copyArray(conflictMatrix.getMatrix());
        int[][] graph = conflictMatrix.getLargestDegree();
        int jumlah_timeslot = timeslot;

        // Start
        long startTime = System.nanoTime();
        Scheduler scheduler = new Scheduler(courseSet.getSize());
        scheduler.timesloting(graph, jumlah_timeslot);

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
		// End

        scheduler.printSchedule(conflictMatrix.getDegree());
        int student_total = conflictMatrix.getJumlahStudent();
        int[][] schedule = scheduler.getSchedule();

        //int[][] gr = cm.getLargestDegree(copyGraph);

        scheduler.exportSchedule(dir_stu.substring(dir_stu.length() - 12, dir_stu.length() - 4));
        System.out.println("Penalty : " + Utils.getPenalty(copyGraph, schedule, student_total));
        System.out.println("Total Eksekusi : " + (double) totalTime / 1000000000 + " detik");
    }

    public static void executeOptimizer(String dir_stu, String dir_crs, int timeslot, String filename) {
        CourseSet cs = new CourseSet(dir_crs);
        ConflictMatrix cm = new ConflictMatrix(dir_stu, cs.getSize());

        int[][] graph = cm.getRandomMatrix();
        int jumlah_timeslot = timeslot;

        Scheduler scheduler = new Scheduler(cs.getSize());
        scheduler.timesloting(graph, jumlah_timeslot);

        scheduler.printSchedule(cm.getRandomIndex(graph.length));
        scheduler.exportSchedule(filename);
    }

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

        int timeslot = 0;

        System.out.println("=== TIMESLOTING === \n");
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
        System.out.println("99. EXIT");

        System.out.print("\nPilih File : ");
        int input = in.nextInt();

        switch (input) {
            case 1:
                System.out.print("Jumlah Timeslot : ");
                timeslot = in.nextInt();
//			execute(dir_carf92_stu, dir_carf92_crs, timeslot);
                long startTime = System.nanoTime();
                HillClimbing.hillClimbing(dir_carf92_stu, dir_carf92_crs, timeslot, 1000);
                long endTime = System.nanoTime();
                long totalTime = endTime - startTime;
                System.out.println("Total waktu : " + (double) totalTime / 1000000000 + " detik");
                break;
            case 2:
                System.out.print("Jumlah Timeslot : ");
                timeslot = in.nextInt();
//			execute(dir_cars91_stu, dir_cars91_crs, timeslot);
                long startTime2 = System.nanoTime();
                HillClimbing.hillClimbing(dir_cars91_stu, dir_cars91_crs, timeslot, 1000);
                long endTime2 = System.nanoTime();
                long totalTime2 = endTime2 - startTime2;
                System.out.println("Total waktu : " + (double) totalTime2 / 1000000000 + " detik");
                break;
            case 3:
                System.out.print("Jumlah Timeslot : ");
                timeslot = in.nextInt();
//			execute(dir_earf83_stu, dir_earf83_crs, timeslot);
                long startTime3 = System.nanoTime();
                HillClimbing.hillClimbing(dir_earf83_stu, dir_earf83_crs, timeslot, 1000);
                long endTime3 = System.nanoTime();
                long totalTime3 = endTime3 - startTime3;
                System.out.println("Total waktu : " + (double) totalTime3 / 1000000000 + " detik");
                break;
            case 4:
                System.out.print("Jumlah Timeslot : ");
                timeslot = in.nextInt();
//			execute(dir_hecs92_stu, dir_hecs92_crs, timeslot);
                long startTime4 = System.nanoTime();
                HillClimbing.hillClimbing(dir_hecs92_stu, dir_hecs92_crs, timeslot, 1000);
                long endTime4 = System.nanoTime();
                long totalTime4 = endTime4 - startTime4;
                System.out.println("Total waktu : " + (double) totalTime4 / 1000000000 + " detik");
                break;
            case 5:
                System.out.print("Jumlah Timeslot : ");
                timeslot = in.nextInt();
//			execute(dir_kfus93_stu, dir_kfus93_crs, timeslot);
                long startTime5 = System.nanoTime();
                HillClimbing.hillClimbing(dir_kfus93_stu, dir_kfus93_crs, timeslot, 1000);
                long endTime5 = System.nanoTime();
                long totalTime5 = endTime5 - startTime5;
                System.out.println("Total waktu : " + (double) totalTime5 / 1000000000 + " detik");
                break;
            case 6:
                System.out.print("Jumlah Timeslot : ");
                timeslot = in.nextInt();
//			execute(dir_lsef91_stu, dir_lsef91_crs, timeslot);
                long startTime6 = System.nanoTime();
                HillClimbing.hillClimbing(dir_lsef91_stu, dir_lsef91_crs, timeslot, 1000);
                long endTime6 = System.nanoTime();
                long totalTime6 = endTime6 - startTime6;
                System.out.println("Total waktu : " + (double) totalTime6 / 1000000000 + " detik");
                break;
            case 7:
                System.out.print("Jumlah Timeslot : ");
                timeslot = in.nextInt();
//			execute(dir_purs93_stu, dir_purs93_crs, timeslot);
                long startTime7 = System.nanoTime();
                HillClimbing.hillClimbing(dir_purs93_stu, dir_purs93_crs, timeslot, 1000000);
                long endTime7 = System.nanoTime();
                long totalTime7 = endTime7 - startTime7;
                System.out.println("Total waktu : " + (double) totalTime7 / 1000000000 + " detik");
                break;
            case 8:
                System.out.print("Jumlah Timeslot : ");
                timeslot = in.nextInt();
//			execute(dir_ryes93_stu, dir_ryes93_crs, timeslot);
                long startTime8 = System.nanoTime();
                HillClimbing.hillClimbing(dir_ryes93_stu, dir_ryes93_crs, timeslot, 1000000);
                long endTime8 = System.nanoTime();
                long totalTime8 = endTime8 - startTime8;
                System.out.println("Total waktu : " + (double) totalTime8 / 1000000000 + " detik");
                break;
            case 9:
                System.out.print("Jumlah Timeslot : ");
                timeslot = in.nextInt();
//			execute(dir_staf83_stu, dir_staf83_crs, timeslot);
                long startTime9 = System.nanoTime();
                HillClimbing.hillClimbing(dir_staf83_stu, dir_staf83_crs, timeslot, 1000000);
                long endTime9 = System.nanoTime();
                long totalTime9 = endTime9 - startTime9;
                System.out.println("Total waktu : " + (double) totalTime9 / 1000000000 + " detik");
                break;
            case 10:
                System.out.print("Jumlah Timeslot : ");
                timeslot = in.nextInt();
//			execute(dir_tres92_stu, dir_tres92_crs, timeslot);
                long startTime10 = System.nanoTime();
                HillClimbing.hillClimbing(dir_tres92_stu, dir_tres92_crs, timeslot, 1000000);
                long endTime10 = System.nanoTime();
                long totalTime10 = endTime10 - startTime10;
                System.out.println("Total waktu : " + (double) totalTime10 / 1000000000 + " detik");
                break;
            case 11:
                System.out.print("Jumlah Timeslot : ");
                timeslot = in.nextInt();
//			execute(dir_utas92_stu, dir_utas92_crs, timeslot);
                long startTime11 = System.nanoTime();
                HillClimbing.hillClimbing(dir_utas92_stu, dir_utas92_crs, timeslot, 1000000);
                long endTime11 = System.nanoTime();
                long totalTime11 = endTime11 - startTime11;
                System.out.println("Total waktu : " + (double) totalTime11 / 1000000000 + " detik");
                break;
            case 12:
                System.out.print("Jumlah Timeslot : ");
                timeslot = in.nextInt();
//			execute(dir_utes92_stu, dir_utes92_crs, timeslot);
                long startTime12 = System.nanoTime();
                HillClimbing.hillClimbing(dir_utes92_stu, dir_utes92_crs, timeslot, 1000000);
                long endTime12 = System.nanoTime();
                long totalTime12 = endTime12 - startTime12;
                System.out.println("Total waktu : " + (double) totalTime12 / 1000000000 + " detik");
                break;
            case 13:
                System.out.print("Jumlah Timeslot : ");
                timeslot = in.nextInt();
//			execute(dir_yorf83_stu, dir_yorf83_crs, timeslot);
                long startTime13 = System.nanoTime();
                HillClimbing.hillClimbing(dir_yorf83_stu, dir_yorf83_crs, timeslot, 1000000);
                long endTime13 = System.nanoTime();
                long totalTime13 = endTime13 - startTime13;
                System.out.println("Total waktu : " + (double) totalTime13 / 1000000000 + " detik");
                break;
            case 99:
                System.out.println("Bye...");
                System.exit(0);
            default:
                System.exit(0);
        }

        in.close();
    }
}