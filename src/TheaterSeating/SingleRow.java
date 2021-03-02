package TheaterSeating;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
public class SingleRow {
	private char rowName;
	  private int emptySeats;
	  private int seatFilled;
	  private boolean isSeatFilled;
	  private ArrayList<String> representation=new ArrayList<>();

	public SingleRow(char name) {
	    this.rowName = name;
	    this.emptySeats = 20;
	    this.seatFilled = -1;
	    for(int i=0;i<emptySeats;i++) {
	    	representation.add("____");
	    }
	  }
	 public String bookSeats(int seatsNumber, String reservationIdentifier, AtomicInteger totalSeats) {

		    StringBuilder seats = new StringBuilder();
		    int loops = Math.min(seatsNumber, emptySeats);
		    int x=0;
		    int y=++seatFilled;
		    seats.append(rowName).append(y);
		    representation.set(y,reservationIdentifier);
		    
		    for (int i = 1; i < loops; i++) {
		    	x=++seatFilled;
		    	seats.append("," + rowName).append(x);
		    	representation.set(x,reservationIdentifier);
		    }
		    if(x!=0) {
		    	for(int i=1;i<=3;i++) {
		    		if(x+i<representation.size()) {
		    		representation.set(x+i,"xxxx");
		    	}
		    		else {
		    			break;
		    		}
		    }
		    }
		    if(x==0) {
		    	for(int i=1;i<=3;i++) {
		    		if(y+i<representation.size()) {
		    		representation.set(y+i,"xxxx");
		    	}
		    		else {
		    			break;
		    		}
		    }
		    }
		   
		    this.seatFilled+=3;
		    this.emptySeats = this.emptySeats-(loops + 3);
		    
		    totalSeats.set(totalSeats.intValue()-(loops+(emptySeats<0?(emptySeats + 3):3)));
		    if (this.emptySeats < 0) {
		    	isSeatFilled = true;
		    }

		    return seats.toString();
		  }
	 
	 
	 public int getEmptySeats() {
		    return emptySeats;
		  }
	 
	 public boolean isSeatFilled() {
		    return isSeatFilled;
		  }
	 public int getseatsFilled() {
		 return seatFilled;
	 }
	 public ArrayList<String> getRepresentation() {
		 return representation;
	 }
	 public void unWantedRows() {
		 for(int i=0;i<20;i++) {
			 representation.set(i, "xxxx");
		 }
	 }
	 public char getRowName() {
		    return rowName;
		  }


}
