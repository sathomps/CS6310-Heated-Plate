package Tpfahp;

import common.AbstractDemo;
import common.DiffusionArguments;
import common.Plate;
import common.number.FloatPlate;
import common.number.FloatWrapperConvertor;

public class Demo extends AbstractDemo
{
    public Demo(final DiffusionArguments args)
    {
        super(args.with(new FloatWrapperConvertor()));
    }

    public static void main(final String args[])
    {
        new Demo(new DiffusionArguments(args)).execute();
    }

    @Override
    public Plate[] createPlates()
    {
        return new Plate[] { new FloatPlate(args), new FloatPlate(args) };
    }
}
