package gugudan_final1;

import java.util.Scanner;

public class gugudan_final {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int x = 0;

		while (true) {
			try {
				System.out.println("---구구단---");
				System.out.println("몇 단을 원하세요?");

				x = scanner.nextInt();

				if (x < 1 || x > 999) {
					// 잘못된 입력값 처리
					throw new IllegalArgumentException("1~999 범위의 정수를 입력해 주세요.");
				}
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("1~999 범위가 아닙니다.");
				System.out.println(e.getMessage());
				continue;
			}
		}

		// 1~9을 곱하여 출력합니다.
		for (int i = 1; i <= 9; i++) {
			System.out.println(x + " x " + i + " = " + (x * i));
		}

	}
}
