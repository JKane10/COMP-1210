	
	/**
   * Helps determine the players accuracy information.
   * @author Clayton Martin and Joshua Kane - Section 004.
   * @version 4/13/11
   */
   public class Score implements Comparable<Score>
   {
   /** Total number of targets hit in player's grid divided by 
   * the total number of hits made. **/
      private double playerAccuracy = 0;
   /** game board. **/
      private BombButton[][] grid3;
      
      // int hits = 0;
      // int misses = 0;
      
   /**
   * Constructor that sets playerAccuracyIn to playerAccuracy.
   * @param playerAccuracyIn - takes playerAccuracyIn as a double.
   */
      
      public Score(double playerAccuracyIn)
      {
         playerAccuracy = playerAccuracyIn;
      }
      
   	
   	/**
      * Constructor that sets playerAccuracy to the default, which is 0.
      */
      
      public Score()
      {
         playerAccuracy = 0;
      }
      
      /**
      * CompareTo method that compares two Score objects based on accuracy.
      * @param scoreIn - a Score object.
      * @return int - returns -1 if accuracy is less than, 0 if equal, 
      * and 1 if greater.
      */
      public int compareTo(Score scoreIn)  
      {
         double thisAccuracy = this.getAccuracy();
         double otherAccuracy = scoreIn.getAccuracy();
         int compared = 0;
         if (thisAccuracy > otherAccuracy)
         {
            compared = 1;
         }
         else if (thisAccuracy < otherAccuracy)
         {
            compared = -1;
         }
         else
         {
            compared = 0;
         }
         
      
         return compared;
      }
    
   
      /**
      * Returns the accuracy stored in the object as a double.
      * @return double - returns the accuracy as a double. 
      */
      public double getAccuracy()
      {
         return playerAccuracy; 
      }
      
      /**
      * Takes an Opponent object and updates the accuracy to reflect
      * that player's grid.
      * @param obj - Opponent object.
      */
      
      public void opponentInfo(Opponent obj)
      {
         double hits = 0;
         double misses = 0;  
         grid3 = obj.getGrid();
         for (int x = 0; x < grid3.length; x++)
         {
            for (int y = 0; y < grid3[x].length; y++)
            {
               if (!grid3[x][y].isAvailable())
               {
                  if (grid3[x][y].getCategory() == BombButton.EMPTY)
                  {	
                     misses++;
                  }
                  else if (grid3[x][y].getCategory() == BombButton.TARGET)
                  {
                     hits++;
                  }
               }
            }
         }
         if (hits + misses >= 0)
         {
            playerAccuracy = (hits / (hits + misses));
         }
      }	   
   }
	
