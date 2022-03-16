package Utils;

import Objects.AppConsts;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;

public class LocalizedWeek {
    // Try and always specify the time zone you're working with
    private final static ZoneId TZ = ZoneId.systemDefault();

    private final DayOfWeek firstDayOfWeek;
    private final DayOfWeek lastDayOfWeek;

    public LocalizedWeek() {
        this.firstDayOfWeek = WeekFields.of(AppConsts.USER_LOCALE).getFirstDayOfWeek();
        this.lastDayOfWeek = DayOfWeek.of(((this.firstDayOfWeek.getValue() + 5) % DayOfWeek.values().length) + 1);
    }

    public LocalDate getFirstDay() {
        return LocalDate.now(TZ).with(TemporalAdjusters.previousOrSame(this.firstDayOfWeek));
    }

    public LocalDate getLastDay() {
        return LocalDate.now(TZ).with(TemporalAdjusters.nextOrSame(this.lastDayOfWeek));
    }

    @Override
    public String toString() {
        return String.format(   "The %s week starts on %s and ends on %s",
                                AppConsts.USER_LOCALE.getDisplayName(),
                                this.firstDayOfWeek,
                                this.lastDayOfWeek);
    }
}