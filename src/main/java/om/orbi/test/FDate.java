package om.orbi.test;

import java.text.*;
import java.util.Calendar;
import java.util.*;
import java.util.GregorianCalendar;

public class FDate  extends Date implements Cloneable {
	/**
     * All minutes have this many milliseconds except the last minute of the day on a day defined with
     * a leap second.
     */
    public static final long MILLISECS_PER_MINUTE = 60*1000;

    /**
     * Number of milliseconds per hour, except when a leap second is inserted.
     */
    public static final long MILLISECS_PER_HOUR   = 60*MILLISECS_PER_MINUTE;

    /**
     * Number of leap seconds per day expect on
     * <BR/>1. days when a leap second has been inserted, e.g. 1999 JAN  1.
     * <BR/>2. Daylight-savings "spring forward" or "fall back" days.
     */
    protected static final long MILLISECS_PER_DAY = 24*MILLISECS_PER_HOUR;



    /**
     * Final Constant initialized to 1900/01/01.
     */
    public static final FDate centuryStart = new FDate(1900, 1, 1);

    /**
     * Default Constructor.
     * @roseuid 3C99B1390271
     */
    public FDate() {

    }

    /**
     * Constructor which takes day,month and year
     *
     * @param year
     * @param month
     * @param day
     * @roseuid 3C99B1360148
     */
    public FDate(int year, int month, int day) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(year, month, day, 12, 0);
        setTime(gc.getTime().getTime());
    }
    /**
     * Constructor which takes day,month , year , hours , minutes and seconds
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     */
     public FDate(int year, int month, int day , int hour , int minute , int second) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(year, month, day, hour ,minute ,second);
        setTime(gc.getTime().getTime());
    }

    /**
     * Constructs which accepts java.util.Date.
     *
     * @param date
     * @roseuid 3C99B1330177
     */
    public FDate(java.util.Date date) {
        // setTime(date.getTime() + (long)0x2932e00);
        setTime(date.getTime());
    }

    public FDate(long timeInMillis) {
        setTime(timeInMillis);
    }

    /**
     * Constructor which accepts String.
     * @param s
     * @roseuid 3C99B12B0177
     */
    public FDate(String s) throws Exception {
        try {
            //  setTime(DateFormat.getDateInstance(3).parse(s).getTime() + (long)0x2932e00);
            setTime(DateFormat.getDateInstance(3).parse(s).getTime());
        } catch (Exception e) {
            throw new Exception("Date Exception");
        }
        if (before(centuryStart))
            addMonths(1200);
    }

    /**
     * Returns the year of the date(YYYY).
     *
     * @return int
     * @roseuid 3C99B14B0109
     */
    public int getYear() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(this);
        return gc.get(1);
    }

    /**
     * Returns the month of the date(00-11).
     *
     * @return int
     * @roseuid 3C99B1570000
     */
    public int getMonth() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(this);
        return gc.get(2);
    }

    /**
     * Returns the day of the date(01-31/30).
     *
     * @return int
     * @roseuid 3C99B163005D
     */
    public int getDay() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(this);
        return gc.get(5);
    }

    /**
     * Returns the time in days from a default date.
     *
     * @return int
     * @roseuid 3C99B16A02CE
     */
    public int getTimeInDays() {
        return (int) (getTime() / (long) 0x5265c00);


    }


    /**
     * Retruns whether the date is week end or not.
     *
     * @return boolean
     * @roseuid 3C99B17103A9
     */
    public boolean isWeekend() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(this);
        return gc.get(7) == 7 || gc.get(7) == 1;
    }

    /**
     * Adds the n days to the current date.
     *
     * @param n
     * @roseuid 3C99B178008C
     */
    public FDate addDays(int n) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(this);
        gc.add(Calendar.DATE, n);
        setTime(gc.getTime().getTime());
        return this;
    }

    /**
     * Adds n months to the current date.
     *
     * @param n
     * @roseuid 3C99B17E006D
     */
    public void addMonths(int n) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(this);
//        int d1 = gc.get(5);
        gc.add(Calendar.MONTH, n);
        gc.setTime(gc.getTime());
