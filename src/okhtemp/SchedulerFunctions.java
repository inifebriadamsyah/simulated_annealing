package okhtemp;

import java.io.FileWriter;
import java.util.Arrays;

public class SchedulerFunctions {

    private int size;
    private int[] timeslot;
    private boolean adaSolusi;
    private int[][] schedule;
    private int jumlahTimeslot;
    private String solusi = "";

    public SchedulerFunctions() {
        this.size = 0;
    }

    public SchedulerFunctions(int size) {
        this.size = size;
    }

    public int[][] getSchedule() {
        return this.schedule;
    }

    public String getSolusi() {
        return this.solusi;
    }

    public int[] getTimeslot() {
        return this.timeslot;
    }
    
    public void setJumlahTimeslot(int jumlahTimeslot) {
    	this.jumlahTimeslot = jumlahTimeslot;
    }
    
    public int getJumlahTimeslot() {
    	return this.jumlahTimeslot;
    } 

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean getAdaSolusi() {
        return this.adaSolusi;
    }

    private void setAdaSolusi(boolean status) {
        this.adaSolusi = status;
    }

    private boolean checkTimeslot(int course, int[][] matrix, int[] timeslot, int t) {
        for (int i = 0; i < size; i++) {
            if (matrix[course][i] != 0 && t == timeslot[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRandomTimeslot(int randomCourse, int randomTimeslot, int[][] matrix, int[][] jadwal) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[randomCourse][i] != 0 && jadwal[i][1] == randomTimeslot) {
                return false;
            }
        }
        return true;
    }

    private boolean isTersedia(int[][] matrix, int jumlah_timeslot, int[] timeslot, int course) {
        if (course == size) {
            return true;
        }

        for (int i = 1; i <= jumlah_timeslot; i++) {
            if (checkTimeslot(course, matrix, timeslot, i)) {
                timeslot[course] = i;

                if (isTersedia(matrix, jumlah_timeslot, timeslot, course + 1)) {
                    return true;
                }

                timeslot[course] = 0;
            }
        }

        return false;
    }

    public void timesloting(int[][] matrix, int jumlah_timeslot) {
        timeslot = new int[size];
        for (int i = 0; i < size; i++) {
            timeslot[i] = 0;
        }

        if (isTersedia(matrix, jumlah_timeslot, timeslot, 0)) {
            setAdaSolusi(true);
        } else {
            setAdaSolusi(false);
        }
    }
    
    private static int calculateSaturation(int[][] sat, int batas) {
		int min = 10000;
		int index = 0;
		for(int i = 0; i < sat.length; i++) {
			if(sat[i][1] < min) {
				index = i;
				min = sat[i][1];
			}
		}
		return index;
	}
	
	public static int[][] getSaturationSchedule(int size, int[][] largestDegree, int[][] matrix) {
		int[][] schedule = new int[size][2];
		int[][] saturation = new int[size][2];
		int timeslot = 1;
		
		for(int i = 0; i<schedule.length; i++) {
            schedule[i][0] = i+1;
            schedule[i][1] = -1;
            saturation[i][0] = largestDegree[i][0];
            saturation[i][1] = size;
        }
		
		for(int i=0; i<size; i++) {
            int index = calculateSaturation(saturation, size);
            for (int j=0; j<=timeslot; j++) {
                if(isOk(saturation[index][0]-1, j, matrix, schedule, saturation)) {
                    schedule[saturation[index][0]-1][1] = j;
                    saturation[index][1] = 100000;
                    int ind = 0;
                    for(int k=0; k<matrix.length; k++) {
                        if(matrix[saturation[index][0]-1][k]!=0) {
                            ind = k;
                            for(int l=0; l<saturation.length; l++) {
                                if(saturation[l][0]==k+1) {
                                    saturation[l][1] = saturation[l][1]-1;
                                }
                            }
                        }
                    }
                    break;
                }
                else {
                    timeslot++;
                }
            }
		}
		return schedule;
	}
		
	private static boolean isOk(int ex, int jad, int[][]cm, int [][]timeslot, int[][]largest) {
		for(int i=0; i<cm.length; i++)
			if(cm[ex][i]!=0 && timeslot[i][1]==jad)
				return false;
		return true;
	}

    public void printSchedule() {
        if (!adaSolusi) {
            System.out.println("null");
        } else {
            System.out.println("Jumlah Timeslot : " + Arrays.stream(timeslot).max().getAsInt());
            for (int i = 0; i < size; i++) {
                System.out.println(+(i + 1) + " " + timeslot[i]);

            }
            System.out.println();
        }
    }
   
    public void printSchedule(int[][] degree) {
        if (!adaSolusi) {
            System.out.println("Null");
        } else {
            schedule = new int[size][2];
            for (int i = 0; i < size; i++) {
//                System.out.println(+ (degree[i][0]) +" " + (timeslot[i])); 
                solusi += degree[i][0] + " " + timeslot[i] + "\n";
                schedule[i][0] = degree[i][0];
                schedule[i][1] = timeslot[i];
            }
        }
    }

    public void exportSchedule(String filename) {
        try {
            FileWriter fileWriter = new FileWriter("E:/Frequently Used/Edukasi/Kuliah/Semester 7/Optimasi Kombinatorik dan Heuristik/Solusi/" + filename + ".sol");
            fileWriter.write(this.getSolusi());
            fileWriter.close();
            System.out.println("File "+filename+" berhasil disimpan bos"); 
        } catch (Exception e) {
            System.out.println("Error = " + e);
        }
//            System.out.println("File "+filename+" berhasil disimpan bos");    
    }
}
