import controllers.Logic;
import controllers.OperationController;

public class MasterMind {

	private Logic logic;

	public MasterMind() {
		logic = new Logic();
	}

	
	public void play() {
		OperationController controller;
		do {
			controller = logic.getController();
			if (controller != null){
				controller.control();
			}
		} while (controller != null);
	}

	public static void main(String[] args) {
		new MasterMind().play();
	}
	
	
	
}
