package com.panacea;


import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Utility class to format the data
 */
public class FormatUtils {
    public static final List<String> MONTHS = Lists.newArrayList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC");
    public static final String DATE_SEP_CHAR = "-";
    public static final CharMatcher DATE_SEPARATORS = CharMatcher.anyOf("/" + DATE_SEP_CHAR);
    public static final String TIME_SEP_CHAR = ":";
    public static final CharMatcher TIME_SEPARATOR = CharMatcher.anyOf(DATE_SEP_CHAR + TIME_SEP_CHAR);
    public static final String DATE_TIME_SEP_CHAR = " ";
    public static final CharMatcher DATE_TIME_SEPARATOR = CharMatcher.anyOf(DATE_TIME_SEP_CHAR);
    public static final String TIME_MS_SEP = ".";
    public static final String DEFAULT_VALUE_SEPARATOR = "|";
    private static final String SQL_QUOTE = "'";
    private static final int TIME_VALUE_LENGTH = 6;
    private static final String DEFAULT_TIME = "00:00:00";
    /**
     * Reverse the date.
     * 
     * @param date
     * @param Present
     *            Date Format (DD-MM-YYYY or YYYY-MM-DD)
     * @return String - Reversed date.
     */
    public static String reverseDate(String date, String dateFormat) {
        String reversedDate = null;
        try {
            if (dateFormat.equalsIgnoreCase("DD-MM-YYYY")) {
                reversedDate = date.substring(6, 10) + "-" +  date.substring (3, 5) + "-" + date.substring(0, 2);
            } else if (dateFormat.equalsIgnoreCase("YYYY-MM-DD")) {
                reversedDate = date.substring(8, 10) + "-" +  date.substring (5, 7) + "-" + date.substring(0, 4);
            } else if (dateFormat.equalsIgnoreCase("DDMMYYYY")) {
                reversedDate = date.substring(4, 8) + "-" +  date.substring (2, 4) + "-" + date.substring(0, 2);
            }
            if (date.length() >= 12 && ((date.charAt(11) >= '1' && date.charAt(11) <= '9') || (date.charAt(12) >= '1' && date.charAt(12) <= '9'))) {
                reversedDate = reversedDate + " " + date.substring(11, 19);
            }
        } catch (Exception e) {
            System.out.println("FormatUtils (reverseDate) : " + e.getMessage());
        }
        return reversedDate;
    }

    /**
     * Formats the given date in the format of DD-Mon-Year
     * @param DDMMYear
     * @return string
     */
    public static String formatToDDMonYear(String DDMMYear) {
        if(StringUtils.isBlank(DDMMYear)) {
            return "";
        }
        String dateAlone = stripOffTimePart(DDMMYear);
        Iterable<String> dateParts = dateIterable(dateAlone);
        StringBuilder sb = new StringBuilder();
        sb.append(Iterables.get(dateParts, 0)).append(DATE_SEP_CHAR)
                .append(monthName(Iterables.get(dateParts, 1))).append(DATE_SEP_CHAR)
                .append(Iterables.get(dateParts, 2));
        return sb.toString();
    }

    /**
     * Formats the time portion of the given date-time string as "00:00:00" upto the seconds portion
     * And the date portion is stripped off automatically
     * @param dateTimeStr
     * @return
     */
    private static String formatTimePart(String dateTimeStr) {
        String timePart = stripOffDatePart(dateTimeStr);
        if(StringUtils.isBlank(timePart)) {
            timePart = DEFAULT_TIME;
        } else {
            timePart = CharMatcher.anyOf(".:-").removeFrom(timePart);
            if(timePart != null && timePart.length() > TIME_VALUE_LENGTH) {
                timePart = timePart.substring(0, TIME_VALUE_LENGTH);
            }
            timePart = StringUtils.rightPad(timePart, TIME_VALUE_LENGTH, '0');
            timePart = Joiner.on(TIME_SEP_CHAR).join(Splitter.fixedLength(2).split(timePart));
        }
        return timePart;
    }
    
    public static String formatToDDMonYearhh24miss(String DDMMYearhh24miss) {
        if (DDMMYearhh24miss == null) {
            return null;
        }
        String date = formatToDDMonYear(DDMMYearhh24miss);
        String time = formatTimePart(DDMMYearhh24miss);
        return "TO_DATE('" + date + " " + time + "','DD-MON-YYYY HH24:MI:SS')";
    }

