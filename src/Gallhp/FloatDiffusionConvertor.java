package Gallhp;

import common.DiffusionArguments;
import common.DiffusionConvertor;

public class FloatDiffusionConvertor implements DiffusionConvertor
{
    @Override
    public Number convert(final Number[][] internals, final int row, final int cell)
    {
        return add(internals, row, cell) / 4;
    }

    private Float add(final Number[][] internals, final int row, final int cell)
    {
        return value(internals, row + 1, cell) + value(internals, row - 1, cell) + value(internals, row, cell + 1) + value(internals, row, cell - 1);
    }

    @Override
    public Float convert(final Number number)
    {
        return Float.valueOf(number.floatValue());
    }

    private Float value(final Number[][] internals, final int row, final int cell)
    {
        return convert(internals[row][cell]);
    }

    @Override
    public Number[][] convert(final DiffusionArguments args)
    {
        return new Float[args.getPlateDimensions()][args.getPlateDimensions()];
    }

}
