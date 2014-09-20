package Gallhp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import common.AbstractDemo;
import common.DiffusionArguments;

public class DiffusionUI extends JFrame
{
    private static final long                         serialVersionUID = 1L;

    private final List<Class<? extends AbstractDemo>> demos            = new ArrayList<Class<? extends AbstractDemo>>();

    private static final int                          INITIAL_VALUE    = 1;
    private static final int                          MIN              = 0;
    private static final int                          MAX              = 100;
    private static final int                          STEP_SIZE        = 1;

    private final SpinnerNumberModel                  dimension        = new SpinnerNumberModel(INITIAL_VALUE, MIN, MAX, STEP_SIZE);
    private final SpinnerNumberModel                  precision        = new SpinnerNumberModel(2, MIN, MAX, STEP_SIZE);
    private final SpinnerNumberModel                  leftTemp         = new SpinnerNumberModel(INITIAL_VALUE, MIN, MAX, STEP_SIZE);
    private final SpinnerNumberModel                  rightTemp        = new SpinnerNumberModel(INITIAL_VALUE, MIN, MAX, STEP_SIZE);
    private final SpinnerNumberModel                  topTemp          = new SpinnerNumberModel(INITIAL_VALUE, MIN, MAX, STEP_SIZE);
    private final SpinnerNumberModel                  bottomTemp       = new SpinnerNumberModel(INITIAL_VALUE, MIN, MAX, STEP_SIZE);

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

        addArgumentSelection(menubar);
        addDemoSelection(menubar);
    }

    private void addArgumentSelection(final JMenuBar menubar)
    {
        addSpinner(menubar, dimension, "dimension");
        addSpinner(menubar, leftTemp, "leftTemp");
        addSpinner(menubar, rightTemp, "rightTemp");
        addSpinner(menubar, topTemp, "topTemp");
        addSpinner(menubar, bottomTemp, "bottomTemp");
        addSpinner(menubar, precision, "precision");
    }

    private void addSpinner(final JMenuBar menubar, final SpinnerNumberModel model, final String menuTitle)
    {
        final JMenu menu = new JMenu(menuTitle);
        menu.add(new JSpinner(model));
        menubar.add(menu);
    }

    private void addDemoSelection(final JMenuBar menubar)
    {
        addDemos();

        final JComboBox selection = new JComboBox();
        menubar.add(selection);
        for (final Class<? extends AbstractDemo> demo : demos)
        {
            selection.addItem(demo);
        }
        selection.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                final AbstractDemo demo = getDemo(e, getDiffusionArguments());
                demo.execute();
            }

            private DiffusionArguments getDiffusionArguments()
            {
                return new DiffusionArguments().setBottomTemp(bottomTemp.getNumber()).setDimension(dimension.getNumber().intValue())
                        .setLeftTemp(leftTemp.getNumber()).setPrecision(precision.getNumber().intValue()).setRightTemp(rightTemp.getNumber())
                        .setTopTemp(topTemp.getNumber());
            }

            private AbstractDemo getDemo(final ActionEvent e, final DiffusionArguments args)
            {
                try
                {
                    return getSelectedItem(e).getConstructor(DiffusionArguments.class).newInstance(args);
                }
                catch (final Exception ex)
                {
                    throw new RuntimeException(ex);
                }
            }

            @SuppressWarnings("unchecked")
            private Class<? extends AbstractDemo> getSelectedItem(final ActionEvent e)
            {
                return (Class<? extends AbstractDemo>) getSource(e).getSelectedItem();
            }

            private JComboBox getSource(final ActionEvent e)
            {
                return (JComboBox) e.getSource();
            }
        });
    }

    private void addPanel()
    {
        add(new DiffusionUIPanel());
    }

    /**
     * XXX - Would rather use something like this pattern here.
     * http://metainf-services.kohsuke.org/
     */
    private void addDemos()
    {
        demos.add(Tpdahp.Demo.class);
        demos.add(Tpdohp.Demo.class);
        demos.add(Tpfahp.Demo.class);
        demos.add(Twfahp.Demo.class);
    }
}
