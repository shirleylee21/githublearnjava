package Class7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Homework7 {
	public static void main(String[] args) {

		new Q7_1().Run();
	}
}

/**
 * <pre>
 *
 *  今天各位要準備開一家飲料店
 *  請使用物件導向方式
 *  設計出以下幾個類別以及簡潔的點餐系統
 *  
 *  1.點餐系統
 *  2.訂單查詢
 *  3.飲料維護   (進階)
 *  4.飲料統計   (進階)
 *  5.點餐修改   (進階)
 *  
 *  飲料 : 要有"基本說明"，"材料"，"容量"，"卡洛里"與"價格"
 *  
 *  飲料調整方式 : 飲料基本上會有"冰塊"，"甜度"，"大杯中杯"
 *            	的調整，請思考一下，如何搭配飲料類別去實作?
 *           	 
 *  菜單 : 裡面需要包含一些基本飲料
 *     	(建議一開始，自己初始化ㄧ些飲料)
 *  
 *  點餐系統 : 1.使用者執行這個程式後
 *          	看到一個簡單的飲料清單
 *      	 
 *        	2.使用者開始點餐，需要記錄使用者點了甚麼飲料
 *          	還有冰塊，糖度，等等
 *     	 
 *        	3.點餐完畢，顯示使用者點完的結果   
 *           	 
 *  訂單查詢 : 我們需要一個訂單查詢系統
 *        	我們需要產生訂單號碼，使用者的姓名與電話
 *        	並紀錄點了多少飲料
 *  
 *  -----------------------------------------------
 *  
 *  進階題
 *  飲料統計 : 每次點餐完畢之後，可以根據功能選項
 *        	看到總共賣出多少飲料，消費總金額
 *        	以及統計每杯飲料點的數量       	 
 *  
 *  飲料維護  : 可以在維護介面新增飲料與修改
 *
 *  點餐修改 : 可以在這個選項裡，新增、修改、刪除客人的訂單
 *  
 *  Hit : 需要看到繼承，多型，封裝這三種物件導向基礎的類別設計
 * </pre>
 */
/*
 * 1. 開始點餐 查看菜單 2. 姓名 3. 電話 4. 外帶 內用 5. 顯示訂單 6. 繼續點餐？ 7. 點餐完畢 取消點餐
 */
class Q7_1 {

	Map<Integer, OrderMenu> menuList = new LinkedHashMap<Integer, OrderMenu>();

	Map<String, OrderData> orderDataMap = new LinkedHashMap<String, OrderData>();

//	ArrayList<Integer> orderitem = new ArrayList<Integer>();
	int orderRow = 1;

	Scanner scanner = new Scanner(System.in);

	public void InitMenuData() {

		menuList.put(1, new OrderMenu("1", "排骨飯", 90));
		menuList.put(2, new OrderMenu("2", "雞腿飯", 120));
		menuList.put(3, new OrderMenu("3", "豬排飯", 95));
		menuList.put(4, new OrderMenu("4", "咖哩飯", 100));
		menuList.put(5, new OrderMenu("5", "魚排飯", 150));
	}

	public void Run() {
		InitMenuData();
		OrderSystem();
	}

	public void OrderSystem() {
		String choosetype;

		while (true) {
			System.out.print("請選擇功能：1.客戶點餐 / 2.訂單查詢 / 3.商品維護 / 4.餐點統計 / 5.餐點修改，");
			System.out.print("輸入0則結束點菜系統：");
			choosetype = scanner.next();

			switch (choosetype) {
			case "1":
				ShowMenu();
				CreateOrder();
				break;
			case "2":
				OrderQuery();
				break;
			case "3":
				ProdMaintain();
				break;
			case "4":
				OrderStatistics();
				break;
			case "5":
				OrderModify();
				break;
			case "0":
				System.out.println("點餐系統結束，掰掰。");
				System.exit(0);
			default:
				System.out.println("輸入錯誤的符號，請重新開始。\n");
				break;
			}
			System.out.println();
		}
	}

