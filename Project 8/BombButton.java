   import javax.swing.JButton;
   import java.awt.Color;  
   // import javax.swing.AbstractButton;
	
	
	
   /**
	* Represents one tile on a player's grid. Either a target location
	* or empty water. Available to bomb or unavaiable if already bombed.
	*
	*
	* @author - Joshua Kane and Murphy Martin - 004
	* @version - 4/6/11
	**/
   
   public class BombButton extends JButton
   {
   
   	/** represents empty water. **/
      public static final int EMPTY = 0;
   	/** represents part of a ship. **/
      public static final int TARGET = 1;
      /** category of the button. **/
      private int buttonCategory;
      /** variable representing if the button has been attempted. **/
      private int attempted = 0;
      /** color representing a hit. **/
      private Color hit;
      /** color representing a miss. **/
      private Color miss;
   
   	/**
   	* Takes 2 parameters, the first is the color of a hit, red and
   	* the second is the color of a miss, blue. Also defaults the category 
   	* to empty. Defaults text to empty, not showing, 
   	*
   	* @param hitIn color representing a hit, red.
   	* @param missIn color representing a miss, blue.
   	**/
   
      public BombButton(Color hitIn, Color missIn)
      {
         setShowing(false);
         setCategory(EMPTY);
         
         hit = hitIn;
         miss = missIn;
      	
      }
      
   	/**
   	* Invokes first constructor with the default colors.
   	**/
      
      public BombButton()
      {
      
         this(Color.RED, Color.BLUE);
      
      }
      
   	/**
   	* Stores whether or not the button text reveals whether it
   	* is a hit or a miss. 
   	*
   	* @param showing true a char is showing or false its blank space. 
   	**/
   
   
      public void setShowing(boolean showing)
      {
      
         if (showing)
         {
            if (getCategory() == TARGET)
            {
               this.setText("X");
            }
            else if (getCategory() == EMPTY)
            {
               this.setText("O");
            }
         }
         else
         {
            this.setText("");
         }
      	
      
      }
      
   	/**
   	* Sets category of bomb button.
   	*
   	* @param type the type of space, target or empty.
   	* @return true if category is a target or empty, false otherwise.
   	**/
   	
      public boolean setCategory(int type)
      {
         if (type == EMPTY || type == TARGET)
         {
         	
            buttonCategory = type;
            return true;
         }
         else
         {
         
            return false;
         }
      }
    
    /**
    * Displays the category. 
    * 
    * @return the category.
    **/  
   	
      public int getCategory()
      {
      
         return buttonCategory;
      }
    
    /**
    * Tells if the bomb button has been hit yet.
    *
    * @return true if button has not been hit, false otherwise.
    **/  
   	
      public boolean isAvailable()
      {
         boolean k = true;
         if (attempted == 0)
         {
            k = true;
            // attempted += 1;
         }
         else if (attempted == 1)
         {
            k = false;
         }
         return k;
      }
      
   	/**
   	* Attempts to make a hit, the bomb button. Changes the color of
   	* the target. Sets the target to not available. 
   	*
   	* @return true if the bombbutton was available before the hit. 
   	*	false if its already been hit. 
   	**/
   	
      public boolean attemptHit()
      {
         if (isAvailable() && getCategory() == TARGET)
         {
            setBackground(hit);
            setShowing(true);
            setEnabled(false);
            attempted = 1;
            return true;
         }
         else if (isAvailable() && getCategory() == EMPTY)
         {
            setBackground(miss);
            setShowing(true);
            setEnabled(false);
            attempted = 1;
            return true;
         }
         
         else
         {
            return false;
         }
           
       
      }
   	
   
   
   
   
   }