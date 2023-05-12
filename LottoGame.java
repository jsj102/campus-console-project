package LottoGame;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        TreeSet<Integer> userNumbers = new TreeSet<>();
        TreeSet<Integer> winningNumbers = new TreeSet<>();

        // 1. 6개의 숫자 입력받기
        System.out.println("1부터 45까지의 숫자 중 6개를 골라주세요.");
        while (userNumbers.size() < 6) {
            System.out.print((userNumbers.size() + 1) + "번째 숫자: ");
            int number = scanner.nextInt();

            // 입력된 숫자가 범위를 벗어나면 다시 입력받기
            if (number < 1 || number > 45) {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                continue;
            }

            if (!userNumbers.add(number)) {
                System.out.println("중복된 숫자입니다. 다시 입력해주세요.");
            }
        }

        // 2. 최종 도전번호 출력
        System.out.print("내가 선택한 번호 : ");
        for (int number : userNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // 3. 게임시작
        System.out.println("게임을 시작합니다.");

        // 4. 당첨번호 출력
        System.out.print("당첨번호: ");
        while (winningNumbers.size() < 6) {
            int number = random.nextInt(45) + 1; // 1부터 45까지의 난수 생성
            if (winningNumbers.add(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();

        // 5. 당첨여부 확인
        userNumbers.retainAll(winningNumbers); // 당첨번호와 일치하는 번호 추출
        int matchedCount = userNumbers.size();
        if (matchedCount == 6) {
            System.out.println("모든 숫자를 맞춰서 1등에 당첨되었습니다!");
        } else if (matchedCount == 5) {
            System.out.println("5개의 숫자를 맞춰서 2등에 당첨되었습니다!");
        } else if (matchedCount == 4) {
            System.out.println("4개의 숫자를 맞춰서 3등에 당첨되었습니다!");
        } else {
            System.out.println("당첨되지 않았습니다. 다음 기회에 도전해보세요.");
        }
    }
}
