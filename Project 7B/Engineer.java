   import java.io.IOException;
   import java.util.Scanner;
   import java.io.File;
   import java.util.Arrays;
   
	/**
	* This program finds different imformation about time worked 
	* on three separate projects.
  	* Project_7A
	* @author Clayton Martin and Joshua Kane - Section 004
	* @version 3/1/11
	*/
   
   public class Engineer 
   {
   /** Arrays storing project data. **/
      private int[] projectA, projectB, projectC; 
   /** Arrays storing data for segments. **/
      private int[] greaterSegments, lesserSegments;
   /** Int for total time. **/
      private int totalTime;
   /** String array for output. **/
      private String[] output;
   /** String array for engineer's name. **/
      private String[] name;
      /** non array variable for name first space last. **/
      private String name2;
      /** 	  
   	* This method takes a file and parses through the information.
   	* @param fileName - takes fileName as a string.
   	* @throws IOException - thrown by a file.
   	*/
      public Engineer(String fileName) throws IOException
      {
         Scanner fileScan = new Scanner(new File(fileName));
         int countA = 0, countB = 0, countC = 0, timeCountA = 0;
         int timeCountB = 0, timeCountC = 0;
         while (fileScan.hasNext()) 
         {
            String[] proj = fileScan.next().split("\\,");
            if (proj[0].equals("A") || proj[0].equals("a"))
            {
               countA++;
            }  
            else if (proj[0].equals("B") || proj[0].equals("b"))
            {
               countB++;
            }	
            else if (proj[0].equals("C") || proj[0].equals("c"))
            { 
               countC++;
            } 
         }
         projectA = new int[countA];
         projectB = new int[countB];
         projectC = new int[countC];
         fileScan = new Scanner(new File(fileName));
         while (fileScan.hasNext())
         {
            String[] proj = fileScan.next().split("\\,");
            if (proj[0].equals("A") || proj[0].equals("a")) 
            {
               projectA[timeCountA] = (Integer.parseInt(proj[2]))
                  - (Integer.parseInt(proj[1]));
               timeCountA++;
            }
            else if (proj[0].equals("B") || proj[0].equals("b"))
            {
               projectB[timeCountB] = (Integer.parseInt(proj[2]))
                  - (Integer.parseInt(proj[1]));
               timeCountB++;
            }
            else if (proj[0].equals("C") || proj[0].equals("c")) 
            {
               projectC[timeCountC] = (Integer.parseInt(proj[2]))
                  - (Integer.parseInt(proj[1]));
               timeCountC++;
            }
         }
         fileName = fileName.replace(".csv", "");
         name = fileName.split("_");
         name2 = name[0] + " " + name[1];
         String output1 = "";
         String name1 = name[1] + "," + name[0];
      
         name = name1.split(",");
         totalTime = (totalProjectTime('A') 
            + totalProjectTime('B') + totalProjectTime('C'));
      }
      /**
      * This method parses through the file and then gives the name 
   	* of the engineer.
      * @throws IOException - thrown by a file.
   	* @return name - returns name as a string[].
      */
      public String[] getName()throws IOException
      {
         return name;
      }
    
    /**
    * method to give the GUI a formated name.
    *
    *@return name2 the name in a format for the GUI.
    **/  
   	
      public String getNameGUI()
      {
         return name2;
      }
   
   	
      /**
      * This method gets the time segments for the projects of
   	* the engineer.
      * @param projectIn - takes in projectIn as a char parameter.
      * @return time - returns time as an int[].
      */
      public int[] getTimeSegments(char projectIn)
      {
         int[] time;
         switch(projectIn)
         {
            case 'A' :
            case 'a' :
               time = projectA;
               break;
            case 'B' :
            case 'b' :
               time = projectB;
               break;
            case 'C' :
            case 'c' :
               time = projectC;
               break;
            default:
               time = new int[0];   
         }
         return time;	
      }
      
   	
      /**
    	* This method finds the average time for each segment.
      * @param averageTimeIn - takes in averageTimeIn as a char parameter.
      * @return average - returns average as a double.
   	* @throws IOException - thrown by a file.
      */
      public double averageTimeSegments(char averageTimeIn) throws IOException
      {
         double average;
         double sumA = 0, sumB = 0, sumC = 0;
         for (int i = 0; i < projectA.length; i++)
         {
            sumA += projectA[i];
         }
         for (int i = 0; i < projectB.length; i++)
         {
            sumB += projectB[i];
         }
         for (int i = 0; i < projectC.length; i++)
         {
            sumC += projectC[i];
         }
         switch(averageTimeIn)
         {
            case 'A' :
            case 'a' :
               average = sumA / projectA.length;
               break;
            case 'B' :
            case 'b' :
               average = sumB / projectB.length;
               break;
            case 'C' :
            case 'c' :
               average = sumC / projectC.length;
               break;
            case '0' :
               average = (sumA + sumB + sumC) 
                  / (projectA.length + projectB.length + projectC.length);
            default:
               average = -1.0;
         }
         return average;	
      		
      }
      /**
      * This method finds the total time worked on all projects.
      * @param projectIn3 - takes projectIn3 as a char[] parameter.
      * @return sum - returns sum as an int.
   	* @throws IOException - thrown by a file.
      */
      public int totalProjectTime(char projectIn3)throws IOException
      {
         double sum = 0;       
         switch(projectIn3)
         {
            case 'A':
            case 'a':
               for (int i = 0; i < projectA.length; i++)
               {
                  sum += projectA[i];
               }
               break;
            case 'B':
            case 'b':
               for (int i = 0; i < projectB.length; i++)
               {
                  sum += projectB[i];
               }
               break;
            case 'C':
            case 'c':
               for (int i = 0; i < projectC.length; i++)
               {
                  sum += projectC[i];
               }
               break;
            default:
               sum = -1.0;
         }
         return (int) sum;
      }
      /**
      * This method finds the longest project.
      * @return longestProj - returns longestProj as a char.
   	* @throws IOException - thrown by a file.
      */
      public char longestProject()throws IOException
      {
         char longestProj = ' ';
         double sumA = 0, sumB = 0, sumC = 0;
         for (int i = 0; i < projectA.length; i++)
         {
            sumA += projectA[i];
         }
         for (int i = 0; i < projectB.length; i++)
         {
            sumB += projectB[i];
         }
         for (int i = 0; i < projectC.length; i++)
         {
            sumC += projectC[i];
         }
         if (sumA > sumB && sumA > sumC)
         {
            longestProj = 'A';
         }	
         else if (sumB > sumA && sumB > sumC)
         {
            longestProj = 'B';
         }
         else if (sumC > sumB && sumC > sumA)
         {
            longestProj = 'C';
         }
         return longestProj;
      }
      /**
      * This method finds the shortest project.
      * @return shortestProj - returns shortestProj as a char.
   	* @throws IOException - thrown by a file
      */
      public char shortestProject()throws IOException
      {
         char shortestProj = ' ';
         double sumA = 0, sumB = 0, sumC = 0;
         for (int i = 0; i < projectA.length; i++)
         {
            sumA += projectA[i];
         }
         for (int i = 0; i < projectB.length; i++)
         {
            sumB += projectB[i];
         }
         for (int i = 0; i < projectC.length; i++)
         {
            sumC += projectC[i];
         }
         
         if (sumA < sumB && sumA < sumC)
         {
            shortestProj = 'A';
         }	
         else if (sumB < sumA && sumB < sumC)
         {
            shortestProj = 'B';
         }
         else if (sumC < sumB && sumC < sumB)
         {
            shortestProj = 'C';
         }
         return shortestProj;
      }
      /** 
      * This method finds which segment is the longest.
      * @return longestSeg - returns longestSeg as an int.
   	* @throws IOException - thrown by a file.
      */
      public int longestSegment()throws IOException
      {
         int longestSegA = projectA[0];
         int longestSeg = 0;
         for (int i = 1; i < projectA.length; i++)
         {
            if (projectA[i] > longestSegA)
            {
               longestSegA = projectA[i];
            }
         }
         int longestSegB = projectB[0];
         for (int i = 1; i < projectB.length; i++)
         {
            if (projectB[i] > longestSegB)
            {
               longestSegB = projectB[i];
            }
         }
          
         int longestSegC = projectC[0];
         for (int i = 1; i < projectC.length; i++)
         {
            if (projectC[i] > longestSegC)
            {
               longestSegC = projectC[i];
            }
         }
         if (longestSegA > longestSegB && longestSegA > longestSegC)
         {
            longestSeg = longestSegA;
         }
         else if (longestSegB > longestSegA && longestSegB > longestSegC)
         {
            longestSeg = longestSegB;
         }
         else if (longestSegC > longestSegA && longestSegC > longestSegB)
         {
            longestSeg = longestSegC;
         }			
         
         return longestSeg;
      }
      /**
      * This method finds which working time segment is the shortest.
      * @return shortestSeg - returns shortestSeg as an int.
   	* @throws IOException - thrown by a file.
      */
      public int shortestSegment()throws IOException
      {
         int shortestSeg = 0;
         int shortestSegA = projectA[0];
         for (int i = 1; i < projectA.length; i++)
         {
            if (projectA[i] < shortestSegA)
            {
               shortestSegA = projectA[i];
            }
         }   
         int shortestSegB = projectB[0];
         for (int i = 1; i < projectB.length; i++)
         {
            if (projectB[i] < shortestSegB)
            {
               shortestSegB = projectB[i];
            }
         }
         int shortestSegC = projectC[0];
         for (int i = 1; i < projectC.length; i++)
         {
            if (projectC[i] < shortestSegC)
            {
               shortestSegC = projectC[i];
            }
         }
         if (shortestSegA < shortestSegB && shortestSegA < shortestSegC)
         {
            shortestSeg = shortestSegA;
         }
         else if (shortestSegB < shortestSegA && shortestSegB < shortestSegC)
         {
            shortestSeg = shortestSegB;
         }
         else if (shortestSegC < shortestSegA && shortestSegC < shortestSegB)
         {
            shortestSeg = shortestSegC;
         }	   
         return shortestSeg;
      }
   
   
   
   
   	/**
      * This method gives the segments that are greater than the user's
      * input.
      * @param segmentValueGreaterIn - takes segmentValueGreaterIn as
      * an int parameter.
      * @return segsGreaterThan - returns segsGreaterThan as an int[].
   	* @throws IOException - thrown by a file
      */
      
      
      public int[] segmentsGreaterThan(int segmentValueGreaterIn)
      throws IOException
      { 
         int length = (projectA.length + projectB.length + projectC.length);
         int[] segments = new int[length];
         int numseg = 0;
         
         for (int i = 0; i < projectA.length; i++)
         {
            segments[i] = projectA[i];
         }
         int j = 0;
         for (int i = projectA.length; i < (projectA.length 
         + projectB.length); i++)
         {
            segments[i] = projectB[j];
            j++;
         }
         int k = 0;
         for (int i = (projectA.length + projectB.length); i < length; i++)
         {
            segments[i] = projectC[k];
            k++;
         }
         
         for (int i = 0; i < length; i++)
         {
            if (segments[i] > segmentValueGreaterIn)
            {
               numseg++;
            }
         }
      	
      	
         int[] greaterSegmentsIn = new int[numseg];
         int l = 0;
         for (int i = 0; i < length; i++)
         {
            if (segments[i] > segmentValueGreaterIn)
            {
               greaterSegmentsIn[l] = segments[i];
               l++;
            }
            greaterSegments = new int[numseg];
            greaterSegments = greaterSegmentsIn;
         
         }  
      	
         Arrays.sort(greaterSegments);
         
         return greaterSegments;
      }
      /**
      * This method gives the segments that are less than the user's
      * input.
      * @param segmentValueLessIn - takes segmentValueLessIn as
      * an int parameter.
      * @return segsLessThan - returns segsLessThan as an int[].
      * @throws IOException - thrown by a file
   	*/
      
      
      public int[] segmentsLessThan(int segmentValueLessIn)throws IOException
      {
         int length = (projectA.length + projectB.length + projectC.length);
         int[] segments = new int[length];
         int numseg = 0;
         
         for (int i = 0; i < projectA.length; i++)
         {
            segments[i] = projectA[i];
         }
         int j = 0;
         for (int i = projectA.length; i < (projectA.length 
         + projectB.length); i++)
         {
            segments[i] = projectB[j];
            j++;
         }
         int k = 0;
         for (int i = (projectA.length + projectB.length); i < length; i++)
         {
            segments[i] = projectC[k];
            k++;
         }
         
         for (int i = 0; i < length; i++)
         {
            if (segments[i] < segmentValueLessIn)
            {
               numseg++;
            }
         }
      	
      	
         int[] lesserSegmentsIn = new int[numseg];
         int l = 0;
         for (int i = 0; i < length; i++)
         {
            if (segments[i] < segmentValueLessIn)
            {
               lesserSegmentsIn[l] = segments[i];
               l++;
            }
            lesserSegments = new int[numseg];
            lesserSegments = lesserSegmentsIn;
         
            Arrays.sort(lesserSegments);
         }  
      	
         return lesserSegments;
      
      
      
      }
      
   	/**
   	* This is an accessor method for total time for 
   	* the compareWork method.
   	*
   	*@return totalTime value of total time spent on all projects.
   	**/
   	
      public int getTotalTime()
      {
         return totalTime;
      }  
   	
      /**
      * This method determines which engineer (obj) has the most
      * total time for all projects.
   	* @param engObj - takes engObj as an object
      * @return compWork - returns compWork as an int.
   	* @throws IOException - thrown by a file.
      */
   
      
      public int compareWork(Engineer engObj)throws IOException
      {
         int compared;
         if (this.getTotalTime() < engObj.getTotalTime())
         {
            compared = -1; 
         }
         else if (this.getTotalTime() == engObj.getTotalTime())
         {
            compared = 0;
         } 
         else
         {
            compared = 1;
         }
         return compared;
      }
   
   
     /**
     * formats the time segments for the GUI.
     *
     *@param projectIn tells which project is being called.
     *@return time returns time in a format for GUI.
     **/
     
      public String getTimeSegmentsGUI(char projectIn)
      {
         String time = "";
         switch(projectIn)
         {
            case 'A' :
               
               // String time = "";
               for (int i = 0; i < projectA.length; i++)
               {
                  time += ("- " + projectA[i] + " minutes\r\n");
                  
               }
               // return time;
               break;
               
            case 'B' :
               
               // String time = "";
               for (int i = 0; i < projectB.length; i++)
               {
                  time += ("- " + projectB[i] + " minutes\r\n");
                  
               }
               // return time;
               break;
               
            case 'C' :
               
               // String time = "";
               for (int i = 0; i < projectC.length; i++)
               {
                  time += ("- " + projectC[i] + " minutes\r\n");
                  
               }
               // return time;
               break;      
                  
            default:
               time = null;
               // return time;
         
         }	
         return time;
      }
     
     /**
     * This method adds the time segments for a specific project.
     *
     * @param projectIn4 - takes projectIn4 as a char parameter.
     * @param arrayTimeSegments - takes arrayTimeSegments as a set
     * of int values.
     * @return boolean - returns true or false. If true, it adds the values
     * for the specified array.
     * @throws IOException - thrown by a file.
     **/
      public boolean addTimeSegments(char projectIn4, int ... arrayTimeSegments)
      	throws IOException
      {
      
         switch(projectIn4)
         {
            case'A':
            case'a':
               int origLength = projectA.length;
               int length = arrayTimeSegments.length + projectA.length;
               int[] projectATemp = projectA;
               projectA = new int[length];
               int j = 0;
               for (int i = 0; i < origLength; i++)
               {
               
                  projectA[i] = projectATemp[i];
               
               }  
            	
               for (int i = origLength; i < length; i++)
               {
               
                  projectA[i] = arrayTimeSegments[j];
                  j++;
               
               }
            
               return true;
               
            case 'B':
            case 'b':
               int origLength1 = projectB.length;
               int length1 = arrayTimeSegments.length + projectB.length;
               int[] projectBTemp = projectB;
               projectB = new int[length1];
               int k = 0;
               for (int i = 0; i < origLength1; i++)
               {
               
                  projectB[i] = projectBTemp[i];
               
               }  
            	
               for (int i = origLength1; i < length1; i++)
               {
               
                  projectB[i] = arrayTimeSegments[k];
                  k++;
               
               }
            
            
               return true;
         
         
            case 'C':
            case 'c':
               int origLength2 = projectC.length;
               int length2 = arrayTimeSegments.length + projectC.length;
               int[] projectCTemp = projectC;
               projectA = new int[length2];
               int f = 0;
               for (int i = 0; i < origLength2; i++)
               {
               
                  projectC[i] = projectCTemp[i];
               
               }  
            	
               for (int i = origLength2; i < length2; i++)
               {
               
                  projectA[i] = arrayTimeSegments[f];
                  f++;
               
               }
            
            
            
            
               return true;
         
         
            default:
               return false;
         }
      }
     
     
     
     
     /**
     * This method returns the engineer's name and their total project 
     * time across all projects in the following format. 
     * @return str - returns str as a string parameter.
     */
     
      public String toString()//throws IOException
      {
         String str = "";
         str = name2 + "\r\n" + "Total Time Spent: " + totalTime + " Minutes";
         
         return str;
      }
   
   
   
   
   
   }  
