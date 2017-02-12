package genericDeser.util;

public class Second
{
	int IntValue;
	double DoubleValue;
	boolean BooleanValue;
	
	public Second()
	{
		Logger.writeMessage ("In Constructor of Second", Logger.DebugLevel.CONSTRUCTOR);
	}

	public int getIntValue()
	{
		return IntValue;
	}
	
	public Double getDoubleValue()
	{
		return DoubleValue;
	}
	
	public Boolean getBooleanValue()
	{
		return BooleanValue;
	}

	public void setIntValue(int intValueIn)
	{
		IntValue = intValueIn;
	}

	public void setDoubleValue(Double doubleValueIn)
	{
		DoubleValue = doubleValueIn;
	}
	
	public void setBooleanValue(Boolean booleanValueIn)
	{
		BooleanValue = booleanValueIn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (BooleanValue ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(DoubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + IntValue;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Second other = (Second) obj;
		if (BooleanValue != other.BooleanValue) {
			return false;
		}
		if (Double.doubleToLongBits(DoubleValue) != Double.doubleToLongBits(other.DoubleValue)) {
			return false;
		}
		if (IntValue != other.IntValue) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Second [IntValue=" + IntValue + ", DoubleValue=" + DoubleValue + ", BooleanValue=" + BooleanValue + "]";
	}

	
}
