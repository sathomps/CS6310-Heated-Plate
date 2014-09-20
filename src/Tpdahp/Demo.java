package Tpdahp;

import common.AbstractDemo;
import common.DiffusionArguments;
import common.Plate;
import common.number.DoublePlate;
import common.number.DoubleWrapperConvertor;

public class Demo extends AbstractDemo
{
    public Demo(final DiffusionArguments args)
    {
        super(args.with(new DoubleWrapperConvertor()));
    }

    public static void main(final String args[])
    {
        new Demo(new DiffusionArguments(args)).execute();
    }

    @Override
    public Plate[] createPlates()
    {
        return new Plate[] { new DoublePlate(args), new DoublePlate(args) };
    }
}
