package courseplanner.util;

import java.util.LinkedHashMap;

import courseplanner.entity.Student;
import courseplanner.state.CoursePlannerStateI;
import courseplanner.state.GraduationTimeline;

public class Createcourseplan {
//	int[] courseperstate = {0,0,0,0,0};
//	int courseassignedpersem = 0;
	String[] coursepergroup = {"ABCD","EFGH","IJKL","MNOP","QRSTUVWXYZ"};
	
	public Createcourseplan() {
		
	}
	
	public int assignCourses(GraduationTimeline g, int stateindex) {	
		int nextstate = -1;
		for(int i = 0; i < g.student.waitlistcourse.size(); i++) {
			if(checkPrereq(g.student.waitlistcourse.get(i), g.courseplan, g.getTotalSemester())) {
				g.courseplan.put(g.student.waitlistcourse.get(i), g.getTotalSemester());
				updateCoursePerState(g.student.waitlistcourse.get(i), g);
				g.student.waitlistcourse.remove(i);
				--i;
				if(gradRequiremment(g.courseperstate)) {
					g.setGraduated(true);
					return -1;
				}
				g.setCourseassignedpersem(g.getCourseassignedpersem() + 1);
				if (g.getCourseassignedpersem() == 3) {
					g.setTotalSemester(g.getTotalSemester() + 1);
					g.setCourseassignedpersem(0);
				}
				nextstate = getNextState(stateindex, g.courseperstate);
				if(nextstate != stateindex) {
					g.setStateCount(g.getStateCount() + 1);
//					System.out.println("val "+nextstate);
//					graduationtimeline.changeState(nextstate);
					return nextstate;
				} else {
					int x = assignCourses(g, stateindex);
					return x;
				}
			}	
		}
		
		for(int i = 0; i < g.student.coursepreference.size(); i++) {
			if(checkPrereq(g.student.coursepreference.get(i), g.courseplan, g.getTotalSemester())) {
				g.courseplan.put(g.student.coursepreference.get(i), g.getTotalSemester());
				updateCoursePerState(g.student.coursepreference.get(i), g);
				g.student.coursepreference.remove(i);
				--i;
				g.setCourseassignedpersem(g.getCourseassignedpersem() + 1);
				if(gradRequiremment(g.courseperstate)) {
					g.setGraduated(true);
					return -1;
				}
				if (g.getCourseassignedpersem() == 3) {
					g.setTotalSemester(g.getTotalSemester() + 1);
					g.setCourseassignedpersem(0);
				}
				nextstate = getNextState(stateindex, g.courseperstate);
				if(nextstate != stateindex) {
					g.setStateCount(g.getStateCount() + 1);
//					System.out.println("val pref "+nextstate);
//					graduationtimeline.changeState(nextstate);
					return nextstate;
				}else {
					int x = assignCourses(g, stateindex);
					return x;
				}	
			}else {
				g.student.waitlistcourse.add(g.student.coursepreference.get(i));
				g.student.coursepreference.remove(i);
				if(gradRequiremment(g.courseperstate)) {
					g.setGraduated(true);
					return -1;
				}
				int x = assignCourses(g, stateindex);
				return x;
			}
		}
		return nextstate;
	}
	
	public int getNextState(int currentstateindexin, int[] courseperstate) {
		int max = courseperstate[0];
		int currentstatecount = courseperstate[currentstateindexin];
		int maxindex = 0;
		for(int i = 0; i < courseperstate.length; i++) {
			if(courseperstate[i] > max) {
				max = courseperstate[i];
				maxindex = i;	
			}
		}
		if (currentstatecount == max) {
//			System.out.println("getNextState if "+ currentstateindexin);
			return currentstateindexin;
		}else {
//			System.out.println("getNextState else "+ maxindex);
			return maxindex;
		}	
	}
	
	public boolean checkPrereq(String coursein, LinkedHashMap<String,Integer> courseplan, int currentsemester) {
		String group = null;
		String prereq = null;
		
		if(checkGroup(coursein) >= 0) {
			group = coursepergroup[checkGroup(coursein)];
		}
		
		if(checkGroup(coursein) == 4) {
			return true;
		}
		
		prereq = group.substring(0,group.indexOf(coursein));
		
		for(int i = 0; i < prereq.length(); i++) {
			if(courseplan.containsKey(Character.toString(prereq.charAt(i))) &&
					courseplan.get(Character.toString(prereq.charAt(i))) != currentsemester){
			}else {
				return false;
			}
		}
		return true;	
	}
	
	public int checkGroup(String coursein) {	
		for(int i = 0; i < coursepergroup.length; i++) {
			if(coursepergroup[i].contains(coursein)) {
				return i;
			}
		}
		return -1;
	}	
	
	public void updateCoursePerState(String coursein, GraduationTimeline g) {
		int groupindex = checkGroup(coursein);
		g.courseperstate[groupindex] = g.courseperstate[groupindex] + 1;	
	}
	
	public boolean gradRequiremment(int[] courseperstate) {
		for(int i = 0; i < courseperstate.length; i ++) {
			if (courseperstate[i] < 2) {
				return false;
			}
		}
		return true;	
	}
}
