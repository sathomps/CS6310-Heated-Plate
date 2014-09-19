package common;

public interface Plate
{
    public void initialize();

    public void calculateDiffusion(final Plate oldPlate, final int row, final int cell);

    public void display();

    public void swap(final Plate swapPlate);

    public Number getTemp(int row, int cell);
}
