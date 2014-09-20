package Gallhp;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

class DiffusionUIPanel extends JPanel
{
    private static final long serialVersionUID = 1L;

    private final static int  WIDTH            = 500;
    private final static int  HEIGHT           = 100;

    public DiffusionUIPanel()
    {
        addOutputConsole();
    }

    private void addOutputConsole()
    {
        final JTextComponent pane = new JTextPane();

        final MessageConsole console = new MessageConsole(pane);
        console.redirectOut();
        console.redirectErr(Color.RED, null);
        add(pane);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public Dimension getMinimumSize()
    {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize()
    {
        return getPreferredSize();
    }
}
