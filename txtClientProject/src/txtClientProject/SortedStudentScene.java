package txtClientProject;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SortedStudentScene
extends Scene {
	private String filepath;
    private ArrayList<Student>[][] students;
    private Button save;
    private Button Mon;
    private Button Tue;
    private Button Wed;
    private Button Thu;
    private Button Fri;
    private String[] days = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri"};
    //private StudentSorter sorter;
    private BorderPane display = new BorderPane();
    private StudentTable table;
    private int day = 0;
    private String session;

    public SortedStudentScene(BorderPane bp, ArrayList<Student>[][] groups, String filepath) {
    	super(bp, 800, 600);
    	this.filepath = filepath;
        session = groups[0][0].get(0).getSession() + "";
        students = groups;
        save = new Button("Save");
        save.setId("save-button");
        Mon = new Button(days[0]);
        Mon.setId("pressed-button");
        Tue = new Button(days[1]);
        Tue.setId("unpressed-button");
        Wed = new Button(days[2]);
        Wed.setId("unpressed-button");
        Thu = new Button(days[3]);
        Thu.setId("unpressed-button");
        Fri = new Button(days[4]);
        Fri.setId("unpressed-button");
        Button[] list = {save, Mon,Tue,Wed,Thu,Fri};
		for(Button b:list) {
			b.setOnAction(e->ButtonClicked(e));
		}
		HBox hbox = new HBox();
        hbox.setPadding(new Insets(10.0));
        hbox.setSpacing(8.0);
        hbox.getChildren().addAll(save);
        hbox.setAlignment(Pos.CENTER);
        bp.setBottom(hbox);
        HBox hungrybox = new HBox();
		hungrybox.setPadding(new Insets(10));
		hungrybox.setSpacing(8);
		hungrybox.getChildren().addAll(Mon,Tue,Wed,Thu,Fri);
		hungrybox.setAlignment(Pos.CENTER);
		display.setTop(hungrybox);
        table = new StudentTable();
		table.update(students[0]);
        display.setCenter(table);
        bp.setCenter(display);
        /*int clemente = 0;
        int femaleNum =0 ;
        int femaleClemente = 0;
		for(Student s:students) {
			boolean both = true;
			if(s.isClemente()) {
				clemente++;
			} else {
				both = false;
			}
			if(s.isFemale()) {
				femaleNum++;
			} else {
				both = false;
			}
			if(both) {
				femaleClemente++;
			}
		}
		int clementeLimit = (int)(Math.random()*100000);
		int groupNum = (int)(Math.random()*100000);
		System.out.println("Details:\nSession: "+session+"\nNumber of students: "+students.size()+"\nNumber of groups: "+groupNum+"\nMax Clemente per group: "+clementeLimit);
		System.out.println("Number of females: "+femaleNum+"\nNumber of Clementes: "+clemente+"\nNumber of female Clementes: "+femaleClemente);
		sorter = new StudentSorter(students);
        output = sorter.sort();
		switchView("Mon");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Students Sorted");
		alert.setHeaderText("The file has been sorted.");
		alert.setContentText("Details:\nSession: "+session+"\nNumber of students: "+students.size()+"\nNumber of groups: "+groupNum+"\nMax Clemente per group: "+clementeLimit);
		alert.show();*/
    }

    public void ButtonClicked(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == save) {
            try {
				ExcelWriter.writeFile(new File(filepath+"Session_"+session+".xlsx"), students);
				String[] answers = {"Open File", "Continue"};
				int ans = JOptionPane.showOptionDialog(null, "Solution was saved to " + filepath+"Session_"+session+".xlsx", "Solution Saved",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answers, answers[0]);
				switch(ans){
				case 0:
					File file = new File(filepath+"Session_"+session+".xlsx");
					Desktop desktop = Desktop.getDesktop();
			        if(file.exists()) desktop.open(file);
				}
			} catch (InvalidFormatException | IOException e1) {
				e1.printStackTrace();
			}
        } else {
        	switchView(((Button)obj).getText());//which day is pressed?
        }
    }


    private void switchView(String button) {
    	//updates the day that is currently being viewed
		switch(button) {
		case "Mon":
			day=0;
			break;
		case "Tue":
			day=1;
			break;
		case "Wed":
			day=2;
			break;
		case "Thu":
			day=3;
			break;
		case "Fri":
			day=4;
			break;
		}
		//System.out.println(day);
		table.update(students[day]);
		Button[] list = {Mon, Tue, Wed, Thu, Fri};
		for(int i=0; i<list.length; i++) {
			if(list[i].getText().equals(button)) {
				list[i].setId("pressed-button");
			} else {
				
				list[i].setId("unpressed-button");
			}
		}	
    }
}