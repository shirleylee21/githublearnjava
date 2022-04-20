package Class6;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

public class HomeWork6 {

	public static void main(String[] args) {

//		new Q6_1().doTreeMap();
//		System.out.println("------------------");
//		new Q6_2().doArrayList();
//		System.out.println("------------------");
//
		new Q6_3().TenGroupLotto();
//		ArrayList lotto = new Q6_3().lottonumber();
//		System.out.println(lotto);
		System.out.println("------------------");

//		new Q6_4().doTreeMap();
//		System.out.println("------------------");

//		new Q6_5().doTreeList();
//		System.out.println("------------------");

	}

}

/**
 * <pre>
 *
 * 請使用Map物件，處理以下問題
 *
 * 會員資料
 * 編號  姓名
 * C1	藍色
 * C2	香菇
 * C3	小草
 *
 * 1.會員編號C1的姓名更改成紅色，並印出前後修改的內容
 * 2.會員編號C2已被停止使用，新增一個新的會員資料
 *   編號:C4 ,  姓名: 天天，並印出整體會員資料
 *
 * </pre>
 */
class Q6_1 {

	Map<String, String> myMap = new HashMap<String, String>();

	public void initdata() {
		myMap.put("C1", "藍色");
		myMap.put("C2", "香菇");
		myMap.put("C3", "小草");
	}

	public void doTreeMap() {

		System.out.println("------會員資料------");
		initdata();
		System.out.println("------修改前：------");
		for (String key : myMap.keySet()) {
			System.out.println(key + " = " + myMap.get(key));
		}
//		System.out.println("------修改後：------");
//
//		myMap.remove("C2");
//		myMap.put("C4", "天天");
//		for (String key : myMap.keySet()) {
//			if (key.equals("C1")) {
//				myMap.put(key, "紅色");
//			}
//			System.out.println(key + " = " + myMap.get(key));
//		}
	}

}

/**
 * <pre>
 * 請使用List物件，處理以下問題
 *
 * 會員資料
 * 編號  姓名
 * C1	藍色
 * C2	香菇
 * C3	小草
 *
 * 1.會員編號C1的姓名更改成紅色，並印出前後修改的內容
 * 2.會員編號C2已被停止使用，新增一個新的會員資料
 *   編號:C4 ,  姓名: 天天，並印出整體會員資料
 * 
 * </pre>
 */
class Q6_2 {

	ArrayList<String> listID = new ArrayList<String>();
	ArrayList<String> listNAME = new ArrayList<String>();

	public void initdata() {
		listID.add("C1");
		listID.add("C2");
		listID.add("C3");

		listNAME.add("藍色");
		listNAME.add("香菇");
		listNAME.add("小草");
	}

	public void removeTag(int index) {
		listID.remove(index);
		listNAME.remove(index);
	}

	public void doArrayList() {
		System.out.println("------會員資料------");
		initdata();
		System.out.println("------修改前：------");
		for (int index = 0; index < listID.size(); index++) {
			System.out.println(listID.get(index) + " = " + listNAME.get(index));
		}
		System.out.println("------修改後：------");

//		listNAME.set(listID.indexOf("C1"), "紅色");

		for (int index = 0; index < listID.size(); index++) {
			if (listID.get(index) == "C1") {
				listNAME.set(index, "紅色");// 覆蓋
			}
			if (listID.get(index) == "C2") {
				removeTag(index);
				listID.add("C4");
				listNAME.add("天天");
			}
		}

		for (int index = 0; index < listID.size(); index++) {
			System.out.println(listID.get(index) + " = " + listNAME.get(index));
		}

	}
}

/**
 * <pre>
 * 使用Set物件與Random物件搭配
 * 產生10組大樂透號碼
 * </pre>
 */
class Q6_3 {

	public void TenGroupLotto() {

		ArrayList tengroup = new ArrayList();

		for (int i = 0; i < 10; i++) {
			tengroup.add(i, lottonumber());
		}
		for (Object obj : tengroup) {
			System.out.println(obj);
		}
	}

	public void Lotto() {
		ArrayList lotto = lottonumber();
		System.out.println(lotto);

	}

	private static ArrayList numberlist;
	private static ArrayList lottolist;
	private static int i;
	private static int j;

