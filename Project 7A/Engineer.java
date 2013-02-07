   import java.util.Scanner;
   import java.io.IOException;
   import java.io.File;
	
	/** 
   *The Engineer class represents an engineering employee 
   *and the time segments that they spend on each project A, B, and C. 
   *
	*@author Joshua Kane - 004
	*@version 3/5/11
   **/
 
   class Engineer
   {
   /** Parses file name into engineer's name in an array. **/
      private String[] engineerName = new String[2];
   /** Used to format the engineer's name last, first in an array. **/   
      private String[] engineerNameFormat = new String[2];
   /** The numbers of time enteries per project. **/
      private int countA, countB, countC;
   /** An array for the time spent on project A. **/
      private int[] segA = new int[100];
   /** An array for the time spent on project B. **/
      private int[] segB = new int[100];
   /** An array for the time spent on project C. **/
      private int[] segC = new int[100];
   
   /**
   * Count the number of time enteries for each project and saves them
   * to the approriate variable.
   *
   *@param prj character that represents the project being counted.
   *@throws IOException to import the file and read it.
   **/
   
      private void projectCounter(char prj) throws IOException
      {
            
         if (prj == 'A')
         {
            countA++;
         }
         else if (prj == 'B')
         {
            countB++;
         }
         else if (prj == 'C')
         {
            countC++;
         }
        
      }
       /**
   	 * Sets the size of the arrays based on the number
   	 * of time enteries.
   	 **/
      public void changeSize()
      {
         int[] segAIn = new int[countA];
         for (int i = 0; i < countA; i++)
         {
            segAIn[i] = segA[i];
         }
         segA = segAIn;
         int[] segBIn = new int[countB];
         for (int i = 0; i < countB; i++)
         {
            segBIn[i] = segB[i];
         }
         segB = segBIn;
         int[] segCIn = new int[countC];
         for (int i = 0; i < countC; i++)
         {
            segCIn[i] = segC[i];
         }
         segC = segCIn;
         
      }
   
   /**
   * Takes a String input representing the name of the file to be read
   * and parses information from the file. 
   *
   *@param fileName name of the file to be parsed.
   *@throws IOException to import the file and read it.
   **/
   
      public Engineer(String fileName) throws IOException
      {
         String fileNameVar = fileName;
         Scanner afileScanner = new Scanner(new File(fileNameVar));
         String engName = fileName.replace(".csv", "");
         engineerName = engName.split("_");
         engineerNameFormat[0] = engineerName[1];
         engineerNameFormat[1] = engineerName[0];
         String placeholder = afileScanner.nextLine();
         
         int a = 0;
         int b = 0;
         int c = 0;
      	
         while (afileScanner.hasNext())
         {	
            String lines = afileScanner.nextLine();
            String[] splitLine = lines.split(",");
            int[] projectTime = new int[2];
            projectTime[0] = Integer.parseInt(splitLine[1]);
            projectTime[1] = Integer.parseInt(splitLine[2]);
            String projString = (splitLine[0]);
            char projChar = projString.charAt(0);
            projectCounter(projChar);
         
         
            if (projChar == 'A')
            {
               segA[a] = (projectTime[1] - projectTime[0]);
               a++;
            }
            
            else if (projChar == 'B')
            {
               segB[b] = (projectTime[1] - projectTime[0]);
               b++;
            }
            
            else if (projChar == 'C')
            {
               segC[c] = (projectTime[1] - projectTime[0]);
               c++;
            }
         } 
         changeSize();
      }
   
     
     
      /**
   	* Displays the Engineer's first and last name.
   	*
   	*@return returns an arry of String objects 
   	* containing first and last name. 
   	*@throws IOException to import the file and read it.
   	**/
   
      
      public String[] getName() throws IOException
      {
      
      
         return engineerNameFormat;
      }
   	
   	/**
   	* Gets the time the engineer spent working on the project.
   	*
   	*@param projLetter char representing the project the engineer worked on.
   	*@return returns an arry of ints representing the time segments 
   	* on the project.
   	*@throws IOException to import the file and read it.
   	**/
   	
      public int[] getTimeSegments(char projLetter) throws IOException
      {
         int[] empty = new int[0];
         if (projLetter == 'A')
         {
            return segA;  
         }
         else if (projLetter == 'B')
         {
            return segB;
         }
         else if (projLetter == 'C')
         {
            return segC;
         }
         else
         {
            return empty;
         }
         
         
      }
   
      
      
   	/**
   	* Averages the time spent working on the project.
   	*
   	*@param timeseg the time segment that will be averaged 
   	* represented by a char.
   	*@return returns the average time spent on the project.
   	*@throws IOException to import the file and read it.
   	**/
   	
      public double averageTimeSegments(char timeseg) throws IOException
      {
         double avgTime;
         if (timeseg == 'A' || timeseg == 'a')
         {
            avgTime = (totalProjectTime('A') / (double) (countA));  
         }
         else if (timeseg == 'B' || timeseg == 'b')
         {
            avgTime = (totalProjectTime('B') / (double) (countB)); 
         }
         else if (timeseg == 'C' || timeseg == 'c')
         {
            avgTime = (totalProjectTime('C') / (double) (countC)); 
         }
         else if (timeseg == '0')
         {
            int totalTime = (totalProjectTime('A') + totalProjectTime('B')
               + totalProjectTime('C'));
            double totalCount = (countA + countB + countC);
            avgTime = totalTime / totalCount;
         }
         else
         {
            avgTime = -1.0;
         }
         return avgTime;
      }
      
   	/**
   	* Calcualates the total time spent on a project
   	* by all engineers.
   	*
   	*@param projLetter representing the project.
   	*@return the total time spent working on the project.
   	*@throws IOException to import the file and read it.
   	**/
   	
      public int totalProjectTime(char projLetter) throws IOException
      {
         int totalTime = 0;
         int totalTimeTemp = 0;
         if ((projLetter == 'A') || (projLetter == 'a'))
         {
            for (int i = 0; i < countA; i++)
            {
               totalTimeTemp += segA[i];
            }
            totalTime = totalTimeTemp; 
         }
         else if ((projLetter == 'B') || (projLetter == 'b'))
         {
            for (int i = 0; i < countB; i++)
            {
               totalTimeTemp += segB[i];
            }
            totalTime = totalTimeTemp; 
         }
         else if ((projLetter == 'C') || (projLetter == 'c'))
         {
            for (int i = 0; i < countC; i++)
            {
               totalTimeTemp += segC[i];
            }
            totalTime = totalTimeTemp; 
         }
         else
         {
            totalTime = -1;
         }
         return totalTime;
      }
      
   	/**
   	* Displays the project that took the longest time.
   	*
   	*@return the char representing the project that took the longest.
   	*@throws IOException to import the file and read it.
   	**/
   	
      public char longestProject() throws IOException
      {
         char output = 0;
         
         if (totalProjectTime('A') > totalProjectTime('B')
         && totalProjectTime('A') > totalProjectTime('C'))
         {
            output = 'A';
         }
         if (totalProjectTime('B') > totalProjectTime('A') 
         && totalProjectTime('B') > totalProjectTime('C'))
         {
            output = 'B';
         }
         if (totalProjectTime('C') > (totalProjectTime('B')) 
         && totalProjectTime('C') > totalProjectTime('A'))
         {
            output = 'C';
         }
      
         return output;
      }
      
    	/**
   	* Displays the project that took the shortest time.
   	*
   	*@return the char representing the project that took the shortest.
   	*@throws IOException to import the file and read it.
   	**/  	
   	
      public char shortestProject() throws IOException
      {
         char output = 0;
         
         if (totalProjectTime('A') < totalProjectTime('B')
         && totalProjectTime('A') < totalProjectTime('C'))
         {
            output = 'A';
         }
         if (totalProjectTime('B') < totalProjectTime('A') 
         && totalProjectTime('B') < totalProjectTime('C'))
         {
            output = 'B';
         }
         if (totalProjectTime('C') < (totalProjectTime('B')) 
         && totalProjectTime('C') < totalProjectTime('A'))
         {
            output = 'C';
         }
      
         return output;
      }
      
   	/**
   	* Displays the segment that took the longest.
   	*
   	*@return returns the longest time spent on a segment.
   	*@throws IOException to import the file and read it.
   	**/
   // //STOP HERE!!!
      // public int longestSegment() throws IOException
      // {
      // 
         // return 0;
      // }
   // 	
   // 	/**
   // 	* Displays the segment that took the shortest.
   // 	*
   // 	*@return returns the shortest time spent on a segment.
   // 	*@throws IOException to import the file and read it.
   // 	**/
   // 	
      // public int shortestSegment() throws IOException
      // {
      // 
         // return 0;
      // }
   // 	
   // 	/**
   // 	* Shows time segments that are greater than the 
   // 	* segment entered by the user in ascending order.
   // 	*
   // 	*@param seg time segment entered by the user.
   // 	*@return the time segments that are greater than 
   // 	* the param seg.
   // 	*@throws IOException to import the file and read it.
   // 	**/
   // 	
      // public int[] segmentsGreaterThan(int seg) throws IOException
      // {
      // 
         // return null;
      // }
   //    
   // 	/**
   // 	* Shows time segments that are less than the
   // 	* segment entered by the user in decending order.
   // 	*
   // 	*@param seg time segment entered by the user.
   // 	*@return the time segments that are less than
   // 	* the param seg.
   // 	*@throws IOException to import the file and read it.
   // 	**/
   // 	
      // public int[] segmentsLessThan(int seg) throws IOException
      // {
      // 
         // return null;
      // }
   //    
   // 	/**
   // 	* Compares the time spent working of the engineers.
   // 	*
   // 	*
   // 	*@param engObj object of the engineer class.
   // 	*@return Returns the difference of time the engineers spent working.
   // 	*@throws IOException to import the file and read it.
   // 	**/
   // 	
      // public int compareWork(Engineer engObj) throws IOException
      // {
      // 
         // return 0;
      // }
   // 	
   // 	/**
   // 	* Prints engineer's name and their total project.
   // 	* time across all projects
   // 	*
   // 	*@return output the text and format to be printed.
   // 	**/
   // 	
      // public String toString()
      // {
         // String output = "";
      // 
         // return output;
      // }
   // 	
   // 	
   }