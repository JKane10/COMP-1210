import java.util.Calendar;
import java.text.SimpleDateFormat;
// import java.util.Date;
import java.util.ArrayList;

// import java.io.IOException;

/**
 * This program will create a to do list of certain tasks as well as set a
 * priority level and due date to the tasks.
 * 
 * @author Joshua Kane - section 004
 * @version 3/23/11
 **/

public class Task {

	/** Constant int variable for low priority. **/
	public static final int LOW_PRIORITY = 1;
	/** Constant int variable for normal priority. **/
	public static final int NORMAL = 2;
	/** Constant int variable for high priority. **/
	public static final int HIGH_PRIORITY = 3;
	/** Constant int variable representing urgent priority. **/
	public static final int URGENT = 4;
	/** Constant int variable for no set priority. **/
	public static final int NONE_SET = 0;
	/** Constant static final string variable for the general category. **/
	public static final String GENERAL = "general";
	/** Constant static final string variable for the school category. **/
	public static final String SCHOOL = "school";
	/** Constant static final string variable for the work category. **/
	public static final String WORK = "work";
	/** String description of the task. **/
	private String taskDescription;
	/** String declaring category of the task. **/
	private String category;
	/** int setting priority level of the task. **/
	private int priority;
	/** int setting the days until due. **/
	private int daysUntilDue;
	/** Calendar object showing days until the task is due. **/
	private static Calendar dateDue;
	/** Calendar object usable for unique due date for each object. **/
	private Calendar dateDue1;
	/** Count of Task objects created. **/
	private static int countObj;
	/** The task with the earliest due date. **/
	private static Task earliest;
	/** format for the date. **/
	private SimpleDateFormat simpleDate = new SimpleDateFormat("M/d/yyyy");
	/** array list of all task objects created. **/
	private static ArrayList<Task> tasks = new ArrayList<Task>();

	/**
	 * Creates a task object containing a description as a string, a priority
	 * level as an int, and days until the task is due as an int.
	 * 
	 * @param priorityIn
	 *            - priority level of the task.
	 * @param taskDescriptionIn
	 *            - description of the task.
	 * @param daysUntilDueIn
	 *            - days until task is due.
	 **/

	public Task(String taskDescriptionIn, int priorityIn, int daysUntilDueIn) {
		if (taskDescriptionIn != null) {
			setDescription(taskDescriptionIn);
		}
		setPriority(priorityIn);
		daysUntilDue = daysUntilDueIn;
		setCategory(GENERAL);
		specifyDaysUntilDue(daysUntilDueIn);
		getDueDate();
		tasks.add(this);
		countObj++;

		// if (countObj == 1)
		// {
		// earliest = this;
		// }
		// else if (this.getDueDate().compareTo(earliest.getDueDate()) < 0)
		// {
		// earliest = this;
		// }
	}

	/**
	 * Boolean method that sets the description of the task unless the
	 * description is null, empty, or whitespace.
	 * 
	 * @param taskDescriptionIn1
	 *            - description of the task.
	 * @return false returns false if the description is null.
	 **/

	public boolean setDescription(String taskDescriptionIn1) {
		if (taskDescriptionIn1 == null) {
			return false;
		}
		String description = taskDescriptionIn1.trim();
		if (description.trim().length() == 0) {
			return false;
		} else {
			taskDescription = taskDescriptionIn1;
			return true;
		}
	}

	/**
	 * Boolean method that sets the priority level and returns true if the
	 * priority level is valid and returns false otherwise.
	 * 
	 * @param priorityIn1
	 *            - priority of the task.
	 * @return false returns false if the priority level is not valud.
	 **/

	public boolean setPriority(int priorityIn1) {
		if (priorityIn1 == LOW_PRIORITY) {
			priority = LOW_PRIORITY;
			return true;
		} else if (priorityIn1 == NORMAL) {
			priority = NORMAL;
			return true;
		} else if (priorityIn1 == HIGH_PRIORITY) {
			priority = HIGH_PRIORITY;
			return true;
		} else if (priorityIn1 == URGENT) {
			priority = URGENT;
			return true;
		} else {
			priority = NORMAL;
			return false;
		}

	}

