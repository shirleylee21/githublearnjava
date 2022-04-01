package Class5;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormatSymbols;
import java.util.*;

public class HomeWork5 {

	public static void main(String[] args) {

//		System.out.println("------------------");
//		Q5_1 Q5_home = new Q5_1();
//		Q5_home.doStringPartOne();
//		System.out.println("------------------");
//		Q5_home.doStringBufferPartOne();
//		System.out.println("------------------");
//		Q5_home.doStringBuilderPartOne();
//		System.out.println("------------------");
//		Q5_home.doStringPartTwo();
//		System.out.println("------------------");
//		Q5_home.doStringBufferPartTwo();
//		System.out.println("------------------");
//		Q5_home.doStringBuilderPartTwo();

//		System.out.println("------------------");
//		Q5_2 Q5_home1 = new Q5_2();
//		Q5_home1.showDate();

		System.out.println("------------------");
		Q5_3 Q5_home2 = new Q5_3();
		System.out.println("Q5_3:列印今年日曆");
		Q5_home2.showyearmonth();
////		Q5_home2.showCalendar();
////		Q5_home2.printDays();

//		System.out.println("------------------");
//		System.out.println("Q5_4:輸入兩個數字做運算");
//		Q5_4 Q5_home3 = new Q5_4();
//		Q5_home3.Operation();

	}

}

/**
 * <pre>
 *  使用String與StringBuffer,StringBuilder
 *  
 *  第一題
 *  有一串英文敘述是
 *  I have a pen.
 *  請幫我找到pen的字串位置把pen這個字串修改成apple
 *  變成以下例句
 *  I have a apple.
 *  
 *  第二題
 *  請幫我幫我把這兩段敘述串聯在一起
 *  I have a pen.
 *  I have a apple.
 *  I have a pen , I have a apple.
 * </pre>
 */
class Q5_1 {

	String replaceStr;

	public void doStringPartOne() {
		String string = "I have a pen.";
		System.out.println("doStringPartOne");
		System.out.println("originStr = " + string);
		if (string.indexOf("pen") != -1) {
			System.out.println("replaceStr = " + string.replace("pen", "apple"));
		}
	}

	public void doStringBufferPartOne() {
		StringBuffer buffer = new StringBuffer("I have a pen.");
		System.out.println("doStringBufferPartOne");
		System.out.println("originStr = " + buffer);
		if (buffer.indexOf("pen") != -1) {
			System.out.println(
					"replaceStr = " + buffer.replace(buffer.indexOf("pen"), buffer.indexOf("pen") + 3, "apple"));
		}
	}

	public void doStringBuilderPartOne() {
		StringBuilder builder = new StringBuilder("I have a pen.");
		System.out.println("doStringBuilderPartOne");
		System.out.println("originStr = " + builder);
		if (builder.indexOf("pen") != -1) {
			System.out.println(
					"replaceStr = " + builder.replace(builder.indexOf("pen"), builder.indexOf("pen") + 3, "apple"));
		}
	}

	public void doStringPartTwo() {
		String string = "I have a pen.";
		replaceStr = "";
		System.out.println("doStringPartTwo");
		System.out.println("originStr = " + string);
		if (string.indexOf("pen") != -1) {
			replaceStr = string.replace("pen", "apple");
			System.out.println("replaceStr = " + replaceStr);
			System.out.println("concatStr  = " + string + replaceStr);
		}
	}

	public void doStringBufferPartTwo() {
		StringBuffer buffer = new StringBuffer("I have a pen.");
		replaceStr = "";
		System.out.println("doStringBufferPartTwo");
		System.out.println("originStr = " + buffer);
		if (buffer.indexOf("pen") != -1) {
			replaceStr = buffer.toString().replace("pen", "apple");
			System.out.println("replaceStr = " + replaceStr);
			System.out.println("concatStr  = " + buffer + replaceStr);
		}
	}

