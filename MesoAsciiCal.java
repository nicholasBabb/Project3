import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MesoAsciiCal extends MesoAsciiAbstract 
{
	private String[] storedStations = new String[1];
	private String stationId;
	private static char[] charArray;
	private int asciiAverage;
	
	public MesoAsciiCal(MesoStation mesoStation) {
		// Taken from Nicholas Babb - Project 2, and modified to fit the purposes of Project 3
		// To hold floor, ceiling, and average. Initialized to 3 slots as that is all that is needed
		double averageValue = 0;
		//Splitting stationId into a char array to easily access each letter for conversion to ASCII.
		charArray = stationId.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			int asciiValue = (int) charArray[i];
			averageValue += (double) asciiValue;
		}
		// Divided by 4 because there are 4 letters in a Station ID.
		averageValue = (averageValue / 4.0);
		// Round to nearest value for Average
		asciiAverages[2] = (int) Math.round(averageValue);
		asciiAverages[1] = (int) Math.floor(averageValue);
		asciiAverages[0] = (int) Math.ceil(averageValue);
		return asciiAverages;
	}
	
	// Taken from Nicholas Babb - Project 1
	public void readFile (String fileName) throws IOException {
		// Holds entire line
		String readLineStorage = "Default";
		// Holds substring of readLineStorage, station name specifically
		String readLineSubstring = "Default";
		int index = 0;
		// Beginning of Station ID after being trimmed.
		int beginString = 0;
		// End of Station ID after being trimmed.
		int endString = 4;
		// Start of stationIDs in Mesonet.txt.
		int startOfStations = 3;
		
		BufferedReader readIn = new BufferedReader(new FileReader(fileName));
		// Reading through first 3 lines to ensure it doesn't go into the array
		for (int i = 0; i < startOfStations; i++) {
			readLineStorage = readIn.readLine();
		}
		// Reading in the rest of the file
		readLineStorage = readIn.readLine();
		for (index = 0; readLineStorage != null; index++) {
			readLineStorage = readLineStorage.trim();
			// Scanning in only the station name with a substring
			readLineSubstring = readLineStorage.substring(beginString, endString);
			
			// Determining if storedTerms can hold next term.
			if (storedStations.length <= index) {
				storedStations = expandArray(storedStations);
			}
			storedStations[index] = readLineSubstring;
			readLineStorage = readIn.readLine();
			
		}
		readIn.close();
    }
	
	// Taken from Nicholas Babb - Project 1
	public String[] expandArray (String[] array) {
		String[] temp = new String[array.length + 1];
		for (int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		array = temp;
		return array;
	}
   
}