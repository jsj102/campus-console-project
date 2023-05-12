
package lotto_machine;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class lotto_machine_c {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] userNumbers = new int[6];
		// 예외 처리(1~45이외의 숫자를 넣었을 경우)

		for (int i = 0; i < 6; i++) {
			while (true) {
				try {
					System.out.println("로또 번호 6개 입력해 주세요");
					int number = sc.nextInt();
					if (number < 1 || number > 45) {
						System.out.println("1~45 사이의 숫자를 입력해 주세요.");
					} else {
						userNumbers[i] = number;
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("올바른 숫자를 입력해 주세요");
				}
			}
		}

		Arrays.sort(userNumbers);
		System.out.println("입력한 번호: ");
		System.out.println(Arrays.toString(userNumbers));

		// 로또 번호를 생성한다.
		Random random = new Random();
		int[] lottoNumbers = new int[6];
		for (int i = 0; i < 6; i++) {
			while (true) {
				int number = random.nextInt(45) + 1;
				boolean isCopy = false;
				for (int j = 0; j < i; j++) {
					if (lottoNumbers[j] == number) {
						isCopy = true;
						break;
					}
				}
				if (!isCopy) {
					lottoNumbers[i] = number;
					break;
				}

			}
		}
		
		Arrays.sort(lottoNumbers);
		System.out.println("생성된 번호: ");
		System.out.println(Arrays.toString(lottoNumbers));

	}

}
