package com.panacea;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class ConcurrentDateFormatAccess {
    public static final String DATE_PATTERN = "dd-MM-yyyy";
    public static final String TIME_PATTERN = "H:mm:ss";
    public static final String DATETIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern(DATE_PATTERN);
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern(TIME_PATTERN);
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern(DATETIME_PATTERN);

    // OTHER DATE FORMATTERS
    public static final String DATE_DDMMMYYYY_PATTERN = "dd-MMM-yyyy";
    public static final DateTimeFormatter DATE_DDMMMYYYY_FORMATTER =  DateTimeFormat.forPattern(DATE_DDMMMYYYY_PATTERN);
    public static final String DATE_PATTERN_WITHOUT_SEPARATOR = "ddMMyyyy";
    public static final DateTimeFormatter DATE_FORMATTER_WOT_SEPARATOR = DateTimeFormat.forPattern(DATE_PATTERN_WITHOUT_SEPARATOR);
    
    public static final DateTimeFormatter ISO_DATE_FORMATTER = ISODateTimeFormat.date();
    
    // PRINTING/FORMATTING
    public static String toDateStringFromDate(Date date) {
        return DATE_FORMATTER.print(date.getTime());
    }
    
    public static String toDateTimeStringFromDate(Date dateTime) {
        return DATE_TIME_FORMATTER.print(dateTime.getTime());
    }
    
    public static String toDateStringFromDateTime(DateTime dateTime) {
        return DATE_FORMATTER.print(dateTime);
    }
    
    public static String toDateTimeStringFromDateTime(DateTime dateTime) {
        return DATE_TIME_FORMATTER.print(dateTime);
    }
    
    // PARSING
    public static DateTime toDateTimeFromDateString(String dateString) {
        return DATE_FORMATTER.parseDateTime(dateString);
    }
    
    public static DateTime toDateTimeFromDateTimeString(String dateTime) {
        return DATE_TIME_FORMATTER.parseDateTime(dateTime);
    }
    
    public static Date toDateFromDateString(String dateString) {
        return toDateTimeFromDateString(dateString).toDate();
    }
    
    public static Date toDateFromDateTimeString(String dateTime) {
        return toDateTimeFromDateTimeString(dateTime).toDate();
    }
    
    public static java.sql.Date toSqlDateFromDateString(String dateString) {
        return toSqlDateFromDate(toDateFromDateString(dateString));
    }
    
    // TYPE CONVERSION
    public static DateTime toDateTimeFromDate(Date date) {
        return new DateTime(date.getTime());
    }
    
    public static Date toDateFromDateTime(DateTime dt) {
        return new Date(dt.getMillis());
    }
    
    public static java.sql.Date toSqlDateFromDate(Date dt) {
        return new java.sql.Date(dt.getTime());
    }
    
    public static java.sql.Date toSqlDateFromDateTime(DateTime dt) {
        return new java.sql.Date(dt.getMillis());
    }
    
    public static String toDDMMYYYYFromDDMMMYYYY(String ddMMMyyyy) {
        return DATE_DDMMMYYYY_FORMATTER.parseDateTime(ddMMMyyyy).toString(DATE_FORMATTER);
    }
    
    public static String toDDMMMYYYYFromDDMMYYYY(String ddMMyyyy) {
        return toDateTimeFromDateString(ddMMyyyy).toString(DATE_DDMMMYYYY_FORMATTER);
    }
    
    public static String toISODateFromDDMMYYYY(String ddMMyyyy) {
        return toDateTimeFromDateString(ddMMyyyy).toString(ISODateTimeFormat.date());
    }
    
    public static String toDDMMYYYFromISODate(String isoDate) {
        return ISO_DATE_FORMATTER.parseDateTime(isoDate).toString(DATE_FORMATTER);
    }
    
    public static Date toDateFromISODate(String isoDate) {
        if (isoDate != null && isoDate.length() > 0) {
            Instant instant = LocalDate.parse(isoDate, java.time.format.DateTimeFormatter.ISO_LOCAL_DATE)
                                        .atStartOfDay(ZoneId.systemDefault())
                                        .toInstant();
            return Date.from(instant);
        }
        return null;
    }
    
    public static String toISODateFromDateWOTSeparator(String dateWithoutSeparator) {
        return DATE_FORMATTER_WOT_SEPARATOR.parseDateTime(dateWithoutSeparator).toString(ISO_DATE_FORMATTER);
    }
}
