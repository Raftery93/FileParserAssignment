package ie.gmit.java2;

import java.net.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;

public class UrlParser {
	// Instance Variables
	private static List<String> fileContents = new ArrayList<String>();
	private File file = null;

	// Constructors

	// Default constructor
	public UrlParser() {
		// String output = getUrlContents("https://learnonline.gmit.ie/my/");
		// System.out.println(output);
	}

	// Constructor with file name input (String)
	public UrlParser(String fileName) {
		this.file = new File(fileName);
		UrlParser.getUrlContents(fileName);
	}

	// Constructor with file input
	public UrlParser(File file) {
		this.file = file;
	}

	public static String getUrlContents(String fileName) {
		StringBuilder content = new StringBuilder();

		// Many of these calls can throw exceptions, so
		// Wrapped them all in try/catch statement.
		try {
			// Create a url object
			URL url = new URL(fileName);

			// Create a urlconnection object
			URLConnection urlConnection = url.openConnection();

			// Wrap the urlconnection in a bufferedreader
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			String line;

			// Read from the urlconnection via the bufferedreader
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line + "\n");

				// Splits line if white space
				String[] words = line.split("\\s+");

				// Adds elements of array to a list
				fileContents.addAll(Arrays.asList(words));
			}

			bufferedReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}// End of getUrlContents

	// Method used for 'cleaning' up URL
	public static String parseString(String s) {
		String output = null;

		Pattern replaceWhitespacePattern = Pattern.compile("\\s");
		Matcher matcher = null;
		matcher = replaceWhitespacePattern.matcher(s);
		output = matcher.replaceAll("\n");

		Pattern removeHTMLTagsPattern = Pattern.compile("]*>");
		matcher = removeHTMLTagsPattern.matcher(output);
		output = matcher.replaceAll("\n");

		Pattern leaveOnlyAlphaNumericCharactersPattern = Pattern.compile("[^0-9a-zA-Z ]");
		matcher = leaveOnlyAlphaNumericCharactersPattern.matcher(output);
		output = matcher.replaceAll("\n");

		return output;

	}// End of parseString

	// Delegate Methods
	public boolean contains(Object o) {
		return fileContents.contains(o);
	}

	public int indexOf(Object o) {
		return fileContents.indexOf(o);
	}

	public boolean isEmpty() {
		return fileContents.isEmpty();
	}

	public boolean remove(Object o) {
		return fileContents.remove(o);
	}

	public int count() {
		return fileContents.size();
	}
}