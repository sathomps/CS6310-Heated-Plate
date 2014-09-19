package common.number;

import common.DiffusionArguments;

public class FloatWrapperConvertor implements NumberConvertor
{

    @Override
    public Float convert(final Number number)
    {
        return Float.valueOf(number.floatValue());
    }

    @Override
    public Number[][] convert(final DiffusionArguments args)
    {
        return new Float[args.getPlateDimensions()][args.getPlateDimensions()];
    }

    @Override
    public String convertForDisplay(final Number number, final int precision)
    {
        return String.format("%." + precision + "f", number);
    }

    @Override
    public Number add(final Number... numbers)
    {
        Float total = Float.valueOf(0);
        for (final Number number : numbers)
        {
            total += (Float) number;
        }
        return total;
    }

    @Override
    public Number divide(final Number add, final int i)
    {
        return (Float) add / 4;
    }

}
