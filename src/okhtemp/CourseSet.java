package okhtemp;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.FileReader;

public class CourseSet {
	Set<String> course;
	public CourseSet(String fileDirectory) {
		try {
			FileReader fileReader = new FileReader(fileDirectory);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			readCourse(bufferedReader);
		} catch(Exception e) {}
	}
	
	public Set<String> getCourse() {
		return this.course;
	}
	
	public void readCourse(BufferedReader bufferedReader) {
		course = new HashSet<String>();
		String courseLine = null;
		try {
			while((courseLine = bufferedReader.readLine()) != null) {
				String[] array = courseLine.split(" ");
				course.add(array[0]);
			}			
		} catch(Exception e) {
			System.out.println("Error boss");
		}
	}
	
	public void printSet() {
		Set<String> sortedCourse = new TreeSet<String>(course); 
        System.out.println(sortedCourse);
	}
	
	public int getSize() {
		return course.size();
	}
	
}