//        int d2 = gc.get(5);
//        if(d1 != d2)
//            gc.add(5, -d2);
        setTime(gc.getTime().getTime());
    }
    
    /**
     * Adds n Years to the current date.
     *
     * @param n
     * @roseuid 3C99B17E006D
     */
    public void addYears(int n) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(this);
        gc.add(Calendar.YEAR, n);
        gc.setTime(gc.getTime());
        setTime(gc.getTime().getTime());
    }

    /**
     * Creates the EOM for the current month.
     * @roseuid 3C99B184004E
     */
    public void endOfMonth() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(this);
        int m = gc.get(2);
        gc.set(5, 1);
        gc.set(2, m + 1);
        gc.setTime(gc.getTime());
        gc.add(5, -1);
        setTime(gc.getTime().getTime());
    }

    public boolean isEOM() {
        Calendar lCal = new GregorianCalendar();
        lCal.setTime(this);
        int maxDays = lCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        if(this.getDay() == maxDays) return true;
        else return false;
    }

    public void firstOfMonth() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(this);
        int m = gc.get(2);
        gc.set(5, 1);//date field
        gc.set(2, m);
        gc.setTime(gc.getTime());
        setTime(gc.getTime().getTime());
    }


    /**
     * Returns the time in days.
     *
     * @return int
     * @roseuid 3C99B18A0251
     */
    public int hashCode() {
        return getTimeInDays();
    }

    /**
     * Creates a date object and initializes it to the current date.
     *
     * @return FDate
     * @roseuid 3C99B19001F4
     */
    public Object clone() {
        FDate other = new FDate();
        other.setTime(this.getTime());
        return other;
    }

    /**
     * Converts date to the string and returns the same.
     *
     * @return java.lang.String
     * @roseuid 3C99B19603B9
     */
    public String toString() {
        // return DateFormat.getDateInstance(3).format(this);
        return FormatDate.longdate2string(this);


    }


    public String toDateTime() {

        return DateFormat.getDateTimeInstance().format(this);
    }

    public String toCompactDateTime() {

        return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(this);
    }

    /**
     * Return time in milliSeconds since 00:00 AM
     */
    public long getCurrentTime() {

        long time = 0;
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(this);

        time += 60000 * 60 * gc.get(Calendar.HOUR_OF_DAY);
        time += 60000 * gc.get(Calendar.MINUTE);
        time += 1000 * gc.get(Calendar.SECOND);
        time += gc.get(Calendar.MILLISECOND);

        return time;
    }

    /**
     * @param date is of Type date
     * @purpose This methods compares two dates with time part ignored
     */

    public boolean isBefore(FDate date) {
        if (date == null)
            return false;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String date1 = formatter.format(this);
        String date2 = formatter.format(date);
        if (date1.equals(date2))
            return false;
        else
            return this.before(date);
    }

    public boolean isAfter(FDate date) {
        if (date == null)
            return false;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String date1 = formatter.format(this);
        String date2 = formatter.format(date);
        if (this.after(date))
            return true;
        else
            return false;

    }

    public boolean isEquals(FDate date) {
        if (date == null)
            return false;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date1 = formatter.format(this);
        String date2 = formatter.format(date);
        if (date1.equals(date2))
            return true;
        else
            return false;
    }


    /**
     * @param newTimeOffset
     * @purpose The method updates the date object with the supplied time component keeping
     * the date part as same.
     */

    public FDate resetTime() {

        Calendar gc = Calendar.getInstance();  // current date+time
        long timeOfDay = 0;
        timeOfDay += 60000 * 60 * gc.get(Calendar.HOUR_OF_DAY);
        timeOfDay += 60000 * gc.get(Calendar.MINUTE);
        timeOfDay += 1000 * gc.get(Calendar.SECOND);
        timeOfDay += gc.get(Calendar.MILLISECOND);
        long oldTime = 0;
        gc.setTime(this);
        oldTime += 60000 * 60 * gc.get(Calendar.HOUR_OF_DAY);
        oldTime += 60000 * gc.get(Calendar.MINUTE);
        oldTime += 1000 * gc.get(Calendar.SECOND);
        oldTime += gc.get(Calendar.MILLISECOND);
        long newTime = this.getTime() - oldTime + timeOfDay;
        this.setTime(newTime);
        return this;
    }

    public double getJulianDate() {
        int month = this.getMonth() + 1; // since this.getMonth returns one less than actual month
        double extra = 100.0 * this.getYear() + month - 190002.5;
        double julianDate = 367.0 * this.getYear();
        julianDate -= Math.floor(7.0 * (this.getYear() + Math.floor((month + 9.0) / 12.0)) / 4.0);
        julianDate += Math.floor(275.0 * month / 9.0);
        julianDate += this.getDay();
        julianDate += 1721013.5;
        julianDate -= 0.5 * extra / Math.abs(extra);
        julianDate += 1.0;

        return julianDate;
    }

    /**
     *@purpose To get the date component excluding time i.e time is set to 00:00:00
     *@return FDate returns a new object of FDate.
     **/

    public FDate getDateOnly() {
        try {
            //return FormatDate.string2FDate(FormatDate.date2string(this, FormatDate.SHORT_DATE), FormatDate.SHORT_DATE); MADHU
            return FormatDate.string2FDate(FormatDate.date2string(this, FormatDate.SHORT_DATE_MMM), FormatDate.SHORT_DATE_MMM);

        } catch (Exception e) {
            e.printStackTrace();
            return this;
        }


    }

    /**
     *@purpose To get the first day of Month
     *@returns First day of month in String format
     **/
    public static String getFirstDayOfMonth(String pdate) {
        String pDate=null;
    	if(pdate.indexOf("/")>-1)
    	pDate=pdate;
    	return "01" + pDate.substring(pDate.indexOf("/"), pDate.length());
    }

    /**
     *@purpose To get the last day of prev Month
     *@returns First day of month in String format
     **/

    public static String getLastDayOfPrevMonth(String pdate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        java.util.Date lDate = sdf.parse(pdate);
        Calendar lCal = new GregorianCalendar();
        lCal.setTime(lDate);

        // rolling the date by one date back
        lCal.roll(Calendar.DATE, false);

        return sdf.format(lCal.getTime());
    }

    public static FDate getReqdDateofGivenWeek(FDate date, int day) throws Exception {

      Calendar lCal = new GregorianCalendar();
      lCal.setTime(date);
      lCal.set(Calendar.DAY_OF_WEEK, day);
		  //System.out.println("Date " + lCal.getTime());
      return new FDate(lCal.getTime());
    }
    public int getNoOfDays() {
        Calendar lCal = new GregorianCalendar();
        lCal.setTime(this);
        return lCal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }





    public boolean isBetween(FDate startdt,FDate enddt){
        if(this.compareTo(startdt)>=0 && this.compareTo(enddt)<=0  )return true;
        else return false;
    }
     //Author Madhu
    //Purpose of this method to get the DAY_OF_YEAR.
    //Ex : 060 for March 01 in the year 2005 ,061 for March 01 in the year 2004(LeapYear)
     public int getDayOfYear() {
           Calendar lCal = new GregorianCalendar();
           lCal.setTime(this);
           return lCal.get(lCal.DAY_OF_YEAR);
       }

    /**
     *
     * @param endDate
     * @return
     * This method would take the current (this) as start date and return the days between considering the offset in
     * case of day light saving.
     *
     */
 	public int daysBetween(FDate endDate) {
 		Calendar end = new GregorianCalendar();
 		end.setTime(endDate);
 		Calendar start = new GregorianCalendar();
 		start.setTime(this);
        long endL   =  end.getTimeInMillis() +  end.getTimeZone().getOffset(  end.getTimeInMillis() );
        long startL = start.getTimeInMillis() + start.getTimeZone().getOffset( start.getTimeInMillis() );
        return (int) ((endL - startL) / MILLISECS_PER_DAY);
 	}


    /**
     *@purpose For Testing
     **/
    public static void main(String[] args) {
        FDate fd1 = new FDate(2003, 9, 27);
        FDate fd2 = new FDate(2004, 9, 27);
        //fd1=fd1.getDateOnly();
        //fd2=fd2.getDateOnly();
        Date date = new Date();
        System.out.println("Get to day date : "+new FDate(date));
        System.out.println("fd1 = " + fd1);
        System.out.println("fd2 = " + fd2);
		System.out.println("fd1 time = " + fd1.getTime());
        System.out.println("fd2 time = " + fd2.getTime());
        //System.out.println("Days = " + (fd2.getTimeInDays() - fd1.getTimeInDays()));
		System.out.println("Days = " + fd1.daysBetween(fd2));

        //System.out.println("Julian date is = " + (int)fd.getJulianDate());
    }


    public int getDayOfWeek() {
         GregorianCalendar gc = new GregorianCalendar();
         gc.setTime(this);
        int dayOfWeek = gc.get(Calendar.DAY_OF_WEEK);
/****
        switch (dayOfWeek) {
            case Calendar.MONDAY:
                dayOfWeek = 2;
                break;
            case Calendar.TUESDAY:
                dayOfWeek = 3;
                break;
            case Calendar.WEDNESDAY:
                dayOfWeek = 4;
                break;
            case Calendar.THURSDAY:
                dayOfWeek = 5;
                break;
            case Calendar.FRIDAY:
                dayOfWeek = 6;
                break;
            case Calendar.SATURDAY:
                dayOfWeek = 7;
                break;
            case Calendar.SUNDAY:
                dayOfWeek = 1;
                break;
        }
***/
        return dayOfWeek;

    }
    public FDate getNextDay(int dayOfWeek){
    	FDate date = this.getDateOnly();
		for(int i = 1 ; i <= 7; i++){
			FDate origDate = this.getDateOnly();
			date = origDate.addDays(i);
			if(date.getDayOfWeek() == dayOfWeek)
				break;
		}
		//System.out.println("Next day : " + date.toString());
    	return date;
    }
    /**
     * This methods compares two dates with time part if the isTimeStampReq is true.
     * @param dateToCompare - Date to compare
     * @param isTimeStampReq - pass 'true' if we needs to compare dates with timeStamp, else calling the isBefore(FDate) method which compare without timeStamp.
     * @return
     */
    
    public boolean isBefore(FDate dateToCompare, boolean isTimeStampReq) {
    	if(!isTimeStampReq)
    		return isBefore(dateToCompare);
    	else if (dateToCompare == null)
    		return false;
        else
        	return this.before(dateToCompare);
    }
    /**
     *@purpose To get the date component excluding time i.e without timestamp
     *@return String returns a new String.
     **/

    public String getDateWithoutTime() {
    	try {
    		int index=-1;
    		String date="";
    		index =this.toString().indexOf(" ");  
    		if(index!=-1)
    		{
    			date=this.getDateOnly().toString().substring(0,index);
    			return date;
    		}
    		else
    			return this.toString();
    	} catch (Exception e) {
    		e.printStackTrace();
    		return this.toString();
    	}
    }
    /**
     * The purpose of this method is to return the Last day of the month for the given date.
     * @param date
     * @return
     */
    public String getLastdayofMonth(FDate date){
    	String pdateWithOutTime = date.getDateWithoutTime().toString();
    	String pDate=null;
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int lastDate = calendar.getActualMaximum(Calendar.DATE);
    	calendar.set(lastDate, date.getMonth(),date.getYear());
    	if(pdateWithOutTime.indexOf("-")>-1)
    		pDate=pdateWithOutTime;
    	return lastDate + pDate.substring(pDate.indexOf("-"), pDate.length());
    }
	  /**
     *@purpose To get the first day of Month
     *@returns First day of month in String format
     **/
    public static String getFirstDayOfMon(String pdate) {
        String pDate=null;
    	if(pdate.indexOf("-")>-1)
    	pDate=pdate;
    	return "01" + pDate.substring(pDate.indexOf("-"), pDate.length());
    }
	
	 public boolean isBefore(FDate date1,FDate date2) {
        if (date1 == null || date2==null)
            return false;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String dateS1 = formatter.format(date1);
        String dateS2 = formatter.format(date2);
        Date fd1 = null,fd2 = null;
		try {
			fd1 = formatter.parse(dateS1);
		    fd2 = formatter.parse(dateS2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        if (fd1.before(fd2))
            return true;
        else
            return false;
    }

    public boolean isAfter(FDate date1,FDate date2) {
    	 if (date1 == null || date2==null)
             return false;
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
         String dateS1 = formatter.format(date1);
         String dateS2 = formatter.format(date2);
         Date fd1 = null,fd2 = null;
 		try {
 			fd1 = formatter.parse(dateS1);
 		    fd2 =  formatter.parse(dateS2);
 		} catch (ParseException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        
         if (fd1.after(fd2))
             return true;
         else
             return false;

    }

    public boolean isEquals(FDate date1,FDate date2) {
    	 if (date1 == null || date2==null)
             return false;
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
         String dateS1 = formatter.format(date1);
         String dateS2 = formatter.format(date2);
         Date fd1 = null,fd2 = null;
 		try {
 			fd1 = formatter.parse(dateS1);
 		    fd2 = formatter.parse(dateS2);
 		} catch (ParseException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        
         if (fd1.equals(fd2))
             return true;
         else
             return false;
    }
}
