
/**
 * 유저에게 서비스를 제공합니다.
 */

import java.util.Scanner;

public class MainWin {
	public static void main(String[] args) {
		Manager manager = new Manager();
		Scanner sc = new Scanner(System.in);

		while (true) {
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

	}
}
