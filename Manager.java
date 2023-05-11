
/**
 * 제공 서비스 입니다.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {

	/**
	 * 구구단 서비스
	 */
	public void gugudan() {
		Scanner sc = new Scanner(System.in);
		private int dan = 0;
		private double[] Num = new double[10];// 계산할 숫자들의 저장배열
		private char[] Sign = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };// 계산할 기호들의 저장배열
		private int countNum = 0;// 계산할 숫자들의 수
		private int countSign = 0;// 계산할 기호들의 수
		private double result = 0.;// 결과값의 배열 로 변경했다가 터져서 일단 배열없이하겠습니다.
		private String str = ""; // 숫자로 변환하기전 문자의 임시저장소
		private int[] priorityPM = new int[10];// 연산 우선순위를 처리하기위해 +,-의 위치를 기억합니다.
		private int[] priorityMDM = new int[10];// 연산 우선순위를 처리하기위해 *,/,%의 위치를 기억합니다.
		private int priorityPMCount = 0;
		private int priorityMDMCount = 0;
		private int resultCount = 0;// 계산결과의 총갯수입니다.

		while (true) {
			try {
				System.out.println("=======구구단=======");
				System.out.println("원하는 단을 입력해주세요 : ");
				
				// 단을 입력받습니다.
				dan = sc.nextInt();

				if (dan < 1 || dan > 999) { // 1~999범위의 숫자가 아닐 시 예외처리
					// 잘못된 인수 예외처리
					throw new IllegalArgumentException("1~999 범위의 정수를 입력해주세요.");
				} 
				break;
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println("입력오류! 1~999 사이의 정수만을 입력해주세요.");
				continue;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				continue;
			}
		}
		// 1~9까지의 구구단을 출력합니다.
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + "X" + i + "=" + dan * i);
		}
	}


		// 계산기 실행부입니다. Main함수 같은 역할입니다.
		public double calculation(Scanner sc) {

			String scc;

			System.out.println("계산식을 입력해주세요. 예)1+2= / 3*5=");
			scc = sc.next();

			// 입력받은것을 숫자, 연산자로 나누어 저장합니다. 이 과정에서 숫자,연산자 이외의 값이 들어오면 터집니다.
			setCalcNum(scc);

			result = priorityCalculation(); // 숫자,연산기호를 연산해줍니다. 사실 함수안에서 result를 처리해주기 떄문에 필요없는부분이지만 가시성을 위해 result =
											// result;형식으로 변경했습니다.

			System.out.println(" ");
			System.out.println(result);
			setResultCount(getResultCount() + 1);
			return result;

		}

		// 아래 두함수는 연산기호가 +,- // *,/,%일때 각각 이전숫자와 연산기호를 변수에 저장하고 숫자,연산기호의 카운트횟루를 늘려주는
		// 함수입니다.
		private void methodAddOperatorPM(char c, String str) {
			Num[countNum] = Double.parseDouble(str);
			countNum += 1;
			Sign[countSign] = c;
			priorityPM[priorityPMCount] = countSign;
			priorityPMCount += 1;
			countSign += 1;
			this.str = "";
		}

		private void methodAddOperatorMDM(char c, String str) {
			Num[countNum] = Double.parseDouble(str);
			countNum += 1;
			Sign[countSign] = c;
			priorityMDM[priorityMDMCount] = countSign;
			priorityMDMCount += 1;
			countSign += 1;
			this.str = "";
		}

		// 계산기 싱행에 실패했을경우 카운팅값들을 초기화하는 함수입니다.
		private void methodCalcInit() {
			this.countNum = 0;
			this.countSign = 0;
			this.result = 0;
			this.str = "";
			this.priorityPMCount = 0;
			this.priorityMDMCount = 0;
		}

		private void setCalcNum(String scc) {
			char calcChar[]; // 입력받은식을 글자단위로 분할하여 저장할 배열
			int scclength;// 입력받은식의 전체길이(숫자처리용 for문에 사용)
			scclength = scc.length();
			calcChar = scc.toCharArray();

			for (int i = 0; scclength > i; i++) {
				if (calcChar[i] == '+') {
					if (isDouble(str)) {
						methodAddOperatorPM('+', str);
					} else {
						System.out.println("올바르지않은 계산식입니다.");
						methodCalcInit();
						break;
					}

				} else if (calcChar[i] == '-') {
					if (isDouble(str)) {
						methodAddOperatorPM('-', str);
					} else {
						System.out.println("올바르지않은 계산식입니다.");
						methodCalcInit();
						break;
					}

				} else if (calcChar[i] == 'X') {
					if (isDouble(str)) {
						methodAddOperatorMDM('*', str);

					} else {
						System.out.println("올바르지않은 계산식입니다.");
						methodCalcInit();
						break;
					}

				} else if (calcChar[i] == '/') {
					if (isDouble(str)) {
						methodAddOperatorMDM('/', str);

					} else {
						System.out.println("올바르지않은 계산식입니다.");
						methodCalcInit();
						break;
					}

				} else if (calcChar[i] == '*') {
					if (isDouble(str)) {
						methodAddOperatorMDM('*', str);

					} else {
						System.out.println("올바르지않은 계산식입니다.");
						methodCalcInit();
						break;
					}

				} else if (calcChar[i] == '%') {
					if (isDouble(str)) {
						methodAddOperatorMDM('%', str);

					} else {
						System.out.println("올바르지않은 계산식입니다.");
						methodCalcInit();
						break;
					}
					// = 연산자를 만나면 저장한 숫자,연산자를 이용하여 게산을합니다. result에 결과를 저장후 반환합니다.
				} else if (calcChar[i] == '=') {
					// 마지막숫자뒤에는 =이외의 연산자가 오지않기 때문에 예외적으로 for문 내에서 처리합니다.
					Num[countNum] = Double.parseDouble(str);
					countNum += 1;
					str = "";
					/////////////////////////////////////////////////////////////////////

					priorityPM[priorityPMCount] = countSign;// 우선수위 연산을 위해 추가한 구문입니다.
					priorityPMCount += 1;
					////////////////////////////////////////////////////////////////////
					break;
					// 곱셈 나눗셈 나머지 우선연산

				} else {
					str += calcChar[i];
				}

			} // for문 끝
		}

		// 입력받은값을 숫자,연산자로 가공후 실제 계산과정 모델입니다.
		private double priorityCalculation() {
			// + - 연산자 순서에 따라서 for문을 돌림.
			if (priorityPMCount != 1) {
				for (int j = 0; j < priorityPMCount; j++) {
					for (int k = priorityPM[j]; k < priorityPM[j + 1]; k++) {
						if (Sign[priorityMDM[k]] == '*') {
							Num[priorityPM[j] + 1] *= Num[priorityMDM[k] + 1];
						}
						if (Sign[priorityMDM[k]] == 'X') {
							Num[priorityPM[j] + 1] *= Num[priorityMDM[k] + 1];
						}
						if (Sign[priorityMDM[k]] == '/') {
							Num[priorityPM[j] + 1] /= Num[priorityMDM[k] + 1];
						}
						if (Sign[priorityMDM[k]] == '%') {
							Num[priorityPM[j] + 1] %= Num[priorityMDM[k] + 1];
						}
					}
				}

				result = Num[0];
				for (int j = 0; j < priorityPMCount - 1; j++) {

					if (Sign[priorityPM[j]] == '+') {
						result += Num[priorityPM[j] + 1];
					}
					if (Sign[priorityPM[j]] == '-') {
						result -= Num[priorityPM[j] + 1];
					}
				}
			} else {
				result = Num[0];
				for (int j = 0; j < priorityMDMCount; j++) {
					if (Sign[priorityMDM[j]] == '*') {
						result *= Num[priorityMDM[j] + 1];
					}
					if (Sign[priorityMDM[j]] == 'X') {
						result *= Num[priorityMDM[j] + 1];
					}
					if (Sign[priorityMDM[j]] == '/') {
						result /= Num[priorityMDM[j] + 1];
					}
					if (Sign[priorityMDM[j]] == '%') {
						result %= Num[priorityMDM[j] + 1];
					}
				}
			}

			return result;
		}
		
		
		
		public void methodDotStar() {
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

		private static boolean isDouble(String s) {
			try {
				Double.parseDouble(s);
				return true;
			} catch (NumberFormatException e) {

				return false;
			}

		}

		public int getResultCount() {
			return resultCount;
		}

		public void setResultCount(int resultCount) {
			this.resultCount = resultCount;
		}
		
		
		
		
	}

