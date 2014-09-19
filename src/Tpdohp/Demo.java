package Tpdohp;

import common.AbstractDemo;
import common.DiffusionArguments;
import common.Plate;
import common.number.DoubleWrapperConvertor;
import common.rowCell.RowCellPlate;

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
        return new Plate[] { new RowCellPlate(args), new RowCellPlate(args) };
    }
}
