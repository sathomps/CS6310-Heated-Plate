package common.rowCell;

import java.util.LinkedHashMap;

public class Row
{
    private final LinkedHashMap<Integer, Cell> cells = new LinkedHashMap<Integer, Cell>();

    public void add(final Integer cellIndex, final Cell cell)
    {
        cells.put(cellIndex, cell);
    }

    public Cell get(final Integer cellIndex)
    {
        return cells.get(cellIndex);
    }
}