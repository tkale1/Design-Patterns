package studentOrientation.collector;

/**
 * Declaring Enums for the CourseRegistration.
 * Along with the getter and setter methods for the same.
 */
public class CourseRegistrationChoice {

	public enum CourseRegistrationChoiceE {
		FORM_REGISTRATION, COMPUTER_REGISTRATION
	};

	private static CourseRegistrationChoiceE choice;

	/**
	 * Sets choice value for Course Registration.
	 * 
	 * @param choiceIn value of the Course Registratione Choice
	 */
	public static void setCourseRegistrationChoice(CourseRegistrationChoiceE choiceIn) {
		choice = choiceIn;
	}

	/**
	 * Gets choice value for Course Registration.
	 */
	public static CourseRegistrationChoiceE getCourseRegistrationChoice() {
		return choice;
	}

	public String toString() {
		return "Debug Level is " + choice;
	}
}
