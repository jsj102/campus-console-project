package gugudan_up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gugudan_study {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("첫 번째 수를 입력하세요 (1 ~ 999): ");
			int first = Integer.parseInt(br.readLine());
			
			System.out.println("두 번째 수를 입력하세요 (1 ~ 999): ");
			int second = Integer.parseInt(br.readLine());
			
			if (first < 1 || first > 999 || second < 1 || second > 999) {
				throw new IllegalArgumentException("입력된 값이 범위를 벗어났습니다.");
			}
			
			for(int i =1;i <= 9; i++) {
				System.out.println(first+" x "+i+" = "+(first*i));
			}
			
			for(int i =1;i <= 9; i++) {
				System.out.println(second+" x "+i+" = "+(second*i));
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
			System.out.println("숫자 형식이 올바르지 않습니다.");
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
