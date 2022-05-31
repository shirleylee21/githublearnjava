package MidPracticeI;

public class StudentsData {

	private String student_no;
	private String student_name;
	
	public StudentsData(String student_no, String student_name) {
		super();
		this.student_no = student_no;
		this.student_name = student_name;
	}

	public String getStudent_no() {
		return student_no;
	}
	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
}
