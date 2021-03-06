package txtClientProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class SelectSessionScene extends Scene{
	
	private Label heading;
	private Button session1;
	private Button session2;
	private ArrayList<Student> students;
	private String filepath;
	
	
	public SelectSessionScene(GridPane pane, String filepath){
		
		super(pane, 800, 600); // Window size
		this.filepath = filepath;
		heading = new Label("Select Session");
		heading.setId("label-headers");
		session1 = new Button("Session One");
		session1.setOnAction(e -> selectSession(1));
		session2 = new Button("Session Two");
		session2.setOnAction(e -> selectSession(2));
		session1.setId("big-button");
		session2.setId("big-button");
		
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
	    //pane.setGridLinesVisible(true);
	}
	
	public void selectSession(int session){
		long startTime = System.nanoTime();
		//System.out.println("Session:  " + session);
		ArrayList<Student> justSession = new ArrayList<Student>(students);
		Iterator<Student> i1 = justSession.iterator();
		while(i1.hasNext()){
			Student s = i1.next();
			if(s.getSession() != session){
				i1.remove();
			}
		}
		if(justSession.size() % 4 != 0){ // Could possibly move this to after the girls
			for(int x = 0; x < justSession.size() % 4; x++){
				justSession.add(new Student(true));
			}
		}
		Collections.shuffle(justSession, new Random(justSession.size())); // So that names have no impact on groups, disabled when testing
		int numGroups = (justSession.size() - 1) / 4 + 1;
		int totalSize = numGroups * 5;
		Algorithm.setTotalNumRoundedUp(totalSize);
		TemplateArrays.initializeTemplates();
		PartialCandidate.setTemplateArr(TemplateArrays.selectTemplate(numGroups));
		ArrayList<Student> nonClementeBoys = new ArrayList<Student>(justSession);
		Iterator<Student> i2 = nonClementeBoys.iterator();
		while(i2.hasNext()){
			Student s = i2.next();
			if(s.isFemale() || s.isClemente() || s.isPlaceholder()){
				i2.remove();
			}
		}
		ArrayList<Student> justGirls = new ArrayList<Student>(justSession);
		Algorithm.setTotalNumInSession(justGirls.size());
		Iterator<Student> i3 = justGirls.iterator();
		while(i3.hasNext()){
			Student s = i3.next();
			if(!s.isFemale() || s.isPlaceholder()){
				i3.remove();
			}
		}
		ArrayList<Student> placeholders = new ArrayList<Student>(justSession);
		Iterator<Student> i4 = placeholders.iterator();
		while(i4.hasNext()){
			Student s = i4.next();
			if(!s.isPlaceholder()){
				i4.remove();
			}
		}
		Algorithm.setGirlsMode(true);
		PartialCandidate solution = Algorithm.generateSeating(justGirls, null, totalSize);
		ArrayList<Student> otherGirlsAndClemente = new ArrayList<Student>(justSession);
		otherGirlsAndClemente.removeAll(solution.getSeating());
		otherGirlsAndClemente.removeAll(nonClementeBoys);
		solution = Algorithm.generateSeating(otherGirlsAndClemente, solution, totalSize);
		/*if(justSession.size() % 4 != 0){ // Could possibly move this to after the girls
			ArrayList<Student> placeholders = new ArrayList<Student>();
			for(int x = 0; x < justSession.size() % 4; x++){
				placeholders.add(new Student(true));
			}
			solution = Algorithm.generateSeating(placeholders, solution, totalSize);
		}*/
		/*if(placeholders.size() != 0){
			solution = Algorithm.generateSeating(placeholders, solution, totalSize);
		}*/
		solution = Algorithm.generateSeating(nonClementeBoys, solution, totalSize);
		//System.out.println(solution);
		for(int j = 0; j < solution.getSeating().size(); j++){
			solution.getSeating().get(j).setNumberInList(j);
		}
		ArrayList<Student>[] groupings = new ArrayList[numGroups * 5];
		int groupNum = 0;
		for(ArrayList<Integer> group : PartialCandidate.getTemplate()){
			ArrayList<Student> al = new ArrayList<Student>();
			for(int i : group){
				Student student = solution.getSeating().get(i);
				if(!student.isPlaceholder()){
					al.add(student);
				}
			}
			groupings[groupNum] = al;
			groupNum++;
		}
		/*for(int k = 0; k < 5; k++){ //TODO comment this
			System.out.println("Day " + (k + 1) + ":");
			for(int i = numGroups*k; i < numGroups+numGroups*k; i++){
				System.out.println(groupings[i]);
			}
		}*/
		ArrayList<Student>[][] seating = new ArrayList[5][numGroups];
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < numGroups; j++){
				seating[i][j] = groupings[i * numGroups + j];
			}
		}
		//System.out.println(Arrays.deepToString(seating));
		
		
		/*JOptionPane.showMessageDialog(null,
				"Found a solution in " + ((double) System.nanoTime() - startTime) / 1000000000 + " seconds", "Algorithm Finished",
				JOptionPane.INFORMATION_MESSAGE);*/
		seatStudents(seating);
		
	}
	
	public void seatStudents(ArrayList<Student>[][] groups){
		for(int day = 0; day < 5; day++){
			for(int groupNum = 0; groupNum < groups[0].length; groupNum++){
				int clementeIndex1 = -1;
				int clementeIndex2 = -1;
				ArrayList<Student> group = groups[day][groupNum];
				for(int i = 0; i < group.size(); i++){
					Student s = group.get(i);
					s.getGroups()[day] = groupNum;
					if(s.isClemente()){
						if(clementeIndex1 == -1){
							clementeIndex1 = i;
						} else if(clementeIndex2 == -1){
							clementeIndex2 = i;
						}
					}
				}
				if(groupNum < 4 || group.size() == 3){
					if(clementeIndex1 != -1){
						swap(group, clementeIndex1, 0);
					}
					if(clementeIndex2 != -1){
						swap(group, clementeIndex2, 2);
					}
				} else{
					if(clementeIndex1 != -1){
						swap(group, clementeIndex1, 1);
					}
					if(clementeIndex2 != -1){
						swap(group, clementeIndex2, 3);
					}
				}
				if(group.size() == 3){
					if(groupNum < 4){
						group.get(0).getSeats()[day] = 'A';
						group.get(1).getSeats()[day] = 'B';
						group.get(2).getSeats()[day] = 'C';
					} else{
						group.get(0).getSeats()[day] = 'B';
						group.get(1).getSeats()[day] = 'C';
						group.get(2).getSeats()[day] = 'D';
					}
				} else{
					group.get(0).getSeats()[day] = 'A';
					group.get(1).getSeats()[day] = 'B';
					group.get(2).getSeats()[day] = 'C';
					group.get(3).getSeats()[day] = 'D';
				}
			}
		}
		Scene sortedStudentScene = new SortedStudentScene(new BorderPane(), groups, filepath);
		Program.getWindow().setScene(sortedStudentScene);
		sortedStudentScene.getStylesheets().add("DarkMaterial.css");
	}
	
	public void swap(ArrayList<Student> group, int index1, int index2){
		Student temp = group.get(index1);
		group.set(index1, group.get(index2));
		group.set(index2, temp);
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}


}
