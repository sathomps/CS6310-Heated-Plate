package common.number;

import common.AbstractPlate;
import common.DiffusionArguments;
import common.Plate;

public class DoublePlate extends AbstractPlate
{
    private final double[][] grid;

    public DoublePlate(final DiffusionArguments args)
    {
        super(args);

        this.grid = new double[args.getPlateDimensions()][args.getPlateDimensions()];
        initialize();
    }

    @Override
    public void initialize()
    {
        for (int row = 0; row < args.getPlateDimensions(); row++)
        {
            for (int cell = 0; cell < args.getPlateDimensions(); cell++)
            {
                if (row == 0)
                {
                    grid[row][cell] = args.getTopTemp().doubleValue();
                }
                else if (row == (args.getPlateDimensions() - 1))
                {
                    grid[row][cell] = args.getBottomTemp().doubleValue();
                }
                else if (cell == 0)
                {
                    grid[row][cell] = args.getLeftTemp().doubleValue();
                }
                else if (cell == (args.getPlateDimensions() - 1))
                {
                    grid[row][cell] = args.getRightTemp().doubleValue();
                }
                else
                {
                    grid[row][cell] = 0;
                }
            }
        }
    }

    @Override
    public void calculateDiffusion(final Plate oldPlate, final int row, final int cell)
    {
        grid[row][cell] = calc.calculate(oldPlate, row, cell).doubleValue();
    }

    @Override
    public Number getTemp(final int row, final int cell)
    {
        return grid[row][cell];
    }

    @Override
    public void swap(final Plate swapPlate)
    {
        for (int row = 0; row < args.getPlateDimensions(); row++)
        {
            for (int cell = 0; cell < args.getPlateDimensions(); cell++)
            {
                grid[row][cell] = swapPlate.getTemp(row, cell).doubleValue();
            }
        }
    }
}
