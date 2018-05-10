package txtClientProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SelectSessionScene extends Scene{
	
	private Label heading;
	private Button session1;
	private Button session2;
	
	
	public SelectSessionScene(GridPane pane){
		super(pane, 800, 600);
		heading = new Label("SELECT SESSION");
		session1 = new Button("SESSION ONE");
		session1.setOnAction(e -> selectSession(1));
		session2 = new Button("SESSION TWO");
		session2.setOnAction(e -> selectSession(2));
		GridPane.setConstraints(heading, 0, 0);
		GridPane.setConstraints(session1, 0, 1);
		GridPane.setConstraints(session2, 0, 2);
		
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(30);
		pane.setVgap(130);
	    pane.setPadding(new Insets(10, 10, 10, 10));
	    pane.getChildren().addAll(heading, session1, session2);
	}
	
	public void selectSession(int session){
		System.out.println("Session:  " + session);
	}

}
