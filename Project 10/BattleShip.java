   import javax.swing.JPanel;
   import javax.swing.JLabel;
   import javax.swing.JTextField;
   import javax.swing.JFrame;
   import javax.swing.BoxLayout;
   import javax.swing.JOptionPane;
   import java.awt.event.ActionListener;
   import java.awt.event.ActionEvent;
   import javax.swing.Timer;
   import java.text.DecimalFormat;
   import java.util.ArrayList;

	
   

 /**
 * Creates Battleship game GUI.
 * 
 * @author Joshua Kane and Clayton Martin - 004.
 * @version 4/13/11
 **/   
	
   
   
   public class BattleShip extends JPanel
   {
   /** opponent object that is a human player. **/
      private static Opponent humanPlayer;
   /** opponent object that is a computer player. **/
      private Opponent computerPlayer;
   /** cpu player grid. **/ 
      private BombButton[][] cpuGrid;
   /** human player grid. **/    
      private BombButton[][] hmnGrid;
   /** row number on the grid for button pressed. **/
      private int rowOutput;
   /** col number on the grid for button pressed. **/
      private int colOutput;
   /** computer button listener. **/
      private ComputerListener listener1 = new ComputerListener();
   /** Accurcy text field. **/
      private JTextField info = new JTextField(10);
   /** timer to delay the computer's move. **/
      private Timer timer;
   /** decimal format for accuracy. **/
      private DecimalFormat df = new DecimalFormat("##.#");
   
      
   
   /**
   * Initalizes GUI components as well as players.
   *
   *@param nameIn name of player.
   **/
   
      public BattleShip(String nameIn)
      {
         humanPlayer = new CpuOpponent(10, nameIn);
         computerPlayer = new PlayerOpponent(10);
         
      
      	
         computerPlayer.placeRandomShip(Opponent.PT_BOAT);
         computerPlayer.placeRandomShip(Opponent.PT_BOAT);
         computerPlayer.placeRandomShip(Opponent.CRUISER);
         computerPlayer.placeRandomShip(Opponent.CRUISER);
         computerPlayer.placeRandomShip(Opponent.BATTLESHIP);
         
      	
         humanPlayer.placeRandomShip(Opponent.PT_BOAT);
         humanPlayer.placeRandomShip(Opponent.PT_BOAT);
         humanPlayer.placeRandomShip(Opponent.CRUISER);
         humanPlayer.placeRandomShip(Opponent.CRUISER);
         humanPlayer.placeRandomShip(Opponent.BATTLESHIP);
         
               
      
      	
      	
         JLabel name = new JLabel(nameIn);
         JLabel computer = new JLabel("Computer");
         
         info.setText("Accuracy: ");
         info.setEditable(false);
         JPanel playerPanel = new JPanel();
      //    playerPanel.add(humanPlayer.createDisplayPanel());
         JPanel computerPanel = new JPanel();
         JPanel computerStats = new JPanel();
         JPanel playerStats = new JPanel();
         JPanel blank = new JPanel();
         playerStats.add(name);
         playerStats.add(info);  
         computerStats.add(computer);
      	
         computerPanel.setLayout(new BoxLayout(
            computerPanel, BoxLayout.Y_AXIS));
         playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
      
         this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
      
         playerPanel.add(playerStats);
         playerPanel.add((JPanel) humanPlayer.createDisplayPanel());
      
      
         computerPanel.add(computerStats); 
         computerPanel.add((JPanel) computerPlayer.createDisplayPanel());
      
         
      
         this.add(computerPanel, BoxLayout.X_AXIS);
         this.add(blank, BoxLayout.X_AXIS);
         this.add(playerPanel, BoxLayout.X_AXIS);
       
         
      	//player listener
         // PlayerListener listener = new PlayerListener();
         
      
         //add to each bomb button, 
      	//use for each loop.addActionListener(listener1);
         cpuGrid = computerPlayer.getGrid();
         for (int row = 0; row < cpuGrid.length; row++)
         {
            for (int col = 0; col < cpuGrid[row].length; col++)
            {
               cpuGrid[row][col].addActionListener(listener1);
            }
         }
         
         timer = new Timer(500, new CpuTurn());
         // hmnGrid = humanPlayer.getGrid();
         // for (int row = 0; row < hmnGrid.length; row++)
         // {
            // for (int col = 0; col < hmnGrid[row].length; col++)
            // {
            //    // if (hmnGrid[row][col].getCategory() == BombButton.TARGET)
            //    // {
               // hmnGrid[row][col].getText();
            //    // }
            // }
         // }  
      	
         // // // for (int row = 0; row < cpuGrid.length; row++)
         // // // {
            // // // for (int col = 0; col < cpuGrid[row].length; col++)
            // // // {
               // // // cpuGrid[row][col].setText("");
            // // // }
         // // // }  
      }
    
    /** Action listener for Player grid. **/  
   	
      // private class PlayerListener implements ActionListener
      // {
      // 
      // /**
      // * This method listens for an action and then acts
      // * according to the action applied to the bomb buttons.
      // *
      // *@param eventInfo is an actionEvent that the program is
      // * listening for.
      // **/
      // 
         // public void actionPerformed(ActionEvent eventInfo)
         // {
            // Object buttonPressed = eventInfo.getSource();
         //    //what happens when show all is selected.
         //    // buttonPressed.setShowing(true);  
         // }
      // 
      // }
      
   	/** Action listener for Computer grid. **/
   
      private class ComputerListener implements ActionListener
      {
      
      /**
      * This method listens for an action and then acts
      * according to the action applied to the bomb buttons.
      *
      *@param eventInfo is an actionEvent that the program is
      * listening for.
      **/
      
         public void actionPerformed(ActionEvent eventInfo)
         {
         
            Object buttonPressed = eventInfo.getSource();
            //what happens when show all is selected.
            for (int row = 0; row < cpuGrid.length; row++)
            {
               for (int col = 0; col < cpuGrid[row].length; col++)
               {
                  if (buttonPressed == cpuGrid[row][col]) 
                  {
                     rowOutput = row;
                     colOutput = col;
                  }
               }
            }  
            System.out.println("Button pressed: " + rowOutput 
               + ", " + colOutput);   
           //gives turn
            computerPlayer.giveTurn(rowOutput, colOutput);
           
           //remove listeners for cpu's turn
            for (int row = 0; row < cpuGrid.length; row++)
            {
               for (int col = 0; col < cpuGrid[row].length; col++)
               { 
                  cpuGrid[row][col].removeActionListener(listener1);
               }
            }
            
            Score scr = new Score();
            scr.opponentInfo(computerPlayer);
            info.setText("Accuracy: " + (df.format(100 * scr.getAccuracy())));
            timer.start();
         }
      }
         
      	/** Action listener for computers turn. **/
      
      private class CpuTurn implements ActionListener
      {
         
         /**
         * This method listens for an action and then acts
         * according to the action applied to the bomb buttons.
         *
         *@param eventInfo is an actionEvent that the program is
         * listening for.
         **/
         
         public void actionPerformed(ActionEvent eventInfo)
         {
            timer.stop();
               
            	
            for (int row = 0; row < cpuGrid.length; row++)
            {
               for (int col = 0; col < cpuGrid[row].length; col++)
               { 
                  cpuGrid[row][col].addActionListener(listener1);
               }
            }
               
            humanPlayer.giveTurn(-1, -1);
            
            if (humanPlayer.determineStatus() == Opponent.LOST
            || computerPlayer.determineStatus() == Opponent.LOST)
            {
               endGame();
            }
            
         }
      }  
      
   	
      
   	
   /**
   * Creates JFrame and GUI.
   *
   *@param args user defined argmuments.
   **/
   
      public static void main(String[] args)
      {
         
         JFrame frame = new JFrame("Josh and Murphy's BattleShip!");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         String name = 
               JOptionPane.showInputDialog("Please type in your "
               + "name.");  
      
         if (name == null || name.trim().equals(""))
         {
            name = "Anonymous";
         }
      	
         BattleShip game = new BattleShip(name);
      
         frame.getContentPane().add((JPanel) game);
         frame.setLocationRelativeTo(null);
         frame.pack();
         frame.setVisible(true);
         System.out.println(game.getPreferredSize());
         
      	
      
      }
      
   	/** 
   	* method called once the game is over.
   	**/
      
      public void endGame()
      {
         if (computerPlayer.determineStatus() == Opponent.LOST)
         {
            for (int row = 0; row < cpuGrid.length; row++)
            {
               for (int col = 0; col < cpuGrid[row].length; col++)
               { 
                  cpuGrid[row][col].removeActionListener(listener1);
               }
            }
            Score humanScore = new Score();
            humanScore.opponentInfo(computerPlayer);
            info.setText("Accuracy: " 
               + (df.format(100 * humanScore.getAccuracy())));
            JOptionPane.showMessageDialog(null, 
               "You Win!\nYour final accuracy was "
               + df.format(100 * humanScore.getAccuracy()) 
               + "%.", humanPlayer.getName() 
               + " Wins", JOptionPane.PLAIN_MESSAGE);
               
         
            ScoreList scr = new ScoreList();
            scr.loadFromFile("HighScores.DAT");
            scr.getSortedScores();
            scr.addScore(humanScore);
            scr.getSortedScores();
            scr.writeToFile("HighScores.DAT");
            
            String scrlist = "";
            
            ArrayList<Score> scores = scr.getScoreList();
         	
         	
            for (int i = 0; i < scr.getnumScores(); i++)
            {
               scrlist += (df.format(scores.get(i).getAccuracy() * 100) + "\n");
            }
            
            
            JOptionPane.showMessageDialog(null,
               "You made the leader board!\n" 
               + scrlist, "High Score List!",
                JOptionPane.PLAIN_MESSAGE);
            // if (scr[9] < humanScore.getAccuracy())
            // {
            // 
            // }
         //    JOptionPane.showMessageDialog(null,
         // 		"You made the leader board!" //scoreList
         // 		,
         
         }
         else if (humanPlayer.determineStatus() == Opponent.LOST)
         { 
            JOptionPane.showMessageDialog(null, "You have lost the game.",
               "Computer Wins", JOptionPane.PLAIN_MESSAGE);
         }
         
      }
      
   
   }