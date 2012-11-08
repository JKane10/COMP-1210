   import java.util.Scanner;
   import java.text.DecimalFormat;
/**
*This program will solve Schaffer's F6 function
*at given x and y coordinates.
*
*Project 3A
*
*@author Joshua Kane - section 004
*@version 2/6/11
*/
   public class F6Function
   {
   /**
   *This method will gather and store the x and y coordinates,
   *name the result, run Schaffer's F6 calculation with the
   *declared x and y coordinates and print the result name and
   *data rounded to the ten thousandths place.
   *
   *@param args User-defined command line arguments.
   */
      public static void main(String[] args)
      {
      // Declare Variables
         double x, y, num, dem;
         String result;
         DecimalFormat fmt = new DecimalFormat("#.####");
         Scanner scan = new Scanner(System.in);
      // Store and display user inputs
         System.out.println("Schaffer's F6 Function Calculator");
         System.out.print("Declare the x coordinate: ");
         x = Double.parseDouble(scan.nextLine());
         System.out.print("Declare the y coordinate: ");
         y = Double.parseDouble(scan.nextLine());
         System.out.print("Name the result: ");
         result = (scan.nextLine());
      // Calculations--
      //Numerator
         num = Math.pow(x, 2) + Math.pow(y, 2);
         num = Math.sqrt(num);
         num = Math.sin(num);
         num = Math.pow(num, 2) - 0.5;
      //Denominator
         dem = Math.pow(x, 2) + Math.pow(y, 2);
         dem = dem * 0.001 + 1;
         dem = Math.pow(dem, 2);
      //Result
         System.out.print("\r\n");
         System.out.print(result + " = " + fmt.format((0.5 - (num / dem))));
      }
   }