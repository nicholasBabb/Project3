import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

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
	// For the year (2019) and month (10), the fifteenth day is TUESDAY and the last day is THURSDAY
	public void daysOfAnyMonth(int i, int j) {
		YearMonth anyMonth = YearMonth.of(i, j);
		LocalDate fifteenthDayOfMonth = anyMonth.atDay(15);
		String fifteenthDay = fifteenthDayOfMonth.getDayOfWeek().toString();
		LocalDate lastDayOfMonth = anyMonth.atEndOfMonth();
		String lastDay = lastDayOfMonth.getDayOfWeek().toString();
		System.out.println("For the year (" + j + ") and month (" + i + "), the fifteenth day is " +
							fifteenthDay + " and the last day is " + lastDay);
	}
	
//	Read the text file: Dates.txt
//    	
//    	The contents are like: 
//		05.05.2017
//		01.01.2004
//    	
//    	First you will determine the year is a leap year or not. In the second part, calculate the difference 
//    	between today and the given date. Today means the server date during execution.
//    	At the same time, save these date in a Hashmap as HashMap<LocalDate, Integer>
//    	Keys are in the file, for map value use numeric values starting from 1. 
//   	Output format is:
//		2017 is not a leap year, and Difference: 2 years, 5 months, and 3 days.
//		2004 is a leap year, and Difference: 15 years, 9 months, and 7 days.

	public void compareYear() throws IOException {
		// Read in Data.txt into an arrayList dateList
		ArrayList<String> dateList = new ArrayList<String>();
		BufferedReader readIn = new BufferedReader(new FileReader("Dates.txt"));
		String readLineStorage = readIn.readLine();
		while(readLineStorage != null) {
			dateList.add(readLineStorage);
			readLineStorage = readIn.readLine();
		}
		readIn.close();
		
		// Determining if the year is a leap year or not.
	}

	public void dateHashMap() {
		// TODO Auto-generated method stub
		
	}

	public void dateHashMapSorted() {
		// TODO Auto-generated method stub
		
	}
}
