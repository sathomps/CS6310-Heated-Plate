package common;

public class Plate
{
    private final DiffusionConvertor convertor;
    private final DiffusionArguments args;
    private final Number[][]         internals;

    public Plate(final DiffusionArguments args)
    {
        this.args = args;
        this.convertor = args.getConvertor();
        this.internals = convertor.convert(args);
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
                    internals[row][cell] = convertor.convert(args.getTopTemp());
                }
                else if (row == (args.getPlateDimensions() - 1))
                {
                    internals[row][cell] = convertor.convert(args.getBottomTemp());
                }
                else if ((row > 0) && (row < args.getPlateDimensions()) && (cell == 0))
                {
                    internals[row][cell] = convertor.convert(args.getLeftTemp());
                }
                else if ((row > 0) && (row < args.getPlateDimensions()) && (cell == (args.getPlateDimensions() - 1)))
                {
                    internals[row][cell] = convertor.convert(args.getRightTemp());
                }
                else
                {
                    internals[row][cell] = convertor.convert(0);
                }
            }
        }
    }

    // XXX - REFACTOR - Move out to a calculation class
    public void calculateDiffusion(final Plate oldPlate, final int row, final int cell)
    {
        internals[row][cell] = convertor.convert(internals, row, cell);
    }

    public void display()
    {
        for (int row = 1; row < (args.getPlateDimensions() - 1); row++)
        {
            for (int cell = 1; cell < (args.getPlateDimensions() - 1); cell++)
            {
                System.out.print(convertor.convert(internals[row][cell]) + " ");
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
                internals[row][cell] = swapPlate.internals[row][cell];
            }
        }
    }
}
