package common.number;

import common.AbstractPlate;
import common.DiffusionArguments;
import common.Plate;

public class WrapperPlate extends AbstractPlate
{
    private final Number[][] grid;

    public WrapperPlate(final DiffusionArguments args)
    {
        super(args);
        this.grid = convertor.convert(args);
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
                    grid[row][cell] = convertor.convert(args.getTopTemp());
                }
                else if (row == (args.getPlateDimensions() - 1))
                {
                    grid[row][cell] = convertor.convert(args.getBottomTemp());
                }
                else if (cell == 0)
                {
                    grid[row][cell] = convertor.convert(args.getLeftTemp());
                }
                else if (cell == (args.getPlateDimensions() - 1))
                {
                    grid[row][cell] = convertor.convert(args.getRightTemp());
                }
                else
                {
                    grid[row][cell] = convertor.convert(0);
                }
            }
        }
    }

    @Override
    public void calculateDiffusion(final Plate oldPlate, final int row, final int cell)
    {
        grid[row][cell] = calc.calculate(oldPlate, row, cell);
    }

    @Override
    public void display()
    {
        for (int row = 1; row < (args.getPlateDimensions() - 1); row++)
        {
            for (int cell = 1; cell < (args.getPlateDimensions() - 1); cell++)
            {
                System.out.print(convertor.convertForDisplay(getTemp(row, cell), args.getPrecision()) + "  ");
            }
            System.out.println();
        }
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
                grid[row][cell] = swapPlate.getTemp(row, cell);
            }
        }
    }
}
