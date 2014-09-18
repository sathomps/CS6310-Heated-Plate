package Gallhp;

import common.DefaultDemo;
import common.DiffusionArguments;
import common.Plate;

public class Demo extends DefaultDemo
{
    public static void main(final String args[])
    {

        final DiffusionArguments diffArgs = new DiffusionArguments(args);
        diffArgs.setConvertor(new FloatDiffusionConvertor());

        final Plate oldPlate = new Plate(diffArgs);
        final Plate newPlate = new Plate(diffArgs);

        execute(diffArgs, oldPlate, newPlate);
    }
}
