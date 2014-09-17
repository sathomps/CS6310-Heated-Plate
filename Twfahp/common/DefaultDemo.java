package common;

public abstract class DefaultDemo
{
    protected static void execute(final DiffusionArguments args, final Plate oldPlate, final Plate newPlate)
    {
        final DiffusionComputation comp = new DiffusionComputation(args, oldPlate, newPlate);

        comp.calculate();
        comp.display();
    }
}
