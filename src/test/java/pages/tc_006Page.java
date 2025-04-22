package pages;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class tc_006Page {
    Workbook workbook;

    public void exportReport() {
        // Code to trigger the exporting of the report
    }

    public void openExcelFile() {
        try {
            FileInputStream excelFile = new FileInputStream(new File("path/to/exported/report.xlsx"));
            workbook = new XSSFWorkbook(excelFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isIVA0ColumnPresent() {
        Sheet sheet = workbook.getSheetAt(0);
        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            if ("IVA 0%".equals(cell.getStringCellValue())) {
                return true;
            }
        }
        return false;
    }

    public boolean areIVA0ValuesCorrect() {
        Sheet sheet = workbook.getSheetAt(0);
        int iva0ColumnIndex = -1;
        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            if ("IVA 0%".equals(cell.getStringCellValue())) {
                iva0ColumnIndex = cell.getColumnIndex();
                break;
            }
        }

        if (iva0ColumnIndex == -1) {
            return false;
        }

        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            Cell cell = row.getCell(iva0ColumnIndex);
            if (cell.getCellType() != CellType.NUMERIC || cell.getNumericCellValue() < 0) {
                return false;
            }
        }
        return true;
    }
}