	public void ShowMenu() {
		System.out.println("-----------------本店菜單-----------------");
		System.out.println("序號\t\t菜名\t\t單價");

		for (int key : menuList.keySet()) {
			System.out.println(menuList.get(key).getId() + "\t\t" + menuList.get(key).getName() + "\t\t"
					+ menuList.get(key).getPrice());
		}
		System.out.println("---------------------------------------");
	}

	// 1.客戶點餐
	public void CreateOrder() {
		String custNm = "", custMobile = "";

		System.out.print("請輸入顧客姓名:");
		custNm = scanner.next();
		if (custNm.equals("0")) {
			return;
		}

		System.out.print("請輸入顧客電話:");
		custMobile = scanner.next();
		if (custMobile.equals("0")) {
			return;
		}

		List<Integer> orderitem = new ArrayList<>();
		while (true) {
			System.out.println("請輸入序號進行點餐，輸入 0 則結束點餐，返回菜單頁面：");
			int id = scanner.nextInt();
			if (id == 0) {
				String orderNo = "ORD" + String.format("%03d", orderRow++);
				OrderData orderData = new OrderData(orderNo, custNm, custMobile, orderitem);
				orderDataMap.put(orderNo, orderData);
				// 點餐完畢，顯示使用者點完的結果
				ShowOrderData(orderNo);
				break;
			}

			if (!menuList.containsKey(id)) {
				System.out.println("輸入錯誤的符號，請重新輸入：");
			} else {

				System.out.println("請輸入菜單序號：" + id);
				System.out.println("你點的餐點是：" + menuList.get(id).getName());
				// 把已點的菜加入訂單
				orderitem.add(id);

			}
		}
//		String orderNo = "ORD" + String.format("%03d", orderRow++);
//		OrderData orderData = new OrderData(orderNo, custNm, custMobile, orderitem);
//		orderDataMap.put(orderNo, orderData);

	}

	/** * 查看已點的菜 */
	public void ShowOrderData(String OrderNo) {

////		System.out.println("你點的餐點如下：");
////		System.out.println("序號\t\t菜名\t\t單價");
//
////		for (int index = 0; index < orderitem.size(); index++) {
////			
////			int order = orderitem.get(index);
////			OrderMenu orderMenu = menuList.get(order);
////			System.out.println(orderMenu.getId() + "\t\t" + orderMenu.getName() + "\t\t" 
////					+ orderMenu.getPrice());
////		}

		System.out.println("訂單：" + orderDataMap.get(OrderNo).getOrderNo() + "，姓名："
				+ orderDataMap.get(OrderNo).getCust_name() + "，電話：" + orderDataMap.get(OrderNo).getCust_mobile());
		System.out.println("---------------------------------------");
		System.out.println("序號\t\t菜名\t\t單價");

		for (Entry<String, OrderData> vo : orderDataMap.entrySet()) {
			vo.getKey();
			vo.getValue().getOrderitem();
			if (vo.getKey() == orderDataMap.get(OrderNo).getOrderNo()) {
				for (int index = 0; index < vo.getValue().getOrderitem().size(); index++) {
					int order = vo.getValue().getOrderitem().get(index);
					OrderMenu orderMenu = menuList.get(order);
					System.out
							.println(orderMenu.getId() + "\t\t" + orderMenu.getName() + "\t\t" + orderMenu.getPrice());
				}
			}
		}

		System.out.println("---------------------------------------");

	}

