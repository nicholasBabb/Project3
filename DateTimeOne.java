import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("kk:mm");
		System.out.println("Time on Server: " + format.format(calendar.getTime()));
		
		// Print Current Time in GMT, Greenwich Mean Time
		TimeZone tz = TimeZone.getTimeZone("GMT");
		Calendar calendarGMT = new GregorianCalendar(tz);
		format = new SimpleDateFormat("kk:mm");
		System.out.println("GMT: " + format.format(calendarGMT.getTime()));
		
		//Print Current Time in BST, Bangladesh Standard Time
		tz = TimeZone.getTimeZone("Bangladesh Standard Time");
		Calendar calendarBST = new GregorianCalendar(tz);
		format = new SimpleDateFormat("kk:mm");
		System.out.println("BST (90E): " + format.format(calendarBST.getTime()));
		
		//Print Current Time in CST, Central Standard Time
		tz = TimeZone.getTimeZone("Central Standard Time");
		Calendar calendarCST = new GregorianCalendar(tz);
		format = new SimpleDateFormat("kk:mm");
		System.out.println("CST (90W): " + format.format(calendarCST.getTime()));
	}

	@Override
	void dateTimeDifferentZone() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void timeZoneHashMap() {
		// TODO Auto-generated method stub
		
	}
}