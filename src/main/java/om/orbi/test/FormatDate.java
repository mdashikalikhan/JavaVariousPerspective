package om.orbi.test;

import java.text.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.*;

public class FormatDate {
	private static String dateFormat = "dd-MMM-yyyy";
	private static String longDateFormat = "dd-MMM-yyyy HH:mm:ss";



    private static java.util.TimeZone TIMEZONE = java.util.TimeZone.getDefault();
    public static String SHORT_DATE	= "dd-MMM-yyyy"; //"dd/MM/yy";
    public static String SHORT_DATE_MMM	= "dd-MMM-yyyy";
    public static String LONG_DATE	= "dd-MMM-yy HH:mm:ss";
    public static String LONG_DATE_MMM	= "dd-MMM-yyyy HH:mm:ss";
    public static String MONTH_DATE     = "MMM yy";
    public static String TIME_FORMAT = "HH:mm:ss";
    public static java.util.Locale LOCALE = java.util.Locale.getDefault();
    public static HashMap dateFormats = null;
    public static String LONG_DATE_TIME = "HH:mm:ss dd-MMM-yyyy";  
    public static String pubDateFormat = "dd-MMM-yyyy";
    public static String SHORT_DATE_MM	= "dd-MM-yyyy";
    public static String TWELVE_HRS_FORMAT = "yyyy-MM-dd h:mm:ss";
    public static String TWENTYFOUR_HRS_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
	/**
	* Function to convert java.util.Date to java.sql.Date
	* @param inDate java.util.Date
	*/

	public static java.sql.Date util2sql (java.util.Date inDate) {
		if (inDate == null) return null;
		java.sql.Date sqlDate;
		sqlDate = new java.sql.Date(inDate.getTime());
		return sqlDate ;
	}

	/**
	* Function to convert java.util.Date to java.sql.Timestamp
	* @param inDate java.util.Date
	*/

	public static java.sql.Timestamp util2timestamp (java.util.Date inDate) {
		if (inDate == null) return null;
		java.sql.Timestamp sqlDate;
		sqlDate = new java.sql.Timestamp(inDate.getTime());
		return sqlDate ;
	}

    /**
     * @Purpose To convert the java.sql.Date Object to java.sql.Timestamp
     * @param inDate java.sql.Date
     */
    public static java.sql.Timestamp sql2timestamp (java.sql.Date inDate) {
		if (inDate == null) return null;
		java.sql.Timestamp sqlDate;
		sqlDate = new java.sql.Timestamp(inDate.getTime());
		return sqlDate ;
	}

	/**
	* Function to convert java.sql.Date to java.util.Date
	* @param inDate java.sql.Date
	*/

	public static java.util.Date sql2util (java.sql.Date inDate) {
		if (inDate == null) return null;
		return (java.util.Date)inDate;
	}

	/**
	* Function to convert java.sql.Date to FDate
	* @param inDate java.sql.Date
	*/

	public static FDate sql2FDate (java.sql.Date inDate) {
		if (inDate == null) return null;
		return new FDate((java.util.Date)inDate);
	}

	/**
	* Function to convert java.sql.Timestamp to java.util.Date
	* @param inDate java.sql.Timestamp
	*/

	public static java.util.Date timestamp2util (java.sql.Timestamp inDate) {
		if (inDate == null) return null;
		return (java.util.Date)inDate;
	}

    /**
     * Function to convert java.sql.Timestamp to customised FDate.
     * @param inDate
     * @return
     */
	public static FDate timestamp2FDate (java.sql.Timestamp inDate) {
		if (inDate == null) return null;
		return new FDate((java.util.Date)inDate);
	}

	/**
	* Function to convert String in DD-MMM-YYYY or DD-MMM-YYYY HH:mm:ss format to java.util.Date
	* @param inStr String
	*/

	public static java.util.Date string2util (String inStr) throws java.text.ParseException {
		if (inStr == null) return null;
		inStr = inStr.trim();
		if (inStr.equals("")) return null;
		if (inStr.length() > 11 ) {
			SimpleDateFormat formatter1 = new SimpleDateFormat (longDateFormat); // dd-MMM-yyyy HH:MI:SS
			formatter1.setTimeZone(FormatDate.TIMEZONE);
			return formatter1.parse(inStr); }
		else if (inStr.length() > 8 ) {
			SimpleDateFormat formatter1 = new SimpleDateFormat (dateFormat); // dd-MMM-yyyy
			formatter1.setTimeZone(FormatDate.TIMEZONE);
			return formatter1.parse(inStr); }
		else {
			SimpleDateFormat formatter1 = new SimpleDateFormat ("dd/MM/yy"); // dd/MM/YY
			formatter1.setTimeZone(FormatDate.TIMEZONE);
			return formatter1.parse(inStr); }
	}