	// 2.訂單查詢
	public void OrderQuery() {

		String choosetype;

		while (true) {
			System.out.print("請選擇功能：1.查詢全部交易 / 2.查詢訂單編號，");
			System.out.print("輸入0則結束訂單查詢系統，返回菜單頁面：");
			choosetype = scanner.next();

			if ("1".equals(choosetype)) {

				if (orderDataMap.isEmpty()) {
					System.out.println("當前您還未點餐，請重新輸入選擇");
				} else {
					System.out.println("訂單餐點如下：");
					for (String key : orderDataMap.keySet()) {
						ShowOrderData(key);
					}
				}
			} else if ("2".equals(choosetype)) {
				if (orderDataMap.isEmpty()) {
					System.out.println("當前您還未點餐，請重新輸入選擇");
				} else {
					System.out.print("請輸入要查詢的餐點訂單編號：");
					String id = scanner.next();
					String orderid = Getid("ORDINFO", id);

					if (orderid.contains("ORD")) {
						System.out.println("你查詢的訂單為：");
						ShowOrderData(orderid);

					} else {
						System.out.println(orderid);
						OrderQuery();
					}

				}
			} else if ("0".equals(choosetype)) {
				OrderSystem();
				break;
			} else {
				System.out.println("輸入錯誤的符號，請重新開始。\n");
			}
			System.out.println();
		}

	}

	// 查詢訂單ID
	public String Getid(String type, String id) {
//		String ls_return = " ";

		switch (type) {
		case "ORDINFO":
			if (orderDataMap.containsKey(id)) {
				return id;
			} else {
				return "輸入錯誤的訂單ID，請重新輸入：";
			}
		case "MAXID":
			int i = 0;
			for (Integer key : menuList.keySet()) {
				if (Integer.valueOf(menuList.get(key).getId()) > i) {
					i = Integer.valueOf(menuList.get(key).getId());
				}
			}
			return String.valueOf(i);

		default:
			return "ID輸入錯誤。";
		}
	}

	// 3.商品維護
	public void ProdMaintain() {
		String menu_name = "";
		Integer menu_id, menu_price = 0;
		String choosetype;

		while (true) {
			System.out.print("請選擇功能：1.新增菜單餐點 / 2.修改菜單餐點 / 3.移除菜單餐點 / 4.查詢菜單 ，");
			System.out.print("輸入0則結束菜單維護系統：");
			choosetype = scanner.next();

			if (choosetype.equals("0")) {
				break;
			}

			if ("1".equals(choosetype)) {

				System.out.print("請輸入要新增的菜單餐點名稱:");
				menu_name = scanner.next();
				if (menu_name.equals("0")) {
					break;
				}
				System.out.print("請輸入新增的菜單餐點價格:");
				menu_price = Integer.parseInt(scanner.next());
				if (menu_price.equals(0)) {
					break;
				}

				int key_id = Integer.parseInt(Getid("MAXID", "")) + 1;
				menuList.put(key_id, new OrderMenu(String.valueOf(key_id), menu_name, menu_price));
				System.out.println("菜單 " + menu_name + " 新增完成。");

			} else if ("2".equals(choosetype)) {
				ShowMenu();
				System.out.print("請輸入要修改的菜單序號:");
				menu_id = Integer.parseInt(scanner.next());
				if (menu_id.equals(0)) {
					break;
				}
				System.out.print("請輸入修改的菜單餐點價格:");
				menu_price = Integer.parseInt(scanner.next());
				if (menu_price.equals(0)) {
					break;
				}

				if (menuList.containsKey(menu_id)) {
					menu_name = menuList.get(menu_id).getName();
					menuList.put(menu_id, new OrderMenu(String.valueOf(menu_id), menu_name, menu_price));
					System.out.println("菜單序號 " + menu_id + " 異動完成。");
				}

			} else if ("3".equals(choosetype)) {
				ShowMenu();
				System.out.print("請輸入要刪除的菜單序號:");
				menu_id = Integer.parseInt(scanner.next());
				if (menu_id.equals(0)) {
					break;
				}
				if (menuList.containsKey(menu_id)) {
					menuList.remove(menu_id);
					System.out.println("菜單序號 " + menu_id + " 刪除完成。");
				} else {
					System.out.println("查無此菜單序號，請重新輸入");
					ProdMaintain();
				}

			} else if ("4".equals(choosetype)) {
				ShowMenu();
			} else {
				System.out.println("輸入錯誤的符號，請重新開始。\n");
			}
			System.out.println();

		}
	}

