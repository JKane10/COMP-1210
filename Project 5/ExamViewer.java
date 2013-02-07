import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This class sets up the GUI for the exam program.
 * 
 * @author Joshua Kane - 004
 * @version 2/27/11
 **/

public class ExamViewer extends JPanel {
	/** Variable for the text pane displayed in the frame. **/
	private JTextPane textDisplay;
	/** Variable for scroll pane. **/
	private JScrollPane scrollPane;
	/** Variable for the buttons in the GUI. **/
	private JButton toText, toHtml;
	/** Variable exam averages object. **/
	private ExamAverages examAverages;

	/**
	 * Creates the GUI.
	 * 
	 * @param fileName
	 *            the name of the file that is read.
	 * @throws IOException
	 *             makes an exception for files.
	 **/

	public ExamViewer(String fileName) throws IOException {
		examAverages = new ExamAverages(fileName);
		textDisplay = new JTextPane();
		textDisplay.setContentType("text/plain");
		textDisplay.setEditable(false);
		textDisplay.setPreferredSize(new Dimension(300, 300));
		textDisplay.setText(examAverages.toString());
		scrollPane = new JScrollPane(textDisplay);

		toText = new JButton("Plain Text");
		toHtml = new JButton("Html");
		this.add(scrollPane);
		this.add(toText);
		this.add(toHtml);
		this.setPreferredSize(new Dimension(320, 350));
		DisplayButtonChanger buttonListener = new DisplayButtonChanger();
		toText.addActionListener(buttonListener);
		toHtml.addActionListener(buttonListener);

	}

	/**
	 * Informs the listener what to do given the user's action.
	 **/

	private class DisplayButtonChanger implements ActionListener {

		/**
		 * Declares which action will happen given user's action.
		 * 
		 * @param eventInfo
		 *            listens for the user's input.
		 **/
		public void actionPerformed(ActionEvent eventInfo) {
			Object buttonPressed = eventInfo.getSource();

			if (buttonPressed == toText) {
				// what happens when the toText button is pressed
				textDisplay.setContentType("text/plain");
				textDisplay.setText(examAverages.toString());
			}

			else if (buttonPressed == toHtml) {
				// what happens when the toHtml button is pressed
				textDisplay.setContentType("text/html");
				textDisplay.setText(examAverages.toHtmlString());
			}
		}

	}
}