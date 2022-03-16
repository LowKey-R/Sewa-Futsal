package Utils;
import Objects.AppConsts;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utility {
    DecimalFormat df = new DecimalFormat("###.#");
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(AppConsts.USER_LOCALE);
    
    public String formatPrice(double price) {
        return currencyFormat.format(Double.parseDouble(df.format(price))).replaceAll(",00", "").replaceAll("\\.", ",");
    }
    
    public String formatDateToTime(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return date.format(formatter);
    }
    
    public String convertDayName(LocalDateTime date) {
        DateFormatSymbols dfs = new DateFormatSymbols(AppConsts.USER_LOCALE);
        Calendar myCal = new GregorianCalendar(date.getYear(), getMonthIndex(date.getMonth().toString()), date.getDayOfMonth());
        myCal.set(Calendar.DAY_OF_WEEK, 1);
        int dOw = myCal.get(Calendar.DAY_OF_WEEK);
        return dfs.getWeekdays()[dOw];
    }
    
    private int getMonthIndex(String month) {
        int index = -1;
        switch(month) {
            case "JANUARY": 
                index = 0;
                break;
            case "FEBRUARY":
                index = 1;
                break;
            case "MARCH": 
                index = 2;
                break;
            case "APRIL":
                index = 3;
                break;
            case "MAY": 
                index = 4;
                break;
            case "JUNE":
                index = 5;
                break;
            case "JULY": 
                index = 6;
                break;
            case "AUGUST":
                index = 7;
                break;
            case "SEPTEMBER": 
                index = 8;
                break;
            case "OCTOBER":
                index = 9;
                break;
            case "NOVEMBER": 
                index = 10;
                break;
            case "DECEMBER":
                index = 11;
                break;
        }
        
        return index;
    }
    
    
    public int getTimeIndexForTable(String time) {
        int timeNumber = -1;
        switch(time) {
            case "08:00":
                timeNumber = 0;
                break;
            case "09:00":
                timeNumber = 1;
                break;
            case "10:00":
                timeNumber = 2;
                break;
            case "11:00":
                timeNumber = 3;
                break;
            case "12:00":
                timeNumber = 4;
                break;
            case "13:00":
                timeNumber = 5;
                break;
            case "14:00":
                timeNumber = 6;
                break;
            case "15:00":
                timeNumber = 7;
                break;
            case "16:00":
                timeNumber = 8;
                break;
            case "17:00":
                timeNumber = 9;
                break;
            case "18:00":
                timeNumber = 10;
                break;
            case "19:00":
                timeNumber = 11;
                break;
            case "20:00":
                timeNumber = 12;
                break;
            case "21:00":
                timeNumber = 13;
                break;
        }
        return timeNumber;
    }
}
