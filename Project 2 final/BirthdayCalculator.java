   import java.util.Scanner;
/**
*This program will determine a customer's age based on their birthday
*and the current date.
*
*Project 2
*
*@author Joshua Kane - section 004
*@version 1/24/11
*/
   public class BirthdayCalculator
   {
   /**
   *This method will gather the information on the customer such as
   *his or her birthday date and todays date and run a calculation
   *to determine his or her age.
   *
   *@param args User-defined command line arguments.
   */
      public static void main(String[] args)
      {
      // Declare variables
         Scanner scanIn = new Scanner(System.in);
         int bday, byear, day, year;
         int age, gap;
      
      // Store, and display user inputs
         System.out.println("Please enter the customer's day of "
            + "birth followed by the year");
         System.out.print("\tDay: "); bday = scanIn.nextInt();
         System.out.print("\tYear: "); byear = scanIn.nextInt();
         System.out.println("Please enter todays day followed by the year");
         System.out.print("\tDay: "); day = scanIn.nextInt();
         System.out.print("\tYear: "); year = scanIn.nextInt();
         
      // Calculations
         age = (year - byear);
         gap = (day - bday);
         	
         if (gap < 0) {
            age = age - 1;
         }
         
         if (age > 0) {
            System.out.println("\r\nThe customer is " + age
               + " years old.");
         }
         else {
            System.out.println("\r\nError: Age can not be negative");
         }
      }
   }