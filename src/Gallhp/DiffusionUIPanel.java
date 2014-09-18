package Gallhp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class DiffusionUIPanel extends JPanel
{
    private static final long serialVersionUID  = 1L;

    /**
     * Size of the containing window in pixels
     */
    public final static int   WINDOW_SIZE       = 400;

    /**
     * Amount of border space around the DrawnGrid in pixels
     */
    public final static int   BORDER_SIZE       = 50;

    /**
     * Height and width of the DrawnGrid in pixels
     */
    private final static int  GRID_SIZE         = WINDOW_SIZE - (2 * BORDER_SIZE);

    /**
     * Number of rows of cells in the DrawnGrid
     */
    private static final int  NUMBER_OF_ROWS    = 6;

    /**
     * Number of cells in a row
     */
    private static final int  NUMBER_OF_COLUMNS = 6;

    /**
     * The height of a cell in pixels
     */
    private static final int  CELL_HEIGHT       = GRID_SIZE / NUMBER_OF_COLUMNS;

    /**
     * The width of a cell in pixels
     */
    private static final int  CELL_WIDTH        = GRID_SIZE / NUMBER_OF_ROWS;

    /**
     * X-coordinate of the upper left hand corner of the rectangle within the
     * containing widget
     */
    private final int         ulhcX;

    /**
     * Y-coordinate of the upper left hand corner of the rectangle within the
     * containing widget
     */
    private final int         ulhcY;

    /**
     * Width of the rectangle in pixels
     */
    private final int         width;

    /**
     * Height of the rectangle in pixels
     */
    private final int         height;

    /**
     * Creates a DrawnGrid, which is a displayable rectangle. All units are in
     * pixels.
     *
     * @param x
     *            X coordinate of the upper left hand corner of the rectangle
     *            within the containing widget
     * @param y
     *            Y coordinate of the upper left hand corner of the rectangle
     *            within the containing widget
     * @param w
     *            width of the rectangle
     * @param h
     *            height of the rectangle
     */
    public DiffusionUIPanel(final int x, final int y, final int w, final int h)
    {
        ulhcX = x;
        ulhcY = y;
        width = w;
        height = h;
    }

    /**
     * Informs Swing of how much space is needed for drawing.
     * 
     * @return Dimension - the size of the drawing area
     * @override getPreferredSize in JPanel
     * @see javax.swing.JComponent#getPreferredSize()
     */
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(width, height);
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

    /**
     * Paints one cell of the grid.
     *
     * @param aGraphics
     *            Graphics into which painting will be done
     * @param row
     *            row number of the grid cell
     * @param col
     *            column number of the grid cell
     * @param t
     *            intensity of Color red to be painted; a number from 0.0 to 1.0
     */
    private void paintSpot(final Graphics aGraphics, final int row, final int col, final double t)
    {
        final int rowPos = ulhcY + (row * CELL_HEIGHT);
        final int colPos = ulhcX + (col * CELL_WIDTH);

        // Overwrite everything that was there previously
        aGraphics.setColor(Color.black);
        aGraphics.fillRect(colPos, rowPos, CELL_WIDTH, CELL_HEIGHT);

        // Color in RGB format with green and blue values = 0.0
        aGraphics.setColor(new Color((float) Math.random(), 0.f, 0.f));
        aGraphics.fillRect(colPos, rowPos, CELL_WIDTH, CELL_HEIGHT);
    }

    /**
     * Informs Swing how to render in terms of subcomponents.
     * 
     * @param aGraphics
     *            Graphics - Graphs context for drawing
     * @override paintComponent in JPanel
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(final Graphics aGraphics)
    {
        super.paintComponent(aGraphics);

        final BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        final Graphics anotherGraphics = bi.createGraphics();

        for (int i = 0; i < NUMBER_OF_ROWS; i++)
        {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
            {
                // Instead of calling random, here is where you
                // would insert the call that would provide
                // the temperature of the corresponding cell
                // on the heated plate.
                paintSpot(anotherGraphics, i, j, Math.random());
            }
        }

        aGraphics.drawImage(bi, 0, 0, this);
    }
}
