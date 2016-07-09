package miscCodingQuestions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/*Virtual Year Explanation: From geeksForGeeks
 * http://www.geeksforgeeks.org/find-day-of-the-week-for-a-given-date/
 * Last comment from kprocks 4 years ago .. 
 * */
public class FindDayOfaYear {

	
	public static int findDayOfYear(int d, int m, int y){
		int[] monthAdjustment = {0,3,2,5,0,3,5,1,4,6,2,4};// 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4
		y = (m < 3)? y-1: y;
		
		return (d + y + y/4 + y/400 - y/100 + monthAdjustment[m-1]) % 7;
	}
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		int result  = findDayOfYear(24,4,1989);
		Map<Integer, String> dayMap = new HashMap<Integer, String>();
		dayMap.put(0, "Sunday");
		dayMap.put(1, "Monday");
		dayMap.put(2, "Tuesday");
		dayMap.put(3, "Wednesday");
		dayMap.put(4, "Thursday");
		dayMap.put(5, "Friday");
		dayMap.put(6, "Saturday");
		
		System.out.println("Using K&R C Function");
		// Refer: https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week
		System.out.println(dayMap.get(result));
		
		/****************************************************/
		/*The following prints the date using Java inbuilt functionalities*/
		
		System.out.println("Using Java inbuilt Calender library");
		
		String input_date="24/04/1989";
		SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		Date dt1=format1.parse(input_date);
		DateFormat format2=new SimpleDateFormat("EEEE"); 
		String finalDay=format2.format(dt1);
		System.out.println(finalDay);
	}

}
