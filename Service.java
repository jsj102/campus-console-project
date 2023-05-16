
/**
 * 유저에게 서비스를 제공합니다.
 */

public class Service {
	private int choice = 0;
	private int dan = 0;
	private int num = 0;

	public run(Scanner sc) {
		View view = new View();
		int choice = 0;
		view.menu();
		try {
			choice = sc.nextInt();
			}
		catch(InputMisMatchException e) {
				System.out.println(e.getMessage);
			}
		if (choice == 1) {
			manager.gugudan();
			break;
		} else if (choice == 2) {
			manager.calculation(sc);
			break;
		} else if (choice == 3) {
			System.out.println("종료합니다.");
			break;
		} else if (choice == 4) {
			manager.methodDotStar();
		}
	}

	public Service(int choice) {
		this.setChoice(choice);
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}

}