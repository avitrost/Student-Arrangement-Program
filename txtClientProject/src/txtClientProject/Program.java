package txtClientProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Program extends Application {
	
	private static Stage window;
	private Scene selectFileScene = new SelectFileScene(new GridPane());

	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getWindow() {
		return window;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.getIcons().add(new Image("SAPThumbnail.png"));
		window.setTitle("Student Arrangement Program");
		window.setScene(selectFileScene);
		window.show();
		
	}

}
