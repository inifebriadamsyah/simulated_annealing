package okhtemp;

import okhtemp.Utils;

public class Heuristics {

    private static int[][] jadwalTheBest;

    private static void setJadwal(int[][] jadwal) {
        jadwalTheBest = jadwal;
    }

    public static int[][] getJadwal() {
        return jadwalTheBest;
    }

    public static void randomSearch(String dir_stu, String dir_crs, int timeslot) {
        CourseSet courseSet = new CourseSet(dir_crs);
        ConflictMatrix conflictMatrix = new ConflictMatrix(dir_stu, courseSet.getSize());

        int[][] copyGraph = Utils.copyArray(conflictMatrix.getMatrix());
        int[][] graph = conflictMatrix.getRandomMatrix();

        int jumlahTimeslot = timeslot;
        Scheduler scheduler = new Scheduler(courseSet.getSize());
        scheduler.timesloting(graph, jumlahTimeslot);

        scheduler.printSchedule(conflictMatrix.getRandomIndex(graph.length));
        int jumlah = conflictMatrix.getJumlahStudent();
        int[][] jadwal = scheduler.getSchedule();

        double penalty = Utils.getPenalty(copyGraph, jadwal, jumlah);
        System.out.println(penalty);
        for (int i = 0; i < 1000; i++) {
            CourseSet csIter = new CourseSet(dir_crs);
            ConflictMatrix cmIter = new ConflictMatrix(dir_stu, courseSet.getSize());

            int[][] copyGraphIter = Utils.copyArray(cmIter.getMatrix());
            int[][] graphIter = conflictMatrix.getRandomMatrix();

            Scheduler schedulerIter = new Scheduler(csIter.getSize());

            schedulerIter.timesloting(graphIter, jumlahTimeslot);
            schedulerIter.printSchedule(conflictMatrix.getRandomIndex(graphIter.length));
            int[][] jadwalIter = schedulerIter.getSchedule();

            //int[][] grIter = cm.getLargestDegree(copyGraphIter);

            double penalty2 = Utils.getPenalty(copyGraphIter, jadwalIter, jumlah);

            if (penalty > penalty2) {
                penalty = penalty2;
            }

            System.out.println("Iterasi " + (i + 1) + " - Penalty : " + penalty);
        }
    }

    public static void hillClimbing(String dir_stu, String dir_crs, int timeslot, int iterasi) {
        CourseSet courseSet = new CourseSet(dir_crs);
        ConflictMatrix conflictMatrix = new ConflictMatrix(dir_stu, courseSet.getSize());

        int[][] conflict_matrix = conflictMatrix.getLargestDegree();
        int jumlahTimeslot = timeslot;

        Scheduler scheduler = new Scheduler(courseSet.getSize());
        scheduler.timesloting(conflict_matrix, jumlahTimeslot);
        scheduler.printSchedule(conflictMatrix.getDegree());

        int jumlahStudent = conflictMatrix.getJumlahStudent();

        int[][] jadwal = scheduler.getSchedule();
        int[][] jadwalTemp = new int[jadwal.length][2];

        for (int i = 0; i < jadwalTemp.length; i++) {
            jadwalTemp[i][0] = jadwal[i][0];
            jadwalTemp[i][1] = jadwal[i][1];
        }

        double penalty = Utils.getPenalty(conflict_matrix, jadwal, jumlahStudent);
        System.out.println(penalty);

        int max_timeslot = 0;

        for (int i = 0; i < jadwal.length; i++) {
            if (jadwal[i][1] > max_timeslot) {
                max_timeslot = jadwal[i][1];
            }
        }
        for (int i = 0; i < iterasi; i++) {

            int randomCourseIndex = Utils.getRandomNumber(0, conflict_matrix.length);
            int randomTimeslot = Utils.getRandomNumber(0, max_timeslot);
//			System.out.println("random " + randomCourseIndex + " " + randomTimeslot);
            jadwalTemp[randomCourseIndex][1] = randomTimeslot;

//			System.out.println();
//			System.out.println(Scheduler.checkRandomTimeslot(randomCourseIndex, randomTimeslot, conflict_matrix, jadwal));
            if (Scheduler.checkRandomTimeslot(randomCourseIndex, randomTimeslot, conflict_matrix, jadwal)) {
                jadwalTemp[randomCourseIndex][1] = randomTimeslot;
                double penalty2 = Utils.getPenalty(conflict_matrix, jadwalTemp, jumlahStudent);
//				System.out.println("penalty = "+penalty+", penalty 2 = "+penalty2);
                if (penalty > penalty2) {
                    penalty = Utils.getPenalty(conflict_matrix, jadwalTemp, jumlahStudent);
                    jadwal[randomCourseIndex][1] = jadwalTemp[randomCourseIndex][1];
                } else {
                    jadwalTemp[randomCourseIndex][1] = jadwal[randomCourseIndex][1];
                }
            }
//			
            System.out.println("Iterasi " + (i + 1) + " - Penalty : " + penalty);
        }

        setJadwal(jadwal);
        System.out.println("Nilai penalty terbaik: " + penalty);
    }
}
