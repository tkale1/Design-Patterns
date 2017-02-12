package studentOrientation.activity;

import studentOrientation.util.Logger;
import studentOrientation.expense.CarbonFootprintsInterface;
import studentOrientation.expense.Cost;
import studentOrientation.expense.Effort;
import studentOrientation.expense.Time;

/**
 * The BusTourAcitivity Class which implements Activity.
 */
public class BusTourActivity implements Activity {

	private Cost cost;
	private Time duration;
	private Effort effort;
	private CarbonFootprintsInterface carbonFootprints;

	/**
	 * The constructor of the BusTourActivity take all instances of all the
	 * activities as an argument. It then initializes the arguments and set the
	 * value of each of the activities. NOTE: The setValue() takes hard-coded
	 * values.
	 */
	public BusTourActivity(Cost costIn, Time durationIn, Effort effortIn,
			CarbonFootprintsInterface carbonFootprintsIn) {
		// TODO Auto-generated constructor stub
		Logger.writeMessage("In Constructor of BusTourActivity",
				Logger.DebugLevel.CONSTRUCTOR);
		cost = costIn;
		cost.setCost(2);
		duration = durationIn;
		duration.setTime(20);
		effort = effortIn;
		effort.setEffort(40);
		carbonFootprints = carbonFootprintsIn;
		carbonFootprints.setCarbonFootprints(0.2);
		Logger.writeMessage(
				"Values set for BusTourActivity(Cost, Time, Effort, carbonfootprints):"
						+ cost.getCost() + "," + duration.getTime() + ","
						+ effort.getEffort() + ","
						+ carbonFootprints.getCarbonFootprints(),
				Logger.DebugLevel.VALUESET);
	}

	/**
	 * returns Cost of the BusTourAcitvity.
	 */
	public double getCost() {
		// TODO Auto-generated method stub
		return cost.getCost();
	}

	/**
	 * returns duration of the BusTourAcitvity.
	 */
	@Override
	public double getDuration() {
		// TODO Auto-generated method stub
		return duration.getTime();
	}

	/**
	 * returns Efforts of the BusTourAcitvity.
	 */
	@Override
	public double getEffort() {
		// TODO Auto-generated method stub
		return effort.getEffort();
	}

	/**
	 * returns CarbonFootPrint of the BusTourAcitvity.
	 */
	@Override
	public double getCarbonFootprint() {
		// TODO Auto-generated method stub
		return carbonFootprints.getCarbonFootprints();
	}
}
