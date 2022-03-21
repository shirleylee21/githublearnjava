package Class3;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class homework3 {
	public static void main(String[] args) {
		System.out.println("------------------");
		System.out.println("q3-1:印出星星");
		Q3_1 q3_home1 = new Q3_1();
		q3_home1.printstars();

		System.out.println("------------------");
		System.out.println("q3-2:for迴圈九九乘法表");
		Q3_2 q3_home2 = new Q3_2();
		q3_home2.usingFor();
		System.out.println("------------------");
		System.out.println("q3-2:While迴圈九九乘法表");
		q3_home2.usingWhile();

		System.out.println("------------------");
		System.out.println("q3-3:判斷閏年");
		Q3_3 q3_home3 = new Q3_3();
		q3_home3.isnoremainder();

		System.out.println("------------------");
		System.out.println("q3-4:計算成績");
		Q3_4 q3_home4 = new Q3_4();
		q3_home4.success();

		System.out.println("------------------");
		System.out.println("q3_5 : 洗牌");

		System.out.println("發牌");
		Q3_5 q3_home5 = new Q3_5();
		q3_home5.initDeckCards();

		System.out.println("洗牌");
		q3_home5.shuffle();
//		q3_home5.jokerqueen();
//		q3_home5.allshuffle();




	}
}

class Q3_1 {
	/** 3-1.請使用for迴圈，練習印出以下圖案 */

