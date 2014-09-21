package Tpfahp;

import common.AbstractDemo;
import common.DiffusionArguments;
import common.number.FloatPlate;
import common.number.FloatWrapperConvertor;

public class Demo extends AbstractDemo
{
    public Demo(final DiffusionArguments diffusionArgs)
    {
        super(diffusionArgs.with(new FloatWrapperConvertor()));
    }

    public static void main(final String args[])
    {
        new Demo(new DiffusionArguments(args)).execute();
    }

    @Override
    public FloatPlate[] createPlates()
    {
        return new FloatPlate[] { new FloatPlate(diffusionArgs), new FloatPlate(diffusionArgs) };
    }
}
