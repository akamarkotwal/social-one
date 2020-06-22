package org.akcap.socialone.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEqulaityCheck {
	public static boolean checkdate(Date  date,Date date2) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str1= sdf.format(date);
		String str2= sdf.format(date2);
		
		
		
		if(str1.contains(str2)) {
			return true;
		}
		
		return false;
		
	}

}
