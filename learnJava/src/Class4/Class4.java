package Class4;

import java.util.Random;
import java.util.Scanner;

public class Class4 {
	public static void main(String[] args) {
		new MySwapNum().swapNumber(100, 10);
		System.out.println("--------------");
		int headNum = 100;
		int footNum = 10;
		new MySwapNum().swapNumber(headNum, footNum);
		System.out.println("origin headNum : " + headNum + " , footNum : " + footNum);

		System.out.println("--------------");
		new MyOtherIfElse().isremainder(2020);

		System.out.println("--------------");
		new MySystemIn().input();
		new MySystemIn().whileInput();

		new MySwtichCase().MyNumberSwtichCase(1);
		new MySwtichCase().MyStringSwitchCase("Tom");

	}
}

// 交換
class MySwapNum {
	public void swapNumber(int headNum, int footNum) {
		System.out.println("交換前 : " + headNum + " , " + footNum);
		int temp = headNum; // <--有個空間去存放接下來要放的內容
		headNum = footNum;
		footNum = temp;
		System.out.println("交換後 : " + headNum + " , " + footNum);
	}
}

// 三元運算
class MyOtherIfElse {

	// 條件 ? 條件為真 : 條件為假;
	public void isDivide2(int num) {
		System.out.println("num = " + num + "是否可被2整除" + (num % 2 == 0 ? true : false));
	}

	public void isTom(String str) {
		System.out.println("Name is " + str + ". is Tom ? " + ("Tom".equals(str) ? true : false));
	}

	// 練習，傳入一個數字，回傳是否可以被 2 3 5整除，請使用三元運算
	public void isDivide235(int num) {
		System.out.println(
				"num = " + num + " , 是否被 2,3,5 整除？" + ((num % 2 == 0 || num % 3 != 0 || num % 5 == 0) ? true : false));
	}

	// 閏年
	public void isremainder(int year) {
		System.out.println(
				"Year: " + year + " 是否為閏年? " + ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? true : false));
	}
}

/**
 * <pre>
 * 如果想讓使用者輸入一些文字
 * 我們可以用內建System.in
 * 搭配內建Scanner
 * 來讀取使用者輸入的內容
 * 來根據輸入的內容
 * 做相對對應的處理
 * </pre>
 */
class MySystemIn {
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input your name: ");
		System.out.printf("Hello! %s!", scanner.next());
	}

	// 練習 請使用While無窮迴圈，讓使用者持續輸入文字，直到輸入0，結束程式
	public void whileInput() {
		Scanner scanner = new Scanner(System.in);
		// 當作一個flag，如果輸入到0的時候，flag會被觸發
		// 當迴圈回到判斷時，因為flag變成flag，便會停止無窮迴圈
		boolean flag = true;
		while (flag) {
			System.out.print("Please input your number: ");
			String s = scanner.next();
			System.out.printf("Hello! %s \n!", s);
			if ("0".equals(s)) {
				flag = false;
			}
		}
	}
}


/**
 * <pre>
 * Switch Case類似於if else
 * 可以接收數字，字元，字串，列舉，進行案例(CASE)處理 
 * 我們可以設計每一種情況CASE案例發生時
 * 處理想要執行的敘述
 * 若執行完畢
 * 最後記得一定要使用break中斷整個switch的案例處理
 * 就不在再往下判斷下去
 * 若案例都沒有成立時
 * 我們可以寫default預設值，代表預設值要處理什麼
 * </pre>
 */
class MySwtichCase {
	public void MyNumberSwtichCase(int num) {
		switch (num) {
		case 0:
			System.out.println("Hello world");
			break;
		default:
			System.out.println("WTF??");
			break;
		}
	}

	public void MyStringSwitchCase(String str) {
		switch (str) {
		case "Tom":
			System.out.println("WelCome Back Admin , " + str);
			break;
		default:
			System.out.println("Hi , " + str);
			break;
		}
	}
}


/**
 * <pre>
 * Random是Java物件，內建亂數產生器
 * Random.nextInt 意旨產生範圍0~?的正整數
 * 若是要從1開始，記得要加1
 * Integer是一個Java內建物件，他直接執行使用的方法
 * 內建Integer.toString，代表把字串轉換成整數
 * </pre>
 */
class MyRandom {
	public void random(int size) {
		Random ran = new Random();
		String str = "";
		for (int i = 1; i < size; i++) {
			str += Integer.toString(ran.nextInt(size) + 1);
			if (i < size - 1) {
				str += ",";
			}
		}
		System.out.println(str);
	}
}


/**
 * <pre>
 * continue適用在迴圈內
 * 當迴圈看到continue時
 * 會自動中斷以下要執行的內容，重新回到迴圈的判斷式，繼續執行下去
 * break適用在迴圈或者判斷式內
 * 當我們使用到break時
 * 代表要中斷整個迴圈或者判斷式內的執行
 * 直接結束掉，不會再執行下去
 * </pre>
 */
class MyBreakContinue {
	public void test1() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				continue;
			}
			if (i % 7 == 0) {
				break;
			}
			System.out.println(" i = " + i);
		}
	}
}
