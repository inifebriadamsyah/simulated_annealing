package okhtemp;

import java.util.ArrayList;

public class GeneticAlgorithm {

    private static ArrayList<Solution> recombination(Solution s1, Solution s2) {
        int[][] sol1 = s1.getSolution();
        int[][] sol2 = s2.getSolution();

        int n = sol1.length / 2;

        int[][] temporary1 = Utility.copySolution(sol1);
        int[][] temporary2 = Utility.copySolution(sol2);

        for (int i = 0; i < n; i++) {
            sol1[i][1] = temporary2[temporary2.length - n + i][1];
            sol2[temporary2.length - n + i][1] = temporary1[i][1];
        }

        Solution solution1 = new Solution(sol1);
        Solution solution2 = new Solution(sol2);

        ArrayList<Solution> solutions = new ArrayList<Solution>();
        solutions.add(solution1);
        solutions.add(solution2);

        return solutions;
    }

    private static Solution mutation(Solution solution) {
        int[][] arrSol = solution.getSolution();

        int step = 100;

        for (int i = 0; i < step; i++) {
            int randomExam = Utility.getRandomNumber(1, arrSol.length - 1);
            int randomTimeslot = Utility.getRandomNumber(1, solution.getJumlahTimeslot());

            arrSol[randomExam][1] = randomTimeslot;
        }
        Solution mutationSolution = new Solution(arrSol);
        return mutationSolution;
    }

    private static ArrayList<Solution> generatePopulation(CourseSet cs, ConflictMatrix cm, int populationSize) {
        int jumlahStudent = cm.getJumlahStudent();
        int[][] conflict_matrix = cm.getMatrix();

        ArrayList<Solution> population = new ArrayList<Solution>();

        for (int i = 0; i < populationSize; i++) {
//			int[][] index = cm.getRandomIndex(cs.getSize());
//			int[][] matrix = cm.getRandomMatrix(index);	
            int[][] matrix = cm.getLargestDegree();

            Scheduler scheduler = new Scheduler(cs.getSize());
            scheduler.timesloting(matrix, 100);
//			scheduler.printSchedule(index);
            scheduler.printSchedule(cm.getDegree());
            int[][] solution = scheduler.getSchedule();

            Solution s = new Solution(solution);
            population.add(s);

            double penalty = Utility.getPenalty(conflict_matrix, solution, jumlahStudent);
            s.setPenalty(penalty);
        }

        return population;
    }

    public static void run(String dir_stu, String dir_crs, int populationSize, int iterasi) {
        CourseSet courseSet = new CourseSet(dir_crs);
        ConflictMatrix conflictMatrix = new ConflictMatrix(dir_stu, courseSet.getSize());

        int jumlahStudent = conflictMatrix.getJumlahStudent();
        int[][] conflict_matrix = conflictMatrix.getMatrix();

        ArrayList<Solution> population = generatePopulation(courseSet, conflictMatrix, populationSize);

        int iter = iterasi;

        Solution bestSolution = new Solution(courseSet.getSize());
        bestSolution.setPenalty(Integer.MAX_VALUE);

        while (iter > 0) {
            population.sort((o1, o2) -> o1.getPenalty().compareTo(o2.getPenalty()));

            System.out.println("Best fit solution : \n\t" + population.get(0).getPenalty() + "\n\t" + population.get(0).getJumlahTimeslot());
            System.out.println("2nd best fit solution : \n\t" + population.get(1).getPenalty() + "\n\t" + population.get(1).getJumlahTimeslot());

            // Recombination
            Solution solution1 = population.get(0);
            Solution solution2 = population.get(1);

            ArrayList<Solution> solRecombination = recombination(solution1, solution2);
            solution1 = solRecombination.get(0);
            solution2 = solRecombination.get(1);
            solution1.setPenalty(Utility.getPenalty(conflict_matrix, solution1.getSolution(), jumlahStudent));
            solution2.setPenalty(Utility.getPenalty(conflict_matrix, solution2.getSolution(), jumlahStudent));

            System.out.println("Solution 1 : \n\t" + solution1.getPenalty() + "\n\t" + solution1.getJumlahTimeslot());
            System.out.println("Solution 2 : \n\t" + solution2.getPenalty() + "\n\t" + solution2.getJumlahTimeslot());

            // Mutation
            solution1 = mutation(solution1);
            solution2 = mutation(solution2);

            solution1.setPenalty(Utility.getPenalty(conflict_matrix, solution1.getSolution(), jumlahStudent));
            solution2.setPenalty(Utility.getPenalty(conflict_matrix, solution2.getSolution(), jumlahStudent));

            System.out.println();
            System.out.println("Solution 1 : \n\t" + solution1.getPenalty() + "\n\t" + solution1.getJumlahTimeslot());
            System.out.println("Solution 2 : \n\t" + solution2.getPenalty() + "\n\t" + solution2.getJumlahTimeslot());

            if (solution1.getPenalty() < solution2.getPenalty() && solution1.getPenalty() < bestSolution.getPenalty()) {
                bestSolution = solution1;
            } else if (solution2.getPenalty() < solution1.getPenalty() && solution2.getPenalty() < bestSolution.getPenalty()) {
                bestSolution = solution2;
            }

            population = generatePopulation(courseSet, conflictMatrix, populationSize);

            iter--;

        }

        System.out.println("Best solution : " + bestSolution.getPenalty() + " " + bestSolution.getJumlahTimeslot());
    }
}