    /**
     * To strip off time part separated by SPACE from the given date time string
     * @param dateTime
     * @return
     */
    public static String stripOffTimePart(String dateTime) {
        return Splitter.on(DATE_TIME_SEPARATOR).trimResults().omitEmptyStrings().splitToList(dateTime).get(0);
    }
    
    /**
     * Takes out the date portion separated by SPACE from the given date-time string 
     * and returns only the time portion
     * @param dateTime
     * @return
     */
    public static String stripOffDatePart(String dateTime) {
        Iterable<String> dateTimeIt = dateTimeIterable(dateTime);
        String timePart = (Iterables.size(dateTimeIt) == 2 ? Iterables.get(dateTimeIt, 1) : "");
        return timePart;
    }
    
    /**
     * Removes any comma character from the given amount
     * @param amount
     * @return
     */
    public static String removeFormat(String amount) {
        return unFormat(amount);
    }

    /**
     * Formats the given date string given as DD-MMM-YYY
     * and returns it as "DD-MM-YYYY"
     * @param DDMonYear
     * @return
     */
    public static String formatToDDMMYear(String DDMonYear) {
        if (StringUtils.isBlank(DDMonYear)) {
            return "";
        }
        String dateAlone = stripOffTimePart(DDMonYear);
        Iterable<String> dateParts = dateIterable(dateAlone);
        String paddedMonth = monthPos(Iterables.get(dateParts, 1)); 
        StringBuilder sb = new StringBuilder();
        sb.append(Iterables.get(dateParts, 0)).append("-")
                            .append(paddedMonth).append("-")
                            .append(Iterables.get(dateParts, 2));
        return sb.toString();
    }

    /**
     * Splits the given date string based on "-" character
     * and returns an Iterable instance
     * @param dateStr
     * @return
     */
    private static Iterable<String> dateIterable(String dateStr) {
        return Splitter.on(DATE_SEPARATORS).trimResults().omitEmptyStrings().split(dateStr);
    }
    
    /**
     * Splits the date and time part, based on SPACE character, for the given date-time string
     * and returns an Iterable instance
     * @param dateTimeStr
     * @return
     */
    private static Iterable<String> dateTimeIterable(String dateTimeStr) {
        return Splitter.on(DATE_TIME_SEPARATOR).trimResults().omitEmptyStrings().split(dateTimeStr);
    }
    
    /**
     * Returns 3 character month name for the given month of the year position
     * @param monthPos
     * @return
     */
    public static String monthName(String monthPos) {
        int pos = NumberUtils.toInt(monthPos) - 1;
        return MONTHS.get(pos);
    }
    
    /**
     * Returns the two digit number value, as the month of the year, for the given month name
     * @param month
     * @return
     */
    public static String monthPos(String month) {
        String formattedMonth = month.substring(0, 3).toUpperCase();
        int pos = MONTHS.indexOf(formattedMonth) + 1;
        return StringUtils.leftPad(String.valueOf(pos), 2, '0');
    }
    
    /**
     * Formats the decimal part alone based on the given decLen value.
     * The parts before the decimal point remains same with at least a '0' ahead.
     * @param inValue
     * @param decLen
     * @return
     */
    public static String FormatDoubleValue(double inValue, int decLen) {
        String fmtAmt = "0.";
        for (int i = 1; i <= decLen; i++) {
            fmtAmt += "#";
        }
        return FormatDoubleValue(inValue, fmtAmt);
    }

    public static String FormatDoubleValue(double value, String format) {
        DecimalFormat DecimalForm = new DecimalFormat(format);
        DecimalForm.setParseIntegerOnly(true);
        return DecimalForm.format(value);
    }
    
    /**
     * Removes any comma from the given number string
     * @param num
     * @return
     */
    public static String unFormat(String num) {
        return StringUtils.replace(StringUtils.trimToEmpty(num), ",", "");
    }
    
