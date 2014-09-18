package Gallhp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import common.DiffusionConvertor;

public class DiffusionUI extends JFrame
{
    private static final long              serialVersionUID = 1L;

    private final List<DiffusionConvertor> convertors       = new ArrayList<DiffusionConvertor>();

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

        gatherConvertors();
    }

    private void gatherConvertors()
    {
        convertors.add(new FloatDiffusionConvertor());
    }
}
