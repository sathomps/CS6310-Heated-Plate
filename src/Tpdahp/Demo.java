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
        super(args);
    }

    public static void main(final String args[])
    {
        new Demo(new DiffusionArguments(args).with(new DoubleWrapperConvertor())).execute();
    }

    @Override
    public Plate[] createPlates()
    {
        return new Plate[] { new DoublePlate(args), new DoublePlate(args) };
    }
}
