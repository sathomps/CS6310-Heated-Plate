package Twfahp;

import common.AbstractDemo;
import common.DiffusionArguments;
import common.number.FloatWrapperConvertor;
import common.number.WrapperPlate;

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
    public WrapperPlate[] createPlates()
    {
        return new WrapperPlate[] { new WrapperPlate(diffusionArgs), new WrapperPlate(diffusionArgs) };
    }
}
