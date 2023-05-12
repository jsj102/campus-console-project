import java.util.Scanner;

public class Caculator_kjh {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x = 0;
		int y = 0;

		String arithmetic = "";
		
		//예외 처리
		while (true) {
			System.out.println("두 수를 입력해 주세요");

			// 두 수를 입력 받습니다.
			x = sc.nextInt();
			y = sc.nextInt();

			System.out.println("사칙연산 부호 (+,-,*,/) : ");
			arithmetic = sc.next();
			try {
				int result = x / y;
				System.out.println(x + " / " + y + " = " + result);
				break;
			} catch (ArithmeticException e) {
				System.out.println("00으로 나눌 수 없습니다.");
				continue;
			}
		}

		if (arithmetic.equals("+")) {
			System.out.println(x + " + " + y + "=" + (x + y));
		} else if (arithmetic.equals("-")) {
			System.out.println(x + " - " + y + "=" + (x - y));
		} else if (arithmetic.equals("*")) {
			System.out.println(x + " * " + y + "=" + (x * y));
		} else if (arithmetic.equals("/")) {
			System.out.println(x + " / " + y + "=" + (x / y));
		} else {
			System.out.println("연산자를 잘못입력하셨습니다.");
		}

	}

}
