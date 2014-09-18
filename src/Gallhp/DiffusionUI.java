package Gallhp;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class DiffusionUI extends JFrame
{
    private static final long serialVersionUID = 1L;

    public DiffusionUI()
    {
        init();
    }

    private void init()
    {
        final JMenuBar menubar = new JMenuBar();

        setJMenuBar(menubar);

        setTitle("Diffusion Simulator");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
