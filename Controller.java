import java.util.Scanner;

public class Controller {
	public static void main(String[] args) {
		LottoMaker lotto = new LottoMaker();
		Scanner sc = new Scanner(System.in);

		//로또 게임을 실행
		lotto.lottoGame(sc);
		
		//로또 당첨 여부를 알려줍니다.
		while (true) {
			System.out.println("당첨을 확인하시려면 1을 누르고 엔터를 쳐주세요");
			int choice = sc.nextInt();
			if (choice == 1) { // 게임시작 }
				System.out.println("당첨결과");
				lotto.lottoResult();
				break;
			}

		}
	}
}
