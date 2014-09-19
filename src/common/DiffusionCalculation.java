package common;

import common.number.NumberConvertor;

public class DiffusionCalculation
{
    private final NumberConvertor convertor;

    public DiffusionCalculation(final NumberConvertor convertor)
    {
        this.convertor = convertor;
    }

    public Number calculate(final Plate plate, final int row, final int cell)
    {
        return convertor.divide(add(plate, row, cell), 4);
    }

    private Number add(final Plate plate, final int row, final int cell)
    {
        return convertor.add(plate.getTemp(row + 1, cell), plate.getTemp(row - 1, cell), plate.getTemp(row, cell + 1), plate.getTemp(row, cell - 1));
    }
}
