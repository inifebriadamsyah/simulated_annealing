package okhtemp;

import java.util.Arrays;

public class SimulatedAnnealing {

    private static int[][] solusiTerbaik;

    public static int[][] getSolusi() {
        return solusiTerbaik;
    }

    public static void run(String dir_stu, String dir_crs, double temperature, int iterasi) {
        CourseSet courseSet = new CourseSet(dir_crs);
        ConflictMatrix cm = new ConflictMatrix(dir_stu, courseSet.getSize());

        int[][] confMat = cm.getMatrix();
        int jumlahSiswa = cm.getJumlahStudent();
        int[][] solution = SchedulerFunctions.getSaturationSchedule(courseSet.getSize(), cm.getDegree(), confMat);

        Solution bestSolution = new Solution(solution);

        int[][] sCurrent = RandomFunctions.copySolution(solution);
        int[][] sBest = RandomFunctions.copySolution(sCurrent);
        double reductionFactor = 0.001;
        double tempCurr = temperature;

        for (int i = 0; i < iterasi; i++) {
            int randomLLH = RandomFunctions.getRandomNumber(1, 5);
            int[][] sIterasi;

            switch (randomLLH) {
                case 1:
                    sIterasi = RandomFunctions.move(RandomFunctions.copySolution(sCurrent), 1);
                    break;
                case 2:
                    sIterasi = RandomFunctions.swap(RandomFunctions.copySolution(sCurrent), 1);
                    break;
                case 3:
                    sIterasi = RandomFunctions.move(RandomFunctions.copySolution(sCurrent), 2);
                    break;
                case 4:
                    sIterasi = RandomFunctions.swap(RandomFunctions.copySolution(sCurrent), 3);
                    break;
                case 5:
                    sIterasi = RandomFunctions.move(RandomFunctions.copySolution(sCurrent), 3);
                    break;
                default:
                    sIterasi = RandomFunctions.swap(RandomFunctions.copySolution(sCurrent), 1);
                    break;
            }

            tempCurr = tempCurr * (1 - reductionFactor);
            if (RandomFunctions.isNotTabrakan(confMat, sIterasi)) {
                if (RandomFunctions.getPenalty(confMat, sIterasi, jumlahSiswa) <= RandomFunctions.getPenalty(confMat, sCurrent, jumlahSiswa)) {
                    sCurrent = RandomFunctions.copySolution(sIterasi);
                    if (RandomFunctions.getPenalty(confMat, sIterasi, jumlahSiswa) <= RandomFunctions.getPenalty(confMat, sBest, jumlahSiswa)) {
                        sBest = RandomFunctions.copySolution(sIterasi);
                        bestSolution.setSolution(sBest);
                        bestSolution.setPenalty(RandomFunctions.getPenalty(confMat, sIterasi, jumlahSiswa));
                    }
                } else if (Math.exp((RandomFunctions.getPenalty(confMat, sCurrent, jumlahSiswa) - RandomFunctions.getPenalty(confMat, sIterasi, jumlahSiswa)) / tempCurr) > Math.random()) {
                    sCurrent = RandomFunctions.copySolution(sIterasi);
                }
            }

            if ((i + 1) % 10 == 0) {
                System.out.println("Iterasi ke-" + (i + 1) + " " + RandomFunctions.getPenalty(confMat, sCurrent, jumlahSiswa));
            }

        }
        System.out.println();
        System.out.println("Penalty initial solution : " + RandomFunctions.getPenalty(confMat, RandomFunctions.getSaturationSchedule(courseSet.getSize(), cm.getDegree(), confMat), jumlahSiswa));
        System.out.println("Penalty Terbaik : " + bestSolution.getPenalty());
        System.out.println("Jumlah timeslot : " + bestSolution.getJumlahTimeslot());
        int[][] bbest = bestSolution.getSolution();
//		
        for (int i = 0; i < bbest.length; i++) {
            System.out.println(bbest[i][0] + " " + bbest[i][1]);
        }

        solusiTerbaik = sBest;
    }
}
