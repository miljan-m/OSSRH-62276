package Utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelDataForTests {

    public static ArrayList<HashMap<String, String>> getDataFromExcel(String filepath, String sheetName) {
        ArrayList<HashMap<String, String>> mydata = new ArrayList<HashMap<String, String>>();
        try {
            FileInputStream file = new FileInputStream(filepath);

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            Row HeaderRow = sheet.getRow(0);

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row currentRow = sheet.getRow(i);
                HashMap<String, String> currentHash = new HashMap<String, String>();
                for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
                    //Cell currentCell = currentRow.getCell(j);
                    String celija = new DataFormatter().formatCellValue(currentRow.getCell(j));
                    currentHash.put(HeaderRow.getCell(j).getStringCellValue(), celija);
/*
                    //currentCell.setCellType(CellType.STRING);
                    String celija = "";
                    switch (currentCell.getCellType()) {

                        case STRING:

                            if (currentCell.getStringCellValue().equals("empty")) {
                                celija = "";
                            } else {
                                celija = currentCell.getStringCellValue();
                            }

                            currentHash.put(HeaderRow.getCell(j).getStringCellValue(), celija);
                            break;

                        case NUMERIC:

                            String.valueOf((int)currentCell.getNumericCellValue());
                            currentHash.put(HeaderRow.getCell(j).getStringCellValue(), celija);
                            break;
                    }
*/

                }
                mydata.add(currentHash);
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mydata;
    }

    public static void WriteTestResult(String testName, String state, String screenshot) {
        try {
            FileInputStream file = new FileInputStream(new File("testdata/TestResults.xlsx"));

            XSSFWorkbook workbook1 = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook1.getSheet("Sheet1");
            String strDate = new SimpleDateFormat("dd.MM.yyyy:HH:mm").format(Calendar.getInstance().getTime());

            Object[][] testData = {{testName, state, strDate, screenshot}};

            int rowCount = sheet.getLastRowNum();

            for (Object[] test : testData) {
                Row row = sheet.createRow(++rowCount);

                int columnCount = 0;

                for (Object field : test) {
                    Cell cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);

                        XSSFCellStyle style = workbook1.createCellStyle();
                        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);


                        if (state.equals("PASSED")) {
                            style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                        }

                        if (state.equals("FAILED")) {
                            style.setFillForegroundColor(IndexedColors.RED.getIndex());
                        }
                        row.getCell(columnCount).setCellStyle(style);

                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
            }
            file.close();
            FileOutputStream outputStream = new FileOutputStream("testdata/TestResults.xlsx");
            workbook1.write(outputStream);

            workbook1.close();
            outputStream.close();
        } catch (Exception e) {
        }
    }

    public static ArrayList<String> GetListOfTestForExecution(String filePath, String ColumnName, String env) {
        ArrayList<String> listForExecution = new ArrayList<String>();
        ArrayList<Integer> listRowIndex = new ArrayList<Integer>();
        try {

            FileInputStream file = new FileInputStream(new File(filePath));

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet("Sheet1");
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int columnIndex = 0;
            int columnIndex1 = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    if (cell.getRowIndex() == 0) {
                        if (cell.getStringCellValue().equals(ColumnName)) {
                            columnIndex = cell.getColumnIndex();
                        }

                        if (cell.getStringCellValue().toUpperCase().equals(env.toUpperCase())) {
                            columnIndex1 = cell.getColumnIndex();
                        }
                    }

                    if (cell.getColumnIndex() == columnIndex1) {
                        if (cell.getStringCellValue().toUpperCase().equals("ON")) {
                            listRowIndex.add(cell.getRowIndex());
                            listForExecution.add(sheet.getRow(cell.getRowIndex()).getCell(columnIndex).getStringCellValue()
                                    .toString());
                        }
                    }

                }
            }
            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listForExecution;
    }

    public static String ReadExcelByKey(String filePath, String Speccolumn, String RowValue, String ColumnName) {
        String data = "";
        try {

            FileInputStream file = new FileInputStream(new File(filePath));

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            // XSSFSheet sheet = workbook.getSheetAt(0);

            XSSFSheet sheet = workbook.getSheet("Sheet1");
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int rowIndex = 0;
            int columnIndex = 0;
            int columnIndex1 = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    if (cell.getRowIndex() == 0) {
                        if (cell.getStringCellValue().equals(ColumnName)) {
                            columnIndex = cell.getColumnIndex();
                        }

                        if (cell.getStringCellValue().equals(Speccolumn)) {
                            columnIndex1 = cell.getColumnIndex();
                        }
                    }

                    if (cell.getColumnIndex() == columnIndex1) {
                        if (cell.getStringCellValue().toUpperCase().equals(RowValue.toUpperCase())) {
                            rowIndex = cell.getRowIndex();
                        }
                    }

                    if (columnIndex != 0 && rowIndex != 0) {
                        data = sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue().toString();
                        rowIndex = 0;
                        columnIndex = 0;
                    }
                }
            }
            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String readDataFromExcelUsingColumnName(String ColumnName, String path, String sheetName) throws IOException {
        String SheetName = sheetName;//Sheet1
        //String Active = active;//ovde mora da se procita iz excela i na osnovu on ide na getRow(1) ili na getRow(2)
        File file = new File(path);//testdata/configuration.xlsx
        FileInputStream fi = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(fi);
        Sheet sheet = wb.getSheet(SheetName);
        // it will take value from first row
        Row row = sheet.getRow(0);
        // it will give you count of row which is used or filled
        short lastcolumnused = row.getLastCellNum();
        //String Active = row.getCell(lastcolumnused).getStringCellValue();
        int colnum = 0;
       // int brojac = 1;

        for (int i = 0; i < lastcolumnused; i++) {
            if (row.getCell(i).getStringCellValue().equalsIgnoreCase(ColumnName)) {

                colnum = i;
                break;

            }

        }
        // it will take value from Second row
        row = sheet.getRow(1);
        Cell column = row.getCell(colnum);
        String CellValue = column.getStringCellValue();

        return CellValue;

    }

    public static Map<String,  Map<String, String>> setMapData(String filepath, String SheetName) throws IOException {

        FileInputStream fis = new FileInputStream(filepath);

        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheetAt(0);

        int lastRow = sheet.getLastRowNum();

        Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String,String>>();

        Map<String, String> dataMap = new HashMap<String, String>();

        //Looping over entire row
        for(int i=0; i<=lastRow; i++){

            Row row = sheet.getRow(i);

            //1st Cell as Value
            Cell valueCell = row.getCell(1);

            //0th Cell as Key
            Cell keyCell = row.getCell(0);

            String value = valueCell.getStringCellValue().trim();
            String key = keyCell.getStringCellValue().trim();

            //Putting key & value in dataMap
            dataMap.put(key, value);

            //Putting dataMap to excelFileMap
            excelFileMap.put(SheetName, dataMap);
        }

        //Returning excelFileMap
        return excelFileMap;

    }


}
