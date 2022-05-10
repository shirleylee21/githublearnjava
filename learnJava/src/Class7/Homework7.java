package Class7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
	ArrayList<Integer> orderList = new ArrayList<Integer>();
	int orderRow = 0;

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
			System.out.print("請選擇功能：1.客戶點餐 / 2.訂單查詢 / 4.餐點統計，");
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
			case "4":
				OrderStatistics();
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

	//1.客戶點餐
	public void CreateOrder() {

		while (true) {
			System.out.println("請輸入序號進行點餐，輸入 0 則結束點餐，返回菜單頁面：");
			int id = scanner.nextInt();
			if (id == 0) {
				// 點餐完畢，顯示使用者點完的結果
            	ShowOrderData();
				break;
			}

			if (!menuList.containsKey(id)) {
				System.out.println("輸入錯誤的符號，請重新輸入：");
			} else {
				System.out.println("輸入菜單序號：" + id);
				System.out.println("你點的餐點是：" + menuList.get(id).getName());
				// 把已點的菜加入已點菜單
				orderList.add(id);
			}
		}

	}

	/**	 * 查看已點的菜	 */
	public void ShowOrderData() {
		
		System.out.println("你點的餐點如下：");
		System.out.println("序號\t\t菜名\t\t單價");

		for (int index = 0; index < orderList.size(); index++) {
			
			int order = orderList.get(index);
			OrderMenu orderMenu = menuList.get(order);
			System.out.println(orderMenu.getId() + "\t\t" + orderMenu.getName() + "\t\t" 
					+ orderMenu.getPrice());
		}

		System.out.println("---------------------------------------");
		
	}

	//2.訂單查詢
	public void OrderQuery() {
		
		String choosetype;

		while (true) {
			System.out.print("請選擇功能：1.查詢全部交易 / 2.查詢編號，");
			System.out.print("輸入0則結束訂單查詢系統，返回菜單頁面：");
			choosetype = scanner.next();

			switch (choosetype) {
			case "1":
				if (orderList.isEmpty()) {
					System.out.println("當前您還未點餐，請重新輸入選擇");
				} else {
					ShowOrderData();
					break;
				}
			case "2":
				if (orderList.isEmpty()) {
					System.out.println("當前您還未點餐，請重新輸入選擇");
				} else {
					System.out.print("請輸入要查詢的餐點編號：");
					int id = scanner.nextInt();
					if (!menuList.containsKey(id)) {
						System.out.println("輸入錯誤的餐點編號，請重新輸入：");
					} else {
						
						System.out.println("你查詢的餐點為：");
						System.out.println("序號："+menuList.get(id).getId() +"，菜名："+ menuList.get(id).getName() 
						+ "，單價：" + menuList.get(id).getPrice());
						int ordercnt = 0;
						for (int index = 0; index < orderList.size(); index++) {
							if (orderList.get(index).equals(id)) {
								ordercnt++;
							}
						}
						System.out.println("共 " + ordercnt + " 份。");
						System.out.println("---------------------------------------");
						
					}
					
					break;
				}
			case "0":
				break;
			default:
				System.out.println("輸入錯誤的符號，請重新開始。\n");
				break;
			}
			System.out.println();
		}
		
	}

	
	//4.餐點統計
	public void OrderStatistics() {
		
        double money = 0.0d;
        if (orderList.isEmpty()) {
            System.out.println("當前您還未點餐，請重新輸入選擇");
        } else {
            System.out.println("請稍等，正在結算你的所有餐點中……");
            for (int i = 0; i < orderList.size(); i++) {
                money += menuList.get(i).getPrice();
            }
            System.out.format("你此次總共消費：NT- %.2f\n", money);
        }
        
	} 


}