package studentOrientation.activity;

import studentOrientation.expense.CarbonFootprintsInterface;
import studentOrientation.expense.Cost;
import studentOrientation.expense.Effort;
import studentOrientation.expense.Time;
import studentOrientation.util.Logger;

/**
 * The OnlineCourseRegistrationActivity Class which implements Activity.
 */

public class OnlineCourseRegistrationActivity implements Activity {
	private Cost cost;
	private Time duration;
	private Effort effort;
	private CarbonFootprintsInterface carbonFootprints;

	/**
	 * The constructor of the OnlineCourseRegistrationActivity take all instances 
	 * of all the activities as an argument. It then initializes 
	 * the arguments and set the value of each of the activities.
	 * NOTE: The setValue() takes hardcoded values.
	 */
	public OnlineCourseRegistrationActivity(Cost costIn, Time durationIn, Effort effortIn, CarbonFootprintsInterface carbonFootprintsIn) {
		// TODO Auto-generated constructor stub
		Logger.writeMessage ("In Constructor of OnlineCourseRegistrationActivity", Logger.DebugLevel.CONSTRUCTOR);

		cost = costIn;
		cost.setCost(15000);
		duration = durationIn;
		duration.setTime(20);
		effort = effortIn;
		effort.setEffort(70);
		carbonFootprints = carbonFootprintsIn;
		carbonFootprints.setCarbonFootprints(0.13);
		Logger.writeMessage(
				"Values set for OnlineCourseRegistrationActivity(Cost, Time, Effort, carbonfootprints):"
						+ cost.getCost() + "," + duration.getTime() + ","
						+ effort.getEffort() + ","
						+ carbonFootprints.getCarbonFootprints(),
				Logger.DebugLevel.VALUESET);
	}

	/**
	 * returns Cost of the OnFootActivity.
	 */
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return cost.getCost();
	}

	/**
	 * returns Duration of the OnFootActivity.
	 */
	@Override
	public double getDuration() {
		// TODO Auto-generated method stub
		return duration.getTime();
	}

	/**
	 * returns Effort of the OnFootActivity.
	 */
	@Override
	public double getEffort() {
		// TODO Auto-generated method stub
		return effort.getEffort();
	}

	/**
	 * returns CarbonFootprint of the OnFootActivity.
	 */
	@Override
	public double getCarbonFootprint() {
		// TODO Auto-generated method stub
		return carbonFootprints.getCarbonFootprints();
	}

}
