package Tpdahp;

import static org.junit.Assert.*;
import org.junit.Test;

import common.DiffusionArguments;
import common.DiffusionSimulation;
import common.number.DoublePlate;

public class TpdahpTest {

    protected DoublePlate[] plates;
    protected DiffusionSimulation simulation;
    protected Demo demo;
	
    @Test
    public void test() { 
        String args[] = {"-d", "4", "-l", "30", "-r", "35", "-t", "25", "-b", "28"}; 
		
        this.demo = new Demo(new DiffusionArguments(args));				
        this.plates = this.demo.createPlates();
        this.simulation = new DiffusionSimulation(demo.getDiffusionArgs(), 
                plates[0], plates[1]);
        simulation.calculate();
        
        String expected = "27.86  27.43  28.00  29.91  \n"+
                "29.02  28.86  29.66  31.64  \n"+
                "29.36  29.34  30.14  31.98  \n"+
                "29.09  29.00  29.57  31.14  \n";
        assertEquals(expected, plates[0].getOutput()); 
    }

}
