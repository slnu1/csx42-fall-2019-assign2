package courseplanner.state;

import courseplanner.util.Createcourseplan;

public class StateTwo implements CoursePlannerStateI {
	
	GraduationTimeline graduationtimeline;
	public static final int stateindex = 1;
	Createcourseplan cp;
	
	public StateTwo(GraduationTimeline graduationtimelinein) {
		graduationtimeline = graduationtimelinein;
		cp = new Createcourseplan();
	}
	
	public void assignCourses() {
		int changestate = cp.assignCourses(graduationtimeline, stateindex);
//		System.out.println("State2 "+changestate);
		if(changestate != -1 && changestate != stateindex) {
			graduationtimeline.changeState(changestate);
		}
	}
}
