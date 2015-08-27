package chrisanabo.jdbctemplate.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;   
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFPivotTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotTableDefinition;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotTableStyle;

public class ReportGenerator {

	private String DATE_TIME_FORMAT = "yyyyMMdd HH:mm:sss";
	// private String cql;
	// private String dimension;
	// private String dateValue;
 
	private String row[];
	private String column[];
	private String fullPathFileName;

	public ReportGenerator(String[] row,
			String column[], String fullPathFileName) {

		this.row = row;
		this.column = column;
		this.fullPathFileName = fullPathFileName;
	}

	public void generateReport(List<Map<String, Object>> matrixData) {

		XSSFWorkbook workBook = new XSSFWorkbook();
		String sourceWorkSheet = "Sheet1";
		String targetWorkSheet = "Sheet2";

		List<Map<String, Object>> records = matrixData;

		
		if (records != null && records.size() > 0) {
			String[] columnHeader = this.getColumnHeader(records.get(0));
			createSourceWorkSheet(workBook, records, columnHeader,
					sourceWorkSheet);

			this.generatePivotReport(workBook, sourceWorkSheet,
					targetWorkSheet, fullPathFileName, row, column,
					Arrays.asList(columnHeader));

		} else {

		}
	}

	private void generatePivotReport(XSSFWorkbook workBook,
			String sourceWorkSheet, String targetWorkSheet,
			String fullPathFileName, String[] row, String[] column,
			List<String> columnHeader) {

		String fileNamePath = fullPathFileName;
		workBook.createSheet(targetWorkSheet);
		workBook.getSheet(targetWorkSheet);

		XSSFSheet sheet = workBook.getSheetAt(0);
		XSSFSheet sheet2 = workBook.getSheetAt(1);

		Row r = sheet.getRow(sheet.getLastRowNum());
		int lastRowNum = sheet.getLastRowNum();
		int lastRowCellNum = r.getLastCellNum() - 1;

		AreaReference source = new AreaReference(new CellReference("Sheet1", 0,
				0, false, false), new CellReference("Sheet1", lastRowNum,
				lastRowCellNum, false, false));

		CellReference b = new CellReference("A1");

		XSSFPivotTable pivotTable = sheet2.createPivotTable(source, b);

		CTPivotTableDefinition ctPivotTableDefinition = pivotTable
				.getCTPivotTableDefinition();
		CTPivotTableStyle ctPivotTableStyle = ctPivotTableDefinition
				.getPivotTableStyleInfo();
		ctPivotTableStyle.setName("PivotStyleLight1");

		for (int i = 0; i < row.length; i++) {
			int index = this.getIndex(row[i], columnHeader);
			if (index < 0) {

			} else {
				pivotTable.addRowLabel(index);
			}
		}

		for (int i = 0; i < column.length; i++) {
			int index = this.getIndex(column[i], columnHeader );
			pivotTable.addColumnLabel(DataConsolidateFunction.COUNT, index);
		}

		FileOutputStream output_file = null;

		try {
			output_file = new FileOutputStream(new File(fileNamePath));
			workBook.write(output_file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private String[] getColumnHeader(Map<String, Object> row) {

		String[] columnHeader = new String[row.keySet().size()];
		columnHeader = row.keySet().toArray(columnHeader);
		return columnHeader;

	}

	private XSSFSheet createSourceWorkSheet(XSSFWorkbook workBook,
			List<Map<String, Object>> matrixData, String[] columnHeader,
			String sourceWorkSheet) {

		XSSFSheet sheet = (XSSFSheet) workBook.createSheet(sourceWorkSheet);

		List<String> xlHeader = new ArrayList<String>();

		Row header = sheet.createRow(0);

		for (int i = 0; i < columnHeader.length; i++) {
			Cell headerColValue = header.createCell(i);
			headerColValue.setCellValue(columnHeader[i]);
			xlHeader.add(columnHeader[i]);
		}

		int ctr = 1;
		for (Map<String, Object> rows : matrixData) {
			Row r = sheet.createRow(ctr);

			for (Map.Entry<String, Object> row : rows.entrySet()) {
				Object value = row.getValue();
				Cell cellValue = null;

				if (!xlHeader.contains(row.getKey())) {
					Cell headerColValue = header.createCell(xlHeader.size());
					headerColValue.setCellValue(row.getKey());
					xlHeader.add(row.getKey());
					cellValue = r.createCell(xlHeader.size());

				} else {
					cellValue = r.createCell(getIndex(row.getKey(), xlHeader));
				}

				if (value instanceof String) {
					cellValue.setCellValue(String.valueOf(value));
				} else if (value instanceof Double) {
					cellValue.setCellValue((Double) value);
				} else {
					new UnsupportedOperationException(
							"Data type not supportted by the report generator");
				}
			}
			ctr++;
		}

		return sheet;
	}

	private int getIndex(String column, List<String> columnName) {

		for (int i = 0; i < columnName.size(); i++) {
			if (column.equals(columnName.get(i))) {
				return i;
			}
		}
		return -1;
	}

}