package txtClientProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	public static void writeFile(File filepath, ArrayList<Student>[][] seatingChart) throws InvalidFormatException, IOException{
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = (XSSFSheet)wb.createSheet("Sorted Students");
        int rownum = 0;
		for(int dayNum = 1; dayNum<=5; dayNum++){
			ArrayList<Student>[] day = seatingChart[dayNum-1];
			// makes a title
	        XSSFRow headerRow = sheet.createRow(rownum);
	        XSSFCell dayCell = (XSSFCell) headerRow.createCell(1);
	        String dayoftheweek = "";
	        switch(dayNum){
	        case 1:
	        	dayoftheweek = "Monday";
	        	break;
	        case 2:
	        	dayoftheweek = "Tuesday";
	        	break;
	        case 3:
	        	dayoftheweek = "Wednesday";
	        	break;
	        case 4:
	        	dayoftheweek = "Thursday";
	        	break;
	        case 5:
	        	dayoftheweek = "Friday";
	        	break;
	        }
	        dayCell.setCellValue(dayoftheweek);
	        //Style the Header Cell
	        XSSFFont font = wb.createFont();
	        font.setBold(true);
	        font.setUnderline(XSSFFont.U_SINGLE);
	        XSSFCellStyle style = wb.createCellStyle();
	        style.setFont(font);
	        dayCell.setCellStyle(style);
	        rownum += 2;
	        
	        //Creates the letters heading
	        XSSFRow firstRow = sheet.createRow(rownum);
	        rownum++;
	        int cNum = 0;
	        for(int k = 0; k<=4; k++){
	        	if(k>0){
		        	XSSFCell cell = (XSSFCell) firstRow.createCell(cNum);
		        	String a = (char)(k+64) + "";
		        	cell.setCellValue(a);
		        	cNum++;
	        	} else {
	        		cNum++;
	        	}
	        }
	        
	        //fills in the names
	        int colNum = 1;
	        for (ArrayList<Student> team : day) {
	            XSSFRow row = sheet.createRow(rownum);
	            rownum++;
	            int cellnum = 0;
            	XSSFCell numCell = (XSSFCell) row.createCell(cellnum); // for the row number
            	numCell.setCellValue(colNum++);
            	cellnum++;
	            for (Student student : team) {
	                XSSFCell cell = (XSSFCell) row.createCell(cellnum);
	                cell.setCellValue(student.toString());
	                cellnum++;
	            }
	        }
	        for(int columnIndex = 0; columnIndex < 5; columnIndex++) {
	            sheet.autoSizeColumn(columnIndex);
	        }
	        rownum += 2;
	        FileOutputStream out = new FileOutputStream(filepath);
	        wb.write(out);
	        out.close();
		}
		wb.close();
	}
}
