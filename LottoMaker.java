import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoMaker {
	private int choice = 0;
	private int num = 0;
	private int count = 0;
	Scanner sc;
	// ArrayList<TreeSet> mylotto = new ArrayList();

// 유저가 로또번호를 랜덤으로 받을지, 입력할지 선택
	public void lottoGame(Scanner sc) {
		LottoMaker lottomaker = new LottoMaker();
		System.out.println("로또게임에 오신 것을 환영합니다!");
		System.out.println("========Menu=======");
		System.out.println("1.수동로또");
		System.out.println("2.자동로또");
		System.out.println("0.종료");

		while (true) {
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("=======수동로또=======");
				lottomaker.lottoInput(sc);
				break;
			} else if (choice == 2) {
				System.out.println("=======자동로또=======");
				lottomaker.lottoRandom();
				break;
			} else if (choice == 0) {
				System.out.println("종료합니다.");
				continue;
			}

		}
	}

// 유저에게 로또번호를 입력받습니다. 수동로또
	public void lottoInput(Scanner sc) {

		System.out.println("1-45까지의 로또 번호 6자리를 입력해주세요!"); // 중복, 범위 아닌 값 예외처리
		int[] usernum = new int[6]; // user가 입력한 숫자를 담을 배열 선언, 숫자 6개 까지만 입력 가능

		for (int i = 0; i < usernum.length; i++) { // 숫자 6개까지만 입력 가능
			usernum[i] = sc.nextInt(); // 유저에게 숫자 입력받기
			if (usernum[i] > 45 || usernum[i] < 1) { // 숫자 범위 제한
				System.out.println("1-45사이의 정수만 입력 가능합니다.");
				i--;
			}
			for (int j = 0; j < i; j++) { // 중복된 값 제거
				if (usernum[i] == usernum[j]) { // 먼저 입력한 수와 같으면 숫자를 제거
					System.out.println("중복된 숫자를 입력하셨습니다");
					i--;
				}

			}

		}
		Arrays.sort(usernum); // 오름차순 정렬

		// 입력한 번호 확인
		System.out.println("나의 번호 : ");
		for (int i = 0; i < 6; i++) { // 입력한 6개 숫자를 그대로 출력
			System.out.println(usernum[i] + "");
		}
		System.out.println();

		// 당첨번호를 랜덤으로 추출합니다.
		int[] lotto = new int[6]; // 당첨번호 6개를 저장하는 배열
		for (int i = 0; i < 6; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) { // 중복된 값을 제거해줍니다.
				if (lotto[i] == lotto[j]) {
					i--;
					break; // 만약 중복된 값이 추출되면 한 번 더 i를 랜덤으로 생성합니다.
				}
			}
		}
		Arrays.sort(lotto); // 당첨번호 오름차순
		System.out.println("당첨번호");
		for (int i = 0; i < 6; i++) { // 숫자 6개 출력
			System.out.println(lotto[i] + "");
		}

		int count = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (usernum[i] == lotto[j]) {
					count++;
				}
			}
			this.setCount(count);
		}
	}

	// 로또 번호 6자리를 랜덤으로 생성합니다. 자동로또
	public void lottoRandom() {
//		TreeSet<Integer> randomLottery = new TreeSet<Integer>(); // treeset을 사용하여 중복없는 값을 입력받습니다.
//		System.out.println("랜덤 로또 번호를 생성합니다.");
//		while (randomLottery.size() < 6) { // 숫자 6개 랜덤 출력
//			int num = (int) (Math.random() * 45 + 1); // math.random을 사용해 1-45까지의 로또 번호 랜덤 출력
//			randomLottery.add(num); // treeset에 값을 저장
//		}
//		System.out.println(randomLottery);
		
		// 로또번호를 랜덤으로 추출합니다.
				int[] userlotto = new int[6]; // 당첨번호 6개를 저장하는 배열
				for (int i = 0; i < 6; i++) {
					userlotto[i] = (int) (Math.random() * 45 + 1);
					for (int j = 0; j < i; j++) { // 중복된 값을 제거해줍니다.
						if (userlotto[i] == userlotto[j]) {
							i--;
							break; // 만약 중복된 값이 추출되면 한 번 더 i를 랜덤으로 생성합니다.
						}
					}
				}
				Arrays.sort(userlotto); // 당첨번호 오름차순
				System.out.println("당첨번호");
				for (int i = 0; i < 6; i++) { // 숫자 6개 출력
					System.out.println(userlotto[i] + "");
				}
		

		// 당첨번호를 랜덤으로 추출합니다.
		int[] lotto = new int[6]; // 당첨번호 6개를 저장하는 배열
		for (int i = 0; i < 6; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) { // 중복된 값을 제거해줍니다.
				if (lotto[i] == lotto[j]) {
					i--;
					break; // 만약 중복된 값이 추출되면 한 번 더 i를 랜덤으로 생성합니다.
				}
			}
		}
		Arrays.sort(lotto); // 당첨번호 오름차순
		System.out.println("당첨번호");
		for (int i = 0; i < 6; i++) { // 숫자 6개 출력
			System.out.println(lotto[i] + "");
		}

		int count = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (userlotto[i] == lotto[j]) {
					count++;
				}
			}
			this.setCount(count);
		}

	}

	// 로또 당첨여부를 확인합니다
	public void lottoResult(int count) {
		// switch로 count 개수를 세고, 당첨여부를 판단합니다.
		switch (count) {
		case 6: {
			System.out.println("1등 입니다!");
		}
		case 5: {
			System.out.println("2등 입니다!");
		}
		case 4: {
			System.out.println("3등 입니다!");
		}
		case 3: {
			System.out.println("4등 입니다!");
		}
		default: {
			System.out.println("꽝입니다!");
		}
		}

	}

	// get/set 영역입니다.
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
