package com.panacea;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.YearMonth;
import org.joda.time.Years;

public final class DateUtility {
    public final static String Dtformat = ConcurrentDateFormatAccess.DATE_PATTERN;
    public final static DateTimeComparator DATE_COMPARATOR = DateTimeComparator.getDateOnlyInstance();
    public static final int DATEGREATERTHAN = 500;
    public static final int DATEGREATERTHANOREQUAL = 501;
    public static final int DATELESSTHAN = 502;
    public static final int DATELESSTHANOREQUAL = 503;
    public static final int DATEEQUAL = 504;
    
    public final static int YEAR = 1;
    public final static int MONTH = 2;
    public final static int DAY = 5;

    public static String addToDate(String Datestring, int fieldtoadd, int addValue) throws ParseException {
        Calendar c1 = getCalender(Dtformat, Datestring);
        c1.add(fieldtoadd, addValue);
        return new SimpleDateFormat(Dtformat).format(c1.getTime());
    }

    public static String subtractFromDate(String Datestring, int fieldtosub, int subValue) throws ParseException {
        if (subValue > 0) {
            subValue = subValue * -1;
        }
        return addToDate(Datestring, fieldtosub, subValue);
    }

    public static long daysBetweenDates(String dateString1, String dateString2) {
        DateTime dt1 = ConcurrentDateFormatAccess.toDateTimeFromDateString(FormatUtils.stripOffTimePart(dateString1));
        DateTime dt2 = ConcurrentDateFormatAccess.toDateTimeFromDateString(FormatUtils.stripOffTimePart(dateString2));
        return Math.abs(Days.daysBetween(dt1, dt2).getDays());
    }

    public static String Get_Date_Format(String Datestring, String Curr_Format, String New_Format) throws ParseException {
        Calendar c1 = getCalender(Curr_Format, Datestring);
        return new SimpleDateFormat(New_Format).format(c1.getTime());
    }

    private static Calendar getCalender(String DateFt, String DateObj) throws ParseException {
        SimpleDateFormat fm = new SimpleDateFormat(DateFt);
        fm.setLenient(false);
        fm.parse(DateObj);
        return fm.getCalendar();
    }

    private static boolean compareDates(String DateFt, String DateString1, String DateString2, int tocheck) {
        try {
            Calendar c1 = getCalender(DateFt, DateString1);
            Calendar c2 = getCalender(DateFt, DateString2);

            switch (tocheck) {
            case DATEGREATERTHAN:
                if (c1.after(c2))
                    return true;
                break;
            case DATEGREATERTHANOREQUAL:
                if (c1.after(c2) || (c1.equals(c2)))
                    return true;
                break;
            case DATELESSTHAN:
                if (c1.before(c2))
                    return true;
                break;
            case DATELESSTHANOREQUAL:
                if (c1.before(c2) || (c1.equals(c2)))
                    return true;
                break;
            case DATEEQUAL:
                if (c1.equals(c2))
                    return true;
                break;
            default:
                return false;
            }
            return false;
        } catch (ParseException e) {
            return false;
        }
    }

    // default Date Format - dd-MM-YYYY
    public static boolean DateGreaterThan(String DateString1, String DateString2) {
        return compareDates(Dtformat, DateString1, DateString2, DATEGREATERTHAN);
    }

    public static boolean DateGreaterThan(String DateString1, String DateString2, String DateFormat) {
        return compareDates(DateFormat, DateString1, DateString2, DATEGREATERTHAN);
    }

    public static boolean DateGreaterThanOrEqual(String DateString1, String DateString2) {
        return compareDates(Dtformat, DateString1, DateString2, DATEGREATERTHANOREQUAL);
    }

    public static boolean DateGreaterThanOrEqual(String DateString1, String DateString2, String DateFormat) {
        return compareDates(DateFormat, DateString1, DateString2, DATEGREATERTHANOREQUAL);
    }

    public static boolean DateLessThan(String DateString1, String DateString2) {
        return compareDates(Dtformat, DateString1, DateString2, DATELESSTHAN);
    }

