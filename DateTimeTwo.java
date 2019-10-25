import java.time.LocalDate;
import java.time.YearMonth;

public class DateTimeTwo extends MesoDateTimeOneAbstract
{
	
	public void daysOfCurrentMonth() {
		YearMonth thisMonth = YearMonth.now();
		LocalDate tenthDayOfMonth = thisMonth.atDay(10);
		String tenthDay = tenthDayOfMonth.getDayOfWeek().toString();
		LocalDate eighteenthDayOfMonth = thisMonth.atDay(18);
		String eighteenthDay = eighteenthDayOfMonth.getDayOfWeek().toString();
		System.out.println("The tenth day of this month is " + tenthDay + " and eighteenth is " + eighteenthDay);
		
	}

	public void daysOfAnyMonth(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void compareYear() {
		// TODO Auto-generated method stub
		
	}

	public void dateHashMap() {
		// TODO Auto-generated method stub
		
	}

	public void dateHashMapSorted() {
		// TODO Auto-generated method stub
		
	}
}
