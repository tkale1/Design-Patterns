package studentOrientation.activity;

import studentOrientation.expense.CarbonFootprintsInterface;
import studentOrientation.expense.Cost;
import studentOrientation.expense.Effort;
import studentOrientation.expense.Time;
import studentOrientation.util.Logger;

/**
 * The UniversityBookStore Class which implements Activity.
 */
public class UniversityBookStore implements Activity {
	private Cost cost;
	private double discount = 0;
	private Time duration;
	private Effort effort;
	private CarbonFootprintsInterface carbonFootprints;

	/**
	 * The constructor of the UniversityBookStore take all instances 
	 * of all the activities as an argument. It then initializes 
	 * the arguments and set the value of each of the activities.
	 * NOTE: The setValue() takes hardcoded values.
	 */
	public UniversityBookStore(Cost costIn, Time durationIn, Effort effortIn, CarbonFootprintsInterface carbonFootprintsIn) {
		// TODO Auto-generated constructor stub
	
		Logger.writeMessage ("In Constructor of UniversityBookStore", Logger.DebugLevel.CONSTRUCTOR);
		cost = costIn;
		cost.setCost(getDiscountCost(400));
		duration = durationIn;
		duration.setTime(30);
		effort = effortIn;
		effort.setEffort(40);
		carbonFootprints = carbonFootprintsIn;
		carbonFootprints.setCarbonFootprints(0.05);
		Logger.writeMessage(
				"Values set for UniversityBookStore(Cost, Time, Effort, carbonfootprints):"
						+ cost.getCost() + "," + duration.getTime() + ","
						+ effort.getEffort() + ","
						+ carbonFootprints.getCarbonFootprints(),
				Logger.DebugLevel.VALUESET);
	}

	/**
	 * returns Discount amount of the UniversityBookStore.
	 */
	private double getDiscountCost(double amount) {
		// TODO Auto-generated method stub
		return amount - amount * discount;
	}

	/**
	 * returns Cost of the UniversityBookStore.
	 */
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return cost.getCost();
	}

	/**
	 * returns Duration of the UniversityBookStore.
	 */
	@Override
	public double getDuration() {
		// TODO Auto-generated method stub
		return duration.getTime();
	}

	/**
	 * returns Effort of the UniversityBookStore.
	 */
	@Override
	public double getEffort() {
		// TODO Auto-generated method stub
		return effort.getEffort();
	}

	/**
	 * returns CarbonFootprint of the UniversityBookStore.
	 */
	@Override
	public double getCarbonFootprint() {
		// TODO Auto-generated method stub
		return carbonFootprints.getCarbonFootprints();
	}
}