	// 產生一組樂透號碼
	public static ArrayList lottonumber() {
		initlottodata();
		getlottonumber();
		for (int j = 1; j <= 6; j++) {
			getrandomnumber();
			putrandomnumber();
			putlottonumber();
		}
		return lottolist;
	}

	// 建立數字與樂透陣列
	private static void initlottodata() {
		numberlist = new ArrayList();
		lottolist = new ArrayList();
	}

	// 將42個號碼放進數字陣列
	private static void getlottonumber() {
		for (int i = 1; i <= 42; i++) {
			numberlist.add(i);
		}
	}

	// 用亂數產生一個陣列索引
	private static void getrandomnumber() {
		i = (int) (Math.random() * numberlist.size());
	}

	// 根據索引從陣列取出號碼
	private static void putrandomnumber() {
		Object obj = numberlist.remove(i);
		j = (int) obj;
	}

	// 將抽出的號碼放進樂透陣列
	private static void putlottonumber() {
		lottolist.add(j);
	}

}

/**
 * <pre>
 *
 * 以下請使用Map物件儲存以下資訊
 * 並解決四個問題
 *
 * 會員資料
 * 編號  姓名
 * C1	小Q
 * C2	小咪
 * C3	查理
 *
 * 訂單資料
 * 訂單 會員編號  訂購內容 	金額
 * O001 	C1  	衣服    	789
 * O002 	C1    	3C	           1999
 * O003 	C2  	遊戲   	           1899
 * O004 	C2	保養品   	3300
 * O005 	C3	攝影機  	14999
 *
 * 請用新增會員與訂單類別(Class)
 * 設定每位會員資料以及訂單資料後
 *
 * 1.用會員編號查詢會員買的商品
 *   輸出格式 => 編號 姓名 訂單 訂購內容 金額
 *   
 * 2.算出每位會員的平均每筆消費金額
 *   輸出格式 => 編號 姓名 平均消費金額
 *   
 * 3.依照消費總金額高到低排序
 *   輸出格式 => 編號 姓名 消費總金額
 *   
 * 4.依照消費總金額低到高排序
 *   輸出格式 => 編號 姓名 消費總金額
 * 
 * </pre>
 */
class Q6_4 {

	Map<String, String> MemberDataMap = new TreeMap<String, String>(); // 會員資料
	Map<String, String> OrderMemberMap = new TreeMap<String, String>();// 訂單會員資料
	Map<String, String> OrderProdMap = new TreeMap<String, String>();// 訂單訂購內容資料
	Map<String, Integer> OrderAmountMap = new HashMap<String, Integer>();// 訂單訂購金額資料
	Map<String, Integer> CustordamtMap = new HashMap<String, Integer>();// 客戶訂單金額資料
	Map<String, Integer> CustorderCntMap = new TreeMap<String, Integer>();// 客戶訂單數

	public void doTreeMap() {
		initdata();
		System.out.println("1.用會員編號查詢會員買的商品");
		getCustOrderlist();
		System.out.println();
		System.out.println("2.算出每位會員的平均每筆消費金額");
		getAvgCustOrderAmt();
		System.out.println();
		System.out.println("3.依照消費總金額高到低排序");
//		setSortDesc();
		printHighCostOrder();
		System.out.println();
		System.out.println("4.依照消費總金額低到高排序");
//		setSort();
		printLowCostOrder();
		System.out.println();
	}

	public void initdata() {
		initmemberMap(MemberDataMap);
		initordmemberMap(OrderMemberMap);
		initordprodMap(OrderProdMap);
		initordamountMap(OrderAmountMap);
	}

	public void initmemberMap(Map<String, String> MemberDataMap) {
		MemberDataMap.put("C1", "小Q");
		MemberDataMap.put("C2", "小咪");
		MemberDataMap.put("C3", "查理");
	}

	public void initordmemberMap(Map<String, String> OrderMemberMap) {
		OrderMemberMap.put("O001", "C1");
		OrderMemberMap.put("O002", "C1");
		OrderMemberMap.put("O003", "C2");
		OrderMemberMap.put("O004", "C2");
		OrderMemberMap.put("O005", "C3");
	}

	public void initordprodMap(Map<String, String> OrderProdMap) {
		OrderProdMap.put("O001", "衣服");
		OrderProdMap.put("O002", "3C");
		OrderProdMap.put("O003", "遊戲");
		OrderProdMap.put("O004", "保養品");
		OrderProdMap.put("O005", "攝影機");
	}

