package okhtemp;

import okhtemp.SimulatedAnnealing;

public class MainSa{

    static final String DIREKTORI = "E:/Frequently Used/Edukasi/Kuliah/Semester 7/Optimasi Kombinatorik dan Heuristik/Toronto/";

    public static void main(String[] args) {
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

        long startTime2 = System.nanoTime();
        SimulatedAnnealing.run(dir_yorf83_stu, dir_yorf83_crs, 100, 1000);

        long endTime2 = System.nanoTime();
        long totalTime2 = endTime2 - startTime2;
        System.out.println("Total waktu : " + (double) totalTime2 / 1000000000 + " detik");
    }
}
