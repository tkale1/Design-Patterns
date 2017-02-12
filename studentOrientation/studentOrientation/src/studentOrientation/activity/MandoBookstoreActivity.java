package studentOrientation.activity;

import studentOrientation.expense.CarbonFootprintsInterface;
import studentOrientation.expense.Cost;
import studentOrientation.expense.Effort;
import studentOrientation.expense.Time;
import studentOrientation.util.Logger;

/**
 * The MandoBookstoreActivity Class which implements Activity.
 */
public class MandoBookstoreActivity implements Activity {
	private Cost cost;
	private double discount = 0.05;
	private Time duration;
	private Effort effort;
	private CarbonFootprintsInterface carbonFootprints;
	
	/**
	 * The constructor of the MandoBookstoreActivity take all instances 
	 * of all the activities as an argument. It then initializes 
	 * the arguments and set the value of each of the activities.
	 * NOTE: The setValue() takes hardcoded values.
	 */
	
	public MandoBookstoreActivity(Cost costIn, Time durationIn, Effort effortIn, CarbonFootprintsInterface carbonFootprintsIn) {
		// TODO Auto-generated constructor stub
		Logger.writeMessage ("In Constructor of MandoBookstoreActivity", Logger.DebugLevel.CONSTRUCTOR);

		cost = costIn;
		cost.setCost(getDiscountCost(400));
		duration = durationIn;
		duration.setTime(45);
		effort = effortIn;
		effort.setEffort(80);
		carbonFootprints = carbonFootprintsIn;
		carbonFootprints.setCarbonFootprints(0.1);
		Logger.writeMessage(
				"Values set for MandoBookstoreActivity(Cost, Time, Effort, carbonfootprints):"
						+ cost.getCost() + "," + duration.getTime() + ","
						+ effort.getEffort() + ","
						+ carbonFootprints.getCarbonFootprints(),
				Logger.DebugLevel.VALUESET);
	}
	
	/**
	 * returns total cost with Discount reduced of the MandoBookstoreActivity.
	 */
	private double getDiscountCost(double amount) {
		// TODO Auto-generated method stub
		return amount - amount * discount;
	}

	/**
	 * returns Cost of the MandoBookstoreActivity.
	 */
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return cost.getCost();
	}

	/**
	 * returns Duration of the MandoBookstoreActivity.
	 */
	@Override
	public double getDuration() {
		// TODO Auto-generated method stub
		return duration.getTime();
	}

	/**
	 * returns Effort of the MandoBookstoreActivity.
	 */
	@Override
	public double getEffort() {
		// TODO Auto-generated method stub
		return effort.getEffort();
	}

	/**
	 * returns CarbonFootprint of the MandoBookstoreActivity.
	 */
	@Override
	public double getCarbonFootprint() {
		// TODO Auto-generated method stub
		return carbonFootprints.getCarbonFootprints();
	}

}
