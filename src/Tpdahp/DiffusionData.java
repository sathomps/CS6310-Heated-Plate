package Tpdahp;

public class DiffusionData {
	
	private int _linearDimension;
	private int _leftEdgeTemperature;
	private int _rightEdgeTemperature;
	private int _topEdgeTemperature;
	private int _bottomEdgeTemperature;
	// default precision is 2
	private int _decimalPrecision = 2;
	
	public DiffusionData()
	{
		
	}
	
	public DiffusionData(int dimension, int leftTemp, int rightTemp, int topTemp, int bottomTemp)
	{
		_linearDimension = dimension;
		_leftEdgeTemperature = leftTemp;
		_rightEdgeTemperature = rightTemp;
		_topEdgeTemperature = topTemp;
		_bottomEdgeTemperature = bottomTemp;
	}
	
	public int getLinearDimension()
	{
		return _linearDimension;
	}
	
	public int getLeftEdgeTemperature()
	{
		return _leftEdgeTemperature;
	}
	
	public int getRightEdgeTemperature()
	{
		return _rightEdgeTemperature;
	}
	
	public int getTopEdgeTemperature()
	{
		return _topEdgeTemperature;
	}
	
	public int getBottomEdgeTemperature()
	{
		return _bottomEdgeTemperature;
	}
	
	public int getDecimalPrecision()
	{
		return _decimalPrecision;
	}
	
	public void setDecimalPrecision(int precision)
	{
		 _decimalPrecision = precision;
	}
}
