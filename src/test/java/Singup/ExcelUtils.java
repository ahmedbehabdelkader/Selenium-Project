package Singup;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    // Open the Excel file and load the sheet
    public static void setExcelFile(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = WorkbookFactory.create(fis);
        sheet = workbook.getSheet(sheetName);
    }

    // Get the value from a specific cell
    public static String getCellData(int rowNum, int colNum) {
        Cell cell = sheet.getRow(rowNum).getCell(colNum);
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }

    // Get the total number of rows
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }
}

