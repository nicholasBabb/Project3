import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	   return (int) (timeInMilliseconds / MILLI_CONVERSION_FACTOR);
	   
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

	@Override
	void dateTimeOfOtherCity() {
		// TODO Auto-generated method stub
		
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