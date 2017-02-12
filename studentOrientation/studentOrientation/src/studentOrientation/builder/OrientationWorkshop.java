package studentOrientation.builder;

/**
 * This is an OrientationWorkshopInterface interface which has methods needed 
 * to build the whole Student Orientation.
 */
public class OrientationWorkshop implements OrientationWorkshopInterface {

	/**
	 * The construct() calls all the build method which is needed
	 * to build the students Orientation.
	 */
	@Override
	public void construct(StudentOrientationInterface studentOrientation) {
		// TODO Auto-generated method stub
		studentOrientation.buildCampusTour();
		studentOrientation.buildDormsSelection();
		studentOrientation.buildCourseRegistration();
		studentOrientation.buildBuyBooks();
	}

}
