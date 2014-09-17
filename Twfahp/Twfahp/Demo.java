package Twfahp;

import common.DefaultDemo;
import common.DiffusionArguments;
import common.DiffusionConvertor;
import common.Plate;

public class Demo extends DefaultDemo
{
    public static void main(final String[] args)
    {
        final DiffusionConvertor convertor = new FloatDiffusionConvertor();
        final DiffusionArguments diffusionArgs = new DiffusionArguments(args);

        final Plate oldPlate = new Plate(diffusionArgs, convertor, new Float[diffusionArgs.getPlateDimensions()][diffusionArgs.getPlateDimensions()]);
        final Plate newPlate = new Plate(diffusionArgs, convertor, new Float[diffusionArgs.getPlateDimensions()][diffusionArgs.getPlateDimensions()]);

        execute(diffusionArgs, oldPlate, newPlate);
    }

}
