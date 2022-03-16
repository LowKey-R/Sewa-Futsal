package Models;

public enum FieldTypeModel {
    FIELD1(120000, 140000, "Lapang Kecil 1 (Interlock)"),
    FIELD2(120000, 140000, "Lapang Kecil 2 (Interlock)"),
    FIELD3(180000, 200000, "Lapang Besar 1 (Interlock)"),
    FIELD4(180000, 200000, "Lapang Besar 2 (Interlock)");

    private final double price;
    private final double weekendPrice;
    private final String name;
    private FieldTypeModel(double price, double weekendPrice, String name) {
        this.price          = price;
        this.weekendPrice   = weekendPrice;
        this.name           = name;
    }

    public double getPrice() { 
        return price; 
    }
    
    public double getPriceWeekend() { 
        return weekendPrice; 
    }

    public String getName() {
        return name;
    }
}