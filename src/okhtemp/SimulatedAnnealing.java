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

        int[][] neighborSolution = RandomFunctions.copySolution(solution);
        int[][] solutionFinal = RandomFunctions.copySolution(neighborSolution);
        double reductionFactor = 0.001;
        double temperatureTemporary = temperature;

        for (int i = 0; i < iterasi; i++) {
            int moveSwapRandomizer = RandomFunctions.getRandomNumber(1, 5);
            int[][] iterasiLLH;

            switch (moveSwapRandomizer) {
                case 1:
                    iterasiLLH = RandomFunctions.move(RandomFunctions.copySolution(neighborSolution), 1);
                    break;
                case 2:
                    iterasiLLH = RandomFunctions.swap(RandomFunctions.copySolution(neighborSolution), 1);
                    break;
                case 3:
                    iterasiLLH = RandomFunctions.move(RandomFunctions.copySolution(neighborSolution), 2);
                    break;
                case 4:
                    iterasiLLH = RandomFunctions.swap(RandomFunctions.copySolution(neighborSolution), 3);
                    break;
                case 5:
                    iterasiLLH = RandomFunctions.move(RandomFunctions.copySolution(neighborSolution), 3);
                    break;
                default:
                    iterasiLLH = RandomFunctions.swap(RandomFunctions.copySolution(neighborSolution), 1);
                    break;
            }

            temperatureTemporary = temperatureTemporary * (1 - reductionFactor);
            if (RandomFunctions.isNotTabrakan(confMat, iterasiLLH)) {
                if (RandomFunctions.getPenalty(confMat, iterasiLLH, jumlahSiswa) <= RandomFunctions.getPenalty(confMat, neighborSolution, jumlahSiswa)) {
                    neighborSolution = RandomFunctions.copySolution(iterasiLLH);
                    if (RandomFunctions.getPenalty(confMat, iterasiLLH, jumlahSiswa) <= RandomFunctions.getPenalty(confMat, solutionFinal, jumlahSiswa)) {
                        solutionFinal = RandomFunctions.copySolution(iterasiLLH);
                        bestSolution.setSolution(solutionFinal);
                        bestSolution.setPenalty(RandomFunctions.getPenalty(confMat, iterasiLLH, jumlahSiswa));
                    }
                } else if (Math.exp((RandomFunctions.getPenalty(confMat, neighborSolution, jumlahSiswa) - RandomFunctions.getPenalty(confMat, iterasiLLH, jumlahSiswa)) / temperatureTemporary) > Math.random()) {
                    neighborSolution = RandomFunctions.copySolution(iterasiLLH);
                }
            }

            if ((i + 1) % 10 == 0) {
                System.out.println("ke-" + (i + 1) + " " + RandomFunctions.getPenalty(confMat, neighborSolution, jumlahSiswa));
            }

        }
        System.out.println();
        //System.out.println("Penalty initial solution : " + RandomFunctions.getPenalty(confMat, RandomFunctions.getSaturationSchedule(courseSet.getSize(), cm.getDegree(), confMat), jumlahSiswa));
        System.out.println("Penalty Terbaik : " + bestSolution.getPenalty());
        System.out.println("Jumlah timeslot : " + bestSolution.getJumlahTimeslot());
        int[][] bbest = bestSolution.getSolution();
//		
        for (int i = 0; i < bbest.length; i++) {
            System.out.println(bbest[i][0] + " " + bbest[i][1]);
        }

        solusiTerbaik = solutionFinal;
    }
}
