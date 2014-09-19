package common;

public abstract class AbstractDemo
{
    protected final DiffusionArguments args;

    public AbstractDemo(final DiffusionArguments args)
    {
        this.args = args;
    }

    public void execute()
    {
        final Plate[] plates = createPlates();

        final DiffusionSimulation simulation = new DiffusionSimulation(args, plates[0], plates[1]);

        simulation.calculate();
        simulation.display();
    }

    public abstract Plate[] createPlates();
}
