package genericDeser.util;

public class First
{

	int IntValue;
	float FloatValue;
	short shortValue;
	String StringValue;
	
	public First()
	{
		Logger.writeMessage ("In Constructor of First", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	public int getIntValue()
	{
		return IntValue;
	}
	
	public float getFloatValue()
	{
		return FloatValue;
	}
	
	public String getStringValue()
	{
		return StringValue;
	}
	
	public short getShortValue()
	{
		return shortValue;
	}

	public void setIntValue(int intValueIn)
	{
		IntValue = intValueIn;
	}

	public void setFloatValue(float floatValueIn)
	{
		FloatValue = floatValueIn;
	}

	public void setShortValue(short shortValueIn)
	{
		this.shortValue = shortValueIn;
	}

	public void setStringValue(String stringValueIn)
	{
		StringValue = stringValueIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(FloatValue);
		result = prime * result + IntValue;
		result = prime * result + ((StringValue == null) ? 0 : StringValue.hashCode());
		result = prime * result + shortValue;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		First other = (First) obj;
		if (Float.floatToIntBits(FloatValue) != Float.floatToIntBits(other.FloatValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		if (shortValue != other.shortValue)
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "First [IntValue=" + IntValue + ", FloatValue=" + FloatValue + ", shortValue=" + shortValue
				+ ", StringValue=" + StringValue + "]";
	}

}