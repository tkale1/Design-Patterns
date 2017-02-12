package studentOrientation.activity;

import studentOrientation.expense.CarbonFootprintsInterface;
import studentOrientation.expense.Cost;
import studentOrientation.expense.Effort;
import studentOrientation.expense.Time;
import studentOrientation.util.Logger;

/**
 * The GamingDormSelectionActivity Class which implements Activity.
 */
public class GamingDormSelectionActivity implements Activity{
	
	private Cost cost;
	private Time duration;
	private Effort effort;
	private CarbonFootprintsInterface carbonFootprints;
	
	/**
	 * The constructor of the GamingDormSelectionActivity take all instances 
	 * of all the activities as an argument. It then initializes 
	 * the arguments and set the value of each of the activities.
	 * NOTE: The setValue() takes hardcoded values.
	 */
	public GamingDormSelectionActivity(Cost costIn, Time durationIn, Effort effortIn, CarbonFootprintsInterface carbonFootprintsIn) {
		// TODO Auto-generated constructor stub
		Logger.writeMessage ("In Constructor of GamingDormSelectionActivity", Logger.DebugLevel.CONSTRUCTOR);
		cost = costIn;
		cost.setCost(getSurchargedValue(1200));
		duration = durationIn;
		duration.setTime(20);
		effort = effortIn;
		effort.setEffort(80);
		carbonFootprints = carbonFootprintsIn;
		carbonFootprints.setCarbonFootprints(0.17);
		Logger.writeMessage(
				"Values set for GamingDormSelectionActivity(Cost, Time, Effort, carbonfootprints):"
						+ cost.getCost() + "," + duration.getTime() + ","
						+ effort.getEffort() + ","
						+ carbonFootprints.getCarbonFootprints(),
				Logger.DebugLevel.VALUESET);
	}
	
	/**
	 * returns Additional Surcharge to the cost.
	 */
	private double getSurchargedValue(double amount) {
		// TODO Auto-generated method stub
		return amount + 0.02 * amount;
	}

	/**
	 * returns Cost of the GamingDormSelectionActivity.
	 */
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return cost.getCost();
	}

	/**
	 * returns Duration of the GamingDormSelectionActivity.
	 */
	@Override
	public double getDuration() {
		// TODO Auto-generated method stub
		return duration.getTime();
	}

	/**
	 * returns Effort of the GamingDormSelectionActivity.
	 */
	@Override
	public double getEffort() {
		// TODO Auto-generated method stub
		return effort.getEffort();
	}

	/**
	 * returns CarbonFootPrint of the GamingDormSelectionActivity.
	 */
	@Override
	public double getCarbonFootprint() {
		// TODO Auto-generated method stub
		return carbonFootprints.getCarbonFootprints();
	}

}
