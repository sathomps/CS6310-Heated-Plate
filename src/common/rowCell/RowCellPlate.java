package common.rowCell;

import java.util.LinkedHashMap;

import common.DiffusionArguments;
import common.DiffusionCalculation;
import common.Plate;
import common.number.NumberConvertor;

public class RowCellPlate implements Plate
{
    private final DiffusionCalculation        calc;
    private final NumberConvertor             convertor;
    private final DiffusionArguments          args;

    private final LinkedHashMap<Integer, Row> grid = new LinkedHashMap<Integer, Row>();

    public RowCellPlate(final DiffusionArguments args)
    {
        this.args = args;
        this.convertor = args.getConvertor();
        calc = new DiffusionCalculation(convertor);
        initialize();
    }

    @Override
    public void initialize()
    {
        for (int rowIndex = 0; rowIndex < args.getPlateDimensions(); rowIndex++)
        {
            final Row row = new Row();

            grid.put(rowIndex, row);

            for (int cellIndex = 0; cellIndex < args.getPlateDimensions(); cellIndex++)
            {
                final Cell cell = new Cell();
                row.add(cellIndex, cell);

                if (rowIndex == 0)
                {
                    cell.setTemp(args.getTopTemp().doubleValue());
                }
                else if (rowIndex == (args.getPlateDimensions() - 1))
                {
                    cell.setTemp(args.getBottomTemp().doubleValue());
                }
                else if (cellIndex == 0)
                {
                    cell.setTemp(args.getLeftTemp().doubleValue());
                }
                else if (cellIndex == (args.getPlateDimensions() - 1))
                {
                    cell.setTemp(args.getRightTemp().doubleValue());
                }
            }
        }
    }

    private Cell getCell(final int row, final int cell)
    {
        return grid.get(row).get(cell);
    }

    @Override
    public void calculateDiffusion(final Plate oldPlate, final int row, final int cell)
    {
        getCell(row, cell).setTemp(calc.calculate(oldPlate, row, cell).doubleValue());
    }

    @Override
    public void display()
    {
        for (int row = 1; row < (args.getPlateDimensions() - 1); row++)
        {
            for (int cell = 1; cell < (args.getPlateDimensions() - 1); cell++)
            {
                System.out.print(convertor.convertForDisplay(getTemp(row, cell), args.getPrecision()) + "  ");
            }
            System.out.println();
        }
    }

    @Override
    public void swap(final Plate swapPlate)
    {
        for (int row = 0; row < args.getPlateDimensions(); row++)
        {
            for (int cell = 0; cell < args.getPlateDimensions(); cell++)
            {
                getCell(row, cell).setTemp(swapPlate.getTemp(row, cell).doubleValue());
            }
        }
    }

    @Override
    public Number getTemp(final int row, final int cell)
    {
        return getCell(row, cell).getTemp();
    }
}
