package courseplanner.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import courseplanner.entity.Student;
import courseplanner.state.GraduationTimeline;



public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	Student student;
	String filename;
	
	BufferedWriter bw;
	
	public Results(String filenamein) {
		filename = filenamein;
	}
	
	public void displayStdoutResults(int idin,GraduationTimeline g) {
		LinkedHashMap<String,Integer> courseplan;
    	System.out.print(idin+": ");
    	courseplan = g.getCoursePlan();
		for(String key : courseplan.keySet() ) {
			System.out.print(key+" " );
		}
    	if(g.getGradStatus()) {
			System.out.print(" "+g.getTotalSemester());
			System.out.print(" "+g.getStateCount());	
		}else {
			System.out.print("the student cannot be graduated");
		}
	}
	
	/**
	 * write output to file passed in a command line argument
	 * @return void
	 * @param null
	 *  */
	public void displayResults(int idin,GraduationTimeline g) {
		try {
			LinkedHashMap<String,Integer> courseplan;
			bw.write(idin+": ");
			courseplan = g.getCoursePlan();
			for(String key : courseplan.keySet() ) {
				bw.write(key+" " );
			}
			if(g.getGradStatus()) {
				bw.write(" "+g.getTotalSemester());
				bw.write(" "+g.getStateCount());	
			}else {
				bw.write(" "+0);
				bw.write(" "+g.getStateCount());
				bw.write(" the student cannot be graduated");
			}			
			bw.newLine(); 
	      } catch (IOException e) {
	         e.printStackTrace();
	      } 
	}
	
	public void createFile() {
		try {
			 File file = new File(filename);
	         if (!file.exists()) {
	            file.createNewFile();
	         } 
	         FileWriter fw = new FileWriter(file.getAbsoluteFile());
		     bw = new BufferedWriter(fw);
		} catch (IOException e) {
			 e.printStackTrace();
		}   	  
	}
	
	public void closeFile() {
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
