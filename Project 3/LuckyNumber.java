   import java.util.Scanner;
   import java.util.Random;
/**
*This program gets a user's information code containing
*their age, height, and name and prints out their
*information as well as a lucky number from 1 to 9.
*
*@author Joshua Kane - 004
*@version 2/6/11
*/
   public class LuckyNumber
   {
   /**
   *This method accepts an information code as input that
   *contains the user's age, height, and name and then prints
   *the information out as well as a random lucky number.
   *
   *@param args User-defined command line arguments.
   */
      public static void main(String[] args)
      {
      
      //Declare variables
         String input, name;
         int age, height, heightft, heightin, num1;
         Scanner scan = new Scanner(System.in);
         Random gen = new Random();
         
      //Store and declare variables
         System.out.print("Input the information code: ");
         input = (scan.nextLine());
         
         if (input.length() < 4)
         {
            System.out.print("\r\nThe information code must be at"
               + " least 4 characters long.");
         }
         else {
            age = Integer.parseInt(input.substring(0, 2));
            height = Integer.parseInt(input.substring(2, 4));
            name = input.substring(4, input.length());
            
         //Calculations
         
            heightft = (height / 12);
            heightin = (height % 12);
            num1 = gen.nextInt(9) + 1;
            
            System.out.print("\r\nName: " + name);
            System.out.print("\r\nAge: " + age);
            System.out.print("\r\nHeight: " + heightft + " ft "
               + heightin + " in");
            System.out.print("\r\nLucky Number: " + num1);
         }
      }
   }