package MidPracticeI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * <pre>
 * 練習題1
 * </pre>
 */
public class MidPracticeI {
	public static void main(String[] args) {
		new mi_1().exec(10);
		System.out.println("-----------");
		new mi_2().exec(5);
		System.out.println("-----------");
		new mi_3().exec();
	}
}

/**
 * <pre>
 請使用for迴圈，練習印出以下圖案
   
   *       *
    *     *
     *   *
      * *
       *
      * *
     *   *
    *     *
   *       *
 * </pre>
 */
class mi_1 {
	public void exec(int size) {

		System.out.println("-----X形星星-----");
		for (int i = 1; i <= size; i++) { // 控制行
			for (int j = 1; j < size; j++) { // 控制"*"號
				if (i == j || j == size - 1 - i + 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(); // 換行
		}

	}
}

/**
 * <pre>
 * 1. 首先產生一組陣列，裡面擺放正整數 0~5
 * 2. 產生一個目標答案，亂數答案是 1~9 之間
 * 3. 利用第一組陣列，隨機兩個元素相加，會等於目標答案，並印出兩個陣列位置
 * </pre>
 */
class mi_2 {
	public void exec(int size) {
		int row = 0;
		int arraynum[] = { 0, 1, 2, 3, 4, 5 };
		int r = (int) ((Math.random() * 9) + 1);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < arraynum.length; j++) {
				if (r == (arraynum[i] + arraynum[j])) {
					row++;
					System.out.println("目標數: " + r + ", 第 " + row + " 組： " + arraynum[i] + ", " + arraynum[j]);
				}
			}
		}
	}
}

/**
 * <pre>
 * 學生資料
 * 學號  姓名
 * S1    小天
 * S2    小忍
 * S3    小玉
 * 
 * 成績資料
 * 學號  數學  英文  國文
 * S1     80   100    87
 * S2     99    94    78
 * S3     55    79    77
 * 
 * 請用新增學生與成績類別(Class)
 * 設定每位學生資料以及設定各科成績資料後
 * 
 * 1.請幫我用學號查詢學生各科的成績
 * 2.每位學生的平均成績
 * 3.各科的平均成績
 * 4.每科最高分數
 * 5.每科最低分數
 * </pre>
 */
class mi_3 {

	Map<Integer, StudentsData> studentMap = new LinkedHashMap<Integer, StudentsData>();
	Map<Integer, ScoreData> scoreMap = new LinkedHashMap<Integer, ScoreData>();

	int stdCount = 0;

	public void exec() {
		InitData();
		System.out.println("1.請幫我用學號查詢學生各科的成績");
		QueryScore();
		System.out.println();
		System.out.println("2.每位學生的平均成績");
		QueryAvgScore();
		System.out.println();
		System.out.println("3.各科的平均成績");
		SujectAvgScore();
		System.out.println();
		System.out.println("4.每科最高分數");
		GetHighestScore();
		System.out.println();
		System.out.println("5.每科最低分數");
		GetLowestScore();
		System.out.println();
	}

	public void InitData() {

		studentMap.put(1, new StudentsData("S1", "小天"));
		studentMap.put(2, new StudentsData("S2", "小忍"));
		studentMap.put(3, new StudentsData("S3", "小玉"));

		scoreMap.put(1, new ScoreData("S1", 80, 100, 87));
		scoreMap.put(2, new ScoreData("S2", 99, 94, 78));
		scoreMap.put(3, new ScoreData("S3", 55, 79, 77));
	}

	public void QueryScore() {

//		if (scoreMap.isEmpty()) {
		for (Integer key : scoreMap.keySet()) {
			System.out.println("學號:" + studentMap.get(key).getStudent_no() + ", " + "姓名:"
					+ studentMap.get(key).getStudent_name() + ", " + "數學:" + scoreMap.get(key).getMath_score() + ", "
					+ "英文:" + scoreMap.get(key).getEnglish_score() + ", " + "國文:"
					+ scoreMap.get(key).getChinese_score());
		}
//		}
	}

	public void QueryAvgScore() {
		for (Integer key : scoreMap.keySet()) {
			System.out.println("學號:" + studentMap.get(key).getStudent_no() + ", " + "姓名:"
					+ studentMap.get(key).getStudent_name() + ", " + "平均分數:" + (scoreMap.get(key).getMath_score()
							+ scoreMap.get(key).getEnglish_score() + scoreMap.get(key).getChinese_score()) / 3);
		}
	}

	public void SujectAvgScore() {
		int i_mathavg = 0, i_englishavg = 0, i_chineseavg = 0;

		for (Integer key : scoreMap.keySet()) {
			i_mathavg += scoreMap.get(key).getMath_score();
			i_englishavg += scoreMap.get(key).getEnglish_score();
			i_chineseavg += scoreMap.get(key).getChinese_score();
		}

		System.out.println("數學平均分數:" + (i_mathavg / 3));
		System.out.println("英文平均分數:" + (i_englishavg / 3));
		System.out.println("國文平均分數:" + (i_chineseavg / 3));
	}

	public void GetHighestScore() {
		int i_math = 0, i_english = 0, i_chinese = 0;

		for (Integer key : scoreMap.keySet()) {
			if (i_math < scoreMap.get(key).getMath_score()) {
				i_math = scoreMap.get(key).getMath_score();
			}
			if (i_english < scoreMap.get(key).getEnglish_score()) {
				i_english = scoreMap.get(key).getEnglish_score();
			}
			if (i_chinese < scoreMap.get(key).getChinese_score()) {
				i_chinese = scoreMap.get(key).getChinese_score();
			}
		}

		System.out.println("數學最高分數:" + i_math);
		System.out.println("英文最高分數:" + i_english);
		System.out.println("國文最高分數:" + i_chinese);
	}

	public void GetLowestScore() {
		int i_math = 0, i_english = 0, i_chinese = 0;

		i_math = scoreMap.get(1).getMath_score();
		i_english = scoreMap.get(1).getEnglish_score();
		i_chinese = scoreMap.get(1).getChinese_score();

		for (Integer key : scoreMap.keySet()) {
			if (i_math > scoreMap.get(key).getMath_score()) {
				i_math = scoreMap.get(key).getMath_score();
			}
			if (i_english > scoreMap.get(key).getEnglish_score()) {
				i_english = scoreMap.get(key).getEnglish_score();
			}
			if (i_chinese > scoreMap.get(key).getChinese_score()) {
				i_chinese = scoreMap.get(key).getChinese_score();
			}
		}

		System.out.println("數學最低分數:" + i_math);
		System.out.println("英文最低分數:" + i_english);
		System.out.println("國文最低分數:" + i_chinese);
	}

}
