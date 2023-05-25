package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public static int totalRow;

	public List<Map<String, String>> getData(String excelFilePath, String sheetName)
			throws InvalidFormatException, IOException {

		Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		workbook.close();
		return readSheet(sheet);
	}

	private List<Map<String, String>> readSheet(Sheet sheet) {

		Row row;
		Cell cell;

		totalRow = sheet.getLastRowNum();

		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();

		for (int currentRow = 1; currentRow <= totalRow; currentRow++) {

			row = sheet.getRow(currentRow);

			int totalColumn = row.getLastCellNum();

			LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();

			for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {

				cell = row.getCell(currentColumn);

				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue();

				columnMapdata.put(columnHeaderName, cell.getStringCellValue());
			}

			excelRows.add(columnMapdata);
		}

		return excelRows;
	}

	public int countRow() {

		return totalRow;
	}

	String path;
	FileInputStream fis;
	Workbook workbook;
	Sheet sheet;
	Row row;

//	public ExcelReader(String path) {
//		super();
//		this.path = path;
//	}

	public void readSheet(String path, String sheetName) throws Exception {

		File file = new File(path);
		fis = new FileInputStream(file);

		// Below API can ready both xls and xlsx formats
		workbook = WorkbookFactory.create(fis);

		// Below API only ready xlsx formats
		// workbook = new XSSFWorkbook(fis);

		// Below API only ready xls formats
		// workbook=new HSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);

	}

	public String getDataFromExcel(String rowName, String colName) throws IOException {
		int dataRowNum = -1;
		int dataColNum = -1;
		String retVal = null;
		int totalRows = sheet.getLastRowNum();
		int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int i = 0; i <= totalRows; i++) {
			if (sheet.getRow(i).getCell(0).getStringCellValue().equals(rowName)) {
				dataRowNum = i;
				break;
			}

		}
		for (int j = 0; j <= totalCols; j++) {
			if (sheet.getRow(0).getCell(j).getStringCellValue().equals(colName)) {
				dataColNum = j;
				break;
			}
		}
//		String body = sheet.getRow(dataRowNum).getCell(dataColNum).getStringCellValue();
//		fis.close();
//		return body;

		DataFormatter formatter = new DataFormatter(); // creating formatter using the default locale
		Cell cell = sheet.getRow(dataRowNum).getCell(dataColNum);
		String retVal1 = formatter.formatCellValue(cell); // Returns the formatted value of a cell as a String
															// regardless of the cell type.
		fis.close();
		return retVal1;
	}

}
