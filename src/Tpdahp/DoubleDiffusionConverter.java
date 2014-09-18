package Tpdahp;


public class DoubleDiffusionConverter implements DiffusionConverter{
	
	private DoublePlate _newPlate;
	private DoublePlate _oldPlate;
	private static final int NUMBER_OF_ITERATIONS = 100;
	
	// Parameterized Constructor
	public DoubleDiffusionConverter(DiffusionData diffusionData)
	{
		_newPlate = new DoublePlate(diffusionData);
		_oldPlate = new DoublePlate(diffusionData);
	}
	
	// Compute diffusion data
	@Override
	public void ComputeDiffusion()
	{
		for(int iterationCount = 0; iterationCount < NUMBER_OF_ITERATIONS; iterationCount++)
		{
			double [][] oldPlateArray = _oldPlate.getPlateTemperatureDataArray();
			double [][] newPlateArray = _newPlate.getPlateTemperatureDataArray();
			
			for (int rowCount = 1; rowCount <= _newPlate._plateDimension; rowCount++) 
			{
				for (int columnCount = 1; columnCount <= _newPlate._plateDimension; columnCount++)
				{
					newPlateArray[rowCount][columnCount] = (double)
							((oldPlateArray[rowCount + 1][columnCount] + oldPlateArray[rowCount - 1][columnCount] + 
							 oldPlateArray[rowCount][columnCount + 1] + oldPlateArray[rowCount][columnCount - 1]) / 4.0);
				}
			}
			Swap();
		}
	}
	
	// Swaps the plate temperature values
	public void Swap()
	{
		double[][] source = _newPlate.getPlateTemperatureDataArray();
		double [][] destination = _oldPlate.getPlateTemperatureDataArray();
		int dimension = _newPlate._plateDimension;
		for (int rowCount = 0; rowCount < dimension + 2; rowCount++)
		{
			for (int columnCount = 0; columnCount < dimension + 2; columnCount++)
			{
				// Swapping values with out using the third variable
				// x = x + y
				// y = x - y;
				// x = x - y
				source[rowCount][columnCount] = source[rowCount][columnCount] + destination[rowCount][columnCount];
				destination[rowCount][columnCount] = source[rowCount][columnCount] - destination[rowCount][columnCount];
				source[rowCount][columnCount] = source[rowCount][columnCount] - destination[rowCount][columnCount];
			}
		}
	}
	
	// Display diffusion data
	public void DisplayDiffusionData()
	{
		System.out.println("Heat Simulation of a plate using a " + _newPlate._diffusionData.getLinearDimension() + "x" +  _newPlate._diffusionData.getLinearDimension() + " grid, with initial edge temperatures (top, bottom,left, right) of " +
				_newPlate._diffusionData.getTopEdgeTemperature() + ", " + _newPlate._diffusionData.getBottomEdgeTemperature() + ", " +
				_newPlate._diffusionData.getLeftEdgeTemperature() + ", " + _newPlate._diffusionData.getRightEdgeTemperature());
		System.out.println("and precision upto " +  _newPlate._diffusionData.getDecimalPrecision() + " decimal places, the resulting temperatures are the following:"); 
		System.out.println(); 
		_newPlate.Display();
	}
}
