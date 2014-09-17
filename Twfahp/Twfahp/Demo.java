package Twfahp;

public class Demo {

	public static void main(String[] args) {
		int dimension = 0;
		int lefttemp = 0;
		int righttemp = 0;
		int toptemp = 0;
		int bottomtemp = 0; 

		if (args == null || args.length != 10)  {
			System.out.println("Invalid command line arguments!");
			System.out
					.println("Program must be run as: java Tpdohp.Demo -d <integer> -l <integer> ");
			System.out
					.println("-r <integer> -t <integer> -b <integer> ");
			System.out
					.println("Where d is the dimension and l,r,t,b are edge temps");
			System.out
					.println("For example: java Tpdohp.Demo -d 4 -l 30 -r 35 -t 25 -b 28");
		} else {
			
			for (int i = 0; i < args.length; i++){
				if(args[i].equalsIgnoreCase("-d")){
					dimension = Integer.valueOf(args[i+1]);
				}
				else if (args[i].equalsIgnoreCase("-l")){
					lefttemp = Integer.valueOf(args[i+1]);
				}
				else if (args[i].equalsIgnoreCase("-r")){
					righttemp = Integer.valueOf(args[i+1]);
				}
				else if (args[i].equalsIgnoreCase("-t")){
					toptemp = Integer.valueOf(args[i+1]);
				}
				else if (args[i].equalsIgnoreCase("-b")){
					bottomtemp = Integer.valueOf(args[i+1]);
				}
				else
					continue;
			}

			
			
			computations.processTemps(dimension,lefttemp,righttemp,toptemp,bottomtemp);
		
		}
	}
}
