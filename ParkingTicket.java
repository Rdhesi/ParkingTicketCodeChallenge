//Ravinder Dhesi

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkingTicket 
{
   public static void main(String[] args) throws IOException 
   {
	   //initializes the ticket amount
	   int ticket = 0;
	   
	   
	   System.out.println("Enter the date the fine is paid. Input month day and year separated by spaces");
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //creates the reader to read in the person's input
	   int paidDateArray[] = new int[3]; //initializes an array that will contain the date paid
	   String[] paidDate = br.readLine().split(" "); //will take the person's input and split it into a string array
	   for (int i = 0; i < 3; i++) {
		   paidDateArray[i] = Integer.parseInt(paidDate[i]);// turns the numbers in the string array into ints and adds to the int array
       }

	   
	   System.out.println("Enter the date the fine was due. Input day month and year separated by spaces");
	   
	   int dueDateArray[] = new int[3]; //initializes an array that will contain the date due
	   String[] dueDate = br.readLine().split(" ");//will take the person's input and split it into a string array
	   for (int i = 0; i < 3; i++) {
		   dueDateArray[i] = Integer.parseInt(dueDate[i]); // turns the numbers in the string array into ints and adds to the int array
       }
	  
	   System.out.println("Enter the parking ticket amount");
	   
	    String tic = br.readLine(); // reads in the parking ticket amount 
	    int parkingTicket = Integer.parseInt(tic); //turns the parking ticket string into an int
	   
	   
	   ticket = calculateTicket(paidDateArray, dueDateArray, parkingTicket); //Calculates the total ticket amount
	   
	   System.out.println(ticket);//prints out the result
   }
   
  public static int calculateTicket(int paidDate[], int dueDate[], int originalAmount)
  //paidDate[] is an array containing the 3 numbers of the paid date [month, day, year]
  // dueDate[] is an array containing the 3 numbers of the due date [day, month, year]
  //originalAmount is the initial parking ticket amount before a fine is applied 
  {
	  int ticketTotal = 0;
	  int fine = 0;
	  if(paidDate[2] > dueDate[2])//if the year paid is greater than the year it was due
	  {
		  fine=500; //set fine to flat rate: $500
		  
	  }
	  //if the paid year is the same as the due year
	  else if (paidDate[0] > dueDate[1]) //if the paid month is later than the month it was due
	  {
		  fine = (paidDate[0] - dueDate[1])*35; //count the number of months late and multiply it by $35
	  }
	  //if moth the month and the year were the same
	  else if (paidDate[1] > dueDate[0]) // if the paid day was later than the day due
	  {
		  fine = (paidDate[1] - dueDate[0]); //the fine is $1 for each late day
	  }
	  else // if it was paid on the due date
	  {
		  fine = 0;
	  }

	  
	  ticketTotal = fine + originalAmount; //the amount that is due is the original ticket price + the fine
	  return ticketTotal;
  }
  
}