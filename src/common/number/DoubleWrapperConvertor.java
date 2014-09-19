package common.number;

import common.DiffusionArguments;

public class DoubleWrapperConvertor implements NumberConvertor
{

    @Override
    public Double convert(final Number number)
    {
        return Double.valueOf(number.doubleValue());
    }

    @Override
    public Number[][] convert(final DiffusionArguments args)
    {
        return new Double[args.getPlateDimensions()][args.getPlateDimensions()];
    }

    @Override
    public String convertForDisplay(final Number number, final int precision)
    {
        return String.format("%." + precision + "f", number);
    }

    @Override
    public Number add(final Number... numbers)
    {
        Double total = Double.valueOf(0);
        for (final Number number : numbers)
        {
            total += (Double) number;
        }
        return total;
    }

    @Override
    public Number divide(final Number add, final int i)
    {
        return (Double) add / 4;
    }

}
