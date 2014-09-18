package Tpfahp;

public abstract class Plate {
	protected int _plateDimension;
	protected DiffusionData _diffusionData;
	
	// Initialize plate temperature from the diffusion data
	abstract protected void InitializePlateTemperature();
	
	// Displays the plate temperature
	abstract public void Display();

}
