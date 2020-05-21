package courseplanner.state;

import courseplanner.util.Createcourseplan;

public class StateOne implements CoursePlannerStateI {
	
	GraduationTimeline graduationtimeline;
	public static final int stateindex = 0;
	Createcourseplan cp;
	
	public StateOne(GraduationTimeline graduationtimelinein) {
		graduationtimeline = graduationtimelinein;
		cp = new Createcourseplan();
	}
	
	public void assignCourses() {
		int changestate = cp.assignCourses(graduationtimeline, stateindex);
//		System.out.println("State1 "+changestate);
		if(changestate != -1 && changestate != stateindex) {
			graduationtimeline.changeState(changestate);
			return;
		}
	}
}
