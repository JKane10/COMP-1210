   import java.util.Scanner;

/**
*This program will determine the total cost and layers of cake
*needed for a party.
*
*Project 2
*
*@author Joshua Kane - section 004
*@version 1/24/11
*/

   public class PartyPlanner
   {
   
   /**
   *This method will gather the number of guests
   *the price per plate of food and run calculations
   *to determine the total costs of the dinner as well
   *as the layers of cake needed to feed all the guests.
   *
   *
   *@param args User-defined command line arguments.
   */
   
      public static void main(String[] args)
      {
      // Declare variables
         Scanner scanIn = new Scanner(System.in);
         int guests, cakelayers, gap;
         double plateprice, totalprice;
      
      // Store and display user inputs
         System.out.print("The number of guests: "); guests = scanIn.nextInt();
         System.out.print("\r\nThe price per plate: "); 
         plateprice = scanIn.nextDouble();
      	
      // Calculations
         totalprice = (((plateprice + 2) * guests) * 0.15) 
            + ((plateprice + 2) * guests); 
         System.out.print("\r\n\r\nPrice for dinner: " + totalprice
            + ".");
         cakelayers = (guests / 11);
                     
         gap = guests % 11;
         
         if (gap > 0) {
            cakelayers = cakelayers + 1;
         }
            
         System.out.print("\rThe cake will need " + cakelayers
            + " layer(s).");
      
      	
      }
   }