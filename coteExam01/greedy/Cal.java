package greedy;

import java.util.Calendar;

public class Cal {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; 
		int day = cal.get(Calendar.DATE); 
		int startDay = cal.get(Calendar.DAY_OF_WEEK);
        int lastDay = cal.getActualMaximum(Calendar.DATE); //해당 월의 마지막 일(date)를 반환
        System.out.println(year); 
        System.out.println(month); 
        System.out.println(day); 
        System.out.println(startDay);  // 일요일은 1, 월요일 2......토요일 7
	    
        System.out.println(year + "년" + month + "월");
	    System.out.println("일  월  화  수  목  금  토");
	    System.out.println("----------------------");
	    //int cnt = 0;
	    
	    for (int i = 1; i < startDay; i++) {
			System.out.print("   ");
			//cnt++;
		}
	    
	    for (int i = 1; i <= lastDay; i++) {
	    	System.out.print(i < 10?" 0" + i :" " + i);
	    	startDay++;
	    	if (startDay % 7 == 0) {
	    		System.out.println();
	    	}
		}
	}
}