	public void initordamountMap(Map<String, Integer> OrderAmountMap) {
		OrderAmountMap.put("O001", 789);
		OrderAmountMap.put("O002", 1999);
		OrderAmountMap.put("O003", 1899);
		OrderAmountMap.put("O004", 3300);
		OrderAmountMap.put("O005", 14999);
	}

	public void initorderinfoMap(Map<String, OrderInfo> OrderInfosMap) {
		OrderInfosMap.put("O001", new OrderInfo("O001", "C1", "衣服", 789));
		OrderInfosMap.put("O002", new OrderInfo("O002", "C1", "3C", 1999));
		OrderInfosMap.put("O003", new OrderInfo("O003", "C2", "遊戲", 1899));
		OrderInfosMap.put("O004", new OrderInfo("O004", "C2", "保養品", 3300));
		OrderInfosMap.put("O005", new OrderInfo("O005", "C3", "攝影機", 14999));

	}

	// 1.用會員編號查詢會員買的商品,輸出格式 => 編號 姓名 訂單 訂購內容 金額
	// C1,小Q,O001,衣服,789
	public void getCustOrderlist() {
		String ls_custNo = "";
		String ls_text = "";
		for (int index = 0; index < OrderMemberMap.size(); index++) {
			ls_custNo = getCustNameMap(OrderMemberMap.get("O00" + String.valueOf(index + 1)));
			ls_text = "編號:" + OrderMemberMap.get("O00" + String.valueOf(index + 1)) + ",姓名:" + ls_custNo + ",訂單:"
					+ "O00" + String.valueOf(index + 1) + ",訂單內容:" + OrderProdMap.get("O00" + String.valueOf(index + 1))
					+ ",金額:" + OrderAmountMap.get("O00" + String.valueOf(index + 1));
			System.out.println(ls_text);
		}
//		for (String key : MemberDataMap.keySet()) {
//			System.out.println(key + " = " + MemberDataMap.get(key));
//		}
//		System.out.println(MemberDataMap.get("C1"));

	}

	public String getCustNameMap(String custNo) {
		return MemberDataMap.get(custNo);
	}

	// 2.算出每位會員的平均每筆消費金額,輸出格式 => 編號 姓名 平均消費金額
	public void getAvgCustOrderAmt() {
//		for (int index = 1; index <= OrderAmountMap.size(); index++) {
//			if (!(CustordamtMap.get(OrderMemberMap.get("O00" + String.valueOf(index))) == null)) {
//				CustordamtMap.put(OrderMemberMap.get("O00" + String.valueOf(index)),
//						(OrderAmountMap.get("O00" + String.valueOf(index))
//								+ CustordamtMap.get(OrderMemberMap.get("O00" + String.valueOf(index)))));
//				CustorderCntMap.put(OrderMemberMap.get("O00" + String.valueOf(index)),
//						CustorderCntMap.get(OrderMemberMap.get("O00" + String.valueOf(index))) + 1);
//				continue;
//			}
//			CustordamtMap.put(OrderMemberMap.get("O00" + String.valueOf(index)),
//					OrderAmountMap.get("O00" + String.valueOf(index)));
//			CustorderCntMap.put(OrderMemberMap.get("O00" + String.valueOf(index)), 1);
//
//		}
//
//		for (String key : CustordamtMap.keySet()) {
//			System.out.println("編號:" + key + " , 姓名: " + getCustNameMap(key) + ", 平均消費金額: "
//					+ (CustordamtMap.get(key) / CustorderCntMap.get(key)));
//		}

		System.out.println("printAvgCost");
		for (String no : MemberDataMap.keySet()) {
			System.out.print("編號:" + no + " , 姓名:" + MemberDataMap.get(no));
			float totalAmout = 0;
			float count = 0;
			for (String key : OrderMemberMap.keySet()) {
				if (no.equals(OrderMemberMap.get(key))) {
					count++;
					totalAmout = totalAmout + OrderAmountMap.get(key);
				}
			}
			float avgAmount = totalAmout / count;
			System.out.printf(" , 平均消費金額 : %.2f \n", avgAmount);
		}
		System.out.println("---------------");

	}

