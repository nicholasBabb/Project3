import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private static final long MILLI_CONVERSION_FACTOR = 1000;
	private long timeInMilliseconds;
	private HashMap<String, String> timeZonesAndTime = new HashMap<String,String>();
	
	public DateTimeOne() {
		timeInMilliseconds = System.currentTimeMillis();	
	}
	
	public DateTimeOne(long input) {
		timeInMilliseconds = input;
	}
	
    public int getValueOfSecond() {
    	int currentSecond = (int) (timeInMilliseconds / MILLI_CONVERSION_FACTOR);
    	System.out.println("The value of Second now: " + currentSecond);
	    return currentSecond;
	   
    }
    // Print the present date/time as:"Current Date/Time: 10/08/2019 03:03 PM"
    // Here is a clue, month/day/year hour:minute am/pm 
	@Override
	public void dateTimeNow() {
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("MM/DD/YYYY hh:mm aa");
		System.out.println("Current Date/Time: " + format.format(calendar.getTime()));
		return;
	}

	@Override
	public void sleepForFiveSec() {
		long timeInMilliseconds = System.currentTimeMillis();
		long timeInSeconds = (timeInMilliseconds / MILLI_CONVERSION_FACTOR);
		while (timeInSeconds > 55) {
			timeInMilliseconds = System.currentTimeMillis();
			timeInSeconds = (timeInMilliseconds / MILLI_CONVERSION_FACTOR);
		}
		return;
	}
	// Sample Output:
	// Time on Server: 15:14
	// GMT: 20:14
	// BST (90E): 2:14
	// CST (90W): 15:14

	@Override
	public void dateTimeOfOtherCity() {
		// Print Current Time in current time zone in military time
		System.out.println(ZonedDateTime.now());
		// Print Current Time in GMT, Greenwich Mean Time
		ZoneId tz = ZoneId.of("Greenwich");
		DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("kk:mm");
		ZonedDateTime gmt = ZonedDateTime.now(tz);
		String formattedGmt = gmt.format(newFormat);
		System.out.println("GMT: " + formattedGmt);
		
		//Print Current Time in BST, Bangladesh Standard Time
		tz = ZoneId.of("Indian/Chagos");
		ZonedDateTime bst = ZonedDateTime.now(tz);
		String formattedBst = bst.format(newFormat);
		System.out.println("BST: " + formattedBst);
		
		//Print Current Time in CST, Central Standard Time
		tz = ZoneId.of("US/Mountain");
		ZonedDateTime cst = ZonedDateTime.now(tz);
		String formattedCst = cst.format(newFormat);
		System.out.println("CST: " + formattedCst);
	}
	
	// Sample Output:
	// GMT: 10/08/2019 20:26
	// BST: 10/09/2019 02:26
	// CST: 10/08/2019 15:26
	// Additionally, store these values in <String, String> hashmap. Time Zone is key,
	// Date and time are value;

	@Override
	public void dateTimeDifferentZone() {
		
		// Print Current Date and Time in GMT, Greenwich Mean Time, and store it in timeZonesAndTime
		ZoneId tz = ZoneId.of("Greenwich");
		DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy kk:mm");
		ZonedDateTime gmt = ZonedDateTime.now(tz);
		String formattedGmt = gmt.format(newFormat);
		System.out.println("GMT: " + formattedGmt);
		timeZonesAndTime.put("GMT", formattedGmt);
		
		// Print Current Date and Time in BST, Bangladesh Standard Time, and store it in timeZonesAndTime
		tz = ZoneId.of("Indian/Chagos");
		ZonedDateTime bst = ZonedDateTime.now(tz);
		String formattedBst = bst.format(newFormat);
		System.out.println("BST: " + formattedBst);
		timeZonesAndTime.put("BST", formattedBst);
		
		// Print Current Date and Time in CST, Central Standard Time, and store it in timeZonesAndTime
		tz = ZoneId.of("US/Mountain");
		ZonedDateTime cst = ZonedDateTime.now(tz);
		String formattedCst = cst.format(newFormat);
		System.out.println("CST: " + formattedCst);
		timeZonesAndTime.put("CST", formattedCst);
	}
	// Put 2 more timeZone objects (AST, ZST) into HashMap, sort the HashMap alphabetically, output it in 3 different format styles.
	// Formatting styles, using the imaginary time zone AST
	// AST and ZST are imaginary.
	// Format 1: AST 10/01/2020 19:59
	// Format 2: 10/01/2020 19:59
	// Format 3: 2020-10-01T19:59
	
	@Override
	public void timeZoneHashMap() {
		ZoneId tz = ZoneId.of("Greenwich");
		// Creation of AST, ZST objects in HashMap, given first output format.
		DateTimeFormatter formatOne = DateTimeFormatter.ofPattern("MM/dd/yyyy kk:mm");
		ZonedDateTime ast = ZonedDateTime.of(2020, 10, 01, 19, 59, 0, 0, tz);
		String formattedAst = ast.format(formatOne);
		timeZonesAndTime.put("AST", formattedAst);
		
		// 11/05/2018 19:59
		ZonedDateTime zst = ZonedDateTime.of(2018, 11, 05, 19, 59, 0, 0, tz);
		String formattedZst = zst.format(formatOne);
		timeZonesAndTime.put("ZST", formattedZst);
		
		// Making a new HashMap to hold the sorted version.
		HashMap<String,String> sortedTimeZones = new HashMap<String,String>();
		// Creating a TreeMap to sort the HashMap
		TreeMap<String, String> sortingHashMap = new TreeMap<String, String>();
		sortingHashMap.putAll(timeZonesAndTime);
		// Printing the Tree Map with Format 1, and storing its values in sortedTimeZones:
		System.out.println("Print Style 1:");
		for (Entry<String, String> entry: sortingHashMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			sortedTimeZones.put(entry.getKey(), entry.getValue());
			
		}
		// Array storing key values to help in producing substrings
		ArrayList<String> keySet = new ArrayList<String>(sortedTimeZones.keySet());
		int startOfFormatTwo = 4;
		int endOfFormatTwo = 20;
		// Creating substrings out of sortingHashMap's values to print;
		for (int i = 0; i < keySet.size(); i++) {
			String valueSubstring = (sortedTimeZones.get(keySet.get(i))).substring(startOfFormatTwo, endOfFormatTwo);
			System.out.println(valueSubstring);
		}
		// SimpleDateFormat object to create the third value
		DateTimeFormatter formatThree = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'kk:mm");
		// Parsing ZonedDateTime objects from sortedTimeZones.
		for (int i = 0; i < keySet.size(); i++) {
			CharSequence usedTerm = sortedTimeZones.get(keySet.get(i));
			ZonedDateTime timeZone = ZonedDateTime.parse(usedTerm, formatThree);
			System.out.println(timeZone.toString());
		}
	}
}