package txtClientProject;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Program extends Application {
	
	private static Stage window;
	private static File inputFile;
	private static ArrayList<Student> students = new ArrayList<Student>();
	private Scene selectFileScene = new SelectFileScene(new GridPane());

	public static void main(String[] args) {
		launch(args);
	}
	
	public void selectFileScene(){
		
	}
	
	public File selectFile() {
		FileDialog dialog = new FileDialog((Frame)null, "Select File to Open"); // Try replacing (Frame)null with the JFrame
		dialog.setDirectory("C:\\");
		dialog.setFile("*.docx");
		dialog.setMode(FileDialog.LOAD);
		dialog.setVisible(true);
		inputFile = new File(dialog.getDirectory() + dialog.getFile());
		System.out.println(inputFile);
		System.out.println(inputFile.equals(dialog.getFiles()[0]));
		return inputFile;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.getIcons().add(new Image("icon1.png"));
		window.setTitle("Student Arrangement Program");
		window.setScene(selectFileScene);
		window.show();
		
	}

}
