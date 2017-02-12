package studentOrientation.expense;

/**
 * This is a DurationMins class which implements Time interface.
 * It has units in terms of Minutes.
 */
public class DurationMins implements Time {
	double duration;
	String units = "minutes";
	@Override
	public double getTime() {
		// TODO Auto-generated method stub
		return duration;
	}

	@Override
	public void setTime(double time) {
		// TODO Auto-generated method stub
		duration = time;
	}
	
	public String getUnits() {
		return units;
	}

	@Override
	public String getUnit() {
		// TODO Auto-generated method stub
		return units;
	}

}
