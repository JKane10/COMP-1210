import java.text.DecimalFormat;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

/**
 * This class will parse out and reformat all of the information for a course as
 * well as exam scores. It will also have methods that format the course
 * information and exam averages in both plain text and html format.
 * 
 * @author Joshua Kane - 004
 * @version 2/27/11
 **/
public class ExamAverages {
	/** declaring a varible for the file object. **/
	private File file;
	/** Variable for the name of the course. **/
	private String courseName;
	/** Variable for the location of the course. **/
	private String location;
	/** String variable for the course type. **/
	private String courseTypeString;
	/** String variable for the course. **/
	private String courseTypeColor;
	/** int variable for the course type. **/
	private int courseType;
	/** int variable for the number of students. **/
	private int numberStudents;
	/** int variable for exam number. **/
	private int examNumber;
	/** double variables for all the exam averages. **/
	private double exam1, exam2, exam3, exam4, exam5, exam6;

	/**
	 * Takes String input representing the name of the file to be read and then
	 * applies it to other methods to parse it out and display it properly.
	 * 
	 * @param fileName
	 *            the name of the files that will be parsed.
	 * @throws IOException
	 *             importing and reading text files.
	 **/
	public ExamAverages(String fileName) throws IOException {
		// call processfile to parse text file
		file = new File(fileName);
		processFile(fileName);
	}

	/**
	 * Pasrses the new file and replaces all course information from the old
	 * file.
	 * 
	 * @param filename
	 *            name of the file to be read.
	 * @throws IOException
	 *             to import the file and read it.
	 **/
	public void processFile(String filename) throws IOException {
		String fileNameVar = filename;
		Scanner scan = new Scanner(new File(filename));
		courseName = scan.nextLine();
		location = scan.nextLine();
		courseType = Integer.parseInt(scan.nextLine());
		numberStudents = Integer.parseInt(scan.nextLine());
		examNumber = 0;
		while (scan.hasNext()) {
			double examTotal = 0;
			examNumber++;
			for (int j = 1; j <= numberStudents; j++) {
				examTotal = examTotal + scan.nextInt();
			}
			examTotal = (examTotal / numberStudents);
			switch (examNumber) {
			case 1:
				exam1 = examTotal;
				break;
			case 2:
				exam2 = examTotal;
				break;
			case 3:
				exam3 = examTotal;
				break;
			case 4:
				exam4 = examTotal;
				break;
			case 5:
				exam5 = examTotal;
				break;
			case 6:
				exam6 = examTotal;
				break;
			default:
				exam1 = 0;
			}
		}
	}

	/**
	 * returns the name of the class as a String.
	 * 
	 * @return returns the name of the class as a string.
	 **/
	public String getClassName() {
		return courseName;
	}

	/**
	 * Returns the location of the course as declared in the text file.
	 * 
	 * @return the location of the course as a string.
	 **/
	public String getLocation() {
		return location;
	}

	/**
	 * This method takes in the class type as a number and parses it as a
	 * String. It then applies a color for the Html output.
	 * 
	 * @return returns course type as an Int.
	 **/
	public int getClassType() {
		switch (courseType) {
		case 1:
			courseTypeString = "Lecture";
			courseTypeColor = "blue";
			break;
		case 2:
			courseTypeString = "Lab";
			courseTypeColor = "green";
			break;
		default:
			courseTypeString = "Unspecified";
			courseTypeColor = "red";
		}
		return courseType;
	}

	/**
	 * Reads the text file and returns the number of students in the class.
	 * 
	 * @return the number of students in the class as an int.
	 **/
	public int getNumberStudents() {
		return numberStudents;
	}

	/**
	 * Reads the text file and returns the number of students in the class.
	 * 
	 * @return the number of students in the class as an int.
	 **/
	public int getNumberExams() {
		return examNumber;
	}

	/**
	 * Returns all of the exam numbers and averages.
	 * 
	 * @return the exam numbers and averages as a string.
	 **/
	public String getExamInfo() {
		DecimalFormat fmt1 = new DecimalFormat("#.##");
		String info;
		double avg;
		avg = 0;
		info = "";
		if (examNumber > 1) {
			info = "\r\n\r\nExam Averages: ";
			for (int i = 1; i <= examNumber; i++) {
				switch (i) {
				case 1:
					avg = exam1;
					break;
				case 2:
					avg = exam2;
					break;
				case 3:
					avg = exam3;
					break;
				case 4:
					avg = exam4;
					break;
				case 5:
					avg = exam5;
					break;
				case 6:
					avg = exam6;
					break;
				default:
					avg = 0;
				}
				info = info + "\r\nExam #" + i + ": " + fmt1.format(avg);
			}
		}
		return info;
	}

	/**
	 * Returns the course and exam information in a certain format.
	 * 
	 * @return returns the exam information in the proper format.
	 **/
	public String toString() {
		String output;
		getClassType();
		output = getClassName() + "\r\n" + getLocation() + " ("
				+ courseTypeString + ")\r\nNumber of Students: "
				+ numberStudents + "\r\nNumber of Exams: " + examNumber
				+ getExamInfo();
		return output;
	}

	/**
	 * Returns the course and exam information in the correct format for html
	 * display.
	 * 
	 * @return returns the string output containing the exam averages and course
	 *         information in the correct format for html display.
	 **/
	public String toHtmlString() {
		String output;
		getClassType();
		output = "<html><b>" + getClassName() + "</b><br>" + getLocation()
				+ " (<font color=\"" + courseTypeColor + "\">"
				+ courseTypeString + "</font>)<br>Number of Students: "
				+ numberStudents + "<br>Number of Exams: " + examNumber
				+ getExamInfo().replace("\r\n", "<br>") + "</html>";
		return output;
	}
}