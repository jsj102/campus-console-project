import java.util.Scanner;

public class Caculator_kjh {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x = 0;
		int y = 0;

		String arithmetic = "";

		System.out.println("두 수를 입력해 주세요");

		x = sc.nextInt();
		y = sc.nextInt();

		System.out.println("사칙연산 부호 (+,-,*,/) : ");
		arithmetic = sc.next();

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
