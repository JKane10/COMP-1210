import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;

/**
 * This program is the GUI for the task program.
 * 
 * @author Joshua Kane and Clayton Martin - Section 004.
 * @version 3/26/11
 **/

public class ToDoGUI extends JPanel {
	/** JRadioButtons for show all and pending only. **/
	private JRadioButton showAll, pendingOnly;
	/** JList for a list containing our tasks. **/
	private JList list;
	/** JScrollPane for a scroll pane apply to the JList. **/
	private JScrollPane scrollPane;
	/** JButton for the delete task button. **/
	private JButton delete;
	/** JPanel to hold the two radio buttons. **/
	private JPanel embeddedButtonPanel;

	/**
	 * This method constructs all the necessary components for our GUI such as
	 * the radio buttons, the delete button, as well as the list of tasks.
	 **/

	public ToDoGUI() {

		this.setLayout(new BorderLayout());
		list = new JList();
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
		// //radio listener
		// radioButtonListener radioListener = new radioButtonListener();
		// showAll.addActionListener(radioListener);
		// pendingOnly.addActionListener(radioListener);
		// //delete button listener
		// deleteListener buttonListener = new deleteListener();
		// delete.addActionListener(buttonListener);

	}

	/**
	 * This class implements a listener for our radio buttons.
	 **/

	// private class RadioButtonListener implements ActionListener
	// {
	//
	// /**
	// * This method listens for an action and then acts
	// * according to the action applied to the radio buttons.
	// *
	// *@param eventInfo is an actionEvent that the program is
	// * listening for.
	// **/
	//
	// public void actionPerformed(ActionEvent eventInfo)
	// {
	//
	// Object buttonPressed = eventInfo.getSource();
	//
	// if (buttonPressed == showAll)
	// {
	// //what happens when show all is selected.
	// }
	// else if (buttonPressed == pendingOnly)
	// {
	// //what happens when pending only is selected.
	// }
	//
	// }
	//
	// }

	/**
	 * This class implements a listener for our delete button.
	 **/

	// private class deleteListener implements ActionListener
	// {
	//
	// /**
	// * This method listens for an action and then acts
	// * according to the action applied to the delete button.
	// *
	// *@param eventInfo is an actionEvent that the program is
	// * listening for.
	// **/
	//
	//
	// public void actionPerformed(ActionEvent eventInfo)
	// {
	// Object buttonPressed = eventInfo.getSource();
	//
	// if (buttonPressed == delete)
	// {
	// //what the delete button does
	// }
	//
	// }
	// }

	/**
	 * returns a reference to the GUI's JList.
	 * 
	 * @return reference to the GUI's JList.
	 **/

	public JList getList() {
		return list;
	}

	/**
	 * returns an array of JRadioButton objects with the Show all button at
	 * index 0 and pending only at index 1.
	 * 
	 * @return an array of JRadioButtons.
	 **/

	public JRadioButton[] getRadioButtons() {
		JRadioButton[] radioArray = new JRadioButton[2];
		radioArray[0] = showAll;
		radioArray[1] = pendingOnly;

		return radioArray;
	}

	/**
	 * returns a reference to the GUI's delete button.
	 * 
	 * @return a reference to the GUI's delete button.
	 **/

	public JButton getDeleteButton() {
		return delete;
	}

}