	/**
	 * Boolean method that sets the category and returns true if the priority
	 * level is valid and returns false otherwise.
	 * 
	 * @param categoryIn
	 *            - category of the task.
	 * @return false returns false if the category is not valid.
	 **/

	public boolean setCategory(String categoryIn) {

		if (categoryIn == null) {

			return false;
		}
		categoryIn.trim();
		if (categoryIn.toLowerCase() == WORK) {
			category = WORK;
			return true;
		}
		if (categoryIn.toLowerCase() == GENERAL) {
			category = GENERAL;
			return true;
		}
		if (categoryIn.toLowerCase() == SCHOOL) {
			category = SCHOOL;
			return true;
		}

		else {
			return false;
		}
	}

	/**
	 * Returns the task description.
	 * 
	 * @return - task description.
	 **/

	public String getDescription() {
		return taskDescription;
	}

	/**
	 * Returns the task category.
	 * 
	 * @return - task category.
	 **/

	public String getCategory() {
		return category;
	}

	/**
	 * Returns the task priority.
	 * 
	 * @return - task priority.
	 **/

	public int getPriority() {
		return priority;
	}

	/**
	 * Returns the task due date.
	 * 
	 * @return due date - days until task is due.
	 **/

	public Calendar getDueDate() {
		dateDue1 = Calendar.getInstance();
		dateDue1.add(Calendar.DAY_OF_YEAR, daysUntilDue);

		return Task.calculateDueDate(daysUntilDue);
	}

	/**
	 * Takes the days from now that the task is due as an int and uses that
	 * value to set the due date.
	 * 
	 * @param daysUntilDueIn
	 *            - days until the task is due.
	 **/

	public void specifyDaysUntilDue(int daysUntilDueIn) {
		daysUntilDue = daysUntilDueIn;
		calculateDueDate(daysUntilDue);

	}

	/**
	 * Takes the days from now that the task is due and returns a Calender
	 * object that is specified number of days from the current date.
	 * 
	 * @param dueIn
	 *            - days until task is due.
	 * @return dueDate as calendar object.
	 **/

	public static Calendar calculateDueDate(int dueIn) {
		dateDue = Calendar.getInstance();
		dateDue.add(Calendar.DAY_OF_YEAR, dueIn);
		return dateDue;
	}

	/**
	 * returns lowest priority that has ever been set as an int value.
	 * 
	 * @return min - lowest priority that has ever been set.
	 **/

	public static int getLowestPriority() {
		int min = 0;
		if (tasks.size() != 0) {
			min = tasks.get(0).getPriority();
			for (int i = 0; i < tasks.size(); i++) {
				if (tasks.get(i).getPriority() <= min) {
					min = tasks.get(i).getPriority();
				}
			}
		}
		return min;
	}

	/**
	 * returns the highest priority that has ever been set as an int value.
	 * 
	 * @return highestPriority - highest priority that has ever been set.
	 **/

	public static int getHighestPriority() {
		int min = 0;
		if (tasks.size() != 0) {
			min = tasks.get(0).getPriority();
			for (int i = 0; i < tasks.size(); i++) {
				if (tasks.get(i).getPriority() >= min) {
					min = tasks.get(i).getPriority();
				}
			}
		}
		return min;

	}

	/**
	 * returns the task object from all that have ever been created that has the
	 * earliest due date.
	 * 
	 * @return earliestTask - task with the earliest due date.
	 **/

	public static Task getEarliestTask() {

		int j = 0;
		if (tasks.size() != 0) {
			Calendar cal1 = tasks.get(0).getDueDate();
			// int j = 0;
			for (int i = 0; i < tasks.size(); i++) {
				Calendar cal2 = tasks.get(i).getDueDate();
				if ((cal1.compareTo(cal2)) > 0) {
					cal1 = cal2;

					j = i;
				}
			}

			Task placeHolder = new Task(tasks.get(j).getDescription(), tasks
					.get(j).getPriority(), tasks.get(j).daysUntilDue);

			return placeHolder;
		}

		else {
			return null;
		}
	}

	/**
	 * Returns a string representation of the task in the correct format.
	 * 
	 * @return output - correct format for string.
	 **/

	public String toString() {
		String output = "";
		output = simpleDate.format(getDueDate().getTime()) + ": "
				+ getDescription() + ".";
		return output;
	}

}