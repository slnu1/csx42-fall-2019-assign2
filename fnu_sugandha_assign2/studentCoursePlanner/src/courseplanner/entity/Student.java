package courseplanner.entity;

import java.util.ArrayList;


public class Student {
	public int id;
	public ArrayList<String> coursepreference = new ArrayList<String>();
	public ArrayList<String> waitlistcourse = new ArrayList<String>();
	
	public Student(int idin,ArrayList<String> coursepreferencein) {
    	id = idin;
    	coursepreference = coursepreferencein;
    } 
    
	
    public void checkOutput() {
    	System.out.println(id);
    	for(int i = 0;i < coursepreference.size();i++) {
    		System.out.print(coursepreference.get(i));
    	}	
    	System.out.println(" ");
    	
    }
    
}
