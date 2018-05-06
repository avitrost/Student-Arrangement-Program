import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	XSSFWorkbook wb;
	
	public ExcelReader(File filePath) throws IOException, InvalidFormatException{
		wb = new XSSFWorkbook(filePath);
	}
	
	public ArrayList<Student> readFile(){
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		ArrayList<Student> students = new ArrayList<Student>();
		boolean firstRow = true;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if(firstRow == true){
				firstRow = false;
				Iterator<Cell> cellIterator = row.cellIterator();
				int i = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if(i==0 && !cell.getStringCellValue().equals("ID")){
						return null;
					} else if(i==1 && !cell.getStringCellValue().equals("Alpha_Name")){
						return null;
					} else if(i==2 && !cell.getStringCellValue().equals("G")){
						return null;
					} else if(i==3 && !cell.getStringCellValue().equals("PHS House")){
						return null;
					}else if(i==4 && !cell.getStringCellValue().equals("Summe MathClass")){
						return null;
					}else if(i==5 && !cell.getStringCellValue().equals("CSchool")){
						return null;
					}else if(i==6 && !cell.getStringCellValue().equals("MCurrentCourse")){
						return null;
					}
					i++;
				}
			} else {
				Iterator<Cell> cellIterator = row.cellIterator();
				int i = 0;
				String name = "";
				String gender = "";
				String session = "";
				String school = "";
				boolean addStudent = true;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if(i==1){
						name = cell.getStringCellValue();
					} else if(i==2){
						gender = cell.getStringCellValue();
					} else if(i==4){
						if(cell.getStringCellValue().equals("No")){
							addStudent = false;
						}
						session = cell.getStringCellValue();
					} else if(i==6){
						school = cell.getStringCellValue();
					}
					i++;
				}
				if(addStudent){
					students.add(new Student(name, gender, session, school));
				}
			}
		}
		return students;
	}
}