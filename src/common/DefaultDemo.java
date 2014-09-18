package common;

public abstract class DefaultDemo
{
    protected static void execute(final String[] args, final NumberConvertor convertor)
    {
        final DiffusionArguments diffArgs = new DiffusionArguments(args);
        diffArgs.setConvertor(convertor);

        final Plate oldPlate = new Plate(diffArgs);
        final Plate newPlate = new Plate(diffArgs);

        final DiffusionSimulation simulation = new DiffusionSimulation(diffArgs, oldPlate, newPlate);

        simulation.calculate();
        simulation.display();
    }
}
