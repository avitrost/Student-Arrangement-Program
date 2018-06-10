package txtClientProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Algorithm {
	
	public static ArrayList<Student> students; // ordered
	private static int totalNumInSession;
	private static int totalNumRoundedUp;
	private static int numStudents;
	private static boolean finished = false;
	private static long startTime;
	private static boolean girlsMode;
	private static PartialCandidate bestCandidate = null;
	private static int bestCandidateNumPairs = -1;
		
	
	
	public static void backtrack(PartialCandidate c){
		if(reject(c)){
			//System.out.println(c);
			return;
		}
		//System.out.println(c.getSeating());
		//System.out.println(c);
		//System.out.println(c.getNextStudentNum());
		if(c.getNextStudentNum() == numStudents - 1){// || c.getSeatsLeft().size() == 0){ // Accept(c)
			finished = true;
			bestCandidate = c;
			//System.out.println(c);             // Temporary Output(c)
		}else if(girlsMode){
			int numPairs = c.getNumDoubleGirlGroups();
			if(numPairs > bestCandidateNumPairs){
				bestCandidate = c;
				bestCandidateNumPairs = numPairs;
			}
			if(System.nanoTime() - startTime >= 100000000){ // .1 seconds
				finished = true;
			}
		}
		if(finished){
			return;
		}
		PartialCandidate s = first(c);
		//System.out.println(s.getSeating());
		backtrack(s);
		ArrayList<Integer> seatsLeft = new ArrayList<Integer>(s.getSeatsLeft()); // changed form s to c
		Iterator<Integer> i = seatsLeft.iterator();
		while(i.hasNext() && !finished){
			Integer seat = i.next();
			//System.out.println(student);
			s = next(s, seat);
			backtrack(s);
		}
		//System.out.println("Could not find a solution");
	}
	
	public static PartialCandidate first(PartialCandidate c){
		PartialCandidate s = new PartialCandidate(c);
		s.incrementStudentNum();
		int i = 0;
		while(i < totalNumInSession){
			if(!s.getSeatOrder().contains(i)){
				s.getSeating().set(i, students.get(s.getNextStudentNum()));
				break;
			}
			
			
			i++;
		}
		s.getSeatOrder().add(i);
		s.getSeatsLeft().remove(Integer.valueOf(i));
		return s;
	}
	
	public static PartialCandidate next(PartialCandidate c, Integer seat){
		PartialCandidate s = new PartialCandidate(c);
		int seatNum = seat.intValue();
		int index = s.getSeating().indexOf(students.get(s.getNextStudentNum()));
		s.getSeating().set(index, new Student());
		s.getSeating().set(seatNum, students.get(s.getNextStudentNum()));
		ArrayList<Integer> seatOrder = s.getSeatOrder();
		s.getSeatsLeft().add(index);
		s.getSeatsLeft().remove(Integer.valueOf(seatNum));
		seatOrder.set(seatOrder.size() - 1, seat);
		return s;
	}
	
	/*
	public static PartialCandidate first(PartialCandidate c){
		PartialCandidate s = new PartialCandidate(c);
		Iterator<Student> i = students.iterator();
		while(i.hasNext()){
			Student student = i.next();
			ArrayList<Student> seating = s.getSeating();
			if(!seating.contains(student)){
				//System.out.println(seating + "   " + student);
				seating.add(student);
				break;
			}else{
				//System.out.println(seating + "   " + student);
			}
		}
		return s;
	}
	
	public static PartialCandidate next(PartialCandidate c, Student student){
		PartialCandidate s = new PartialCandidate(c);
		ArrayList<Student> seating = s.getSeating();
		seating.set(seating.size() - 1, student);
		return s;
	}*/
	
	/*
	public static PartialCandidate first(PartialCandidate c){
		PartialCandidate s = new PartialCandidate(c);
		//s.setPreviousStudents(new ArrayList<Student>(c.getCurrentStudents()));
		s.setPreviousStudents(c.getCurrentStudents());
		s.setCurrentStudents(new ArrayList<Student>(c.getCurrentStudents()));
		//s.setPreviousSeating(new ArrayList<Student>(c.getCurrentSeating()));
		s.setPreviousSeating(c.getCurrentSeating());
		s.setCurrentSeating(new ArrayList<Student>(c.getCurrentSeating()));
		s.setLastStudentIndexSelected(0);
		s.getCurrentSeating().add(s.getCurrentStudents().remove(0));
		return s;
		
	}
	
	public static PartialCandidate next(PartialCandidate c){
		PartialCandidate s = new PartialCandidate(c);
		s.setPreviousStudents(new ArrayList<Student>(c.getPreviousStudents()));
		s.setCurrentStudents(new ArrayList<Student>(c.getPreviousStudents()));
		s.setPreviousSeating(new ArrayList<Student>(c.getPreviousSeating()));
		s.setCurrentSeating(new ArrayList<Student>(c.getPreviousSeating()));
		s.setLastStudentIndexSelected(s.getLastStudentIndexSelected() + 1);
		try{
			s.getCurrentStudents().remove(s.getLastStudentIndexSelected());
			return s;
		}catch(IndexOutOfBoundsException e){
			return null;
		}
	}*/
	
	public static boolean reject(PartialCandidate c){
		int index = c.getNextStudentNum();
		if(index == -1){
			return false;
		}
		Student newStudent = students.get(c.getNextStudentNum());
		if(newStudent.toString().trim().equals("Song, Justin Y.") && !girlsMode){
			//System.out.println("test");
		}
		//System.out.println(newStudent);
		Student[][] groups = c.getGroups(newStudent);
		//System.out.println(Arrays.deepToString(groups));
		for(Student[] group : groups){
			//System.out.println(Arrays.deepToString(groups));
			int girls = 0;
			int clemente = 0;
			int people = 0;
			int placeholders = 0;
			for(Student student : group){
				//System.out.println(Arrays.deepToString(group));
				if(student != null && student.isNone() == false){
					people++;
					if(student.isClemente()){
						clemente++;
					}
					if(student.isFemale()){
						girls++;
					}
					if(student.isPlaceholder()){
						placeholders++;
					}
				}
			}
			//System.out.println(people + "  " + girls + "  " + clemente);
			if(clemente > 3){ // FIX LATER
				//System.out.println(Arrays.toString(group));
				//System.out.println("true");
				return true;
			}
			if(placeholders > 1){
				return true;
			}
			if(girlsMode){
				if(girls == 1){
					c.incrementSingleGirlGroups();
					if(c.getNumSingleGirlGroups() > numStudents - c.getSeatOrder().size()){
						return true;
					}
				}
				if(girls == 2){
					c.decrementSingleGirlGroups();
					c.incrementNumDoubleGirlGroups();
				}
				if(girls >= 3){
					if(c.isThreeGirlsOptionAvailable()){
						c.setThreeGirlsOptionAvailable(false);
					}
					else{
						return true;
					}
				}
			}
		}
		return false;
		
	}
	
	public static void sortStudents(){
		students.sort((Student s1, Student s2) -> s1.getClassification() - s2.getClassification()); // Lambda, basically a comparator
	}

	public static ArrayList<Student> getStudents() {
		return students;
	}

	public static void setStudents(ArrayList<Student> students) {
		Algorithm.students = students;
	}

	public static PartialCandidate generateSeating(ArrayList<Student> studentList, PartialCandidate c, int totalSize) {
		students = studentList;
		numStudents = students.size();
		sortStudents();
		//System.out.println(students);
		
		startTime = System.nanoTime();
		//System.out.println("Starting at " + startTime);
		if(!girlsMode){
			finished = false;
			PartialCandidate root = c;
			root.setNextStudentNum(-1);
			backtrack(root);
			//System.out.println(bestCandidate);
		}
		
		//System.out.println(finished);
		if(girlsMode){
			PartialCandidate root = new PartialCandidate(students, totalNumInSession); //
			backtrack(root);
			//System.out.println(bestCandidate);
			//System.out.println(bestCandidateNumPairs);
			girlsMode = false;
		}
		long endTime = System.nanoTime();
		//System.out.println("finished at " + endTime + ", algorithm took " + (endTime - startTime));
		return bestCandidate;
		
		
	}

	public static int getTotalNumInSession() {
		return totalNumInSession;
	}

	public static void setTotalNumInSession(int totalNumInSession) {
		Algorithm.totalNumInSession = totalNumInSession;
	}

	public static boolean isGirlsMode() {
		return girlsMode;
	}

	public static void setGirlsMode(boolean girlsMode) {
		Algorithm.girlsMode = girlsMode;
	}

	public static int getTotalNumRoundedUp() {
		return totalNumRoundedUp;
	}

	public static void setTotalNumRoundedUp(int totalNumRoundedUp) {
		Algorithm.totalNumRoundedUp = totalNumRoundedUp;
	}

	
	
	
	
	/*public static PartialCandidate first(PartialCandidate candidate){
		PartialCandidate s = new PartialCandidate(candidate);
		int group_1 = s.getCurrentSeatNum() / s.getGroups()[0].length;  // Usage: groups[group_1][group_2]
		int group_2 = s.getCurrentSeatNum() % s.getGroups()[0].length;
		s.setCurrentStudentNumInList(candidate.getCurrentStudentNumInList());
		s.groups[group_1][group_2] = s.students.get(s.getCurrentStudentNumInList());
		return s;
		
	}
	
	public static PartialCandidate next(PartialCandidate candidate){
		PartialCandidate s = new PartialCandidate(candidate);
		int group_1 = s.getCurrentSeatNum() / s.getGroups()[0].length;  // Usage: groups[group_1][group_2]
		int group_2 = s.getCurrentSeatNum() % s.getGroups()[0].length;
		s.setCurrentStudentNumInList(s.getCurrentStudentNumInList() + 1);
		s.groups[group_1][group_2] = s.students.remove(s.getCurrentStudentNumInList());
		return s;
	}*/

}
