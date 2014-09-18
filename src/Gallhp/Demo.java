package Gallhp;

import javax.swing.SwingUtilities;

import common.DefaultDemo;

public class Demo extends DefaultDemo
{
    public static void main(final String args[])
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                final DiffusionUI ui = new DiffusionUI();
                ui.setVisible(true);
            }
        });

        /*
         * final DiffusionArguments diffArgs = new DiffusionArguments(args);
         * diffArgs.setConvertor(new FloatDiffusionConvertor());
         * 
         * final Plate oldPlate = new Plate(diffArgs); final Plate newPlate =
         * new Plate(diffArgs);
         * 
         * execute(diffArgs, oldPlate, newPlate);
         */
    }
}
