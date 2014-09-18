package common;

import static java.lang.System.out;

public class DiffusionArguments
{
    private int                dimension  = 0;
    private Number             leftTemp   = 0;
    private Number             rightTemp  = 0;
    private Number             topTemp    = 0;
    private Number             bottomTemp = 0;
    private DiffusionConvertor convertor;

    public DiffusionArguments(final String[] args)
    {
        validateArgs(args);
        processArgs(args);
    }

    private void validateArgs(final String[] args)
    {
        if ((args == null) || (args.length != 10))
        {
            out.println("Invalid command line arguments!");
            out.println("Program must be run as: java Tpdohp.Demo -d <integer> -l <integer> ");
            out.println("-r <integer> -t <integer> -b <integer> ");
            out.println("Where d is the dimension and l,r,t,b are edge temps");
            out.println("For example: java Tpdohp.Demo -d 4 -l 30 -r 35 -t 25 -b 28");

            throw new IllegalArgumentException("Invalid command line arguments!");
        }
    }

    private void processArgs(final String[] args)
    {
        for (int i = 0; i < args.length; i += 2)
        {

            final int value = Integer.valueOf(args[i + 1]);
            switch (args[i])
            {
            case "-d":
                dimension = value;
                break;

            case "-l":
                leftTemp = value;
                break;

            case "-r":
                rightTemp = value;
                break;

            case "-t":
                topTemp = value;
                break;

            case "-b":
                bottomTemp = value;
                break;

            default:
                break;
            }
        }
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

    public void setConvertor(final DiffusionConvertor convertor)
    {
        this.convertor = convertor;
    }

    public DiffusionConvertor getConvertor()
    {
        return convertor;
    }

}