    /**
     * Returns TimeStamp from the given date-time string value
     * @param dateTime
     * @return
     */
    public static Timestamp timeStampFromDateTimeString(String dateTime) {
        Timestamp ret = null;
        if(StringUtils.isNotBlank(dateTime)) {
            String[] parts = Iterables.toArray(dateTimeIterable(dateTime), String.class);
            if(parts.length == 2) {
                parts[1] = formatTimePart(dateTime);
                String dateTimeValue = Joiner.on(DATE_TIME_SEP_CHAR).join(parts);
                ret = new Timestamp(ConcurrentDateFormatAccess.toDateFromDateTimeString(dateTimeValue).getTime());
            } else if (parts.length == 1){
                ret = new Timestamp(ConcurrentDateFormatAccess.toDateFromDateString(parts[0]).getTime());
            }
        }
        return ret;
    }
    
    /**
     * Returns "Y" or "N", with/without the quote, based on the passed "quote" argument value
     * @param b
     * @param quote
     * @return
     */
    public static String booleanToString(boolean b, boolean quote) {
        if (b) {
            return (quote) ? "'Y'" : "Y";
        } else {
            return (quote) ? "'N'" : "N";
        }
    }
    
    /**
     * Returns true if the given string value is "Y", or false otherwise
     * @param s
     * @return
     */
    public static boolean stringToBoolean(String s) {
        return toBoolean(s);
    }
    
    
    /**
     * Returns the first character of the given string s. 
     * In case its null or empty, it returns a BLANK character.
     * @param s
     * @return
     */
    public static char stringToChar(String s) {
        if (StringUtils.isBlank(s)) {
            return ' ';
        }
        return s.charAt(0);
    }
    
    /**
     * Returns '0' if the given string is blank, otherwise returns the first chracter of the given
     * string s. 
     * @param s
     * @return
     */
    public static char formatBoolean(String s) {
        if(StringUtils.isBlank(s)) {
            return '0';
        }
        return s.trim().charAt(0);
    }
    
    /**
     * If the value is true, returns '1' otherwise, returs '0'
     * @param value
     * @return
     */
    public static char formatBoolean(boolean value) {
        return value ? '1' : '0';
    }
    
    /**
     * If the given value is "true" or "1" or "y", then returns true
     * otherwise false
     * @param value
     * @return
     */
    public static boolean toBoolean(String value) {
        boolean result = false;
        if(StringUtils.isNotBlank(value)) {
            if(StringUtils.equalsIgnoreCase("true", value.trim())
                    || StringUtils.equals("1", value.trim())
                    || StringUtils.equalsIgnoreCase("y", value.trim())) {
                result = true;
            }
        }
        return result;
    }
    
    public static String charToString(char c) {
        char list[] = new char[] {c};
        return new String(list);
    }
    
    public static String escapeString(String str, int maxLen, boolean quote) {
        if (str == null) {
            if (quote) {
                return SQL_QUOTE + SQL_QUOTE;
            } else {
                return "";
            }
        }

        int strLen = str.length();
        if (strLen > maxLen) {
            str = str.substring(0, maxLen);
        }

        StringBuffer buf = new StringBuffer(strLen + 20);
        if (quote) {
            buf.append(SQL_QUOTE);
        }
        int start = 0;
        int end = str.indexOf(SQL_QUOTE);
        while (end != -1) {
            buf.append(str.substring(start, end));
            buf.append(SQL_QUOTE).append(SQL_QUOTE);
            start = end;
            if (start < strLen - 1) {
                end = str.indexOf(SQL_QUOTE, ++start);
            } else {
                end = -1;
            }
        }
        if (start < strLen && !str.endsWith(SQL_QUOTE)) {
            buf.append(str.substring(start));
        }

        if (quote) {
            buf.append(SQL_QUOTE);
        }
        return buf.toString();
    }
    
    /**
     * Splits the given string by the given separator.
     * If the separator is not given, by default, it assumes, a pipe character
     * @param separator
     * @param source
     * @return
     */
    public static String[] splitString(String source, String ... separator ) {
        String sep = DEFAULT_VALUE_SEPARATOR;
        if(ArrayUtils.isNotEmpty(separator)) {
            sep = StringUtils.defaultIfBlank(separator[0], DEFAULT_VALUE_SEPARATOR);
        }
        String src = StringUtils.defaultIfBlank(source, "");
        return Splitter.on(sep).omitEmptyStrings().trimResults().splitToList(src).toArray(new String[]{});
    }
}