	public void doStringBuilderPartTwo() {
		StringBuilder builder = new StringBuilder("I have a pen.");
		replaceStr = "";
		System.out.println("doStringBuilderPartTwo");
		System.out.println("originStr = " + builder);
		if (builder.indexOf("pen") != -1) {
			replaceStr = builder.toString().replace("pen", "apple");
			System.out.println("replaceStr = " + replaceStr);
			System.out.println("concatStr  = " + builder + replaceStr);
		}
	}

}

/**
 * <pre>
 *  使用Date物件與Calendar物件
 *  計算下一個年度2022的4/1
 *  那天是禮拜幾
 *  以及離現在還有多少天
 * </pre>
 */
class Q5_2 {

	public void showDate() {

		String dateStr = "2022/04/01";

		// 準備輸出的格式，如：星期四 2009/01/01
		SimpleDateFormat today = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd");

		try {

			Date date = new Date();
			Date date2 = new Date();

			System.out.println("今日：" + today.format(date));

//			parse方法：將字符串類型（java.lang.String）解析為日期類型（java.util.Date）
//			format方法：將日期類型（Date）數據格式化為字符串（String）
			date2 = today.parse(dateStr);

			System.out.println("两个日期的差距：" + differentDays(date, date2));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * date2比date1多的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentDays(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day1 = cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if (year1 != year2) // 同一年
		{
			int timeDistance = 0;
			for (int i = year1; i < year2; i++) {
				if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) // 闰年
				{
					timeDistance += 366;
				} else // 不是闰年
				{
					timeDistance += 365;
				}
			}

			return timeDistance + (day2 - day1);
		} else // 不同年
		{
			System.out.println("判断day2 - day1 : " + (day2 - day1));
			return day2 - day1;
		}
	}

}

/**
 * <pre>
 *  使用Calendar物件
 *  實作出2022年的日曆表
 *  EX :
 *  2022 3月
 *  日 ㄧ 二  三  四  五  六
 *         	1   2   3   4
 *   5  6  7   8   9  10  11
 *   .......................
 *   .................31
 * </pre>
 */
class Q5_3 {

	/** * 列印日曆 **/
	public void showyearmonth() {

		int year = 2022;

		for (int m = 0; m <= 11; m++) {

			int month = m + 1;

			// 一週七天，定義一個計數器，列印一天加1（包括空白）如果%7等於0的話就需要換行
			int count = 0;
			System.out.println();
			System.out.println("---下面列印的是：" + year + "年" + month + "月的日曆表---");
			System.out.println();
			System.out.println("一 二 三 四 五 六 日");
			for (int i = 1; i <= getSpace(year, month); i++) {

				System.out.print("  ");
				count += 1;
			}
			for (int i = 1; i <= getDaysOfMonth(year, month); i++) {

				System.out.print(i + " ");
				count += 1;
				if (count % 7 == 0) {
					System.out.println();
				}
			}
		}

	}

	/**
	 * 判斷年份是平年還是閏年(用於判斷一年有365天或366天，並用於判斷2月有28天或29天),返回值是true(29天、366天)和flase(28天、365天)
	 **/
	public static boolean isLoopYear(int year) {

		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	/**
	 * 獲得某月的天數
	 **/
	public static int getDaysOfMonth(int year, int month) {

		int days = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			days = isLoopYear(year) ? 29 : 28;
			break;
		}
		return days;
	}

	/**
	 * 獲得自1900年至當前年、月經過的總天數 實現：1900年到year - 1 年的總天數 當年至month - 1 的總在數 兩個天數之和相加
	 **/
	public static int getTotalDays(int year, int month) {
		int daysofyear = 0;
		int daysofmonth = 0;
		for (int i = 1900; i < year; i++) {

			daysofyear += isLoopYear(i) ? 366 : 365;
		}
		for (int i = 1; i < month; i++) {

			daysofmonth += getDaysOfMonth(year, i);
		}
		return daysofyear + daysofmonth;
	}

	/**
	 * 利用總天數模7取餘，得到所需要列印的空格數
	 **/
	public static int getSpace(int year, int month) {

		int allSpace = getTotalDays(year, month) % 7;
		return allSpace;
	}

