package ie.gmit.java2;

import java.io.*;

import java.util.*;

public class Parser {

	// Instance Variables
	private List<String> fileContents = new ArrayList<String>();
	private File file = null;

	// Constructors

	//Default constructor
	public Parser() {

		// this("book.txt");
	}

	//Constructor with file name input (String)
	public Parser(String fileName) {
		this.file = new File(fileName);
		this.parse(fileName);
	}

	//Constructor with file input
	public Parser(File file) {
		this.file = file;
	}

	public void parse(String fileName) {
		//Read file in
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//Output to list
		String line = "";
		try {

			while ((line = br.readLine()) != null) {

				// Splits line if white space
				String[] words = line.split("\\s+");

				//Adds elements of array to a list
				fileContents.addAll(Arrays.asList(words));

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// end of parse

	
	// Delegate Methods

	public int count() {
		return fileContents.size();
	}

	public boolean isEmpty() {
		return fileContents.isEmpty();
	}

	public boolean contains(Object o) {
		return fileContents.contains(o);
	}

	public boolean remove(Object o) {
		return fileContents.remove(o);
	}

	public int indexOf(Object o) {
		return fileContents.indexOf(o);
	}

}
