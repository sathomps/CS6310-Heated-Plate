package Tpdohp;

import java.util.List;
import java.util.Vector;

public class TempGrid {
	SingleTemp[][] temperatures;
	
	int d;
	int upperd;

	public TempGrid(int dimension) {
		// TODO Auto-generated constructor stub
		upperd = dimension + 2;
		temperatures = new SingleTemp[upperd][upperd];
		
		for(int i=0; i<upperd; i++){
			for (int j = 0; j<upperd; j++){
				temperatures[i][j] = new SingleTemp();
			}
		}
		
		d = dimension;
	}

	public void initialize(int lefttemp, int righttemp, int toptemp,
			int bottomtemp) {
		float l = (float)lefttemp;
		float r = (float)righttemp;
		float t = (float)toptemp;
		float b = (float)bottomtemp;
	    
		for(int i=0; i<upperd; i++) {
			temperatures[0][i].setTemperature(t);
			temperatures[d + 1][i].setTemperature(b);
		}
		
		for(int i=0; i<upperd; i++) {
			temperatures[i][0].setTemperature(l);
			temperatures[i][d + 1].setTemperature(r);
		}
		for(int i=1; i<d + 1; i++){
			for(int j=1; j<d + 1; j++){
				temperatures[i][j].setTemperature(0);
				List<SingleTemp> neighbors = new Vector<SingleTemp>();
				neighbors.add(temperatures[i][j-1]);
				neighbors.add(temperatures[i-1][j]);
				neighbors.add(temperatures[i+1][j]);
				neighbors.add(temperatures[i][j+1]);
				temperatures[i][j].setNeighbors(neighbors);
			}
		}
		
	}

	public void doCalculations() {
		for(int i=1; i<d + 1; i++){
			for(int j=1; j<d + 1; j++){
				temperatures[i][j].update();
			}
		}
		
	}

	public void printPlate() {
		String output = "";
		double temp = 0;
		for(int i= 1; i <= d; i++) {
        	for(int j= 1; j <= d; j++) {
        	    temp = temperatures[i][j].getTemperature();
        	    //temp = Math.round(temp * 100) / 100;
        	    temp = Math.round(temp * 100);
        	    temp = temp/100;
        	    output = Double.toString(temp) + " ";
        		System.out.print(output);
        	
        	}
        	System.out.println();
        }
		
	}

}