	public void showCalendar() {

		// construct d as current date
		Locale.setDefault(Locale.ENGLISH);

		GregorianCalendar d = new GregorianCalendar();

		int month = d.get(Calendar.MONTH); // 用於迴圈列印當前月份的月曆__月份判斷
		int today = d.get(Calendar.DAY_OF_MONTH); // 用於給當前日期後面加"*"

		String weekdays[] = new DateFormatSymbols().getShortWeekdays(); // 儲存7個星期名

		for (int i = 1; i < 8; ++i)
			System.out.print(weekdays[i] + " "); // 列印月曆頭部,7個星期名
		System.out.println();

		d.set(Calendar.DAY_OF_MONTH, 1); // 設定d的日期為當月1號
		int weeknameofFirstday = d.get(Calendar.DAY_OF_WEEK);// 獲得當月1號的星期名

		int cnt = 1;
		while (weekdays[cnt] != weekdays[weeknameofFirstday]) // 列印日曆第一行,判斷當月1號從第一行的哪裡開始列印
		{
			System.out.print("    ");
			++cnt;
		}

		do {
			int day = d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3s", day);
			if (day == today)
				System.out.print("*");
			else
				System.out.print(" ");

			if (weekdays[d.get(Calendar.DAY_OF_WEEK)] == weekdays[7]) // 判斷是否需要換行列印
				System.out.println();
			d.add(Calendar.DAY_OF_MONTH, 1);
		} while (d.get(Calendar.MONTH) == month);
	}

	public void printDays() {

		int num = 0;
		for (int i = 2007; i <= 2022; i++) {

			System.out.println(i);
			for (int j = 1; j <= 12; j++) {

				System.out.println(j + "月");
				switch (j) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					num = 31;
					break;
				case 2:
					num = (((i % 4) == 0 && (i % 100) != 0) || (i % 400) == 0 ? 29 : 28);
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					num = 30;
					break;
				}

				for (int k = 1; k <= num; k++) {
					System.out.print(k + (k == num ? " " : ", "));
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}

/**
 * <pre>
 *  使用BigDecimal版本
 *  讓使用者輸入兩個數字
 *  並讓使用者選擇要使用 加減乘除 的功能
 *  Hint: 必須使用到system.in 與 switch case
 * </pre>
 */
class Q5_4 {

	public void Operation() {
		double numOne = 0;
		double numTwo = 0;
		char symbol = '\0';

		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入兩個數字，並選擇要執行的加減乘除動作，會幫您進行運算");
		System.out.print("請輸入第一個數字:");
		if (scanner.hasNextInt()) {
			numOne = Double.parseDouble(scanner.next());
			System.out.printf("第一個數字: " + numOne);
		}

		System.out.print("\n請輸入第二個數字:");
		if (scanner.hasNextInt()) {
			numTwo = Double.parseDouble(scanner.next());
			System.out.printf("第二個數字: " + numTwo);
		}

		System.out.println("\n請輸入要運算的符號 +(加) , -(減) , *(乘法) , /(除)");
		System.out.print("符號:");
		symbol = scanner.next().charAt(0);
		System.out.println();
		switch (symbol) {
		case '+':
			System.out.println(
					"您選了加法 , " + numOne + "+" + numTwo + " = " + new BigDecimal(numOne).add(new BigDecimal(numTwo)));
			break;
		case '-':
			System.out.println("您選了減法 , " + numOne + "-" + numTwo + " = "
					+ new BigDecimal(numOne).subtract(new BigDecimal(numTwo)));
			break;
		case '*':
			System.out.println("您選了乘法 , " + numOne + "*" + numTwo + " = "
					+ new BigDecimal(numOne).multiply(new BigDecimal(numTwo)));
			break;
		case '/':
			System.out.println(
					"您選了除法 , " + numOne + "/" + numTwo + " = " + new BigDecimal(numOne).divide(new BigDecimal(numTwo)));
			break;
		default:
			System.out.println("輸入錯誤的符號，請重新開始\n");
			break;
		}
		System.out.println("是否要繼續執行?，若要取消請輸入N。繼續執行按下任意鍵，Enter後繼續。");
		System.out.println("請輸入:");
		if ("N".equals(scanner.next())) {
			System.out.println("運算結束，掰掰");
		}

	}

}
