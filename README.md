#ProblemStatement:

This application is used to to reserve seats for movie theater as per the request and this algorithm is giving preference to customer satisfaction and  customer safety while reserving the seats

#Classes:
This algorithm have 5 classes mainly:

1. TheaterSeatingApplication:This is our main class.
#Methods in TheaterSeatingApplication:
Here we have written methods to read input file and to write to the output file.
We also have a main method which calls the main function to make reservations.

2. SingleRow: This class contains variables like rownumber, capacity, remaining, startingpos
3. Screen: This class contains list of Singlerows.
4. SeatFilling: This class contains our main functionality to make reservations according to the availability.
5. Reservation: This class contains input id, count and output fields. This class is used to read the input in to id and count fields and writes output in the output field. This class also contains necessary getters and setters.

#SeatFillingTestClass:
This have different scenarios JUnit testcases.

#Assumptions:
1. seats will be booked on first come first serve basis.
2. So customer satisfaction attribute I have taken the assumption of customers prefer the seats far away from the screen and my screens farthest row is "A" and the nearest row to screen is 'J'
3. So first seats are booked in a single row if enough empty seats are present, if there aren't enough seats will check for maximum empty seats in a row and will be filled first
4. Maximum limit for bookings is 20 seats if it exceeds we show error message.
5. after a order is booked, next 3 seats will be blocked for customer safety. If the next request can accomodate seats in the same row then we use that row to fill first otherwise we will try using new row.

#How to Run
have executable Runnable jar file
java -jar TheatreSeating.jar "inputpath"
prints the output path
