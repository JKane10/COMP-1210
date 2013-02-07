 /**
 * Represents an opponent that is playing against a human. 
 * 
 * @author Joshua Kane and Clayton Martin - 004.
 * @version 4/6/11
 **/ 
   
   
   public class PlayerOpponent extends Opponent
   {
   /** name of the player. **/
      private String playerName;
   /** 2d array of bomb buttons representing the board. **/
      private BombButton[][] grid;
   
   /**
   * Creates default opponent.
   **/
   
      public PlayerOpponent()
      {
      
         super(DEFAULT_HEIGHT);
         grid = getGrid();
      }
   
   /**
   * Creates a CPU opponent.
   * @param gridHeight - int parameter that represents the grid height.
   **/
   
      public PlayerOpponent(int gridHeight)
      {
      
         super(gridHeight);
         playerName = "CPU";
         grid = getGrid();
      }
      
   /**
   * Creates a player opponent with a set name.
   * @param gridHeight - int parameter that represents the height
   * of the grid.
   * @param nameIn - String parameter that represents the player 
   * name.
   **/
   
      public PlayerOpponent(int gridHeight, String nameIn)
      {
      
         super(gridHeight);
         playerName = nameIn;
         grid = getGrid();
      
      }
      
   	/**
   	* Gives player a turn, depending on whether the 
   	* opponent is another player or the CPU.
   	* @param row - int that represents the row.
   	* @param col - int represents the column the player would like to bomb.
   	* @return boolean - whether or not the row and column were in bounds
   	* and the button at the location was available.
   	**/
      
      public boolean giveTurn(int row, int col)
      {
      
      
      
         return super.giveTurn(row, col);
      } 
     /** String represntation of BombButton grid, targets are X's
   	* empty locations are O's.
   	*
   	* @return string representation of grid.
   	**/
   
      public String toString()
      {
         String output = "Name: " + playerName + "\n";
         for (int row = 0; row < grid.length; row++)
         {
            for (int col = 0; col < grid[row].length; col++)
            {
               BombButton spot = grid[row][col];
               if (spot.getText() == "X" || spot.getText() == "O")
               {
               
                  if (spot.getCategory() == EMPTY)
                  {
                     output += "O\t";
                  }
                  else if (spot.getCategory() == TARGET)
                  {
                     output += "X\t";
                  }
               }
               else
               {
                  output += "-\t";
               }
               
              
               
            }
            output += "\n";
         } 
         return output;
      }
   
   }