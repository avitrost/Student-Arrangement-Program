package txtClientProject;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class SelectFileScene extends Scene{
	
	private File file;
	private Label topText;
	private Label middleText;
	private Button chooseFile;
	private Button confirm;
	private Label filePath;
	
	
	public SelectFileScene(GridPane pane){
		super(pane, 600, 400);
		topText = new Label("FILE SELECTION");
		middleText = new Label("FILE PATH:");
		filePath = new Label("                                            ");
		chooseFile = new Button("CHOOSE FILE");
		chooseFile.setOnAction(e -> selectFile());
		confirm = new Button("CONFIRM");
		confirm.setDefaultButton(true);
		confirm.setDisable(true);
		confirm.setOnAction(e -> confirm());
		//pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(100);
		//pane.setGridLinesVisible(true);
		GridPane.setConstraints(topText, 1, 0);
		GridPane.setConstraints(middleText, 0, 1);
		GridPane.setConstraints(filePath, 1, 1);
		GridPane.setConstraints(chooseFile, 2, 1);
		GridPane.setConstraints(confirm, 1, 2);
	    pane.setPadding(new Insets(10, 10, 10, 10));
	    pane.getChildren().addAll(topText, middleText, filePath, chooseFile, confirm);
	}
	
	public void selectFile() {
		FileDialog dialog = new FileDialog((Frame)null, "Select File to Open"); // Try replacing (Frame)null with the JFrame
		dialog.setDirectory("C:\\");
		dialog.setFile("*.xlsx");
		dialog.setMode(FileDialog.LOAD);
		dialog.setVisible(true);
		//file = new File(dialog.getDirectory() + dialog.getFile());
		file = dialog.getFiles()[0];
		filePath.setText(file.toString());
		confirm.setDisable(false);
		//System.out.println(file);
		//System.out.println(file.equals(dialog.getFiles()[0]));
	}
	
	public void confirm(){
		ExcelReader er = null;
		try {
			er = new ExcelReader(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Student> students = er.readFile();
		System.out.println(students);
	}

}
