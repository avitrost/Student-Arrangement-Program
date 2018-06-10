package txtClientProject;
/**The table where sorted students are viewed before saving.
 * @author Skylar Chan
 */
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
@SuppressWarnings({ "unchecked", "rawtypes" })
public class StudentTable extends TableView {
	//These are the columns of student data in the table view
	TableColumn nameCol = new TableColumn("Name");
	TableColumn seatCol = new TableColumn("Seat (Excel Format)");
	TableColumn genCol = new TableColumn("Gender");
	TableColumn schoolCol = new TableColumn("Middle School");

	public StudentTable() {
		//set columns
		//property value factory: <Object, field type>("name of field")
		setEditable(false);
		nameCol.setCellValueFactory(new PropertyValueFactory<Student,String>("fullName"));
		// Set styles for all table headers
		nameCol.setId("table-headers");
		seatCol.setId("table-headers");
		genCol.setId("table-headers");
		schoolCol.setId("table-headers");
		//
		seatCol.setCellValueFactory(new PropertyValueFactory<Student,String>("seatNum"));
		seatCol.setStyle("-fx-font-size:16;");
		genCol.setCellValueFactory(new PropertyValueFactory<Student,String>("myGender"));
		genCol.setStyle("-fx-font-size:16;");
		schoolCol.setCellValueFactory(new PropertyValueFactory<Student,String>("mySchool"));
		schoolCol.setStyle("-fx-font-size:16;");
		getColumns().addAll(nameCol, seatCol, genCol, schoolCol);
		setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}
	
	/**
	 * Updates this Table's contents with the specified list of Students.
	 * @param students The list of students to be viewed.
	 */
	
	//update the data based on the arraylist of students, preserving orientation and sorting arrangement of previous chart
	public void update(ArrayList<Student>[] students) {
		ObservableList<Student> data = FXCollections.observableArrayList();
		
		int nextNum = 1;
		for(ArrayList<Student> group: students) {
			int nextLetter = 65;
			for(Student s: group){
				s.setSeatNum((char)nextLetter, nextNum);
				nextLetter++;
				data.add(s);
			}
			nextNum++;
		}
		setItems(data);
	}
	
	
}