import org.junit.Assert;
// import org.junit.Before;
import org.junit.Test;

/**
 * This program is a JUnit test against our Task.java program.
 * 
 * @author Joshua Kane and Clayton Martin - section 004.
 * @version 3/26/11
 **/

public class TaskTest {

	/**
	 * A test of the getDescription method.
	 **/

	@Test
	public void getDescription() {
		Task task = new Task("test task", 1, 3);
		task.getDescription();

		Assert.assertEquals("The getDescription method returned an"
				+ " incorrect description.", "test task", task.getDescription());

	}

	/**
	 * A test of the getPriority method.
	 **/

	@Test
	public void getPriority() {
		Task task = new Task("test task", 1, 3);
		task.getPriority();

		Assert.assertEquals("The getPriority method returned an"
				+ " incorrect value.", 1, task.getPriority());

	}

	/**
	 * A test of the getCategory method.
	 **/

	@Test
	public void getCategory() {
		Task task = new Task("test task", 1, 3);
		task.setCategory("work");
		task.getCategory();
		Assert.assertEquals("The getCategory method returned an"
				+ " incorrect value.", "work", task.getCategory());
	}

}