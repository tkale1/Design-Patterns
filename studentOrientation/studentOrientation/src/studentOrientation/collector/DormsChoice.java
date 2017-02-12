package studentOrientation.collector;
/**
 * Declaring Enums for the DormsChoice.
 * Along with the getter and setter methods for the same.
 */
public class DormsChoice {

	public static enum DormsChoiceE {
		ADMIN_OFFICE, GAMING_CONTEST
	};

	private static DormsChoiceE choice;

	/**
	 * Sets choice value for Dorms Choice.
	 * 
	 * @param choiceIn
	 *            value of the Dorms Choice
	 */
	public static void setDormsChoice(DormsChoiceE choiceIn) {
		choice = choiceIn;
	}

	/**
	 * Gets choice value for Dorms Selection.
	 */

	public static DormsChoiceE getDormsChoice() {
		return choice;
	}

	public String toString() {
		return "Debug Level is " + choice;
	}
}
