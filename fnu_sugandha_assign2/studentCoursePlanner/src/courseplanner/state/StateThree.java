package courseplanner.state;

import courseplanner.util.Createcourseplan;

public class StateThree implements CoursePlannerStateI {
	
	GraduationTimeline graduationtimeline;
	public static final int stateindex = 2;
	Createcourseplan cp;
	
	public StateThree(GraduationTimeline graduationtimelinein) {
		graduationtimeline = graduationtimelinein;
		cp = new Createcourseplan();
	}
	
	public void assignCourses() {
		int changestate = cp.assignCourses(graduationtimeline, stateindex);
//		System.out.println("State3 "+changestate);
		if(changestate != -1 && changestate != stateindex) {
			graduationtimeline.changeState(changestate);
		}
	}
}
