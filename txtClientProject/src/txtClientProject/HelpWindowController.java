package txtClientProject;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HelpWindowController { // Controller class for welcome screen

	@FXML
	void buttonOnAction(ActionEvent event) {
		// opens and closes excel so that it doesn't take too long to load
		try {
			Runtime runTime = Runtime.getRuntime();
			runTime.exec("cmd /c start excel.exe");
			try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			runTime.exec("cmd /c taskkill /f /im excel.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Program.selectFileScene();
	}
}
