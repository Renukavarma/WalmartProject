#ProblemStatement:

Need to reserve seats for movie theater as per the request and this algorithm is given preference to customer satisfaction and  customer safety while reserving the seats

#Classes:
This algorithm have 3 classes mainly:

1. Theater:To specify rows and columns of a Theater
#Methods in Theater:
This have constructor to initialize rows and columns
This also have printTheater method which shows how many seats are booked with the reservationIdentifier and the seats which cant be booked is represented as "xxxx"
Another Method fillSeats method which checks if the given order(reservationIdentifier numberOfSeats)/(R001 12) is valid or not.If this is valid then it checks if the order can be filled in a single row if it cannot it checks for can it split up and complete the order.

2. SingleRow:This particular class is having the statistics of a single row and it fills the seats according to this statistics
#Methods in SingleRow
Here constructor is initialised with name,emptyseats
Have bookSeats method so this will check if there are any empty seats it will reserve the requested seats and it make next 3 seats unavailable for booking for customer safety.

3. Driver:this is main program
This is the main program it takes file path as argument and books the seats in theater and the status of order is appended to output file and returns the output file path.

#TheaterTestClass:
This have different scenarios JUnit testcases.

#Assumptions:
1. seats will be booked on first come first serve basis.
2. So customer satisfaction attribute I have taken the assumption of customers prefer the seats far away from the screen and my screens farthest row is "A" and the nearest row to screen is 'I'
3. So first seats are booked in a single row if enough empty seats are present, if there aren't enough seats will check for maximum empty seats in a row and will be filled first
4. Not booking seats more than a single row seats ,if the booking request exceeds 20 then they need to contact customer service .

#How to Run
have executable Runnable jar file
java -jar walmart.jar "inputpath"
prints the output path
