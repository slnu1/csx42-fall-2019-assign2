package courseplanner.state;

import courseplanner.util.Createcourseplan;

public class StateFive implements CoursePlannerStateI {
	
	GraduationTimeline graduationtimeline;
	public static final int stateindex = 4;
	Createcourseplan cp;
	
	public StateFive(GraduationTimeline graduationtimelinein) {
		graduationtimeline = graduationtimelinein;
		cp = new Createcourseplan();
	}
	
	public void assignCourses() {
		int changestate = cp.assignCourses(graduationtimeline, stateindex);
//		System.out.println("State5 "+changestate);
		if(changestate != -1 && changestate != stateindex) {
			graduationtimeline.changeState(changestate);
		}
	}
}
