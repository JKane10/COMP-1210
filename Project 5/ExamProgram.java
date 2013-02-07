import javax.swing.JFrame;
import java.io.IOException;

/**
 * This is the driver program that creates the GUI and fills in the approriate
 * inforamation using the ExamAverages and ExamViewer programs.
 * 
 * Project 5B
 * 
 * @author Joshua Kane - 004
 * @version 2/27/11
 **/

public class ExamProgram {

	/**
	 * This method calls and creates the GUI as well as creating a examViewer
	 * object and then displays the approriate output.
	 * 
	 * @param args
	 *            user defined command line arguments.
	 * @throws IOException
	 *             makes an exception for files.
	 **/

	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame("Joshua Kane's Exam Viewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ExamViewer guiDisplay = new ExamViewer("CourseA.txt");
		frame.getContentPane().add(guiDisplay);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
}