	public void printstars() {
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 4; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

class Q3_2 {
	/** 3-2. 請使用for迴圈與While迴圈，寫出99乘法表 */

	public void usingFor() {
		int sum[] = new int[10];
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				sum[i] = i * j;
				System.out.print(j + "*" + i + "=" + sum[i]);
				if (i < 10) {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}

	public void usingWhile() {
		int i = 1;
		int j = 1;
		while (i < 10) {
			while (j < 10) {
				System.out.print(j + "*" + i + "=" + j * i);
				if (i < 10) {
					System.out.print("   ");
				}
				j++;
			}
			i++; // => i = i + 1;
			System.out.println();
			j = 1;
		}
		System.out.println();
	}

}

class Q3_3 {
	/** 3-3. 請使用for迴圈，先用一個整數一維陣列儲存1900~2022年後，判斷那幾年是閏年? */
	public void isnoremainder() {
		int icnt = 2022 - 1901;
		int years[] = new int[icnt];
		for (int i = 0; i < icnt; i++) {
			years[i] = 1901 + i;

			// 年份能被4整除但不能被100整除，或者年份能被400整除)
			if (years[i] % 4 == 0 && years[i] % 100 != 0 || years[i] % 400 == 0) {
				System.out.print("Year:" + years[i] + " , 是閏年嗎? true");
				System.out.println();
			} else {
				System.out.print("Year:" + years[i] + " , 是閏年嗎? false");
				System.out.println();
			}
		}
	}
}

class Q3_4 {
	/**
	 * <pre>
	 * 有三個學生，期末考結束了，公佈了三科成績，請幫我算一下各科平均分數，每個人平均分數，需要精確到小數點兩位。
	 *
	 *  姓名  數學    國文   英文
	 *  小乖   95    80   77
	 *  小忍   55    87   89
	 *  小天   71    78   88
	 * </pre>
	 */
	public void success() {

		int A[] = { 95, 80, 77 };
		int B[] = { 55, 87, 89 };
		int C[] = { 71, 78, 88 };

		DecimalFormat frmt = new DecimalFormat("#.##");
		// Get only 2 decimal points

		System.out.println("學生:小乖 , 平均分數:" + frmt.format(((A[0] + A[1] + A[2]) / 3.00)));
//		System.out.println();
		System.out.println("學生:小忍 , 平均分數:" + frmt.format(((B[0] + B[1] + B[2]) / 3.00)));
//		System.out.println();
		System.out.println("學生:小天 , 平均分數:" + frmt.format(((C[0] + C[1] + C[2]) / 3.00)));
//		System.out.println();

		System.out.println(" 數學平均:" + frmt.format(((A[0] + B[0] + C[0]) / 3.00)));
//		System.out.println();
		System.out.println(" 國文平均:" + frmt.format(((A[1] + B[1] + C[1]) / 3.00)));
//		System.out.println();
		System.out.println(" 英文平均:" + frmt.format(((A[2] + B[2] + C[2]) / 3.00)));
		System.out.println();

	}
}


class Q3_5 {
	/*** 3-5.有一組52張撲克牌(不含鬼牌)，請幫我進行發牌動作，並且發給四個人(不重覆)。 */
	
   
	String[] colorArray;
	String[] numberArray;
	String[][] cards;
	String[] Allcard;
	
	
//	public void jokerqueen() {
//		//儲存每張撲克的花色、數字
//		
//		initColorArray();
//		initNumberArray();
//		Allcard = new String[52];
//		for (int index = 0; index < colorArray.length; index++) {
//			for (int tag = 0; tag < numberArray.length; tag++) {
//				Allcard[index+tag] = colorArray[index] + numberArray[tag];
//				System.out.print(Allcard[index+tag] + "\t");
//			}
//		}
//	}

//  //洗牌
//	public void allshuffle() {
//        int i, j;
//        Q3_5 tempcard = new Q3_5();         //交換過程中臨時備份用
//        Random r = new Random();                //隨機種子
//        for (i = 0; i < 52; i++) //換52次牌
//        {
//            j = r.nextInt(52);                      //隨機取牌
//            tempcard = Allcard[j];          //換牌
//            Allcard[j] = Allcard[i];
//            Allcard[i] = tempcard;
//        }
//    }
	
	
	// 花色
	public void initColorArray() {
		colorArray = new String[4];
		colorArray[0] = "梅花";
		colorArray[1] = "方塊";
		colorArray[2] = "愛心";
		colorArray[3] = "黑桃";
	}

	// 數字
	public void initNumberArray() {
		numberArray = new String[13];
		numberArray[0] = "A";
		numberArray[1] = "2";
		numberArray[2] = "3";
		numberArray[3] = "4";
		numberArray[4] = "5";
		numberArray[5] = "6";
		numberArray[6] = "7";
		numberArray[7] = "8";
		numberArray[8] = "9";
		numberArray[9] = "10";
		numberArray[10] = "J";
		numberArray[11] = "Q";
		numberArray[12] = "K";
	}


	// 練習3 : 請練習發初始二維陣列，放入52張牌
	public void initDeckCards() {
		initColorArray();
		initNumberArray();
		cards = new String[4][13];
		for (int index = 0; index < colorArray.length; index++) {
			for (int tag = 0; tag < numberArray.length; tag++) {
				cards[index][tag] = colorArray[index] + numberArray[tag];
				System.out.print(cards[index][tag] + "\t");
			}
			System.out.print("\n");
		}
		
	}


	public void shuffle() {

		for (int index = 0; index < colorArray.length; index++) {
			
			ArrayList<Integer> cardsDeck = new ArrayList<>();
			for (int i = 0; i < numberArray.length; ++i) {
				cardsDeck.add(i);
			}

			ArrayList<Integer> shuffledDeck = new ArrayList<>();
			while (cardsDeck.size() > 0) {
				int index1 = (int) (Math.random() * cardsDeck.size());
				int removedCard = cardsDeck.remove(index1);
				shuffledDeck.add(removedCard) ;

			}
//			System.out.println("Shuffled Cards" + shuffledDeck.toString());
			String s = shuffledDeck.toString().substring(1,shuffledDeck.toString().length()-3);
	        String[] strArr = s.split("\\s+");
	        
			for (int tag = 0; tag < strArr.length; tag++) {
				cards[index][tag] = colorArray[index] + strArr[tag].toString().substring(0,strArr[tag].toString().length()-1);
				System.out.print( cards[index][tag]+ "\t");
			}
			System.out.print("\n");
		}
		
		
	}

}
