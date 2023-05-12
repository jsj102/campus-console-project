import java.util.Scanner;

public class Star {

	public static void methodDotStar() {
		String dot = "";
		double top = 0.;
		double middle = 0.;
		double bottom = 0.;
		Scanner sc = new Scanner(System.in);
		String scs = "";
		int line = 0;
		for (; true;) {
			System.out.println("별의 크기를 정해주세요.(정수만 입력받습니다.)");
			scs = sc.next();
			if (isInteger(scs)) {
				break;
			}else {
				System.out.println("입력값이 정수가 아닙니다.");
			}
		}
		line = Integer.parseInt(scs);
		top = 0.3 * line;
		middle = 0.4 * line;
		bottom = 0.3 * line;
		for (int i = 0; top > i; i++) {
			for (int j = ((line - 1) * 2 + 1 - i * 2 - 1) / 2; j > 0; j--) {
				dot = dot + " ";
			}
			for (int j = i * 2 + 1; j > 0; j--) {
				dot = dot + "*";
			}
			System.out.println(dot);
			dot = "";
		}
		/* top */
		for (int i = line; i >= (top + middle); i--) {
			for (int j = ((line - 1) * 2 + 1 - i * 2 - 1) / 2; j > 0; j--) {
				dot = dot + " ";
			}
			for (int j = i * 2 + 1; j > 0; j--) {
				dot = dot + "*";
			}
			System.out.println(dot);
			dot = "";
		}
		/* middle */
		for (double i = top + middle; line >= i; i++) {
			for (double j = ((line - 1) * 2 + 1 - i * 2 - 1) / 2; j > 0; j--) {
				dot = dot + " ";
			}
			for (double j = (line - i) * 2; j > 0; j--) {
				dot = dot + "*";
			}
			for (double j = (i - top - middle) * 7 + 1; j > 0; j--) {
				dot = dot + " ";
			}
			for (double j = (line - i) * 2; j > 0; j--) {
				dot = dot + "*";
			}
			System.out.println(dot);
			dot = "";
		}
		/* bottom */
		scs = "";

	}

	private static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}
}
