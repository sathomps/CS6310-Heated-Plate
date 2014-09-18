package Twfahp;

public class computations
{
    static Float[][] oldPlate;
    static Float[][] newPlate;
    static int       iteration = 100;

    public static void processTemps(final int dimension, final int lefttemp, final int righttemp, final int toptemp, final int bottomtemp)
    {
        oldPlate = new Float[dimension + 2][dimension + 2];
        newPlate = new Float[dimension + 2][dimension + 2];

        initialize(oldPlate, lefttemp, righttemp, toptemp, bottomtemp);
        initialize(newPlate, lefttemp, righttemp, toptemp, bottomtemp);

        doCalculations(oldPlate, newPlate, dimension);

        printPlate(newPlate);

    }

    private static void printPlate(final Float[][] newPlate2)
    {

        for (int i = 1; i < (newPlate2.length - 1); i++)
        {
            for (int j = 1; j < (newPlate2.length - 1); j++)
            {
                System.out.print(newPlate2[i][j] + " ");

            }
            System.out.println();
        }

    }

    private static void doCalculations(final Float[][] oldPlate1, final Float[][] newPlate1, final int dimension)
    {
        int it = 0;
        while (!(it == iteration))
        {

            it++;
            for (int i = 1; i <= dimension; i++)
            {
                for (int j = 1; j <= dimension; j++)
                {
                    newPlate1[i][j] = ((oldPlate1[i + 1][j] + oldPlate1[i - 1][j] + oldPlate1[i][j + 1] + oldPlate1[i][j - 1]) / 4);
                    System.out.println(newPlate1[i][j]);
                }
            }
            // Swap the plates and continue
            swapPlates(oldPlate, newPlate);
        }

    }

    private static void swapPlates(final Float[][] oldPlate2, final Float[][] newPlate2)
    {
        // TODO Auto-generated method stub
        // put the values of newPlate into oldPlate
        for (int i = 0; i < oldPlate.length; i++)
        {
            for (int j = 0; j < oldPlate.length; j++)
            {
                oldPlate[i][j] = newPlate[i][j];
            }
        }

    }

    private static void initialize(final Float[][] plate, final int lefttemp, final int righttemp, final int toptemp, final int bottomtemp)
    {
        for (int i = 0; i < plate.length; i++)
        {
            for (int j = 0; j < plate.length; j++)
            {
                if (i == 0)
                {
                    plate[i][j] = (float) toptemp;
                }
                else if (i == (plate.length - 1))
                {
                    plate[i][j] = (float) bottomtemp;
                }
                else if ((i > 0) && (i < plate.length) && (j == 0))
                {
                    plate[i][j] = (float) lefttemp;
                }
                else if ((i > 0) && (i < plate.length) && (j == (plate.length - 1)))
                {
                    plate[i][j] = (float) righttemp;
                }
                else
                {
                    plate[i][j] = (float) 0;
                }
            }
        }

    }

}
