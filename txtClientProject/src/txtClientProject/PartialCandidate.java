package txtClientProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PartialCandidate {
	
	private ArrayList<Student> currentSeating;
	private ArrayList<Student> currentStudents;
	private ArrayList<Student> previousSeating;
	private ArrayList<Student> previousStudents;
	private ArrayList<Student> seating;
	private ArrayList<Integer> seatOrder;
	private ArrayList<Integer> seatsLeft;
	private int nextStudentNum;
	private int lastStudentIndexSelected;
	private int numSingleGirlGroups = 0;
	private int numDoubleGirlGroups = 0;
	
	private static ArrayList<Integer>[] template = new ArrayList[35];
	private int currentStudentNumInList;
	private int currentSeatNum;
	private boolean threeGirlsOptionAvailable = false;
	/*public static Integer[][] templateArr = { { 9, 43, 11, 27 }, // 44
	    { 18, 21, 6, 40 },
	    { 5, 39, 4, 30 },
	    { 36, 33, 24, 35 },
	    { 32, 37, 38, 31 },
	    { 3, 19, 42, 28 },
	    { 25, 26, 23, 34 },
	    { 41, 22, 12, 20 },
	    { 7, 29, 16, 17 },
	    { 14, 10, 2, 13 },
	    { 15, 8, 0, 1 } ,
	   { 20, 30, 8, 43 },
	    { 7, 40, 23, 41 },
	    { 0, 38, 4, 22 },
	    { 31, 14, 34, 36 },
	    { 35, 16, 42, 32 },
	    { 3, 10, 27, 12 },
	    { 24, 37, 6, 25 },
	    { 9, 39, 2, 21 },
	    { 17, 19, 33, 18 },
	    { 13, 15, 29, 26 },
	    { 1, 11, 5, 28 } ,
	   { 8, 9, 6, 7 },
	    { 42, 14, 39, 41 },
	    { 26, 5, 38, 40 },
	    { 28, 20, 34, 37 },
	    { 31, 13, 30, 33 },
	    { 25, 27, 35, 29 },
	    { 24, 3, 23, 4 },
	    { 36, 21, 17, 22 },
	    { 2, 1, 16, 19 },
	    { 32, 43, 12, 15 },
	    { 18, 10, 0, 11 } ,
	   { 9, 16, 22, 40 },
	    { 7, 43, 24, 42 },
	    { 19, 37, 4, 36 },
	    { 35, 3, 11, 38 },
	    { 39, 33, 29, 20 },
	    { 28, 31, 12, 0 },
	    { 8, 26, 21, 14 },
	    { 32, 6, 2, 23 },
	    { 15, 5, 25, 18 },
	    { 13, 17, 27, 41 },
	    { 10, 34, 30, 1 } ,
	   { 36, 29, 8, 41 },
	    { 22, 10, 6, 43 },
	    { 5, 9, 0, 37 },
	    { 35, 18, 34, 39 },
	    { 3, 32, 40, 33 },
	    { 28, 30, 27, 21 },
	    { 7, 25, 31, 11 },
	    { 20, 17, 2, 24 },
	    { 15, 38, 14, 19 },
	    { 13, 16, 12, 23 },
	    { 42, 26, 4, 1 }  };*/
	public static Integer[][] templateArr = { { 12, 27, 8, 20 }, // 28
		    { 7, 17, 3, 24 },
		    { 5, 23, 10, 16 },
		    { 6, 21, 11, 26 },
		    { 18, 19, 22, 25 },
		    { 14, 15, 9, 13 },
		    { 4, 2, 0, 1  },
		   { 9, 21, 22, 27 },
		    { 1, 24, 6, 25 },
		    { 15, 17, 4, 23 },
		    { 18, 20, 2, 26 },
		    { 8, 19, 16, 3 },
		    { 11, 5, 12, 14 },
		    { 7, 13, 0, 10  },
		   { 8, 9, 6, 7 },
		    { 4, 5, 26, 27 },
		    { 24, 14, 22, 23 },
		    { 20, 11, 13, 3 },
		    { 17, 18, 16, 0 },
		    { 2, 25, 12, 15 },
		    { 1, 10, 19, 21  },
		   { 9, 20, 10, 24 },
		    { 7, 1, 16, 26 },
		    { 14, 21, 4, 25 },
		    { 19, 23, 2, 27 },
		    { 15, 3, 5, 18 },
		    { 13, 17, 12, 6 },
		    { 8, 11, 0, 22  },
		   { 13, 24, 8, 2 },
		    { 14, 18, 6, 27 },
		    { 5, 20, 1, 22 },
		    { 3, 21, 0, 23 },
		    { 15, 11, 7, 19 },
		    { 9, 16, 12, 4 },
		    { 10, 26, 25, 17  } };
	
	public PartialCandidate(ArrayList<Student> seating, ArrayList<Student> students, int currentStudentNumInList, int currentSeatNum){
		this.seating = seating;
		this.students = students;
		this.currentStudentNumInList = currentStudentNumInList;
		this.currentSeatNum = currentSeatNum;
		arrayToTemplate(templateArr);
	}
	
	public PartialCandidate(ArrayList<Student> seating, ArrayList<Student> students){
		arrayToTemplate(templateArr);
		this.seating = seating;
		this.students = students;
	}
	
	public PartialCandidate(PartialCandidate other){
		seating = new ArrayList<Student>(other.seating);
		seatOrder = new ArrayList<Integer>(other.seatOrder);
		seatsLeft = new ArrayList<Integer>(other.seatsLeft);
		nextStudentNum = other.nextStudentNum;
		//arrayToTemplate(templateArr);
		/*currentSeating = other.currentSeating;
		previousSeating = other.previousSeating;
		previousStudents = other.previousStudents;
		previousStudents = other.previousStudents;*/
	}
	
	public PartialCandidate(ArrayList<Student> students, int totalNumStudentsInSession){
		/*currentSeating = new ArrayList<Student>(students.size());
		previousSeating = new ArrayList<Student>(students.size());
		currentStudents = new ArrayList<Student>(students);
		previousStudents = new ArrayList<Student>(students);*/
		seating = new ArrayList<Student>(totalNumStudentsInSession); // TEMPORARY SIZING
		arrayToTemplate(templateArr);
		Student filler = new Student();
		for (int i = 0; i < totalNumStudentsInSession; i++) {
	        seating.add(filler);
	    }
		nextStudentNum = -1;
		seatOrder = new ArrayList<Integer>(totalNumStudentsInSession);
		seatsLeft = new ArrayList<Integer>(totalNumStudentsInSession);
		for(int i = 0; i < totalNumStudentsInSession; i++){
			seatsLeft.add(i);
		}
	}
	
	

	public ArrayList<Student> getCurrentSeating() {
		return currentSeating;
	}

	public void setCurrentSeating(ArrayList<Student> currentSeating) {
		this.currentSeating = currentSeating;
	}

	public ArrayList<Student> getCurrentStudents() {
		return currentStudents;
	}

	public void setCurrentStudents(ArrayList<Student> currentStudents) {
		this.currentStudents = currentStudents;
	}

	public ArrayList<Student> getPreviousSeating() {
		return previousSeating;
	}

	public void setPreviousSeating(ArrayList<Student> previousSeating) {
		this.previousSeating = previousSeating;
	}

	public ArrayList<Student> getPreviousStudents() {
		return previousStudents;
	}

	public void setPreviousStudents(ArrayList<Student> previousStudents) {
		this.previousStudents = previousStudents;
	}

	public int getLastStudentIndexSelected() {
		return lastStudentIndexSelected;
	}

	public void setLastStudentIndexSelected(int lastStudentIndexSelected) {
		this.lastStudentIndexSelected = lastStudentIndexSelected;
	}

	public ArrayList<Student> getSeating() {
		return seating;
	}


	public void setSeating(ArrayList<Student> seating) {
		this.seating = seating;
	}


	public ArrayList<Student> getStudents() {
		return students;
	}


	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}


	public boolean isThreeGirlsOptionAvailable() {
		return threeGirlsOptionAvailable;
	}

	public void setThreeGirlsOptionAvailable(boolean threeGirlsOptionAvailable) {
		this.threeGirlsOptionAvailable = threeGirlsOptionAvailable;
	}

	public int getCurrentStudentNumInList() {
		return currentStudentNumInList;
	}


	public void setCurrentStudentNumInList(int currentStudentNumInList) {
		this.currentStudentNumInList = currentStudentNumInList;
	}


	public int getCurrentSeatNum() {
		return currentSeatNum;
	}


	public void setCurrentSeatNum(int currentSeatNum) {
		this.currentSeatNum = currentSeatNum;
	}
	
	// ISSUE IS IN HERE
	public Student[][] getGroups(Student student){ // Returns the groups that the student is in
		//System.out.println(Algorithm.getOrderedStudents());
		Student[][] studentGroups = new Student[5][4];
		int groupCount = 0;
		for(ArrayList<Integer> group : template){
			if(group.contains(seating.indexOf(student))){ // student.getNumberInList())
				for(int i = 0; i < 4; i++){
					//System.out.println(groupCount + "  " + i);
					try{
					studentGroups[groupCount][i] = seating.get(group.get(i));
					} catch(IndexOutOfBoundsException e){
						studentGroups[groupCount][i] = null;
					}
				}
				groupCount++;
				if(groupCount == 5){
					return studentGroups;
				}
			}
		}
		System.out.println("Check the getGroups() method");
		return null;
	}
	
	public static void arrayToTemplate(Integer[][] arr){
		for(int i = 0; i < arr.length; i++){
			ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(arr[i]));
			template[i] = al;
		}
		//System.out.println(Arrays.deepToString(template));
	}
	
	public String toString(){
		return numDoubleGirlGroups + "   " + seating.size() + "   " + seating.toString();
	}

	public int getNextStudentNum() {
		return nextStudentNum;
	}

	public void setNextStudentNum(int nextStudentNum) {
		this.nextStudentNum = nextStudentNum;
	}
	
	public void incrementStudentNum(){
		nextStudentNum++;
	}

	public ArrayList<Integer> getSeatOrder() {
		return seatOrder;
	}

	public void setSeatOrder(ArrayList<Integer> seatOrder) {
		this.seatOrder = seatOrder;
	}

	public ArrayList<Integer> getSeatsLeft() {
		return seatsLeft;
	}

	public void setSeatsLeft(ArrayList<Integer> seatsLeft) {
		this.seatsLeft = seatsLeft;
	}

	public int getNumSingleGirlGroups() {
		return numSingleGirlGroups;
	}

	public void setNumSingleGirlGroups(int numSingleGirlGroups) {
		this.numSingleGirlGroups = numSingleGirlGroups;
	}
	
	public void incrementSingleGirlGroups(){
		this.numSingleGirlGroups++;
	}
	public void decrementSingleGirlGroups(){
		this.numSingleGirlGroups--;
	}

	public int getNumDoubleGirlGroups() {
		return numDoubleGirlGroups;
	}

	public void setNumDoubleGirlGroups(int numDoubleGirlGroups) {
		this.numDoubleGirlGroups = numDoubleGirlGroups;
	}
	
	public void incrementNumDoubleGirlGroups(){
		this.numDoubleGirlGroups++;
	}
	
	

}
