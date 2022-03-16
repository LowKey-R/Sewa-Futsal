package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class CLITable {
    Utility aU = new Utility();
    
    private static final String HORIZONTAL_SEP = "-";
    private String verticalSep;
    private String joinSep;
    private String[] headers;
    private final List<String[]> rows = new ArrayList<>();
    private boolean rightAlign;

    public CLITable() {
        setShowVerticalLines(false);
    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        verticalSep = showVerticalLines ? "|" : "";
        joinSep = showVerticalLines ? "+" : " ";
    }

    public void setHeaders(String... headers) {
        this.headers = headers;
    }

    public void addRow(String... cells) {
        rows.add(cells);
    }
    
    public void editRow(int RowId, String dayName, String dayTime, String personInCharge) {
        String[] tempData = rows.get(RowId);
        
        if(dayName.equalsIgnoreCase("Jumat")) {
            dayName = "Jum'at";
        }
        
        int dayIndex = getDayIndex(dayName);
        tempData[dayIndex] = personInCharge;
        
        rows.set(RowId, tempData);
    }
    
    private int getDayIndex(String dayName) {
        int index = -1;
        switch(dayName) {
            case "Senin":
                index = 1;
                break;
            case "Selasa":
                index = 2;
                break;
            case "Rabu":
                index = 3;
                break;
            case "Kamis":
                index = 4;
                break;
            case "Jum'at":
                index = 5;
                break;
            case "Sabtu":
                index = 6;
                break;
            case "Minggu":
                index = 7;
                break;
            default: 
                index = -1;
                break;
        }
        return index;
    }

    public void print() {
        int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Jumlah row-cells dan headers harus konsisten");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        if (headers != null) {
            printLine(maxWidths);
            printRow(headers, maxWidths);
            printLine(maxWidths);
        }
        for (String[] cells : rows) {
            printRow(cells, maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }

    private void printLine(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    verticalSep.length() + 1, HORIZONTAL_SEP));
            System.out.print(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
        }
        System.out.println();
    }

    private void printRow(String[] cells, int[] maxWidths) {
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSep : "";
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            } else {
                System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            }
        }
        System.out.println();
    }
}
