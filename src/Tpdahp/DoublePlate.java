package Tpdahp;

public class DoublePlate extends Plate {
	private double[][] _plateTemperatureDataArray;
	
	// Parameterized Constructor
	public DoublePlate(DiffusionData diffusionData)
	{
		_diffusionData = diffusionData;
		_plateDimension = diffusionData.getLinearDimension();
		_plateTemperatureDataArray = 
				new double [_plateDimension + 2] [_plateDimension + 2];
		
		InitializePlateTemperature();
	}
	
	// Get method for plate temperature data array
	public double [][] getPlateTemperatureDataArray()
	{
		return _plateTemperatureDataArray;
	}
	
	// Initialize plate temperature from the diffusion data
	@Override
	protected void InitializePlateTemperature()
	{
		for (int rowCount = 0; rowCount < _plateDimension + 2; rowCount++)
		{
			for (int columnCount = 0; columnCount < _plateDimension + 2; columnCount++)
			{
				
				if (rowCount == 0)
				{
					_plateTemperatureDataArray[0][columnCount] = _diffusionData.getTopEdgeTemperature();
				}
				else if (rowCount == _plateDimension + 1)
				{
					_plateTemperatureDataArray[_plateDimension + 1][columnCount] = _diffusionData.getBottomEdgeTemperature();
				}
				else if (columnCount == 0)
				{
					_plateTemperatureDataArray[rowCount][0] = _diffusionData.getLeftEdgeTemperature();
				}
				else if (columnCount == _plateDimension + 1)
				{
					_plateTemperatureDataArray[rowCount][_plateDimension + 1] = _diffusionData.getRightEdgeTemperature();
				}
				else
				{
					_plateTemperatureDataArray[rowCount][columnCount] = 0;
				}
			}
		}
		
	}
	
	// Displays the plate temperature
	@Override
	public void Display()
	{
		for (int rowCount = 1; rowCount < _plateDimension + 1; rowCount++) 
		{ 
			for (int cellCount = 1; cellCount < _plateDimension + 1; cellCount++) 
			{ 
				System.out.print(String.format("%." + _diffusionData.getDecimalPrecision() + "f", _plateTemperatureDataArray[rowCount][cellCount]) + "		"); 
			} 
			
			System.out.println(); 
		} 
	}
}
