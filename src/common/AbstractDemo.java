package common;

public abstract class AbstractDemo
{
    protected final DiffusionArguments diffusionArgs;

    public AbstractDemo(final DiffusionArguments args)
    {
        this.diffusionArgs = args;
    }

    
    /**
	 * @return the diffusionArgs
	 */
	public DiffusionArguments getDiffusionArgs() {
		return diffusionArgs;
	}


	public void execute()
    {
        final Plate[] plates = createPlates();

        final DiffusionSimulation simulation = 
        		new DiffusionSimulation(diffusionArgs, plates[0], plates[1]);

        simulation.calculate();
        simulation.display();
    }

    public abstract Plate[] createPlates();
}
