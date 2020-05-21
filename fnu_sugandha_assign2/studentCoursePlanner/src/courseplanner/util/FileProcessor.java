package courseplanner.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import courseplanner.entity.Student;

public class FileProcessor {
private String inputfilename;
	
	public FileProcessor(String inputfilenameIn){		
		inputfilename = inputfilenameIn;	
	}
	
	public ArrayList<Student> readInputFile() throws CustomException {
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			fr = new FileReader(inputfilename);
			br = new BufferedReader(fr);
			String temp = null;
			Student s;
			while((temp = br.readLine()) != null) {
				s = processStudents(temp);
				for (int counter = 0; counter < students.size(); counter++) { 
					Student tempstudent = students.get(counter);
					if(tempstudent.id == s.id) {
						throw new CustomException("Duplicate student in the file.please provide the correct file.");
					}
				}
				students.add(s);
			}
		} catch(FileNotFoundException ex) {
			System.out.println("File not found exception for " + inputfilename + ex);
			System.exit(1);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				System.exit(1);
			}
		}
		return students;
	}
	
	public Student processStudents(String studentin) throws CustomException {
		
		//1234: A B C D E F G H I J K L M N O P Q R S T U V W
		String[] temp = studentin.split(":");
		//temp = {"1234"," A B C D E F G H I J K L M N O P Q R S T U V W"}
		//exception handling for ids
		if(temp[0].length() != 4) {
			throw new CustomException("id length is not equal to 4.please provide the valid id."); 
		}else if(temp[0].matches(".*[A-Za-z].*")) {
			throw new CustomException("Invalid alphanumeric id for the student.please provide the valid id.");
		}else if(temp[0].startsWith("0")){
			throw new CustomException("Id starting with 0.please provide the valid id.");
		}
		
		int id = Integer.parseInt(temp[0]);
		
		temp = temp[1].trim().split(" ");
		//temp = {"A","B","C", "D", "E", "F", "G", "H", "I" J K L M N O P Q R S T U V W"}
		
		ArrayList<String> preferences = new ArrayList<String>();
		
		
		for(int i = 0;i <temp.length; i++) {
			preferences.add(temp[i]);	
		}

		Student s = new Student(id,preferences);
		
		return s;		
	}	
}

class CustomException extends Exception{
  public CustomException(String message)
  {
    super(message);
  }
}
