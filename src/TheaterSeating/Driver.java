package TheaterSeating;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Theater theater = new Theater(10);
		
		StringBuilder confirmation = new StringBuilder();
	 String input=args[0];
	 
	 //Reading input
	 try (BufferedReader br = new BufferedReader(new FileReader(input))){
		String line = br.readLine();
		//theater.PrintTheater();
		System.out.println("input file content...................");
		while(line!=null) {
			//System.out.println(line);
			String[] order = line.split(" ");//splitting the line 
			//System.out.println(order);
			System.out.println(order[0]+" "+order[1]);
			String reservationIdentifier = order[0];
			int numberOfSeats = Integer.parseInt(order[1]);
			confirmation.append(theater.fillSeats(reservationIdentifier, numberOfSeats));
	        
			line = br.readLine();
		}
		//writing to the output file
		File file = new File("output.txt");
	      BufferedWriter b = new BufferedWriter(new FileWriter(file));
	      b.write(confirmation.toString());
	      System.out.println("\noutput file content...................");
	      System.out.println(confirmation.toString());
	      b.flush();
	      b.close();
	      System.out.println("\nOutput File Path: "+file.getAbsoluteFile()+"\n");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		 
	 
	 
	 //theater.PrintTheater();

}
}
