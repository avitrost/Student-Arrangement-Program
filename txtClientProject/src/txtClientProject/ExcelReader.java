import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	XSSFWorkbook wb;
	
	public ExcelReader(String filePath) throws IOException{
		FileInputStream file = new FileInputStream(new File(filePath));
		wb = new XSSFWorkbook(file);
	}
	
	public ArrayList<Student> readFile(){
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		ArrayList<Student> students = new ArrayList<Student>();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			int i = 0;
			String name = "";
			String gender = "";
			String session = "";
			String school = "";
			
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if(i==1){
					name = cell.getStringCellValue();
				} else if(i==2){
					gender = cell.getStringCellValue();
				} else if(i==4){
					session = cell.getStringCellValue();
				} else if(i==6){
					school = cell.getStringCellValue();
				}
				i++;
			}
			students.add(new Student(name, gender, session, school));
		}
		return students;
	}
}