    public static boolean DateLessThan(String DateString1, String DateString2, String DateFormat) {
        return compareDates(DateFormat, DateString1, DateString2, DATELESSTHAN);
    }

    public static boolean DateLessThanOrEqual(String DateString1, String DateString2) {
        return compareDates(Dtformat, DateString1, DateString2, DATELESSTHANOREQUAL);
    }

    public static boolean dateLessThanOrEqual(DateTime dateTime1, DateTime dateTime2) {
        int result = compareDatesWithoutTime(dateTime1, dateTime2);
        return result <= 0;
    }
    
    public static boolean dateLessThanOrEqual(Date date1, Date date2) {
        int result = compareDatesWithoutTime(date1, date2);
        return result <= 0;
    }
    
    private static int compareDatesWithoutTime(Object date1, Object date2) {
        return DATE_COMPARATOR.compare(date1, date2);
    }
    
    public static boolean DateLessThanOrEqual(String DateString1, String DateString2, String DateFormat) {
        return compareDates(DateFormat, DateString1, DateString2, DATELESSTHANOREQUAL);
    }

    public static boolean DateEqual(String DateString1, String DateString2) {
        return compareDates(Dtformat, DateString1, DateString2, DATEEQUAL);
    }

    public static boolean DateEqual(String DateString1, String DateString2, String DateFormat) {
        return compareDates(DateFormat, DateString1, DateString2, DATEEQUAL);
    }

    public static boolean isLeapYear(int year) {
        return isLeap(year);
    }

    public static boolean isValidDate(String date) {
        return isValidDate(date, Dtformat);
    }

    public static boolean isValidDate(String date, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        sdf.setLenient(false);
        Date testDate = null;
        try {
            testDate = sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static boolean isLeap(int yyyy) {
        return DateTime.now().withYear(yyyy).year().isLeap();
    }

    /**
     * Returns the no of days of the given month of the given year
     * @param mm
     * @param yyyy
     * @return
     */
    public static int daysInMonth(int mm, int yyyy) {
        YearMonth ym = new YearMonth(yyyy, mm);
        DateTime now = DateTime.now();
        return ym.toDateTime(now).dayOfMonth().getMaximumValue();
    }

    /**
     * 
     * 
     * @param dd_mm_yyyy
     *            string of form "dd_mm_yyyy".
     * @return the no of broken days in a month between the given two dates
     */

    public static int getBrokenDays(String dd_mm_yyyy1, String dd_mm_yyyy2) {
        try {
            if ((dd_mm_yyyy1.length() != 10) || (dd_mm_yyyy2.length() != 10)) {
                return 0;
            }   
            
            DateTime dt1 = ConcurrentDateFormatAccess.toDateTimeFromDateString(dd_mm_yyyy1);
            DateTime dt2 = ConcurrentDateFormatAccess.toDateTimeFromDateString(dd_mm_yyyy2);
            
            PeriodType periodType = PeriodType.yearMonthDayTime();
            Period period = new Period(dt1, dt2, periodType);
            return Math.abs(period.getDays());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int getYears(String dd_mm_yyyy1, String dd_mm_yyyy2) {
        try {
            if ((dd_mm_yyyy1.length() != 10) || (dd_mm_yyyy2.length() != 10)) {
                return 0;
            }
            DateTime dt1 = ConcurrentDateFormatAccess.toDateTimeFromDateString(dd_mm_yyyy1);
            DateTime dt2 = ConcurrentDateFormatAccess.toDateTimeFromDateString(dd_mm_yyyy2);
            return Math.abs(Years.yearsBetween(dt1, dt2).getYears());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public static int getMonths(String dd_mm_yyyy1, String dd_mm_yyyy2) {
        try {
            if ((dd_mm_yyyy1.length() != 10) || (dd_mm_yyyy2.length() != 10)) {
                return 0;
            }
            
            DateTime dt1 = ConcurrentDateFormatAccess.toDateTimeFromDateString(dd_mm_yyyy1);
            DateTime dt2 = ConcurrentDateFormatAccess.toDateTimeFromDateString(dd_mm_yyyy2);
            return Math.abs(Months.monthsBetween(dt1, dt2).getMonths());
            
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private DateUtility() {};

}