package TheaterSeating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Theater {
	private List<SingleRow> rows;
	 private List<SingleRow> sortedDivisionList;
	  private AtomicInteger totalSeats;
	  
	public Theater(int numberOfRows) {
	    rows = new ArrayList<SingleRow>();
	    int actualRows = (numberOfRows + 1) / 2;
	    totalSeats = new AtomicInteger(actualRows * 20);
	    for (char ch = 'A'; ch < 'A'+numberOfRows; ch++) {
	      rows.add(new SingleRow(ch));
	    }
	  }
	public void  PrintTheater() {
		//System.out.println(rows);
		for(SingleRow row:rows) {
			System.out.println(row.getEmptySeats()+" "+row.getRowName()+" "+row.getRepresentation());
			
		}
	}
	public String fillSeats(String reservationIdentifier, int numberOfSeats) {
		StringBuilder confirmation = new StringBuilder();
		List<String> fillingSeatNumbers = new ArrayList<>();
		//check whether number of seats are valid /not (order is valid or not)
		if (numberOfSeats <= 0 || reservationIdentifier == null) {

			confirmation.append("Invalid Order(check number of seats or Reservation Identifier)\n");
		      return confirmation.toString();
		    }
	//	checking if seats are more than 20 and redirecting to contact service
	    if (numberOfSeats > 20) {
	    	confirmation.append(reservationIdentifier + " ").append("Cannot process more than 20 seats ,Please contact customer service\n");
	      return confirmation.toString();
	    }
		//Here checking if theater has space for the requested number of seats
	    if (totalSeats.intValue() < numberOfSeats) {
	    	confirmation.append(reservationIdentifier + " ").append("Sorry,The theater is full\n");
	      return confirmation.toString();
	    }
	  /*Assumption of primary preference is far away from the screen
	   * Starting from the last row it checks all the rows which have place if there is a row then it fills the seats
	   */
	    for (int i = 0; i < rows.size(); i = i + 2) {
	      if (rows.get(i).getEmptySeats() >= numberOfSeats) {
	    	  fillingSeatNumbers.add(rows.get(i).bookSeats(numberOfSeats, reservationIdentifier, totalSeats));
	    	  rows.get(i+1).unWantedRows();
	    	  break;
	      }
	    }
	  //When the seats are not available in the same row, allot the seats in different rows in the
	    // decreasing order
	    if (fillingSeatNumbers.isEmpty()) {
	    	
	    	//sorting according to the  maximum empty rows 
	    	sortedDivisionList = rows.stream().filter(row -> row.getRowName() % 2 != 0)
	              .collect(Collectors.toList());
	      
	    	Collections.sort(sortedDivisionList, (a, b) -> b.getEmptySeats() - a.getEmptySeats());
	      
	     
	      int m = 0;

	      while (m < sortedDivisionList.size() && numberOfSeats > 0) {
	    	  //System.out.println(sortedList.get(j).isFilled()+"checking if it is filled or not");
	        if (!sortedDivisionList.get(m).isSeatFilled()) {
	          int temp = sortedDivisionList.get(m).getEmptySeats();
	          fillingSeatNumbers.add(sortedDivisionList.get(m).bookSeats(numberOfSeats, reservationIdentifier,
	                  totalSeats));
	          
	          numberOfSeats = numberOfSeats - Math.min(temp, numberOfSeats);
	        }
	        m++;
	      }
	    }
	    confirmation.append(reservationIdentifier).append(" ")
	            .append(String.join(",", fillingSeatNumbers))
	            .append("\n");
	    return confirmation.toString();

	  }
	  
	
	public List<SingleRow> getRows() {
		    return rows;
		  }
	  public int getTotalSeats() {
		    return totalSeats.intValue();
		  }


		
		
	}