	public void setSortDesc() {
		LinkedHashMap<String, Integer> custSortCostMap = new LinkedHashMap<String, Integer>();
		Map<String, Integer> custSumCostCloneMap = new TreeMap<String, Integer>(CustordamtMap);
		String temp;
		for (String key1 : custSumCostCloneMap.keySet()) {
			temp = null;
			for (String key2 : custSumCostCloneMap.keySet()) {
				if (custSumCostCloneMap.get(key1) <= custSumCostCloneMap.get(key2)
						&& custSumCostCloneMap.get(key2) != 0) {
					temp = key2;
				}
			}
			if (!temp.equals(null)) {
				custSortCostMap.put(temp, custSumCostCloneMap.get(temp));
				custSumCostCloneMap.put(temp, 0);// 排序過的補0
			}
		}
		for (String key : CustordamtMap.keySet()) {
			System.out.println("編號:" + key + " , 姓名: " + getCustNameMap(key) + ", 總消費金額: " + CustordamtMap.get(key));
		}
	}

	public void setSort() {
		for (String key : CustordamtMap.keySet()) {
			System.out.println("編號:" + key + " , 姓名: " + getCustNameMap(key) + ", 總消費金額: " + CustordamtMap.get(key));
		}
	}

	// 3.依照消費總金額高到低排序
	private void printHighCostOrder() {
		System.out.println("printHighCostOrder");
		// 利用總金額當作Key，value儲存會員編號
		Map<Integer, String> sumMemberPayMap = sortSumMemberPayMap();
		// 用陣列方式，放入總金額
		Integer[] orderByHighAmount = addMemberAmount(sumMemberPayMap);
		// 根據總金額開始排序
		for (int index = 0; index < orderByHighAmount.length - 1; index++) {
			for (int tag = 1; tag < orderByHighAmount.length; tag++) {
				if (orderByHighAmount[index] < orderByHighAmount[tag]) {

					Integer temp = orderByHighAmount[index];
					orderByHighAmount[index] = orderByHighAmount[tag];
					orderByHighAmount[tag] = temp;

				}
			}
		}

		// 利用總金額的排序，利用sumMemberPayMap，去找出會員編號，印出相關資料
		for (int index = 0; index < orderByHighAmount.length; index++) {
			String no = sumMemberPayMap.get(orderByHighAmount[index]);
			System.out.println(
					"編號 : " + no + " , 姓名 : " + MemberDataMap.get(no) + " , 消費總金額  : " + orderByHighAmount[index]);
		}
		System.out.println("---------------");
	}

	private LinkedHashMap<Integer, String> sortSumMemberPayMap() {
		LinkedHashMap<Integer, String> sumMemberPayMap = new LinkedHashMap<Integer, String>();
		for (String no : MemberDataMap.keySet()) {
			int totalAmt = 0;
			for (String key : OrderMemberMap.keySet()) {
				if (no.equals(OrderMemberMap.get(key))) {
					totalAmt = totalAmt + OrderAmountMap.get(key);
				}
			}
			sumMemberPayMap.put(totalAmt, no);
		}
		return sumMemberPayMap;
	}

	private Integer[] addMemberAmount(Map<Integer, String> sumMemberPayMap) {
		Integer[] orderByHighAmount = new Integer[sumMemberPayMap.size()];
		int count = 0;
		for (Integer totalAmt : sumMemberPayMap.keySet()) {
			orderByHighAmount[count] = totalAmt;
			count++;
		}
		return orderByHighAmount;
	}

	// 4.依照消費總金額低到高排序
	private void printLowCostOrder() {
		System.out.println("printLowCostOrder");
		// 利用總金額當作Key，value儲存會員編號
		Map<Integer, String> sumMemberPayMap = sortSumMemberPayMap();
		// 用陣列方式，放入總金額
		Integer[] orderByLowAmount = addMemberAmount(sumMemberPayMap);
		// 根據總金額開始排序
		for (int index = 0; index < orderByLowAmount.length - 1; index++) {
			for (int tag = 1; tag < orderByLowAmount.length; tag++) {
				if (orderByLowAmount[index] > orderByLowAmount[tag]) {

					Integer temp = orderByLowAmount[index];
					orderByLowAmount[index] = orderByLowAmount[tag];
					orderByLowAmount[tag] = temp;

				}
			}
		}

		// 利用總金額的排序，利用sumMemberPayMap，去找出會員編號，印出相關資料
		for (int index = 0; index < orderByLowAmount.length; index++) {
			String no = sumMemberPayMap.get(orderByLowAmount[index]);
			System.out.println(
					"編號 : " + no + " , 姓名 : " + MemberDataMap.get(no) + " , 消費總金額  : " + orderByLowAmount[index]);
		}
		System.out.println("---------------");
	}
}

