package okhtemp;

import okhtemp.RandomFunctions;

public class HillClimbing {

    private static int[][] bestSchedule;

    private static void setJadwal(int[][] jadwal) {
        bestSchedule = jadwal;
    }

    public static int[][] getJadwal() {
        return bestSchedule;
    }

    public static void randomSearch(String dir_stu, String dir_crs, int timeslot) {
        CourseSet courseSet = new CourseSet(dir_crs);
        ConflictMatrix conflictMatrix = new ConflictMatrix(dir_stu, courseSet.getSize());

        int[][] copyGraph = RandomFunctions.copyArray(conflictMatrix.getMatrix());
        int[][] graph = conflictMatrix.getRandomMatrix();

        int jumlahTimeslot = timeslot;
        SchedulerFunctions scheduler = new SchedulerFunctions(courseSet.getSize());
        scheduler.timesloting(graph, jumlahTimeslot);

        scheduler.printSchedule(conflictMatrix.getRandomIndex(graph.length));
        int jumlah = conflictMatrix.getJumlahStudent();
        int[][] jadwal = scheduler.getSchedule();
        
        int[][] copiedCopyGraph = conflictMatrix.getLargestDegree(copyGraph);

        double penalty = RandomFunctions.getPenalty(copyGraph, jadwal, jumlah);
        System.out.println(penalty);
        for (int i = 0; i < 1000; i++) {
            CourseSet csIter = new CourseSet(dir_crs);
            ConflictMatrix cmIter = new ConflictMatrix(dir_stu, courseSet.getSize());

            int[][] copyGraphIter = RandomFunctions.copyArray(cmIter.getMatrix());
            int[][] graphIter = conflictMatrix.getRandomMatrix();

            SchedulerFunctions schedulerIteration = new SchedulerFunctions(csIter.getSize());

            schedulerIteration.timesloting(graphIter, jumlahTimeslot);
            schedulerIteration.printSchedule(conflictMatrix.getRandomIndex(graphIter.length));
            int[][] jadwalIter = schedulerIteration.getSchedule();

            int[][] graphIteration = conflictMatrix.getLargestDegree(copyGraphIter);
            
            double penaltyTemp = RandomFunctions.getPenalty(copyGraphIter, jadwalIter, jumlah);

            if (penalty > penaltyTemp) {
                penalty = penaltyTemp;
            }

            System.out.println("Iterasi " + (i + 1) + " - Penalty : " + penalty);
        }
    }

    public static void hillClimbing(String dir_stu, String dir_crs, int timeslot, int iterasi) {
        CourseSet courseSet = new CourseSet(dir_crs);
        ConflictMatrix cm = new ConflictMatrix(dir_stu, courseSet.getSize());

//		int [][] confMat = cm.getConflictMatrix();
        int[][] conflict_matrix = cm.getMatrix();
        int[][] jadwal = SchedulerFunctions.getSaturationSchedule(courseSet.getSize(), cm.getDegree(), conflict_matrix);
//		int jumlahTimeslot = timeslot;

//		Scheduler scheduler = new Scheduler(cs.getSize());
//		scheduler.timesloting(conflict_matrix, jumlahTimeslot);
//		scheduler.printSchedule(cm.getDegree());
        int jumlahStudent = cm.getJumlahStudent();

//		int[][] jadwal = scheduler.getSchedule();
        int[][] jadwalNeighbor = new int[jadwal.length][2];

        for (int i = 0; i < jadwalNeighbor.length; i++) {
            jadwalNeighbor[i][0] = jadwal[i][0];
            jadwalNeighbor[i][1] = jadwal[i][1];
        }

        double penalty = RandomFunctions.getPenalty(conflict_matrix, jadwal, jumlahStudent);
        System.out.println(penalty);

        Solution bestSolution = new Solution(jadwal);
        int max_timeslot = bestSolution.getJumlahTimeslot();

        for (int i = 0; i < iterasi; i++) {
            int randomCourseIndex = RandomFunctions.getRandomNumber(0, conflict_matrix.length - 1);
            int randomTimeslot = RandomFunctions.getRandomNumber(0, max_timeslot - 1);

            if (SchedulerFunctions.checkRandomTimeslot(randomCourseIndex, randomTimeslot, conflict_matrix, jadwalNeighbor)) {
                jadwalNeighbor[randomCourseIndex][1] = randomTimeslot;
                double penalty2 = RandomFunctions.getPenalty(conflict_matrix, jadwalNeighbor, jumlahStudent);

                if (penalty > penalty2) {
                    penalty = RandomFunctions.getPenalty(conflict_matrix, jadwalNeighbor, jumlahStudent);
                    jadwal[randomCourseIndex][1] = jadwalNeighbor[randomCourseIndex][1];
                    bestSolution.setSolution(jadwal);
                    bestSolution.setPenalty(penalty);
                } else {
                    jadwalNeighbor[randomCourseIndex][1] = jadwal[randomCourseIndex][1];
                }
            }
            if ((i + 1) % 1000 == 0) {
                System.out.println("Iterasi - " + (i + 1) + " " + penalty);
            }
        }

        setJadwal(jadwal);
        System.out.println();

        int[][] thebest = bestSolution.getSolution();
        for (int i = 0; i < thebest.length; i++) {
            System.out.println(thebest[i][0] + " " + thebest[i][1]);
        }

        System.out.println("Best Penalty : " + bestSolution.getPenalty());
        System.out.println("Jumlah timeslot : " + bestSolution.getJumlahTimeslot());
    }
}
