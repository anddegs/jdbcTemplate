package chrisanabo.jdbctemplate.poc;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFPivotTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotField;

public class CreatePivotTable {

   public static void main(String[] args) throws FileNotFoundException, IOException, InvalidFormatException {
	  // CreatePivotTable.createPivotTable();
	   CreatePivotTable.updateReadPivotTable("/Users/anddegs/devs/chrisanabo/excel3111/ooxml-pivottable.xlsx");
	                                            
	   
   }
    
   
   
   
 

   public static void updateReadPivotTable(String fileName) throws IOException{
	   
	   FileInputStream fis = new FileInputStream(new File(fileName));
		XSSFWorkbook workbook = new XSSFWorkbook (fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator ite = sheet.rowIterator();
		while(ite.hasNext()){
			Row row = (Row) ite.next();
			Iterator<Cell> cite = row.cellIterator();
			while(cite.hasNext()){
				Cell c = cite.next();
				//System.out.print(c.toString() +"  ");
			}
			System.out.println();
		}
		
		fis.close();
	   
		updateCellData(sheet);
	    FileOutputStream fileOut = new FileOutputStream("updated-ooxml-pivottable.xlsx");
	    workbook.write(fileOut);
	       fileOut.close();
	   
   }
   
   public static void createPivotTable() throws IOException{
	   
       XSSFWorkbook wb = new XSSFWorkbook();
       XSSFSheet sheet = (XSSFSheet) wb.createSheet();
  
       //Create some data to build the pivot table on
       setCellData(sheet);
  
       XSSFPivotTable pivotTable = sheet.createPivotTable(new AreaReference("A1:D40"), new CellReference("H5"));
       
       
       pivotTable.addRowLabel(0);
     //  pivotTable.addRowLabel(3);
       
       pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 1,"OK");
       pivotTable.addColumnLabel(DataConsolidateFunction.AVERAGE, 2,"NABA");
      

     
       FileOutputStream fileOut = new FileOutputStream("ooxml-pivottable.xlsx");
       wb.write(fileOut);
       fileOut.close();
       
       
	   
   }
   
   
   
   public static void setCellData(XSSFSheet sheet) {
       Row row1 = sheet.createRow(0);
       // Create a cell and put a value in it.
       Cell cell11 = row1.createCell(0);
       cell11.setCellValue("Names");
       Cell cell12 = row1.createCell(1);
       cell12.setCellValue("#");
       Cell cell13 = row1.createCell(2);
       cell13.setCellValue("%");
       Cell cell14 = row1.createCell(3);
       cell14.setCellValue("Human");

       Row row2 = sheet.createRow(1);
       Cell cell21 = row2.createCell(0);
       cell21.setCellValue("Jane");
       Cell cell22 = row2.createCell(1);
       cell22.setCellValue(10);
       Cell cell23 = row2.createCell(2);
       cell23.setCellValue(100);
       Cell cell24 = row2.createCell(3);
       cell24.setCellValue("Yes");

       Row row3 = sheet.createRow(2);
       Cell cell31 = row3.createCell(0);
       cell31.setCellValue("Tarzan");
       Cell cell32 = row3.createCell(1);
       cell32.setCellValue(5);
       Cell cell33 = row3.createCell(2);
       cell33.setCellValue(90);
       Cell cell34 = row3.createCell(3);
       cell34.setCellValue("Yes");

       Row row4 = sheet.createRow(3);
       Cell cell41 = row4.createCell(0);
       cell41.setCellValue("Terk");
       Cell cell42 = row4.createCell(1);
       cell42.setCellValue(10);
       Cell cell43 = row4.createCell(2);
       cell43.setCellValue(90);
       Cell cell44 = row4.createCell(3);
       cell44.setCellValue("No");
   }

   public static void updateCellData(XSSFSheet sheet) {
     
       Row row2 = sheet.createRow(1);
       Cell cell21 = row2.createCell(0);
       cell21.setCellValue("Jane-XXX");
       Cell cell22 = row2.createCell(1);
       cell22.setCellValue(10);
       Cell cell23 = row2.createCell(2);
       cell23.setCellValue(100);
       Cell cell24 = row2.createCell(3);
       cell24.setCellValue("Yes");

       Row row3 = sheet.createRow(2);
       Cell cell31 = row3.createCell(0);
       cell31.setCellValue("Tarzan");
       Cell cell32 = row3.createCell(1);
       cell32.setCellValue(5);
       Cell cell33 = row3.createCell(2);
       cell33.setCellValue(90);
       Cell cell34 = row3.createCell(3);
       cell34.setCellValue("Yes");

       Row row4 = sheet.createRow(3);
       Cell cell41 = row4.createCell(0);
       cell41.setCellValue("Tersssssk");
       Cell cell42 = row4.createCell(1);
       cell42.setCellValue(10);
       Cell cell43 = row4.createCell(2);
       cell43.setCellValue(90);
       Cell cell44 = row4.createCell(3);
       cell44.setCellValue("No");
       
       
       Row row5= sheet.createRow(4);
       Cell cell51 = row5.createCell(0);
       cell51.setCellValue("Using Template");
       Cell cell52 = row5.createCell(1);
       cell52.setCellValue(100);
       Cell cell53 = row5.createCell(2);
       cell53.setCellValue(900);
       Cell cell54 = row5.createCell(3);
       cell54.setCellValue("Yes");
     
       
       
       Row row6= sheet.createRow(5);
       Cell cell61 = row6.createCell(0);
       cell61.setCellValue("Using Template222");
       Cell cell62 = row6.createCell(1);
       cell62.setCellValue(100);
       Cell cell63 = row6.createCell(2);
       cell63.setCellValue(900);
       Cell cell64 = row6.createCell(3);
       cell64.setCellValue("Yes");
       
   }

   
   public static void addFormulaToCache(XSSFPivotTable pivotTable) {
	    CTCacheFields ctCacheFields = pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields();
	    CTCacheField ctCacheField = ctCacheFields.addNewCacheField();
	    ctCacheField.setName("Field1"); // Any field name
	    ctCacheField.setFormula("'Ended' / 'Generated' * 100");
	    ctCacheField.setDatabaseField(false);
	    ctCacheField.setNumFmtId(0);
	    ctCacheFields.setCount(ctCacheFields.sizeOfCacheFieldArray()); //!!! update count of fields directly
	}

	public static void addPivotFieldForNewColumn(XSSFPivotTable pivotTable) {
	    CTPivotField pivotField = pivotTable.getCTPivotTableDefinition().getPivotFields().addNewPivotField();
	    pivotField.setDataField(true);
	    pivotField.setDragToCol(false);
	    pivotField.setDragToPage(false);
	    pivotField.setDragToRow(false);
	    pivotField.setShowAll(false);
	    pivotField.setDefaultSubtotal(false);
	}

	public static void addFormulaColumn(XSSFPivotTable pivotTable) {
	    CTDataFields dataFields;
	    if(pivotTable.getCTPivotTableDefinition().getDataFields() != null) {
	        dataFields = pivotTable.getCTPivotTableDefinition().getDataFields();
	    } else {
	        // can be null if we have not added any column labels yet
	        dataFields = pivotTable.getCTPivotTableDefinition().addNewDataFields();
	    }
	    CTDataField dataField = dataFields.addNewDataField();
	    dataField.setName("Avg Pct Processed");
	    // set index of cached field with formula - it is the last one!!!
	    dataField.setFld(pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCount()-1);
	    dataField.setBaseItem(0);
	    dataField.setBaseField(0);
	}
}

