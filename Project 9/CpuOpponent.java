   import java.util.Random;
   
	/**
   * Forming the basics for the workings of the human player.
   * @author Clayton Martin and Joshua Kane - Section 004.
   * @version 4/13/11
   */
   public class CpuOpponent extends Opponent
   {
      /** name of the player. **/
      private String playerName;
      /** 2d array of bomb buttons representing the board. **/
      private BombButton[][] grid1;
   //    /** current number of ships on the board. **/
      // private int currentShipSpace;
   //    /** limit of ships that can be on the board based on height. **/
      // private double shipLimit;
   	/** shots fired. **/
      private int shotsFire = 0;
      /** default shipLocation. **/
      private int[] shipLocation = { -1, -1, -1};
   
   	
     	/**
      * One of three constructors. Sets playerName to Anonymous. 
      */
      
      public CpuOpponent()
      {
         super(DEFAULT_HEIGHT);
         playerName = "Anonymous";
         grid1 = getGrid();
      }
      /**
      * Second of three constructors. Sets playerName to Anonymous.
      * @param gridHeight - parameter represented as an int.
      */
      
      public CpuOpponent(int gridHeight)
      {
         super(gridHeight);
         playerName = "Anonymous";
         grid1 = getGrid();
      }
      
      /**
      * Third of three constructors.
      * @param gridHeight - parameter represented as an int.
      * @param nameIn - parameter represented as a String.
      */
      public CpuOpponent(int gridHeight, String nameIn)
      {        
         super(gridHeight);
         grid1 = getGrid();
         playerName = nameIn;
      }
      
      /**
      * Determing the actions of the computer against the human player.
      * @param row - parameter represented as an int.
      * @param col - parameter represented as an int.
      * @return boolean - whether or not the row and column were in bounds
   	 * and the button at the location was available.
      */
      public boolean giveTurn(int row, int col)     
      {
         boolean k = true;
         if (row >= 0 && col >= 0)
         {
         
            return super.giveTurn(row, col);
         }
         else
         {
            int stop = 0;
            Random generator1 = new Random();
            while (stop == 0)
            {
            // gives random row coordinate.
               row = generator1.nextInt(grid1.length);
            // gives random column coordinate.
               col = generator1.nextInt(grid1.length);
               if (grid1[row][col].isAvailable())
               {
                  shotsFire += 1;
                  stop += 1;
                  k = super.giveTurn(row, col);
               }
            } 
            return k;  
         }
      }
     /** Allows players to see boats.
     * @param height - represents an int parameter.
     */
     
     
      public void reset(int height)
      {
         super.grid = new BombButton[height][height];
         int i = 0;
         for (int row = 0; row < grid.length; row++)
         {
            for (int col = 0; col < grid[row].length; col++)
            {
               super.grid[row][col] = new BombButton();
               super.grid[row][col].setShowing(true);
            }
         }	
         shipLimit = (0.20 * (height * height));
         currentShipSpace = 0;
      }
      
   	
   	   	/** Places ship at random location in the grid with a random
   	* alignment.
   	* @param ship type of ship to be added.
   	* @return an array of 3 ints.
   	**/
   	
      public int[] placeRandomShip(int ship)
      {
         int stopcheck = 0;
         Random generator = new Random();
         int angle = generator.nextInt(2);
         while (stopcheck == 0) {
            if (ship == PT_BOAT) {
               if (angle == 0 && (currentShipSpace + 2) <= shipLimit) {
                  int rowLoc = generator.nextInt(grid.length);
                  int colLoc = generator.nextInt(grid.length - 1);
                  if (grid[rowLoc][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc][colLoc + 1].getCategory() == EMPTY) {
                     grid[rowLoc][colLoc].setCategory(TARGET);
                     grid[rowLoc][colLoc].setText("X");
                     grid[rowLoc][colLoc + 1].setCategory(TARGET);
                     grid[rowLoc][colLoc + 1].setText("X");
                     stopcheck = 1; 
                     currentShipSpace += 2;
                     int[] tempShipLocation = {rowLoc, colLoc, angle}; 
                     shipLocation = tempShipLocation; }
               }
               else if (angle == 1 && (currentShipSpace + 2) <= shipLimit) {
                  int rowLoc = generator.nextInt(grid.length - 1);
                  int colLoc = generator.nextInt(grid.length);
                  if (grid[rowLoc][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc + 1][colLoc].getCategory() == EMPTY) {
                     grid[rowLoc][colLoc].setCategory(TARGET);
                     grid[rowLoc][colLoc].setText("X");
                     grid[rowLoc + 1][colLoc].setCategory(TARGET);
                     grid[rowLoc + 1][colLoc].setText("X");
                     stopcheck = 1; 
                     currentShipSpace += 2;
                     int[] tempShipLocation = {rowLoc, colLoc, angle}; 
                     shipLocation = tempShipLocation; }  
               }
               else {
                  int[] tempShipLocation = {-1, -1, -1}; 
                  shipLocation = tempShipLocation;
                  stopcheck = 1; 
                  return shipLocation; }
            }
            else if (ship == CRUISER) {
               if (angle == 0 && (currentShipSpace + 3) <= shipLimit) {
                  int rowLoc = generator.nextInt(grid.length);
                  int colLoc = generator.nextInt(grid.length - 2);
                  if (grid[rowLoc][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc][colLoc + 1].getCategory() == EMPTY
                  && grid[rowLoc][colLoc + 2].getCategory() == EMPTY) {
                     grid[rowLoc][colLoc].setCategory(TARGET);
                     grid[rowLoc][colLoc].setText("X");
                     grid[rowLoc][colLoc + 1].setCategory(TARGET);
                     grid[rowLoc][colLoc + 1].setText("X");
                     grid[rowLoc][colLoc + 2].setCategory(TARGET);
                     grid[rowLoc][colLoc + 2].setText("X");
                     stopcheck = 1;
                     currentShipSpace += 3; 
                     int[] tempShipLocation = {rowLoc, colLoc, angle}; 
                     shipLocation = tempShipLocation; }
               }
               else if (angle == 1 && (currentShipSpace + 3) <= shipLimit) {
                  int rowLoc = generator.nextInt(grid.length - 2);
                  int colLoc = generator.nextInt(grid.length);
                  if (grid[rowLoc][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc + 1][colLoc].getCategory() == EMPTY
                  && grid[rowLoc + 2][colLoc].getCategory() == EMPTY) {
                     grid[rowLoc][colLoc].setCategory(TARGET);
                     grid[rowLoc][colLoc].setText("X");
                     grid[rowLoc + 1][colLoc].setCategory(TARGET);
                     grid[rowLoc + 1][colLoc].setText("X");
                     grid[rowLoc + 2][colLoc].setCategory(TARGET);
                     grid[rowLoc + 2][colLoc].setText("X");
                     stopcheck = 1;  
                     currentShipSpace += 3;      
                     int[] tempShipLocation = {rowLoc, colLoc, angle}; 
                     shipLocation = tempShipLocation; }
               } 
               else {
                  int[] tempShipLocation = {-1, -1, -1}; 
                  shipLocation = tempShipLocation; 
                  stopcheck = 1; 
                  return shipLocation; }
            }
            else if (ship == BATTLESHIP) {
               if (angle == 0  && (currentShipSpace + 4) <= shipLimit) {
                  int rowLoc = generator.nextInt(grid.length);
                  int colLoc = generator.nextInt(grid.length - 3);
                  if (grid[rowLoc][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc][colLoc + 1].getCategory() == EMPTY
                  && grid[rowLoc][colLoc + 2].getCategory() == EMPTY 
                  && grid[rowLoc][colLoc + 3].getCategory() == EMPTY) {
                     grid[rowLoc][colLoc].setCategory(TARGET);
                     grid[rowLoc][colLoc].setText("X");
                     grid[rowLoc][colLoc + 1].setCategory(TARGET);
                     grid[rowLoc][colLoc + 1].setText("X");
                     grid[rowLoc][colLoc + 2].setCategory(TARGET);
                     grid[rowLoc][colLoc + 2].setText("X");
                     grid[rowLoc][colLoc + 3].setCategory(TARGET);
                     grid[rowLoc][colLoc + 3].setText("X");
                     stopcheck = 1;
                     currentShipSpace += 4;
                     int[] tempShipLocation = {rowLoc, colLoc, angle}; 
                     shipLocation = tempShipLocation; }
               }
               else if (angle == 1  
               && (currentShipSpace + 4) <= shipLimit) {
                  int rowLoc = generator.nextInt(grid.length - 3);
                  int colLoc = generator.nextInt(grid.length);
                  if (grid[rowLoc][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc + 1][colLoc].getCategory() == EMPTY
                  && grid[rowLoc + 2][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc + 3][colLoc].getCategory() == EMPTY)
                  {
                     grid[rowLoc][colLoc].setCategory(TARGET);
                     grid[rowLoc][colLoc].setText("X");
                     grid[rowLoc + 1][colLoc].setCategory(TARGET);
                     grid[rowLoc + 1][colLoc].setText("X");
                     grid[rowLoc + 2][colLoc].setCategory(TARGET);
                     grid[rowLoc + 2][colLoc].setText("X");
                     grid[rowLoc + 3][colLoc].setCategory(TARGET);
                     grid[rowLoc + 3][colLoc].setText("X");
                     stopcheck = 1;
                     currentShipSpace += 4;
                     int[] tempShipLocation = {rowLoc, colLoc, angle}; 
                     shipLocation = tempShipLocation; 
                  }
               }
               else
               {
                  int[] tempShipLocation = {-1, -1, -1}; 
                  shipLocation = tempShipLocation; 
                  stopcheck = 1; 
                  return shipLocation;
               }  
            }
            else
            {
               int[] tempShipLocation = {-1, -1, -1}; 
               shipLocation = tempShipLocation; 
               stopcheck = 1; 
               return shipLocation;   
            }
         }
         return shipLocation;  
      }
   	
      // public String toString()
      // {
         // String output = "Name: " + playerName + "\n";
         // for (int row = 0; row < grid.length; row++)
         // {
            // for (int col = 0; col < grid[row].length; col++)
            // {
               // BombButton spot = grid[row][col];
               // if (spot.getText() == "X" || spot.getText() == "O")
               // {
                  // if (spot.getCategory() == EMPTY)
                  // {
                     // output += "O\t";
                  // }
                  // else if (spot.getCategory() == TARGET)
                  // {
                     // output += "X\t";
                  // }
               // }
               // else
               // {
                  // output += "-\t";
               // }
            // }
            // output += "\n";
         // } 
         // return output;
      // }
   	
   }