  /**
  * Creating an exception that extends Exception class.
  * @author Clayton Martin and Joshua Kane - Section 004.
  * @version 4/20/11.
  */
  
  
   public class FileNameException extends RuntimeException
   {
      /**
      * Method that is a constructor that takes a file name.
      * @param fileName - takes fileName as a string parameter.
      */
      
      
      FileNameException(String fileName)
      {
         super("File name does not have .dat extension.");
      }
   }
