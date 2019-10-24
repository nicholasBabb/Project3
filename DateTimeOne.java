import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TimeZone;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private static final long MILLI_CONVERSION_FACTOR = 1000;
	private long timeInMilliseconds;
	
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
		Calendar calendarDefault = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("kk:mm");
		System.out.println("Time on Server: " + format.format(calendarDefault.getTime()));
		
		// Print Current Time in GMT, Greenwich Mean Time
		TimeZone tz = TimeZone.getTimeZone("Greenwich Mean Time");
		Calendar calendarGMT = new GregorianCalendar(tz);
		System.out.println("GMT: " + format.format(calendarGMT.getTime()));
		
		//Print Current Time in BST, Bangladesh Standard Time
		tz = TimeZone.getTimeZone("Bangladesh Standard Time");
		Calendar calendarBST = new GregorianCalendar(tz);
		System.out.println("BST (90E): " + format.format(calendarBST.getTime()));
		
		//Print Current Time in CST, Central Standard Time
		tz = TimeZone.getTimeZone("Central Standard Time");
		Calendar calendarCST = new GregorianCalendar(tz);
		System.out.println("CST (90W): " + format.format(calendarCST.getTime()));
	}
	
	// Sample Output:
	// GMT: 10/08/2019 20:26
	// BST: 10/09/2019 02:26
	// CST: 10/08/2019 15:26
	// Additionally, store these values in <String, String> hashmap. Time Zone is key,
	// Date and time are value;

	@Override
	public void dateTimeDifferentZone() {
		// Hashmap to store the outputs
		HashMap<String, String> timeZonesAndTime = new HashMap<String,String>();
		
		// Print Current Date and Time in GMT, Greenwich Mean Time, and store it in timeZonesAndTime
		TimeZone tz = TimeZone.getTimeZone("Greenwich Mean Time");
		Calendar calendarGMT = new GregorianCalendar(tz);
		SimpleDateFormat format = new SimpleDateFormat("MM/DD/YYYY kk:mm");
		String timeZoneGMT = format.format(calendarGMT.getTime());
		System.out.println("GMT: " + timeZoneGMT);
		timeZonesAndTime.put("GMT", timeZoneGMT);
		
		// Print Current Date and Time in BST, Bangladesh Standard Time, and store it in timeZonesAndTime
		tz = TimeZone.getTimeZone("Bangladesh Standard Time");
		Calendar calendarBST = new GregorianCalendar(tz);
		String timeZoneBST = format.format(calendarBST.getTime());
		System.out.println("BST: " + timeZoneBST);
		timeZonesAndTime.put("BST", timeZoneBST);
		
		// Print Current Date and Time in CST, Central Standard Time, and store it in timeZonesAndTime
		tz = TimeZone.getTimeZone("Central Standard Time");
		Calendar calendarCST = new GregorianCalendar(tz);
		String timeZoneCST = format.format(calendarCST.getTime());
		System.out.println("BST: " + timeZoneCST);
		timeZonesAndTime.put("CST", timeZoneBST);
	}

	@Override
	void timeZoneHashMap() {
		// TODO Auto-generated method stub
		
	}
}