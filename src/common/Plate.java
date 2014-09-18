package common;

public class Plate
{
    private final DiffusionCalculation calc;
    private final NumberConvertor      convertor;
    private final DiffusionArguments   args;
    private final Number[][]           grid;

    public Plate(final DiffusionArguments args)
    {
        this.args = args;
        this.convertor = args.getConvertor();
        this.grid = convertor.convert(args);
        calc = new DiffusionCalculation(convertor);
        initialize();
    }

    // XXX - Refactor
    private void initialize()
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

    public void calculateDiffusion(final Plate oldPlate, final int row, final int cell)
    {
        grid[row][cell] = calc.calculate(grid, row, cell);
    }

    public void display()
    {
        for (int row = 1; row < (args.getPlateDimensions() - 1); row++)
        {
            for (int cell = 1; cell < (args.getPlateDimensions() - 1); cell++)
            {
                System.out.print(convertor.convertForDisplay(grid[row][cell], args.getPrecision()) + "  ");
            }
            System.out.println();
        }
    }

    public void swap(final Plate swapPlate)
    {
        for (int row = 0; row < args.getPlateDimensions(); row++)
        {
            for (int cell = 0; cell < args.getPlateDimensions(); cell++)
            {
                grid[row][cell] = swapPlate.grid[row][cell];
            }
        }
    }
}
