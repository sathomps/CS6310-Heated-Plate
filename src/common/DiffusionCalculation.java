package common;

public class DiffusionCalculation
{
    private final NumberConvertor convertor;

    public DiffusionCalculation(final NumberConvertor convertor)
    {
        this.convertor = convertor;
    }

    public Number calculate(final Number[][] grid, final int row, final int cell)
    {
        return convertor.divide(add(grid, row, cell), 4);
    }

    private Number add(final Number[][] grid, final int row, final int cell)
    {
        return convertor.add(value(grid, row + 1, cell), value(grid, row - 1, cell), value(grid, row, cell + 1), value(grid, row, cell - 1));
    }

    private Number value(final Number[][] internals, final int row, final int cell)
    {
        return internals[row][cell];
    }
}
