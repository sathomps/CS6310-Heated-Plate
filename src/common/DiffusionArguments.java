package common;

import static java.lang.System.out;

public class DiffusionArguments
{
    private int             precision  = 2;
    private int             dimension  = 0;
    private Number          leftTemp   = 0;
    private Number          rightTemp  = 0;
    private Number          topTemp    = 0;
    private Number          bottomTemp = 0;
    private NumberConvertor convertor;

    public DiffusionArguments(final String[] args)
    {
        validateInput(args);
        processArgs(args);
        validateArgs();
    }

    private void validateInput(final String[] args)
    {
        if ((args == null) || (args.length < 10))
        {
            out.println("Invalid command line arguments!");
            out.println("Program must be run as: java Tpfahp.Demo -d # -l # -r # -t # -b # -p <optinal> #");
            out.println("Where The -d flag indicates that the next argument is the dimension of the square lattice (number of rows and columns, ");
            out.println("not counting the edge values). It is a positive integer value greater than zero.");
            out.println("The -l, -r, -t, and -b options respectively denote the edge temperatures for the left, right, top, and bottom edges.");
            out.println("Their values are any integer between zero and one hundred, inclusive. The -p denotes precision which is an integer and is optional.");
            out.println("For example: java Tpfahp.Demo -d 3 -l 75 -r 50 -t 100 -b 0 ");

            throw new IllegalArgumentException("Invalid command line arguments!");
        }
    }

    private void processArgs(final String[] args)
    {
        for (int i = 0; i < args.length; i += 2)
        {
            final int value = Integer.valueOf(args[i + 1]);
            if (args[i].equalsIgnoreCase("-d"))
            {
                dimension = value;
            }
            else if (args[i].equalsIgnoreCase("-l"))
            {
                leftTemp = value;
            }
            else if (args[i].equalsIgnoreCase("-r"))
            {
                rightTemp = value;
            }
            else if (args[i].equalsIgnoreCase("-t"))
            {
                topTemp = value;
            }
            else if (args[i].equalsIgnoreCase("-b"))
            {
                bottomTemp = value;
            }
            else if (args[i].equalsIgnoreCase("-p"))
            {
                precision = value;
            }
        }
    }

    private void validateArgs()
    {
        // dimension and precision must be > 0 while the edge temperatures must
        // be 0 - 100 inclusive
        if ((dimension <= 0) || invalidTemp(leftTemp) || invalidTemp(rightTemp) || invalidTemp(topTemp) || invalidTemp(bottomTemp))
        {
            out.println("One or more arguments provided are not valid!");
            out.println("Dimension & Precision must be a positive integer value greater than zero. The edge temperatures must be in the range 0 - 100 (inclusive).");

            throw new IllegalArgumentException("Invalid command line argument values!");
        }
    }

    private boolean invalidTemp(final Number temp)
    {
        return (temp.intValue() < 0) || (temp.intValue() > 100);
    }

    public int getPlateDimensions()
    {
        return getDimension() + 2;
    }

    public int getDimension()
    {
        return dimension;
    }

    public void setDimension(final int dimension)
    {
        this.dimension = dimension;
    }

    public Number getLeftTemp()
    {
        return leftTemp;
    }

    public void setLeftTemp(final Number leftTemp)
    {
        this.leftTemp = leftTemp;
    }

    public Number getRightTemp()
    {
        return rightTemp;
    }

    public void setRightTemp(final Number rightTemp)
    {
        this.rightTemp = rightTemp;
    }

    public Number getTopTemp()
    {
        return topTemp;
    }

    public void setTopTemp(final Number topTemp)
    {
        this.topTemp = topTemp;
    }

    public Number getBottomTemp()
    {
        return bottomTemp;
    }

    public void setBottomTemp(final Number bottomTemp)
    {
        this.bottomTemp = bottomTemp;
    }

    public void setConvertor(final NumberConvertor convertor)
    {
        this.convertor = convertor;
    }

    public NumberConvertor getConvertor()
    {
        return convertor;
    }

    public int getPrecision()
    {
        return precision;
    }

    public void setPrecision(final int precision)
    {
        this.precision = precision;
    }
}
