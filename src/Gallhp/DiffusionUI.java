package Gallhp;

import static Gallhp.DiffusionUIPanel.BORDER_SIZE;
import static Gallhp.DiffusionUIPanel.WINDOW_SIZE;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import common.number.FloatWrapperConvertor;
import common.number.NumberConvertor;

public class DiffusionUI extends JFrame
{
    private static final long           serialVersionUID = 1L;

    private final List<NumberConvertor> convertors       = new ArrayList<NumberConvertor>();

    public DiffusionUI()
    {
        init();
    }

    private void init()
    {
        addMenuBar();
        addPanel();

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addMenuBar()
    {
        final JMenuBar menubar = new JMenuBar();

        setJMenuBar(menubar);

        setTitle("Diffusion Simulator");

        gatherConvertors();
    }

    private void addPanel()
    {
        add(new DiffusionUIPanel(BORDER_SIZE, BORDER_SIZE, WINDOW_SIZE, WINDOW_SIZE));
    }

    /**
     * XXX - Would rather use something like this pattern here.
     * http://metainf-services.kohsuke.org/
     */
    private void gatherConvertors()
    {
        convertors.add(new FloatWrapperConvertor());
    }
}
