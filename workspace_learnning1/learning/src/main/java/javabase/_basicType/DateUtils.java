package javabase._basicType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat	s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d3 = new Date(1596174101000L);
		System.out.println(s1.format(d3));
		
		Date d1 = new Date();

		
		try {
			Date d2 = s1.parse("2020-06-03 19:00:00");
			
			System.out.println(d1.before(d2));
			System.out.println(d1.after(d2));
			
			System.out.println("只比较日期");
	        int k = daysBetweenCrossYear(d1, d2);
	        boolean undercons = k>0?false:true;
	        System.out.println(undercons);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static int daysBetweenCrossYear(Date startDate, Date endDate) {
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(startDate);
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(endDate);
        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        int days = day2 - day1;
        return days;
    }	

}
