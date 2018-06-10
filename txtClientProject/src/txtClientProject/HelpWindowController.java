package txtClientProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HelpWindowController { // Controller class for welcome screen

	@FXML
	void buttonOnAction(ActionEvent event) {
		Program.selectFileScene();
	}
}
