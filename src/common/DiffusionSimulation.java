package common;

public class DiffusionSimulation
{
    private final DiffusionArguments args;
    private final Plate              oldPlate;
    private final Plate              newPlate;
    private final int                ITERATIONS = 100;

    public DiffusionSimulation(final DiffusionArguments args, final Plate oldPlate, final Plate newPlate)
    {
        this.args = args;
        this.oldPlate = oldPlate;
        this.newPlate = newPlate;
    }

    public void calculate()
    {
        for (int iteration = 0; iteration < ITERATIONS; iteration++)
        {
            for (int row = 1; row <= args.getDimension(); row++)
            {
                for (int cell = 1; cell <= args.getDimension(); cell++)
                {
                    newPlate.calculateDiffusion(oldPlate, row, cell);
                }
            }
            // Swap the plates and continue
            swapPlates();
        }
    }

    public void display()
    {
        newPlate.display();
    }

    private void swapPlates()
    {
        oldPlate.swap(newPlate);
    }
}
