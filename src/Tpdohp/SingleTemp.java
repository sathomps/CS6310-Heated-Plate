/**
 * 
 */
package Tpdohp;

import java.util.List;

/**
 * @author jr488m
 *
 */
public class SingleTemp {
	double newTemp;
	double oldTemp;
	private List<SingleTemp> neighbors;
	boolean checked;
	
	public SingleTemp(){
		checked = true;
	}

	public void setTemperature(float temp) {
		// TODO Auto-generated method stub
		newTemp = temp;
		oldTemp = temp;
	}
	
	public double getTemperature(){
		return newTemp;
	}

	public void setNeighbors(List<SingleTemp> neighbors) {
		// TODO Auto-generated method stub
		this.neighbors = neighbors;
	}

	public void update() {
		// TODO Auto-generated method stub
		oldTemp = newTemp;
		double total = 0;
		checked = !checked;
		for(SingleTemp neighbor : neighbors){
			total += neighbor.getOldTemp(checked);
		}
		
		newTemp = total/ neighbors.size();
	}

	private double getOldTemp(boolean checked2) {
		// TODO Auto-generated method stub
		if(checked){
			return oldTemp;
		}
		else{
			return newTemp;
		}
	}

}
