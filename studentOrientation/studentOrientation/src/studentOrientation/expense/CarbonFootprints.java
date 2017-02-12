package studentOrientation.expense;

/**
 * This is a CarbonFootprints class which implements CarbonFootprintsInterface.
 */
public class CarbonFootprints implements CarbonFootprintsInterface {
	double value;
	String units = "tonnes of CO2";
	
	@Override
	public double getCarbonFootprints() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void setCarbonFootprints(double carbonFootprintsIn) {
		// TODO Auto-generated method stub
		value = carbonFootprintsIn;
	}
	
	public String getUnits(){
		return units;
	}

	@Override
	public String getUnit() {
		// TODO Auto-generated method stub
		return units;
	}

}
