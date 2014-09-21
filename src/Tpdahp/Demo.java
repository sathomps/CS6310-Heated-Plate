package Tpdahp;

import common.AbstractDemo;
import common.DiffusionArguments;
import common.number.DoublePlate;
import common.number.DoubleWrapperConvertor;

public class Demo extends AbstractDemo
{
    public Demo(final DiffusionArguments diffusionArgs)
    {
        super(diffusionArgs.with(new DoubleWrapperConvertor()));
    }

    public static void main(final String args[])
    {
        new Demo(new DiffusionArguments(args)).execute();
    }

    @Override
    public DoublePlate[] createPlates()
    {
        return new DoublePlate[] { new DoublePlate(diffusionArgs), new DoublePlate(diffusionArgs) };
    }
}
