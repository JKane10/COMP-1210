   import javax.swing.JFrame;
   import java.io.IOException;
   import javax.swing.JOptionPane;
   
	
	/**
	* Creates GUI.
	*
  	* Project_7B
	* @author Clayton Martin and Joshua Kane - Section 004
	* @version 3/1/11
	*/
	
   public class ViewTimes {
   
   /**
   * Creates GUI.
   *
   *@param args user defined arguments in an array.
   *@throws IOException - thrown by a file.
   **/
   
      public static void main(String[] args) throws IOException {
         JFrame frame = new JFrame("Joshua Kane's and "
            + "Clayton Martin's Time Viewer");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
         TimeGUI guiDisplay = new TimeGUI();
         String[] files;
         if (args.length == 0) {
         // show a dialog to get the filename
            String fileInput = 
               JOptionPane.showInputDialog("Please type in the file "
               + "name including the .csv extension: ");
            files = new String[1];
            files[0] = fileInput;
         }
         else {
            files = args;
         }
         
      
         guiDisplay.setEngineers(files);
      
         // send the filename to the constructor of the GUI
         
         //TimeGUI gui = new TimeGUI();
      	
         frame.getContentPane().add(guiDisplay);
         
         frame.setLocationRelativeTo(null);
         frame.pack();
         frame.setVisible(true);
      
      }
      
   }