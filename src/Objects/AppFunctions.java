package Objects;

import Models.FieldTypeModel;
import Models.OrderModel;
import Utils.LocalizedWeek;
import Utils.Utility;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppFunctions {
    boolean kembaliKeMenuUtama = false, salahPilihanLapang = false, salahPilihanHari = false, salahPilihanJam = false, salahPilihanRekap = false, uangDpKurang = false, uangBayarKurang = false;
    int pilihanMenuUtama = -1, pilihanDataLapang = -1, pilihanDataHari = -1, pilihanJamBooking = -1, pilihanMenuRekap = -1;
    
    //BOOKING DATA
    FieldTypeModel jenisLapang;
    LocalDateTime tanggalOrder;
    LocalDate tanggalOrderTemp;
    String atasNama = "Not Set";
    double uangDP = -1;
    double uangBayar = -1;
    OrderModel orderData;
    
    GlobalVariables gv = new GlobalVariables();
    
    LocalDateTime dateNow = LocalDateTime.now();
    Scanner scnr = new Scanner(System.in);
    AppConsts appConsts = new AppConsts();
    Utility appUtil = new Utility();
    LocalizedWeek weekDate = new LocalizedWeek();
    
    public void initTable() {
        gv.bookingTableDatas1.setRightAlign(false); //if true then cell text is right aligned
        gv.bookingTableDatas1.setShowVerticalLines(true); //if false (default) then no vertical lines are shown

        gv.bookingTableDatas1.setHeaders("JAM", "SENIN", "SELASA", "RABU", "KAMIS", "JUM'AT", "SABTU", "MINGGU"); //optional - if not used then there will be no header and horizontal lines
        gv.bookingTableDatas1.addRow("08:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas1.addRow("09:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas1.addRow("10:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas1.addRow("11:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas1.addRow("12:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas1.addRow("13:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas1.addRow("14:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas1.addRow("15:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas1.addRow("16:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas1.addRow("17:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas1.addRow("18:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas1.addRow("19:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas1.addRow("20:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas1.addRow("21:00", "", "", "", "", "", "", "");
        
        gv.bookingTableDatas2.setRightAlign(false); //if true then cell text is right aligned
        gv.bookingTableDatas2.setShowVerticalLines(true); //if false (default) then no vertical lines are shown

        gv.bookingTableDatas2.setHeaders("JAM", "SENIN", "SELASA", "RABU", "KAMIS", "JUM'AT", "SABTU", "MINGGU"); //optional - if not used then there will be no header and horizontal lines
        gv.bookingTableDatas2.addRow("08:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas2.addRow("09:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas2.addRow("10:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas2.addRow("11:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas2.addRow("12:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas2.addRow("13:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas2.addRow("14:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas2.addRow("15:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas2.addRow("16:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas2.addRow("17:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas2.addRow("18:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas2.addRow("19:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas2.addRow("20:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas2.addRow("21:00", "", "", "", "", "", "", "");
        
        gv.bookingTableDatas3.setRightAlign(false); //if true then cell text is right aligned
        gv.bookingTableDatas3.setShowVerticalLines(true); //if false (default) then no vertical lines are shown

        gv.bookingTableDatas3.setHeaders("JAM", "SENIN", "SELASA", "RABU", "KAMIS", "JUM'AT", "SABTU", "MINGGU"); //optional - if not used then there will be no header and horizontal lines
        gv.bookingTableDatas3.addRow("08:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas3.addRow("09:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas3.addRow("10:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas3.addRow("11:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas3.addRow("12:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas3.addRow("13:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas3.addRow("14:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas3.addRow("15:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas3.addRow("16:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas3.addRow("17:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas3.addRow("18:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas3.addRow("19:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas3.addRow("20:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas3.addRow("21:00", "", "", "", "", "", "", "");
        
        gv.bookingTableDatas4.setRightAlign(false); //if true then cell text is right aligned
        gv.bookingTableDatas4.setShowVerticalLines(true); //if false (default) then no vertical lines are shown

        gv.bookingTableDatas4.setHeaders("JAM", "SENIN", "SELASA", "RABU", "KAMIS", "JUM'AT", "SABTU", "MINGGU"); //optional - if not used then there will be no header and horizontal lines
        gv.bookingTableDatas4.addRow("08:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas4.addRow("09:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas4.addRow("10:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas4.addRow("11:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas4.addRow("12:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas4.addRow("13:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas4.addRow("14:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas4.addRow("15:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas4.addRow("16:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas4.addRow("17:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas4.addRow("18:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas4.addRow("19:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas4.addRow("20:00", "", "", "", "", "", "", "");
        gv.bookingTableDatas4.addRow("21:00", "", "", "", "", "", "", "");
    }
    
    private int getRowIndex(String dayName) {
        int index = -1;
        if(dayName.equalsIgnoreCase("Senin")) {
            index = 1;
        } else if(dayName.equalsIgnoreCase("Selasa")) {
            index = 2;
        } else if(dayName.equalsIgnoreCase("Rabu")) {
            index = 3;
        } else if(dayName.equalsIgnoreCase("Kamis")) {
            index = 4;
        } else if(dayName.equalsIgnoreCase("Jum'at")) {
            index = 5;
        } else if(dayName.equalsIgnoreCase("Sabtu")) {
            index = 6;
        } else if(dayName.equalsIgnoreCase("Minggu")) {
            index = 7;
        }
        return index;
    }
    
    public void addOrderDataToTable() {
        LocalDate start = weekDate.getFirstDay();
        LocalDate end = weekDate.getLastDay();
        List<LocalDate> weekDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            weekDates.add(start);
            start = start.plusDays(1);
        }
        gv.orderDatas.forEach((orderData) -> {
            switch(orderData.getFieldType()) {
                case FIELD1:
                    for(LocalDate date : weekDates) {
                        if(date.getDayOfMonth() == orderData.getOrderDayNumber()) {
                            gv.bookingTableDatas1.editRow(appUtil.getTimeIndexForTable(orderData.getOrderTime()), orderData.getOrderDayName(), orderData.getOrderTime(), orderData.getInChargePerson());
                        }
                    }
                    break;
                case FIELD2:
                    for(LocalDate date : weekDates) {
                        if(date.getDayOfMonth() == orderData.getOrderDayNumber()) {
                            gv.bookingTableDatas2.editRow(appUtil.getTimeIndexForTable(orderData.getOrderTime()), orderData.getOrderDayName(), orderData.getOrderTime(), orderData.getInChargePerson());
                        }
                    }
                    break;
                case FIELD3:
                    for(LocalDate date : weekDates) {
                        if(date.getDayOfMonth() == orderData.getOrderDayNumber()) {
                            gv.bookingTableDatas3.editRow(appUtil.getTimeIndexForTable(orderData.getOrderTime()), orderData.getOrderDayName(), orderData.getOrderTime(), orderData.getInChargePerson());
                        }
                    }
                    break;
                case FIELD4:
                    for(LocalDate date : weekDates) {
                        if(date.getDayOfMonth() == orderData.getOrderDayNumber()) {
                            gv.bookingTableDatas4.editRow(appUtil.getTimeIndexForTable(orderData.getOrderTime()), orderData.getOrderDayName(), orderData.getOrderTime(), orderData.getInChargePerson());
                        }
                    }
                    break;
            }
        });
    }
    
    public void addDummyDatas() {   
        gv.orderDatas.add(new OrderModel(FieldTypeModel.FIELD1, LocalDateTime.of(dateNow.getYear(), dateNow.getMonth(), 10, 9, 0), "Bayu", 120000));
        gv.orderDatas.add(new OrderModel(FieldTypeModel.FIELD1, LocalDateTime.of(dateNow.getYear(), dateNow.getMonth(), 10, 10, 0), "Baee", 110000));
        gv.orderDatas.add(new OrderModel(FieldTypeModel.FIELD1, LocalDateTime.of(dateNow.getYear(), dateNow.getMonth(), 15, 10, 0), "Rifky", 110000));
//        
        gv.orderDatas.add(new OrderModel(FieldTypeModel.FIELD2, LocalDateTime.of(dateNow.getYear(), dateNow.getMonth(), 14, 9, 0), "Rivan", 120000));
        gv.orderDatas.add(new OrderModel(FieldTypeModel.FIELD2, LocalDateTime.of(dateNow.getYear(), dateNow.getMonth(), 16, 10, 0), "Baee", 110000));
        gv.orderDatas.add(new OrderModel(FieldTypeModel.FIELD2, LocalDateTime.of(dateNow.getYear(), dateNow.getMonth(), 12, 10, 0), "Rifky", 110000));
        
        gv.orderDatas.add(new OrderModel(FieldTypeModel.FIELD4, LocalDateTime.of(dateNow.getYear(), dateNow.getMonth(), 14, 9, 0), "Abdul", 120000));
        gv.orderDatas.add(new OrderModel(FieldTypeModel.FIELD4, LocalDateTime.of(dateNow.getYear(), dateNow.getMonth(), 15, 10, 0), "Hanan", 110000));
        gv.orderDatas.add(new OrderModel(FieldTypeModel.FIELD4, LocalDateTime.of(dateNow.getYear(), dateNow.getMonth(), 10, 10, 0), "Rifky", 110000));
    }
    
    public void spacing() {
        System.out.println();
    }
    
    public boolean checkBookedStatus(OrderModel data, LocalDate date) {
        boolean isBooked = false;
        String dayName = date.getDayOfWeek().getDisplayName(TextStyle.FULL, AppConsts.USER_LOCALE);
        if(dayName.equalsIgnoreCase("Jumat")) {
            dayName = "Jum'at";
        }        
        
        for(int i = 0; i < gv.orderDatas.size(); i++) {
            if(isBooked == false) {
                if(gv.orderDatas.get(i).getOrderDayName().equalsIgnoreCase(dayName)) {
                    isBooked = gv.orderDatas.get(i).getFieldType().equals(data.getFieldType()) && gv.orderDatas.get(i).getOrderTime().equalsIgnoreCase(data.getOrderTime());
                }
            }
        }
        
        return isBooked;
    }
    
    public void initializeApp() {
        initTable();
        showMainMenu();
    }
    
    public void chooseFieldSchedule() {        
        addOrderDataToTable();
        
        System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                        JADWAL LAPANG KECIL 1                      ");
        System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                           SEWA FUTSAL 35                          ");
        showBookingTable(FieldTypeModel.FIELD1);
        System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                        JADWAL LAPANG KECIL 2                      ");
        System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                           SEWA FUTSAL 35                          ");
        showBookingTable(FieldTypeModel.FIELD2);
        System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                        JADWAL LAPANG BESAR 1                      ");
        System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                           SEWA FUTSAL 35                          ");
        showBookingTable(FieldTypeModel.FIELD3);
        System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                        JADWAL LAPANG BESAR 2                      ");
        System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                           SEWA FUTSAL 35                          ");
        showBookingTable(FieldTypeModel.FIELD4);
        
        kembaliKeMenuUtama = true;
    }
    
    public void showBookingTable(FieldTypeModel fieldType) {
        switch(fieldType) {
            case FIELD1:
                gv.bookingTableDatas1.print();
                break;
            case FIELD2:
                gv.bookingTableDatas2.print();
                break;
            case FIELD3:
                gv.bookingTableDatas3.print();
                break;
            case FIELD4:
                gv.bookingTableDatas4.print();
                break;
            default:
                break;
        }
    }
    
    private int getTimeNumber(String time) {
        int timeNumber = -1;
        switch(time) {
            case "08:00":
                timeNumber = 8;
                break;
            case "09:00":
                timeNumber = 9;
                break;
            case "10:00":
                timeNumber = 10;
                break;
            case "11:00":
                timeNumber = 11;
                break;
            case "12:00":
                timeNumber = 12;
                break;
            case "13:00":
                timeNumber = 13;
                break;
            case "14:00":
                timeNumber = 14;
                break;
            case "15:00":
                timeNumber = 15;
                break;
            case "16:00":
                timeNumber = 16;
                break;
            case "17:00":
                timeNumber = 17;
                break;
            case "18:00":
                timeNumber = 18;
                break;
            case "19:00":
                timeNumber = 19;
                break;
            case "20:00":
                timeNumber = 20;
                break;
            case "21:00":
                timeNumber = 21;
                break;
        }
        return timeNumber;
    }
    
    public void chooseTimeBooking() {
        do {
            salahPilihanJam = false;
            
            System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                 PEMILIHAN JAM                  ");
            System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                 SEWA FUTSAL 35                 " + AppConsts.ANSI_RESET);
            int index = 0;
            for(String timeList : AppConsts.TIME_LIST) {
                if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), getTimeNumber(timeList), 0), "", 0), tanggalOrderTemp)) {
                System.out.println("| "+ (index++ + 1) + ". " + timeList + AppConsts.ANSI_RED +" (Sudah Dibooking)                   " + AppConsts.ANSI_RESET
                        + "|");
                } else {
                System.out.println("| "+ (index++ + 1) + ". " + timeList + "                                     |");
                }
                if((index) == AppConsts.TIME_LIST.length) {
                    System.out.println("| "+ (AppConsts.TIME_LIST.length + 1) + ". Kembali ke Menu Awal (Batalkan Pemesanan) |");
                }
            }
            System.out.println("------------------------------------------------");
            System.out.print("Pilihan Jam: ");
            pilihanJamBooking = scnr.nextInt();
            switch(pilihanJamBooking) {
                case 1:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 8, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 8, 0);
                        askInChargePerson();
                    }
                    break;
                case 2:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 9, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 9, 0);
                        askInChargePerson();
                    }
                    break;
                case 3:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 10, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 10, 0);
                        askInChargePerson();
                    }
                    break;
                case 4:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 11, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 11, 0);
                        askInChargePerson();
                    }
                    break;
                case 5:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 12, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 12, 0);
                        askInChargePerson();
                    }
                    break;
                case 6:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 13, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 13, 0);
                        askInChargePerson();
                    }
                    break;
                case 7:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 14, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 14, 0);
                        askInChargePerson();
                    }
                    break;
                case 8:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 15, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 15, 0);
                        askInChargePerson();
                    }
                    break;
                case 9:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 16, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 16, 0);
                        askInChargePerson();
                    }
                    break;
                case 10:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 17, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 17, 0);
                        askInChargePerson();
                    }
                    break;
                case 11:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 18, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 18, 0);
                        askInChargePerson();
                    }
                    break;
                case 12:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 19, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 19, 0);
                        askInChargePerson();
                    }
                    break;
                case 13:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 20, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 20, 0);
                        askInChargePerson();
                    }
                    break;
                case 14:
                    if(checkBookedStatus(new OrderModel(jenisLapang, LocalDateTime.of(tanggalOrderTemp.getYear(), dateNow.getMonth(), tanggalOrderTemp.getDayOfMonth(), 21, 0), "", 0), tanggalOrderTemp)) {
                        System.out.println("\n==================================\nData lapang sudah dibooking!\nSilahkan pilih kembali\n==================================\n");
                        salahPilihanJam = true;
                    } else {
                        tanggalOrder = LocalDateTime.of(tanggalOrderTemp.getYear(), tanggalOrderTemp.getMonth(), tanggalOrderTemp.getDayOfMonth(), 21, 0);
                        askInChargePerson();
                    }
                    break;
                case 15:
                    kembaliKeMenuUtama = true;
                    break;
                default:
                    salahPilihanJam = true;
                    break;
            }
        } while (salahPilihanJam == true);
    }
    
    public void askInChargePerson() {
        System.out.println("Note: ");
        System.out.println("- Isi nama dengan -1 untuk membatalkan pemesanan");
        spacing(); 
        System.out.print("Booking Atas Nama: ");
        scnr.nextLine();
        atasNama = scnr.nextLine();
        
        if("-1".equals(atasNama)) {
            kembaliKeMenuUtama = true;
        } else {
           askDownPayment();
        }
    }
    
    public void askDownPayment() {
        do {
            uangDpKurang = false;
                
            System.out.println("Note: ");
            System.out.println("- Isi uang dp dengan angka 0 atau kosongkan untuk membatalkan pemesanan");
            spacing(); 
            System.out.print("Uang DP: ");
            uangDP = scnr.nextDouble();

            if(uangDP == 0) {
                kembaliKeMenuUtama = true;
            } else if (uangDP != 0 && uangDP < 50000) {
                System.out.println("Uang DP Minimal Rp. 50,000");
                uangDpKurang = true;
            } else {
                askUangBayar();
            }
        } while(uangDpKurang == true);
    }
    
    public void askUangBayar() {
        do {
            uangBayarKurang = false; 
            
            System.out.println("Note: ");
            System.out.println("- Isi uang bayar dengan angka 0 atau kosongkan untuk membatalkan pemesanan");
            spacing(); 
            System.out.print("Uang Bayar: ");
            uangBayar = scnr.nextDouble();
            spacing(); 

            if(uangBayar == 0) {
                kembaliKeMenuUtama = true;
            } else if (uangBayar > 0 && uangBayar < uangDP) {
                System.out.println("Uang Bayar kurang dari uang DP");
                uangBayarKurang = true;
            } else {
                orderData = new OrderModel(jenisLapang, tanggalOrder, atasNama, uangDP);
                gv.orderDatas.add(orderData);
                showInvoice();
                kembaliKeMenuUtama = true;
            }
        } while(uangBayarKurang == true);
    }
    
    public void showInvoice() {
        spacing();
        System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                                  STRUK BOOKING LAPANG                               ");
        System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                                        FUTSAL 35                                    ");
        System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                       Jl. International School No. 8 A, Cicaheum                    \n"
                                                                                + AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                    Kec. Kiaracondong, Kota Bandung, Jawa Barat 40282                ");
        System.out.println("  Jenis Lapang    : " + jenisLapang.getName());
        if(orderData.getOrderDayName().equalsIgnoreCase("Sabtu") || orderData.getOrderDayName().equalsIgnoreCase("Minggu")) {
            System.out.println("  Harga Lapang    : " + appUtil.formatPrice(jenisLapang.getPriceWeekend()) + " (Weekend)");
        } else {
            System.out.println("  Harga Lapang    : " + appUtil.formatPrice(jenisLapang.getPrice()));
        }
        spacing();
        System.out.println("  Tanggal Booking : " + orderData.getOrderDayName() + ", " + tanggalOrder.getDayOfMonth() + " " + tanggalOrder.getMonth().getDisplayName(TextStyle.FULL, AppConsts.USER_LOCALE) + " " + tanggalOrder.getYear() + " (" + orderData.getOrderTime() + ")");
        System.out.println("  Atas Nama       : " + atasNama);
        spacing();
        System.out.println("  Uang DP         : " + appUtil.formatPrice(uangDP));
        System.out.println("  Uang Bayar      : " + appUtil.formatPrice(uangBayar));
        System.out.println("  Uang Kembali    : " + appUtil.formatPrice(uangBayar - uangDP));
        if(orderData.getOrderDayName().equalsIgnoreCase("Sabtu") || orderData.getOrderDayName().equalsIgnoreCase("Minggu")) {
            if(jenisLapang.getPriceWeekend() - uangDP == 0) {
                System.out.println("  Sisa Bayar      : " + appUtil.formatPrice(jenisLapang.getPriceWeekend() - uangDP) + " (Lunas)");
            } else {
                System.out.println("  Sisa Bayar      : " + appUtil.formatPrice(jenisLapang.getPriceWeekend() - uangDP));
            }
        } else {
            if(jenisLapang.getPriceWeekend() - uangDP == 0) {
                System.out.println("  Sisa Bayar      : " + appUtil.formatPrice(jenisLapang.getPrice() - uangDP) + " (Lunas)");
            } else {
                System.out.println("  Sisa Bayar      : " + appUtil.formatPrice(jenisLapang.getPrice() - uangDP));
            }
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("             BERHASIL BOOKING LAPANG FUTSAL! SAMPAI BERTEMU DI MATCHDAY               ");
        System.out.println("--------------------------------------------------------------------------------------");
        spacing();
        spacing();
        spacing();
    }
    
    public void chooseDayBooking() {
        do {
            salahPilihanHari = false;
            
            LocalDate start = weekDate.getFirstDay();
            LocalDate end = weekDate.getLastDay();
            List<LocalDate> weekDates = new ArrayList<>();
            while (!start.isAfter(end)) {
                weekDates.add(start);
                start = start.plusDays(1);
            }
                    
            System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                 PEMILIHAN HARI                 ");
            System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                 SEWA FUTSAL 35                 ");
            int index = 0;
            for(String dayName : AppConsts.DAY_LIST) {
                System.out.print("| "+ (index++ + 1) + ". " + dayName);
                switch (dayName.length()) {
                    case 4:
                        System.out.println("                                      |");
                        break;
                    case 5:
                        System.out.println("                                     |");
                        break;
                    case 6:
                        System.out.println("                                    |");
                        break;
                    default:
                        break;
                }
                if((index) == AppConsts.DAY_LIST.length) {
                    System.out.println("| "+ (AppConsts.DAY_LIST.length + 1) + ". Kembali ke Menu Awal (Batalkan Pemesanan) |");
                }
            }
            System.out.println("------------------------------------------------");
            System.out.print("Pilihan Hari: ");
            pilihanDataHari = scnr.nextInt();
            switch(pilihanDataHari) {
                case 1:
                    tanggalOrderTemp = weekDates.get(0);
                    chooseTimeBooking();
                    break;
                case 2:
                    tanggalOrderTemp = weekDates.get(1);
                    chooseTimeBooking();
                    break;
                case 3:
                    tanggalOrderTemp = weekDates.get(2);
                    chooseTimeBooking();
                    break;
                case 4:
                    tanggalOrderTemp = weekDates.get(3);
                    chooseTimeBooking();
                    break;
                case 5:
                    tanggalOrderTemp = weekDates.get(4);
                    chooseTimeBooking();
                    break;
                case 6:
                    tanggalOrderTemp = weekDates.get(5);
                    chooseTimeBooking();
                    break;
                case 7:
                    tanggalOrderTemp = weekDates.get(6);
                    chooseTimeBooking();
                    break;
                case 8:
                    kembaliKeMenuUtama = true;
                    break;
                default:
                    salahPilihanHari = true;
                    break;
            }
        } while (salahPilihanHari == true);
    }
    
    public void chooseFieldBooking() {
        do {
            salahPilihanLapang = false;
            
            System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                                PEMILIHAN LAPANG                               ");
            System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                                 SEWA FUTSAL 35                                ");
            for(FieldTypeModel fieldType : FieldTypeModel.values()) {
                System.out.println("| " +(fieldType.ordinal()+1) + ". " + fieldType.getName() + "(" + appUtil.formatPrice(fieldType.getPrice()) + " - Weekend: " + appUtil.formatPrice(fieldType.getPriceWeekend()) + ")               |");
                if(fieldType.ordinal()+1 == FieldTypeModel.values().length) {
                    System.out.println("| " + (FieldTypeModel.values().length + 1) + ". Kembali ke Menu Awal (Batalkan Pemesanan)                                |");
                }
            }
            System.out.println("-------------------------------------------------------------------------------");
            System.out.print("Pilihan Lapang: ");
            pilihanDataLapang = scnr.nextInt();
            switch(pilihanDataLapang) {
                case 1:
                    spacing();
                    jenisLapang = FieldTypeModel.FIELD1;
                    chooseDayBooking();
                    break;
                case 2:
                    spacing();
                    jenisLapang = FieldTypeModel.FIELD2;
                    chooseDayBooking();
                    break;
                case 3:
                    spacing();
                    jenisLapang = FieldTypeModel.FIELD3;
                    chooseDayBooking();
                    break;
                case 4:
                    spacing();
                    jenisLapang = FieldTypeModel.FIELD4;
                    chooseDayBooking();
                    break;
                case 5:
                    kembaliKeMenuUtama = true;
                    break;
                default:
                    salahPilihanLapang = true;
                    break;
            }
        } while (salahPilihanLapang == true);
    }
    
    public void resetVar() {
        kembaliKeMenuUtama = false; 
        salahPilihanLapang = false; 
        salahPilihanHari = false; 
        salahPilihanJam = false;
        salahPilihanRekap = false;
        uangDpKurang = false;
        uangBayarKurang = false;
        pilihanMenuUtama = -1; 
        pilihanDataLapang = -1; 
        pilihanDataHari = -1; 
        pilihanJamBooking = -1;
        pilihanMenuRekap = -1;
        
        atasNama = "Not Set";
        uangDP = -1;
        uangBayar = -1;
    }
    
    public void showMainMenu() {
        do {
            resetVar();
            System.out.println("                _...----.._");
            System.out.println("             ,:':::::.     `>.");
            System.out.println("          ,' |:::::;'     |:::.");
            System.out.println("         /    `'::'       :::::\\");
            System.out.println("        /         _____     `::;\\");
            System.out.println("        :         /:::::\\      `  :");
            System.out.println("        | ,.     /::SSt::\\        |");
            System.out.println("        |;:::.   `::::::;'        |");
            System.out.println("        ::::::     `::;'      ,.  ;");
            System.out.println("        \\:::'              ,::::/");
            System.out.println("         \\                 \\:::/");
            System.out.println("          `.     ,:.        :;'");
            System.out.println("            `-.::::::..  _.''");
            System.out.println("               ```----'''");
            spacing();
            System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                 APLIKASI KASIR                ");
            System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                 SEWA FUTSAL 35                ");
            System.out.println("| 1. Booking Lapang                           |");
            System.out.println("| 2. Cek Data Booking                         |");
            System.out.println("| 3. Rekap Data Booking                       |");
            System.out.println("| 4. Keluar Aplikasi                          |");
            System.out.println("-----------------------------------------------");
            System.out.print("Pilihan Anda: "); 
            int mainMenuChoice = scnr.nextInt();
            
            switch(mainMenuChoice) {
                case 1:
                    spacing();
                    chooseFieldBooking();
                    break;
                case 2:
                    chooseFieldSchedule();
                    break;
                case 3:
                    menuRekap();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    kembaliKeMenuUtama = true;
                    System.out.println("Ulangi pilihan");
                    break;
            }
            
        } while(kembaliKeMenuUtama == true);
    }
    
    public void menuRekap() {
        int totalTransaksi = 0, totalLunas = 0, totalDP = 0, totalUang = 0;
        
        for(OrderModel orderModel : gv.orderDatas) {
            totalTransaksi = gv.orderDatas.size();
            totalUang += orderModel.getDownPayment();
            if(orderModel.getOrderDayName().equalsIgnoreCase("Sabtu") || orderModel.getOrderDayName().equalsIgnoreCase("Minggu")) {
                if(orderModel.getFieldType().getPriceWeekend() - orderModel.getDownPayment() == 0) {
                    totalLunas++;
                } else {
                    totalDP++;
                }
            } else {
                if(orderModel.getFieldType().getPrice() - orderModel.getDownPayment() == 0) {
                    totalLunas++;
                } else {
                    totalDP++;
                }
            }
        }
        
        System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                REKAP DATA BOOKING                ");
        System.out.println(AppConsts.ANSI_RED_BACKGROUND + AppConsts.ANSI_WHITE + "                     FUTSAL 35                    ");
        System.out.println("  Total Transaksi: " + totalTransaksi);
        System.out.println("  Total Lunas    : " + totalLunas);
        System.out.println("  Total DP       : " + totalDP);
        System.out.println("  Total Uang     : " + appUtil.formatPrice(totalUang));
        System.out.println("-----------------------------------------------");
        
        kembaliKeMenuUtama = true;
    }
}
