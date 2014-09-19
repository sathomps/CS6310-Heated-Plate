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
        super(args);
    }

    public static void main(final String args[])
    {
        new Demo(new DiffusionArguments(args).with(new FloatWrapperConvertor())).execute();
    }

    @Override
    public Plate[] createPlates()
    {
        return new Plate[] { new FloatPlate(args), new FloatPlate(args) };
    }
}
