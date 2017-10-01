package ie.gmit.java2;

import java.util.*;

public class Menu {

	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {

		int num = 0;

		// While / switch for initial menu + input
		while (num != 4) {
			System.out.println(" 1) Parse a File or URL\n 2) Search\n 3) Print Stats\n 4) Exit\n");
			num = console.nextInt();

			switch (num) {
			case 1:
				// calls parse method
				Parse();
				num = 4;
				break;

			case 2:
				System.out.println("Searching...Completed!");
				num = 4;
				break;

			case 3:
				System.out.println("Printed, check output file!");
				num = 4;
				break;

			case 4:
				System.out.println("Progamme Exited\n");
				break;

			default:
				System.out.println("Invalid option, try again");

			}// close switch

		} // close while

	}// close main

	// parse menu for Url and file - runner
	private static void Parse() {
		int parseNum;
		int optionNum = 0;
		int optionNum2 = 0;

		// selection for file or url parse
		System.out.println("1) File 2) URL");
		parseNum = console.nextInt();

		// first if statement for parse file
		if (parseNum == 1) {

			// instance variables
			Parser file = new Parser();
			String fileName = ParseFile();
			file.parse(fileName);

			String search = "";

			// input for word to search / manipulate
			System.out.println("Enter word: ");
			search = console.next();

			// while loop call different methods dependant on which option is
			// decided, used for stats / manipulation
			while (optionNum != 6) {
				System.out.println(
						"1) Does file contain word \n" + "2) Number of elements in Array \n" + "3) Is file empty \n"
								+ "4) First Occurence of word \n" + "5) Remove word from file \n" + "6) Exit \n");
				optionNum = console.nextInt();

				switch (optionNum) {
				case 1:
					System.out.println("Does this book contain " + search + "? :" + file.contains(search));
					break;
				case 2:
					System.out.println("The size of the Array is: " + file.count());
					break;
				case 3:
					System.out.println("Is Empty? " + file.isEmpty());
					break;
				case 4:
					System.out.println("Index of first Occurence of word: " + file.indexOf(search));
					break;
				case 5:
					System.out.println("Delete word from file: " + file.remove(search));
					break;
				}
			}
		} // close if

		// second if for parsing URL
		else if (parseNum == 2) {
			// instance variables
			UrlParser fileU = new UrlParser();
			String fileName = UrlFile();
			String search2 = "";

			// enter word to manipulate
			System.out.println("Enter word: ");
			search2 = console.next();

			// While loop for options - call different methods in UrlPrser
			while (optionNum2 != 7) {
				System.out.println("1) Does file contain word \n" + "2) Number of elements in Array \n"
						+ "3) Is file empty \n" + "4) First Occurence of word \n" + "5) Remove word from file \n"
						+ "6) Output to screen URL Contents \n" + "7) Exit \n");
				optionNum2 = console.nextInt();

				switch (optionNum2) {
				case 1:
					System.out.println("Does this book contain " + search2 + "? :" + fileU.contains(search2));
					break;
				case 2:
					System.out.println("The size of the Array is: " + fileU.count());
					break;
				case 3:
					System.out.println("Is Empty? " + fileU.isEmpty());
					break;
				case 4:
					System.out.println("Index of first Occurence of word: " + fileU.indexOf(search2));
					break;
				case 5:
					System.out.println("Delete word from file: " + fileU.remove(search2));
					break;
				case 6:
					System.out.println(UrlParser.parseString(UrlParser.getUrlContents(fileName)));
					break;

				}
			} // while
		} // close else if

		else {
			System.out.println("Invalid Option");
		}
	}// close Parse

	// method for intial parsing to file
	private static String ParseFile() {
		String fileName = "";
		System.out.println("Please enter file name: ");
		fileName = console.next();
		return fileName;
	}// close ParseFile

	// method for intial parsing to Url file
	private static String UrlFile() {
		String urlName = "";
		System.out.println("Please enter URL: ");
		urlName = console.next();
		return urlName;
	}// close UrlFile
}// close Menu

// ===================================================================================================