//訂單資料
class OrderInfo {
	private String orderNo;
	private String no;
	private String orderDesc;
	private int amount;

	public OrderInfo(String orderNo, String no, String orderDesc, int amount) {
		setOrderNo(orderNo);
		setNo(no);
		setOrderDesc(orderDesc);
		setAmount(amount);
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}

/**
 * <pre>
 *
 * 以下請使用List物件儲存以下資訊
 * 並解決四個問題
 *
 * 會員資料
 * 編號  姓名
 * C1	小Q
 * C2	小咪
 * C3	查理
 *
 * 訂單資料
 * 訂單 會員編號  訂購內容 	金額
 * O001 	C1  	衣服    	789
 * O002 	C1    	3C	1999
 * O003 	C2  	遊戲   	1899
 * O004 	C2	保養品   	3300
 * O005 	C3	攝影機  	14999
 *
 * 請用新增會員與訂單類別(Class)
 * 設定每位會員資料以及訂單資料後
 *
 * 1.用會員編號查詢會員買的商品
 *   輸出格式 => 編號 姓名 訂單 訂購內容 金額
 *   
 * 2.算出每位會員的平均每筆消費金額
 *   輸出格式 => 編號 姓名 平均消費金額
 *   
 * 3.依照消費總金額高到低排序
 *   輸出格式 => 編號 姓名 消費總金額
 *   
 * 4.依照消費總金額低到高排序
 *   輸出格式 => 編號 姓名 消費總金額
 * 
 * </pre>
 */
class Q6_5 {

	ArrayList<String> CustID = new ArrayList<String>();
	ArrayList<String> CustNAME = new ArrayList<String>();
	ArrayList<OrderInfo> OrderInfos = new ArrayList<OrderInfo>();
	ArrayList<Integer> CustTotalamt = new ArrayList<Integer>();
	ArrayList<Integer> CustTotalamt1 = new ArrayList<Integer>();

	public void doTreeList() {
		initCustinitdata();
		initorderinfodata();
		System.out.println("1.用會員編號查詢會員買的商品");
		getCustOrderlist();
		System.out.println("2.算出每位會員的平均每筆消費金額");
		getCustAvgAmt();
		System.out.println("3.依照消費總金額高到低排序");
		printHighOrderAmt();
		System.out.println("4.依照消費總金額低到高排序");
		printLowOrderAmt();
	}

	public void initCustinitdata() {
		CustID.add("C1");
		CustID.add("C2");
		CustID.add("C3");

		CustNAME.add("小Q");
		CustNAME.add("小咪");
		CustNAME.add("查理");
	}

	public void initorderinfodata() {
		OrderInfos.add(new OrderInfo("O001", "C1", "衣服", 789));
		OrderInfos.add(new OrderInfo("O002", "C1", "3C", 1999));
		OrderInfos.add(new OrderInfo("O003", "C2", "遊戲", 1899));
		OrderInfos.add(new OrderInfo("O004", "C2", "保養品", 3300));
		OrderInfos.add(new OrderInfo("O005", "C3", "攝影機", 14999));
	}

	// 1.用會員編號查詢會員買的商品,輸出格式 => 編號 姓名 訂單 訂購內容 金額
	// C1,小Q,O001,衣服,789
	private void getCustOrderlist() {
		String ls_custName = "";
		String ls_text = "";

		for (int index = 0; index < OrderInfos.size(); index++) {
			for (int i = 0; i < CustID.size(); i++) {
				if (CustID.get(i) == OrderInfos.get(index).getNo()) {
					ls_custName = CustNAME.get(i);
				}
			}

			ls_text = "編號:" + OrderInfos.get(index).getOrderNo() + ",姓名:" + ls_custName + ",訂單:"
					+ OrderInfos.get(index).getOrderNo() + ",訂單內容:" + OrderInfos.get(index).getOrderDesc() + ",金額:"
					+ OrderInfos.get(index).getAmount();

			System.out.println(ls_text);
		}
	}

