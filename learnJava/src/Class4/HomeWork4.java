package Class4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
	public static void main(String[] args) {

//		System.out.println("------------------");
//		System.out.println("Q4_1:由大到小排序");
//		Q4_1 Q4_home = new Q4_1();
//		Q4_home.SortBigtoSmall();
//		System.out.println();
//		System.out.println("Q4_1:由小到大排序");
//		Q4_home.SortSmalltoBig();

//		System.out.println("------------------");
//		System.out.println("Q4_2:輸入兩個數字做運算");
//		Q4_2 Q4_home1 = new Q4_2();
//		Q4_home1.Operation();

//		System.out.println("------------------");
//		System.out.println("Q4_3:印出 2007~2022 的年月日");
//		Q4_3 Q4_home2 = new Q4_3();
//		Q4_home2.isnoremainder();

		System.out.println("------------------");
		System.out.println("Q4_4:猜數字");
		Q4_4 Q4_home3 = new Q4_4();
		Q4_home3.guessnumber(100);
	}
}

/**
 * <pre>
 * 有一個整數陣列，請幫我完成由大到小排序與小到大排序
 * { 100 , 10 , 7 , 78 , 87 , 45 , 32 , 11 , 10}
 * </pre>
 */
class Q4_1 {

	int arraynum[] = { 100, 10, 7, 78, 87, 45, 32, 11, 10 };

	// 由大到小排列
	public void SortBigtoSmall() {

		for (int i = 0; i < arraynum.length - 1; i++) {
			for (int j = i + 1; j < arraynum.length; j++) {
				if (arraynum[i] < arraynum[j]) {
					int a = arraynum[i];
					arraynum[i] = arraynum[j];
					arraynum[j] = a;
				}
			}
		}

		for (int icnt = 0; icnt < arraynum.length; icnt++) {
			System.out.print(arraynum[icnt] + ",");
		}
	}

	// 由小到大排列
	public void SortSmalltoBig() {

		for (int i = 0; i < arraynum.length - 1; i++) {
			for (int j = i + 1; j < arraynum.length; j++) {
				if (arraynum[i] > arraynum[j]) {
					int a = arraynum[i];
					arraynum[i] = arraynum[j];
					arraynum[j] = a;
				}
			}
		}

		for (int icnt = 0; icnt < arraynum.length; icnt++) {
			System.out.print(arraynum[icnt] + ",");
		}
	}
}

/**
 * <pre>
 * 讓使用者輸入兩個數字
 * 並讓使用者選擇要使用 加減乘除 的功能
 * Hint: 必須使用到system.in 與 switch case
 * </pre>
 */
class Q4_2 {

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
			System.out.println("您選了加法 , " + numOne + "+" + numTwo + " = " + (numOne + numTwo));
			break;
		case '-':
			System.out.println("您選了減法 , " + numOne + "-" + numTwo + " = " + (numOne - numTwo));
			break;
		case '*':
			System.out.println("您選了乘法 , " + numOne + "*" + numTwo + " = " + (numOne * numTwo));
			break;
		case '/':
			System.out.println("您選了除法 , " + numOne + "/" + numTwo + " = " + (numOne / numTwo));
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

/**
 * <pre>
 * 
 * 使用  array
 * 印出 2007~2022 的年月日  
 * 
 * ex :
 * 2017
 * 1月
 * 1,2,3,4,....,31
 * 2月 
 * 1,2,3,....,29
 * 
 * Hint:建議初始化陣列平年與閏年每月的天數
 * 
 * </pre>
 */
class Q4_3 {

	int[] normalYear = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	int[] leapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	String[] sMonth = { "1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月" };

	public void isnoremainder() {
		int icnt = 2022 - 2007;
		int years[] = new int[icnt];
		for (int i = 0; i < icnt; i++) {
			years[i] = 2007 + i;

			// 年份能被4整除但不能被100整除，或者年份能被400整除)，是閏年
			if (years[i] % 4 == 0 && years[i] % 100 != 0 || years[i] % 400 == 0) {
				printleapyear(years[i]);
			} else {
				printnormalyear(years[i]);
			}
		}
	}

	public void printleapyear(int year) {

		System.out.println(year + "年");
		for (int month = 0; month < sMonth.length; month++) {
			System.out.println((month + 1) + "月");
			for (int day = 1; day <= leapYear[month]; day++) {
				System.out.print(day + ",");

			}
			System.out.println();
		}
		System.out.println();

	}

