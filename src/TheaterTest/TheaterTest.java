package TheaterTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

import TheaterSeating.SingleRow;
import TheaterSeating.Theater;

class TheaterTest {
	Theater t;
	
	  //checking single row constructor
	  @Test
	  public void testSingleRow() {
		  
	    SingleRow row = new SingleRow('A');
	    assertEquals(20, row.getEmptySeats());
	  }
	  
	  //checking if a single Row is assigning seats correctly/not
	  @Test
	  public void testRowForSeatsFilled() {
		  SingleRow row = new SingleRow('A');
	    assertEquals("A0,A1",
	            row.bookSeats(2,"R001",new AtomicInteger(20)));
	  }
	//checking the total seats can be occupied in theater
	@Test
	void theater() {
		t=new Theater(10);
		assertEquals(100, t.getTotalSeats());
	
		
	}
	
	//After Filling seats how many seats left out
	 @Test
	  public void testTotalRemainingSeats() {
		 
	    t = new Theater(10);
	    t.fillSeats("R001", 15);
	    assertEquals(82, t.getTotalSeats());
	  }

	 //how many empty seats in a row
	  @Test
	  public void testEmptySeats() {
		  t = new Theater(10);
		  System.out.println("\n\n\n________________Testing how many empty seats in a row ______________\n");
		  t.fillSeats("R001", 15);
	    assertEquals(2, t.getRows().get(0).getEmptySeats());
	    t.PrintTheater();
	    System.out.println("\n\n\n");
	  }

	  //testing if seats filled correctly/not
	  @Test
	  public void testAssignment() {
	    t = new Theater(10);
	    System.out.println("\n\n\n________________Testing if seats filled correctly/not ______________\n");
	    
	    assertEquals("R001 A0,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14\n",
	            t.fillSeats("R001", 15));
	    t.PrintTheater();
	    System.out.println("\n\n\n");
	  }
	//testing if seats filled correctly/not

	  @Test
	  public void testAssignmentOne() {
	    t = new Theater(10);
	    System.out.println("\n\n\n________________Testing if seats filled correctly/not ______________\n");
	    t.fillSeats("R001", 2);
	    t.fillSeats("R001", 2);
	    t.fillSeats("R001", 2);
	    t.fillSeats("R001", 6);
	    t.fillSeats("R002", 2);
	    assertEquals("R003 C9,C10\n",
	            t.fillSeats("R003", 2));
	    
	    t.PrintTheater();
	    System.out.println("\n\n\n");
	  }

	 //checking if there is a order with negative number of seats or Reservation Identifier
	  @Test
	  public void testNegativeorNullReservation() {
	    t = new Theater(10);
	    assertEquals("Invalid Order(check number of seats or Reservation Identifier)\n",
	            t.fillSeats("R001", -200));
	  }

	  //checking if there is a order requesting 0 seats
	  @Test
	  public void testZeroSeats() {
	    t = new Theater(10);
	    assertEquals("Invalid Order(check number of seats or Reservation Identifier)\n",
	            t.fillSeats("R001", 0));
	   
	    
	  }
	  
	  //checking division of a gang to multiple rows
	  @Test
	  public void testFillingInDifferentRows() {
	    t = new Theater(10);
	    t.fillSeats("R001", 16);
	    t.fillSeats("R001", 16);
	    t.fillSeats("R001", 16);
	    t.fillSeats("R001", 16);
	    t.fillSeats("R001", 16);
	    assertEquals("R001 A19,C19\n",
	            t.fillSeats("R001", 2));
	    
	    
	  }

	  //checking if the theater is at maximum capacity with gang split up and cannot fit further
	  @Test
	  public void testTheaterFull() {
	    t = new Theater(10);
	    t.fillSeats("R001", 15);
	    t.fillSeats("R002", 15);
	    t.fillSeats("R003", 15);
	    t.fillSeats("R004", 15);
	    t.fillSeats("R005", 15);
	    t.fillSeats("R006", 4);
	    t.fillSeats("R007", 4);
	    t.fillSeats("R008", 2);
	    assertEquals("R009 Sorry,The theater is full\n",
	            t.fillSeats("R009",1 ));
	    
	  }

	  //checking if there are some seats left out but the requested gang seats are more so cannot fit
	  @Test
	  public void testNotEnoughSeats() {
	    t = new Theater(10);
	    t.fillSeats("R001", 15);
	    t.fillSeats("R002", 15);
	    t.fillSeats("R003", 15);
	    t.fillSeats("R004", 15);
	    t.fillSeats("R005", 15);
	    t.fillSeats("R006", 4);
	    t.fillSeats("R007", 4);
	    assertEquals("R008 Sorry,The theater is full\n",
	            t.fillSeats("R008",4 ));
	   
	  }

	  //checking max capacity with no gang split up
	  @Test
	  public void testFillingToCapacity() {
	    t = new Theater(10);
	    t.fillSeats("R001", 20);
	    t.fillSeats("R002", 20);
	    t.fillSeats("R003", 20);
	    t.fillSeats("R004", 20);
	    t.fillSeats("R005", 20);
	    assertEquals("R006 Sorry,The theater is full\n",
	            t.fillSeats("R006",1 ));
	   
	  }

	//checking not enough place if the gang is more than theater capacity  
	  @Test
	  public void testTheaterCapacity() {
		  t = new Theater(10);
		   
		   assertEquals("R001 Cannot process more than 20 seats ,Please contact customer service\n",
		            t.fillSeats("R001",101 ));
		  
		   
		  
	  }
	  @Test
	  public void testMoreThanRowCapacity() {
		  
		  t = new Theater(10);
		   
		  assertEquals("R001 Cannot process more than 20 seats ,Please contact customer service\n",t.fillSeats("R001", 100));
		  
		  
	  }
	

}
