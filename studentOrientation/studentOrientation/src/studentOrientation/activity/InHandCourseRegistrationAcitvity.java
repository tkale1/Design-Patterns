package studentOrientation.activity;

import studentOrientation.expense.CarbonFootprintsInterface;
import studentOrientation.expense.Cost;
import studentOrientation.expense.Effort;
import studentOrientation.expense.Time;
import studentOrientation.util.Logger;

/**
 * The InHandCourseRegistrationAcitvity Class which implements Activity.
 */
public class InHandCourseRegistrationAcitvity implements Activity {
	private Cost cost;
	private double discount = 0.03;
	private Time duration;
	private Effort effort;
	private CarbonFootprintsInterface carbonFootprints;
	
	/**
	 * The constructor of the InHandCourseRegistrationAcitvity take all instances 
	 * of all the activities as an argument. It then initializes 
	 * the arguments and set the value of each of the activities.
	 * NOTE: The setValue() takes hard-coded values.
	 */
	public InHandCourseRegistrationAcitvity(Cost costIn, Time durationIn, Effort effortIn, CarbonFootprintsInterface carbonFootprintsIn) {
		// TODO Auto-generated constructor stub
		Logger.writeMessage ("In Constructor of InHandCourseRegistrationAcitvity", Logger.DebugLevel.CONSTRUCTOR);

		cost = costIn;
		cost.setCost(getDiscount(15000));
		duration = durationIn;
		duration.setTime(90);
		effort = effortIn;
		effort.setEffort(100);
		carbonFootprints = carbonFootprintsIn;
		carbonFootprints.setCarbonFootprints(0.08);
		Logger.writeMessage(
				"Values set for InHandCourseRegistrationAcitvity(Cost, Time, Effort, carbonfootprints):"
						+ cost.getCost() + "," + duration.getTime() + ","
						+ effort.getEffort() + ","
						+ carbonFootprints.getCarbonFootprints(),
				Logger.DebugLevel.VALUESET);
	}

	/**
	 * returns the total cost after getting Discount.
	 */
	private double getDiscount(double fees) {
		// TODO Auto-generated method stub
		return fees - fees * discount;
	}

	/**
	 * returns Cost of the InHandCourseRegistrationAcitvity.
	 */
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return cost.getCost();
	}

	/**
	 * returns Duration of the InHandCourseRegistrationAcitvity.
	 */
	@Override
	public double getDuration() {
		// TODO Auto-generated method stub
		return duration.getTime();
	}

	/**
	 * returns Effort of the InHandCourseRegistrationAcitvity.
	 */
	@Override
	public double getEffort() {
		// TODO Auto-generated method stub
		return effort.getEffort();
	}

	/**
	 * returns CarbonFootprint of the InHandCourseRegistrationAcitvity.
	 */
	@Override
	public double getCarbonFootprint() {
		// TODO Auto-generated method stub
		return carbonFootprints.getCarbonFootprints();
	}
}
