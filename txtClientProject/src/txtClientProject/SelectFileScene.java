package txtClientProject;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class SelectFileScene extends Scene{
	
	private GridPane pane;
	private File file;
	private Label topText;
	private Label middleText;
	private Label incorrectFile;
	private Button chooseFile;
	private Button confirm;
	private TextField fileName;
	private Scene selectSessionScene = new SelectSessionScene(new GridPane());
	private ArrayList<Student> students;
	private boolean wrongFile = false;
	
	
	public SelectFileScene(GridPane gridPane){ // It doesn't need to be GridPane, but it will most likely be the best option for this
		super(gridPane, 800, 600); // Window size
		pane = gridPane;
		topText = new Label("File Selection");
		topText.setId("label-headers");
		middleText = new Label("File Name:");
		incorrectFile = new Label("The file you have chosen is of incorrect format.\nPlease select a file with the correct format and headings.");
		fileName = new TextField("");
		fileName.setEditable(false);
		fileName.textProperty().addListener(new ChangeListener<String>() { // Resizes TextField to fit new text
	        @Override
	        public void changed(ObservableValue<? extends String> ob, String o,
	                String n) {
	            // expand the textfield
	            fileName.setPrefWidth(TextUtils.computeTextWidth(fileName.getFont(),
	                    fileName.getText(), 0.0D) + 14);
	        }
	    });
		chooseFile = new Button("Choose File");
		chooseFile.setOnAction(e -> selectFile()); // Action when clicked
		confirm = new Button("Confirm");
		confirm.setDefaultButton(true); // Makes it so you can hit enter instead of pressing the confirm button
		confirm.setDisable(true); // Grays it out
		confirm.setOnAction(e -> confirm());
		confirm.setId("confirm-button");
		
		// ***THINGS THAT CAN BE CHANGED***
		pane.setAlignment(Pos.CENTER); // Makes it so the center element is in the exact center,
		                               // and all other elements are based off of this position
		pane.setHgap(10); // These set the gaps for all elements, look into how to adjust the gaps for each individual element
		//pane.setVgap(130);
		//pane.setGridLinesVisible(true); // Turned on to help with positioning, will be turned off in end product
		GridPane.setConstraints(topText, 1, 0); // These say where to put the elements in the grid
		                                        // There is an overloaded version of this for some fine tuning, check API
		GridPane.setConstraints(middleText, 0, 1);
		GridPane.setConstraints(fileName, 1, 1);
		GridPane.setConstraints(chooseFile, 2, 1);
		GridPane.setConstraints(confirm, 1, 2);
		//GridPane.setConstraints(incorrectFile, 1, 2);
		GridPane.setHalignment(topText, HPos.CENTER); // Centers elements in their cells
		GridPane.setHalignment(confirm, HPos.CENTER);
	    pane.getChildren().addAll(topText, middleText, fileName, chooseFile, confirm); // Adds elements to the pane so they can be visible
	}
	
	public void selectFile() {
		selectSessionScene.getStylesheets().add("DarkMaterial.css");
		FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
		dialog.setDirectory("C:\\");
		dialog.setFile("*.xlsx");
		dialog.setMode(FileDialog.LOAD);
		dialog.setVisible(true);
		//file = new File(dialog.getDirectory() + dialog.getFile());
		try{
			file = dialog.getFiles()[0];
		} catch(ArrayIndexOutOfBoundsException e){
			return;
		}
		file = dialog.getFiles()[0];
		fileName.setText(file.getName());
		ExcelReader er = null; // Does this after select file so that there is minimal delay on confirm button
		try {
			er = new ExcelReader(file);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		students = er.readFile();
		if(students == null || students.size() == 0){
			confirm.setDisable(true);
			wrongFile = true;
			GridPane.setConstraints(incorrectFile, 1, 2);
			GridPane.setConstraints(confirm, 1, 3);
			pane.getChildren().add(incorrectFile);
		}
		else{
			confirm.setDisable(false);
			if(wrongFile){
				wrongFile = false;
				pane.getChildren().remove(incorrectFile);
				GridPane.setConstraints(confirm, 1, 2);
			}
		}
		//System.out.println(file);
		//System.out.println(file.equals(dialog.getFiles()[0]));
	}
	
	public void confirm(){
		if(students.size() == 0){
			JOptionPane.showMessageDialog(null,
					"Please select a file with the correct format", "Incorrect Format",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		System.out.println(students); // For testing
		((SelectSessionScene) selectSessionScene).setStudents(students);
		Program.getWindow().setScene(selectSessionScene);
		
	}

}
