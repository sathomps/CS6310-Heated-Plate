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
                new DiffusionUI();
            }
        });
    }
}
