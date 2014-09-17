package common;

public class DiffusionComputation
{
    protected final DiffusionArguments args;
    protected Plate                    oldPlate;
    protected Plate                    newPlate;
    private final int                  ITERATIONS = 100;

    public DiffusionComputation(final DiffusionArguments args, final Plate oldPlate, final Plate newPlate)
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
