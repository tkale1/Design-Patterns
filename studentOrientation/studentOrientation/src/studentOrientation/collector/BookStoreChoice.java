package studentOrientation.collector;

/**
 * Declaring Enums for the BookStore.
 * Along with the getter and setter methods for the same.
 */
public class BookStoreChoice {

	public static enum BookStoreChoiceE {
		UNIVERSITY_BOOKSTORE, MANDO_BOOOKS
	};

	private static BookStoreChoiceE choice;

	/**
	 * Sets choice value for Book Store.
	 * 
	 * @param choiceIn value of the Book Store Choice
	 */
	public static void setBookStoreChoice(BookStoreChoiceE choiceIn) {
		choice = choiceIn;
	}

	/**
	 * Gets choice value for Book Store.
	 */
	public static BookStoreChoiceE getBookStoreChoice() {
		return choice;
	}

	public String toString() {
		return "Debug Level is " + choice;
	}
}
