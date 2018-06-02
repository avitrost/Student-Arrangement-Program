package txtClientProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	public static void writeFile(File filepath, ArrayList<Student>[][] seatingChart) throws InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook();
		int i = 1;
		for(ArrayList<Student>[] day : seatingChart){
			// creates a new sheet for 5 days
			String sheetName = "Day " + i;
			i++;
			XSSFSheet sheet = (XSSFSheet)wb.createSheet(sheetName);
	        int rownum = 0;
	        for (ArrayList<Student> team : day) {
	            XSSFRow row = sheet.createRow(rownum);
	            rownum++;
	            int cellnum = 0;
	            for (Student student : team) {
	                XSSFCell cell = (XSSFCell) row.createCell(cellnum);
	                cellnum++;
	                cell.setCellValue(student.toString());
	            }
	        }
	        fis.close();
	        FileOutputStream out = new FileOutputStream(filepath);
	        wb.write(out);
	        out.close();
		}
		wb.close();
	}
}
