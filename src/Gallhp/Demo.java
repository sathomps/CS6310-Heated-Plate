package Gallhp;

import javax.swing.SwingUtilities;

public class Demo
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
