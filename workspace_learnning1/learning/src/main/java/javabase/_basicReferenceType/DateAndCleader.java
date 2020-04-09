package javabase._basicReferenceType;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * 测试日期，日历计算
 * @author jiawen
 *
 */
public class DateAndCleader {
    public  Date dateAddOrSub(Date olddate,int se){
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(olddate);
        aCalendar.add(Calendar.DAY_OF_MONTH, se);
        return aCalendar.getTime();
    }
    public  String date2Str(java.util.Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }    
    @Test
    public void tes1(){
    	System.out.println(this.dateAddOrSub(new Date(), 365));
    	
    	Date dateAddOrSub = this.dateAddOrSub(new Date(), -365);
    	System.out.println(dateAddOrSub);
    	System.out.println(this.date2Str(dateAddOrSub, "yyyy"));
		System.out.println(this.date2Str(dateAddOrSub, "MM"));
		System.out.println(this.date2Str(dateAddOrSub, "dd"));    	
    }
}
