   import javax.swing.JPanel;
   import javax.swing.JList;
   import javax.swing.JButton;
   import java.awt.BorderLayout;
   import javax.swing.JScrollPane;
   import javax.swing.JRadioButton;
   import javax.swing.ButtonGroup;
   import java.awt.event.ActionListener;
   import java.awt.event.ActionEvent;
   // import java.util.ArrayList;
   // import java.util.Arrays;
 
/**
* This program is the GUI for the task program.
*
*@author Joshua Kane and Clayton Martin - Section 004.
*@version 3/26/11
**/

   public class ToDoGUI extends JPanel
   {
   /** JRadioButtons for show all and pending only. **/
      private JRadioButton showAll, pendingOnly;
   /** JList for a list containing our tasks. **/
      private JList list;
   /** JScrollPane for a scroll pane apply to the JList. **/
      private JScrollPane scrollPane;
   /** JButton for the delete task button.**/
      private JButton delete;
   /** JPanel to hold the two radio buttons. **/
      private JPanel embeddedButtonPanel;
   /** Object ToDoList with variable theToDoList. **/
      private ToDoList theToDoList;
   
   /**
   * This method constructs all the necessary components
   * for our GUI such as the radio buttons, the delete button,
   * as well as the list of tasks.
   **/
   
   
      public ToDoGUI()
      {
         list = new JList();
         this.setLayout(new BorderLayout());
         scrollPane = new JScrollPane(list);
         delete = new JButton("Delete Item");
         
         showAll = new JRadioButton("Show all", true);
         pendingOnly = new JRadioButton("Pending only");
         embeddedButtonPanel = new JPanel(); 
         embeddedButtonPanel.add(showAll);
         embeddedButtonPanel.add(pendingOnly);
      	
         ButtonGroup group = new ButtonGroup();
         group.add(showAll);
         group.add(pendingOnly);
       
         this.add(scrollPane, BorderLayout.CENTER);
         this.add(embeddedButtonPanel, BorderLayout.NORTH);
         this.add(delete, BorderLayout.SOUTH);
         //radio listener
         RadioButtonListener radioListener = new RadioButtonListener();
         showAll.addActionListener(radioListener);
         pendingOnly.addActionListener(radioListener);
         //delete button listener
         DeleteListener buttonListener = new DeleteListener();
         delete.addActionListener(buttonListener);
      
      	
      }
      
   	/**
   	* Takes a ToDoList as a parameter and updates the JList to show
   	* all of the tasks in the ToDo list.  
   	*
   	* @param listIn a to do list.
   	**/
   	
      public void setToDoList(ToDoList listIn)
      {
         theToDoList = listIn;
         // ArrayList<Task> toDoArrayList = new ArrayList<Task>(0); 
      //    // Task[] taskArray = new Task[ToDoList.size()];
         // toDoArrayList = listIn.getTasks();
         // Task[] taskArray = new Task[toDoArrayList.size()];  
         // int j = 0;
         // for (int i = 0; i < toDoArrayList.size(); i++)
         // {
            // taskArray[i] = toDoArrayList.get(i);
         //  
         // }
         list.setListData(listIn.getTasks().toArray());
      }
      
   	
   	
   	/**
   	* This class implements a listener for our radio buttons.
   	**/
      
      private class RadioButtonListener implements ActionListener
      {
      
      /**
      * This method listens for an action and then acts
      * according to the action applied to the radio buttons.
      *
      *@param eventInfo is an actionEvent that the program is
      * listening for.
      **/
      
         public void actionPerformed(ActionEvent eventInfo)
         {
         
            Object buttonPressed = eventInfo.getSource();
         
            if (buttonPressed == showAll)
            {
            //what happens when show all is selected.
               
               list.setListData(theToDoList.getTasks(ToDoList.ALL).toArray());
            }
            else if (buttonPressed == pendingOnly)
            {
            //what happens when pending only is selected.
               list.setListData(theToDoList.getTasks(
                  ToDoList.PENDING_ONLY).toArray());
            }
         
         }
      
      }
      
   	/**
   	* This class implements a listener for our delete button.
   	**/
   	
      private class DeleteListener implements ActionListener
      {
      
      /**
      * This method listens for an action and then acts
      * according to the action applied to the delete button.
      *
      *@param eventInfo is an actionEvent that the program is
      * listening for.
      **/
      
      
         public void actionPerformed(ActionEvent eventInfo)
         {
            Object buttonPressed = eventInfo.getSource();
         
            if (buttonPressed == delete)
            {
               if (showAll.isSelected())
               {
                  theToDoList.deleteTask((Task) list.getSelectedValue());
                  setToDoList(theToDoList);
               }
               else 
               {
                  theToDoList.deleteTask((Task) list.getSelectedValue());
                  list.setListData(theToDoList.getTasks(
                     ToDoList.PENDING_ONLY).toArray());
               }
            
            }
         }
      }
   	
   	/**
   	* returns a reference to the GUI's JList.
   	*
   	*@return reference to the GUI's JList.
   	**/
      
      public JList getList()
      {
         return list;
      }
      
   	/**
   	* returns an array of JRadioButton objects with the Show
   	* all button at index 0 and pending only at index 1.
   	*
   	*@return an array of JRadioButtons.
   	**/
      
      public JRadioButton[] getRadioButtons()
      {
         JRadioButton[] radioArray = new JRadioButton[2]; 
         radioArray[0] = showAll;
         radioArray[1] = pendingOnly;
      	
         return radioArray;
      }
      
   	/**
   	* returns a reference to the GUI's delete button.
   	*
   	*@return a reference to the GUI's delete button.
   	**/
   	
      public JButton getDeleteButton()
      {
         return delete;
      }
   
   }