package courseplanner.state;

//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.LinkedHashMap;

import courseplanner.entity.Student;
import courseplanner.util.Createcourseplan;

public class GraduationTimeline {

	CoursePlannerStateI stateone;
	CoursePlannerStateI statetwo;
	CoursePlannerStateI statethree;
	CoursePlannerStateI statefour;
	CoursePlannerStateI statefive;
	
	CoursePlannerStateI state;
	public int[] courseperstate = {0,0,0,0,0};
	int statechangecount = 0;
	int courseassignedpersem = 0;
	int currentsemester = 1;
//	String[] coursepergroup = {"ABCD","EFGH","IJKL","MNOP","QRSTUVWXYZ"};
	public Student student;
	public LinkedHashMap<String,Integer> courseplan = new LinkedHashMap<String,Integer>();
	boolean graduated = false;
	
//	Createcourseplan cp;
	
	public GraduationTimeline(Student studentin) {
		stateone = new StateOne(this);
		statetwo = new StateTwo(this);
		statethree = new StateThree(this);
		statefour = new StateFour(this);
		statefive = new StateFive(this);
		student = studentin;
		state = stateone;
//		cp = new Createcourseplan();
	}
	
	
	public boolean getGradStatus() {
		return graduated;
	}

	public void setGraduated(boolean val) {
		graduated = val;
	}
	
	public int getCourseassignedpersem() {
		return courseassignedpersem;
	}


	public void setCourseassignedpersem(int val) {
		courseassignedpersem = val;
	}
	
	public int getStateCount() {
		return statechangecount;
	}
	
	public void setStateCount(int val) {
		statechangecount = val;
	}

	public void assignCourses() {
		state.assignCourses();
	}
	
	public int getTotalSemester() {
		return currentsemester;
	}
	
	public void setTotalSemester(int val) {
		currentsemester = val;
	}
	
	
//	public int getNextState(int currentstateindexin) {
//		int max = courseperstate[0];
//		int currentstatecount = courseperstate[currentstateindexin];
//		int maxindex = 0;
//		for(int i = 0; i < courseperstate.length; i++) {
//			if(courseperstate[i] > max) {
//				max = courseperstate[i];
//				maxindex = i;	
//			}
//		}
//		if (currentstatecount == max) {
//			return currentstateindexin;
//		}else {
//			return maxindex;
//		}	
//	}
	
	public void setState(CoursePlannerStateI statein) {
		this.state = statein;
		assignCourses();
	}
	
	
	public void changeState(int statein) {
		if(statein == 0) {
			setState(stateone);
		}else if(statein == 1) {
			setState(statetwo);
		}else if(statein == 2) {
			setState(statethree);
		}else if(statein == 3) {
			setState(statefour);
		}else if(statein == 4) {
			setState(statefive);
		}
	}
	
	
//	public boolean checkPrereq(String coursein) {
//		String group = null;
//		String prereq = null;
//		
//		if(checkGroup(coursein) >= 0) {
//			group = coursepergroup[checkGroup(coursein)];
//		}
//		
//		if(checkGroup(coursein) == 4) {
//			return true;
//		}
//		
//		prereq = group.substring(0,group.indexOf(coursein));
//		
//		for(int i = 0; i < prereq.length(); i++) {
//			if(courseplan.containsKey(Character.toString(prereq.charAt(i))) &&
//					courseplan.get(Character.toString(prereq.charAt(i))) != currentsemester){
//			}else {
//				return false;
//			}
//		}
//		return true;	
//	}
//	
//	public int checkGroup(String coursein) {	
//		for(int i = 0; i < coursepergroup.length; i++) {
//			if(coursepergroup[i].contains(coursein)) {
//				return i;
//			}
//		}
//		return -1;
//	}	
//	
//	public void updateCoursePerState(String coursein) {
//		int groupindex = checkGroup(coursein);
//		courseperstate[groupindex] = courseperstate[groupindex] + 1;	
//	}
//	
//	public boolean gradRequiremment() {
//		for(int i = 0; i < courseperstate.length; i ++) {
//			if (courseperstate[i] < 2) {
//				return false;
//			}
//		}
//		return true;	
//	}
	
	public LinkedHashMap<String,Integer> getCoursePlan(){
		return courseplan;
	}
}
