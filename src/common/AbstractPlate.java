package common;

import common.number.NumberConvertor;

public abstract class AbstractPlate implements Plate
{
    protected final DiffusionCalculation calc;
    protected final NumberConvertor      convertor;
    protected final DiffusionArguments   args;

    public AbstractPlate(final DiffusionArguments args)
    {
        this.args = args;
        this.convertor = args.getConvertor();
        calc = new DiffusionCalculation(convertor);
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
}
