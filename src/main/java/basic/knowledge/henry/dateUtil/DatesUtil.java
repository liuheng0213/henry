package basic.knowledge.henry.dateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatesUtil {
    private static final String DATE_FORMAT_PATTERN_DATE   = "dd/MM/yyyy";
    private static SimpleDateFormat simpleDateFormat         = new SimpleDateFormat(DATE_FORMAT_PATTERN_DATE);
    private static SimpleDateFormat simpleTimeFormat         = new SimpleDateFormat("HH:mm:ss");
    private static SimpleDateFormat simpleDateTimeFormat      = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static SimpleDateFormat simpleDateTimeMsFormat    = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");

    public static boolean isValidDate(String date)
    {
        boolean isValid = true;

        try
        {
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(date);
        }
        catch (ParseException e)
        {
            isValid = false;
        }

        return isValid;
    }

    public static boolean isFutureDate(String date)
    {
        Date validDate = formatStringToDate(DATE_FORMAT_PATTERN_DATE, date);
        Date todayDate = getCurrentDate();
        return (validDate.compareTo(todayDate) <= 0);
    }

    public static Date formatStringToDate(String format, String date)
    {
        Date formatDate = null;
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            formatter.setLenient(false);
            formatDate = formatter.parse(date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return formatDate;
    }

    public static Date formatStringToDate(String date)
    {
        return formatStringToDate(DATE_FORMAT_PATTERN_DATE, date);
    }

    public static String getNextDayDateAsString(String inputDate)
    {
        if (inputDate == null)
            return "";

        String outputDate = "";
        try
        {
            int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
            Date formatDate = simpleDateFormat.parse(inputDate);
            outputDate = simpleDateFormat.format(formatDate.getTime() + MILLIS_IN_DAY);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return outputDate;
    }

    public static Date getCurrentDate()
    {
        long now = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now);
        return calendar.getTime();
    }

    public static String getDatePart(Date date)
    {
        return simpleDateFormat.format(date);
    }

    public static String getTimePart(Date date)
    {
        return simpleTimeFormat.format(date);
    }

    public static String getDateTimePart(Date date)
    {
        return simpleDateTimeFormat.format(date);
    }

    public static String formatLongToDateTime(long dateTime)
    {
        Date d = new Date(dateTime);
        return simpleDateTimeMsFormat.format(d);
    }
}
