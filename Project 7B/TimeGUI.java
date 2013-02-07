   import javax.swing.JPanel;
   import javax.swing.JTextPane;
   import javax.swing.JScrollPane;
   import javax.swing.JCheckBox;
   import java.awt.Dimension;
   import java.awt.event.ActionListener;
   import java.awt.event.ActionEvent;
   import java.io.IOException;
   import java.util.ArrayList;
   // import java.util.Arrays;
   // import java.awt.BorderLayout;

   
	/**
	* Sets up the GUI for Engineer program.
	*
  	* Project_7A
	* @author Clayton Martin and Joshua Kane - Section 004
	* @version 3/1/11
	*/


   public class TimeGUI extends JPanel {
   /** creates text pane. **/
      private JTextPane textDisplay;
      /** creates a scroll pane. **/
      private JScrollPane scrollPane;
      /** creates a check box for the three projects.**/
      private JCheckBox projASelect, projBSelect, projCSelect;
      /** creates an embedded button panel.**/
      private JPanel embeddedButtonPanel;
      /** creates an array list named file.**/
      // private ArrayList<Engineer> files;
      private ArrayList<Engineer> engObj = 
      new ArrayList<Engineer>();
      /** number of engineers. **/	       
      private int engNum;  
       
       /**
   	  * Initializes all GUI components and adds them to the 
   	  * main panel. Also parses all information from the engineer's
   	  * time segment file using the Engineer class and adds it 
   	  * to the main display.
   	  *
   	  * @throws IOException if the file cannot be read.
   	  */
      public TimeGUI() throws IOException {
      
      	// instantiate your Engineer object using the file name
      	 //   setEngineers(file);     
         textDisplay = new JTextPane();
         // this can be changed if you want to use html formatting
         textDisplay.setContentType("text/plain");
         textDisplay.setEditable(false);
         textDisplay.setPreferredSize(new Dimension(300, 300));
         
         String output = "";
      //    change this code to display all 3 projects when the GUI is opened.
      
      
      
         for (int i = 0; i < engNum; i++)
         {
            output += (engObj.get(i).getNameGUI() + "\r\n\r\nProject A:\r\n" 
               + engObj.get(i).getTimeSegmentsGUI('A') + "\r\nProject B:\r\n"
               + engObj.get(i).getTimeSegmentsGUI('B') + "\r\nProject C:\r\n"
               + engObj.get(i).getTimeSegmentsGUI('C') + "\r\n\r\n\r\n");
         }
         textDisplay.setText(output);
      	//"Change this so that all "
            //+ "3 projects are shown when the GUI is opened.");
      
         scrollPane = new JScrollPane(textDisplay);
         
      	
         // instantiate check boxes
         projASelect = new JCheckBox("ProjectA");
         projBSelect = new JCheckBox("ProjectB");
         projCSelect = new JCheckBox("ProjectC");
         /* use the setSelected method to ensure that all checkboxes are 
      	 checked when the GUI is opened. */
      	 
         // projASelect.isSelected(true);
         // projBSelect.isSelected(true);
         // projCSelect.isSelected(true);
      	 
      
         ProjectSelect listener = new ProjectSelect();
         projASelect.addActionListener(listener);
         projBSelect.addActionListener(listener);
         projCSelect.addActionListener(listener);
      		
      	// instantiate embedded panel and add the JCheckBox components
      	
         embeddedButtonPanel = new JPanel();
         embeddedButtonPanel.add(projASelect);
         embeddedButtonPanel.add(projBSelect);
         embeddedButtonPanel.add(projCSelect);
      		
      		
         this.add(scrollPane);
         
         this.add(embeddedButtonPanel);
        
      	
         embeddedButtonPanel = new JPanel();
         this.setPreferredSize(new Dimension(350, 450)); 
      }
      
   	/**
   	* This method takes in a String array of file
   	* names and creates engineer objects with it.
   	*
   	*@param file String array of file names.
   	*@throws IOException thrown if file not found.
   	**/
      public void setEngineers(String[] file) throws IOException
      {
         engNum = file.length;
         for (int i = 0; i < file.length; i++)
         {
            engObj.add(new Engineer(file[i]));
         }	
      }	
   	
   // 
   
   /**
   * adds information for the GUI.
   *
   *@param addA check box true or false.
   *@param addB check box true or false.
   *@param addC check box true or false.
   *@return displayInfo returns display info.
   **/	
      // private String getDisplayInformation(boolean addA, boolean addB,   
      // boolean addC) {  
         // String displayInfo = "";  
         // for (Engineer e : engObj)
         // {
            // displayInfo += getDisplayInformationForEngineer(
               // e, addA, addB, addC);
         // }
         // return displayInfo;
      //  
      //    
      // }
   		//String name = Arrays.toString(engObj.getName());
         
   		/**
   		* Adds information for the GUI.
   		*
   		*
   		*@param engObj engineer Object.
   		*@param addA check box true or false
   		*@param addB check box true or false
   		*@param addC check box true or false
   		*@return returns display information.
   		**/
   		
      // private String getDisplayInformationForEngineer(Engineer engObj, 
      // boolean addA, boolean addB, boolean addC)
      // {
      // 
      // 
      // 
         // return null;
      // }
      	
       /**
   	 * takes an array of file names and creates 
   	 * Engineer objects.
   	 *
   	 **/
       
       
   	 /**
   	 * Calls the text display.
   	 *
   	 *@return textDisplay returns text display.
   	 **/
     
      public JTextPane getTextDisplay() 
      { 
         return textDisplay;   
      } 
      
   	/**
   	* Calls check boxes.
   	*
   	*@return boxes returns text boxes.
   	**/
   	
      public JCheckBox[] getProjectCheckboxes() { 
         JCheckBox[] boxes = {projASelect, projBSelect, projCSelect}; 
          
         return boxes;   
      }
   
   	/**
   	* This class uses the project and implements ActionListener.
   	**/
   	
      private class ProjectSelect implements ActionListener {
         
         /**
         * This method finds the actions performed.
         * @param eventInfo - takes eventInfo as an ActionEvent parameter.
         */
         
         public void actionPerformed(ActionEvent eventInfo) {
            String output = "";
         
          // add the engineer's name to the display
         
          // find out which check boxes are checked using the isSelected method
         
         
         
         
          // if project A checkbox is currently selected, 
          // add project A information to display
            // for (int i = 0; i < 3; i++)
            // {
               // projASelect.isSelected();
               // {
                  // output += engObj.get(i).getTimeSegmentsGUI('A');
               // }
            //    
               // projBSelect.isSelected();
               // {
                  // output += engObj.get(i).getTimeSegmentsGUI('B');
               // }
            //    
               // projCSelect.isSelected();
               // {
                  // output += engObj.get(i).getTimeSegmentsGUI('C');
               // }
            // } 
            
         
               
               // else if (projBSelect.isSelected())
               // {
                  // output += engObj.get(i).getTimeSegmentsGUI('B');
               // }
               // else if (projCSelect.isSelected())
               // {
                  // output += engObj.get(i).getTimeSegmentsGUI('C');
               // }
            // }
          
          // if project B checkbox is currently selected, 
          //add project B information to display
         
          // if project C checkbox is currently selected, 
          //add project C information to display
         
            textDisplay.setText(output);
         }
      }
      
   
   }
