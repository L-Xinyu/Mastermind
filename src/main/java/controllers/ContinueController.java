package controllers;

import models.Game;
import models.State;
import utils.IO;

public class ContinueController extends OperationController {

	public ContinueController(Game game) {
		super(game);
	}

	@Override
	public void control() {
		assert this.getState() == State.FINAL;
		IO io = new IO();
		char answer;
		do {
			answer = io.readChar("Do you want to continue? (y/n): ");
		} while (answer != 'y' && answer != 'n');
		if (answer == 'y') {
			this.clear();
			this.setState(State.INITIAL);
		} else {
			this.setState(State.EXIT);
		}
	}

}
