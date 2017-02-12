package studentOrientation.driver;

import studentOrientation.builder.OrientationWorkshop;
import studentOrientation.builder.OrientationWorkshopInterface;
import studentOrientation.builder.StudentOrientation;
import studentOrientation.builder.StudentOrientationInterface;
import studentOrientation.collector.BookStoreChoice.BookStoreChoiceE;
import studentOrientation.collector.CourseRegistrationChoice.CourseRegistrationChoiceE;
import studentOrientation.collector.DormsChoice.DormsChoiceE;
import studentOrientation.collector.TourChoice.CampusTourChoice;
import studentOrientation.util.Logger;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger.setDebugValue(0);
		OrientationWorkshopInterface workshop = new OrientationWorkshop();
		StudentOrientationInterface orientation = new StudentOrientation(
				CampusTourChoice.ON_FOOT, DormsChoiceE.GAMING_CONTEST,
				BookStoreChoiceE.UNIVERSITY_BOOKSTORE,
				CourseRegistrationChoiceE.FORM_REGISTRATION);
		workshop.construct(orientation);
		System.out.println(orientation.getResult());
	}

}
