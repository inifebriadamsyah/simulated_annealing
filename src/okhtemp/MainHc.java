package okhtemp;

import okhtemp.Heuristics;

public class MainHc {

    static final String DIREKTORI = "E:/Frequently Used/Edukasi/Kuliah/Semester 7/Optimasi Kombinatorik dan Heuristik/Toronto/";

    public static void main(String[] args) {
        // Direktori file
        String stud_set = DIREKTORI + "car-f-92.stu";
        String crs_set = DIREKTORI + "car-f-92.crs";

        String test_stu = DIREKTORI + "test.stu";
        String test_crs = DIREKTORI + "test.crs";

        long startTime = System.nanoTime();
        Heuristics.hillClimbing(stud_set, crs_set, 100, 1000);
        long endTime = System.nanoTime();
        System.out.println("Runtime: " +(double) (endTime - startTime) / 1000000000);
        int[][] jadwal = Heuristics.getJadwal();
        for (int i = 0; i < jadwal.length; i++) {
            System.out.println(jadwal[i][0] + " " + jadwal[i][1]);
        }
    }
}