	/**
	* Function to convert String in Given format to java.util.Date
	* @param inStr String
	*/

	public static java.util.Date string2util (String inStr, String format) throws java.text.ParseException {
		if (inStr == null) return null;
		inStr = inStr.trim();
		if (inStr.equals("")) return null;
		inStr = inStr.trim();

		SimpleDateFormat formatter = new SimpleDateFormat( format );
		formatter.setTimeZone(FormatDate.TIMEZONE);
			return formatter.parse(inStr);
	}

    /**
     * Function to convert string to our customised Date
     * @param inStr
     * @return
     * @throws java.text.ParseException
     */
	public static FDate string2FDate(String inStr) throws java.text.ParseException {
		//return string2FDate(inStr,FormatDate.SHORT_DATE_MMM);
		System.out.println(" Parsing Date " + inStr);
		return new FDate(string2util(inStr));
	}

   /**
	* Function to convert String in Given format to java.util.Date
	* @param inStr String
	*/

	public static FDate string2FDate(String inStr, String format) throws java.text.ParseException {
		if (inStr == null) return null;
		inStr = inStr.trim();
		if (inStr.equals("")) return null;
		inStr = inStr.trim();
    	SimpleDateFormat formatter = new SimpleDateFormat( format );

       //Added by Abhijit to display date in proper format eg 12/12/25 should display as 12-Dec-2025
       formatter.set2DigitYearStart(new GregorianCalendar(2000,01,01).getTime());

       formatter.setTimeZone(FormatDate.TIMEZONE);
       return new FDate(formatter.parse(inStr));
	}


	/**
	* Function to convert String in DD-MMM-YYYY or DD-MMM-YYYY HH:mm:ss format to java.sql.Date
	* @param inStr String
	*/

	public static java.sql.Date string2sql (String inStr) throws java.text.ParseException {
		if (inStr == null) return null;
		inStr = inStr.trim();
		if (inStr.equals("")) return null;
		if (inStr.length() > 11 ) {
			SimpleDateFormat formatter1 = new SimpleDateFormat (longDateFormat);
			formatter1.setTimeZone(FormatDate.TIMEZONE);
			return util2sql(formatter1.parse(inStr)); }
		else {
			SimpleDateFormat formatter1 = new SimpleDateFormat (dateFormat);
			formatter1.setTimeZone(FormatDate.TIMEZONE);
			return util2sql(formatter1.parse(inStr)); }
	}

	/**
	* Function to convert String in DD-MMM-YYYY or DD-MMM-YYYY HH:mm:ss format to java.sql.Timestamp
	* @param inStr String
	*/

	public static java.sql.Timestamp string2timestamp (String inStr) throws java.text.ParseException {
		if (inStr == null) return null;
		inStr = inStr.trim();
		if (inStr.equals("")) return null;
		if (inStr.length() > 11 ) {
			SimpleDateFormat formatter = new SimpleDateFormat (longDateFormat);
			formatter.setTimeZone(FormatDate.TIMEZONE);
			return util2timestamp(formatter.parse(inStr)); }
		else {
			SimpleDateFormat formatter = new SimpleDateFormat (dateFormat);
			formatter.setTimeZone(FormatDate.TIMEZONE);
			return util2timestamp(formatter.parse(inStr));}
	}


// Overladed methods to return string given any date

	/**
	* Function to convert java.util.Date to date in DD-MMM-YYYY string format
	* @param inStr java.util.Date
	*/

