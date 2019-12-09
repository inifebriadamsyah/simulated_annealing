package okhtemp;

public class SimulatedAnnealing {

    static int[][] solusiTerbaik;

    public static int[][] run2(int[][] matrix, int jumlahSiswa, int[][] solution, double temperature, int iterasi) {
        int[][] sCurrent = solution;
        int[][] sBest = Utility.copySolution(sCurrent);
        double reductionFactor = 0.001;
        double tempCurr = temperature;

        for (int i = 0; i < iterasi; i++) {
            int randomLLH = Utility.getRandomNumber(1, 5);
            int[][] sIterasi;

            switch (randomLLH) {
                case 1:
                    sIterasi = Utility.move(sCurrent.clone(), 1);
                    break;
                case 2:
                    sIterasi = Utility.swap(sCurrent.clone(), 1);
                    break;
                case 3:
                    sIterasi = Utility.move(sCurrent.clone(), 2);
                    break;
                case 4:
                    sIterasi = Utility.swap(sCurrent.clone(), 3);
                    break;
                case 5:
                    sIterasi = Utility.move(sCurrent.clone(), 3);
                    break;
                default:
                    sIterasi = Utility.swap(sCurrent.clone(), 1);
                    break;
            }

            tempCurr = tempCurr * (1 - reductionFactor);

            if (Utility.getPenalty(matrix, sIterasi, jumlahSiswa) <= Utility.getPenalty(matrix, sCurrent, jumlahSiswa)) {
                sCurrent = Utility.copySolution(sIterasi);
                if (Utility.getPenalty(matrix, sIterasi, jumlahSiswa) <= Utility.getPenalty(matrix, sBest, jumlahSiswa)) {
                    sBest = Utility.copySolution(sIterasi);
                }
            } else if (Math.exp((Utility.getPenalty(matrix, sCurrent, jumlahSiswa) - Utility.getPenalty(matrix, sIterasi, jumlahSiswa)) / tempCurr) > Math.random()) {
                sCurrent = Utility.copySolution(sIterasi);
            }

            System.out.println(i + " " + Utility.getPenalty(matrix, sCurrent, jumlahSiswa));
        }

        return sBest;
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

        int[][] sCurrent = solution;
        int[][] sBest = Utility.copySolution(sCurrent);
        double reductionFactor = 0.001;
        double tempCurr = temperature;

        for (int i = 0; i < iterasi; i++) {
            int randomLLH = Utility.getRandomNumber(1, 5);
            int[][] sIterasi;

            switch (randomLLH) {
                case 1:
                    sIterasi = Utility.move(sCurrent.clone(), 1);
                    break;
                case 2:
                    sIterasi = Utility.swap(sCurrent.clone(), 1);
                    break;
                case 3:
                    sIterasi = Utility.move(sCurrent.clone(), 2);
                    break;
                case 4:
                    sIterasi = Utility.swap(sCurrent.clone(), 3);
                    break;
                case 5:
                    sIterasi = Utility.move(sCurrent.clone(), 3);
                    break;
                default:
                    sIterasi = Utility.swap(sCurrent.clone(), 1);
                    break;
            }

            tempCurr = tempCurr * (1 - reductionFactor);

            if (Utility.getPenalty(matrix, sIterasi, jumlahSiswa) <= Utility.getPenalty(matrix, sCurrent, jumlahSiswa)) {
                sCurrent = Utility.copySolution(sIterasi);
                if (Utility.getPenalty(matrix, sIterasi, jumlahSiswa) <= Utility.getPenalty(matrix, sBest, jumlahSiswa)) {
                    sBest = Utility.copySolution(sIterasi);
                }
            } else if (Math.exp((Utility.getPenalty(matrix, sCurrent, jumlahSiswa) - Utility.getPenalty(matrix, sIterasi, jumlahSiswa)) / tempCurr) > Math.random()) {
                sCurrent = Utility.copySolution(sIterasi);
            }

            System.out.println(i + " " + Utility.getPenalty(matrix, sCurrent, jumlahSiswa));
        }
        System.out.println("Fitness Terbaik : " + Utility.getPenalty(matrix, sBest, jumlahSiswa));
        solusiTerbaik = sBest;
    }
}
