package okhtemp;

import java.util.Arrays;

public class SimulatedAnnealing {

    static int[][] solusiTerbaik;

    public static int[][] run2(int[][] matrix, int jumlahSiswa, int[][] solution, double temperature, int iterasi) {
        int[][] currentSolution = solution;
        int[][] bestSolution = Utility.copySolution(currentSolution);
        double reductionFactor = 0.001;
        double currentTemperature = temperature;

        for (int i = 0; i < iterasi; i++) {
            int randomLLH = Utility.getRandomNumber(1, 5);
            int[][] sIterasi;

            switch (randomLLH) {
                case 1:
                    sIterasi = Utility.move(currentSolution.clone(), 1);
                    break;
                case 2:
                    sIterasi = Utility.swap(currentSolution.clone(), 1);
                    break;
                case 3:
                    sIterasi = Utility.move(currentSolution.clone(), 2);
                    break;
                case 4:
                    sIterasi = Utility.swap(currentSolution.clone(), 3);
                    break;
                case 5:
                    sIterasi = Utility.move(currentSolution.clone(), 3);
                    break;
                default:
                    sIterasi = Utility.swap(currentSolution.clone(), 1);
                    break;
            }

            currentTemperature = currentTemperature * (1 - reductionFactor);

            if (Utility.getPenalty(matrix, sIterasi, jumlahSiswa) <= Utility.getPenalty(matrix, currentSolution, jumlahSiswa)) {
                currentSolution = Utility.copySolution(sIterasi);
                if (Utility.getPenalty(matrix, sIterasi, jumlahSiswa) <= Utility.getPenalty(matrix, bestSolution, jumlahSiswa)) {
                    bestSolution = Utility.copySolution(sIterasi);
                }
            } else if (Math.exp((Utility.getPenalty(matrix, currentSolution, jumlahSiswa) - Utility.getPenalty(matrix, sIterasi, jumlahSiswa)) / currentTemperature) > Math.random()) {
                currentSolution = Utility.copySolution(sIterasi);
            }

            System.out.println(i + " " + Utility.getPenalty(matrix, currentSolution, jumlahSiswa));
        }

        return bestSolution;
    }

    public static void run(String dir_stu, String dir_crs, double temperature, int iterasi) {
        CourseSet courseSet = new CourseSet(dir_crs);
        ConflictMatrix conflictMatrix = new ConflictMatrix(dir_stu, courseSet.getSize());

        int[][] matrix = conflictMatrix.getLargestDegree();
        int jumlahSiswa = conflictMatrix.getJumlahStudent();
        Scheduler scheduler = new Scheduler(courseSet.getSize());
        scheduler.timesloting(matrix, 100);
        scheduler.printSchedule(conflictMatrix.getDegree());
        int[][] solution = scheduler.getSchedule();

        int[][] currentSolution = solution;
        int[][] bestSolution = Utility.copySolution(currentSolution);
        double reductionFactor = 0.001;
        double currentTemperature = temperature;

        for (int i = 0; i < iterasi; i++) {
            int randomLLH = Utility.getRandomNumber(1, 5);
            int[][] sIterasi;

            switch (randomLLH) {
                case 1:
                    sIterasi = Utility.move(currentSolution.clone(), 1);
                    break;
                case 2:
                    sIterasi = Utility.swap(currentSolution.clone(), 1);
                    break;
                case 3:
                    sIterasi = Utility.move(currentSolution.clone(), 2);
                    break;
                case 4:
                    sIterasi = Utility.swap(currentSolution.clone(), 3);
                    break;
                case 5:
                    sIterasi = Utility.move(currentSolution.clone(), 3);
                    break;
                default:
                    sIterasi = Utility.swap(currentSolution.clone(), 1);
                    break;
            }

            currentTemperature = currentTemperature * (1 - reductionFactor);

            if (Utility.getPenalty(matrix, sIterasi, jumlahSiswa) <= Utility.getPenalty(matrix, currentSolution, jumlahSiswa)) {
                currentSolution = Utility.copySolution(sIterasi);
                if (Utility.getPenalty(matrix, sIterasi, jumlahSiswa) <= Utility.getPenalty(matrix, bestSolution, jumlahSiswa)) {
                    bestSolution = Utility.copySolution(sIterasi);
                }
            } else if (Math.exp((Utility.getPenalty(matrix, currentSolution, jumlahSiswa) - Utility.getPenalty(matrix, sIterasi, jumlahSiswa)) / currentTemperature) > Math.random()) {
                currentSolution = Utility.copySolution(sIterasi);
            }

            System.out.println(i + " " + Utility.getPenalty(matrix, currentSolution, jumlahSiswa));
        }
        
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i][0] + " " + solution[i][1]);
        }
        int[] timeslotTempLd = new int[solution.length];
        for (int i = 0; i < solution.length; i++) {
            timeslotTempLd[i] = solution[i][1];
        }
        System.out.print("Timeslot dibutuhkan: " + Arrays.stream(timeslotTempLd).max().getAsInt() + "\n");
        
        
        System.out.println("Fitness Terbaik : " + Utility.getPenalty(matrix, bestSolution, jumlahSiswa));
        solusiTerbaik = bestSolution;
    }
}