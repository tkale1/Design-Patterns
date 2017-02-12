package studentOrientation.builder;

import studentOrientation.activity.Activity;
import studentOrientation.activity.BusTourActivity;
import studentOrientation.activity.GamingDormSelectionActivity;
import studentOrientation.activity.InHandCourseRegistrationAcitvity;
import studentOrientation.activity.InHandDormSelectionActivity;
import studentOrientation.activity.MandoBookstoreActivity;
import studentOrientation.activity.OnFootActivity;
import studentOrientation.activity.OnlineCourseRegistrationActivity;
import studentOrientation.activity.UniversityBookStore;
import studentOrientation.collector.BookStoreChoice;
import studentOrientation.collector.BookStoreChoice.BookStoreChoiceE;
import studentOrientation.collector.CourseRegistrationChoice;
import studentOrientation.collector.CourseRegistrationChoice.CourseRegistrationChoiceE;
import studentOrientation.collector.DormsChoice;
import studentOrientation.collector.DormsChoice.DormsChoiceE;
import studentOrientation.collector.TourChoice;
import studentOrientation.collector.TourChoice.CampusTourChoice;
import studentOrientation.expense.Calories;
import studentOrientation.expense.CarbonFootprints;
import studentOrientation.expense.CarbonFootprintsInterface;
import studentOrientation.expense.Cost;
import studentOrientation.expense.Dollar;
import studentOrientation.expense.DurationMins;
import studentOrientation.expense.Effort;
import studentOrientation.expense.Time;
import studentOrientation.util.Logger;

/**
 * The StudentOrientation Class which implements StudentOrientationInterface.
 */
public class StudentOrientation implements StudentOrientationInterface {

	private Activity campusTour, dormSelection, buyBook, classRegistration;
	private Cost money;
	private Time duration;
	private Effort effort;
	private CarbonFootprintsInterface carbonFootprints;

	/**
	 * The constructor of the StudentOrientation take all instances of all the
	 * Enums and Set the Enums inorder to identify the activities that are
	 * needed to be performed.
	 */
	public StudentOrientation(CampusTourChoice campusTourChoiceIn,
			DormsChoiceE dormsChoiceIn, BookStoreChoiceE bookStoreChoiceIn,
			CourseRegistrationChoiceE courseRegistrationChoiceE) {

		// TODO Auto-generated constructor stub
		Logger.writeMessage("In Constructor of StudentOrientation",
				Logger.DebugLevel.CONSTRUCTOR);

		TourChoice.setTourChoice(campusTourChoiceIn);
		DormsChoice.setDormsChoice(dormsChoiceIn);
		BookStoreChoice.setBookStoreChoice(bookStoreChoiceIn);
		CourseRegistrationChoice
				.setCourseRegistrationChoice(courseRegistrationChoiceE);
	}

	/**
	 * Initializes the CampusTour activity as per the Enum value. In future we
	 * can have addition activity such as HELICOPTOR_RIDE.
	 */
	@Override
	public void buildCampusTour() {
		// TODO Auto-generated method stub
		money = new Dollar();
		duration = new DurationMins();
		effort = new Calories();
		carbonFootprints = new CarbonFootprints();

		switch (TourChoice.getTourChoice()) {
		case BUS_RIDE:
			campusTour = new BusTourActivity(money, duration, effort,
					carbonFootprints);
			break;
		case ON_FOOT:
			campusTour = new OnFootActivity(money, duration, effort,
					carbonFootprints);
			break;
		default:
			break;
		}
	}

	/**
	 * Initializes the DormSelection activity as per the Enum value.
	 */
	@Override
	public void buildDormsSelection() {
		// TODO Auto-generated method stub
		money = new Dollar();
		duration = new DurationMins();
		effort = new Calories();
		carbonFootprints = new CarbonFootprints();

		switch (DormsChoice.getDormsChoice()) {
		case ADMIN_OFFICE:
			dormSelection = new InHandDormSelectionActivity(money, duration,
					effort, carbonFootprints);
			break;
		case GAMING_CONTEST:
			dormSelection = new GamingDormSelectionActivity(money, duration,
					effort, carbonFootprints);
			break;
		default:
			break;
		}
	}

	/**
	 * Initializes the BuyBook activity to select BOOKSTORE as per the Enum
	 * value.
	 */
	@Override
	public void buildBuyBooks() {
		// TODO Auto-generated method stub
		money = new Dollar();
		duration = new DurationMins();
		effort = new Calories();
		carbonFootprints = new CarbonFootprints();

		switch (BookStoreChoice.getBookStoreChoice()) {
		case MANDO_BOOOKS:
			buyBook = new MandoBookstoreActivity(money, duration, effort,
					carbonFootprints);
			break;
		case UNIVERSITY_BOOKSTORE:
			buyBook = new UniversityBookStore(money, duration, effort,
					carbonFootprints);
			break;
		default:
			break;
		}
	}

	/**
	 * Initializes the Course Registration activity as per the Enum value.
	 */
	@Override
	public void buildCourseRegistration() {
		// TODO Auto-generated method stub
		money = new Dollar();
		duration = new DurationMins();
		effort = new Calories();
		carbonFootprints = new CarbonFootprints();

		switch (CourseRegistrationChoice.getCourseRegistrationChoice()) {
		case COMPUTER_REGISTRATION:
			classRegistration = new OnlineCourseRegistrationActivity(money,
					duration, effort, carbonFootprints);
			break;
		case FORM_REGISTRATION:
			classRegistration = new InHandCourseRegistrationAcitvity(money,
					duration, effort, carbonFootprints);
			break;
		default:
			break;
		}

	}

	/**
	 * Returns a String with the output of the whole Orientation in terms of
	 * Cost, Duration, Effort, CarbonFootprint.
	 */
	@Override
	public String getResult() {
		return "Cost: "
				+ (campusTour.getCost() + dormSelection.getCost()
						+ classRegistration.getCost() + buyBook.getCost())
				+ " "
				+ money.getUnit()
				+ "\nDuration: "
				+ (campusTour.getDuration() + dormSelection.getDuration()
						+ classRegistration.getDuration() + buyBook
							.getDuration())
				+ " "
				+ duration.getUnit()
				+ "\nEffort: "
				+ (campusTour.getEffort() + dormSelection.getEffort()
						+ classRegistration.getEffort() + buyBook.getEffort())
				+ " "
				+ effort.getUnit()
				+ "\nCarbon Footprints: "
				+ (campusTour.getCarbonFootprint()
						+ dormSelection.getCarbonFootprint()
						+ classRegistration.getCarbonFootprint() + buyBook
							.getCarbonFootprint()) + " "
				+ carbonFootprints.getUnit();
	}

}