	// 2.算出每位會員的平均每筆消費金額
	// 輸出格式 => 編號 姓名 平均消費金額
	private void getCustAvgAmt() {
		String ls_custName = "";

		for (int i = 0; i < CustID.size(); i++) {
			ls_custName = "編號:" + CustID.get(i) + " , 姓名:" + CustNAME.get(i);
			System.out.print(ls_custName);

			float totalAmount = 0;
			float count = 0;
			for (int index = 0; index < OrderInfos.size(); index++) {
				if (CustID.get(i).equals(OrderInfos.get(index).getNo())) {
					count++;
					totalAmount = totalAmount + OrderInfos.get(index).getAmount();
				}
			}
			float avgAmount = totalAmount / count;
			System.out.printf(" , 平均消費金額 : %.2f \n", avgAmount);
		}
		System.out.println("---------------");

	}

	// 3.依照消費總金額高到低排序
	// 輸出格式 => 編號 姓名 消費總金額
	private void printHighOrderAmt() {

		// 計算總消費金額
		for (int i = 0; i < CustID.size(); i++) {

			Integer totalAmount = 0;

			for (int index = 0; index < OrderInfos.size(); index++) {
				if (CustID.get(i).equals(OrderInfos.get(index).getNo())) {
					totalAmount = totalAmount + OrderInfos.get(index).getAmount();
				}
			}
//			System.out.printf(" , 消費金額 : %.2f \n", totalAmount);
			CustTotalamt.add(totalAmount);
		}

//		for (int i = 0; i < CustTotalamt.size()  ; i++) {
//			System.out.println(CustTotalamt.get(i));
//		}

		// 根據總金額開始排序
		for (int i = 0; i < CustTotalamt.size() - 1; i++) {
			for (int j = i + 1; j < CustTotalamt.size(); j++) {
//				System.out.println("一:"+CustTotalamt.get(i).intValue());
//				System.out.println("二:"+CustTotalamt.get(j).intValue());
				if (CustTotalamt.get(j).intValue() < CustTotalamt.get(i).intValue()) {

					Integer temp = CustTotalamt.get(i);
					CustTotalamt.set(i, CustTotalamt.get(j)); // 覆蓋
					CustTotalamt.set(j, temp);

				}
			}
		}

		for (int index = 0; index < CustID.size(); index++) {
			System.out.println(
					"編號:" + CustID.get(index) + " ,姓名:" + CustNAME.get(index) + " ,消費總金額:" + CustTotalamt.get(index));
		}

	}

	// 4.依照消費總金額低到高排序
	// 輸出格式 => 編號 姓名 消費總金額
	private void printLowOrderAmt() {

		// 計算總消費金額
		for (int i = 0; i < CustID.size(); i++) {

			Integer totalAmount = 0;

			for (int index = 0; index < OrderInfos.size(); index++) {
				if (CustID.get(i).equals(OrderInfos.get(index).getNo())) {
					totalAmount = totalAmount + OrderInfos.get(index).getAmount();
				}
			}
//			System.out.printf(" , 消費金額 : %.2f \n", totalAmount);
			CustTotalamt1.add(totalAmount);
		}

//		for (int i = 0; i < CustTotalamt.size()  ; i++) {
//			System.out.println(CustTotalamt.get(i));
//		}

		// 根據總金額開始排序
		for (int i = 0; i < CustTotalamt1.size() - 1; i++) {
			for (int j = i + 1; j < CustTotalamt1.size(); j++) {
//				System.out.println("一:"+CustTotalamt.get(i).intValue());
//				System.out.println("二:"+CustTotalamt.get(j).intValue());
				if (CustTotalamt1.get(i).intValue() < CustTotalamt1.get(j).intValue()) {

					Integer temp = CustTotalamt1.get(i);
					CustTotalamt1.set(i, CustTotalamt1.get(j)); // 覆蓋
					CustTotalamt1.set(j, temp);

				}
			}
		}

		for (int index = 0; index < CustID.size(); index++) {
			System.out.println(
					"編號:" + CustID.get(index) + " ,姓名:" + CustNAME.get(index) + " ,消費總金額:" + CustTotalamt1.get(index));
		}

	}

}
