package studentOrientation.collector;

/**
 * Declaring Enums for the TourChoice.
 * Along with the getter and setter methods for the same.
 */
public class TourChoice {

	public static enum CampusTourChoice {
		BUS_RIDE, ON_FOOT;
	}

	private static CampusTourChoice choice;

	/**
	 * Sets choice value for Tour Choice.
	 * 
	 * @param choiceIn
	 *            value of the Tour Choice
	 */
	public static void setTourChoice(CampusTourChoice choiceIn) {
		choice = choiceIn;
	}
	
	/**
	 * Gets choice value for Tour choice.
	 */
	public static CampusTourChoice getTourChoice() {
		return choice;
	}

	public String toString() {
		return "Debug Level is " + choice;
	}
}
