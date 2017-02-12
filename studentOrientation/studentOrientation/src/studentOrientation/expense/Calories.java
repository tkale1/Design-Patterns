package studentOrientation.expense;

/**
 * This is a Calorie class which implements Effort interface.
 * It has units in terms of Calories.
 */
public class Calories implements Effort {
	double value;
	String units = "calories";
	@Override
	public double getEffort() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void setEffort(double effort) {
		// TODO Auto-generated method stub
		value = effort;
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
