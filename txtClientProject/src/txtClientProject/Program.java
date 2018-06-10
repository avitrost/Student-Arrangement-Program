/*
 * Avi Trost
 * 6/10/18
 * This is a program that takes, as input, an excel file of students in the summer math sessions,
 * and as output gives the seating arrangement of the students based on certain constraints, such as
 * students can't sit with each other more than once.
 */

package txtClientProject;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Program extends Application {
	
	private static Stage window;
	private static Scene selectFileScene = new SelectFileScene(new GridPane());

	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getWindow() {
		return window;
	}
	
	public static void selectFileScene() {
		window.setScene(selectFileScene);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		selectFileScene.getStylesheets().add("DarkMaterial.css");
		window = primaryStage;
		window.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    @Override
		    public void handle(WindowEvent t) {
		        Platform.exit();
		        System.exit(0);
		    }
		});
		window.setTitle("Student Arrangement Program");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/Help Window.fxml"));
		Parent content = loader.load();
		window.setScene(new Scene(content));
		window.show();
		
	}

}
