
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
}