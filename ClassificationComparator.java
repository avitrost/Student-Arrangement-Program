package txtClientProject;

import java.util.Comparator;

public class ClassificationComparator implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		return student1.getClassification() - student2.getClassification();
	}

}
