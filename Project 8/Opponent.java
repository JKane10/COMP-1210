   import javax.swing.JPanel;
   import java.util.Random;
   import java.awt.GridLayout;
   // import javax.swing.JButton;

	
 /**
 * Abstract that holds functionality for both types 
 * of opponents that the other opponent classes can inherit.
 *
 * @author Joshua Kane and Clayton Martin - 004.
 * @version 4/6/11
 **/ 
  
   public abstract class Opponent extends BombButton
   {
   
   	/** indicates player has not lost yet. **/
      public static final int IN_PLAY = 1;
     	/** indicates that player lost the game. **/
      public static final int LOST = 0;
      /** represents PT boat, 2 spots on grid. **/
      public static final int PT_BOAT = 2;
      /** represents cruiser, 3 spots on grid. **/
      public static final int CRUISER = 3;
   	/** represents battleship, 4 spots on grid. **/
      public static final int BATTLESHIP = 4;
      /** default grid height. **/
      public static final int DEFAULT_HEIGHT = 10;
      /** grid 2d array of bomb buttons. **/
      private BombButton[][] grid;
      /** height of the board. **/
      private int boardHeight = 1;
      /** limit of ships that can be on the board based on height. **/
      private double shipLimit;
      /** current number of ships on the board. **/
      private int currentShipSpace;
      /** default shipLocation. **/
      private int[] shipLocation = { -1, -1, -1};
     
      
   	/**
   	* sets up 2D array of BomButton objects.
   	*
   	* @param height size of the 2D array.
   	**/
   	
      public Opponent(int height)
      {
         boardHeight = height;
         reset(height);
         
      }
    
     /**
     * invokes first constructor with a default grid height of 10.
     **/  
   	
      public Opponent()
      {
      
         // Opponent default1 = new Opponent(DEFAULT_HEIGHT);
         boardHeight = DEFAULT_HEIGHT;
      }
    
     /**
     * sets up the grid when an object is created or game
     * is restarted. 
     *
     * @param height int representing the size of the grind.
     **/  
   	
      public void reset(int height)
      {
         grid = new BombButton[height][height];
         int i = 0;
         for (int row = 0; row < grid.length; row++)
         {
            for (int col = 0; col < grid[row].length; col++)
            {
               grid[row][col] = new BombButton();
            }
         
         }	
         shipLimit = (0.20 * (height * height));
      }
      
   	/**
   	* Returns 2D array of BombButton objects.
   	*
   	* @return 2D array of BombButton objects.
   	**/
      
      public BombButton[][] getGrid()
      {
      
         return grid;
      }
      
   	/** String represntation of BombButton grid, targets are X's
   	* empty locations are O's.
   	*
   	* @return string representation of grid.
   	**/
      
      public String toString()
      {	
         String output = "";
         for (int row = 0; row < grid.length; row++)
         {
            for (int col = 0; col < grid[row].length; col++)
            {
               grid[row][col].setShowing(true);
               if (grid[row][col].getCategory() == EMPTY)
               {
                  output += "O\t";
               }
               else if (grid[row][col].getCategory() == TARGET)
               {
                  output += "X\t";
               }
            }
            output += "\n";
         } 
         
         return output;
      }
      
   	/** Places ship at random location in the grid with a random
   	* alignment.
   	*
   	* @param ship type of ship to be added.
   	* @return an array of 3 ints.
   	**/
   	
      public int[] placeRandomShip(int ship)
      {
         int stopcheck = 0;
         Random generator = new Random();
         int angle = generator.nextInt(2);
         while (stopcheck == 0)
         {
            if (ship == PT_BOAT)
            {
               if (angle == 0 && (currentShipSpace + 2) <= shipLimit)
               {
                  int rowLoc = generator.nextInt(grid.length);
                  int colLoc = generator.nextInt(grid.length - 1);
                  if (grid[rowLoc][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc][colLoc + 1].getCategory() == EMPTY)
                  {
                     grid[rowLoc][colLoc].setCategory(TARGET);
                     grid[rowLoc][colLoc + 1].setCategory(TARGET);
                     stopcheck = 1; 
                     currentShipSpace += 2;
                     int[] tempShipLocation = {rowLoc, colLoc, angle}; 
                     shipLocation = tempShipLocation;       
                  }
               }
               else if (angle == 1 && (currentShipSpace + 2) <= shipLimit)
               {
                  int rowLoc = generator.nextInt(grid.length - 1);
                  int colLoc = generator.nextInt(grid.length);
                  if (grid[rowLoc][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc + 1][colLoc].getCategory() == EMPTY)
                  {
                     grid[rowLoc][colLoc].setCategory(TARGET);
                     grid[rowLoc + 1][colLoc].setCategory(TARGET);
                     stopcheck = 1; 
                     currentShipSpace += 2;
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
            else if (ship == CRUISER)
            {
               if (angle == 0 && (currentShipSpace + 3) <= shipLimit)
               {
                  int rowLoc = generator.nextInt(grid.length);
                  int colLoc = generator.nextInt(grid.length - 2);
                  if (grid[rowLoc][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc][colLoc + 1].getCategory() == EMPTY
                  && grid[rowLoc][colLoc + 2].getCategory() == EMPTY)
                  {
                     grid[rowLoc][colLoc].setCategory(TARGET);
                     grid[rowLoc][colLoc + 1].setCategory(TARGET);
                     grid[rowLoc][colLoc + 2].setCategory(TARGET);
                     stopcheck = 1;
                     currentShipSpace += 3; 
                     int[] tempShipLocation = {rowLoc, colLoc, angle}; 
                     shipLocation = tempShipLocation;
                  }
               }
               else if (angle == 1 && (currentShipSpace + 3) <= shipLimit)
               {
                  int rowLoc = generator.nextInt(grid.length - 2);
                  int colLoc = generator.nextInt(grid.length);
                  if (grid[rowLoc][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc + 1][colLoc].getCategory() == EMPTY
                  && grid[rowLoc + 2][colLoc].getCategory() == EMPTY)
                  {
                     grid[rowLoc][colLoc].setCategory(TARGET);
                     grid[rowLoc + 1][colLoc].setCategory(TARGET);
                     grid[rowLoc + 2][colLoc].setCategory(TARGET);
                     stopcheck = 1;  
                     currentShipSpace += 3;      
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
            else if (ship == BATTLESHIP)
            {
               if (angle == 0  && (currentShipSpace + 4) <= shipLimit)
               {
                  int rowLoc = generator.nextInt(grid.length);
                  int colLoc = generator.nextInt(grid.length - 3);
                  if (grid[rowLoc][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc][colLoc + 1].getCategory() == EMPTY
                  && grid[rowLoc][colLoc + 2].getCategory() == EMPTY 
                  && grid[rowLoc][colLoc + 3].getCategory() == EMPTY)
                  {
                     grid[rowLoc][colLoc].setCategory(TARGET);
                     grid[rowLoc][colLoc + 1].setCategory(TARGET);
                     grid[rowLoc][colLoc + 2].setCategory(TARGET);
                     grid[rowLoc][colLoc + 3].setCategory(TARGET);
                     stopcheck = 1;
                     currentShipSpace += 4;
                     int[] tempShipLocation = {rowLoc, colLoc, angle}; 
                     shipLocation = tempShipLocation; 
                  }
               }
               else if (angle == 1  
               && (currentShipSpace + 4) <= shipLimit)               
               {
                  int rowLoc = generator.nextInt(grid.length - 3);
                  int colLoc = generator.nextInt(grid.length);
                  if (grid[rowLoc][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc + 1][colLoc].getCategory() == EMPTY
                  && grid[rowLoc + 2][colLoc].getCategory() == EMPTY 
                  && grid[rowLoc + 3][colLoc].getCategory() == EMPTY)
                  {
                     grid[rowLoc][colLoc].setCategory(TARGET);
                     grid[rowLoc + 1][colLoc].setCategory(TARGET);
                     grid[rowLoc + 2][colLoc].setCategory(TARGET);
                     grid[rowLoc + 3][colLoc].setCategory(TARGET);
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
      
   	/**
   	* Creates JPanel to hold grid.
   	*
   	* @return JPanel containing all of the BombButtons in grid.
   	**/
   	
      public JPanel createDisplayPanel()
      {
         JPanel board = new JPanel();
         board.setLayout(new GridLayout(boardHeight, boardHeight));
         
         for (int row = 0; row < grid.length; row++)
         {
            for (int col = 0; col < grid[row].length; col++)
            {
               BombButton tempButton = grid[row][col];
               board.add(tempButton);  
            }
         }
         return board;
      }
      
   	/**
   	* Tells the status of the player.
   	*
   	* @return int representing player's status.
   	**/
      
      public int determineStatus()
      {
         int status = 0;
         int hits = 0;
         for (int row = 0; row < grid.length; row++)
         {
            for (int col = 0; col < grid[row].length; col++)
            {
               BombButton spot = grid[row][col];
              
               if (spot.isAvailable() && spot.getCategory() == TARGET)
               {
                  hits++;
               } 
               else if (hits <= currentShipSpace)
               {
                  status = IN_PLAY;
               }
               else
               {
                  status = LOST;
               }
            
            
            }
         }
      
      
      
      
         return status;
      }
      
   	/**
   	* Abstract method that is not defined. Gives
   	* opponent a turn.
   	*
   	* @param row row the player would like to bomb.
   	* @param col column the player would like to bomb.
   	* @return whether or not the row and column were in bounds
   	* 	and the button at the location was available.
   	**/
      
      public boolean giveTurn(int row, int col)
      {
         if (row <= boardHeight - 1 && col <= boardHeight - 1
         && row >= 0 && col >= 0)
         {
            BombButton spot = grid[row][col];
            if (spot.isAvailable()
            && determineStatus() == IN_PLAY)
            {
               spot.attemptHit();
            
               return true;
            }
            else
            {
               return false;
            }
         }
         else
         {
            return false;
         }
      } 
   	
   
   
   
   }