package courseplanner.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import courseplanner.entity.Student;
import courseplanner.state.GraduationTimeline;
import courseplanner.util.FileProcessor;
import courseplanner.util.Results;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
			System.exit(1);
		}
		FileProcessor fp;
		fp = new FileProcessor(args[0]);
		ArrayList<Student> students = null;
		try {
			students = fp.readInputFile();
		} catch(Exception e) {
			System.exit(1);
		}
		if (students.size() == 0) {
			System.err.println("Error: File is empty, please provide correct input file.");
			System.exit(1);
		}
		LinkedHashMap<String,Integer> courseplan;
		GraduationTimeline g;
		Results re = new Results(args[1]);
		re.createFile();
		for(int i = 0; i < students.size(); i++) {
//			students.get(i).checkOutput();
			g = new GraduationTimeline(students.get(i));
			g.assignCourses();
			re.displayResults(students.get(i).id, g);
		}
		re.closeFile();	
	}
}
