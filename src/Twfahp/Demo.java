package Twfahp;

import common.AbstractDemo;
import common.DiffusionArguments;
import common.Plate;
import common.number.FloatWrapperConvertor;
import common.number.WrapperPlate;

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
        return new Plate[] { new WrapperPlate(args), new WrapperPlate(args) };
    }
}
