package Twfahp;

import common.DiffusionConvertor;

public class FloatDiffusionConvertor implements DiffusionConvertor
{

    @Override
    public Number convert(final Number[][] internals, final int row, final int cell)
    {
        return (value(internals, row + 1, cell) + value(internals, row - 1, cell) + value(internals, row, cell + 1) + (value(internals, row, cell - 1) / 4));
    }

    @Override
    public Float convert(final Number number)
    {
        return Float.valueOf(number.floatValue());
    }

    private Float value(final Number[][] internals, final int row, final int cell)
    {
        final Float conversion = convert(internals[row][cell]);
        if (conversion.isInfinite())
        {
            System.out.println(String.format("row cell {} {}", row, cell));
        }
        return conversion;
    }

}
