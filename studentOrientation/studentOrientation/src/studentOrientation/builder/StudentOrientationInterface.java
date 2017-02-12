package studentOrientation.builder;

/**
 * OrientationWorkshopInterface used for declaring the method 
 * needed to implement for building the Orientation workshop.
 * In furture we can add more build methods which will be added
 * in the orientation. ex : buildMeetProfessor().
 */
public interface StudentOrientationInterface {
	public void buildCampusTour();
	public void buildDormsSelection();
	public void buildBuyBooks();
	public void buildCourseRegistration();

	public String getResult();

}
