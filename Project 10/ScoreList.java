   import java.io.IOException;
   import java.util.Scanner;
   import java.io.File;
  	   	// import java.util.InputMismatchException;
   import java.io.FileNotFoundException;
   import java.io.FileWriter;
   import java.io.BufferedWriter;
   import java.io.PrintWriter;
   import java.util.ArrayList;
  	   	// import java.util.NoSuchElementException;
  	   	// import java.lang.Exception;
  	   	
  	   	/**
  	   	* The program creates a list used to keep track of the top 10
  	   	* scores in winning games.
  	   	* @author Clayton Martin and Joshua Kane - Section 004.
  	   	* @version 4/20/11.
  	   	*/
  	   	
  	   	
   public class ScoreList
   {
      	/** number of scores in the list. **/
      private int numberScores2;
      	/** number of scores in the list. **/
      private int numberScores;
      	/** Array list of score objects. **/
      private ArrayList<Score> scoreList;
      	/** Array of score objects. **/
      private Score[] scoreListA;
      	
      	
      	
      	/**
      	* This method is the constructor. It initializes an empty score list.
      	*/
      public ScoreList()
      {
         scoreList = new ArrayList<Score>();
      	// scoreList = new Score[10];
      	// for (int i = 0; i < 10; i++)
      	// {
      	// // scoreList[i] = (new Score(0));
      	// }
      }
      	
      	/**
      	* Accessor method for the number of scores.
      	*
      	*@return number of scores in the scoreList.
      	**/
      	
      public int getnumScores()
      {
         return numberScores;
      }
      	
      	/**
      	* Accessor method for the scores.
      	*
      	*@return the scoreList.
      	**/
      	
      public ArrayList<Score> getScoreList()
      {
         return scoreList;
      }
      	
      	/**
      	* This method adds a score to the score list.
      	* @param scoreObj - takes scoreObj as a Score parameter.
      	*/
      public void addScore(Score scoreObj)
      {
         numberScores2 = 0;
         numberScores = 0;
         Score hold;
      	
         if (scoreList.size() < 10)
         {
            scoreList.add(scoreObj);
         }
         
         else
         {
            for (int i = 0; i < 10; i++)
            {
               if (scoreList.get(i).compareTo(scoreObj) == -1)
               {
                  hold = scoreList.get(i);
                  scoreList.set(scoreList.indexOf(hold), scoreObj);
                  scoreObj = hold;
               }
            }
         }
      	
      	//
      	// for (int i = 0; i < 10; i++)
      	// {
      	// if (scoreList.get(i) != null)
      	// {
      	// numberScores2++;
      	// }
      	// }
      	
      	
      	// if (numberScores2 < 10)
      	// {
      	// scoreList.set(numberScores2, scoreObj);
      	//
      	// }
      	// else // if (numberScores2 >= 10)
      	// {
      	// int i = 0;
      	// for (int j = 1; j < 10; j++)
      	// {
      	// if (scoreList.get(i).getAccuracy()
      	//> scoreList.get(j).getAccuracy())
      	// {
      	// i = j;
      	// }
      	// }
      	//
      	// if (scoreList.get(i).getAccuracy() < scoreObj.getAccuracy())
      	// {
      	// scoreList.set(i, scoreObj);
      	// }
      	// }
      	//
      	// for (int i = 0; i < 10; i++)
      	// {
      	// if (scoreList.get(i) != null)
      	// {
      	// numberScores++;
      	// }
      	// }
      	//
      }
      	/**
      	* This method sorts the score list in descending order.
      	* @return -
      	*/
      	
      	
      public Score[] getSortedScores()
      {
         int min;
         Score temp;
         for (int i = 0; i < scoreList.size(); i++)
         {
            min = i;
            for (int j = i + 1; j < scoreList.size(); j++)
            {
               if (scoreList.get(j).compareTo(scoreList.get(min)) > 0)
               {
                  min = j;
               }
            }
         
            temp = scoreList.get(min);
            scoreList.set(min, scoreList.get(i));
            scoreList.set(i, temp);
         }
      	
      	// for (int i = 1; i < numberScores; i++)
      	// {
      	// int toInsert = scoreList[i];
      	// int j = i;
      	// while ((j > 0) && (scoreList[j - 1] > toInsert))
         scoreListA = new Score[scoreList.size()];
         for (int i = 0; i < scoreList.size(); i++)
         {
            scoreListA[i] = scoreList.get(i);
         }
      	
      	
         return scoreListA;
      }
      	/**
      	* Loads scores from a file and decides if the file can be read.
      	* @param fileName - String parameter called fileName.
      	* @return int - returns an integer.
      	*/
      public int loadFromFile(String fileName)
      {
         scoreList = new ArrayList<Score>();
      	// ArrayList<Double> scoresScanned = null;
         try
         {
            Scanner scan = new Scanner(new File(fileName));
         // scoresScanned = new ArrayList<Double>();
            while (scan.hasNext())
            {
            // scoresScanned.add(Double.parseDouble(scan.nextLine()));
               scoreList.add(new Score(Double.parseDouble(scan.nextLine())));
            }
         
            scoreListA = new Score[scoreList.size()];
            for (int i = 0; i < scoreList.size(); i++)
            {
               scoreListA[i] = scoreList.get(i);
            }
         }
            catch (FileNotFoundException e)
            {
               return 1;
            }
            catch (NumberFormatException e)
            {
               scoreList.clear();
               return 2;
            }
      	
      	
      	// for (int i = 0; i < scoresScanned.size(); i++)
      	// {
      	// scoreList.set(i, new Score(scoresScanned.get(i)));
      	//
      	// numberScores = scoresScanned.size();
      	// }
         return 0;
      }
      	/**
      	* This method simply writes all score values in the ScoreList object
      	* to the file (1 per line), replacing the file if it already exists.
      	* @param fileName1 - String parameter called fileName1.
      	* @return boolean - returns a boolean value (true or false).
      	*/
      	
      	
      public boolean writeToFile(String fileName1)
      {
         boolean fileWritten = false;
         int nameLength = fileName1.length();
         int fileLength = (nameLength - 4);
         String extentionCheck = fileName1.substring(fileLength, nameLength);
         String check = ".DAT";
         String check1 = ".dat";
      	
         if (extentionCheck.equals(check) || extentionCheck.equals(check1))
         {
            fileWritten = true;
            try
            {
               int max = 10;
               double value;
               String file = fileName1;
               int i = 0;
            
               FileWriter fw = new FileWriter(file);
               BufferedWriter bw = new BufferedWriter(fw);
               PrintWriter outFile = new PrintWriter(bw);
            // while (scoreList.length < max)
            // {
            // for (int line = 0; line <= numberScores; line++)
            // {
               for (int num = 0; num <= numberScores2; num++)
               {
               // value = scoreList[num].getAccuracy();
               // i++;
                  outFile.println(scoreList.get(num).getAccuracy());
               }
            // outFile.println();
            // }
            
               outFile.close();
            // }
            // System.out.println("Output file has been created: " + file);
            }
               catch (IOException error)
               {
                  return false;
               }
         }
         else
         {
            FileNameException problem =
               new FileNameException(fileName1);
            throw problem;
         // return false;
         
         
         }
         return true;
      }
      	
   }