package Models;

import Utils.Utility;
import java.time.LocalDateTime;

public class OrderModel {
    Utility appUtil = new Utility();
    
    private final FieldTypeModel fieldType;
    private final LocalDateTime orderTime;
    private final String inchargePerson;
    private final double downPayment;
    
    public OrderModel(FieldTypeModel fieldType, LocalDateTime orderTime, String inchargePerson, double downPayment) {
        this.fieldType          = fieldType;
        this.orderTime          = orderTime;
        this.inchargePerson     = inchargePerson;
        this.downPayment        = downPayment;
    }
    
    public FieldTypeModel getFieldType() {
        return fieldType;
    }
    
    public String getOrderTime() {
        return appUtil.formatDateToTime(orderTime);
    }
    
    public int getOrderDayNumber() {
        return orderTime.getDayOfMonth();
    }
    
    public String getOrderDayName() {
        return appUtil.convertDayName(orderTime);
    }
    
    public String getInChargePerson() {
        return inchargePerson;
    }
    
    public double getDownPayment() {
        return downPayment;
    }
}
