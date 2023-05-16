
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