	public static String date2string (java.util.Date inDate) {
		if (inDate == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat (dateFormat, FormatDate.LOCALE);
		formatter.setTimeZone(FormatDate.TIMEZONE);
		return formatter.format(inDate);
	}
	
	/**
	 * This method has been introduced for External Risk Date format
	 * @param inDate
	 * @return
	 */
	public static String date2yyyyMMdd (java.util.Date inDate) {
		if (inDate == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd", FormatDate.LOCALE);
		formatter.setTimeZone(FormatDate.TIMEZONE);
		return formatter.format(inDate);
	}
	
	/**
	* Function to convert java.sql.Date to date in DD-MMM-YYYY string format
	* @param inStr java.sql.Date
	*/


	public static String date2string (java.sql.Date inDate) {
		if (inDate == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat (dateFormat, FormatDate.LOCALE);
		formatter.setTimeZone(FormatDate.TIMEZONE);
		return formatter.format(sql2util(inDate));
	}


	/**
	* Function to convert java.sql.Timestamp to date in DD/MM/YYYY string format
	* @param inStr java.sql.Timestamp
	*/

	public static String date2string (java.sql.Timestamp inDate) {
		if (inDate == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat (dateFormat, FormatDate.LOCALE);
		formatter.setTimeZone(FormatDate.TIMEZONE);
		return formatter.format(timestamp2util(inDate));
	}

// Overladed methods to return string given any date in long date format


	/**
	* Function to convert java.util.Date to date in DD/MM/YYYY HH:mm:ss string, long format
	* @param inStr java.util.Date
	*/

	public static String longdate2string (java.util.Date inDate) {
		if (inDate == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat (longDateFormat, FormatDate.LOCALE);
		formatter.setTimeZone(FormatDate.TIMEZONE);
		return formatter.format(inDate);
	}

	/**
	 * Function to convert java.util.Date to date in specified format
	 * @param inStr java.util.Date
	 */

	public static String longdate2string (java.util.Date inDate, String format) {
		if (inDate == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat (format,FormatDate.LOCALE);
		formatter.setTimeZone(FormatDate.TIMEZONE);
		return formatter.format(inDate);
	}

	/**
	* Function to convert java.sql.Date to date in DD/MM/YYYY HH:mm:ss string, long format
	* @param inStr java.sql.Date
	*/

	public static String longdate2string (java.sql.Date inDate) {
		if (inDate == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat (longDateFormat,FormatDate.LOCALE);
		formatter.setTimeZone(FormatDate.TIMEZONE);
		return formatter.format(sql2util(inDate));
	}


	/**
	* Function to convert java.sql.Timestamp to date in DD/MM/YYYY HH:mm:ss string, long format
	* @param inStr java.sql.Timestamp
	*/

	public static String longdate2string (java.sql.Timestamp inDate) {
		if (inDate == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat (longDateFormat,FormatDate.LOCALE);
		formatter.setTimeZone(FormatDate.TIMEZONE);
		return formatter.format(timestamp2util(inDate));
	}



	/**
	* Function to convert java.util.Date to date in supplied dtfrmt, string format
	* @param inStr java.util.Date
	*/

	public static String date2string (java.util.Date inDate, String dtfrmt) {
		if (inDate == null) return null;
		SimpleDateFormat formatter = new SimpleDateFormat (dtfrmt,FormatDate.LOCALE);
		formatter.setTimeZone(FormatDate.TIMEZONE);
		return formatter.format(inDate);
	}

    /**
     * Function will Convert the Calendar object to String of format (dd/MM/YYYY)
     * @param pGregCalendar
     * @return
     */
    public static String CalendartoString(GregorianCalendar pGregCalendar){
            String lDateFormat = "dd/MM/yyyy";
            SimpleDateFormat lSdateformat = new SimpleDateFormat(lDateFormat);
            java.util.Date lDate = pGregCalendar.getTime();
            String lDateString = lSdateformat.format(lDate);
            return lDateString;
    }
    /**
     * Function to convert the string to Gregorian Calendar
     * @param pString
     * @return
     */
    public static GregorianCalendar StringtoCalendar(String pString) {
        GregorianCalendar lGregorianCalendar = null;
        try{
            String lDateFormat = "dd/MM/yyyy";
            SimpleDateFormat lSimpleDateFormat = new SimpleDateFormat(lDateFormat);
            java.util.Date lDate = lSimpleDateFormat.parse(pString);
            lGregorianCalendar = (GregorianCalendar)Calendar.getInstance();
            lGregorianCalendar.setTime(lDate);
        }
        catch(java.text.ParseException pe){
            System.out.println("Exception while parsing date in DateFunctions.StringtoCalendar");
        }
        return lGregorianCalendar;
    }

    /**
     * Function to Convert julian date to our customised Date
     * @param juliandate
     * @return
     */
    public static FDate julian2FDate(int juliandate)
    {
    	GregorianCalendar gc = new GregorianCalendar(4713,0,1);
		gc.set(Calendar.ERA,GregorianCalendar.BC);
		gc.add(Calendar.DATE, juliandate);
		FDate dt = new FDate(gc.getTime());
		return(dt);
    }

    /**
     * Function to convert java.util.Date to java.sql.TimeStamp
     * @param pDate
     * @return
     */
    public static java.sql.Timestamp getTimeStamp(java.util.Date pDate){
        Calendar gc = Calendar.getInstance();  // current date+time
        gc.set(pDate.getYear() + 1900, pDate.getMonth(), pDate.getDate());
        return new java.sql.Timestamp(gc.getTime().getTime());
    }

    /**
     * Function to convert util date to Julian date
     * @param pDate
     * @return
     */
    public static double util2Julian(java.util.Date pDate){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(pDate);
    	int month = gc.get(GregorianCalendar.MONTH) + 1; // since this.getMonth returns one less than actual month
        double extra = 100.0*gc.get(GregorianCalendar.YEAR) + month - 190002.5;
        double julianDate = 367.0*gc.get(GregorianCalendar.YEAR);
        julianDate -= Math.floor(7.0*(gc.get(GregorianCalendar.YEAR)+Math.floor((month+9.0)/12.0))/4.0) ;
        julianDate += Math.floor(275.0*month/9.0) ;
        julianDate += gc.get(GregorianCalendar.DATE);
        julianDate += 1721013.5 ;
        julianDate -= 0.5*extra/Math.abs(extra) ;
        julianDate += 1.0 ;
        return julianDate;
    }
    public static java.util.TimeZone getTimeZone() {
        return TIMEZONE;
    }
    public static void setTimeZone(java.util.TimeZone TIMEZONE) {
        FormatDate.TIMEZONE = TIMEZONE;
    }
    /**
     * @purpose Added to retrieve the time component from the date.
     * @param inDate
     * @return
     */
    public static String date2timeString(java.util.Date inDate) {
        if (inDate == null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat(TIME_FORMAT, FormatDate.LOCALE);
        formatter.setTimeZone(FormatDate.TIMEZONE);
        return formatter.format(inDate);
    }

    /**
     * This method is for supporting all date formats.Creating an hashmap with all date formats to support.
     * @return
     */

    public static  HashMap initDateFormats(){
        dateFormats = new HashMap();
        String[] style6 = {"d-M-yy", "d/M/yy","ddMMyy"};
        dateFormats.put(6, style6);
        String[] style7 = {"dd-M-yy", "dd/M/yy","d-MM-yy", "d/MM/yy","ddMMMyy"};
        dateFormats.put(7, style7);
        String[] style8 = {"dd-MM-yy", "dd/MM/yy","ddMMyyyy", "dd.MM.yy", "d/M/yyyy", "d-M-yyyy", "d-MMM-yy", "d.MMM.yy", "d/MMM/yy"};
        dateFormats.put(8, style8);
        String[] style9 = {"dd-MMM-yy", "dd/MMM/yy","ddMMMyyyy", "dd.MMM.yy", "d-MM-yyyy", "d/MM/yyyy", "dd/M/yyyy"};
        dateFormats.put(9, style9);
        String[] style10 = {"dd-MM-yyyy", "dd/MM/yyyy", "dd.MM.yyyy", "d-MMM-yyyy", "d.MMM.yyyy"};
        dateFormats.put(10, style10);
        String[] style11 = {"dd-MMM-yyyy", "dd/MMM/yyyy", "dd.MMM.yyyy"};
        dateFormats.put(11, style11);
        String[] style17 = {"dd-MM-yy HH:mm:ss", "dd/MM/yy HH:mm:ss"};
        dateFormats.put(17, style17);
        String[] style18 = {"dd-MMM-yy HH:mm:ss", "dd/MMM/yy HH:mm:ss"};
        dateFormats.put(18, style18);
        String[] style19 = {"dd-MM-yyyy HH:mm:ss", "dd/MM/yyyy HH:mm:ss"};
        dateFormats.put(19, style19);
        String[] style20 = {"dd-MMM-yyyy HH:mm:ss", "dd/MMM/yyyy HH:mm:ss"};
        dateFormats.put(20, style20);
        return dateFormats;
    }
    /**
     * Function to  Converting the GMT time to local time, Given the GMT time and the time difference (in hours)
     * @param inStr java.util.Date
     * @param inStr offset
     */
    public static FDate getLocalTime(java.util.Date date, double offset) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        int s= (int)(offset*60*60*1000);
        gc.add(Calendar.MILLISECOND, s);
        FDate dt = new FDate(gc.getTime());
        return(dt);
    }

    /**
     * Function to  Converting the Local time to GMT, given the local time and time difference (in hours)
     * @param inStr java.util.Date
     * @param inStr offset
     */

    public static FDate getGMTTime(java.util.Date date, double offset){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        int s= (int)(-offset*60*60*1000);
        gc.add(Calendar.MILLISECOND, s);
        FDate dt = new FDate(gc.getTime());
        return(dt);
    }
    
    public static String get12HrsFormat(String dateString){ 
        
        SimpleDateFormat sdf = new SimpleDateFormat(TWELVE_HRS_FORMAT); 
        Date dateTimeStamp = null; 
                try { 
                        dateTimeStamp = sdf.parse(dateString); 
                } catch (ParseException e) { 
                        // TODO Auto-generated catch block 
                        e.printStackTrace(); 
                } 
        String formattedDate = sdf.format(dateTimeStamp);                                
        int formatHours = dateTimeStamp.getHours();                              
         
        if(formatHours>12){ 
                formattedDate = formattedDate.concat(" ").concat("PM"); 
        }else{ 
                formattedDate = formattedDate.concat(" ").concat("AM"); 
        } 
        return formattedDate; 
    } 
     
public static String subtractMinutes(String formattedDate,int parameterValue) throws Exception{ 
        int stringCount = 0,hour = 0,min = 0,sec = 0; 
        String dateString = null,space =" ",amOrPm = null; 
        String hrsMinutes = null; 
         for (String data: formattedDate.split(" ", 3)){ 
                 
                if (stringCount==0) 
                { 
                        dateString = data; 
                }else if(stringCount==1){ 
                        hrsMinutes = data; 
                }else{ 
                        amOrPm = data; 
                }                
                 
                stringCount++; 
        } 
        stringCount =0; 
        for (String data: hrsMinutes.split(":", 3)){ 
         
                if (stringCount==0) 
                { 
                        hour = Integer.parseInt(data); 
                }else if(stringCount==1) 
                        min = Integer.parseInt(data); 
                else 
                        sec = Integer.parseInt(data); 
                 
                stringCount++; 
    	} 
    	try { 
    		SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss"); 
    		Date timestamp = formatTime.parse(hrsMinutes); 
    		System.out.println("hrsMinutes timestamp "+timestamp);
    		Calendar instance = GregorianCalendar.getInstance(); 
    		instance.setTime(timestamp);
    		if(hour < 1 ){
    			if( min > parameterValue){
    				instance.add(GregorianCalendar.MINUTE, -parameterValue);
    				hrsMinutes = formatTime.format(instance.getTime()); 
    	    		dateString = dateString.concat(space).concat(hrsMinutes);
    			}else{
    				SimpleDateFormat onlyDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
    				Date datehm = onlyDateFormat.parse(dateString);   
    				onlyDateFormat.applyPattern("MM/dd/yyyy");     				                    
    				FDate fdate = new FDate(datehm); 
        			fdate.addDays(-1);
    				instance.add(GregorianCalendar.MINUTE, -parameterValue);
    				SimpleDateFormat onlyDateFormat1 = new SimpleDateFormat("yyyy-MM-dd"); 
    				String onlyDate = onlyDateFormat1.format(fdate);  
    				hrsMinutes = formatTime.format(instance.getTime()); 
    	    		dateString = onlyDate.concat(space).concat(hrsMinutes);
    			}
    		}else{
    				instance.add(GregorianCalendar.MINUTE, -parameterValue); 
    				hrsMinutes = formatTime.format(instance.getTime()); 
    	    		dateString = dateString.concat(space).concat(hrsMinutes);
    		}
    		/*if(("PM").equals(amOrPm)){ 
    			if((hour == 12 && min < parameterValue)){ 
    				dateString = dateString.concat(space).concat(hrsMinutes).concat(space).concat("AM"); 
    			}else{ 
    				dateString = dateString.concat(space).concat(hrsMinutes).concat(space).concat("PM"); 
    			} 

    		}else{ 
    			if(hour ==12 && min < parameterValue) 
    			{ 

    				SimpleDateFormat onlyDateFormat = new SimpleDateFormat("yyyy-MM-dd");                            
    				Date datehm = onlyDateFormat.parse(dateString);                           
    				onlyDateFormat.applyPattern("MM/dd/yyyy"); 
    				String dateString2 = onlyDateFormat.format(datehm);   

    				FDate fdate = new FDate(dateString2); 
    				fdate.addDays(-1); 
    				SimpleDateFormat onlyDateFormat1 = new SimpleDateFormat("yyyy-MM-dd"); 
    				String onlyDate = onlyDateFormat1.format(fdate);                           
    				dateString = onlyDate.concat(space).concat(hrsMinutes).concat(space).concat("PM");                       


    			} 
    			else{ 
    				dateString = dateString.concat(space).concat(hrsMinutes).concat(space).concat("AM"); 
    			} 

    		} 
    		return dateString; */
    	} catch (ParseException e) { 
    		// TODO Auto-generated catch block 
    		e.printStackTrace(); 
    		return dateString; 
    	} 
    	return dateString;
    } 

	public static String getCurrentTime(){
		
		Date currDate = new Date();
		SimpleDateFormat currTime = new SimpleDateFormat ("dd-MMM-yyyy hh:mm:ss a");
		String currDateTime = currTime.format(currDate);
		return currDateTime;
	}
}
