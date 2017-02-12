package studentOrientation.activity;

/**
 * This is an Activity interface which has methods needed 
 * to get the output of the whole Orientation in terms of Cost,
 * Duration, Effort, CarbonFootprint.
 */
public interface Activity {
	public double getCost();
	public double getDuration();
	public double getEffort();
	public double getCarbonFootprint();
}
