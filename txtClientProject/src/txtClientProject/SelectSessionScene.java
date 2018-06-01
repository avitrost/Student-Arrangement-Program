package txtClientProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JOptionPane;

import javafx.geometry.HPos;
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
	private ArrayList<Student> students;
	
	
	public SelectSessionScene(GridPane pane){
		super(pane, 800, 600); // Window size
		heading = new Label("SELECT SESSION");
		session1 = new Button("SESSION ONE");
		session1.setOnAction(e -> selectSession(1));
		session2 = new Button("SESSION TWO");
		session2.setOnAction(e -> selectSession(2));
		
		// Same notes as previous scene
		GridPane.setConstraints(heading, 0, 0);
		GridPane.setConstraints(session1, 0, 1);
		GridPane.setConstraints(session2, 0, 2);
		GridPane.setHalignment(heading, HPos.CENTER);
		GridPane.setHalignment(session1, HPos.CENTER);
		GridPane.setHalignment(session2, HPos.CENTER);
		
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(30);
		pane.setVgap(130);
	    pane.setPadding(new Insets(10, 10, 10, 10));
	    pane.getChildren().addAll(heading, session1, session2);
	    pane.setGridLinesVisible(true);
	}
	
	public void selectSession(int session){
		long startTime = System.nanoTime();
		System.out.println("Session:  " + session);
		ArrayList<Student> justSession = new ArrayList<Student>(students);
		Iterator<Student> i1 = justSession.iterator();
		while(i1.hasNext()){
			Student s = i1.next();
			if(s.getSession() != session){
				i1.remove();
			}
		}
		ArrayList<Student> nonClementeBoys = new ArrayList<Student>(justSession);
		Iterator<Student> i2 = nonClementeBoys.iterator();
		while(i2.hasNext()){
			Student s = i2.next();
			if(s.isFemale() || s.isClemente()){
				i2.remove();
			}
		}
		ArrayList<Student> justGirls = new ArrayList<Student>(justSession);
		Algorithm.setTotalNumInSession(justGirls.size());
		Iterator<Student> i3 = justGirls.iterator();
		while(i3.hasNext()){
			Student s = i3.next();
			if(!s.isFemale()){
				i3.remove();
			}
		}
		//Collections.shuffle(justSession); // So that names have no impact on groups, disabled when testing
		//System.out.println(justSession);
		Algorithm.setGirlsMode(true);
		PartialCandidate solution = Algorithm.generateSeating(justSession, null);
		ArrayList<Student> otherGirlsAndClemente = new ArrayList<Student>(justSession);
		otherGirlsAndClemente.removeAll(solution.getSeating());
		otherGirlsAndClemente.removeAll(nonClementeBoys);
		solution = Algorithm.generateSeating(otherGirlsAndClemente, solution);
		if(justSession.size() % 4 != 0){ // Could possibly move this to after the girls
			ArrayList<Student> placeholders = new ArrayList<Student>();
			for(int x = 0; x < justSession.size() % 4; x++){
				placeholders.add(new Student(true));
			}
			solution = Algorithm.generateSeating(placeholders, solution);
		}
		solution = Algorithm.generateSeating(nonClementeBoys, solution);
		System.out.println(solution);
		JOptionPane.showMessageDialog(null,
				"Found a solution in " + ((double) System.nanoTime() - startTime) / 1000000000 + " seconds", "Algorithm Finished",
				JOptionPane.INFORMATION_MESSAGE);
		return;
		
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}


}
