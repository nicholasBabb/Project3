
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

	@Override
	public void dateTimeNow() {
		
		
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