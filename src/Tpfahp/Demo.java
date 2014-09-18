package Tpfahp;

public class Demo {

	public static void main(String[] args) {

		// Argument length should be minimum 10
		if (args == null || args.length < 10)  
		{ 
			System.out.print("Invalid command line arguments!"); 
			System.out.print("Program must be run as: java Tpfahp.Demo -d # -l # -r # -t # -b # -p <optinal> #"); 
			System.out.println("Where The -d flag indicates that the next argument is the dimension of the square lattice (number of rows and columns, ");
			System.out.println("not counting the edge values). It is a positive integer value greater than zero.");
			System.out.println("The -l, -r, -t, and -b options respectively denote the edge temperatures for the left, right, top, and bottom edges.");
			System.out.println("Their values are any integer between zero and one hundred, inclusive. The -p denotes precision which is an integer and is optional."); 
			System.out.println("For example: java Tpfahp.Demo -d 3 -l 75 -r 50 -t 100 -b 0 "); 
		}
		else 
		{ 
			int linearDimension = -1;
			int leftEdgeTemp = -1;
			int rightEdgeTemp = -1;
			int topEdgeTemp = -1;
			int bottomEdgeTemp = -1;
			int precision = -1;
		
			// Read all of the diffusion data
			for (int argCount = 0; argCount < args.length; argCount++)
			{
				String argument = args[argCount].toLowerCase();
				try
				{
					switch(argument)
					{
						case "-d":
						{
							linearDimension = Integer.parseInt(args[argCount+1]);
							break;
						}
						case "-l":
						{
							leftEdgeTemp = Integer.parseInt(args[argCount+1]);
							break;
						}
						case "-r":
						{
							rightEdgeTemp = Integer.parseInt(args[argCount+1]);
							break;
						}
						case "-t":
						{
							topEdgeTemp = Integer.parseInt(args[argCount+1]);
							break;
						}
						case "-b":
						{
							bottomEdgeTemp = Integer.parseInt(args[argCount+1]);
							break;
						}
						case "-p":
						{
							precision = Integer.parseInt(args[argCount+1]);
							break;
						}
					}
				}
				catch(NumberFormatException e)
				{
				       //it failed
				}
			}
			
			// dimension and precision must be > 0 while the edge temperatures must be 0 - 100 inclusive
			if (linearDimension <= 0 || leftEdgeTemp < 0 || rightEdgeTemp < 0 || topEdgeTemp < 0 || bottomEdgeTemp < 0
					|| leftEdgeTemp > 100 || rightEdgeTemp > 100 || topEdgeTemp > 100 || bottomEdgeTemp > 100)
			{
				System.out.println("One or more arguments provided are not valid!"); 
				System.out.println("Dimension & Precision must be a positive integer value greater than zero. The edge temperatures must be in the range 0 - 100 (inclusive).");
			}
			else
			{
				// Create diffusion data request
				DiffusionData diffusionData = new DiffusionData(
						linearDimension, leftEdgeTemp, rightEdgeTemp, topEdgeTemp, bottomEdgeTemp);
				// Update precision required only if > 0
				if (precision > 0)
					diffusionData.setDecimalPrecision(precision);
				
				FloatDiffusionConverter floatDiffusion = new FloatDiffusionConverter(diffusionData);
				
				floatDiffusion.ComputeDiffusion();
				floatDiffusion.DisplayDiffusionData();
			}
		}
	}

}
