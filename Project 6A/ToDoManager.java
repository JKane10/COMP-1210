import javax.swing.JFrame;
import java.io.IOException;

/**
 * This program creates the GUI for our task program.
 * 
 * @author Joshua Kane and Clayton Martin - Section 004.
 * @version 3/26/11
 **/

public class ToDoManager {

	/**
	 * This method creates a new frame that will exit on closing adds our
	 * ToDoGUI to the frame and makes it visible.
	 * 
	 * @param args
	 *            String array of user defined arguments.
	 * @throws IOException
	 *             thrown when file can not be found.
	 **/

	public static void main(String[] args) throws IOException {

		JFrame frame = new JFrame("Joshua's and " + "Clayton's Time Viewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ToDoGUI guiDisplay = new ToDoGUI();
		frame.getContentPane().add(guiDisplay);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);

	}

}