   import javax.swing.JFrame;
   import java.io.IOException;
   
	
/**
* This program creates the GUI for our task program.
*
*@author Joshua Kane and Clayton Martin - Section 004.
*@version 3/26/11
**/
	
   public class ToDoManager
   {
   
   /**
   * This method creates a new frame that will exit on closing
   * adds our ToDoGUI to the frame and makes it visible.
   *
   *@param args String array of user defined arguments.
   *@throws IOException thrown when file can not be found.
   **/
   
      public static void main(String[] args)throws IOException
      {
      
         JFrame frame = new JFrame("Joshua's and "
            + "Clayton's Time Viewer");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ToDoGUI guiDisplay = new ToDoGUI();
         ToDoList list = new ToDoList();
         list.addTask(new Task("Study for Comp 1210.", Task.HIGH_PRIORITY, 2));
         list.addTask(new Task("Schedule meeting.", Task.NORMAL, 7));
         list.addTask(new Task("Take exam.", Task.HIGH_PRIORITY, -3));
         list.addTask(new Task("Get ready for MLB regular season.",
            	Task.HIGH_PRIORITY, 1));
         list.addTask(new Task("Socialize.", Task.LOW_PRIORITY, 45));
         list.addTask(new Task("Schedule meeting.", Task.NORMAL, -7));
         list.addTask(new Task("Get groceries.", Task.NORMAL, -5));
         list.addTask(new Task("Homework due.", Task.NORMAL, 8));
         list.addTask(new Task("Sign up for classes.", Task.URGENT, -4));
         list.addTask(new Task("Do taxes.", Task.LOW_PRIORITY, 9));
         guiDisplay.setToDoList(list);   
      	
      	
      	
         frame.getContentPane().add(guiDisplay);
         frame.setLocationRelativeTo(null);
         frame.pack();
         frame.setVisible(true);
         
      	
      
      }
   
   }