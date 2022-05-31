package MidPracticeI;

public class ScoreData {

	private String student_no;
	private Integer math_score;
	private Integer english_score;
	private Integer chinese_score;
	public String getStudent_no() {
		return student_no;
	}
	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}
	public Integer getMath_score() {
		return math_score;
	}
	public void setMath_score(Integer math_score) {
		this.math_score = math_score;
	}
	public Integer getEnglish_score() {
		return english_score;
	}
	public void setEnglish_score(Integer english_score) {
		this.english_score = english_score;
	}
	public Integer getChinese_score() {
		return chinese_score;
	}
	public void setChinese_score(Integer chinese_score) {
		this.chinese_score = chinese_score;
	}
	public ScoreData(String student_no, Integer math_score, Integer english_score, Integer chinese_score) {
		super();
		this.student_no = student_no;
		this.math_score = math_score;
		this.english_score = english_score;
		this.chinese_score = chinese_score;
	}
	
	
}
