package txtClientProject;

public class Student {

	private String name;
	private String school;
	private String gender;
	private String program;
	private int[] groups = new int[5];
	private char[] seats = new char[5];
	private boolean clemente;
	private boolean female;
	private boolean placeholder;
	private boolean none = false;
	private int session;
	private int numberInList;
	private int classification;
	private int seatNum;
	private int prime;
	private long product;
	private static int nextPrime = 2;
	private static int numberOfStudents = 0;

	public Student(String name, String gender, String session, String school) { // Fix to template
		this.name = name;
		this.school = school;
		this.gender = gender;
		this.session = Integer.parseInt(session.substring(0, 1));
		clemente = school.equals("Roberto W. Clemente");
		female = gender.equals("F");
		if(female){
			if(clemente){
				classification = 1;
			}
			else{
				classification = 3; // Changed temporarily
			}
		}
		else{
			if(clemente){
				classification = 2;
			}
			else{
				classification = 4;
			}
			if(placeholder){
				classification = 5;
			}
		}
		prime = nextPrime;
		numberOfStudents++;
		nextPrime = prime(numberOfStudents + 2);
		product = prime;
	}
	
	public Student(){
		none = true;
	}
	
	public Student(boolean placeholder){
		if(placeholder){
			this.placeholder = true;
			name = "placeholder";
		}
	}

	public boolean isClemente() {
		return clemente;
	}

	public boolean isFemale() {
		return female;
	}

	public int getPrime() {
		return prime;
	}

	public long getProduct() {
		return product;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public int getNumberInList() {
		return numberInList;
	}

	public void setNumberInList(int numberInList) {
		this.numberInList = numberInList;
	}

	public void multiply(Student other) {
		this.product *= other.prime;
	}

	public static int getNumberOfStudents() {
		return numberOfStudents;
	}
	
	public int getClassification() {
		return classification;
	}

	public void setClassification(int classification) {
		this.classification = classification;
	}

	public boolean isPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(boolean placeholder) {
		this.placeholder = placeholder;
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	private static boolean isPrime(int n) { // Can make better later
		boolean isPrime = true;
		for(int divisor = 2; divisor <= n / 2; divisor++) {
			if(n % divisor == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	private static int prime(int n) { // Return nth prime
		int num = 1;
		int count = 0;
		while(count != n) {
			num++;
			if(isPrime(num)) {
				count++;
			}
		}
		return num;
		
	}
	public static long gcd(long p, long q) {
		while(q != 0) {
			long temp = q;
			q = p % q;
			p = temp;
		}
		return p;
	}
	
	public boolean neverTogether(Student other) {
		 return gcd(product, other.prime) == 1;
	}
	
	public boolean togetherOnce(Student other) {
		return !neverTogether(other) && product / other.prime % other.prime != 0;
	}

	public String toString() {
		return name;
	}

	public boolean isNone() {
		return none;
	}

	public void setNone(boolean none) {
		this.none = none;
	}

	public int[] getGroups() {
		return groups;
	}

	public void setGroups(int[] groups) {
		this.groups = groups;
	}

	public char[] getSeats() {
		return seats;
	}

	public void setSeats(char[] seats) {
		this.seats = seats;
	}
	
	/*public static void main(String[] args) {
		System.out.println(gcd(9,27));
		System.out.println(gcd(18,12));
		System.out.println(gcd(6577,6576));
		System.out.println(gcd(11,121));
		System.out.println(gcd(121,11));
	}*/

}
