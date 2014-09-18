package Tpdohp;

public class Computations {
	
	static int iteration = 100;

	public static void processTemps(int dimension, int lefttemp, int righttemp,
			int toptemp, int bottomtemp) {
		TempGrid temps = new TempGrid(dimension);
		temps.initialize(lefttemp,righttemp,toptemp,bottomtemp);
		int i = 0;
		while (i < iteration){
			i++;
			temps.doCalculations();
		}
		
		temps.printPlate();
		
	}

}