	public void printnormalyear(int year) {

		System.out.println(year + "年");
		for (int month = 0; month < sMonth.length; month++) {
			System.out.println((month + 1) + "月");
			for (int day = 1; day <= normalYear[month]; day++) {
				System.out.print(day + ",");

			}
			System.out.println();
		}
		System.out.println();

	}

}

/**
 * <pre>
 * 這是一個小遊戲請使用者猜測1~100
 * 請使用者每次輸入100內的數字
 * 每次輸入完，需要印出輸入過的數字
 * 以及這個數字的在某個區間範圍內
 * 直到使用者猜到那個數字，程式停止
 * Hint : 使用While迴圈，並使用break機制中斷
 * </pre>
 */
class Q4_4 {

	public void guessnumber(int size) {
	    int answer = new Random().nextInt(size) + 1;
	    int topNumber = 1 ;
	    int endNumber = size;
	    int guessNumber = 0;
	    String guessNumberStr="";
	    int countGuessTime = 0;
	    System.out.println("終極密碼開始，請你們猜測1~"+size+"範圍內的數字，若猜中，會停止遊戲~");
	    
	    while(true){
	  
	      Scanner scanner = new Scanner(System.in);
	      
	      if(isNotNumber(scanner , topNumber ,endNumber)){
	        continue;
	      }
	      
	      
	      guessNumber = Integer.parseInt(scanner.next());
	      
	      // 判斷輸入的數字是否超過範圍，超過範圍，使用者需要重新輸入
	      if(this.isOutOfRange(guessNumber, topNumber, endNumber)){
	        continue;
	      }

	      guessNumberStr = guessNumberStr + guessNumber;
	      countGuessTime++;
	      
	      // 若猜中終極密碼結束
	      if(isEqualAnswer(guessNumber, answer, countGuessTime, guessNumberStr)){
	        break;
	      }
	      
	      // 沒有結束，繼續串聯下去
	      guessNumberStr = guessNumberStr + ",";
	            
	      // 根據數字，設定範圍數字
	      if(guessNumber > answer){
	        // answer = 30
	        // guess  = 40
	        // range  = 1~ 40
	        endNumber = guessNumber;
	      } else {
	        // answer = 30
	        // guess  = 10
	        // range  = 10 ~ 100
	        topNumber = guessNumber;
	      }
	      
	      this.printInfo(guessNumberStr, countGuessTime, topNumber, endNumber);
	    }
	        
	  }// end guessNumber
	  

	  // 判斷輸入是不是輸字
	  private boolean isNotNumber(Scanner scanner , int topNumber , int endNumber){
	    System.out.print("請輸入猜測的數字:");
	    if(!scanner.hasNextInt()){
	      System.out.println("請輸入這範圍內數字!! " + topNumber + "~" + endNumber);
	      System.out.println("----------------------");
	      return true;
	    }
	    return false;
	  }
	  
	  // 判斷是否超過範圍
	  private boolean isOutOfRange(int guessNumber , int topNumber , int endNumber){
	    if(guessNumber < topNumber || guessNumber > endNumber){
	      System.out.println("你輸入超過範圍的數字，請輸入這個範圍內的數字，" + topNumber + "~" + endNumber);
	      System.out.println("----------------------");
	      return true;
	    }
	    return false;
	  }
	   
	  // 猜中密碼
	  private boolean isEqualAnswer(int guessNumber , int answer  , int countGuessTime , String guessNumberStr){
	    if(guessNumber == answer){
	      System.out.println("我們在第 " + countGuessTime + " 次，猜中終極密碼 : " + answer);
	      System.out.println("總共猜測了這些數字 = " + guessNumberStr);
	      return true;
	    }
	    return false;
	  }
	    
	  // 印出尚未答到答案資訊
	  private void printInfo(String guessNumberStr , int countGuessTime , int topNumber , int endNumber){
	    System.out.println("已猜測數字 = " + guessNumberStr);
	    System.out.println("目前我們猜了 " +countGuessTime+ " 次");
	    System.out.println("沒有猜中，數字範圍在 " + topNumber + "~" + endNumber);
	    System.out.println("----------------------");
	  }

	
}
