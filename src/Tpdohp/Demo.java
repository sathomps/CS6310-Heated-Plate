package Tpdohp;

import common.AbstractDemo;
import common.DiffusionArguments;
import common.Plate;
import common.number.DoubleWrapperConvertor;
import common.rowCell.RowCellPlate;

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
    public RowCellPlate[] createPlates()
    {
        return new RowCellPlate[] { new RowCellPlate(diffusionArgs), new RowCellPlate(diffusionArgs) };
    }
}
