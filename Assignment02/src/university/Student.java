package university;
	
public class Student{ //class named student
	//variables
	private String firstName;
	private String surname; 
	private int id;
	private char calculusGrade;
	private char physicsGrade;
	private char computationGrade;
	private char writingGrade;
	private char kazakhGrade;
	//constants
	private static final int CALCULUS_CREDIT_HOURS = 5;
	private static final int PHYSICS_CREDIT_HOURS = 5;
	private static final int COMPUTATION_CREDIT_HOURS = 5;
	private static final int WRITING_CREDIT_HOURS = 3;
	private static final int GERMAN_CREDIT_HOURS = 1;
	//end constants
	//end variables
	//start getters and setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public float getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getCalculusGrade() {
		return calculusGrade;
	}
	public void setCalculusGrade(char calculusGrade) {
		this.calculusGrade = calculusGrade;
	}
	public char getPhysicsGrade() {
		return physicsGrade;
	}
	public void setPhysicsGrade(char physicsGrade) {
		this.physicsGrade = physicsGrade;
	}
	public char getComputationGrade() {
		return computationGrade;
	}
	public void setComputationGrade(char computationGrade) {
		this.computationGrade = computationGrade;
	}
	public char getWritingGrade() {
		return writingGrade;
	}
	public void setWritingGrade(char writingGrade) {
		this.writingGrade = writingGrade;
	}
	public char getKazakhGrade() {
		return kazakhGrade;
	}
	public void setKazakhGrade(char kazakhGrade) {
		this.kazakhGrade = kazakhGrade;
	}
	//end getters and setters
	
	public Student(String first, String last, int sid){//constructor passing name fields 
	firstName = first;
	surname = last;
	id = sid;
	}
	
	  public int convertGrade(char gradeIn){
	        int grade=0;
	        char letterGrade = gradeIn;
	        if (letterGrade == 'A' || letterGrade == 'a'){
	            grade = 4;
	        } else
	            if (letterGrade == 'B' || letterGrade == 'b') {
	            grade = 3;
	        } else
	            if (letterGrade == 'C' || letterGrade == 'c') {
	            grade = 2;
	        } else
	            if (letterGrade == 'D' || letterGrade == 'd') {
	            grade = 1;
	        } else grade = 0;
	        return grade;
	    }
	
	public float calculateGPA(){//calculate GPA
		 float GPA;
	        float calcGrade = convertGrade(getCalculusGrade());
	        float physGrade = convertGrade(getPhysicsGrade());
	        float compGrade = convertGrade(getComputationGrade());
	        float writeGrade = convertGrade(getWritingGrade());
	        float kazakhGrade = convertGrade(getKazakhGrade());
	        GPA = ((calcGrade*CALCULUS_CREDIT_HOURS)+(physGrade*PHYSICS_CREDIT_HOURS)+(compGrade*COMPUTATION_CREDIT_HOURS)+
	                (writeGrade*WRITING_CREDIT_HOURS)+(kazakhGrade*GERMAN_CREDIT_HOURS)) / (CALCULUS_CREDIT_HOURS+
	                        PHYSICS_CREDIT_HOURS+COMPUTATION_CREDIT_HOURS+WRITING_CREDIT_HOURS+GERMAN_CREDIT_HOURS);
	        return GPA;
	}
	
	public void printResults(){ //print results method
		System.out.println("Student: " + firstName + ' ' + surname);
        System.out.println("Calculus: " + calculusGrade);
        System.out.println("Physics: "+physicsGrade);
        System.out.println("Computation: "+computationGrade);
        System.out.println("Writing: "+writingGrade);
        System.out.println("Kazakh: "+kazakhGrade);
        System.out.println("Semester GPA: "+ calculateGPA());
	}
	
	public static void main(String[] args) {//main method
		Student s1 = new Student("Albert", "Einstein", 43682934); //constructor tab creating object
		
		// setting student's grades
	       s1.setCalculusGrade('A');
           s1.setPhysicsGrade('A');
           s1.setComputationGrade('B');
           s1.setWritingGrade('C');
           s1.setKazakhGrade('F');
		
           s1.printResults();
           //method call
	}
}



