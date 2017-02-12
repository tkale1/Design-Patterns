package studentOrientation.expense;

/**
 * This is a Dollar class which implements Cost interface.
 * It has units in terms of Dollars.
 */
public class Dollar implements Cost {
	double value;
	String currency = "dollars";
	
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void setCost(double cost) {
		// TODO Auto-generated method stub
		value = cost;
	}
	
	public String getCurrency(){
		return currency;
	}

	@Override
	public String getUnit() {
		// TODO Auto-generated method stub
		return currency;
	}

}