	// 4.餐點統計
	public void OrderStatistics() {

		String choosetype;

		while (true) {
			System.out.print("請選擇功能：1.查詢餐點銷售總金額 / 2.餐點銷售量，");
			System.out.print("輸入0則結束訂單查詢系統，返回菜單頁面：");
			choosetype = scanner.next();

			if ("1".equals(choosetype)) {
				double total_amt = 0.0d;

				if (orderDataMap.isEmpty()) {
					System.out.println("當前您還未點餐，請重新輸入選擇");
				} else {

					System.out.println("請稍等，正在結算你的所有餐點中……");
					for (String key : orderDataMap.keySet()) {
						for (int index = 0; index < orderDataMap.get(key).getOrderitem().size(); index++) {
							int menu_id = orderDataMap.get(key).getOrderitem().get(index);
							total_amt += menuList.get(menu_id).getPrice();
						}
					}
					System.out.format("今日銷售總金額：NT- %.2f\n", total_amt);

				}
			} else if ("2".equals(choosetype)) {
				int ll_cnt = 0;

				if (orderDataMap.isEmpty()) {
					System.out.println("當前您還未點餐，請重新輸入選擇");
				} else {
					System.out.print("請輸入你要查詢的餐點序號：");
					String id = scanner.next();

					for (String key : orderDataMap.keySet()) {
						for (int index = 0; index < orderDataMap.get(key).getOrderitem().size(); index++) {
							if (id.equals(String.valueOf(orderDataMap.get(key).getOrderitem().get(index)))) {
								ll_cnt++;
							}
						}
					}

					System.out.println("餐點序號-'" + id + "', 今日餐點銷售量：" + String.valueOf(ll_cnt));
				}

			} else if ("0".equals(choosetype)) {
				OrderSystem();
				break;
			} else {
				System.out.println("輸入錯誤的符號，請重新開始。\n");
			}
			System.out.println();
		}

	}

	// 5.餐點修改
	public void OrderModify() {
		String choosetype, orderid;
		Integer menu_id, prod_id;

		while (true) {
			System.out.print("請選擇功能：1.新增訂單餐點 /2.刪除訂單餐點，");
			System.out.print("輸入0則結束菜單維護系統：");
			choosetype = scanner.next();

			if (choosetype.equals("0")) {
				break;
			}

			if ("1".equals(choosetype)) {

				System.out.print("請輸入要修改的訂單編號:");
				String id = scanner.next();
				orderid = Getid("ORDINFO", id);

				if (!orderid.contains("ORD")) {
					System.out.println("查無此訂單資料!!");
					break;
				}
				// 顯示菜單
				ShowMenu();

				System.out.print("請輸入要新增的菜單序號：");
				menu_id = Integer.parseInt(scanner.next());
				// 把已點的菜加入訂單
				orderDataMap.get(orderid).getOrderitem().add(menu_id);
				System.out.println(orderid + "訂單餐點 "+ menuList.get(menu_id).getName() +" 新增完成。");

			}else if ("2".equals(choosetype)) {
				
				System.out.print("請輸入要修改的訂單編號:");
				String id = scanner.next();
				orderid = Getid("ORDINFO", id);

				if (!orderid.contains("ORD")) {
					System.out.println("查無此訂單資料!!");
					break;
				}
				// 顯示訂單資料
				ShowOrderData(orderid);

				System.out.print("請輸入要刪除的訂單餐點序號：");
				prod_id = Integer.parseInt(scanner.next());
				// 訂單商品刪除
				orderDataMap.get(orderid).getOrderitem().remove(prod_id);
				System.out.println(orderid + "訂單餐點 "+ menuList.get(prod_id).getName() +" 刪除完成。");
				
			} else {
				System.out.println("輸入錯誤的符號，請重新開始。\n");
			}
			System.out.println();

		}

	}



}