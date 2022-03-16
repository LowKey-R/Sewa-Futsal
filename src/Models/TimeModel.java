package Models;

public class TimeModel {
    private final String dayName;
    private final String timePlay;
    
    public TimeModel(String dayName, String timePlay) {
        this.dayName         = dayName;
        this.timePlay        = timePlay;
    }

    public String getDayName() {
        return dayName;
    }
    
    public String getTime() {
        return timePlay;
    }
}
