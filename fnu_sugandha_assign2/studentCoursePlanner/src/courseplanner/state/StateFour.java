package courseplanner.state;

import courseplanner.util.Createcourseplan;

public class StateFour implements CoursePlannerStateI {
	
	GraduationTimeline graduationtimeline;
	public static final int stateindex = 3;
	Createcourseplan cp;
	
	public StateFour(GraduationTimeline graduationtimelinein) {
		graduationtimeline = graduationtimelinein;
		cp = new Createcourseplan();
	}
	
	public void assignCourses() {
		int changestate = cp.assignCourses(graduationtimeline, stateindex);
//		System.out.println("State4 "+changestate);
		if(changestate != -1 && changestate != stateindex) {
			graduationtimeline.changeState(changestate);
		}
	}
}
