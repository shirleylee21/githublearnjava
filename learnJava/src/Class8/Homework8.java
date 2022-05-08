package Class8;

import java.util.Random;

public class Homework8 {

	public static void main(String[] args) {
		new Q8_1().exec();
	}
}

/**
 * <pre>
 *  使用try catch
 *  捕捉1/0的錯誤，要顯示不可除以0
 *  捕捉類似1/3的錯誤，提示會無限循環小數，並只格式化到小數點第三位
 * </pre>
 */
class Q8_1 {

	public void exec() {

		System.out.println("使用try catch");
		run1();
		run2();

	}

	public void run1() {
		try {
			int a = 1 / 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("不可除以0!!");
		} finally {

		}
	}

	public void run2() {
		try {
			double b = 1 / 3;
			Math.round(b);
			System.out.println(b);
			System.out.println("無限循環小數，並只格式化到小數點第三位!!");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}
	}
}

/**
 * <pre>
 *  我們要進行動物賽跑比賽
 *  目前有三個參賽者
 *  烏龜，兔子，小豬
 *  烏龜每一秒前進一公尺，每次休息0.5秒
 *  小豬每一秒前進兩公尺，每次休息1~1.5秒
 *  兔子每一秒前進三公尺，每次休息1~3秒
 *  每次比賽都是同時出發
 *  請問10次比賽下來，誰是常勝軍
 * </pre>
 */
class Q8_2 {

//	// 多Thread 簡單範例
//	public void doList() {
//
//		List<>
//		List<Animal> animals = new Animals().init();
//
//		for (int j = 0; j < animals.size(); j++) {
//			Animal animal = animals.get(j);
//			double lastTrack = animal.getTrack();
//			for (int index = 1; index < animal.getTrack(); index++) {
//				// 他每一公尺，花多久時間
//				for (int tag = 0; tag < animal.getSpeed(); tag++) {
//					lastTrack = lastTrack - 1;
//					double totalTime = animal.getTotalTime() + animal.getAvgSpeed();
//					animal.setTotalTime(totalTime);
//
//					if (lastTrack <= 0) {
//						// 跑完了
//						break;
//					}
//				}
////				// 他跑完一次(1公尺)，要休息多久
////				double relaxTotalTime = animal.getRelaxTotalTime()
////						+ ThreadLocalRandom.current().nextInt(animal.getSleepMinTime(), animal.getSleepMaxTime());
////				animal.setRelaxTotalTime(relaxTotalTime);
////			}
////			// 他總共跑了多久
////			animal.setTotalTime(animal.getTotalTime() + animal.getRelaxTotalTime());
////			System.out.println("name : " + animal.getName() + " , total:" + animal.getTotalTime());
//		}
//	}

}

class Animal extends Thread {

	// 必定實作run方法，代表要執行的動作
	public void run() {
		// 做一些事情唷
		try {
			int sleepTime = new Random().nextInt(2000) + 1;
//			System.out.println(Thread.currentThread().getName() + " , 休息:" + sleepTime + "ms");
			// 內建自動等候機制，單位是千毫秒
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	// 養成良好習慣，完成後要結束他
	public void interrupt() {
		super.interrupt();
	}
}