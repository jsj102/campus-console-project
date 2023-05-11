
/**
 * 유저에게 서비스를 제공합니다.
 */

import java.util.Scanner;

public class MainWin {
	public static void main(String[] args) {
		Manager manager = new Manager();
		Scanner sc = new Scanner(System.in);

		while (true) {
			run(sc);

		}

	}
}

public class Service {
	private int choice = 0;
	private int dan = 0;
	private int num = 0;
	
	public run(Scanner sc) {
		System.out.println("==========Menu==========");
		System.out.println("1. 구구단");
		System.out.println("2. 계산기");
		System.out.println("3. 종료");
		System.out.println("4. 별그리기");
		System.out.println("선택 : ");

		int choice = sc.nextInt();
		if (choice == 1) {
			manager.gugudan();
			break;
		} else if (choice == 2) {
			manager.calculation(sc);
			break;
		} else if (choice == 3) {
			System.out.println("종료합니다.");
			break;
		} else if (choice == 4) {
			manager.methodDotStar();
		}
	}
	public Service(int choice) {
		this.setChoice(choice);
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}

}