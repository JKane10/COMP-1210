   import java.util.ArrayList;
   
/**
* Represents a list of Task objects. Has methods to add, delete,
* and filter tasks based on whether they are past due / incomplete. 
*
* @author Joshua Kane and Clayton Martin - section 004
* @version 3/30/11
**/

   public class ToDoList
   {
   /** int value representing a choice to display only pending tasks. **/
      public static final int PENDING_ONLY = 0;
   /** int value representing a choice to display all tasks. **/
      public static final int ALL = 1;
   /** array list for to do list. **/
      private ArrayList<Task> list = new ArrayList<Task>();
   /** array list used for the pending list.**/   
      private ArrayList<Task> pendingList = new ArrayList<Task>();
   
   /**
   * Stores an array of task objects as a list of tasks.
   *
   *
   **/
   
   
      public ToDoList()
      {
      
         list.equals(new ArrayList<Task>(Task.getTaskList()));
      
      }
      
   /**
   * Stores an array of task objects as a list of tasks.
   *
   * @param tasksIn Array list of tasks.
   **/
      
      public ToDoList(Task[] tasksIn)
      {
         list.equals(Task.getTaskList());
        
         for (int i = 0; i < tasksIn.length; i++)
         {
            list.add(tasksIn[i]);
         }
      }
   
   /** Adds a Task to the list of Task objects. 
   * Returns the current number of Task objects
   * that are being held after the new Task is added. 
   *
   * @param taskIn task to be added to the list.
   * @return returns current number of task objects in the list.
   **/
   
   
      public int addTask(Task taskIn)
      {
      
         list.add(taskIn);
      
         return list.size();
      }
      
   	/** Takes a Task object as a parameter and deletes
   	* that Task from the list. 
   	*
   	* @param taskIn task to be deleted from the list.
   	* @return whether that object was found in the list and removed. 
   	**/
   
   	
      public boolean deleteTask(Task taskIn)
      {
      
         if (list.remove(taskIn))
         {
            return true;
         }
      
         return false;       //////////// changed something here/////////
         
         // int j = 0;
      // 
         // for (int i = 0; i < list.size(); i++)
         // {
            // if (list.get(i) == taskIn)
            // {
               // j = i;
            // }
         // }
      //    
         // boolean k = false;
      // 	
         // if (j != 0)
         // {
            // list.remove(taskIn);
            // k = true;
         // }
         // 
         // else if (j == 0)
         // {
            // k = false;
         // } 
      //    
         // return k; 
      }
      
   	/** Takes an int parameter
   	* and returns an ArrayList with generic type Task. 
   	*
   	* @param type one of the public constants.
   	* @return array list with generic type Task.
   	**/
   
      public ArrayList<Task> getTasks(int type)
      {	
         // ArrayList<Task> k = null;
         ArrayList<Task> tempTask = new ArrayList<Task>();
         
         if (type == PENDING_ONLY)
         {
            for (int i = 0; i < list.size(); i++)
            {
               if (!Task.isPastDue(list.get(i)))
               {
                  if (!list.get(i).isComplete())
                  {
                     tempTask.add(list.get(i));
                  }
               }
            	  
            	
            }
            // l = tempTask;
            pendingList = tempTask;
            return pendingList;
         }
         else
         {
            return list;
         }
      }
   
   /** Takes no parameters and returns an ArrayList with generic type 
    * Task that contains all items. 
    *
    *@return array list with all generic type Task.
    **/
   
   
      public ArrayList<Task> getTasks()
      {
         return list;
      }
   
   }